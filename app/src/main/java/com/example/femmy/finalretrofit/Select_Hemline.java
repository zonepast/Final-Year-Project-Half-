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

public class Select_Hemline extends AppCompatActivity {

    GridView gridView;
    ArrayList<HemlineItem> list_hemline;
    public HemlineAdapter hemlineAdapter;
    HemlineItem item_hemline;
    String url="http://192.168.0.103";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select__hemline);
        getSupportActionBar().setTitle("Select HEMLINE");

        gridView=(GridView)findViewById(R.id.grid_hemline);

        list_hemline = new ArrayList<HemlineItem>();

        HemlineDetail();
    }

    public void HemlineDetail()
    {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        REGAPI services = retrofit.create(REGAPI.class);
        Call<List<HemlineDetail>> call = services.HemlineDetail();
        call.enqueue(new Callback<List<HemlineDetail>>() {
            @Override
            public void onResponse(Call<List<HemlineDetail>> call, Response<List<HemlineDetail>> response) {
                for (int i = 0; i < response.body().size(); i++) {

                    item_hemline = new HemlineItem();

                    item_hemline.setHemline_name(response.body().get(i).getHemlinePatternName());
                    item_hemline.setHemline_image(response.body().get(i).getHemlinePatternImage());

                    Log.e(">>>>>>>",""+response.body().get(i).getHemlinePatternName());
                    Log.e(">>>>>>>",""+response.body().get(i).getHemlinePatternImage());

                    list_hemline.add(item_hemline);
                    hemlineAdapter= new HemlineAdapter(getApplicationContext(),list_hemline);
                    gridView.setAdapter(hemlineAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<HemlineDetail>> call, Throwable t) {

            }
        });
    }
}
