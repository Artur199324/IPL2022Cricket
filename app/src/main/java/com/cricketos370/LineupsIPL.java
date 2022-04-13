package com.cricketos370;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class LineupsIPL extends AppCompatActivity {
    String id;
    private String name;
    private String role;
    private String battingStyle;
    private String bowlingStyle;
    private String country;
    private String playerImg;
    ArrayList<Players> arrayListPlayers;
    RecyclerView recyclerPlaers;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lineups);
        id = getIntent().getStringExtra("id");
        recyclerPlaers = findViewById(R.id.recyclerPlaers);
        recyclerPlaers.setLayoutManager(new LinearLayoutManager(this));
        arrayListPlayers = new ArrayList<>();

        new Thread(new Runnable() {
            @Override
            public void run() {
               try {
                   HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://api.cricapi.com/v1/match_squad?apikey=ad3ceb64-e5b1-4fa9-8c13-7abd6c9ed944&offset=0&id=" + id).openConnection();
                   BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                   String api = bufferedReader.readLine();
                   JSONObject jsonObject = new JSONObject(api);
                   JSONArray jsonArrayplayers = jsonObject.getJSONArray("data");

                   for (int i = 0; i<jsonArrayplayers.length();i++){
                       JSONObject jsonObjectplayers = jsonArrayplayers.getJSONObject(i);
                       JSONArray jsonArrayplayer = new JSONArray(jsonObjectplayers.getString("players"));
                       for (int a = 0 ; a < jsonArrayplayer.length();a++){
                           JSONObject jsonObjectplayer =  jsonArrayplayer.getJSONObject(a);

                           name = jsonObjectplayer.getString("name");
                           role = jsonObjectplayer.getString("role");
                           battingStyle = jsonObjectplayer.getString("battingStyle");
                           bowlingStyle = jsonObjectplayer.getString("bowlingStyle");
                           country = jsonObjectplayer.getString("country");
                           playerImg = jsonObjectplayer.getString("playerImg");

                           Log.d("weq",name);
                           Log.d("weq",role);
                           Log.d("weq",battingStyle);
                           Log.d("weq",bowlingStyle);
                           Log.d("weq",country);
                           Log.d("weq",playerImg);
                           Players players = new Players();
                           players.setName(name);
                           players.setRole(role);
                           players.setBattingStyle(battingStyle);
                           players.setBowlingStyle(bowlingStyle);
                           players.setCountry(country);
                           players.setPlayerImg(playerImg);
                           arrayListPlayers.add(players);

                           runOnUiThread(new Runnable() {
                               @Override
                               public void run() {
                                   PlayersAdapter playersAdapter= new PlayersAdapter(LineupsIPL.this,arrayListPlayers);
                                   recyclerPlaers.setAdapter(playersAdapter);
                               }
                           });
                       }
                   }

               }catch (Exception e){

               }
            }
        }).start();
    }
}
