package com.company.transformer;

import com.company.controller.dto.User;
import com.company.entity.UserEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {
    public UserEntity mapUserToUserEntity(User user) {

        if (user == null){
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setId(user.getId());
        userEntity.setEmail(user.getEmail());
        userEntity.setPassword(user.getPassword());
        userEntity.setFirstName(user.getFirstName());
        userEntity.setLastName(user.getLastName());
        userEntity.setRoles(user.getRoles());

        return userEntity;
    }

    public User mapUserEntityToUser(UserEntity userEntity) {

        if (userEntity == null){
            return null;
        }

        User user = new User();

        user.setId(userEntity.getId());
        user.setEmail(userEntity.getEmail());
        user.setPassword(userEntity.getPassword());
        user.setFirstName(userEntity.getFirstName());
        user.setLastName(userEntity.getLastName());

        return user;
    }

    public List<User> mapUserEntityListToUserList(List<UserEntity> userEntities){

        if (userEntities == null){
            return null;
        }

        return userEntities
                .stream()
                .map(this::mapUserEntityToUser)
                .collect(Collectors.toList());
    }
}
