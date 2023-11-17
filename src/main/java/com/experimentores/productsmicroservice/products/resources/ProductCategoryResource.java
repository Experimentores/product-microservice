package com.experimentores.productsmicroservice.products.resources;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductCategoryResource {
    private Long id;
    private String name;
}
