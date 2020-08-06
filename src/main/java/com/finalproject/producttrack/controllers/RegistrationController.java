package com.finalproject.producttrack.controllers;

import com.finalproject.producttrack.entities.User;
import com.finalproject.producttrack.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class RegistrationController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String showRegistrationForm() {
        return "registration";
    }

    @PostMapping("/registration")
    public ModelAndView saveNewUser(@RequestParam String repeat_password, @ModelAttribute User user, ModelMap modelMap) {
        if (!user.getLogin().equals(repeat_password)) {
            // TODO display any message on the page
            System.out.println("You do not repeat password. Try again");
            return new ModelAndView("redirect:/registration");
        }
        if (userService.userExistWithProvidedEmail(user.getEmail())) {
            // TODO display any message on the page
            System.out.println("Such email already exist. Try another one");
            return new ModelAndView("redirect:/registration");
        }
        userService.saveOrUpdateUser(user);
        modelMap.addAttribute("name", user.getLogin());
        return new ModelAndView("redirect:/greeting", modelMap);
    }
}
