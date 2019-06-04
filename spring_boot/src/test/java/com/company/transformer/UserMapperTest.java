package com.company.transformer;

import com.company.controller.dto.User;
import com.company.entity.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper mapper;

    @Test
    public void mapUserToUserEntity() {
        User user = new User()
                .setEmail("email")
                .setPassword("password")
                .setFirstName("FirstName")
                .setLastName("LastName");

        UserEntity userEntity = mapper.mapUserToUserEntity(user);

        assertEquals(user, userEntity);
    }

    @Test
    public void mapUserEntityToUser() {
        UserEntity userEntity = new UserEntity()
                .setEmail("email")
                .setPassword("password")
                .setFirstName("FirstName")
                .setLastName("LastName");

        User user = mapper.mapUserEntityToUser(userEntity);

        assertEquals(user, userEntity);
    }

    @Test
    public void mapUserEntityListToUserList() {
        List<User> users;
        List<UserEntity> userEntities = new ArrayList<>();

        UserEntity userEntity = new UserEntity()
                .setEmail("email")
                .setPassword("password")
                .setFirstName("FirstName")
                .setLastName("LastName");

        UserEntity userEntitySecond = new UserEntity()
                .setEmail("secondEmail")
                .setPassword("SecondPassword")
                .setFirstName("SecondFirstName")
                .setLastName("SecondLastName");

        userEntities.add(userEntity);
        userEntities.add(userEntitySecond);

        users = mapper.mapUserEntityListToUserList(userEntities);

        assertEquals(users.size(), userEntities.size());
    }
}
