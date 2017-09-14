package com.example.femmy.finalretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Select_Sleeves extends AppCompatActivity {

    GridView gridView;
    public SleevesAdapter sleevesAdapter;
    ArrayList<SleevesItem> list_sleeves;
    SleevesItem item_sleeves;
    String url = "http://192.168.0.103";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select__sleeves);
        getSupportActionBar().setTitle("Select SLEEVES");

        gridView = (GridView) findViewById(R.id.grid_sleeves);

        list_sleeves = new ArrayList<SleevesItem>();

        SleeveDetail();
    }

    public void SleeveDetail() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        REGAPI services = retrofit.create(REGAPI.class);
        Call<List<SleeveDetail>> call = services.SleeveDetail();
        call.enqueue(new Callback<List<SleeveDetail>>() {
            @Override
            public void onResponse(Call<List<SleeveDetail>> call, Response<List<SleeveDetail>> response) {

                for (int i = 0; i < response.body().size(); i++) {

                    item_sleeves = new SleevesItem();

                    item_sleeves.setSleeves_name(response.body().get(i).getSleevePatternName());
                    item_sleeves.setSleeves_image(response.body().get(i).getSleevePatternImage());

                    Log.e(">>>>>>>",""+response.body().get(i).getSleevePatternName());
                    Log.e(">>>>>>>",""+response.body().get(i).getSleevePatternImage());

                    list_sleeves.add(item_sleeves);
                    sleevesAdapter= new SleevesAdapter(getApplicationContext(),list_sleeves);
                    gridView.setAdapter(sleevesAdapter);
            }

            }

            @Override
            public void onFailure(Call<List<SleeveDetail>> call, Throwable t) {

            }
        });
    }
}


