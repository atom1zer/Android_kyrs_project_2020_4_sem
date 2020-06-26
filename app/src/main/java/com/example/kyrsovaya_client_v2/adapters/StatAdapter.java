package com.example.kyrsovaya_client_v2.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kyrsovaya_client_v2.R;
import com.example.kyrsovaya_client_v2.models.Quiz;
import com.example.kyrsovaya_client_v2.models.Stat;

import java.util.List;

public class StatAdapter extends RecyclerView.Adapter<StatAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private Context mCtx;
    private List<Stat> stat;

    public StatAdapter(Context mCtx, List<Stat> stat){

        this.stat = stat;
        this.mCtx = mCtx;
        this.inflater = LayoutInflater.from(mCtx);
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.for_stat, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final Stat statt = stat.get(position);
        holder.login.setText(statt.getLogin());
        Log.d("33333333", "2222222 " + statt.getLogin());
        holder.count.setText(statt.getStatistics());
        Log.d("33333333", "2222222 " + statt.getStatistics());

    }

    @Override
    public int getItemCount() {
        return stat.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        final TextView login, count;

        public ViewHolder(View view) {
            super(view);

            login = (TextView) view.findViewById(R.id.stat_login);
            count = (TextView) view.findViewById(R.id.stat_count);
        }
    }
}
