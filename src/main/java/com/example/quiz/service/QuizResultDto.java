package com.example.quiz.service;

import com.example.quiz.domain.*;

import java.util.List;

/**
 * Created by tianhaoyang on 11/6/23.
 */



public class QuizResultDto {
    private Quiz quiz;
    private User user;
    private List<QuestionDetail> questionDetails;
    private boolean passed;

    private long score;


    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<QuestionDetail> getQuestionDetails() {
        return questionDetails;
    }

    public void setQuestionDetails(List<QuestionDetail> questionDetails) {
        this.questionDetails = questionDetails;
    }

    public boolean isPassed() {
        return passed;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }

    public static class QuestionDetail {
        private Question question;
        private List<Choice> choices;
        private Choice userSelectedChoice;
        private Choice correctChoice;

        public Question getQuestion() {
            return question;
        }

        public void setQuestion(Question question) {
            this.question = question;
        }

        public List<Choice> getChoices() {
            return choices;
        }

        public void setChoices(List<Choice> choices) {
            this.choices = choices;
        }

        public Choice getUserSelectedChoice() {
            return userSelectedChoice;
        }

        public void setUserSelectedChoice(Choice userSelectedChoice) {
            this.userSelectedChoice = userSelectedChoice;
        }

        public Choice getCorrectChoice() {
            return correctChoice;
        }

        public void setCorrectChoice(Choice correctChoice) {
            this.correctChoice = correctChoice;
        }
    }
}