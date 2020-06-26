package com.example.kyrsovaya_client_v2.models;

import java.lang.reflect.Array;

public class Quiz {

    private String quiz_id/*, author_id*/;
    private String quizname, author_id, author_name;


    public Quiz(String quiz_id,String author_id,String quizname, String author_name) {
        this.quiz_id = quiz_id;
        this.author_id = author_id;
        this.quizname = quizname;
        this.author_name = author_name;

    }


    public String getQuiz_id() {
        return quiz_id;
    }

    public String getAuthor_id() {
        return author_id;
    }

    public String getQuizname() {
        return quizname;
    }

    public String getAuthor_name() {
        return author_name;
    }



}
