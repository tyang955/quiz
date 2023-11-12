package com.example.quiz.service;

import com.example.quiz.domain.User;
import com.example.quiz.exceptions.DuplicateEmailException;

import java.util.List;

/**
 * Created by tianhaoyang on 11/4/23.
 */
public interface UserService {
    void register(User user) throws DuplicateEmailException;

    boolean login(String email, String password);

    boolean authenticate(String email, String password);

    public User findUserByEmail(String email);


    List<User> getAllUsers();

    void suspendUser(int userId);

    void activateUser(int userId);
}
