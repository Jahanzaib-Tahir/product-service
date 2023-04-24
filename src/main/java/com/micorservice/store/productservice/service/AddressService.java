package com.micorservice.store.productservice.service;

import com.micorservice.store.productservice.dto.AddressDto;

import java.util.Optional;

public interface AddressService {
    Optional<AddressDto> findById(Long id);
}
