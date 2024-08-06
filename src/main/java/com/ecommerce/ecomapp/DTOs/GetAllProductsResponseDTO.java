package com.ecommerce.ecomapp.DTOs;

import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
public class GetAllProductsResponseDTO {

    private List<CreateProductResponseDTO> createProductResponseDTOS;
}
