package com.micorservice.store.productservice.service.impl;

import com.micorservice.store.productservice.dto.CityDto;
import com.micorservice.store.productservice.repository.CityRepository;
import com.micorservice.store.productservice.service.CityService;
import com.micorservice.store.productservice.service.mapper.CityMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;
    private final CityMapper cityMapper;

    public CityServiceImpl(CityRepository cityRepository, CityMapper cityMapper) {
        this.cityRepository = cityRepository;
        this.cityMapper = cityMapper;
    }

    @Override
    public CityDto save(CityDto cityDto) {
        return null;
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
