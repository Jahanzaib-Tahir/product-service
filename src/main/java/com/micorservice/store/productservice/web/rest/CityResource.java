package com.micorservice.store.productservice.web.rest;

import com.micorservice.store.productservice.dto.CityDto;
import com.micorservice.store.productservice.service.CityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product-service/city")
public class CityResource {
    private final CityService cityService;

    public CityResource(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/find-all")
    public ResponseEntity<List<CityDto>> findAll(){
        List<CityDto> cityDtoList = cityService.findAll();
        return cityDtoList.size() > 0 ?
                new ResponseEntity<>(cityDtoList, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

}
