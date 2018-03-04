package com.Alatheer.m.schooles.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.Alatheer.m.schooles.Avtivities.DescActivity;
import com.Alatheer.m.schooles.Models.News_Model;
import com.Alatheer.m.schooles.R;

import java.util.ArrayList;


/**
 * Created by ok on 29/01/2018.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.Holder>{
Context context;
News_Model Model;
    ArrayList<News_Model> atmArray;
    public static double lat;
    public static double longit;
    public static String adress;

    public Adapter(Context context, ArrayList<News_Model> atmArray) {
        this.context = context;
        this.atmArray = atmArray;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item,parent,false);

        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        Model=atmArray.get(position);
        holder.linearLayout.setTag(position);

        holder.bank.setText(Model.getTitle());
        holder.street.setText(Model.getDesc());

    }

    @Override
    public int getItemCount() {
        return  atmArray.size();
    }

    class Holder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView bank, street;
        ImageView logo;
        LinearLayout linearLayout;

        public Holder(View itemView) {
            super(itemView);

            bank=itemView.findViewById(R.id.title);
            street=itemView.findViewById(R.id.desc);
            logo=itemView.findViewById(R.id.img);

            linearLayout=itemView.findViewById(R.id.linnn);



            linearLayout.setOnClickListener(this);



        }

        @Override
        public void onClick(View view) {

            int position = (int) view.getTag();


            Intent i = new Intent(context,DescActivity.class);
            context.startActivity(i);


        }
    }
}
