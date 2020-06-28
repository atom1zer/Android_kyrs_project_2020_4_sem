package com.example.kyrsovaya_client_v2.adapters;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kyrsovaya_client_v2.R;
import com.example.kyrsovaya_client_v2.activitys.MainActivity;
import com.example.kyrsovaya_client_v2.activitys.PersonalQuizActivity;
import com.example.kyrsovaya_client_v2.activitys.QuizOnClickActivity;
import com.example.kyrsovaya_client_v2.models.Quiz;
import com.example.kyrsovaya_client_v2.ui.home.HomeFragment;


import java.util.ArrayList;
import java.util.List;

public class QuizAdapter extends RecyclerView.Adapter<QuizAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private List<Quiz> quiz;
    private Context mCtx;

    public QuizAdapter(Context mCtx, List<Quiz> quiz) {
        this.quiz = quiz;
        this.mCtx = mCtx;
        this.inflater = LayoutInflater.from(mCtx);
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.recycleview_quiz, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(QuizAdapter.ViewHolder holder, int position) {


        final Quiz quizz = quiz.get(position);
        holder.quiz_nameView.setText(quizz.getQuizname());
        holder.author_nameView.setText(quizz.getAuthor_name());
        holder.id.setText(quizz.getQuiz_id());


        final Context context = holder.cardView.getContext();
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Context context = view.getContext();
                Intent inten = new Intent(context, PersonalQuizActivity.class);
                inten.putExtra("ID", quizz.getQuiz_id().toString());
                context.startActivity(inten);

            }

        });
    }

    @Override
    public int getItemCount() {
        return quiz.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final TextView author_nameView, quiz_nameView, id;
        final CardView cardView;

        ViewHolder(View view){
            super(view);
            author_nameView = (TextView) view.findViewById(R.id.author_name);
            quiz_nameView = (TextView) view.findViewById(R.id.quiz_name);
            id = (TextView) view.findViewById(R.id.author_id);
            cardView = (CardView) view.findViewById(R.id.card);
        }

    }

}
