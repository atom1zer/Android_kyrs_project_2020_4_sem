package com.example.kyrsovaya_client_v2.models;

public class User {

    private int id, quiz_id, author_id;
    private String email, login, quizname, questions, incorrect_answers, correct_answers;

    public User(int id, String email, String login) {
        this.id = id;
        this.email = email;
        this.login = login;
    }



    public int getId() {
        return id;
    }

    public String getNickname() {
        return email;
    }

    public String getLogin() {
        return login;
    }
}


