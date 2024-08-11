package com.ecommerce.ecomapp.models;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Category extends BaseModel{

    private String title;
    private String description;
    private List<Product> featuredProducts;

}
