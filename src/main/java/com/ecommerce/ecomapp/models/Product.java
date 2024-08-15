package com.ecommerce.ecomapp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product extends BaseModel{
    private String title;
    private String description;
    private Double price;
    private String imageUrl;
    private String categoryName;
    @ManyToOne
    private Category category;
}
