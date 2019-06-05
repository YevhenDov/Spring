package com.company.transformer;

import com.company.controller.dto.User;
import com.company.entity.UserEntity;
import org.junit.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;


@SpringBootTest
public class UserMapperImplTest {

    private UserMapper mapper = Mappers.getMapper(UserMapper.class);

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

        assertThat(users, is(userEntities));
    }

    @Test
    public void mapUserToUserEntityWithNullArgument() {
        UserEntity userEntity = mapper.mapUserToUserEntity(null);
        assertNull(userEntity);
    }

    @Test
    public void mapUserEntityToUserWithNullArgument() {
        User user = mapper.mapUserEntityToUser(null);
        assertNull(user);
    }

    @Test
    public void mapUserEntityListToUserListWithNullArgument() {
        List<User> users = mapper.mapUserEntityListToUserList(null);
        assertNull(users);
    }
}
