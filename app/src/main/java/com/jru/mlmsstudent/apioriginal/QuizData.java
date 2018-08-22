package com.jru.mlmsstudent.apioriginal;

import com.google.gson.annotations.SerializedName;

public class QuizData {

    private int id;

    @SerializedName("teacher_id")
    private long teacherId;

    private String title;

    @SerializedName("time_limit")
    private long timeLimit;

    @SerializedName("quiz_data")
    private String quizData;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("updated_at")
    private String updatedAt;

    public QuizData(int id, long teacherId, String title, long timeLimit, String quizData, String createdAt, String updatedAt) {
        this.id = id;
        this.teacherId = teacherId;
        this.title = title;
        this.timeLimit = timeLimit;
        this.quizData = quizData;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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

    public String getQuizData() {
        return quizData;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }
}
