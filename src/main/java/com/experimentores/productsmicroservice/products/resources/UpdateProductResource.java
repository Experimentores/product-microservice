package com.experimentores.productsmicroservice.products.resources;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProductResource {
    @NotBlank
    @Length(max = 50)
    private String name;

    @NotBlank
    @Length(max = 500)
    private String description;

    @Positive(message = "Must be a valid price")
    private Double price;

    @NotBlank
    @Length(max = 250)
    private String imageUrl;

    @NotNull
    private Double rating;
}
