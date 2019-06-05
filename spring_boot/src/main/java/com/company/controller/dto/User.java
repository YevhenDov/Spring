package com.company.controller.dto;

import com.company.entity.RoleEntity;
import com.company.entity.UserEntity;
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
public class User {
    private Long id;
    private UUID uuid;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private Set<RoleEntity> roles;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 2;

        return prime * result + (email == null ? 0 : email.hashCode());
    }

    @Override
    public boolean equals(Object obj) {

        if (obj instanceof UserEntity) {

            UserEntity userEntity = (UserEntity) obj;

            if (this.email.equals(userEntity.getEmail()) &&
                    this.password.equals(userEntity.getPassword()) &&
                    this.firstName.equals(userEntity.getFirstName()) &&
                    this.lastName.equals(userEntity.getLastName())) {
                return true;
            }
        }
        return false;
    }
}
