package com.company.listener;

import com.company.entity.CreatableEntity;

import javax.persistence.PrePersist;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class CreatableEnmityListener {

    @PrePersist
    public void prePersist(CreatableEntity entity){
        entity.setCreatedDate(LocalDate.now());
    }
}
