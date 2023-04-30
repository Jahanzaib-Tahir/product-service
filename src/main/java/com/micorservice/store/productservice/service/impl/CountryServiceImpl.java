package com.micorservice.store.productservice.service.impl;

import com.micorservice.store.productservice.dao.Country;
import com.micorservice.store.productservice.dto.CountryDto;
import com.micorservice.store.productservice.exception.RecordNotFound;
import com.micorservice.store.productservice.repository.CountryRepository;
import com.micorservice.store.productservice.service.CountryService;
import com.micorservice.store.productservice.service.mapper.CountryMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;
    private final CountryMapper countryMapper;

    public CountryServiceImpl(CountryRepository countryRepository, CountryMapper countryMapper) {
        this.countryRepository = countryRepository;
        this.countryMapper = countryMapper;
    }

    @Override
    public CountryDto save(Country country) {
        Country countryRes =  countryRepository.save(country);
        return new CountryDto(countryRes.getShortName());
    }

    @Override
    public Optional<CountryDto> findByShortName(String shortName) {
        return countryRepository
                .findByShortName(shortName)
                .map(country -> countryMapper.toDto(country));
    }


    @Override
    public Optional<CountryDto> findById(Long id){
        return countryRepository
                .findById(id)
                .map(country -> countryMapper.toDto(country));
    }
}
