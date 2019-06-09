package com.company.controller;

import com.company.controller.dto.User;
import com.company.entity.RoleEntity;
import com.company.service.impl.RoleServiceImpl;
import com.company.service.impl.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.HashSet;
import java.util.Set;

@Controller
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {

    private final UserServiceImpl userService;
    private final RoleServiceImpl roleService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    @GetMapping("/")
    public String helloUser(){
        return "hello";
    }

    @GetMapping("/registration-form")
    public ModelAndView registerForm(){
        User user = new User();
        ModelAndView modelAndView = new ModelAndView("registration_form");
        modelAndView.addObject("user", user);

        return modelAndView;
    }

    @PostMapping("/registration")
    public RedirectView userRegistration(@ModelAttribute("user") User user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Set<RoleEntity> roles = new HashSet<>();
        roles.add(roleService.getRoleById(2L));
        user.setRoles(roles);
        userService.createUser(user);

        return new RedirectView("/admin/users");
    }

    @GetMapping("/admin/users")
    public ModelAndView allUsers(){
        ModelAndView modelAndView = new ModelAndView("ADMIN_users_list");
        modelAndView.addObject("users" , userService.getAllUsers());
        return modelAndView;
    }

    @GetMapping("/admin/edit-user/{id}")
    public ModelAndView editProductForm(@PathVariable(name = "id") Long id){
        ModelAndView modelAndView = new ModelAndView("ADMIN_edit_user");
        User user = userService.getUserById(id);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        modelAndView.addObject("user", user);

        return modelAndView;
    }

    @DeleteMapping("/admin/delete-user/{id}")
    public RedirectView deleteProduct(@PathVariable(name = "id") Long id){
        userService.deleteUserById(id);
        return new RedirectView("/admin/users");
    }

    @GetMapping("/user/users")
    public ModelAndView allUsersForUser() {
        ModelAndView modelAndView = new ModelAndView("USER_user_list");
        modelAndView.addObject("users", userService.getAllUsers());
        return modelAndView;
    }
}
