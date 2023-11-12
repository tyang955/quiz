package com.example.quiz.service;

import com.example.quiz.dao.QuizDao;
import com.example.quiz.domain.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by tianhaoyang on 11/5/23.
 */

@Service
public class QuizServiceImpl implements QuizService{
    @Autowired
    private QuizDao quizDao;

    public List<Quiz> getQuizzesByUserId(int userId) {
        return quizDao.getQuizzesByUserId(userId);
    }

    @Transactional
    public int saveQuiz(Quiz quiz) {
        return quizDao.saveQuiz(quiz);
    }
}
