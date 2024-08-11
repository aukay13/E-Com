package com.ecommerce.ecomapp.services;

import com.ecommerce.ecomapp.models.Product;

import java.util.List;

public interface ProductService {

    Product createProduct(Product product);
    List<Product> getAllProducts();

    Product getSingleProduct(Long id);

    List<String> getAllCategories();

    List<Product> getProductsOfCategory(String cname);

    Product UpdateAProduct(Long id,Product product);
    Product deleteAProduct(Long id);

}
