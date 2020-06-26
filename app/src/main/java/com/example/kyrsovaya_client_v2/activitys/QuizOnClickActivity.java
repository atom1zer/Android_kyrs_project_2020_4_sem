package com.example.kyrsovaya_client_v2.activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kyrsovaya_client_v2.R;
import com.example.kyrsovaya_client_v2.api.RetrofitClient;
import com.example.kyrsovaya_client_v2.helper.SharedPrefManager;
import com.example.kyrsovaya_client_v2.models.AnswersResponse;
import com.example.kyrsovaya_client_v2.models.ArrayInDB;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuizOnClickActivity  extends Activity  {


    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<ArrayInDB> answertList;

    public final static String NAME = "NAME";
    public TextView name;
    public final static String NAME_OF_QUIZ = "NAME_OF_QUIZ";
    public TextView name_of_quiz;

    public static String id;

   /* public final static String QUESTIONS = "QUESTIONS";
    public TextView questions;
    public final static String INCORRECT_ANSWERS = "INCORRECT_ANSWERS";
    public TextView incorrect_answers;*/

    /*public static void ID(){
        Intent i = getIntent();
        id = i.getStringExtra("id");
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.click_on_quiz);


        name = findViewById(R.id.DETAILS_name);
        name.setText(getIntent().getStringExtra("NAME"));
        name_of_quiz = findViewById(R.id.name_of_quiz);
        name_of_quiz.setText(getIntent().getStringExtra("NAME_OF_QUIZ"));
       /* recyclerView = (RecyclerView) findViewById(R.id.recyclerView_1);
        //recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        SharedPrefManager s=SharedPrefManager.getInstance(getApplicationContext());
        Call<AnswersResponse> call = RetrofitClient.getInstance().getApi().getArray(s.getToken());

        call.enqueue(new Callback<AnswersResponse>() {
            @Override
            public void onResponse(Call<AnswersResponse> call, Response<AnswersResponse> response) {

                answertList = response.body().getAnswers();
                adapter = new AnswersAdapter(getActivity(), answertList);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<AnswersResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(),Toast.LENGTH_SHORT).show();

            }


        });*/




        }
}
