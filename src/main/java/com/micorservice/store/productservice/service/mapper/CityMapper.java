package com.micorservice.store.productservice.service.mapper;

import com.micorservice.store.productservice.dao.City;
import com.micorservice.store.productservice.dto.CityDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface CityMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "country", target = "countryDto")
    })
    CityDto toDto(City city);
}
