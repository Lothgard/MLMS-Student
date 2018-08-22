package com.jru.mlmsstudent.quiz;

import java.io.Serializable;
import java.util.List;

public class QuizItem implements Serializable{

    private String question;
    private List<String> choices;
    private String letterOfCorrectAnswer;

    public QuizItem(String question, List<String> choices, String letterOfCorrectAnswer) {
        this.question = question;
        this.choices = choices;
        this.letterOfCorrectAnswer = letterOfCorrectAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getChoices() {
        return choices;
    }

    public String getLetterOfCorrectAnswer() {
        return letterOfCorrectAnswer;
    }

}
