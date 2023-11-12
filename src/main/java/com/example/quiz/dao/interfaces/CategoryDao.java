package com.example.quiz.dao.interfaces;
import com.example.quiz.domain.Category;
import java.util.List;
/**
 * Created by tianhaoyang on 11/5/23.
 */

public interface CategoryDao {
    List<Category> getAllCategories();
    String getCategoryNameById(int categoryId);
}
