package com.experimentores.productsmicroservice.products.controller;

import com.crudjpa.controller.CrudController;
import com.crudjpa.exception.ResourceNotFoundException;
import com.experimentores.productsmicroservice.products.domain.model.Product;
import com.experimentores.productsmicroservice.products.domain.model.ProductCategory;
import com.experimentores.productsmicroservice.products.domain.services.IProductCategoryService;
import com.experimentores.productsmicroservice.products.domain.services.IProductService;
import com.experimentores.productsmicroservice.products.exception.InvalidCreateResourceException;
import com.experimentores.productsmicroservice.products.exception.InvalidUpdateResourceException;
import com.experimentores.productsmicroservice.products.mapping.ProductMapper;
import com.experimentores.productsmicroservice.products.resources.CreateProductResource;
import com.experimentores.productsmicroservice.products.resources.ProductResource;
import com.experimentores.productsmicroservice.products.resources.UpdateProductResource;
import jakarta.annotation.Nullable;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("${tripstore.products-service.path}")
public class ProductsController extends CrudController<Product, Long, ProductResource, CreateProductResource, UpdateProductResource> {

    private final IProductService productService;
    private final IProductCategoryService productCategoryService;

    public ProductsController(IProductService productService, ProductMapper mapper, IProductCategoryService productCategoryService) {
        super(productService, mapper);
        this.productService = productService;
        this.productCategoryService = productCategoryService;
    }
    @Override
    protected boolean isValidCreateResource(CreateProductResource createProductResource) {
        return true;
    }

    @Override
    protected boolean isValidUpdateResource(UpdateProductResource updateProductResource) {
        return true;
    }

    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductResource> getProductById(@PathVariable Long id) {
        return getById(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProductResource>> getAllProducts() {
        return getAll();
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductResource> createProduct(@Valid @RequestBody CreateProductResource resource, BindingResult result) {
        if(result.hasErrors()) {
            throw new InvalidCreateResourceException(getErrorsFromResult(result));
        }
        return insert(resource);
    }

    @PutMapping(value ="{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductResource> updateProduct(@PathVariable Long id, @Valid @RequestBody UpdateProductResource resource, BindingResult result) {
        if(result.hasErrors())
            throw new InvalidUpdateResourceException(getErrorsFromResult(result));
        return update(id, resource);
    }

    @DeleteMapping(value ="{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductResource> deleteProduct(@PathVariable Long id) {
        return delete(id);
    }

    @GetMapping(value = "search/{name}")
    public ResponseEntity<ProductResource> getByName(@PathVariable String name) {
        Optional<Product> product = productService.findByName(name);
        if(product.isEmpty())
            throw new ResourceNotFoundException("Product with name %s not exists".formatted(name));

        return ResponseEntity.ok(fromModelToResource(product.get()));
    }

    @GetMapping(value = "search/")
    public ResponseEntity<List<ProductResource>> searchProducts(@RequestParam(required = false) @Nullable Long categoryId, @RequestParam(required = false) Double rating) {
        HashSet<Product> products = new HashSet<>();

        if(categoryId != null) {
            Optional<ProductCategory> category = productCategoryService.getById(categoryId);
            category.ifPresent(productCategory -> products.addAll(productService.findProductsByCategory(productCategory)));
        }

        if(rating != null)
            products.addAll(productService.findProductsByRating(rating));

        List<ProductResource> filterProducts = products.stream()
                .filter(product -> (categoryId == null || product.getCategory().getId() == categoryId)
                        && (rating == null || product.getRating().equals(rating)))
                .map(this::fromModelToResource)
                .toList();

        return ResponseEntity.ok(filterProducts);
    }
}
