package com.company.transformer;

import com.company.controller.dto.Product;
import com.company.entity.ProductEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {
    public ProductEntity mapProductToProductEntity(Product product){
        ProductEntity productEntity = new ProductEntity();

        productEntity.setId(product.getId());
        productEntity.setName(product.getName());
        productEntity.setPrice(product.getPrice());
        productEntity.setProducer(product.getProducer());

        return productEntity;
    }

    public Product mapProductEntityToProduct(ProductEntity productEntity){
        Product product = new Product();

        product.setId(productEntity.getId());
        product.setName(productEntity.getName());
        product.setPrice(productEntity.getPrice());
        product.setProducer(productEntity.getProducer());

        return product;
    }

    public List<Product> mapProductEntityListToProductList(List<ProductEntity> productEntities){
        return productEntities
                .stream()
                .map(this::mapProductEntityToProduct)
                .collect(Collectors.toList());
    }
}
