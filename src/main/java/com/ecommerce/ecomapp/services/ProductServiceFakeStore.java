package com.ecommerce.ecomapp.services;
import com.ecommerce.ecomapp.DTOs.FakeStoreRequestDTO;
import com.ecommerce.ecomapp.DTOs.FakeStoreResponseDTO;
import com.ecommerce.ecomapp.models.Product;
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
}
