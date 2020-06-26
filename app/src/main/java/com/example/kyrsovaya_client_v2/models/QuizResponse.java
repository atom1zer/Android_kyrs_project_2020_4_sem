package com.example.kyrsovaya_client_v2.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class QuizResponse {

    private List<Quiz> quiz;

    private boolean status;

    public QuizResponse(boolean status, List<Quiz> quiz) {
        this.status = status;
        this.quiz = quiz;
    }

    public List<Quiz> getQuiz() {
        return quiz;
    }
    public boolean isStatus() {
        return status;
    }
}
