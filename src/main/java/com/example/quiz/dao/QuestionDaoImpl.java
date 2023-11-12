package com.example.quiz.dao;

import com.example.quiz.domain.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

/**
 * Created by tianhaoyang on 11/5/23.
 */

@Repository
public class QuestionDaoImpl {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Question> getRandomActiveQuestionsByCategory(int categoryId, int limit) {
        String sql = "SELECT * FROM question WHERE category_id = ? AND is_active = true ORDER BY RAND() LIMIT ?";
        return jdbcTemplate.query(sql, new Object[]{categoryId, limit}, (rs, rowNum) ->
                new Question(rs.getInt("question_id"), rs.getInt("category_id"), rs.getString("description"), rs.getBoolean("is_active"))
        );
    }

    public Question getQuestionById(int questionId) {
        String sql = "SELECT * FROM question WHERE question_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{questionId}, new BeanPropertyRowMapper<>(Question.class));
    }

    public List<Question> findAll() {
        String sql = "SELECT q.question_id, q.category_id, q.description, q.is_active, c.name as category_name " +
                "FROM Question q JOIN Category c ON q.category_id = c.category_id";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Question question = new Question();
            question.setQuestionId(rs.getInt("question_id"));
            question.setCategoryId(rs.getInt("category_id"));
            question.setDescription(rs.getString("description"));
            question.setActive(rs.getBoolean("is_active"));

            return question;
        });
    }


    public void save(Question question) {
        if (question.getQuestionId() == 0) {
            // Insert
            String sql = "INSERT INTO question (category_id, description, is_active) VALUES (?, ?, ?)";
            jdbcTemplate.update(sql, question.getCategoryId(), question.getDescription(), question.isActive());
        } else {
            // Update
            String sql = "UPDATE question SET category_id = ?, description = ?, is_active = ? WHERE question_id = ?";
            jdbcTemplate.update(sql, question.getCategoryId(), question.getDescription(), question.isActive(), question.getQuestionId());
        }
    }

    public int saveQuestion(Question question) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
                connection -> {
                    PreparedStatement ps = connection.prepareStatement(
                            "INSERT INTO question (description, category_id, is_active) VALUES (?, ?, ?)",
                            Statement.RETURN_GENERATED_KEYS);
                    ps.setString(1, question.getDescription());
                    ps.setInt(2, question.getCategoryId());
                    ps.setBoolean(3, question.isActive());
                    return ps;
                },
                keyHolder);

        return keyHolder.getKey().intValue();
    }
}
