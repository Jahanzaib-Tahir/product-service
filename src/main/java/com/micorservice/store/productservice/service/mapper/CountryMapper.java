package com.micorservice.store.productservice.service.mapper;

import com.micorservice.store.productservice.dao.Country;
import com.micorservice.store.productservice.dto.CountryDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface CountryMapper {
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "shortName", target = "shortName")
    })
    CountryDto toDto(Country country);
}
