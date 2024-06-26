package com.micorservice.store.productservice.dao;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document(collection = "address")
public class Address {
    @Transient
    public static final String SEQUENCE_NAME = "address_sequence";
    private Long id;
    private String fullAddress;
    @DocumentReference(lazy = true)
    private City city;

    public Address() {
    }

    public Address(Long id, String fullAddress, City city) {
        this.id = id;
        this.fullAddress = fullAddress;
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", fullAddress='" + fullAddress + '\'' +
                ", city=" + city +
                '}';
    }
}
