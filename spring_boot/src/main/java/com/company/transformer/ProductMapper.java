package com.company.transformer;

import com.company.controller.dto.Product;
import com.company.entity.ProductEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    ProductEntity mapProductToProductEntity(Product product);

    Product mapProductEntityToProduct(ProductEntity productEntity);

    List<Product> mapProductEntityListToProductList(List<ProductEntity> productEntities);
}
