package com.experimentores.productsmicroservice.products.controller;

import com.crudjpa.controller.CrudController;
import com.experimentores.productsmicroservice.products.domain.model.ProductCategory;
import com.experimentores.productsmicroservice.products.domain.services.IProductCategoryService;
import com.experimentores.productsmicroservice.products.exception.InvalidCreateResourceException;
import com.experimentores.productsmicroservice.products.exception.ValidationException;
import com.experimentores.productsmicroservice.products.mapping.ProductCategoryMapper;
import com.experimentores.productsmicroservice.products.resources.CreateProductCategoryResource;
import com.experimentores.productsmicroservice.products.resources.ProductCategoryResource;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("${tripstore.products-service.category-path}")
public class ProductCategoriesController extends CrudController<ProductCategory, Long,
        ProductCategoryResource, CreateProductCategoryResource, CreateProductCategoryResource> {

    private final IProductCategoryService categoryService;

    public ProductCategoriesController(IProductCategoryService categoryService, ProductCategoryMapper mapper) {
        super(categoryService, mapper);
        this.categoryService = categoryService;
    }

    public void validateIfAlreadyExists(String name) {
        Optional<ProductCategory> category = categoryService.findProductCategoryByName(name);
        if(category.isPresent())
            throw new ValidationException("A category with this name already exists");
    }

    @Override
    protected boolean isValidCreateResource(CreateProductCategoryResource createProductCategoryResource) {
        validateIfAlreadyExists(createProductCategoryResource.getName());
        return true;
    }

    @Override
    protected boolean isValidUpdateResource(CreateProductCategoryResource createProductCategoryResource) {
        validateIfAlreadyExists(createProductCategoryResource.getName());
        return true;
    }


    @GetMapping
    ResponseEntity<List<ProductCategoryResource>> findAllCategories() {
        return getAll();
    }

    @GetMapping(value = "{id}")
    ResponseEntity<ProductCategoryResource> findCategoryById(@PathVariable Long id) {
        return getById(id);
    }

    @PostMapping
    ResponseEntity<ProductCategoryResource> createCategory(@Valid @RequestBody CreateProductCategoryResource resource, BindingResult result) {
        if(result.hasErrors())
            throw new InvalidCreateResourceException(getErrorsFromResult(result));

        return insert(resource);
    }

    @DeleteMapping(value = "{id}")
    ResponseEntity<ProductCategoryResource> deleteCategory(@PathVariable Long id) {
        return delete(id);
    }
}
