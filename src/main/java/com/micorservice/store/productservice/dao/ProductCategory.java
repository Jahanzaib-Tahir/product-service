package com.micorservice.store.productservice.dao;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document(collection = "product_category")
public class ProductCategory {
    private Long id;
    private String name;
    @DocumentReference(lazy = true)
    private ProductCategory parent;

    public ProductCategory() {
    }

    public ProductCategory(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public ProductCategory(Long id, String name, ProductCategory parent) {
        this.id = id;
        this.name = name;
        this.parent = parent;
    }

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

    @Override
    public String toString() {
        return "ProductCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
