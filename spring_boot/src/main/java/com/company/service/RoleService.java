package com.company.service;

import com.company.entity.RoleEntity;

import java.util.List;

public interface RoleService {
    List<RoleEntity> getRoleEntities();

    RoleEntity getRoleById(Long id);
}
