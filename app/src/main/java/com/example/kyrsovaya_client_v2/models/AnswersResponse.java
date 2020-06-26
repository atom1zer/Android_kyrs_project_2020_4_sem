package com.example.kyrsovaya_client_v2.models;

import android.text.TextUtils;

import java.lang.reflect.Array;
import java.util.Collections;
import java.util.List;

public class AnswersResponse {

    private List<String> incorrect_answers;


    private boolean status;
    boolean BAN;
    private String author_name, quizname,questions, quiz_id, author_id;


    public AnswersResponse( boolean BAN) {
        this.BAN = BAN;
    }

    public AnswersResponse(boolean status, List<String> answers, String author_name, String quizname, String questions, List<String> incorrect_answers, String author_id/*,List<String> correct_answers*/) {
        this.status = status;
        this.incorrect_answers = incorrect_answers;
        this.author_name = author_name;
        this.quizname = quizname;
        this.questions = questions;
        this.quiz_id = quiz_id;
        this.author_id = author_id;

    }


    public boolean isStatus() {
        return status;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public String getQuizname() {
        return quizname;
    }

    public String getQuestions() {
        return questions;
    }

    public List<String> getIncorrect_answers() {

        return incorrect_answers;
    }

    public String getQuiz_id() {
        return quiz_id;
    }

    public String getAuthor_id() {
        return author_id;
    }

    public boolean isBAN() {
        return BAN;
    }
}
