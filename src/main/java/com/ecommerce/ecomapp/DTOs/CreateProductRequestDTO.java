package com.ecommerce.ecomapp.DTOs;

import com.ecommerce.ecomapp.models.Category;
import com.ecommerce.ecomapp.models.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductRequestDTO {
    private String title;
    private String detail;
    private double cost;
    private String image;
    private String categoryName;

    public Product toProduct(){

        Category category = new Category();
        category.setTitle(this.categoryName);

        return Product.builder()
                .title(this.title)
                .price(this.cost)
                .description(this.detail)
                .imageUrl(this.image)
                .category(category)
                .build();
    }
}
