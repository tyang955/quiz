package com.example.quiz.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by tianhaoyang on 11/5/23.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question {
    private int questionId;
    private int categoryId;
    private String description;
    private boolean isActive;
    private List<Choice> choices;

    public Question(int questionId, int categoryId, String description, boolean isActive) {
        this.questionId = questionId;
        this.categoryId = categoryId;
        this.description = description;
        this.isActive = isActive;
    }
}
