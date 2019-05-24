package com.company;


import com.company.config.ApplicationConfig;

import com.company.dto.User;
import com.company.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

public class App {
    @Autowired
    public static UserService service;

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        User user = new User()
                .setName("Alex");

        service.createUser(user);
    }
}