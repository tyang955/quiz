package com.example.quiz.dao;

import com.example.quiz.domain.Question;
import com.example.quiz.domain.User;
import com.example.quiz.exceptions.DuplicateEmailException;

import java.util.List;

public interface UserDao {
    void register(User user) throws DuplicateEmailException;
    User findByEmail(String email);

    User getUserByUserId(int userId);

    void suspendUser(int userId);

    void activateUser(int userId);

    List<User> getUsersByPage(int page, int pageSize);

    int getTotalUserCount();

    List<User> getAllUsers();

    void save(User user);
}
