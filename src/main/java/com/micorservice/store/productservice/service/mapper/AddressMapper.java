package com.micorservice.store.productservice.service.mapper;

import com.micorservice.store.productservice.dao.Address;
import com.micorservice.store.productservice.dao.City;
import com.micorservice.store.productservice.dto.AddressDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

@Mapper
public interface AddressMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "fullAddress", target = "fullAddress"),
            @Mapping(source = "city", target = "city", qualifiedByName = "cityObjToName")
    })
    AddressDto toDto(Address address);

    @Named("cityObjToName")
    default String cityObjToName(City city) {
        if(city == null)
            return null;
        else
            return String.valueOf(city.getName());
    }
}
