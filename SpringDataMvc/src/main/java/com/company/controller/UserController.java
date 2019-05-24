package com.company.controller;

import com.company.dto.User;
import com.company.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@ComponentScan(basePackages = "com.company")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {

    private UserService userService;

    @GetMapping("/homeAdmin")
    public ModelAndView adminHome() {
        ModelAndView modelAndView = new ModelAndView("admin_home");
        List<User> allUsers = userService.getAllUsers();
        modelAndView.addObject("users", allUsers);

        return modelAndView;
    }

    @GetMapping("/homeUser")
    public ModelAndView userHome(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user_home");
        List<User> allUsers = userService.getAllUsers();
        modelAndView.addObject("users", allUsers);

        return modelAndView;
    }


    @GetMapping("/add")
    public ModelAndView addUserForm() {
        ModelAndView modelAndView = new ModelAndView("new_user");
        modelAndView.addObject("user", new User());

        return modelAndView;
    }

    @PostMapping("/addOrUpdate")
    public RedirectView addOrUpdate(@ModelAttribute("user") User user) {
        userService.createUser(user);

        return new RedirectView("/");
    }

    @GetMapping("/edit")
    public ModelAndView editUserForm(@RequestParam int id) {
        ModelAndView modelAndView = new ModelAndView("edit_user");
        User user = userService.getUserById(id);
        modelAndView.addObject("user", user);

        return modelAndView;
    }

    @GetMapping("/delete")
    public RedirectView deleteUser(@RequestParam int id) {
        userService.deleteUserById(id);

        return new RedirectView("/");
    }


    @GetMapping("/login")
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @PostMapping("/login")
    public RedirectView auth(@ModelAttribute("user") User user){

        return new RedirectView("/");
    }

    @GetMapping("/admin")
    public String admin(Model model){
        return "/admin";
    }
}
