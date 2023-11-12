package com.example.quiz.service;

import com.example.quiz.domain.Category;

import java.util.List;

/**
 * Created by tianhaoyang on 11/5/23.
 */
public interface CategoryService {
    public List<Category> getAllCategories();
    String getCategoryNameById(int categoryId);
}
