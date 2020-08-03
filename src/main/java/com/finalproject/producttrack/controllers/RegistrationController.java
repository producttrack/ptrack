package com.finalproject.producttrack.controllers;

import com.finalproject.producttrack.entities.User;
import com.finalproject.producttrack.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/add")
    public String showRegistrationForm() {
        return "registration";
    }

    @PostMapping("/add")
    public String saveNewUser(@RequestParam String password,  @RequestParam String repeat_password, @ModelAttribute User user) {
//        System.out.println(user.getLogin());
        if (!password.equals(repeat_password)) {
            // TODO display any message on the page
            System.out.println("You do not repeat password. Try again");
            return "redirect:/registration/add";
        }
        if (userService.userExistWithProvidedEmail(user.getEmail())) {
            // TODO display any message on the page
            System.out.println("Such email already exist. Try another one");
            return "redirect:/registration/add";
        }
        userService.saveOrUpdateUser(user);
        return "redirect:/";
    }
}
