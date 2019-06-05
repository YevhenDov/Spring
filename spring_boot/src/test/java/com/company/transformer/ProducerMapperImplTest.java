package com.company.transformer;

import com.company.controller.dto.Producer;
import com.company.entity.ProducerEntity;
import org.junit.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.constraints.AssertTrue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

@SpringBootTest
public class ProducerMapperImplTest {

    private ProducerMapper mapper = Mappers.getMapper(ProducerMapper.class);

    @Test
    public void mapProducerToProducerEntity() {
        Producer producer = new Producer()
                .setName("Asus");

        ProducerEntity producerEntity = mapper.mapProducerToProducerEntity(producer);
        assertEquals(producer, producerEntity);
    }

    @Test
    public void mapProducerEntityToProducer() {
        ProducerEntity producerEntity = new ProducerEntity()
                .setName("Asus");

        Producer producer = mapper.mapProducerEntityToProducer(producerEntity);
        assertEquals(producer, producerEntity);
    }

    @Test
    public void mapProducerEntityListToProducerList() {
        List<ProducerEntity> producerEntities = new ArrayList<>();

        com.company.entity.ProducerEntity producerEntity = new com.company.entity.ProducerEntity()
                .setName("Asus");
        com.company.entity.ProducerEntity producerEntitySecond = new com.company.entity.ProducerEntity()
                .setName("Acer");

        producerEntities.add(producerEntity);
        producerEntities.add(producerEntitySecond);

        List<Producer> producers = mapper.mapProducerEntityListToProducerList(producerEntities);

        assertThat("Lists not equals",producers, is(producerEntities));
    }

    @Test
    public void mapProducerToProducerEntityWithNullArgument() {
        ProducerEntity producerEntity = mapper.mapProducerToProducerEntity(null);
        assertNull(producerEntity);
    }

    @Test
    public void mapProducerEntityToProducerWithNullArgument() {
        Producer producer = mapper.mapProducerEntityToProducer(null);
        assertNull(producer);
    }

    @Test
    public void mapProducerEntityListToProducerListWithNullArgument() {
        List<Producer> producers = mapper.mapProducerEntityListToProducerList(null);
        assertNull(producers);
    }
}
