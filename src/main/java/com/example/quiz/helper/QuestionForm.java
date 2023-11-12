package com.example.quiz.helper;

import com.example.quiz.domain.Choice;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by tianhaoyang on 11/6/23.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionForm {
    private String description;
    private int categoryId;
    private boolean isActive;
    private List<Choice> choices;
    private int correctChoice;

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
}
