package com.company.entity;

import com.company.controller.dto.Producer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "producers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ProducerEntity extends BaseEntity{

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "producer")
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
