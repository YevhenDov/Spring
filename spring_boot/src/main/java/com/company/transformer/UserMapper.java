package com.company.transformer;

import com.company.controller.dto.User;
import com.company.entity.UserEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    UserEntity mapUserToUserEntity(User user);

    User mapUserEntityToUser(UserEntity userEntity);

    List<User> mapUserEntityListToUserList(List<UserEntity> userEntities);
}
