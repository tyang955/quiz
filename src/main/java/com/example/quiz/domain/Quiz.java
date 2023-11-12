package com.example.quiz.domain;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by tianhaoyang on 11/5/23.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Quiz {
    private int quizId;
    private int userId;
    private int categoryId;
    private String name;
    private Timestamp timeStart;
    private Timestamp timeEnd;
}
