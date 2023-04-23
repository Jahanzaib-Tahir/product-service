package com.micorservice.store.productservice.service;

import com.micorservice.store.productservice.dto.ProductDto;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    ProductDto save(ProductDto productDto);
    Optional<ProductDto> findByName(String name);
    List<ProductDto> findBySupplier(String supplerName);
    List<ProductDto> findAllBySimilarName(String name);
}
