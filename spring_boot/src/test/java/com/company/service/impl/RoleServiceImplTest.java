package com.company.service.impl;

import com.company.service.RoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:test-application.properties")
public class RoleServiceImplTest {

    @Autowired
    private RoleService roleService;

    @Test
    public void getRoleEntities() {
        assertEquals(2, roleService.getRoleEntities().size());
    }

    @Test
    public void getRoleById() {
        assertEquals("ADMIN", roleService.getRoleById(1L).getName());
    }
}
