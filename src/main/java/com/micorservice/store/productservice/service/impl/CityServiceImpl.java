package com.micorservice.store.productservice.service.impl;

import com.micorservice.store.productservice.dao.City;
import com.micorservice.store.productservice.dto.CityDto;
import com.micorservice.store.productservice.dto.CountryDto;
import com.micorservice.store.productservice.exception.RecordNotFound;
import com.micorservice.store.productservice.repository.CityRepository;
import com.micorservice.store.productservice.service.CityService;
import com.micorservice.store.productservice.service.CountryService;
import com.micorservice.store.productservice.service.mapper.CityMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;
    private final CityMapper cityMapper;

    private final CountryService countryService;

    public CityServiceImpl(CityRepository cityRepository, CityMapper cityMapper, CountryService countryService) {
        this.cityRepository = cityRepository;
        this.cityMapper = cityMapper;
        this.countryService = countryService;
    }

    @Override
    public CityDto save(CityDto cityDto) {
        Optional<CountryDto> country = countryService.findByShortName(cityDto.getCountryDto().getShortName());
        if(!country.isPresent())
            throw new RecordNotFound("no record found for country : "+ cityDto.getCountryDto().getShortName());
        City city = cityMapper.toEntity(cityDto);
        city = cityRepository.save(city);
        return cityMapper.toDto(city);
    }

    @Override
    public Optional<CityDto> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public List<CityDto> findByShortName(String shortName) {
        return null;
    }

    @Override
    public List<CityDto> findAllBySimilarName(String name) {
        return null;
    }

    @Override
    public List<CityDto> findAll() {
        return cityRepository.findAll()
                .stream()
                .map(city -> cityMapper.toDto(city))
                .collect(Collectors.toList());
    }
}
