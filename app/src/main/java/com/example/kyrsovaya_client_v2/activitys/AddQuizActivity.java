package com.example.kyrsovaya_client_v2.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kyrsovaya_client_v2.R;
import com.example.kyrsovaya_client_v2.adapters.CreateQuizAdapter;
import com.example.kyrsovaya_client_v2.api.RetrofitClient;
import com.example.kyrsovaya_client_v2.helper.SharedPrefManager;
import com.example.kyrsovaya_client_v2.models.AnswersResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddQuizActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    Button add, create_quiz;
    EditText otvet, quiz_name, question, correct_answer;
    TextView mew_name_quiz,new_question, incorect_answers;
    ArrayList<String> list = new ArrayList<>();
    String m;
    public final static String CORRECT = "CORRECT_ANSWER";



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lichnuy_kabinet);
        setTitle("Создание опроса");

        recyclerView = findViewById(R.id.recyclerView_1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        SharedPrefManager s=SharedPrefManager.getInstance(AddQuizActivity.this);
        //Toast.makeText(getContext(), s.getToken(),Toast.LENGTH_SHORT).show();
        //correct_answer = view.findViewById(R.id.correct_answers);
        add = findViewById(R.id.add);



        recyclerView.setLayoutManager(new LinearLayoutManager(AddQuizActivity.this));




        create_quiz =  (Button)  findViewById( R.id.create_quiz);
        quiz_name =  (EditText)   findViewById( R.id.nameofquiz);
        question =  (EditText)   findViewById( R.id.question);
        otvet = (EditText)  findViewById(R.id.otvet);
        correct_answer = (EditText)  findViewById(R.id.correct);



        create_quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getContext(), "Добавление в базу произошло успешно!", Toast.LENGTH_SHORT).show();
               CreateQuiz();

                quiz_name.setText("");
                question.setText("");
                correct_answer.setText("");


            }
        });


        // String[] array = {"Привет","Пока","Стой"};
        //ArrayList<String> list = new ArrayList<>();
        CreateQuizAdapter createQuizAdapter = new CreateQuizAdapter(list);
        recyclerView.setAdapter(createQuizAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(AddQuizActivity.this));





        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(otvet.getText().toString().trim().length()!=0){

                   if (list.contains(otvet.getText().toString().trim())){
                        Toast.makeText(AddQuizActivity.this, "Уже существует!", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        list.add(otvet.getText().toString());
                        otvet.setText("");
                    }



                    //Log.d("23412412412412", "231231231231" + list);
                }
                else {
                    Toast.makeText(AddQuizActivity.this, "Введите вариант ответа.", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

     public void CreateQuiz(){



        Intent intent=getIntent();
        m=intent.getExtras().getString("CORRECT_ANSWER"/*, "defaultKey"*/);
        Log.d("СМОТРИИИИИ","СМОТРИИИИИ" + m);

         String name_quiz = quiz_name.getText().toString().trim(); //email
         String avtor = SharedPrefManager.getInstance().getUser().getNickname(); //имя автора опроса
         String quest = question.getText().toString().trim(); //password
         String correct = correct_answer.getText().toString().trim(); //правильный ответ
         Integer id = SharedPrefManager.getInstance().getUser().getId();
         Log.d("546456459456645654", "1455616156151566" + id);



        ArrayList<String> i = list;
        //ArrayList<String> m = cor;


        Call<AnswersResponse> call = RetrofitClient
                .getInstance()
                .getApi()
                .createQuiz(name_quiz, id ,avtor ,quest, i , correct);
        // Log.d("ПРОВЕРЯЮЮЮЮЮЮ", "ПРОВЕРЯЮЮЮЮЮЮ" + name_quiz + avtor + quest + i);

        call.enqueue(new Callback<AnswersResponse>() {
            @Override
            public void onResponse(Call<AnswersResponse> call, Response<AnswersResponse> response) {

                Toast.makeText(AddQuizActivity.this, "Опрос успешно создан!", Toast.LENGTH_SHORT).show();


            }


            @Override
            public void onFailure(Call<AnswersResponse> call, Throwable t) {
                 Toast.makeText(AddQuizActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }

        });


    }

}
