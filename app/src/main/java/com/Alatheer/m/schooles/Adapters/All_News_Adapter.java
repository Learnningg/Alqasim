package com.Alatheer.m.schooles.Adapters;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.Alatheer.m.schooles.Activities.DescActivity;
import com.Alatheer.m.schooles.Models.News_Model;
import com.Alatheer.m.schooles.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


/**
 * Created by ok on 29/01/2018.
 */

public class All_News_Adapter extends RecyclerView.Adapter<All_News_Adapter.Holder>{
Context context;
News_Model Model;
    ArrayList<News_Model> news;
    public static double lat;
    public static double longit;
    public static String adress;

    public All_News_Adapter(Context context, ArrayList<News_Model> news) {
        this.context = context;
        this.news = news;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item,parent,false);

        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        Model=news.get(position);
        holder.linearLayout.setTag(position);

        holder.title.setText(Model.getnews_title());
        holder.desc.setText(Model.getnews_content());
        Picasso.with(context).load("http://nsqapp.anwaralfyaha.com/"+Model.getimage_name()).into(holder.image);

    }

    @Override
    public int getItemCount() {
        return  news.size();
    }

    class Holder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title, desc;
        ImageView image;
        LinearLayout linearLayout;

        public Holder(View itemView) {
            super(itemView);

            title=itemView.findViewById(R.id.title);
            desc=itemView.findViewById(R.id.desc);
            image=itemView.findViewById(R.id.img);
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
