package com.ecommerce.ecomapp.repositories;

import com.ecommerce.ecomapp.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

    @Override
    Category save(Category c);

    Optional<Category> findByTitle(String title);

    @Override
    List<Category> findAll();
}
