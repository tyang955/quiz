package com.example.quiz.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by tianhaoyang on 11/6/23.
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contact {
    private int contactId;
    private String subject;
    private String email;
    private String message;
    private Timestamp time;
}
