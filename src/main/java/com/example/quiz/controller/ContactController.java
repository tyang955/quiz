package com.example.quiz.controller;

import com.example.quiz.domain.Contact;
import com.example.quiz.service.MessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by tianhaoyang on 11/6/23.
 */


@Controller
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private MessageServiceImpl messageService;

    @GetMapping
    public String showContactForm(Model model) {
        model.addAttribute("message", new Contact());
        return "contact";
    }

    @PostMapping
    public String handleSubmit(@ModelAttribute Contact message) {
        messageService.saveContactMessage(message);
        return "redirect:/contact?success";
    }
}
