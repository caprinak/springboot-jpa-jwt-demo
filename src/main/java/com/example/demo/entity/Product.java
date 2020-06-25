package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name="PRODUCT")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="PRODUCT_ID", nullable = false)
    private Long id;

    @Column(name="PRODUCT_NAME", length = 64, nullable = false)
    private String pName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="category_id")
    private Category category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getpName() {
        return pName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if(!(o instanceof  Product)) return  false;
//        return id != null && id.equals(((Product) o).getId());
//    }
//
//    public int hashCode() {
//        return 31;
//    }
}
