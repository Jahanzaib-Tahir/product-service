package com.micorservice.store.productservice.repository;

import com.micorservice.store.productservice.dao.ProductCategory;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductCategoryRepository extends MongoRepository<ProductCategory, Long> {
}
