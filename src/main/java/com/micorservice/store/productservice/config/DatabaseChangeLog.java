package com.micorservice.store.productservice.config;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.micorservice.store.productservice.dao.City;
import com.micorservice.store.productservice.dao.Country;
import com.micorservice.store.productservice.dao.ProductCategory;
import com.micorservice.store.productservice.repository.CityRepository;
import com.micorservice.store.productservice.repository.CountryRepository;
import com.micorservice.store.productservice.repository.ProductCategoryRepository;

import java.util.*;

@ChangeLog
public class DatabaseChangeLog {
    @ChangeSet(order = "1", id = "00001",author = "Jahanzaib")
    public void seedDataCountry(CountryRepository countryRepository){
        List<Country> countries = Arrays.asList(
                new Country(1L,"Pakistan","PAK"),
                new Country(2L,"China","CN"));
        countryRepository.insert(countries);
    }
    @ChangeSet(order = "2", id = "00002",author = "Jahanzaib")
    public void seedDataCity(CountryRepository countryRepository, CityRepository cityRepository){
        Optional<Country> pakistan = countryRepository.findById(1L);
        List<City> cities = Arrays.asList(
                new City(1L,"Lahore","LHR",pakistan.get()),
                new City(2L,"Karachi","KHI",pakistan.get()),
                new City(3L,"Islamabad","ISL",pakistan.get()));
        cityRepository.saveAll(cities);
    }

    @ChangeSet(order = "3", id = "00003",author = "Jahanzaib")
    public void seedDataProductCategory(ProductCategoryRepository productCategoryRepository){
        List<ProductCategory> parentProductCategory = Arrays.asList(
        new ProductCategory(1L,"Electronics & Gadgets"),
        new ProductCategory(2L,"Clothing & Apparel"));
        productCategoryRepository.saveAll(parentProductCategory);
        Optional<ProductCategory> productCategory = productCategoryRepository.findById(1L);

        List<ProductCategory> productCategories = Arrays.asList(
                new ProductCategory(3L,"Mobiles", productCategory.get()),
                new ProductCategory(4L,"Laptops", productCategory.get()),
                new ProductCategory(5L,"Headphones", productCategory.get()));
        productCategoryRepository.saveAll(productCategories);
    }

}
