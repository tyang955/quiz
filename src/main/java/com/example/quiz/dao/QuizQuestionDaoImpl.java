package com.example.quiz.dao;

import com.example.quiz.domain.QuizQuestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by tianhaoyang on 11/6/23.
 */

@Repository
public class QuizQuestionDaoImpl {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void saveQuizQuestion(int quizId, int questionId, int userChoiceId) {
        String sql = "INSERT INTO quiz_question (quiz_id, question_id, user_choice_id) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, quizId, questionId, userChoiceId);
    }

    public List<QuizQuestion> getQuestionsForQuiz(int quizId) {
        String sql = "SELECT * FROM quiz_question WHERE quiz_id = ?";
        return jdbcTemplate.query(sql, new Object[]{quizId}, new BeanPropertyRowMapper<>(QuizQuestion.class));
    }
}
