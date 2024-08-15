package com.ecommerce.ecomapp.services;

import com.ecommerce.ecomapp.exceptions.ProductNotFoundException;
import com.ecommerce.ecomapp.models.Category;
import com.ecommerce.ecomapp.models.Product;

import java.util.List;

public interface ProductService {

    Product createProduct(Product product);
    List<Product> getAllProducts();

    Product getSingleProduct(Long id) throws ProductNotFoundException;

    List<Category> getAllCategories();

    List<Product> getProductsOfCategory(String cname);

    Product UpdateAProduct(Long id,Product product);
    Product deleteAProduct(Long id);

}
