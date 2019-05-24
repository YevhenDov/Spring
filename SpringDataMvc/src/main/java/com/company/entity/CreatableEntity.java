package com.company.entity;

import com.company.listener.CreatableEnmityListener;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(value = CreatableEnmityListener.class)
public class CreatableEntity extends BaseEntity {

    @Column(name = "created_date")
    private LocalDateTime createdDate;
}
