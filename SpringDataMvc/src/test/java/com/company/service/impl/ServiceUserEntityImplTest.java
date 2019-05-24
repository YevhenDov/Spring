package com.company.service.impl;

import com.company.dto.User;
import com.company.entity.UserEntity;
import com.company.service.UserService;
import com.company.config.TestApplicationConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestApplicationConfig.class)
public class ServiceUserEntityImplTest {
    @Autowired
    private UserService service;

    private User user;

    @Before
    public void init() {
        user = new User()
                .setName("John")
                .setAge(25)
                .setEmail("c4c4c");
        service.createUser(user);
    }

    @After
    public void drop() {
        service.deleteUserById(user.getId());
    }

    @Test
    public void createUser() {
        assertEquals(service.getUserById(user.getId()), user);
    }

    @Test
    public void getUserById() {
        int id = user.getId();
        assertEquals(service.getUserById(id), user);
    }

    @Test
    public void updateUser() {
        user.setName("update");
        service.updateUser(user);
        int id = user.getId();
        assertEquals(service.getUserById(id), user);

    }

    @Test
    public void deleteUserById() {
        User newUser = new User()
                .setName("delete");
        service.createUser(newUser);
        int id = newUser.getId();
        service.deleteUserById(id);
        assertFalse(service.getAllUsers().contains(newUser));
    }

    @Test
    public void getAllUsers() {
        User newUser = new User()
                .setName("New UserEntity");
        service.createUser(newUser);
        assertTrue(service.getAllUsers().size() == 2);
    }
}
