package com.example.kyrsovaya_client_v2.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.text.NoCopySpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kyrsovaya_client_v2.NavigationActivity;
import com.example.kyrsovaya_client_v2.R;
import com.example.kyrsovaya_client_v2.adapters.PersonalQuizAdapter;
import com.example.kyrsovaya_client_v2.api.RetrofitClient;
import com.example.kyrsovaya_client_v2.helper.SharedPrefManager;
import com.example.kyrsovaya_client_v2.models.AnswersResponse;
import com.example.kyrsovaya_client_v2.models.ArrayInDB;
import com.example.kyrsovaya_client_v2.ui.home.HomeFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PersonalQuizActivity extends AppCompatActivity {

    String id;
    private RecyclerView recyclerView;
    private PersonalQuizAdapter adapter;


    public TextView I;
    public final static String ID_D = "ID";
    Button send;

    public TextView author_nameView, quiz_nameView, questionsView, ID;
    EditText correct;

    //List<ArrayInDB> answers = new ArrayList<>();


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Участие в опросе");
        setContentView(R.layout.click_on_quiz);
        Intent intent=getIntent();
        id=intent.getExtras().getString("ID"/*, "defaultKey"*/);//quiz_id нужное мне
        Log.d("СМОТРИИИИИ","СМОТРИИИИИ" + id);
        recyclerView = findViewById(R.id.recycle_answers);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<ArrayInDB> answers = new ArrayList<>();

        author_nameView = (TextView) findViewById(R.id.DETAILS_name);
        quiz_nameView = (TextView) findViewById(R.id.name_of_quiz);
        questionsView = (TextView) findViewById(R.id.questions);
        ID = (TextView) findViewById(R.id.hidden_ID);

        correct =  findViewById( R.id.correc);



        send = findViewById(R.id.send);
        send.setEnabled(true);




        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Send();
                v.setVisibility(View.GONE);
            }
        });


        SharedPrefManager s = SharedPrefManager.getInstance(this);



        Call<AnswersResponse> call = RetrofitClient.getInstance().getApi().getAnswer(Integer.valueOf(id),s.getToken());

        call.enqueue(new Callback<AnswersResponse>() {
            @Override
            public void onResponse(Call<AnswersResponse> call, Response<AnswersResponse> response) {


                AnswersResponse answersResponse = response.body();
                author_nameView.setText(answersResponse.getAuthor_name());
                quiz_nameView.setText(answersResponse.getQuizname());
                questionsView.setText(answersResponse.getQuestions());


                List<String> ans = answersResponse.getIncorrect_answers();

                adapter = new PersonalQuizAdapter(PersonalQuizActivity.this, ans);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<AnswersResponse> call, Throwable t) {
                Toast.makeText(PersonalQuizActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void Send(){


        String otvet = correct.getText().toString().trim();
        Integer avtor = SharedPrefManager.getInstance().getUser().getId(); //имя автора опроса


        Call<AnswersResponse> call = RetrofitClient
                .getInstance()
                .getApi()
                .createResult( avtor, id , otvet);

        call.enqueue(new Callback<AnswersResponse>() {
            @Override
            public void onResponse(Call<AnswersResponse> call, Response<AnswersResponse> response) {

                AnswersResponse answersResponse = response.body();
                if(answersResponse.isStatus()){

                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Вы ответили правильно!", Toast.LENGTH_LONG);
                    toast.show();
                }

                else if(!answersResponse.isBAN()){
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Вы уже проходили данный опрос!!!", Toast.LENGTH_LONG);
                    toast.show();

                }

                else if (answersResponse.isBAN()){

                    Toast.makeText(PersonalQuizActivity.this, "Вы ответили неправильно!", Toast.LENGTH_LONG).show();
                }

            }


            @Override
            public void onFailure(Call<AnswersResponse> call, Throwable t) {
                Toast.makeText(PersonalQuizActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }

        });


        }




}
