package com.jru.mlmsstudent.apioriginal;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Question {

    private int id;

    @SerializedName("quiz_id")
    private long quizId;

    private String question;

    private List<Choices> choices;

    private String answer;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("updated_at")
    private String updatedAt;

    public Question(int id, long quizId, String question, List<Choices> choices, String answer, String createdAt, String updatedAt) {
        this.id = id;
        this.quizId = quizId;
        this.question = question;
        this.choices = choices;
        this.answer = answer;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return id;
    }

    public long getQuizId() {
        return quizId;
    }

    public String getQuestion() {
        return question;
    }

    public List<Choices> getChoices() {
        return choices;
    }

    public String getAnswer() {
        return answer;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }
}
