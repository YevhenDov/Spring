package com.company.service.impl;

import com.company.controller.dto.User;
import com.company.entity.RoleEntity;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Log4j
@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserServiceImpl userService;
    private final RoleServiceImpl roleService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userService.getUserByEmail(email);
        List<String> roleNames = new ArrayList<>();
        List<GrantedAuthority> authorityList = new ArrayList<>();

        if (user == null){
            log.info("User with this email not found: " + email);
            throw new UsernameNotFoundException("User " + email + " was not found in the database");
        }

        log.info("Found user: " + email);

        for (RoleEntity roleEntity : roleService.getRoleEntities()){
            roleNames.add(roleEntity.getName());
        }

        if (roleNames.size() > 0){
            for (String role : roleNames){
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role);
                authorityList.add(grantedAuthority);
            }
        }

        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorityList);
        return userDetails;
    }
}
