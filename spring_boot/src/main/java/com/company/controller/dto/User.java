package com.company.controller.dto;

import com.company.entity.RoleEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class User {
    private Long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private Set<RoleEntity> roles;
}
