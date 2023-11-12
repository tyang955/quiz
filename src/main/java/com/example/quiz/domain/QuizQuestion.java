package com.example.quiz.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by tianhaoyang on 11/6/23.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuizQuestion {
    private int qqId;
    private int quizId;
    private int questionId;
    private int userChoiceId;
}
