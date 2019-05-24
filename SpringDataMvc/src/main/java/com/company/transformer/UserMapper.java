package com.company.transformer;

import com.company.dto.User;
import com.company.entity.UserEntity;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class UserMapper {
    public UserEntity mapUserToUserEntity(User user) {
        UserEntity userEntity = new UserEntity();

        userEntity.setId(user.getId());
        userEntity.setName(user.getName());
        userEntity.setAge(user.getAge());
        userEntity.setEmail(user.getEmail());

        return userEntity;
    }

    public User mapUserEntityToUser(UserEntity userEntity) {
        return new User()
                .setName(userEntity.getName())
                .setAge(userEntity.getAge())
                .setEmail(userEntity.getEmail())
                .setCreatedDate(userEntity.getCreatedDate())
                .setId(userEntity.getId());
    }

    public List<User> mapUserEntityListToUserList(List<UserEntity> userEntities){
        return userEntities
                .stream()
                .map(this::mapUserEntityToUser)
                .collect(toList());
    }
}
