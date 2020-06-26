package com.example.kyrsovaya_client_v2.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kyrsovaya_client_v2.R;
import com.example.kyrsovaya_client_v2.models.ArrayInDB;
import com.example.kyrsovaya_client_v2.models.Quiz;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class PersonalQuizAdapter extends RecyclerView.Adapter<PersonalQuizAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private List<String> answers;
    private Context mCtx;

    public PersonalQuizAdapter (Context mCtx, List<String> answers){
        this.answers = answers;
        this.mCtx = mCtx;
        this.inflater = LayoutInflater.from(mCtx);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.shablon_answers, parent, false);
        return new ViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        String arrayy = answers.get(position);
        holder.answer.setText(arrayy);

    }


    @Override
    public int getItemCount() {
        return answers.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        final TextView answer,  author_nameView, quiz_nameView,  questionsView, id;

        ViewHolder(View view){
            super(view);
            answer = (TextView) view.findViewById(R.id.answers_fragm);
            //pravilno = view.findViewById(R.id.checkBox);
            author_nameView = (TextView) view.findViewById(R.id.DETAILS_name);
            quiz_nameView = (TextView) view.findViewById(R.id.name_of_quiz);
            questionsView = (TextView) view.findViewById(R.id.questions);
            id = (TextView) view.findViewById(R.id.hidden_ID);

        }


    }

}
