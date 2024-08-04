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
public class CreateProductRequestDTO {
    private String title;
    private String detail;
    private double cost;
    private String image;

    public Product toProduct(){
        return Product.builder()
                .title(this.title)
                .price(this.cost)
                .description(this.detail)
                .imageUrl(this.image)
                .build();
    }
}
