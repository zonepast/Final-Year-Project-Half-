package com.example.femmy.finalretrofit;

import android.app.Activity;
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
 * Created by FAMY on 28-Mar-17.
 */

public class Backadapter extends BaseAdapter {
    ArrayList<BackItem> list;
    Context context;
    BackItem item;
    SleevesItem item_sleeve;
    String url = "http://192.168.0.103/dd/crop/back/urban/";
    private static LayoutInflater inflater=null;

   public Backadapter(Context context, ArrayList<BackItem> list)
    {
        this.context=context;
        this.list=list;

        inflater = ( LayoutInflater )context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return list.size();
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
        TextView pattern_name;
        ImageView pattern_image;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {

        item = list.get(i);

        Holder holder = new Holder();
        View rowView ;
        rowView=inflater.inflate(R.layout.single_grid_back,null);

        holder.pattern_name=(TextView)rowView.findViewById(R.id.pattern_name);
        holder.pattern_image=(ImageView)rowView.findViewById(R.id.pattern_image);

       Log.e(">>>>",  item.getBack_names() + " : " + item.getPattern_back());

        holder.pattern_name.setText(item.getBack_names());

        Log.e(">>>>>",url + item.getPattern_back() );

        Picasso.with(context)
                .load(url + item.getPattern_back())
                .into(holder.pattern_image);

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                BackItem item = list.get(i);

                Toast.makeText(context,"You Selected" + item.getBack_names(),Toast.LENGTH_LONG).show();
/*
               Intent intent = ((Activity) context).getIntent();
                intent.getStringExtra("Pattern");
                ((Activity) context).setResult(((Activity) context).RESULT_OK,
                        intent);
                ((Activity) context).finish();*/

                Intent intent = new Intent(context,Select_Sleeves.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("Pattern", item.getPattern_back());
                context.startActivity(intent);
            }
        });

        return rowView;
    }
}
