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

public class Select_Extras extends AppCompatActivity {

    GridView gridView;
    public ExtrasAdapter extrasAdapter;
    ExtrasItem item_extras;
    ArrayList<ExtrasItem> list_extras;
    String url = "http://192.168.0.103";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select__extras);

        getSupportActionBar().setTitle("Select EXTRAS");


        gridView=(GridView)findViewById(R.id.grid_extras);

        list_extras=new ArrayList<ExtrasItem>();

        ExtraDetail();
    }

    public void ExtraDetail()
    {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        REGAPI services =  retrofit.create(REGAPI.class);
        Call<List<ExtraDetail>> call = services.ExtraDetail();

        call.enqueue(new Callback<List<ExtraDetail>>() {
            @Override
            public void onResponse(Call<List<ExtraDetail>> call, Response<List<ExtraDetail>> response) {
                for (int i = 0; i < response.body().size(); i++) {

                    item_extras = new ExtrasItem();

                    item_extras.setExtras_name(response.body().get(i).getOtherPatternName());
                    item_extras.setExtras_price(response.body().get(i).getExtrasPrice());
                    item_extras.setExtras_image(response.body().get(i).getOtherPatternImage());

                    Log.e(">>>>>>>", "" + response.body().get(i).getOtherPatternName());
                    Log.e(">>>>>>>", "" + response.body().get(i).getExtrasPrice());

                    list_extras.add(item_extras);
                    extrasAdapter = new ExtrasAdapter(getApplicationContext(), list_extras);
                    gridView.setAdapter(extrasAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<ExtraDetail>> call, Throwable t) {

            }
        });
    }
}
