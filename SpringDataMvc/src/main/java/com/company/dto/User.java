package com.company.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import javax.validation.constraints.Email;
import javax.xml.transform.sax.SAXResult;
import java.time.LocalDateTime;

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
    private LocalDateTime createdDate;
    private String username;
    private String password;
}
