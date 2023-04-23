package com.micorservice.store.productservice;

import com.github.cloudyrock.spring.v5.EnableMongock;
import com.micorservice.store.productservice.service.CountryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableMongock
public class ProductServiceApplication{


	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

}
