package com.experimentores.productsmicroservice.products.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("behaviourMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public ProductMapper tripMapper() {
        return new ProductMapper();
    }

    @Bean
    public ProductCategoryMapper productCategoryMapper() { return new ProductCategoryMapper(); }
}
