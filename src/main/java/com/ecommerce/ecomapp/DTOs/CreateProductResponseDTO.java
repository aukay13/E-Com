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
public class CreateProductResponseDTO {
    private long id;
    private String title;
    private String detail;
    private double cost;
    private String image;
    private String categoryName;

    public static CreateProductResponseDTO from(Product product){
        CreateProductResponseDTO responseDTO = new CreateProductResponseDTO();
        responseDTO.id = product.getId();
        responseDTO.title = product.getTitle();;
        responseDTO.detail = product.getDescription();
        responseDTO.cost = product.getPrice();;
        responseDTO.image = product.getImageUrl();
        responseDTO.categoryName = product.getCategoryName();
        return responseDTO;
    }
}
