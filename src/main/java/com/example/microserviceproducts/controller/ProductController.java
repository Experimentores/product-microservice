package com.example.microserviceproducts.controller;


import com.example.microserviceproducts.exception.ValidationException;
import com.example.microserviceproducts.model.Product;
import com.example.microserviceproducts.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tripstore/v1")

public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // EndPoint: /api/tripstore/v1/products
    // Method: GET
    @Transactional(readOnly = true)
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    // EndPoint: /api/tripstore/v1/products/{id}
    // Method: GET
    @Transactional(readOnly = true)
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }

    // EndPoint: /api/tripstore/v1/products
    // Method: POST
    @Transactional
    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        validateProduct(product);
        existsProductByProductName(product);
        return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.CREATED);
    }

    // EndPoint: /api/tripstore/v1/products/{id}
    // Method: PUT
    @Transactional
    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody Product product) {
        validateProduct(product);
        return new ResponseEntity<>(productService.updateProduct(id, product), HttpStatus.OK);
    }

    // EndPoint: /api/tripstore/v1/products/{id}
    // Method: DELETE
    @DeleteMapping("/products/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>("Product with id: " + id + " was deleted", HttpStatus.OK);
    }

    public void validateProduct(Product product) {
        if (product.getProductName() == null || product.getProductName().trim().isEmpty()) {
            throw new ValidationException("Product name is required");
        }
        if (product.getProductDescription() == null || product.getProductDescription().trim().isEmpty()) {
            throw new ValidationException("Product description is required");
        }
        if (product.getProductPrice() == null || product.getProductPrice() <= 0) {
            throw new ValidationException("Product price is required");
        }
    }

    private void existsProductByProductName(Product product) {
        if (productService.getProductByProductName(product.getProductName()) != null) {
            throw new ValidationException("Product name already exists");
        }
    }
}
