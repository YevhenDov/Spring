package com.company.service;

import com.company.controller.dto.Producer;
import com.company.entity.ProducerEntity;

import java.util.List;

public interface ProducerService {
    void createProducer(Producer producer);

    Producer getProducerById(Long id);

    void updateProducer(Producer producer);

    void deleteProducerById(Long id);

    List<Producer> getAllProducers();

    ProducerEntity getProducerByName(String name);
}
