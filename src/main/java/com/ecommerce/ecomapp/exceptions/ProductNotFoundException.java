package com.ecommerce.ecomapp.exceptions;

public class ProductNotFoundException extends RuntimeException{

    public ProductNotFoundException(Long productId){
        super(STR."Product with ID \{productId} not found.");
    }
}
