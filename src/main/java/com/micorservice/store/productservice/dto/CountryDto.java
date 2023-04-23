package com.micorservice.store.productservice.dto;

public class CountryDto {
    private String id;
    private String shortName;

    public CountryDto() {
    }

    public CountryDto(String shortName) {
        this.shortName = shortName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public CountryDto withShortName(String shortName){
        this.shortName = shortName;
        return this;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
