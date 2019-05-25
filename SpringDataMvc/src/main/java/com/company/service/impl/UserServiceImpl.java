package com.company.service.impl;

import com.company.dto.User;
import com.company.exeption.EmptyEntityException;
import com.company.interceptor.SimpleLogger;
import com.company.repository.UserEntityRepository;
import com.company.service.UserService;
import com.company.transformer.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.interceptor.Interceptors;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {

    private UserEntityRepository userEntityRepository;
    private UserMapper userMapper;
    private BCryptPasswordEncoder encoder;

    @Override
    @Interceptors(SimpleLogger.class)
    public void createUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        userEntityRepository.save(userMapper.mapUserToUserEntity(user));
    }

    @Override
    public User getUserById(int id) throws EmptyEntityException {
        return userMapper.mapUserEntityToUser(userEntityRepository.findById(id).orElseThrow(EmptyEntityException::new));
    }

    @Override
    public void updateUser(User user) {
        userEntityRepository.save(userMapper.mapUserToUserEntity(user));
    }

    @Override
    public void deleteUserById(Integer id) {
        userEntityRepository.deleteById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userMapper.mapUserEntityListToUserList(userEntityRepository.findAll());
    }

    @Override
    public User getUserByUserName(String username) throws EmptyEntityException {
        return userMapper.mapUserEntityToUser(userEntityRepository.findByUsername(username).orElseThrow(EmptyEntityException::new));
    }
}

