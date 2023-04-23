package com.micorservice.store.productservice.repository;

import com.micorservice.store.productservice.dao.Supplier;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends MongoRepository<Supplier, Long> {
}
