package com.ecommerce.ecomapp.services;

import com.ecommerce.ecomapp.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service("DBProductService")
public class ProductServiceDatabase implements ProductService{
    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product getSingleProduct(Long id) {
        return null;
    }

    @Override
    public List<String> getAllCategories() {
        return null;
    }

    @Override
    public List<Product> getProductsOfCategory(String cname) {
        return null;
    }

    @Override
    public Product UpdateAProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Product deleteAProduct(Long id) {
        return null;
    }
}
