package com.example.kyrsovaya_client_v2.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kyrsovaya_client_v2.R;
import com.example.kyrsovaya_client_v2.activitys.ChatListActivity;
import com.example.kyrsovaya_client_v2.adapters.QuizAdapter;
import com.example.kyrsovaya_client_v2.api.RetrofitClient;
import com.example.kyrsovaya_client_v2.helper.SharedPrefManager;
import com.example.kyrsovaya_client_v2.models.Quiz;
import com.example.kyrsovaya_client_v2.models.QuizResponse;
import com.example.kyrsovaya_client_v2.models.User;
import com.example.kyrsovaya_client_v2.models.UsersResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private List<Quiz> quizList;
    private QuizAdapter adapter;
   // private ListView listView;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_fragment, container, false);

    }

    //ListView list = (ListView) listView.findViewById(R.id.list);

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //ChatListActivity.Spisok();

        /*Call<List<Quiz>> call = RetrofitClient.getInstance().getApi().getQuizzes();

        call.enqueue(new Callback<List<Quiz>>() {
            @Override
            public void onResponse(Call<List<Quiz>> call, Response<List<Quiz>> response) {
                List<Quiz> quiz = response.body();
                String[] quiznames = new String[quiz.size()];

                for(int i = 0; i<quiz.size(); i++)
                {
                    quiznames[i] = quiz.get(i).getQuizname();
                }
                list.setAdapter(
                        new ArrayAdapter<String>(
                                getApplicationContext(),
                                android.R.layout.simple_list_item_1,
                                quiznames
                        )
                );
                // Log.d("123", "Пока");

                for(Quiz q:quiz)
                {
                    Log.d("quizname", q.getQuizname());
                }
            }

            @Override
            public void onFailure(Call<List<Quiz>> call, Throwable t) {
                Log.d("Беда", "БЕДА!!!!!!!!!!!!!!!!!!!!!!!!!!");
            }
        });*/
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        SharedPrefManager s=SharedPrefManager.getInstance(getContext());
       //Toast.makeText(getContext(), s.getToken(),Toast.LENGTH_SHORT).show();
        Call<QuizResponse> call = RetrofitClient.getInstance().getApi().getQuizzes(s.getToken());

        call.enqueue(new Callback<QuizResponse>() {
            @Override
            public void onResponse(Call<QuizResponse> call, Response<QuizResponse> response) {

                quizList = response.body().getQuiz();
                adapter = new QuizAdapter(getActivity(), quizList);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<QuizResponse> call, Throwable t) {

                Toast.makeText(getContext(), t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });

    }

}
