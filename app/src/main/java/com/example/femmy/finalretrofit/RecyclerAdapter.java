package com.example.femmy.finalretrofit;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;


/**
 * Created by FAMY on 26-Feb-17.
 */

//ADAPTER (to bind data with recycleview we need an adapter)

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    List<Listitem> listitems;
    private Context context;

    String url = "http://192.168.0.103/dd/crop/first/";
    Listitem listitem;

    public RecyclerAdapter(List<Listitem> listitems, Context context) {
        this.listitems = listitems;
        this.context = context;
    }

    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final RecyclerAdapter.ViewHolder holder, final int position) {

        listitem = listitems.get(position);

        Log.e(">>", listitem.getHeading() + " : " + listitem.getPrices() + " : " + listitem.getImage());

        holder.heading.setText(listitem.getName());
        holder.prices.setText(listitem.getPrice());

        Log.e(">>>>", url + listitem.getImage());

        Picasso.with(context)
                .load(url + listitem.getImage())
                .into(holder.image);

        holder.cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Listitem listitem = listitems.get(position);
                Toast.makeText(context,listitem.getName(), Toast.LENGTH_LONG).show();

             Intent int_grid = new Intent(context, Select_Front.class);
                int_grid.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                int_grid.putExtra("Pattern", listitem.getPattern());
                context.startActivity(int_grid);
            }

        });
    }

    @Override
    public int getItemCount() {
        return listitems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView heading, prices;
        ImageView image;
        CardView cardview;

        public ViewHolder(final View itemView) {
            super(itemView);

            heading = (TextView) itemView.findViewById(R.id.heading);
            prices = (TextView) itemView.findViewById(R.id.prices);
            image = (ImageView) itemView.findViewById(R.id.image);
            cardview = (CardView) itemView.findViewById(R.id.cardview);
        }
    }
}