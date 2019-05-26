package com.company.dto;

import com.company.entity.RoleEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import javax.validation.constraints.Email;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class User {
    private Integer id;
    private String name;
    private Integer age;
    @Email
    private String email;
    private LocalDate createdDate;
    private String username;
    private String password;
    private String confirmPassword;
    private Set<RoleEntity> roleEntities;
}
