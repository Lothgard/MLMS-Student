package com.jru.mlmsstudent.lecture;

import java.io.Serializable;

public class DiscussionItem implements Serializable {

    private long studentId;
    private String studentName;
    private String question;
    private long facultyId;
    private String facultyName;
    private String answer;

    public DiscussionItem(long studentId, String studentName, String question, long facultyId, String facultyName, String answer) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.question = question;
        this.facultyId = facultyId;
        this.facultyName = facultyName;
        this.answer = answer;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public long getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(long facultyId) {
        this.facultyId = facultyId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }
}
