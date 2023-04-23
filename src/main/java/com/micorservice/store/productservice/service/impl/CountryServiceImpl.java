package com.micorservice.store.productservice.service.impl;

import com.micorservice.store.productservice.dao.Country;
import com.micorservice.store.productservice.dto.CountryDto;
import com.micorservice.store.productservice.repository.CountryRepository;
import com.micorservice.store.productservice.service.CountryService;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public CountryDto save(Country country) {
        Country countryRes =  countryRepository.save(country);
        return new CountryDto(countryRes.getShortName());
    }
}
