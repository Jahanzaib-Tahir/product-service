package com.micorservice.store.productservice.service;

import com.micorservice.store.productservice.dto.CityDto;

import java.util.List;
import java.util.Optional;

public interface CityService {
    CityDto save(CityDto cityDto);
    Optional<CityDto> findByName(String name);
    List<CityDto> findByShortName(String shortName);
    List<CityDto> findAllBySimilarName(String name);
    List<CityDto> findAll();
}
