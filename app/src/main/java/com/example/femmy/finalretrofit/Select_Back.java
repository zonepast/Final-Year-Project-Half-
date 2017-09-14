package com.example.femmy.finalretrofit;
import android.content.Intent;
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

public class Select_Back extends AppCompatActivity {

    GridView gridView;
    public Backadapter backadapter;
    ArrayList<BackItem> list_back;
    BackItem item;
    String url="http://192.168.0.103";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select__back);
        getSupportActionBar().setTitle("Select BACK");

        gridView = (GridView)findViewById(R.id.grid_back);
        list_back=new ArrayList<BackItem>();


        BackDetail();

        }
    public void BackDetail()
    {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        REGAPI services = retrofit.create(REGAPI.class);

        Call<List<BackDetail>> call = services.BackDetail();

        call.enqueue(new Callback<List<BackDetail>>() {
            @Override
            public void onResponse(Call<List<BackDetail>> call, Response<List<BackDetail>> response) {


                for (int i=0; i < response.body().size();i++){

                    item=new BackItem();
                    item.setBack_names(response.body().get(i).getBackPatternName());
                    item.setPattern_back(response.body().get(i).getBackPatternImage());

                    Log.e(">>>",""+ response.body().get(i).getBackPatternName());
                    Log.e(">>>",""+response.body().get(i).getBackPatternImage());

                    list_back.add(item);

                    backadapter = new Backadapter(getApplicationContext(),list_back);
                    gridView.setAdapter(backadapter);

                }
            }

            @Override
            public void onFailure(Call<List<BackDetail>> call, Throwable t) {

            }
        });
    }
}
