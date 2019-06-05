package com.company.listener;

import com.company.entity.UuidEntity;

import javax.persistence.PrePersist;
import java.util.UUID;

public class UuidEntityListener {
    @PrePersist
    public void prePersist(UuidEntity uuidEntity){
        uuidEntity.setUuid(UUID.randomUUID());
    }
}
