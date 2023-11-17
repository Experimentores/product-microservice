package com.experimentores.productsmicroservice.products.service;

import com.crudjpa.service.impl.CrudService;
import com.experimentores.productsmicroservice.products.domain.model.ProductCategory;
import com.experimentores.productsmicroservice.products.domain.services.IProductCategoryService;
import com.experimentores.productsmicroservice.products.persistence.repository.IProductCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ProductCategoryService extends CrudService<ProductCategory, Long> implements IProductCategoryService {
    private final IProductCategoryRepository categoryRepository;
    public ProductCategoryService(IProductCategoryRepository categoryRepository) {
        super(categoryRepository);
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Optional<ProductCategory> findProductCategoryByName(String name) {
        return categoryRepository.findProductCategoryByName(name);
    }
}
