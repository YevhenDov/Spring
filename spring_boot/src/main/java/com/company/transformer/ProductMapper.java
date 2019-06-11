package com.company.transformer;

import com.company.controller.dto.Product;
import com.company.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface ProductMapper {
    ProductEntity mapProductToProductEntity(Product product);

    @Mapping(target = "id", source = "id")
    Product mapProductEntityToProduct(ProductEntity productEntity);

    List<Product> mapProductEntityListToProductList(List<ProductEntity> productEntities);
}
