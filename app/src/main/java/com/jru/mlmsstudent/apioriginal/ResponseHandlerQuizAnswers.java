package com.jru.mlmsstudent.apioriginal;

public class ResponseHandlerQuizAnswers {

    private String message;

    private QuizResult data;

    public ResponseHandlerQuizAnswers(String message, QuizResult data) {
        this.message = message;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public QuizResult getData() {
        return data;
    }
}
