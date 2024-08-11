package com.ecommerce.ecomapp.controllers;

import com.ecommerce.ecomapp.DTOs.CreateProductRequestDTO;
import com.ecommerce.ecomapp.DTOs.GetProductsByCategoryResponseDTO;
import com.ecommerce.ecomapp.DTOs.ProductResponseDTO;
import com.ecommerce.ecomapp.DTOs.GetProductsResponseDTO;
import com.ecommerce.ecomapp.models.Product;
import com.ecommerce.ecomapp.services.ProductService;
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
    public @ResponseBody ProductResponseDTO createProduct(@RequestBody CreateProductRequestDTO createProductRequestDTO){

        Product product = productService.createProduct(createProductRequestDTO.toProduct());

        return ProductResponseDTO.builder()
                .id(product.getId())
                .detail(product.getDescription())
                .cost(product.getPrice())
                .title(product.getTitle())
                .image(product.getImageUrl())
                .build();
    }

    @GetMapping("")
    public @ResponseBody GetProductsResponseDTO getAllProducts(){

        List<Product> products = productService.getAllProducts();

        GetProductsResponseDTO responseDTO = new GetProductsResponseDTO();

        List<ProductResponseDTO> productResponseDTOS = new ArrayList<>();

        for (Product p: products){
            productResponseDTOS.add(ProductResponseDTO.from(p));
        }

        responseDTO.setProductResponseDTOS(productResponseDTOS);

        return responseDTO;

    }

    @GetMapping("{id}")
    public ProductResponseDTO getOneProduct(@PathVariable("id") Long id){

        Product product = productService.getSingleProduct(id);
        return ProductResponseDTO.from(product);
    }

    @GetMapping("categories")
    public List<String> getAllCategories(){
        return productService.getAllCategories();
    }

    @GetMapping("category/{cname}")
    public GetProductsByCategoryResponseDTO getProductsOfCategory(@PathVariable("cname")String cname){

        List<Product> productsOfCategory = productService.getProductsOfCategory(cname);
        GetProductsByCategoryResponseDTO getProductsByCategoryResponseDTO = new GetProductsByCategoryResponseDTO();

        List<ProductResponseDTO> productResponseDTOS = new ArrayList<>();
        for(Product p : productsOfCategory){
            productResponseDTOS.add(ProductResponseDTO.from(p));
        }

        getProductsByCategoryResponseDTO.setProductResponseDTOS(productResponseDTOS);
        return getProductsByCategoryResponseDTO;
    }

    @DeleteMapping("{id}")
    public ProductResponseDTO deleteAProduct(@PathVariable("id") Long id){
        Product deletedProduct = productService.deleteAProduct(id);
        return ProductResponseDTO.from(deletedProduct);
    }

    @PatchMapping("{id}")
    public ProductResponseDTO updateAProduct(@PathVariable("id")Long id,@RequestBody CreateProductRequestDTO createProductRequestDTO){
        Product updatedProduct = productService.UpdateAProduct(id,createProductRequestDTO.toProduct());
        return ProductResponseDTO.from(updatedProduct);
    }

}