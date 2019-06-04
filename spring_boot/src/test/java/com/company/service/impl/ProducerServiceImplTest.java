package com.company.service.impl;

import com.company.controller.dto.Producer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProducerServiceImplTest {

    @Autowired
    private ProducerServiceImpl service;
    private Producer producer;

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
        assertEquals(producer, producerByName);
    }

    @Test
    public void getProducerById() {
        Producer producerById = service.getProducerById(1L);

        assertEquals(producer, producerById);
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
        assertEquals(producer, service.getProducerByName(producer.getName()));
    }
}
