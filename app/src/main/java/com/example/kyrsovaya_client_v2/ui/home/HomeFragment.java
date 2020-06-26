package com.example.kyrsovaya_client_v2.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kyrsovaya_client_v2.R;
import com.example.kyrsovaya_client_v2.adapters.QuizAdapter;
import com.example.kyrsovaya_client_v2.api.RetrofitClient;
import com.example.kyrsovaya_client_v2.helper.SharedPrefManager;
import com.example.kyrsovaya_client_v2.models.Quiz;
import com.example.kyrsovaya_client_v2.models.QuizResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    private RecyclerView recyclerView;
    private List<Quiz> quizList;
    private QuizAdapter adapter;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.home_fragment, container, false);

        return root;

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //answersView = view.findViewById(R.id.recycle_answers);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        SharedPrefManager s=SharedPrefManager.getInstance(getContext());

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
