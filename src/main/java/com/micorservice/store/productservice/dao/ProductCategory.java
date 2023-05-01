package com.micorservice.store.productservice.dao;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document(collection = "product_category")
public class ProductCategory {

    @Transient
    public static final String SEQUENCE_NAME = "product_category_sequence";
    private Long id;
    private String name;
    @DocumentReference
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

    public ProductCategory withId(Long id){
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductCategory withName(String name){
        this.name = name;
        return this;
    }

    public ProductCategory getParent() {
        return parent;
    }

    public void setParent(ProductCategory parent) {
        this.parent = parent;
    }

    public ProductCategory withParent(ProductCategory parent){
        this.parent = parent;
        return this;
    }

    @Override
    public String toString() {
        return "ProductCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
