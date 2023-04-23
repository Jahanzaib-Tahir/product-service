package com.micorservice.store.productservice.repository;

import com.micorservice.store.productservice.dao.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, Long> {
}
