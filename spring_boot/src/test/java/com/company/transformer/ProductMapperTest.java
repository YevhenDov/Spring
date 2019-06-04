package com.company.transformer;

import com.company.controller.dto.Product;
import com.company.entity.ProducerEntity;
import com.company.entity.ProductEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductMapperTest {

    @Autowired
    private ProductMapper mapper;

    @Test
    public void mapProductToProductEntity() {
        Product product = new Product()
                .setName("KeyBoard")
                .setPrice(new BigDecimal("100"))
                .setProducer(new ProducerEntity()
                        .setName("Asus"));

        ProductEntity productEntity = mapper.mapProductToProductEntity(product);

        assertEquals(product, productEntity);
    }

    @Test
    public void mapProductEntityToProduct() {
        ProductEntity productEntity = new ProductEntity()
                .setName("KeyBoard")
                .setPrice(new BigDecimal("100"))
                .setProducer(new ProducerEntity()
                        .setName("Asus"));

        Product product = mapper.mapProductEntityToProduct(productEntity);

        assertEquals(product, productEntity);
    }

    @Test
    public void mapProductEntityListToProductList() {
        List<ProductEntity> productEntities = new ArrayList<>();
        List<Product> products;

        ProductEntity productEntity = new ProductEntity()
                .setName("KeyBoard")
                .setPrice(new BigDecimal("100"))
                .setProducer(new ProducerEntity()
                        .setName("Asus"));

        ProductEntity productEntitySecond = new ProductEntity()
                .setName("LapTop")
                .setPrice(new BigDecimal("1000"))
                .setProducer(new ProducerEntity()
                        .setName("Aser"));

        productEntities.add(productEntity);
        productEntities.add(productEntitySecond);

        products = mapper.mapProductEntityListToProductList(productEntities);

        assertEquals(productEntities.size(), products.size());
    }
}
