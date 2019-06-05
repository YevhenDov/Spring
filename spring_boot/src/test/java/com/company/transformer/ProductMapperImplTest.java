package com.company.transformer;

import com.company.controller.dto.Product;
import com.company.entity.ProducerEntity;
import com.company.entity.ProductEntity;
import org.junit.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

@SpringBootTest
public class ProductMapperImplTest {

    private ProductMapper mapper = Mappers.getMapper(ProductMapper.class);

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

        assertThat(products,is(productEntities));
    }

    @Test
    public void mapProductToProductEntityWithNullArgument() {
        ProductEntity productEntity = mapper.mapProductToProductEntity(null);
        assertNull(productEntity);
    }

    @Test
    public void mapProductEntityToProductWithNullArgument() {
        Product product = mapper.mapProductEntityToProduct(null);
        assertNull(product);
    }

    @Test
    public void mapProductEntityListToProductListWithNullArgument() {
        List<Product> products = mapper.mapProductEntityListToProductList(null);
        assertNull(products);
    }
}
