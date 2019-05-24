package com.company.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "roles")
public class RoleEntity extends BaseEntity {

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "roleEntities")
    private Set<UserEntity> userEntities;
}
