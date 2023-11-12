package com.example.quiz.controller;

import com.example.quiz.domain.User;
import com.example.quiz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam("email") String email,
                            @RequestParam("password") String password,
                            HttpSession session, Model model) {


        boolean isAuthenticated = userService.authenticate(email, password);

        if (isAuthenticated) {
            User user = userService.findUserByEmail(email);
            if(user != null) {
                session.setAttribute("email", email);
                session.setAttribute("userId", user.getU_id());
                if(user.isAdmin()) {
                    return "redirect:/admin/home";
                } else {
                    return "redirect:/home";
                }
            }
        }else {
            model.addAttribute("error", "Invalid credentials");
        }
        return "login";
    }

}