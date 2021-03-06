package com.company.controller;

import com.company.dto.User;
import com.company.service.SecurityService;
import com.company.service.UserService;
import com.company.validator.UserValidator;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;


@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {

    private UserService userService;
    private SecurityService securityService;
    private UserValidator userValidator;

    @GetMapping("/registration_form")
    public ModelAndView registrationForm() {
        ModelAndView modelAndView = new ModelAndView("new_user");
        modelAndView.addObject("user", new User());

        return modelAndView;
    }

    @PostMapping("/registration")
    public RedirectView registration(@ModelAttribute("user") User user, BindingResult bindingResult) {
        userValidator.validate(user, bindingResult);

        if (bindingResult.hasErrors()) {
            return new RedirectView("/registration_form");
        }

        userService.createUser(user);
        securityService.autoLogin(user.getUsername(), user.getConfirmPassword());

        return new RedirectView("/");
    }

    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("user", new User());

        return modelAndView;
    }

    @PostMapping("/auto_login")
    public RedirectView autologin(@ModelAttribute(value = "user") User user) {
        securityService.autoLogin(user.getUsername(), user.getPassword());

        return new RedirectView("/");
    }

    @GetMapping("/")
    public ModelAndView userHome() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user_home");
        List<User> allUsers = userService.getAllUsers();
        modelAndView.addObject("users", allUsers);

        return modelAndView;
    }
}