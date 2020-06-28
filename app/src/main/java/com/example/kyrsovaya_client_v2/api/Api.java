package com.example.kyrsovaya_client_v2.api;


import com.example.kyrsovaya_client_v2.models.AnswersResponse;
import com.example.kyrsovaya_client_v2.models.Data;
import com.example.kyrsovaya_client_v2.models.QuizResponse;
import com.example.kyrsovaya_client_v2.models.Stat;
import com.example.kyrsovaya_client_v2.models.User;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Api {


    @FormUrlEncoded
    @POST("register")
    Call<ResponseBody> createUser(
            @Field("email") String email, //email
            @Field("login") String login, //логин
            @Field("password") String password //пароль

    );

    @FormUrlEncoded
    @POST("login")
    Call<Data> getUserByInput(
            @Field("email") String email, //email
            @Field("password") String password,//пароль
            @Query("token") String token
    );

    @FormUrlEncoded
    @POST("createquiz")
    Call<AnswersResponse> createQuiz(
            @Field("quizname") String quizname,
            @Field("author_id") Integer author_id,
            @Field("author_name") String author_name,
            @Field("questions") String questions,
            @Field("incorrect_answers") ArrayList<String> incorrect_answers,
            @Field("correct_answers") String correct_answers
    );

    @FormUrlEncoded
    @POST("result")
    Call<AnswersResponse> createResult(
            @Field("userID") Integer userID,
            @Field("quizID") String quiz_id,
            @Field("correct") String correct
    );

    @GET("quiz")
    Call<QuizResponse> getQuizzes(
            @Query("token") String token
    );

    @GET("quiz")
    Call<AnswersResponse> getArray(
            @Query("token") String token
    );

    @GET("users")
    Call<User> getUsers(
            @Query("token") String token
    );

    @GET("statistics")
    Call<Stat> getStat(

    );

   @GET("quiz/{SIZE}")
   Call<AnswersResponse> getAnswer(
            @Path("SIZE") Integer SIZE,
            @Query("token") String token
    );

}