package com.micorservice.store.productservice.repository;

import com.micorservice.store.productservice.dao.Address;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AddressRepository extends MongoRepository<Address,Long> {
}
