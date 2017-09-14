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

public class Select_Bottom extends AppCompatActivity {

    GridView gridView;
    public BottomAdapter bottomAdapter;
    ArrayList<BottomItem> list_bottom;
    BottomItem item_bottom;
    String url="http://192.168.0.103";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select__bottom);
        getSupportActionBar().setTitle("Select BOTTOM");

        gridView=(GridView)findViewById(R.id.grid_bottom);
        list_bottom=new ArrayList<BottomItem>();

        BottomDetail();
    }

    public void BottomDetail()
    {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        REGAPI services = retrofit.create(REGAPI.class);
        Call<List<BottomDetail>> call = services.BottomDetail();

        call.enqueue(new Callback<List<BottomDetail>>() {
            @Override
            public void onResponse(Call<List<BottomDetail>> call, Response<List<BottomDetail>> response) {

                for(int i =0;i<response.body().size();i++)
                {
                    item_bottom=new BottomItem();
                    item_bottom.setBottom_name(response.body().get(i).getBottomPatternName());
                    item_bottom.setBottom_image(response.body().get(i).getBottomPatternImage());

                    Log.e(">>>",""+ response.body().get(i).getBottomPatternImage());
                    Log.e(">>>",""+response.body().get(i).getBottomPatternName());

                    list_bottom.add(item_bottom);

                    bottomAdapter = new BottomAdapter(getApplicationContext(),list_bottom);
                    gridView.setAdapter(bottomAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<BottomDetail>> call, Throwable t) {

            }
        });
    }
}
