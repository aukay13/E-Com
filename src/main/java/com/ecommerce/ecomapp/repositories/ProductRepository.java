package com.ecommerce.ecomapp.repositories;

import com.ecommerce.ecomapp.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    @Override
    Product save(Product p);

    @Override
    List<Product> findAll();

    @Override
    Optional<Product> findById(Long id);

    List<Product> findProductsByCategory_Id(Long categoryId);


}
