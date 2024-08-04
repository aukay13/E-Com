package com.ecommerce.ecomapp.services;
import com.ecommerce.ecomapp.DTOs.FakeStoreRequestDTO;
import com.ecommerce.ecomapp.DTOs.FakeStoreResponseDTO;
import com.ecommerce.ecomapp.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
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
}
