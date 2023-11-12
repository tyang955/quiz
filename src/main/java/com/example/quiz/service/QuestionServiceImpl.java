package com.example.quiz.service;

import com.example.quiz.dao.ChoiceDaoImpl;
import com.example.quiz.dao.QuestionDaoImpl;
import com.example.quiz.domain.Choice;
import com.example.quiz.domain.Question;
import com.example.quiz.helper.QuestionForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tianhaoyang on 11/5/23.
 */

@Service
public class QuestionServiceImpl {

    @Autowired
    private QuestionDaoImpl questionDao;

    @Autowired
    private ChoiceDaoImpl choiceDao;

    public List<Question> getRandomActiveQuestionsByCategory(int categoryId, int limit) {
        return questionDao.getRandomActiveQuestionsByCategory(categoryId, limit);
    }

    public List<Question> getAllQuestions() {
        return questionDao.findAll();
    }

    public void saveQuestionAndChoices(QuestionForm questionForm) {
        Question question = new Question();
        question.setDescription(questionForm.getDescription());
        question.setCategoryId(questionForm.getCategoryId());
        question.setActive(questionForm.isActive());

        int questionId = questionDao.saveQuestion(question);

        List<Choice> choices = questionForm.getChoices();
        for (int i = 0; i < choices.size(); i++) {
            Choice choice = choices.get(i);
            choice.setQuestionId(questionId);
            choice.setCorrect(i == questionForm.getCorrectChoice());
            choiceDao.saveChoice(choice);
        }
    }

    public void suspendQuestion(Integer id) {
        Question question = questionDao.getQuestionById(id);
        question.setActive(false);
        question.setQuestionId(id);
        questionDao.save(question);
    }

    public void activateQuestion(Integer id) {
        Question question = questionDao.getQuestionById(id);
        question.setActive(true);
        question.setQuestionId(id);
        questionDao.save(question);
    }

    public Question findById(Integer questionId) {
        return questionDao.getQuestionById(questionId);
    }

    public void updateQuestion(Integer questionId, Question questionDetails) {
        Question question = questionDao.getQuestionById(questionId);

        question.setQuestionId(questionId);
        question.setDescription(questionDetails.getDescription());
        question.setActive(questionDetails.isActive());

        questionDao.saveQuestion(question);
    }
}
