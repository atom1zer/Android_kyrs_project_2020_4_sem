package com.example.kyrsovaya_client_v2.fragments;

import android.app.Application;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kyrsovaya_client_v2.R;
import com.example.kyrsovaya_client_v2.adapters.CreateQuizAdapter;
import com.example.kyrsovaya_client_v2.helper.SharedPrefManager;

import java.util.ArrayList;

public class KabinetFragment extends Fragment {
    RecyclerView recyclerView;
    Button add;
    EditText otvet;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.lichnuy_kabinet, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerView_1);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        SharedPrefManager s=SharedPrefManager.getInstance(getContext());
        //Toast.makeText(getContext(), s.getToken(),Toast.LENGTH_SHORT).show();

        add = view.findViewById(R.id.add);
        otvet = view.findViewById(R.id.otvet);

       // String[] array = {"Привет","Пока","Стой"};
        ArrayList<String> list = new ArrayList<>();
        CreateQuizAdapter createQuizAdapter = new CreateQuizAdapter(list);
        recyclerView.setAdapter(createQuizAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(otvet.getText().toString().trim().length()!=0){
                    list.add(otvet.getText().toString());
                }
                else {
                    Toast.makeText(getContext(), "Введите вариант ответа.", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
