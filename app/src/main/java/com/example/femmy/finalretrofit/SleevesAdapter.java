package com.example.femmy.finalretrofit;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by FAMY on 01-Apr-17.
 */

public class SleevesAdapter extends BaseAdapter {

    Context context;
    ArrayList<SleevesItem> list_sleeves;
    private static LayoutInflater inflater=null;
    SleevesItem item_sleeves;
    String url = "http://192.168.0.103/dd/crop/sleeves/";

    public SleevesAdapter(Context context,ArrayList<SleevesItem> list)
    {
        this.context=context;
        this.list_sleeves=list;

        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return list_sleeves.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public class Holder
    {
        TextView sleeves_name;
        ImageView sleeves_image;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {

        item_sleeves = list_sleeves.get(i);

        Holder holder= new Holder();
        View row;
        row = inflater.inflate(R.layout.single_grid_sleeves,null);
        holder.sleeves_name=(TextView)row.findViewById(R.id.pattern_name);
        holder.sleeves_image=(ImageView)row.findViewById(R.id.pattern_image);

        Log.e(">>>>>", item_sleeves.getSleeves_name()+ " : " + item_sleeves.getSleeves_image());

        holder.sleeves_name.setText(item_sleeves.getSleeves_name());

        Log.e(">>>>>", url + item_sleeves.getSleeves_image());

        Picasso.with(context)
                .load(url + item_sleeves.getSleeves_image())
                .into(holder.sleeves_image);

        row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SleevesItem item = list_sleeves.get(i);

                Toast.makeText(context,"You Selected" + item.getSleeves_name(),Toast.LENGTH_LONG).show();

                Intent i = new Intent(context,Select_Bottom.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                i.putExtra("Pattern",item_sleeves.getSleeves_image());
                context.startActivity(i);
            }
        });

        return row;
    }
}
