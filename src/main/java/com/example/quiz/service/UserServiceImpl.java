package com.example.quiz.service;

import com.example.quiz.dao.interfaces.UserDao;
import com.example.quiz.domain.User;
import com.example.quiz.exceptions.DuplicateEmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tianhaoyang on 11/4/23.
 */

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private static final int PAGE_SIZE = 5;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void register(User user) throws DuplicateEmailException {
        userDao.register(user);
    }

    @Override
    public boolean login(String email, String password) {
        User user = userDao.findByEmail(email);
        return user != null && user.getPassword().equals(password) && user.isActive();
    }

    @Override
    public boolean authenticate(String email, String password) {
        try {
            User user = userDao.findByEmail(email);
            if (!user.isActive()) {
                return false;
            }
            return user.getPassword().equals(password);
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
    }

    public User findUserByEmail(String email) {
        try {
            return userDao.findByEmail(email);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public void suspendUser(int userId) {
        User user = userDao.getUserByUserId(userId);
        user.setActive(false);
        user.setU_id(String.valueOf(userId));
        userDao.save(user);
    }

    @Override
    public void activateUser(int userId) {
        User user = userDao.getUserByUserId(userId);
        user.setActive(true);
        user.setU_id(String.valueOf(userId));
        userDao.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

}
