package com.example.quiz.service;

import com.example.quiz.dao.ChoiceDaoImpl;
import com.example.quiz.domain.Choice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tianhaoyang on 11/5/23.
 */

@Service
public class ChoiceServiceImpl {

    @Autowired
    private ChoiceDaoImpl choiceRepository;

    public List<Choice> getChoicesByQuestionId(int questionId) {
        return choiceRepository.getChoicesByQuestionId(questionId);
    }

    public Choice getChoiceById(int chosenChoiceId) {
        return choiceRepository.getChoiceById(chosenChoiceId);
    }
}
