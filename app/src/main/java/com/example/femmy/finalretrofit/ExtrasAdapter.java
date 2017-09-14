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
 * Created by FAMY on 03-Apr-17.
 */

public class ExtrasAdapter extends BaseAdapter {

    Context context;
    ArrayList<ExtrasItem> list_extras;
    ExtrasItem item_extras;

    private static LayoutInflater inflater = null;

    String url="http://192.168.0.103/dd/crop/others/";

    public ExtrasAdapter(Context context,ArrayList<ExtrasItem> list_extras)
    {
        this.context=context;
        this.list_extras=list_extras;

        inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return list_extras.size();
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
        TextView extras_name,extras_price;
        ImageView extras_image;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {

        item_extras=list_extras.get(i);

        Holder holder = new Holder();
        View row;
        row=inflater.inflate(R.layout.single_grid_extras,null);

        Log.e(">>>>>",""+item_extras.getExtras_name() + " : " + item_extras.getExtras_price());

        holder.extras_name=(TextView)row.findViewById(R.id.pattern_name);
        holder.extras_price=(TextView)row.findViewById(R.id.pattern_price);
        holder.extras_image=(ImageView)row.findViewById(R.id.pattern_image);

        holder.extras_name.setText(item_extras.getExtras_name());
        holder.extras_price.setText(item_extras.getExtras_price());


        Log.e("Picca",""+ url + item_extras.getExtras_image());

        Picasso.with(context)
                .load(url + item_extras.getExtras_image())
                .into(holder.extras_image);

        row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ExtrasItem item_extras = list_extras.get(i);

                Toast.makeText(context,"You Selected" + item_extras.getExtras_name(),Toast.LENGTH_LONG).show();

                Intent intent = new Intent(context,Measurement_Form_Upper.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("Pattern",item_extras.getExtras_image());
                context.startActivity(intent);
            }
        });

        return row;
    }
}
