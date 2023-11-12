package com.example.quiz.controller;

import com.example.quiz.domain.User;
import com.example.quiz.exceptions.DuplicateEmailException;
import com.example.quiz.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

// ...


@Controller
public class RegistrationController {
    private static final Logger logger = LoggerFactory.getLogger(RegistrationController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String registerForm(Model model) {
        logger.info("Accessed the register form");
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, Model model) {
        logger.info("Attempting to register user: {}", user.getEmail());
        try {
            userService.register(user);
            return "redirect:/login";
        } catch (DuplicateEmailException e) {
            model.addAttribute("emailError", "Email already taken!");
            return "register";
        }
    }
}
