package com.finalproject.producttrack.controllers;

import com.finalproject.producttrack.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/authorize")
public class AuthorizationController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String showAuthorizationForm() {
        return "authorization";
    }

    @PostMapping()
    public ModelAndView userAuthorization(@RequestParam String login, @RequestParam String password, ModelMap model) {
        if (userService.getUserByLogin(login) != null &&
                userService.getUserByLogin(login).getPassword().equals(password)) {
            model.addAttribute("name", login);
            return new ModelAndView("redirect:/greeting", model);
        }
        System.out.println("There is no such login. Please register or repeat enter");
        return new ModelAndView("redirect:/authorize");
    }
}
