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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

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

    @GetMapping("/registration_form")
    public String registerForm(Model model){
        User user = new User();

        model.addAttribute("user", user);
        return "registration_form";
    }

    @PostMapping("/registration")
    public String userRegistration(@ModelAttribute("user") User user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Set<RoleEntity> roles = new HashSet<>();
        roles.add(roleService.getRoleById(2L));
        user.setRoles(roles);
        userService.createUser(user);

        return "redirect:/admin/users";
    }

    @GetMapping("/admin/users")
    public String allUsers(Model model){
        model.addAttribute("users" , userService.getAllUsers());

        return "ADMIN_users_list";
    }

    @GetMapping("/admin/edit_user/{id}")
    public ModelAndView editProductForm(@PathVariable(name = "id") Long id){
        ModelAndView modelAndView = new ModelAndView("ADMIN_edit_user");
        User user = userService.getUserById(id);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        modelAndView.addObject("user", user);

        return modelAndView;
    }

    @GetMapping("/admin/delete_user/{id}")
    public String deleteProduct(@PathVariable(name = "id") Long id){
        userService.deleteUserById(id);
        return "redirect:/admin/users";
    }

    @GetMapping("/user/users")
    public String allUsersForUser(Model model) {
        model.addAttribute("users", userService.getAllUsers());

        return "USER_user_list";
    }
}
