package com.example.quiz.dao.interfaces;

import com.example.quiz.domain.QuizQuestion;

import java.util.List;

/**
 * @author Tianhao Yang
 * @create 2023 11 11 10:21 PM
 */
public interface QuizQuestionDao {
    /**
     * Saves a quiz question association in the database.
     *
     * @param quizId The ID of the quiz.
     * @param questionId The ID of the question.
     * @param userChoiceId The ID of the user's choice.
     */
    void saveQuizQuestion(int quizId, int questionId, int userChoiceId);

    /**
     * Retrieves all questions for a specific quiz.
     *
     * @param quizId The ID of the quiz.
     * @return A list of QuizQuestion objects.
     */
    List<QuizQuestion> getQuestionsForQuiz(int quizId);
}
