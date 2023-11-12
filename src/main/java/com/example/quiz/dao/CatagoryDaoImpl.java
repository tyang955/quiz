package com.example.quiz.dao;

import com.example.quiz.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by tianhaoyang on 11/5/23.
 */
@Repository
public class CatagoryDaoImpl implements CategoryDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Category> getAllCategories() {
        String sql = "SELECT * FROM category";
        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new Category(rs.getInt("category_id"), rs.getString("name"))
        );
    }

    @Override
    public String getCategoryNameById(int categoryId) {
        String sql = "SELECT name FROM category WHERE category_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{categoryId}, String.class);
    }
}
