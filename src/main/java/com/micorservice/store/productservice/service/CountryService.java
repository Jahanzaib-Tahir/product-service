package com.micorservice.store.productservice.service;

import com.micorservice.store.productservice.dao.Country;
import com.micorservice.store.productservice.dto.CountryDto;

import java.util.Optional;

public interface CountryService {
    CountryDto save(Country country);
    Optional<CountryDto> findByShortName(String shortName);
    Optional<CountryDto> findById(Long id);
}
