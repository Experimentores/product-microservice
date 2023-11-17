package com.experimentores.productsmicroservice.products.mapping;

import com.crudjpa.mapping.IEntityMapper;
import com.experimentores.productsmicroservice.products.domain.model.ProductCategory;
import com.experimentores.productsmicroservice.products.resources.CreateProductCategoryResource;
import com.experimentores.productsmicroservice.products.resources.ProductCategoryResource;
import com.experimentores.productsmicroservice.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductCategoryMapper implements IEntityMapper<ProductCategory, ProductCategoryResource, CreateProductCategoryResource, CreateProductCategoryResource> {
    @Autowired
    EnhancedModelMapper mapper;
    @Override
    public ProductCategory fromCreateResourceToModel(CreateProductCategoryResource createProductCategoryResource) {
        return mapper.map(createProductCategoryResource, ProductCategory.class);
    }

    @Override
    public void fromCreateResourceToModel(CreateProductCategoryResource createProductCategoryResource, ProductCategory productCategory) {
        mapper.map(createProductCategoryResource, productCategory);
    }

    @Override
    public ProductCategoryResource fromModelToResource(ProductCategory productCategory) {
        return mapper.map(productCategory, ProductCategoryResource.class);
    }

    @Override
    public ProductCategory fromUpdateResourceToModel(CreateProductCategoryResource createProductCategoryResource) {
        return mapper.map(createProductCategoryResource, ProductCategory.class);
    }

    @Override
    public void fromUpdateResourceToModel(CreateProductCategoryResource createProductCategoryResource, ProductCategory productCategory) {
        mapper.map(createProductCategoryResource, productCategory);
    }
}
