package com.micorservice.store.productservice.config;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.micorservice.store.productservice.dao.*;
import com.micorservice.store.productservice.repository.*;
import com.micorservice.store.productservice.service.SequenceGeneratorService;

import java.util.*;

@ChangeLog
public class DatabaseChangeLog {
    @ChangeSet(order = "1", id = "00001",author = "Jahanzaib")
    public void seedDataCountry(CountryRepository countryRepository, SequenceGeneratorService sequenceGeneratorService){
        List<Country> countries = Arrays.asList(
                new Country(sequenceGeneratorService.generateSequence(Country.SEQUENCE_NAME),"Pakistan","PAK"),
                new Country(sequenceGeneratorService.generateSequence(Country.SEQUENCE_NAME),"China","CN"));
        countryRepository.insert(countries);
    }
    @ChangeSet(order = "2", id = "00002",author = "Jahanzaib")
    public void seedDataCity(CountryRepository countryRepository, CityRepository cityRepository, SequenceGeneratorService sequenceGeneratorService){
        Optional<Country> pakistan = countryRepository.findById(1L);
        List<City> cities = Arrays.asList(
                new City(sequenceGeneratorService.generateSequence(City.SEQUENCE_NAME),"Lahore","LHR",pakistan.get()),
                new City(sequenceGeneratorService.generateSequence(City.SEQUENCE_NAME),"Karachi","KHI",pakistan.get()),
                new City(sequenceGeneratorService.generateSequence(City.SEQUENCE_NAME),"Islamabad","ISL",pakistan.get()));
        cityRepository.saveAll(cities);
    }

    @ChangeSet(order = "3", id = "00003",author = "Jahanzaib")
    public void seedDataProductCategory(ProductCategoryRepository productCategoryRepository, SequenceGeneratorService sequenceGeneratorService){
        List<ProductCategory> parentProductCategory = Arrays.asList(
        new ProductCategory(sequenceGeneratorService.generateSequence(ProductCategory.SEQUENCE_NAME),"Electronics & Gadgets"),
        new ProductCategory(sequenceGeneratorService.generateSequence(ProductCategory.SEQUENCE_NAME),"Clothing & Apparel"));
        productCategoryRepository.saveAll(parentProductCategory);
        Optional<ProductCategory> productCategory = productCategoryRepository.findById(1L);

        List<ProductCategory> productCategories = Arrays.asList(
                new ProductCategory(sequenceGeneratorService.generateSequence(ProductCategory.SEQUENCE_NAME),"Mobiles", productCategory.get()),
                new ProductCategory(sequenceGeneratorService.generateSequence(ProductCategory.SEQUENCE_NAME),"Laptops", productCategory.get()),
                new ProductCategory(sequenceGeneratorService.generateSequence(ProductCategory.SEQUENCE_NAME),"Headphones", productCategory.get()));
        productCategoryRepository.saveAll(productCategories);
    }

    @ChangeSet(order = "4", id = "00004",author = "Jahanzaib")
    public void seedDataSupplier(AddressRepository addressRepository, CityRepository cityRepository, SequenceGeneratorService sequenceGeneratorService){
        Optional<City> city = cityRepository.findById(3L);
        addressRepository.save(new Address(sequenceGeneratorService.generateSequence(Address.SEQUENCE_NAME),"4377 Cathy Harbour", city.get()));
    }

    @ChangeSet(order = "5", id = "00005",author = "Jahanzaib")
    public void seedDataSupplier(SupplierRepository supplierRepository,AddressRepository addressRepository, SequenceGeneratorService sequenceGeneratorService){
        Optional<Address> address = addressRepository.findById(1L);
        supplierRepository.save(new Supplier(sequenceGeneratorService.generateSequence(Address.SEQUENCE_NAME),"ABC Supplier","abc@suuplier.com", "+123456789", address.get()));
    }

}
