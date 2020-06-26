package com.example.kyrsovaya_client_v2.ui.gallery;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kyrsovaya_client_v2.R;
import com.example.kyrsovaya_client_v2.activitys.AddQuizActivity;
import com.example.kyrsovaya_client_v2.activitys.LoginActivity;
import com.example.kyrsovaya_client_v2.activitys.RegisterActivity;
import com.example.kyrsovaya_client_v2.adapters.CreateQuizAdapter;
import com.example.kyrsovaya_client_v2.adapters.QuizAdapter;
import com.example.kyrsovaya_client_v2.api.RetrofitClient;
import com.example.kyrsovaya_client_v2.helper.SharedPrefManager;
import com.example.kyrsovaya_client_v2.models.AnswersResponse;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Intent.getIntent;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;

    RecyclerView recyclerView;
    Button add, create_quiz;
    CheckBox correct_answer;
    EditText otvet, quiz_name, question;
    TextView mew_name_quiz,new_question, incorect_answers;
    String correct;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

       /* galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);*/
       // View root = inflater.inflate(R.layout.lichnuy_kabinet, container, false);

        //startActivity(new Intent(getActivity(), AddQuizActivity.class));

        /*final TextView textView = root.findViewById(R.id.text_gallery);
        galleryViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
            return null;



    }
   /* ArrayList<String> list = new ArrayList<>();*/

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        /*recyclerView = view.findViewById(R.id.recyclerView_1);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        SharedPrefManager s=SharedPrefManager.getInstance(getContext());
        //Toast.makeText(getContext(), s.getToken(),Toast.LENGTH_SHORT).show();
        //correct_answer = view.findViewById(R.id.correct_answers);
        add = view.findViewById(R.id.add);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));




        create_quiz =  (Button)  view.findViewById( R.id.create_quiz);
        quiz_name =  (EditText)   view.findViewById( R.id.nameofquiz);
        question =  (EditText)   view.findViewById( R.id.question);
        otvet = (EditText)  view.findViewById(R.id.otvet);



        create_quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getContext(), "Добавление в базу произошло успешно!", Toast.LENGTH_SHORT).show();
                    CreateQuiz();



            }
        });


        // String[] array = {"Привет","Пока","Стой"};
        //ArrayList<String> list = new ArrayList<>();
        CreateQuizAdapter createQuizAdapter = new CreateQuizAdapter(list);
        recyclerView.setAdapter(createQuizAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));



        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(otvet.getText().toString().trim().length()!=0){
                    list.add(otvet.getText().toString());
                    //Log.d("23412412412412", "231231231231" + list);
                }
                else {
                    Toast.makeText(getContext(), "Введите вариант ответа.", Toast.LENGTH_SHORT).show();
                }

            }
        });*/




    }



   /* public void CreateQuiz(){


        String name_quiz = quiz_name.getText().toString().trim(); //email
        String avtor = SharedPrefManager.getInstance().getUser().getNickname();
        String quest = question.getText().toString().trim(); //password



        ArrayList<String> i = list;


        Call<AnswersResponse> call = RetrofitClient
                .getInstance()
                .getApi()
                .createQuiz(name_quiz, avtor ,quest, i , );
       // Log.d("ПРОВЕРЯЮЮЮЮЮЮ", "ПРОВЕРЯЮЮЮЮЮЮ" + name_quiz + avtor + quest + i);

        call.enqueue(new Callback<AnswersResponse>() {
            @Override
            public void onResponse(Call<AnswersResponse> call, Response<AnswersResponse> response) {

                Toast.makeText(getContext(), "Опрос успешно создан!", Toast.LENGTH_SHORT).show();


            }


            @Override
            public void onFailure(Call<AnswersResponse> call, Throwable t) {
               // Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }

        });


    }*/

   /* public void CheckBox() {

        for (int i = 0; i < list.size(); i++) {
            CheckBox cb = new CheckBox(getContext());
            cb.setOnCheckedChangeListener(new On);
            cb.setText(String.valueOf(list.get(i)));
            cb.setId(Integer.parseInt(list.get(i)));
            if (cb.isChecked())
            {
                Log.d("КУКУКУУКККУУКУ","УКУКУКУККУКУКУ" +  cb.isChecked());
                Toast.makeText(getContext(), "Галочкаааа", Toast.LENGTH_SHORT).show();
            }
            //Log.d("КУКУКУУКККУУКУ","УКУКУКУККУКУКУ" +  cb);

        }
    }*/

}
