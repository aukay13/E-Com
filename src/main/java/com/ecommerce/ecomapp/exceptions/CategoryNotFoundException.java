package com.ecommerce.ecomapp.exceptions;


public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException(String message){
        super(STR."Category with \{message} not found");
    }

}