package com.micorservice.store.productservice.service.impl;

import com.micorservice.store.productservice.dto.ProductDto;
import com.micorservice.store.productservice.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public ProductDto save(ProductDto productDto) {
        return null;
    }

    @Override
    public Optional<ProductDto> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public List<ProductDto> findBySupplier(String supplerName) {
        return null;
    }

    @Override
    public List<ProductDto> findAllBySimilarName(String name) {
        return null;
    }
}
