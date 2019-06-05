package com.company.entity;

import com.company.listener.UuidEntityListener;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@MappedSuperclass
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain
        = true)
@EntityListeners(value = UuidEntityListener.class)
public class UuidEntity extends BaseEntity{

    @Column(name = "UUID")
    private UUID uuid;
}
