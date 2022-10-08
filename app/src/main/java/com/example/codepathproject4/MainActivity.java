package com.example.codepathproject4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView list;
    ArrayList<recyclerJoin> join = new ArrayList<>();
    Button add;
    JSONObject movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = findViewById(R.id.list);

                setJoin();
                listAdapter adapter = new listAdapter(MainActivity.this, join);
                list.setAdapter(adapter);
                list.setLayoutManager(new LinearLayoutManager(MainActivity.this));

    }
    public void setJoin(){
        Request postRequest = new Request.Builder()
                .url("https://api.themoviedb.org/3/movie/now_playing?api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed&language=en-US&page=1")
                .build();
        new OkHttpClient()
                .newCall(postRequest)
                .enqueue(new Callback() {
                    @Override
                    public void onFailure(@NonNull okhttp3.Call call, @NonNull IOException e) {
                        //Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onResponse(@NonNull okhttp3.Call call, @NonNull Response response) throws IOException {
                        Log.i("tag", response.body().string());
                        //try {
                            String title = null;
                            String body = null;
                            String head = null;
                            try {
                                movies = new JSONObject(String.valueOf(response.body()));
                                JSONArray result = movies.getJSONArray("results");
                                title = result.getJSONObject(0).getString("original_title");
                                body = result.getJSONObject(0).getString("original_title");
                                head = result.getJSONObject(0).getString("original_title");
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            join.add(new recyclerJoin(title, body, head));

                    }
                });
    }

/*String title = null;
                        String body = null;
                        String head = null;
                        try {
                            movies = new JSONObject(String.valueOf(response.body()));
                            JSONArray result = movies.getJSONArray("results");
                            title = result.getJSONObject(0).getString("original_title");
                            body = result.getJSONObject(0).getString("original_title");
                            head = result.getJSONObject(0).getString("original_title");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        join.add(new recyclerJoin(title, body, head));
                    }
                });
    }*/
}