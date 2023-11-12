package com.example.quiz.dao.jdbcTemplate;

import com.example.quiz.dao.interfaces.MessageDao;
import com.example.quiz.domain.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by tianhaoyang on 11/6/23.
 */

@Repository
public class JdbcMessageDao implements MessageDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void saveMessage(Contact mess) {
        String sql = "INSERT INTO contact (subject, email, message) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, mess.getSubject(), mess.getEmail(), mess.getMessage());
    }

    public List<Contact> findAllContacts() {
        String sql = "SELECT * FROM contact";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Contact.class));
    }
}
