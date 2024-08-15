package com.ecommerce.ecomapp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Category extends BaseModel{

    private String title;
    private String description;
    @OneToMany(mappedBy = "category",fetch = FetchType.LAZY)
    private List<Product> featuredProducts;

}
