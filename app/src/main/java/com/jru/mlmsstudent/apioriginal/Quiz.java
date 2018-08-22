package com.jru.mlmsstudent.apioriginal;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Quiz {

    private int id;

    @SerializedName("teacher_id")
    private long teacherId;

    private String title;

    @SerializedName("time_limit")
    private long timeLimit;

    @SerializedName("quiz_date")
    private String quizDate;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("updated_at")
    private String updatedAt;

    private List<Question> questions;

    public Quiz(int id, long teacherId, String title, long timeLimit, String quizDate, String createdAt, String updatedAt, List<Question> questions) {
        this.id = id;
        this.teacherId = teacherId;
        this.title = title;
        this.timeLimit = timeLimit;
        this.quizDate = quizDate;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.questions = questions;
    }

    public int getId() {
        return id;
    }

    public long getTeacherId() {
        return teacherId;
    }

    public String getTitle() {
        return title;
    }

    public long getTimeLimit() {
        return timeLimit;
    }

    public String getQuizDate() {
        return quizDate;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public List<Question> getQuestions() {
        return questions;
    }
}
