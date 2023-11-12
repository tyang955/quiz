package com.example.quiz.dao;

import com.example.quiz.domain.Choice;
import com.example.quiz.domain.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by tianhaoyang on 11/5/23.
 */

@Repository
public class ChoiceDaoImpl {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Choice> getChoicesByQuestionId(int questionId) {
        String sql = "SELECT * FROM choice WHERE question_id = ?";
        return jdbcTemplate.query(sql, new Object[]{questionId}, (rs, rowNum) ->
                new Choice(rs.getInt("choice_id"), rs.getInt("question_id"), rs.getString("description"), rs.getBoolean("is_correct"))
        );
    }

    public Choice getChoiceById(int choiceId) {
        String sql = "SELECT * FROM choice WHERE choice_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{choiceId}, new ChoiceRowMapper());
    }

    public void saveChoice(Choice choice) {
        jdbcTemplate.update(
                "INSERT INTO choice (question_id, description, is_correct) VALUES (?, ?, ?)",
                choice.getQuestionId(), choice.getDescription(), choice.isCorrect());
    }


    private static final class ChoiceRowMapper implements RowMapper<Choice> {
        @Override
        public Choice mapRow(ResultSet rs, int rowNum) throws SQLException {
            Choice choice = new Choice();
            choice.setChoiceId(rs.getInt("choice_id"));
            choice.setQuestionId(rs.getInt("question_id"));
            choice.setDescription(rs.getString("description"));
            choice.setCorrect(rs.getBoolean("is_correct"));
            return choice;
        }
    }

    public boolean isChoiceCorrect(int choiceId) {
        String sql = "SELECT is_correct FROM choice WHERE choice_id = ?";

        Boolean isCorrect = jdbcTemplate.queryForObject(sql, new Object[]{choiceId}, Boolean.class);

        return isCorrect != null && isCorrect;
    }

    public List<Choice> getChoicesForQuestion(int questionId) {
        String sql = "SELECT * FROM choice WHERE question_id = ?";
        return jdbcTemplate.query(sql, new Object[]{questionId}, new ChoiceRowMapper());
    }

}
