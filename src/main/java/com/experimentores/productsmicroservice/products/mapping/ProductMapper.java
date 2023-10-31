package com.experimentores.productsmicroservice.products.mapping;

import com.crudjpa.mapping.IEntityMapper;
import com.experimentores.productsmicroservice.products.domain.model.Product;
import com.experimentores.productsmicroservice.products.resources.CreateProductResource;
import com.experimentores.productsmicroservice.products.resources.ProductResource;
import com.experimentores.productsmicroservice.products.resources.UpdateProductResource;
import com.experimentores.productsmicroservice.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductMapper implements IEntityMapper<Product, ProductResource, CreateProductResource, UpdateProductResource> {
    @Autowired
    EnhancedModelMapper mapper;

    @Override
    public Product fromCreateResourceToModel(CreateProductResource createProductResource) {
        return mapper.map(createProductResource, Product.class);
    }

    @Override
    public void fromCreateResourceToModel(CreateProductResource resource, Product product) {
        mapper.map(resource, product);
    }

    @Override
    public ProductResource fromModelToResource(Product product) {
        return mapper.map(product, ProductResource.class);
    }

    @Override
    public Product fromUpdateResourceToModel(UpdateProductResource updateProductResource) {
        return mapper.map(updateProductResource, Product.class);
    }

    @Override
    public void fromUpdateResourceToModel(UpdateProductResource resource, Product product) {
        mapper.map(resource, product);
    }
}
