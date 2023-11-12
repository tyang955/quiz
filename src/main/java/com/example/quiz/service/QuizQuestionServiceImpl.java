package com.example.quiz.service;

import com.example.quiz.dao.interfaces.QuizQuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by tianhaoyang on 11/6/23.
 */
@Service
public class QuizQuestionServiceImpl {
    @Autowired
    private QuizQuestionDao quizQuestionDao;

    @Transactional
    public void saveQuizQuestion(int quizId, int questionId, int userChoiceId) {
        quizQuestionDao.saveQuizQuestion(quizId, questionId, userChoiceId);
    }


}
