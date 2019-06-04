package com.company.service;

import com.company.controller.dto.Producer;

import java.util.List;

public interface ProducerService {
    void createProducer(Producer producer);

    Producer getProducerById(Long id);

    void deleteProducerById(Long id);

    List<Producer> getAllProducers();

    Producer getProducerByName(String name);
}
