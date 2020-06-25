package com.example.demo.dao;

import com.example.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepositoryCustom extends ProductRepository {
    Optional<Product> findById(Long Id);

    List<Product> findBypNameLike(String name);

    List<Product> findByCategoryId(Long categoryId);

    Long deleteBypNameAndCategoryId(String name, Long Id);

    Long deleteBypName(String name);

    void deleteById(Long Id);
}


