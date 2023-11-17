package com.experimentores.productsmicroservice.products.resources;

import com.experimentores.productsmicroservice.products.domain.model.ProductCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResource {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String imageUrl;
    private Double rating;
    private ProductCategory category;
}
