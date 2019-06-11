package com.company.transformer;

import com.company.controller.dto.User;
import com.company.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface UserMapper {
    UserEntity mapUserToUserEntity(User user);

    @Mapping(target = "id", source = "id")
    User mapUserEntityToUser(UserEntity userEntity);

    List<User> mapUserEntityListToUserList(List<UserEntity> userEntities);
}
