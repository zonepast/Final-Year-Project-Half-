package com.example.femmy.finalretrofit;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
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
 * Created by FAMY on 26-Mar-17.
 */

public class Gridadapter extends BaseAdapter {

    ArrayList<SingleItem> list;
    Context context;
    SingleItem item;
    private static LayoutInflater inflater = null;

    String url = "http://192.168.0.103/dd/crop/front/urban/";

    public Gridadapter(Context context, ArrayList<SingleItem> list) {
        this.context = context;
        this.list = list;

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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

    public class Holder {
        TextView pattern_name;
        ImageView pattern_image;
        CardView cardView;
    }

    @Override
    public View getView(final int i, View view, final ViewGroup viewGroup) {

        item = list.get(i);

        Holder holder = new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.single_grid_item, null);

        holder.pattern_name = (TextView) rowView.findViewById(R.id.pattern_name);
        holder.pattern_image = (ImageView) rowView.findViewById(R.id.pattern_image);
        holder.cardView = (CardView) rowView.findViewById(R.id.cardview);

        Log.e(">>>", item.getFront_names() + " : " + item.getPattern_front());

        holder.pattern_name.setText(item.getFront_names());

        Log.e(">>>>", url + item.getPattern_front());

        Picasso.with(context)
                .load(url + item.getPattern_front())
                .into(holder.pattern_image);

        holder.pattern_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SingleItem item = list.get(i);
                Toast.makeText(context, "You Selected " + item.getFront_names(), Toast.LENGTH_LONG).show();

                Intent i = new Intent(context, Select_Back.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                i.putExtra("Pattern", item.getPattern_front());
                context.startActivity(i);
            }
        });

        return rowView;
    }
}