package com.example.quiz.dao;

import com.example.quiz.domain.Quiz;
import com.example.quiz.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;

/**
 * Created by tianhaoyang on 11/5/23.
 */
@Repository
public class QuizDaoImpl implements QuizDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Quiz> getQuizzesByUserId(int userId) {
        String sql = "SELECT * FROM quiz WHERE user_id = ?";
        return jdbcTemplate.query(sql, new Object[]{userId}, (rs, rowNum) ->
                new Quiz(rs.getInt("quiz_id"), rs.getInt("user_id"), rs.getInt("category_id"),
                        rs.getString("name"), rs.getTimestamp("time_start"), rs.getTimestamp("time_end"))
        );
    }

    @Override
    public int saveQuiz(Quiz quiz) {
        String sql = "INSERT INTO quiz (user_id, category_id, name, time_start, time_end) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                quiz.getUserId(),
                quiz.getCategoryId(),
                quiz.getName(),
                quiz.getTimeStart(),
                quiz.getTimeEnd());

        String returnIdSQL = "SELECT LAST_INSERT_ID()";
        return jdbcTemplate.queryForObject(returnIdSQL, Integer.class);
    }

    @Override
    public Quiz getQuizzesByQuizId(Integer quizId) {
        String sql = "SELECT * FROM quiz WHERE quiz_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{quizId}, new BeanPropertyRowMapper<>(Quiz.class));
    }

    public List<Integer> getAllQuizIds() {
        String sql = "SELECT quiz_id FROM quiz ORDER BY time_start DESC";
        return jdbcTemplate.queryForList(sql, Integer.class);
    }
}
