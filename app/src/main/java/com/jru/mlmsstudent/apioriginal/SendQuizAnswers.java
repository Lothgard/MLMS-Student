package com.jru.mlmsstudent.apioriginal;

import java.util.List;

public class SendQuizAnswers {

    private List<Answer> answers;

    public SendQuizAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
