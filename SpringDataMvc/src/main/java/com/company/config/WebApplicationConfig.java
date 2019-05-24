package com.company.config;

import com.company.dto.User;
import com.company.entity.UserRoleEum;
import com.company.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@Configuration
@ComponentScan("com.company")
public class WebApplicationConfig {

    @Autowired
    UserService userService;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService getUserDetailsService(){
        return new UserDetailsService() {
            @Override

            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                User user = userService.getUserByUserName(username);
                Set<GrantedAuthority> roles = new HashSet<>();
                roles.add(new SimpleGrantedAuthority(UserRoleEum.USER.name()));

                UserDetails userDetails =
                        new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), roles);

                return userDetails;
            }
        };
    }
}
