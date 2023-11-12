package com.example.quiz.dao.interfaces;

import com.example.quiz.domain.Choice;

import java.util.List;

/**
 * @author Tianhao Yang
 * @create 2023 11 11 10:07 PM
 */
public interface ChoiceDao {
    List<Choice> getChoicesByQuestionId(int questionId);

    Choice getChoiceById(int choiceId);

    void saveChoice(Choice choice);

    boolean isChoiceCorrect(int choiceId);

    List<Choice> getChoicesForQuestion(int questionId);
}
