package com.company.service.impl;

import com.company.dto.User;
import com.company.interceptor.SimpleLogger;
import com.company.repository.RoleEntityRepository;
import com.company.repository.UserEntityRepository;
import com.company.service.UserService;
import com.company.transformer.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.interceptor.Interceptors;
import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {

    private UserEntityRepository userEntityRepository;
    private RoleEntityRepository roleEntityRepository;
    private UserMapper transformer;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    @Interceptors(SimpleLogger.class)
    public void createUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        userEntityRepository.save(transformer.mapUserToUserEntity(user));
    }

    @Override
    public User getUserById(int id) {
        return transformer.mapUserEntityToUser(userEntityRepository.findById(id).get());
    }

    @Override
    public void updateUser(User user) {
        userEntityRepository.save(transformer.mapUserToUserEntity(user));
    }

    @Override
    public void deleteUserById(Integer id) {
        userEntityRepository.deleteById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return transformer.mapUserEntityListToUserList(userEntityRepository.findAll());
    }

    @Override
    public User getUserByUserName(String username) {
        return transformer.mapUserEntityToUser(userEntityRepository.findByUsername(username));
    }
}

