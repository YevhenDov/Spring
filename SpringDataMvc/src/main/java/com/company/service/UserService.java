package com.company.service;

import com.company.dto.User;
import com.company.entity.UserEntity;
import com.company.exeption.EmptyEntityException;
import com.company.interceptor.SimpleLogger;

import javax.interceptor.Interceptors;
import java.util.List;

public interface UserService {

    @Interceptors(SimpleLogger.class)
    void createUser(User user);

    User getUserById(int id) throws NotFoundEntityExeption, Exception;

    void updateUser(User user);

    void deleteUserById(Integer id);

    List<User> getAllUsers();

    User getUserByUserName(String username) throws EmptyEntityException;
}
