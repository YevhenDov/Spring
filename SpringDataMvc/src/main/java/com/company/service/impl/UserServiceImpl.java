package com.company.service.impl;

import com.company.dto.User;
import com.company.entity.UserEntity;
import com.company.interceptor.SimpleLogger;
import com.company.repository.UserEntityRepository;
import com.company.service.UserService;
import com.company.transformer.UserMapper;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.interceptor.Interceptors;
import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {

    private UserEntityRepository repository;
    private UserMapper transformer;

    @Override
    @Interceptors(SimpleLogger.class)
    public void createUser(User user) {
        repository.save(transformer.mapUserToUserEntity(user));
    }

    @Override
    public User getUserById(int id) {
        return transformer.mapUserEntityToUser(repository.findById(id).get());
    }

    @Override
    public void updateUser(User user) {
        repository.save(transformer.mapUserToUserEntity(user));
    }

    @Override
    public void deleteUserById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return transformer.mapUserEntityListToUserList(repository.findAll());
    }

    @Override
    public User getUserByUserName(String username) {
        return transformer.mapUserEntityToUser(repository.findByUsername(username));
    }
}

