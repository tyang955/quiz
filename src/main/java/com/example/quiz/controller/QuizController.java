package com.example.quiz.controller;

import com.example.quiz.domain.Choice;
import com.example.quiz.domain.Question;
import com.example.quiz.domain.Quiz;
import com.example.quiz.service.*;
import java.sql.Timestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tianhaoyang on 11/5/23.
 */

@Controller
@RequestMapping("/")
@SessionAttributes({"questions", "answers", "currentQuestionIndex"})
public class QuizController {
    @Autowired
    private QuestionServiceImpl questionService;

    @Autowired
    private ChoiceServiceImpl choiceService;

    @Autowired
    private QuizServiceImpl quizService;

    @Autowired
    private QuizQuestionServiceImpl quizQuestionService;

    @Autowired
    private CategoryService categoryService;


    @Autowired
    private QuizResultService quizResultService;

    @GetMapping("/startQuiz/{categoryId}")
    public String startQuiz(@PathVariable int categoryId, Model model, HttpServletRequest request) {
        List<Question> questions = questionService.getRandomActiveQuestionsByCategory(categoryId, 5);
        for(Question question : questions) {
            question.setChoices(choiceService.getChoicesByQuestionId(question.getQuestionId()));
        }
        model.addAttribute("questions", questions);
        model.addAttribute("currentQuestionIndex", 0);
        model.addAttribute("answers", new HashMap<Integer, Integer>());
        Timestamp quizStartTime = new Timestamp(System.currentTimeMillis());
        request.getSession().setAttribute("quizStartTime", quizStartTime);
        return "quizPage";
    }

    @PostMapping("/nextQuestion")
    public String nextQuestion(@RequestParam int currentQuestionIndex, @RequestParam int currentQuestionId, @RequestParam int selectedChoice, @ModelAttribute("answers") Map<Integer, Integer> answers, Model model) {
        answers.put(currentQuestionId, selectedChoice);
        currentQuestionIndex++;

        if(currentQuestionIndex == 5) {
            return "redirect:/submitQuiz";
        }

        model.addAttribute("currentQuestionIndex", currentQuestionIndex);
        return "quizPage";
    }


    @PostMapping("/submitQuiz")
    public String submitQuiz(@ModelAttribute("answers") Map<Integer, Integer> answers, @ModelAttribute("questions") List<Question> questions, Model model, HttpServletRequest request) {
        int score = 0;
        List<QuestionReviewItem> reviewItems = new ArrayList<>();

        if (request.getParameter("selectedChoice") != null) {
            int lastAnswer = Integer.parseInt(request.getParameter("selectedChoice"));
            int lastQuestionId = Integer.parseInt(request.getParameter("currentQuestionId"));
            answers.put(lastQuestionId, lastAnswer);
        }

        for(Question question : questions) {
            int chosenChoiceId = answers.get(question.getQuestionId());
            Choice chosenChoice = choiceService.getChoiceById(chosenChoiceId);
            Choice correctChoice = question.getChoices().stream()
                    .filter(Choice::isCorrect)
                    .findFirst()
                    .orElse(null);

            boolean isCorrect = chosenChoice.isCorrect();
            if(isCorrect) {
                score++;
            }

            reviewItems.add(new QuestionReviewItem(question, chosenChoice, correctChoice, isCorrect));
        }

        model.addAttribute("score", score);
        model.addAttribute("totalQuestions", questions.size());
        model.addAttribute("reviewItems", reviewItems);


        Quiz quiz = new Quiz();
        String userIdStr = (String) request.getSession().getAttribute("userId");
        quiz.setUserId(Integer.parseInt(userIdStr));
        quiz.setCategoryId(questions.get(0).getCategoryId());
        quiz.setName(categoryService.getCategoryNameById(questions.get(0).getCategoryId()));
        Timestamp quizStartTime = (Timestamp) request.getSession().getAttribute("quizStartTime");
        if (quizStartTime != null) {
            quiz.setTimeStart(quizStartTime);
            quiz.setTimeEnd(new Timestamp(System.currentTimeMillis()));
        } else {
            Timestamp currentTime = new Timestamp(System.currentTimeMillis());
            quiz.setTimeStart(currentTime);
            quiz.setTimeEnd(currentTime);
        }

        int quizId = quizService.saveQuiz(quiz);

        for (Map.Entry<Integer, Integer> entry : answers.entrySet()) {
            int questionId = entry.getKey();
            int userChoiceId = entry.getValue();
            quizQuestionService.saveQuizQuestion(quizId, questionId, userChoiceId);
        }
        return "score";
    }


    @GetMapping("/result/{quizId}")
    public String getQuizResult(@PathVariable Integer quizId, Model model) {
        QuizResultDto quizResultDto = quizResultService.getQuizDetails(quizId);
        model.addAttribute("quizResult", quizResultDto);
        return "quizResult";
    }


    public class QuestionReviewItem {
        private Question question;
        private Choice chosenChoice;
        private Choice correctChoice;
        private boolean isCorrect;

        public QuestionReviewItem(Question question, Choice chosenChoice, Choice correctChoice, boolean isCorrect) {
            this.question = question;
            this.chosenChoice = chosenChoice;
            this.correctChoice = correctChoice;
            this.isCorrect = isCorrect;
        }

        public Question getQuestion() {
            return question;
        }

        public void setQuestion(Question question) {
            this.question = question;
        }

        public Choice getChosenChoice() {
            return chosenChoice;
        }

        public void setChosenChoice(Choice chosenChoice) {
            this.chosenChoice = chosenChoice;
        }

        public Choice getCorrectChoice() {
            return correctChoice;
        }

        public void setCorrectChoice(Choice correctChoice) {
            this.correctChoice = correctChoice;
        }

        public boolean isCorrect() {
            return isCorrect;
        }

        public void setCorrect(boolean correct) {
            isCorrect = correct;
        }
    }
}
