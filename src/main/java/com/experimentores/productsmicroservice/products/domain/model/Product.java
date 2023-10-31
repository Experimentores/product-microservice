package com.experimentores.productsmicroservice.products.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "description", nullable = false, length = 500)
    private String description;

    @Column(name = "product_price", nullable = false, length = 10)
    private Double price;

    @Column(name = "image_url", nullable = false, length = 250)
    private String imageUrl;

    @Column(name = "rating", nullable = false, length = 10)
    private Double rating;

    @Column(name = "category", nullable = false, length = 50)
    private String category;
}
