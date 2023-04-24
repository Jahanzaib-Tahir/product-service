package com.micorservice.store.productservice.service.impl;

import com.micorservice.store.productservice.dao.ProductCategory;
import com.micorservice.store.productservice.dto.ProductCategoryDto;
import com.micorservice.store.productservice.repository.ProductCategoryRepository;
import com.micorservice.store.productservice.service.ProductCategoryService;
import com.micorservice.store.productservice.service.mapper.ProductCategoryMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductCategoryServiceImpl.class);
    private final ProductCategoryRepository productCategoryRepository;
    private final ProductCategoryMapper productCategoryMapper;

    public ProductCategoryServiceImpl(ProductCategoryRepository productCategoryRepository, ProductCategoryMapper productCategoryMapper) {
        this.productCategoryRepository = productCategoryRepository;
        this.productCategoryMapper = productCategoryMapper;
    }

    @Override
    public ProductCategoryDto save(ProductCategoryDto productCategoryDto) {
        ProductCategory productCategory = productCategoryMapper.toEntity(productCategoryDto);
        productCategory = productCategoryRepository.save(productCategory);
        return productCategoryMapper.toDto(productCategory);
    }

    @Override
    public List<ProductCategoryDto> findAll() {
        return productCategoryRepository.findAll()
                .stream()
                .map(productCategory -> productCategoryMapper.toDto(productCategory))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductCategoryDto> findByParentId(Long id) {
        return productCategoryRepository
                .findProductCategoriesByParentId(id)
                .stream()
                .map(productCategory -> productCategoryMapper.toDto(productCategory))
                .collect(Collectors.toList());
    }
}
