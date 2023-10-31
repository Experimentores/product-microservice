package com.experimentores.productsmicroservice.products.domain.services;

import com.crudjpa.service.ICrudService;
import com.experimentores.productsmicroservice.products.domain.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService extends ICrudService<Product, Long> {
    Optional<Product> findByName(String name);
    List<Product> findProductsByCategory(String productCategory);
    List<Product> findProductsByRating(Double productRating);
}
