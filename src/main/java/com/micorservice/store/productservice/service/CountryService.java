package com.micorservice.store.productservice.service;

import com.micorservice.store.productservice.dao.Country;
import com.micorservice.store.productservice.dto.CountryDto;

public interface CountryService {
    CountryDto save(Country country);
}
