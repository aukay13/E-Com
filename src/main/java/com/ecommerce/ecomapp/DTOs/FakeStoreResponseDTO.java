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
public class FakeStoreResponseDTO {
    private long id;
    private String title;
    private String description;
    private double price;
    private String image;
    private String category;

    public Product toProduct(){

        Product product = new Product();
        product.setId(this.getId());
        product.setTitle(this.getTitle());
        product.setDescription(this.getDescription());
        product.setPrice(this.getPrice());
        product.setImageUrl(this.getImage());
        Category category1 = new Category();
        category1.setTitle(this.getCategory());
        product.setCategory(category1);

        return product;
    }
}
