package com.example.quiz.controller;

import com.example.quiz.domain.Category;
import com.example.quiz.domain.Contact;
import com.example.quiz.domain.Question;
import com.example.quiz.domain.User;
import com.example.quiz.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tianhaoyang on 11/6/23.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private QuizResultService quizResultService;

    @Autowired
    private QuestionServiceImpl questionService;

    @Autowired
    private CategoryService categoryService;


    @Autowired
    private MessageServiceImpl messageService;


    @GetMapping("/home")
    public String adminHome() {
        return "admin/home";
    }

    @GetMapping("/user_management")
    public String userManagement(Model model,
                                 @RequestParam(value = "page", defaultValue = "1") int page) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "admin/user_management";
    }


    @GetMapping("/quiz_result_management")
    public String quizResultManagement(Model model) {
        List<QuizResultDto> quizzes = quizResultService.getAllQuizResults();
        model.addAttribute("quizzes", quizzes);
        return "admin/quiz_result_management";
    }

    @GetMapping("/quiz_details/{quizId}")
    public String quizDetails(@PathVariable int quizId, Model model) {
        QuizResultDto quizResult = quizResultService.getQuizDetails(quizId);

        model.addAttribute("quizResult", quizResult);
        return "admin/quizResult";
    }

    @GetMapping("/question_management")
    public String questionManagement(Model model) {
        List<Question> questions = questionService.getAllQuestions();
        List<Category> categories = categoryService.getAllCategories();

        Map<Category, List<Question>> questionsByCategory = new HashMap<>();

        for (Category category : categories) {
            questionsByCategory.put(category, new ArrayList<>());
        }
        for (Question question : questions) {
            Category category = categories.stream()
                    .filter(c -> c.getCategoryId() == question.getCategoryId())
                    .findFirst()
                    .orElseThrow(() -> new IllegalStateException("Category not found for question: " + question.getQuestionId()));

            questionsByCategory.get(category).add(question);
        }

        model.addAttribute("questionsByCategory", questionsByCategory);
        return "admin/question_management";
    }

    @GetMapping("/contact_us_management")
    public String contactUsManagement(Model model) {
        List<Contact> contacts = messageService.getAllContacts();
        model.addAttribute("contacts", contacts);
        return "admin/contact_us_management";
    }


    @GetMapping("/suspend/{id}")
    public String suspendQuestion(@PathVariable Integer id, HttpServletRequest request) {
        userService.suspendUser(id);
        String referer = request.getHeader("Referer");
        return "redirect:" + (referer == null ? "/admin/user_management" : referer);
    }

    @GetMapping("/activate/{id}")
    public String activateQuestion(@PathVariable Integer id, HttpServletRequest request) {
        userService.activateUser(id);
        String referer = request.getHeader("Referer");
        return "redirect:" + (referer == null ? "/admin/user_management" : referer);
    }
}