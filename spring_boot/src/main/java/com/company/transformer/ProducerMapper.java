package com.company.transformer;

import com.company.controller.dto.Producer;
import com.company.entity.ProducerEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ProducerMapper {
    ProducerEntity mapProducerToProducerEntity(Producer producer);

    Producer mapProducerEntityToProducer(ProducerEntity producerEntity);

    List<Producer> mapProducerEntityListToProducerList(List<ProducerEntity> producerEntities);
}
