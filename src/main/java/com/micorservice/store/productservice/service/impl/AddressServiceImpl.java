package com.micorservice.store.productservice.service.impl;

import com.micorservice.store.productservice.dto.AddressDto;
import com.micorservice.store.productservice.repository.AddressRepository;
import com.micorservice.store.productservice.service.AddressService;
import com.micorservice.store.productservice.service.mapper.AddressMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AddressServiceImpl.class);
    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    public AddressServiceImpl(AddressRepository addressRepository, AddressMapper addressMapper) {
        this.addressRepository = addressRepository;
        this.addressMapper = addressMapper;
    }

    @Override
    public Optional<AddressDto> findById(Long id) {
        LOGGER.info("request to get address by id : {}",id);
        return addressRepository.findById(id).map(address -> addressMapper.toDto(address));
    }
}
