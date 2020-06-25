package com.example.demo.dao;

import com.example.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findById(Long Id);

    List<Product> findBypNameLike(String name);

    List<Product> findByCategoryId(Long categoryId);

    Long deleteBypNameAndCategoryId(String name, Long Id);

    @Transactional
    Long deleteBypNameContains(String name);

    void deleteById(Long Id);
}


