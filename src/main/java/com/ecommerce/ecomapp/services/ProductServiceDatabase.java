package com.ecommerce.ecomapp.services;

import com.ecommerce.ecomapp.exceptions.CategoryNotFoundException;
import com.ecommerce.ecomapp.exceptions.ProductNotFoundException;
import com.ecommerce.ecomapp.models.Category;
import com.ecommerce.ecomapp.models.Product;
import com.ecommerce.ecomapp.repositories.CategoryRepository;
import com.ecommerce.ecomapp.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("DBProductService")
public class ProductServiceDatabase implements ProductService{

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    ProductServiceDatabase(ProductRepository productRepository, CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    @Override
    public Product createProduct(Product product) {
        categoryCheckInProduct(product);
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> allProducts =  productRepository.findAll();

        return allProducts.stream().
                filter(product -> !product.isDeleted()).
                toList();
    }

    @Override
    public Product getSingleProduct(Long productId) throws ProductNotFoundException {
        Optional<Product> returnedProduct =  productRepository.findById(productId);
        if(returnedProduct.isEmpty() || returnedProduct.get().isDeleted()){
            throw new ProductNotFoundException(productId);
        }
        return returnedProduct.get();
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Product> getProductsOfCategory(String categoryName) {
        Optional<Category> category = categoryRepository.findByTitle(categoryName);
        Long categoryId = category.orElseThrow(()-> new CategoryNotFoundException(categoryName)).getId();

        return productRepository.findProductsByCategory_Id(categoryId).stream()
                .filter(product -> !product.isDeleted()).toList();
    }

    @Override
    public Product UpdateAProduct(Long productId, Product product) {
        Product returnedProduct = productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException(productId));

        if(product.getTitle()!=null){
            returnedProduct.setTitle(product.getTitle());
        }

        if(product.getPrice()!=null){
            returnedProduct.setPrice(product.getPrice());
        }

        if(product.getDescription()!=null){
            returnedProduct.setDescription(product.getDescription());
        }

        if(product.getImageUrl()!=null){
            returnedProduct.setImageUrl(product.getImageUrl());
        }

        if(product.getCategory()!=null){
            categoryCheckInProduct(returnedProduct);
        }

        return productRepository.save(returnedProduct);
    }

    @Override
    public Product deleteAProduct(Long productId) {
        Product returnedProduct = productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException(productId));

        returnedProduct.setDeleted(true);

        return productRepository.save(returnedProduct);
    }

    private void categoryCheckInProduct(Product product) {
        Category fromRequestCategory = product.getCategory();
        Optional<Category> dbCategory = categoryRepository.findByTitle(fromRequestCategory.getTitle());
        Category toBePutInProduct = dbCategory.orElseGet(() -> categoryRepository.save(product.getCategory()));

        product.setCategory(toBePutInProduct);
    }
}