package com.micorservice.store.productservice.web.rest;

import com.micorservice.store.productservice.dto.ProductCategoryDto;
import com.micorservice.store.productservice.service.ProductCategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product-service/product-category")
public class ProductCategoryResource {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductCategoryResource.class);
    private final ProductCategoryService productCategoryService;

    public ProductCategoryResource(ProductCategoryService productCategoryService) {
        this.productCategoryService = productCategoryService;
    }

    @PostMapping
    public ResponseEntity<ProductCategoryDto> save(@RequestBody ProductCategoryDto productCategoryDto){
        LOGGER.info("request to save product category {}", productCategoryDto);
        productCategoryDto = productCategoryService.save(productCategoryDto);
        return new ResponseEntity<>(productCategoryDto, HttpStatus.CREATED);
    }




    @GetMapping("/find-all")
    public ResponseEntity<List<ProductCategoryDto>> findAll(){
        LOGGER.info("request to find all product categories : ");
        List<ProductCategoryDto> categoryDtoList = productCategoryService.findAll();
        return categoryDtoList.size() > 0 ?
                new ResponseEntity<>(categoryDtoList, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/parent/{parentId}")
    public ResponseEntity<List<ProductCategoryDto>> findByParentId(@PathVariable Long parentId){
        LOGGER.info("request to find product category by parent id : {}",parentId);
        List<ProductCategoryDto> categoryDtoList  = productCategoryService.findByParentId(parentId);
        return categoryDtoList.size() > 0 ?
                new ResponseEntity<>(categoryDtoList, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
