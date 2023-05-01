package com.micorservice.store.productservice.dao;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document(collection = "city")
public class City {
    @Transient
    public static final String SEQUENCE_NAME = "city_sequence";
    private Long id;
    private String name;
    private String shortName;
    @DocumentReference(lazy = true)
    private Country country;

    public City() {
    }

    public City(Long id, String name, String shortName, Country country) {
        this.id = id;
        this.name = name;
        this.shortName = shortName;
        this.country = country;
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

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", shortName='" + shortName + '\'' +
                ", country=" + country +
                '}';
    }
}
