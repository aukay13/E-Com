package com.ecommerce.ecomapp.DTOs;

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
        return Product.builder()
                .id(this.getId())
                .title(this.getTitle())
                .description(this.getDescription())
                .price(this.getPrice())
                .imageUrl(this.getImage())
                .categoryName(this.getCategory())
                .build();
    }
}
