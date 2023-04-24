package com.micorservice.store.productservice.service.mapper;

import com.micorservice.store.productservice.dao.ProductCategory;
import com.micorservice.store.productservice.dto.ProductCategoryDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

@Mapper
public interface ProductCategoryMapper {

    @Mappings({
           @Mapping(source = "id", target = "id"),
           @Mapping(source = "name", target = "name"),
           @Mapping(source = "parent", target = "parent", qualifiedByName = "convertingParentForDto")
    })
    ProductCategoryDto toDto(ProductCategory productCategory);


    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "parent", target = "parent", qualifiedByName = "convertingParentForEntity")
    })
    ProductCategory toEntity(ProductCategoryDto productCategoryDto);




    @Named("convertingParentForDto")
    default Long convertingParentForDto(ProductCategory productCategory) {
        if(productCategory == null)
            return null;
        else
            return Long.valueOf(productCategory.getId());
    }


    @Named("convertingParentForEntity")
    default ProductCategory convertingParentForEntity(Long id) {
        if(id == null)
            return null;
        else
            return new ProductCategory().withId(id);

    }
}
