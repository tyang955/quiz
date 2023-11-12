package com.example.quiz.dao.hibernate;

import com.example.quiz.dao.interfaces.UserDao;
import com.example.quiz.domain.User;
import com.example.quiz.exceptions.DuplicateEmailException;

import java.util.List;

/**
 * @author Tianhao Yang
 * @create 2023 11 11 10:31 PM
 */
public class HibernateUserDao implements UserDao {
    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public User getUserByUserId(int userId) {
        return null;
    }

    @Override
    public List<User> getUsersByPage(int page, int pageSize) {
        return null;
    }

    @Override
    public int getTotalUserCount() {
        return 0;
    }

    @Override
    public User findByEmail(String email) {
        return null;
    }

    @Override
    public void activateUser(int userId) {

    }

    @Override
    public void suspendUser(int userId) {

    }

    @Override
    public void register(User user) throws DuplicateEmailException {

    }

    @Override
    public void save(User user) {

    }
}
