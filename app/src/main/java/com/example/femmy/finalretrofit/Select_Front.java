package com.example.femmy.finalretrofit;

import android.content.Context;
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

public class Select_Front extends AppCompatActivity {

    GridView gridview;
    public Gridadapter gridadapter;
    ArrayList<SingleItem> list_front;
   SingleItem item;
    String url = "http://192.168.0.103";
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select__front);

        getSupportActionBar().setTitle("Select FRONT");

        gridview = (GridView) findViewById(R.id.grid);

        list_front=new ArrayList<SingleItem>();

       /* Intent i = new Intent(context,Select_Back.class);
        i.putExtra("Pattern",item.getPattern_front());
        context.startActivity(i);
*/

       PatternDetail();
    }


    public void PatternDetail() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        REGAPI services = retrofit.create(REGAPI.class);

        Call<List<PatternDetail>> call = services.PatternDetails();

        call.enqueue(new Callback<List<PatternDetail>>() {
            @Override
            public void onResponse(Call<List<PatternDetail>> call, Response<List<PatternDetail>> response) {

                for (int i = 0; i < response.body().size(); i++) {

                    item = new SingleItem();

                    item.setFront_names(response.body().get(i).getCaption());
                    item.setPattern_front(response.body().get(i).getPatternImage());

                    Log.e(">>>>>>>",""+response.body().get(i).getCaption());
                    Log.e(">>>>>>>",""+response.body().get(i).getPatternImage());

                    list_front.add(item);
                    gridadapter= new Gridadapter(getApplicationContext(),list_front);
                    gridview.setAdapter(gridadapter);
                }
            }

            @Override
            public void onFailure(Call<List<PatternDetail>> call, Throwable t) {

            }
        });


    }
}


