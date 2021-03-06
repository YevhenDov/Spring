package com.company.service.impl;

import com.company.entity.RoleEntity;
import com.company.repository.RoleEntityRepository;
import com.company.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class RoleServiceImpl implements RoleService {

    private final RoleEntityRepository repository;

    @Override
    public void createRoleEntity(RoleEntity roleEntity) {
        repository.save(roleEntity);
    }

    @Override
    public List<RoleEntity> getRoleEntities() {
        return repository.findAll();
    }

    @Override
    public RoleEntity getRoleById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
