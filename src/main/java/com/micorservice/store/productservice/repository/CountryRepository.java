package com.micorservice.store.productservice.repository;

import com.micorservice.store.productservice.dao.Country;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CountryRepository extends MongoRepository<Country, Long> {
    Optional<Country> findByShortName(String shortName);
}
