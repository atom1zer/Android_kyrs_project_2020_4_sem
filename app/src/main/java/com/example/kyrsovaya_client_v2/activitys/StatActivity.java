package com.example.kyrsovaya_client_v2.activitys;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kyrsovaya_client_v2.R;
import com.example.kyrsovaya_client_v2.adapters.PersonalQuizAdapter;
import com.example.kyrsovaya_client_v2.adapters.StatAdapter;
import com.example.kyrsovaya_client_v2.api.RetrofitClient;
import com.example.kyrsovaya_client_v2.helper.SharedPrefManager;
import com.example.kyrsovaya_client_v2.models.AnswersResponse;
import com.example.kyrsovaya_client_v2.models.ArrayInDB;
import com.example.kyrsovaya_client_v2.models.Quiz;
import com.example.kyrsovaya_client_v2.models.Stat;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StatActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    public TextView login, count;
    private StatAdapter adapter;
    private List<Stat> stat;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stat);
        recyclerView = findViewById(R.id.recycle_stat);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<Stat> answers = new ArrayList<>();
        SharedPrefManager s = SharedPrefManager.getInstance(this);

        Call<Stat> call = RetrofitClient.getInstance().getApi().getStat();

        call.enqueue(new Callback<Stat>() {
            @Override
            public void onResponse(Call<Stat> call, Response<Stat> response) {
                stat = response.body().getStat();
                adapter = new StatAdapter(StatActivity.this, stat);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<Stat> call, Throwable t) {
                Toast.makeText(StatActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
