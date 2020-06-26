package com.example.kyrsovaya_client_v2.helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;


import com.example.kyrsovaya_client_v2.models.Quiz;
import com.example.kyrsovaya_client_v2.models.User;

public class SharedPrefManager {

    private static final String SHARED_PREF_NAME ="my_shared_preff";

    private static SharedPrefManager mInstance;
    private Context mCtx;

    private SharedPrefManager(Context mCtx){
        this.mCtx = mCtx;
    }



    public static synchronized SharedPrefManager getInstance(Context mCtx){
        if (mInstance == null){
            mInstance = new SharedPrefManager(mCtx);
        }
        return mInstance;
    }
    public static synchronized SharedPrefManager getInstance(){
        if (mInstance == null){
            Log.d("messageshared","instance not initilized");
        }
        return mInstance;
    }
    public void saveUser(User user){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt("id", user.getId());
        editor.putString("login", user.getLogin());
        editor.putString("email", user.getNickname());

        editor.apply();
    }

    public boolean isLoggedIn(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getInt("id", -1) != -1;
    }

    public String LoginReq(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return String.valueOf(sharedPreferences.getString("login", null) != null);
    }



    public User getUser(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return new User(
                sharedPreferences.getInt("id", -1),
                sharedPreferences.getString("login",  null),
                sharedPreferences.getString("email", null)
        );
    }

    public Quiz getQuiz(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return new Quiz(
                sharedPreferences.getString("quiz_id", null),
                sharedPreferences.getString("author_id", null),
                sharedPreferences.getString("quizname", null),
                sharedPreferences.getString("author_name", null)
                //sharedPreferences.getString("questions", null),
                //sharedPreferences.getString("incorrect_answers", null),
                //sharedPreferences.getString("correct_answers", null)
        );
    }

    public void saveToken(String token){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("token", token);

        editor.apply();
    }

    public String getToken(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return
                sharedPreferences.getString("token", null);

    }


    public void clear(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }

}

