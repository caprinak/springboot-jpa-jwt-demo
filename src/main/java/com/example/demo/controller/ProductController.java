package com.example.demo.controller;

import com.example.demo.dao.ProductRepository;
import com.example.demo.entity.Product;
import com.example.demo.exception.ProductNotFoundException;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
public class ProductController {

    private final ProductRepository productRepo;
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    public ProductController(@Qualifier("productRepository") ProductRepository repo) {
        this.productRepo = repo;
    }
    @GetMapping("/products")
    List<Product> getAll() {
        return productRepo.findAll();
    }

    @GetMapping("/product/{id}")
    Product getSpecificProduct(@PathVariable Long id) {
             return productRepo.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id)) ;
    }

    @GetMapping("/category/products/{categoryId}")
    List<Product> getProductsInCategory(@PathVariable Long categoryId) {
        return (List<Product>) productRepo.findByCategoryId(categoryId);
    }

    @GetMapping("product/name/{part}")
    List<Product> getProductsWithNameLike(@PathVariable String part) {
        return productRepo.findBypNameLike('%' + part + '%');
    }

    @DeleteMapping("product/del/name/{name}")
    Long deleteProductsByName(@PathVariable String name) {
        logger.error ("delete User Name: {}", name);

        return productRepo.deleteBypNameContains(name);
    }

    @DeleteMapping("product/id/{id}")
    void deleteProductById(@PathVariable Long id) {
        productRepo.deleteById(id);
    }

    @PostMapping("/product")
    Product createNewProduct(@RequestBody Product newProduct) {
        return productRepo.save(newProduct);

    }
}
