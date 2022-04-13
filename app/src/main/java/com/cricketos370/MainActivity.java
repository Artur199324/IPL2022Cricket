package com.cricketos370;

import static com.cricketos370.IPL.navControllerIPL;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements MatchesModelIPLAdapter.OnItemClickListener {




    String id;
    String name;
    String date;
    String status;
    RecyclerView recycler;
    ArrayList<MatchesModelIPL> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycler = findViewById(R.id.recycler);
        arrayList = new ArrayList<>();
        recycler.setLayoutManager(new LinearLayoutManager(this));
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://api.cricapi.com/v1/matches?apikey=ad3ceb64-e5b1-4fa9-8c13-7abd6c9ed944&offset=0").openConnection();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                    String api = bufferedReader.readLine();
                    JSONObject jsonObject = new JSONObject(api);
                    JSONArray jsonArrayResults = jsonObject.getJSONArray("data");
                    for (int i = 0 ; i<jsonArrayResults.length(); i++){
                        JSONObject jsonObjectMac = jsonArrayResults.getJSONObject(i);
                        id = jsonObjectMac.getString("id");
                        name = jsonObjectMac.getString("name");
                        status = jsonObjectMac.getString("status");
                        date = jsonObjectMac.getString("date");
                        MatchesModelIPL matchesModelIPL = new MatchesModelIPL();
                        matchesModelIPL.setId(id);
                        matchesModelIPL.setName(name);
                        matchesModelIPL.setStatus(status);
                        matchesModelIPL.setDate(date);
                        arrayList.add(matchesModelIPL);

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                MatchesModelIPLAdapter matchesModelIPLAdapter = new MatchesModelIPLAdapter(MainActivity.this,arrayList);
                                recycler.setAdapter(matchesModelIPLAdapter);
                                matchesModelIPLAdapter.setOnItemClickListener((MatchesModelIPLAdapter.OnItemClickListener) MainActivity.this);
                            }
                        });
                    }
                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                }



            }
        }).start();
    }

    @Override
    public void onItemClick(int position) {
        MatchesModelIPL matchesModelIPL = null;

        for (int i = 0 ; i<arrayList.size();i++){

            matchesModelIPL = arrayList.get(position);

        }

        Intent intent = new Intent(getApplicationContext(),LineupsIPL.class);
        intent.putExtra("id",matchesModelIPL.getId());
        startActivity(intent);

    }
}