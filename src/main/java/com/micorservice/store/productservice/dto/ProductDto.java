package com.micorservice.store.productservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class ProductDto {
    private String id;
    private String name;
    private String description;
    private double unitPrice;
    private String uuid;

    private ProductCategoryDto productCategoryDto;
    private SupplierDto supplierDto;

    public ProductDto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public ProductCategoryDto getProductCategoryDto() {
        return productCategoryDto;
    }

    public void setProductCategoryDto(ProductCategoryDto productCategoryDto) {
        this.productCategoryDto = productCategoryDto;
    }

    public SupplierDto getSupplierDto() {
        return supplierDto;
    }

    public void setSupplierDto(SupplierDto supplierDto) {
        this.supplierDto = supplierDto;
    }
}
