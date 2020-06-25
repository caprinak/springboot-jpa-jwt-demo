package com.example.demo.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CATEGORY")
public class Category{
    @Id
    @GeneratedValue
    @Column(name="ID", nullable = false)
    private Long id;

    @Column(name = "CATEGORY_NAME")
    private String name;

    @OneToMany(
        mappedBy = "category",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<Product> products = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public List<Product> getProducts() {
//        return products;
//    }

//    public void setProducts(List<Product> products) {
//        this.products = products;
//    }
//
//    public void addProduct(Product product){
//        products.add(product);
//        product.setCategory(this);
//    }
//    public void removeProduct(Product product) {
//        products.remove(product);
//        product.setCategory(null);
//    }
}
