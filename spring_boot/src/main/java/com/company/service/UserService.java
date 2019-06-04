package com.company.service;

import com.company.controller.dto.User;

import java.util.List;

public interface UserService {
    void createUser(User user);

    User getUserById(Long id);

    void deleteUserById(Long id);

    User getUserByEmail(String email);

    List<User> getAllUsers();
}
