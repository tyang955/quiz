package com.example.quiz.controller;

import com.example.quiz.domain.Question;
import com.example.quiz.helper.QuestionForm;
import com.example.quiz.service.CategoryService;
import com.example.quiz.service.QuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by tianhaoyang on 11/6/23.
 */
@Controller
@RequestMapping("/admin/questions")
public class QuestionAdminController {
    @Autowired
    private QuestionServiceImpl questionService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/add")
    public String addQuestion(Model model) {
        model.addAttribute("question", new Question());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "admin/add_question";
    }

    @PostMapping("/add")
    public String addQuestion(@ModelAttribute("questionForm") QuestionForm questionForm, BindingResult result, HttpServletRequest request, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("categories", categoryService.getAllCategories());
            return "admin/add_question";
        }
        String isActiveValue = request.getParameter("isActive");

        if (isActiveValue == null) {
            isActiveValue = request.getParameter("_isActive");
        }

        boolean isActive = Boolean.parseBoolean(isActiveValue);
        questionForm.setIsActive(isActive);
        questionService.saveQuestionAndChoices(questionForm);
        return "redirect:/admin/question_management";
    }

    @GetMapping("/suspend/{id}")
    public String suspendQuestion(@PathVariable Integer id, HttpServletRequest request) {
        questionService.suspendQuestion(id);
        String referer = request.getHeader("Referer");
        return "redirect:" + (referer == null ? "/admin/question_management" : referer);
    }

    @GetMapping("/activate/{id}")
    public String activateQuestion(@PathVariable Integer id, HttpServletRequest request) {
        questionService.activateQuestion(id);
        String referer = request.getHeader("Referer");
        return "redirect:" + (referer == null ? "/admin/question_management" : referer);
    }

    @GetMapping("/edit/{id}")
    public String editQuestionForm(@PathVariable("id") Integer questionId, Model model) {
        Question question = questionService.findById(questionId);
        model.addAttribute("question", question);
        return "admin/editQuestion";
    }

    @PostMapping("/edit/{id}")
    public String editQuestion(@PathVariable("id") Integer questionId,
                               @ModelAttribute("question") Question question,
                               BindingResult result,
                               Model model) {
        if (result.hasErrors()) {
            return "admin/editQuestion";
        }

        questionService.updateQuestion(questionId, question);
        return "redirect:/admin/questions";
    }
}