package com.ecommerce.ecomapp.controllers;

import com.ecommerce.ecomapp.DTOs.GetAllCategoryResponseDTO;
import com.ecommerce.ecomapp.models.Category;
import com.ecommerce.ecomapp.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/category/")
public class CategoryController {

    private final ProductService productService;

    public CategoryController(@Qualifier("DBProductService") ProductService productService){
        this.productService = productService;
    }

    @GetMapping("all")
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllCategoryResponseDTO> getAllCategories(){
        List<Category> allCategories = productService.getAllCategories();
        List<GetAllCategoryResponseDTO> returnValue = new ArrayList<>();
        for (Category c : allCategories){
            returnValue.add(GetAllCategoryResponseDTO.getAllCategoryResponseDTO(c));
        }
        return returnValue;
    }


//    @GetMapping("all")
//    public List<Category> getAllCategories(){
//        return productService.getAllCategories();
//    }
}
