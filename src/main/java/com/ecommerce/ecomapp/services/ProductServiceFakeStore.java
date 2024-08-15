package com.ecommerce.ecomapp.services;
import com.ecommerce.ecomapp.DTOs.FakeStoreRequestDTO;
import com.ecommerce.ecomapp.DTOs.FakeStoreResponseDTO;
import com.ecommerce.ecomapp.models.Category;
import com.ecommerce.ecomapp.models.Product;
import com.sun.jdi.event.StepEvent;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@Service("FakeStoreProductService")
public class ProductServiceFakeStore implements ProductService{

    private final RestTemplate restTemplate;

    ProductServiceFakeStore(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public Product createProduct(Product product) {
        FakeStoreRequestDTO request = FakeStoreRequestDTO.builder()
                .title(product.getTitle())
                .price(product.getPrice())
                .description(product.getDescription())
                .image(product.getImageUrl())
                .category(product.getCategoryName())
                .build();

        FakeStoreResponseDTO fakeStoreResponseDTO = restTemplate.postForObject(
                "https://fakestoreapi.com/products",
                request,
                FakeStoreResponseDTO.class
        );

        return fakeStoreResponseDTO.toProduct();

    }

    @Override
    public List<Product> getAllProducts(){
        FakeStoreResponseDTO[] response = restTemplate.getForObject(
                "https://fakestoreapi.com/products",
                FakeStoreResponseDTO[].class
        );

//        List<FakeStoreResponseDTO> fakeStoreResponseDTOS = Stream.of(response).toList();

        List<Product> products = new ArrayList<>();

        for(FakeStoreResponseDTO fakeStoreResponseDTO: response){
            products.add(fakeStoreResponseDTO.toProduct());
        }

        return products;
    }

    @Override
    public Product getSingleProduct(Long id) {

        FakeStoreResponseDTO fakeStoreResponseDTO = restTemplate.getForObject(
                STR."https://fakestoreapi.com/products/\{id}",
                FakeStoreResponseDTO.class
        );

        return fakeStoreResponseDTO.toProduct();
    }

    @Override
    public List<Category> getAllCategories() {
        String[] categories = restTemplate.getForObject(
                "https://fakestoreapi.com/products/categories",
                String[].class

        );

//        return Stream.of(categories).toList();
        return null;
    }

    @Override
    public List<Product> getProductsOfCategory(String cname) {
        FakeStoreResponseDTO[] response = restTemplate.getForObject(
                STR."https://fakestoreapi.com/products/category/\{cname}",
                FakeStoreResponseDTO[].class
        );

//        List<FakeStoreResponseDTO> fakeStoreResponseDTOS = Stream.of(response).toList();

        List<Product> products = new ArrayList<>();

        for(FakeStoreResponseDTO fakeStoreResponseDTO: response){
            products.add(fakeStoreResponseDTO.toProduct());
        }

        return products;
    }

    @Override
    public Product UpdateAProduct(Long id, Product product) {

        FakeStoreRequestDTO request = FakeStoreRequestDTO.builder()
                .title(product.getTitle())
                .price(product.getPrice())
                .description(product.getDescription())
                .image(product.getImageUrl())
                .category(product.getCategoryName())
                .build();

//        FakeStoreResponseDTO fakeStoreResponseDTO = restTemplate.patchForObject(
//                STR."https://fakestoreapi.com/products/\{id}",
//                request,
//                FakeStoreResponseDTO.class,
//                id
//        );

        HttpEntity<FakeStoreRequestDTO> fakeStoreRequestDTOHttpEntity = new HttpEntity<>(request);

        ResponseEntity<FakeStoreResponseDTO> fakeStoreResponseDTOResponseEntity = restTemplate.exchange(
                STR."https://fakestoreapi.com/products/\{id}",
                HttpMethod.PATCH,
                fakeStoreRequestDTOHttpEntity,
                FakeStoreResponseDTO.class
        );

        return fakeStoreResponseDTOResponseEntity.getBody().toProduct();
    }

    @Override
    public Product deleteAProduct(Long id) {
        FakeStoreResponseDTO fakeStoreResponseDTO = restTemplate.getForObject(
                STR."https://fakestoreapi.com/products/\{id}",
                FakeStoreResponseDTO.class
        );

        return fakeStoreResponseDTO.toProduct();
    }


}
