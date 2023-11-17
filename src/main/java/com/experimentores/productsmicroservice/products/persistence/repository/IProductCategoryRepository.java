package com.experimentores.productsmicroservice.products.persistence.repository;

import com.experimentores.productsmicroservice.products.domain.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
    Optional<ProductCategory> findProductCategoryByName(String name);
}
