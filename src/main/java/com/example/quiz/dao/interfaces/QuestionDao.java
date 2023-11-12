package com.example.quiz.dao.interfaces;

import com.example.quiz.domain.Question;

import java.util.List;

/**
 * @author Tianhao Yang
 * @create 2023 11 11 10:17 PM
 */
public interface QuestionDao {
    /**
     * Retrieves a random list of active questions for a given category.
     *
     * @param categoryId The category ID to filter questions.
     * @param limit The maximum number of questions to retrieve.
     * @return A list of Question objects.
     */
    List<Question> getRandomActiveQuestionsByCategory(int categoryId, int limit);

    /**
     * Retrieves a question by its ID.
     *
     * @param questionId The ID of the question.
     * @return A Question object.
     */
    Question getQuestionById(int questionId);

    /**
     * Retrieves all questions.
     *
     * @return A list of all Question objects.
     */
    List<Question> findAll();

    /**
     * Saves or updates a question in the database.
     *
     * @param question The Question object to be saved or updated.
     */
    void save(Question question);

    /**
     * Saves a new question and returns its generated ID.
     *
     * @param question The Question object to be saved.
     * @return The generated ID of the saved question.
     */
    int saveQuestion(Question question);

}
