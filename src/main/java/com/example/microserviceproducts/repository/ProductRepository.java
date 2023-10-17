package com.example.microserviceproducts.repository;


import com.example.microserviceproducts.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product findByProductName(String productName);
    Product findByProductCategory(String productCategory);
    Product findByProductRating(Double productRating);
}
