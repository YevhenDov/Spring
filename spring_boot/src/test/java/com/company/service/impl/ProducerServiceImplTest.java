package com.company.service.impl;

import com.company.controller.dto.Producer;
import com.company.transformer.ProducerMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:test-application.properties")
public class ProducerServiceImplTest {

    @Autowired
    private ProducerServiceImpl service;
    private Producer producer;
    private ProducerMapper mapper = Mappers.getMapper(ProducerMapper.class);

    @Before
    public void setUp() throws Exception {
        producer = new Producer()
                .setName("Asus");

        service.createProducer(producer);
    }

    @Test
    public void createProducer() {
        Producer producer = new Producer()
                .setName("Acer");

        service.createProducer(producer);
        Producer producerByName = service.getProducerByName(producer.getName());
        assertEquals(producer, mapper.mapProducerToProducerEntity(producerByName));
    }

    @Test
    public void getProducerById() {
        Producer producerById = service.getProducerById(1L);

        assertEquals(producer, mapper.mapProducerToProducerEntity(producerById));
    }


    @Test
    public void deleteProducerById() {
        service.deleteProducerById(1L);

        assertNull(service.getProducerById(1L));
    }

    @Test
    public void getAllProducers() {
        assertEquals(4, service.getAllProducers().size());
    }

    @Test
    public void getProducerByName() {
        Producer producer = new Producer()
                .setName("Samsung");
        service.createProducer(producer);
        assertEquals(producer, mapper.mapProducerToProducerEntity(service.getProducerByName(producer.getName())));
    }
}
