package com.micorservice.store.productservice.repository;

import com.micorservice.store.productservice.dao.Country;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CountryRepository extends MongoRepository<Country, Long> {
}
