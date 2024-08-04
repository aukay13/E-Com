package com.ecommerce.ecomapp.DTOs;

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
}
