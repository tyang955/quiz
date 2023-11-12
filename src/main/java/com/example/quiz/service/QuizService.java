package com.example.quiz.service;

import com.example.quiz.domain.Quiz;

import java.util.List;

/**
 * Created by tianhaoyang on 11/5/23.
 */
public interface QuizService {
    List<Quiz> getQuizzesByUserId(int userId);

    int saveQuiz(Quiz quiz);
}
