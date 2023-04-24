package com.micorservice.store.productservice.config;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.micorservice.store.productservice.dao.*;
import com.micorservice.store.productservice.repository.*;

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

    @ChangeSet(order = "4", id = "00004",author = "Jahanzaib")
    public void seedDataSupplier(AddressRepository addressRepository, CityRepository cityRepository){
        Optional<City> city = cityRepository.findById(1L);
        addressRepository.save(new Address(1L,"4377 Cathy Harbour", city.get()));
    }

    @ChangeSet(order = "5", id = "00005",author = "Jahanzaib")
    public void seedDataSupplier(SupplierRepository supplierRepository,AddressRepository addressRepository){
        Optional<Address> address = addressRepository.findById(1L);
        supplierRepository.save(new Supplier(7L,"ABC Supplier","abc@suuplier.com", "+123456789", address.get()));
    }

}
