package com.ecommerce.ecomapp.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FakeStoreRequestDTO {
    private String title;
    private String description;
    private double price;
    private String image;
    private String category;
}