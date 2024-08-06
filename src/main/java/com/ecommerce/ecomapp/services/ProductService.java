package com.ecommerce.ecomapp.services;

import com.ecommerce.ecomapp.models.Product;

import java.util.List;

public interface ProductService {

    Product createProduct(Product product);
    List<Product> getAllProducts();

}
