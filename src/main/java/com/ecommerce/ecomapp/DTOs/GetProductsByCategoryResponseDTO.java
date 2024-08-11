package com.ecommerce.ecomapp.DTOs;

import lombok.Data;

import java.util.List;

@Data
public class GetProductsByCategoryResponseDTO {

    private List<ProductResponseDTO> productResponseDTOS;
}
