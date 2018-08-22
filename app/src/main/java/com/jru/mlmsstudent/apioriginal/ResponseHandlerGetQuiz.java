package com.jru.mlmsstudent.apioriginal;

public class ResponseHandlerGetQuiz {

    private Quiz data;

    public ResponseHandlerGetQuiz(Quiz data) {
        this.data = data;
    }

    public Quiz getData() {
        return data;
    }
}
