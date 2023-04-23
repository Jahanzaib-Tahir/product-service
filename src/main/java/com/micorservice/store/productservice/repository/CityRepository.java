package com.micorservice.store.productservice.repository;

import com.micorservice.store.productservice.dao.City;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CityRepository extends MongoRepository<City, Long> {
}
