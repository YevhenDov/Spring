package com.company.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;
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
}
