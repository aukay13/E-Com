package com.ecommerce.ecomapp.controllers;

import com.ecommerce.ecomapp.DTOs.CreateProductRequestDTO;
import com.ecommerce.ecomapp.DTOs.CreateProductResponseDTO;
import com.ecommerce.ecomapp.DTOs.GetAllProductsResponseDTO;
import com.ecommerce.ecomapp.models.Product;
import com.ecommerce.ecomapp.services.ProductService;
import com.ecommerce.ecomapp.services.ProductServiceFakeStore;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products/")
public class ProductController {

    private final ProductService productService;

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

    @GetMapping("")
    public @ResponseBody GetAllProductsResponseDTO getAllProducts(){

        List<Product> products = productService.getAllProducts();

        GetAllProductsResponseDTO responseDTO = new GetAllProductsResponseDTO();

        List<CreateProductResponseDTO> createProductResponseDTOS = new ArrayList<>();

        for (Product p: products){
            createProductResponseDTOS.add(CreateProductResponseDTO.from(p));
        }

        responseDTO.setCreateProductResponseDTOS(createProductResponseDTOS);

        return responseDTO;

    }
}