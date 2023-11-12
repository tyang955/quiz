package com.example.quiz.controller;

import com.example.quiz.domain.Question;
import com.example.quiz.service.CategoryService;
import com.example.quiz.service.QuestionServiceImpl;
import com.example.quiz.service.QuizService;
import com.example.quiz.service.QuizServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by tianhaoyang on 11/5/23.
 */
@Controller
public class HomeController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private QuizService quizService;

    @Autowired
    private QuestionServiceImpl questionService;

    @GetMapping("/home")
    public String homePage(Model model, HttpSession session) {
        // Fetching user's id from the session
        String userIdStr = (String) session.getAttribute("userId");
        int userId = Integer.parseInt(userIdStr);

        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("quizzes", quizService.getQuizzesByUserId(userId));

        return "home";
    }

}