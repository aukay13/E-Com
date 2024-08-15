package com.ecommerce.ecomapp.controllers;

import com.ecommerce.ecomapp.DTOs.CreateProductRequestDTO;
import com.ecommerce.ecomapp.DTOs.GetProductsByCategoryResponseDTO;
import com.ecommerce.ecomapp.DTOs.ProductResponseDTO;
import com.ecommerce.ecomapp.DTOs.GetProductsResponseDTO;
import com.ecommerce.ecomapp.models.Category;
import com.ecommerce.ecomapp.models.Product;
import com.ecommerce.ecomapp.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products/")
public class ProductController {

    private final ProductService productService;

    public ProductController(@Qualifier("DBProductService") ProductService productService){
        this.productService = productService;
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody ProductResponseDTO createProduct(@RequestBody CreateProductRequestDTO createProductRequestDTO){

        Product product = productService.createProduct(createProductRequestDTO.toProduct());

        return ProductResponseDTO.builder()
                .id(product.getId())
                .detail(product.getDescription())
                .cost(product.getPrice())
                .title(product.getTitle())
                .image(product.getImageUrl())
                .categoryName(product.getCategory().getTitle())
                .build();
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
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
    @ResponseStatus(HttpStatus.OK)
    public ProductResponseDTO getOneProduct(@PathVariable("id") Long id){

        Product product = productService.getSingleProduct(id);
        return ProductResponseDTO.from(product);
    }

    @GetMapping("category/{cname}")
    @ResponseStatus(HttpStatus.OK)
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
    @ResponseStatus(HttpStatus.OK)
    public ProductResponseDTO deleteAProduct(@PathVariable("id") Long id){
        Product deletedProduct = productService.deleteAProduct(id);
        return ProductResponseDTO.from(deletedProduct);
    }

    @PatchMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductResponseDTO updateAProduct(@PathVariable("id")Long id,@RequestBody CreateProductRequestDTO createProductRequestDTO){
        Product updatedProduct = productService.UpdateAProduct(id,createProductRequestDTO.toProduct());
        return ProductResponseDTO.from(updatedProduct);
    }

}