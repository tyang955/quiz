package com.example.quiz.dao.interfaces;

import com.example.quiz.domain.Quiz;

import java.util.List;
import java.util.Optional;

/**
 * Created by tianhaoyang on 11/5/23.
 */
public interface QuizDao {
    List<Quiz> getQuizzesByUserId(int userId);

    int saveQuiz(Quiz quiz);

    Quiz getQuizzesByQuizId(Integer quizId);

    List<Integer> getAllQuizIds();
}
