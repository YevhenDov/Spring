package com.company.transformer;

import com.company.controller.dto.Producer;
import com.company.entity.ProducerEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProducerMapper {
    public ProducerEntity mapProducerToProducerEntity(Producer producer){
        ProducerEntity producerEntity = new ProducerEntity();

        producerEntity.setId(producer.getId());
        producerEntity.setName(producer.getName());
        producerEntity.setProducts(producer.getProducts());

        return producerEntity;
    }

    public Producer mapProducerEntityToProducer(ProducerEntity producerEntity){
        Producer producer = new Producer();

        producer.setId(producerEntity.getId());
        producer.setName(producerEntity.getName());
        producer.setProducts(producerEntity.getProducts());

        return producer;
    }

    public List<Producer> mapProducerEntityListToProducerList(List<ProducerEntity> producerEntities){
        return producerEntities
                .stream()
                .map(this::mapProducerEntityToProducer)
                .collect(Collectors.toList());
    }
}