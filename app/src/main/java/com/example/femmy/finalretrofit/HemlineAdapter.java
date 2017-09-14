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

public class HemlineAdapter extends BaseAdapter{

    Context context;
    ArrayList<HemlineItem> list_hemline;
    private static LayoutInflater inflater = null;
    HemlineItem item_hemline;
    String url = "http://192.168.0.103/dd/crop/hemline/";

    public HemlineAdapter(Context context,ArrayList<HemlineItem> list_hemline)
    {
        this.context=context;
        this.list_hemline=list_hemline;
        inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return list_hemline.size();
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
        TextView hemline_name;
        ImageView hemline_image;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {

        item_hemline = list_hemline.get(i);

        Holder holder = new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.single_grid_hemline,null);

        holder.hemline_name=(TextView)rowView.findViewById(R.id.pattern_name);
        holder.hemline_image=(ImageView)rowView.findViewById(R.id.pattern_image);

        Log.e(">>>>>","" + item_hemline.getHemline_name() + " : " + item_hemline.getHemline_image() );

        holder.hemline_name.setText(item_hemline.getHemline_name());

        Log.e(">>>>", "" + url + item_hemline.getHemline_image());

        Picasso.with(context)
                .load(url + item_hemline.getHemline_image())
                .into(holder.hemline_image);

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HemlineItem item_hemline = list_hemline.get(i);

                Toast.makeText(context,"You Selected" + item_hemline.getHemline_name(),Toast.LENGTH_LONG).show();

                Intent i = new Intent(context,Select_Extras.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                i.putExtra("Pattern",item_hemline.getHemline_image());
                context.startActivity(i);
            }
        });

        return rowView;
    }
}
