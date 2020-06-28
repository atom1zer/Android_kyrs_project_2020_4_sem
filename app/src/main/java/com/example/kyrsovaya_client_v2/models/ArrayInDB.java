package com.example.kyrsovaya_client_v2.models;

import android.text.TextUtils;

import java.lang.reflect.Array;
import java.util.Collections;

public class ArrayInDB {

    private Integer author_id;
    private String quiz_id,author_name,quizname,questions;
    private Array incorrect_answers/*, correct_answers*/;

    public ArrayInDB(String quiz_id, String quizname, String author_name, Integer author_id, String questions, Array incorrect_answers/*, Array correct_answers*/) {

        this.quiz_id = quiz_id;
        this.quizname = quizname;
        this.author_name = author_name;
        this.author_id = author_id;
        this.questions = questions;
        //this.incorrect_answers = incorrect_answers;
      /*  this.correct_answers = correct_answers;*/
}

    public String getQuiz_id() {
        return quiz_id;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public String getQuizname() {
        return quizname;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public String getQuestions() {
        return questions;
    }

    public String getIncorrect_answers() {
        String str = TextUtils.join(",", Collections.singleton(incorrect_answers));
        return str;
    }


}
