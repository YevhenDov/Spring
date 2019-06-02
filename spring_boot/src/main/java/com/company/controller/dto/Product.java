package com.company.controller.dto;

import com.company.entity.ProducerEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Product {
    private Long id;
    private String name;
    private BigDecimal price;
    private ProducerEntity producer;
    private String producerName;
}
