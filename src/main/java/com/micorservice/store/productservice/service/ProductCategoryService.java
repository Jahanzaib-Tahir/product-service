package com.micorservice.store.productservice.service;

import com.micorservice.store.productservice.dto.ProductCategoryDto;

import java.util.List;

public interface ProductCategoryService {
    ProductCategoryDto save(ProductCategoryDto productCategoryDto);
    List<ProductCategoryDto> findAll();
    List<ProductCategoryDto> findByParentId(Long id);
}
