package com.example.quiz.service;

import com.example.quiz.dao.*;
import com.example.quiz.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tianhaoyang on 11/6/23.
 */
@Service
public class QuizResultService {

    @Autowired
    private QuizDao quizDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private QuizQuestionDaoImpl quizQuestionDao;

    @Autowired
    private QuestionDaoImpl questionDao;

    @Autowired
    private ChoiceDaoImpl choiceDao;

    public QuizResultDto getQuizDetails(Integer quizId) {

        Quiz quiz = quizDao.getQuizzesByQuizId(quizId);
        User user = userDao.getUserByUserId(quiz.getUserId());
        List<QuizQuestion> quizQuestions = quizQuestionDao.getQuestionsForQuiz(quizId);

        List<QuizResultDto.QuestionDetail> questionDetails = new ArrayList<>();

        for (QuizQuestion qq : quizQuestions) {
            QuizResultDto.QuestionDetail detail = new QuizResultDto.QuestionDetail();

            Question question = questionDao.getQuestionById(qq.getQuestionId());
            detail.setQuestion(question);

            List<Choice> choices = choiceDao.getChoicesForQuestion(qq.getQuestionId());
            detail.setChoices(choices);

            Choice userChoice = choiceDao.getChoiceById(qq.getUserChoiceId());
            detail.setUserSelectedChoice(userChoice);

            for (Choice choice : choices) {
                if (choice.isCorrect()) {
                    detail.setCorrectChoice(choice);
                    break;
                }
            }

            questionDetails.add(detail);
        }

        QuizResultDto result = new QuizResultDto();
        result.setQuiz(quiz);
        result.setUser(user);
        result.setQuestionDetails(questionDetails);

        long correctAnswersCount = questionDetails.stream()
                .filter(detail -> detail.getUserSelectedChoice().isCorrect())
                .count();

        result.setScore(correctAnswersCount);
        result.setPassed(correctAnswersCount > 3);

        return result;
    }

    public List<QuizResultDto> getAllQuizResults() {
        List<Integer> quizIds = quizDao.getAllQuizIds();
        List<QuizResultDto> quizResults = new ArrayList<>();

        for(Integer quizId : quizIds) {
            quizResults.add(getQuizDetails(quizId));
        }

        return quizResults;
    }
}
