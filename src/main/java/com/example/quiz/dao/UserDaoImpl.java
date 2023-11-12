package com.example.quiz.dao;

import com.example.quiz.domain.Question;
import com.example.quiz.domain.User;
import com.example.quiz.exceptions.DuplicateEmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Repository
public class UserDaoImpl implements UserDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<User> userRowMapper = new RowMapper<User>() {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setU_id(String.valueOf(rs.getInt("u_id")));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
            user.setFirstname(rs.getString("firstname"));
            user.setLastname(rs.getString("lastname"));
            user.setActive(rs.getBoolean("is_active"));
            user.setAdmin(rs.getBoolean("is_admin"));
            return user;
        }
    };


    @Override
    public void register(User user) throws DuplicateEmailException {
        if (emailExists(user.getEmail())) {
            throw new DuplicateEmailException("Email already exists: " + user.getEmail());
        }
        String sql = "INSERT INTO user (email, password, firstname, lastname, is_active, is_admin) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, user.getEmail(), user.getPassword(), user.getFirstname(),
                user.getLastname(), user.isActive(), user.isAdmin());
    }

    private boolean emailExists(String email) {
        String sql = "SELECT COUNT(*) FROM user WHERE email = ?";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, email);
        return count > 0;
    }


    @Override
    public User findByEmail(String email) {
        String sql = "SELECT * FROM user WHERE email = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{email}, userRowMapper);
    }

    public User getUserByUserId(int userId) {
        String sql = "SELECT * FROM user WHERE u_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{userId}, new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public void suspendUser(int userId) {
        String sql = "UPDATE user SET is_active = false WHERE u_id = ?";
        jdbcTemplate.update(sql, userId);
    }

    @Override
    public void activateUser(int userId) {
        String sql = "UPDATE user SET is_active = true WHERE u_id = ?";
        jdbcTemplate.update(sql, userId);
    }

    @Override
    public List<User> getUsersByPage(int page, int pageSize) {
        int offset = (page - 1) * pageSize;
        String sql = "SELECT * FROM user LIMIT ? OFFSET ?";
        return jdbcTemplate.query(sql, new Object[]{pageSize, offset}, (rs, rowNum) -> {
            User user = new User();
            user.setU_id(String.valueOf(rs.getInt("u_id")));
            user.setEmail(rs.getString("email"));
            user.setFirstname(rs.getString("firstname"));
            user.setLastname(rs.getString("lastname"));
            user.setActive(rs.getBoolean("is_active"));
            user.setAdmin(rs.getBoolean("is_admin"));
            return user;
        });
    }

    @Override
    public int getTotalUserCount() {
        String sql = "SELECT COUNT(*) FROM user";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    @Override
    public List<User> getAllUsers() {
        String sql = "SELECT * FROM user";
        return jdbcTemplate.query(sql, userRowMapper);
    }

    @Override
    public void save(User user) {
        if (user.getU_id() == "") {
            String sql = "INSERT INTO user (email, password, firstname, lastname, is_active, is_admin) VALUES (?, ?, ?, ?, ?, ?)";
            jdbcTemplate.update(sql, user.getEmail(), user.getPassword(), user.getFirstname(), user.getLastname(), user.isActive(), user.isAdmin());
        } else {
            String sql = "UPDATE user SET email = ?, password = ?, firstname = ?, lastname = ?, is_active = ?, is_admin = ? WHERE u_id = ?";
            jdbcTemplate.update(sql, user.getEmail(), user.getPassword(), user.getFirstname(), user.getLastname(), user.isActive(), user.isAdmin(), user.getU_id());
        }
    }

}
