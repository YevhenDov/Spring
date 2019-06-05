package com.company.controller.dto;

import com.company.entity.ProducerEntity;
import com.company.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Producer {
    private Long id;
    private UUID uuid;
    private String name;
    private Set<ProductEntity> products;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 2;

        return prime * result + (name == null ? 0 : name.hashCode());
    }

    @Override
    public boolean equals(Object obj) {

        if (obj instanceof ProducerEntity) {

            ProducerEntity producerEntity = (ProducerEntity) obj;

            if (name.equals(producerEntity.getName())) {
                return true;
            }
        }
        return false;
    }
}
