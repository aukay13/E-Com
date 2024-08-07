package com.ecommerce.ecomapp.DTOs;

import lombok.Data;

@Data
public class ErrorResponseDTO {
    private String status;
    private String message;
}
