package com.ecommerce.ecomapp.DTOs;

import com.ecommerce.ecomapp.models.Category;
import lombok.Data;

import java.net.CacheRequest;

@Data
public class GetAllCategoryResponseDTO {
    private Long id;
    private String title;
    private String description;

    public static GetAllCategoryResponseDTO getAllCategoryResponseDTO(Category c){
        GetAllCategoryResponseDTO responseDTO = new GetAllCategoryResponseDTO();
        responseDTO.setId(c.getId());
        responseDTO.setTitle(c.getTitle());
        responseDTO.setDescription(c.getDescription());
        return responseDTO;
    }
}
