package com.example.femmy.finalretrofit;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Dashboard extends AppCompatActivity {

    public RecyclerAdapter adapter;
    private List<Listitem> listitems;
    public RecyclerView recyclerView;
    Listitem item;
    String url = "http://192.168.0.103";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        getSupportActionBar().setTitle("Select PRODUCT");

        //recyclerView.setHasFixedSize(true);
        recyclerView = (RecyclerView) findViewById(R.id.recycleview);

            listitems = new ArrayList<>();

        GarmentDetails();
    }

    public void GarmentDetails() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        REGAPI services = retrofit.create(REGAPI.class);
        Call<List<GarmentDetail>> call = services.GarmentDetails();

        call.enqueue(new Callback<List<GarmentDetail>>() {
            @Override
            public void onResponse(Call<List<GarmentDetail>> call, Response<List<GarmentDetail>> response) {
                //Log.e(">>>>>>>>>>", "" + response.body().size());

                for (int i = 0; i < response.body().size(); i++) {

                    item = new Listitem();

                    item.setName(response.body().get(i).getName());
                    item.setImage(response.body().get(i).getImage());
                    item.setPattern(response.body().get(i).getPattern());
                    item.setPrice(response.body().get(i).getPrice());
                    item.setQuantity(response.body().get(i).getQuantity());

                    Log.e(">>>>>>>>>>", "" + response.body().get(i).getName());
                    Log.e(">>>>>>>>>>", "" + response.body().get(i).getImage());
                    Log.e(">>>>>>>>>>", "" + response.body().get(i).getPattern());
                    Log.e(">>>>>>>>>", "" + response.body().get(i).getQuantity());
                    Log.e(">>>>>>>>>", "" + response.body().get(i).getPrice());
                    listitems.add(item);
                }

                adapter = new RecyclerAdapter(listitems, getApplicationContext());
                LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
                //recyclerView.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(llm);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<GarmentDetail>> call, Throwable t) {

            }
        });
    }
}

