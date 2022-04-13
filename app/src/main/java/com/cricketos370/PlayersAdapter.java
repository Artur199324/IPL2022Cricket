package com.cricketos370;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PlayersAdapter extends  RecyclerView.Adapter<PlayersAdapter.PlayersAdapterHolder>{

    Context context;
    ArrayList<Players> arrayListPlayers;

    public PlayersAdapter(Context context, ArrayList<Players> arrayListPlayers) {
        this.context = context;
        this.arrayListPlayers = arrayListPlayers;
    }

    @NonNull
    @Override
    public PlayersAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.plaers_item, parent, false);
        return new PlayersAdapterHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlayersAdapterHolder holder, int position) {
        Players players = arrayListPlayers.get(position);

        holder.textViewNameP.setText(players.getName());
        holder.textViewrole.setText(players.getRole());
        holder.textViewbattingStyle.setText(players.getBattingStyle());
        holder.textViewbowlingStyle.setText(players.getBowlingStyle());
        holder.textViewcountry.setText(players.getCountry());
        String url = players.getPlayerImg();
        Picasso.get().load(url).fit().centerInside().into(holder.imageViewPla);
    }

    @Override
    public int getItemCount() {
        return arrayListPlayers.size();
    }

    public class PlayersAdapterHolder extends RecyclerView.ViewHolder{

        ImageView imageViewPla;
        TextView textViewNameP,textViewrole,textViewbattingStyle,textViewbowlingStyle,textViewcountry;

        public PlayersAdapterHolder(@NonNull View itemView) {
            super(itemView);
            imageViewPla = itemView.findViewById(R.id.imageViewPla);
            textViewNameP = itemView.findViewById(R.id.textViewNameP);
            textViewrole = itemView.findViewById(R.id.textViewrole);
            textViewbattingStyle = itemView.findViewById(R.id.textViewbattingStyle);
            textViewbowlingStyle = itemView.findViewById(R.id.textViewbowlingStyle);
            textViewcountry = itemView.findViewById(R.id.textViewcountry);
        }
    }
}
