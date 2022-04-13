package com.cricketos370;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MatchesModelIPLAdapter extends RecyclerView.Adapter<MatchesModelIPLAdapter.MatchesModelIPLHolder> {

    Context context;
    ArrayList<MatchesModelIPL> arrayListMatches;
    private MatchesModelIPLAdapter.OnItemClickListener listener;
    public static int position;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = (MatchesModelIPLAdapter.OnItemClickListener) listener;
    }

    public MatchesModelIPLAdapter(Context context, ArrayList<MatchesModelIPL> arrayListMatches) {
        this.context = context;
        this.arrayListMatches = arrayListMatches;
    }

    @NonNull
    @Override
    public MatchesModelIPLHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.matches_item, parent, false);
        return new MatchesModelIPLHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MatchesModelIPLHolder holder, int position) {

        MatchesModelIPL matchesModelIPL = arrayListMatches.get(position);
        String name = matchesModelIPL.getName();
        String date = matchesModelIPL.getDate();
        String status = matchesModelIPL.getStatus();
        holder.textViewname.setText(name);
        holder.textViewdate.setText(date);
        holder.textViewstatus.setText(status);


    }

    @Override
    public int getItemCount() {
        return arrayListMatches.size();
    }

    public class MatchesModelIPLHolder extends RecyclerView.ViewHolder {

        TextView textViewname, textViewdate, textViewstatus;

        public MatchesModelIPLHolder(@NonNull View itemView) {
            super(itemView);
            textViewname = itemView.findViewById(R.id.textViewname);
            textViewdate = itemView.findViewById(R.id.textViewdate);
            textViewstatus = itemView.findViewById(R.id.textViewstatus);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
