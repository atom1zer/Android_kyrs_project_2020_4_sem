package com.example.kyrsovaya_client_v2.models;

public class LoginResponse {


    private boolean status;
    private User data;




    public LoginResponse(boolean status, User data) {
        this.status = status;
        this.data = data;


    }

    public boolean isStatus() {
        return status;
    }

    public User getData() {
        return data;
    }

}
