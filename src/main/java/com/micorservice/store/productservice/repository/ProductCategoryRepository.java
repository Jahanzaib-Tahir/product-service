package com.micorservice.store.productservice.repository;

import com.micorservice.store.productservice.dao.ProductCategory;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductCategoryRepository extends MongoRepository<ProductCategory, Long> {
    List<ProductCategory> findProductCategoriesByParentId(Long id);
}
