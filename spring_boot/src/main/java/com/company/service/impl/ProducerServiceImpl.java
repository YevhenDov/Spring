package com.company.service.impl;

import com.company.controller.dto.Producer;
import com.company.entity.ProducerEntity;
import com.company.repository.ProducerEntityRepository;
import com.company.service.ProducerService;
import com.company.transformer.ProducerMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProducerServiceImpl implements ProducerService {

    private final ProducerEntityRepository repository;
    private final ProducerMapper mapper;

    @Override
    public void createProducer(Producer producer) {
        repository.save(mapper.mapProducerToProducerEntity(producer));
    }

    @Override
    public Producer getProducerById(Long id) {
        return mapper.mapProducerEntityToProducer(repository.findById(id).get());
    }

    @Override
    public void updateProducer(Producer producer) {
        repository.save(mapper.mapProducerToProducerEntity(producer));
    }

    @Override
    public void deleteProducerById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Producer> getAllProducers() {
        return mapper.mapProducerEntityListToProducerList(repository.findAll());
    }

    @Override
    public ProducerEntity getProducerByName(String name) {
        return repository.findByName(name);
    }
}
