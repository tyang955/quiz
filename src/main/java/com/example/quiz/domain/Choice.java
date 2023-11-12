package com.example.quiz.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by tianhaoyang on 11/5/23.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Choice {
    private int choiceId;
    private int questionId;
    private String description;
    private boolean isCorrect;
}

