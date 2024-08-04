package com.ecommerce.ecomapp.controllers;

import com.ecommerce.ecomapp.DTOs.CreateProductRequestDTO;
import com.ecommerce.ecomapp.DTOs.CreateProductResponseDTO;
import com.ecommerce.ecomapp.models.Product;
import com.ecommerce.ecomapp.services.ProductService;
import com.ecommerce.ecomapp.services.ProductServiceFakeStore;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products/")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }


    @PostMapping("")
    public @ResponseBody CreateProductResponseDTO createProduct(@RequestBody CreateProductRequestDTO createProductRequestDTO){
        Product product = productService.createProduct(createProductRequestDTO.toProduct());
        return CreateProductResponseDTO.builder()
                .id(product.getId())
                .detail(product.getDescription())
                .cost(product.getPrice())
                .title(product.getTitle())
                .image(product.getImageUrl())
                .build();
    }
}