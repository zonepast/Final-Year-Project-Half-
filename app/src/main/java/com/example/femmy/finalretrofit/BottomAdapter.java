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
 * Created by FAMY on 02-Apr-17.
 */

public class BottomAdapter extends BaseAdapter {

    Context context;
    ArrayList<BottomItem> list_bottom;
    private static LayoutInflater inflater = null;
    BottomItem item_bottom;
    String url = "http://192.168.0.103/dd/crop/bottom/";

    public BottomAdapter(Context context,ArrayList<BottomItem> list_bottom)
    {
        this.context=context;
        this.list_bottom= list_bottom;

        inflater =  (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return list_bottom.size();
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
        TextView bottom_name;
        ImageView bottom_image;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {

        item_bottom=list_bottom.get(i);

        Holder holder = new Holder();
        View row;
        row = inflater.inflate(R.layout.single_grid_bottom,null);

        holder.bottom_name=(TextView)row.findViewById(R.id.pattern_name);
        holder.bottom_image=(ImageView)row.findViewById(R.id.pattern_image);

        Log.e(">>>", item_bottom.getBottom_name() + " : " + item_bottom.getBottom_image());

        holder.bottom_name.setText(item_bottom.getBottom_name());

        Log.e(">>>>","" + url + item_bottom.getBottom_image());

        Picasso.with(context)
                .load(url + item_bottom.getBottom_image())
                .into(holder.bottom_image);

        row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                BottomItem item_bottom =  list_bottom.get(i);
                Toast.makeText(context,"You Selected"+ item_bottom.getBottom_name(),Toast.LENGTH_LONG).show();

                Intent intent = new Intent(context,Select_Hemline.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("Pattern",item_bottom.getBottom_name());
                context.startActivity(intent);
            }
        });
        return row;
    }
}
