package com.ecommerce.ecomapp.services;

import com.ecommerce.ecomapp.models.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceFakeStore implements ProductService{
    @Override
    public Product createProduct(Product product) {
        return null;
    }
}
