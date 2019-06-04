package com.company.service.impl;

import com.company.controller.dto.User;
import com.company.service.UserService;
import com.company.transformer.UserMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    UserService userService;
    @Autowired
    UserMapper userMapper;
    User user;

    @Before
    public void setUp() throws Exception {
        user = new User()
                .setEmail("email")
                .setPassword("password")
                .setFirstName("FirstName")
                .setLastName("LastName");

        userService.createUser(user);
    }

    @Test
    public void createUser() {
        User testUser = new User()
                .setEmail("Test User")
                .setPassword("password")
                .setFirstName("FirstName")
                .setLastName("LastName");

        userService.createUser(testUser);

        assertEquals(testUser, userMapper.mapUserToUserEntity(userService.getUserById(5L)));
    }

    @Test
    public void getUserById() {
        assertEquals(user, userMapper.mapUserToUserEntity(userService.getUserById(1L)));
    }

    @Test
    public void deleteUserById() {
        userService.deleteUserById(1L);
        assertNull(userService.getUserById(1L));
    }

    @Test
    public void getAllUsers() {
        assertEquals(3, userService.getAllUsers().size());
    }

    @Test
    public void getUserByEmail() {
        User SecondTestUser = new User()
                .setEmail("Second Test User")
                .setPassword("password")
                .setFirstName("FirstName")
                .setLastName("LastName");

        userService.createUser(SecondTestUser);
        assertEquals(SecondTestUser, userMapper.mapUserToUserEntity(userService.getUserByEmail("Second Test User")));
    }
}
