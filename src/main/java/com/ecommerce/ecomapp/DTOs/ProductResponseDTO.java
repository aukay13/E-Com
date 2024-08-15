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
public class ProductResponseDTO {
    private long id;
    private String title;
    private String detail;
    private double cost;
    private String image;
    private String categoryName;

    public static ProductResponseDTO from(Product product){
        ProductResponseDTO responseDTO = new ProductResponseDTO();
        responseDTO.id = product.getId();
        responseDTO.title = product.getTitle();;
        responseDTO.detail = product.getDescription();
        responseDTO.cost = product.getPrice();;
        responseDTO.image = product.getImageUrl();
        responseDTO.categoryName = product.getCategory().getTitle();
        return responseDTO;
    }
}
