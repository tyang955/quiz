package com.example.quiz.service;

import com.example.quiz.dao.interfaces.CategoryDao;
import com.example.quiz.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tianhaoyang on 11/5/23.
 */

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryDao categoryDao;

    @Override
    public List<Category> getAllCategories() {
        return categoryDao.getAllCategories();
    }

    @Override
    public String getCategoryNameById(int categoryId) {
        return categoryDao.getCategoryNameById(categoryId);
    }
}
