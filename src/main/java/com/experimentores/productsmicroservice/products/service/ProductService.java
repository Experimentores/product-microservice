package com.experimentores.productsmicroservice.products.service;



import com.crudjpa.service.impl.CrudService;
import com.experimentores.productsmicroservice.products.domain.model.Product;
import com.experimentores.productsmicroservice.products.domain.model.ProductCategory;
import com.experimentores.productsmicroservice.products.domain.services.IProductService;
import com.experimentores.productsmicroservice.products.persistence.repository.IProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProductService extends CrudService<Product, Long> implements IProductService {

    private final IProductRepository productRepository;

    public ProductService(IProductRepository productRepository) {
        super(productRepository);
        this.productRepository = productRepository;
    }

    @Override
    public Optional<Product> findByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public List<Product> findProductsByCategory(ProductCategory productCategory) {
        return productRepository.findProductsByCategory(productCategory);
    }

    @Override
    public List<Product> findProductsByRating(Double productRating) {
        return productRepository.findProductsByRating(productRating);
    }
}
