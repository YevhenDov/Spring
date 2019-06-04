package com.company.transformer;

import com.company.controller.dto.Producer;
import com.company.entity.ProducerEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProducerMapperTest {

    @Autowired
    private ProducerMapper mapper;

    @Test
    public void mapProducerToProducerEntity() {
        Producer producer = new Producer()
                .setName("Asus");

        ProducerEntity producerEntity = mapper.mapProducerToProducerEntity(producer);
        assertEquals(producer.getName(), producerEntity.getName());
    }

    @Test
    public void mapProducerEntityToProducer() {
        com.company.entity.ProducerEntity producerEntity = new com.company.entity.ProducerEntity();

        Producer producer = mapper.mapProducerEntityToProducer(producerEntity);
        assertEquals(producer.getName(), producerEntity.getName());
    }

    @Test
    public void mapProducerEntityListToProducerList() {
        List<com.company.entity.ProducerEntity> producerEntities = new ArrayList<>();

        com.company.entity.ProducerEntity producerEntity = new com.company.entity.ProducerEntity()
                .setName("Asus");
        com.company.entity.ProducerEntity producerEntitySecond = new com.company.entity.ProducerEntity()
                .setName("Acer");

        producerEntities.add(producerEntity);
        producerEntities.add(producerEntitySecond);

        List<Producer> producers = mapper.mapProducerEntityListToProducerList(producerEntities);

        assertEquals(producerEntities.size(), producers.size());
    }
}
