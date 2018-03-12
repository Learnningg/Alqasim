package com.Alatheer.elashry.Faihaa.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.Alatheer.elashry.Faihaa.Activities.DescActivity;
import com.Alatheer.elashry.Faihaa.Models.AllActivities_Model;
import com.Alatheer.elashry.Faihaa.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


/**
 * Created by ok on 29/01/2018.
 */

public class All_Activities_Adapter extends RecyclerView.Adapter<All_Activities_Adapter.Holder>{
   Context context;
   AllActivities_Model Model;
    ArrayList<AllActivities_Model> actiitiesList;


    public All_Activities_Adapter(Context context, ArrayList<AllActivities_Model> actiitiesList) {
        this.context = context;
        this.actiitiesList = actiitiesList;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_activities,parent,false);

        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        Model=actiitiesList.get(position);
        holder.linearLayout.setTag(position);

        holder.title.setText(Model.getActivity_title());
        holder.content.setText(Model.getActivity_content());
        holder.date.setText(Model.getActivity_date());
        Picasso.with(context).load("http://nsqapp.anwaralfyaha.com/"+Model.getImage_name()).into(holder.image);

    }

    @Override
    public int getItemCount() {
        return  actiitiesList.size();
    }

    class Holder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title, content,date;
        ImageView image;
        LinearLayout linearLayout;

        public Holder(View itemView) {
            super(itemView);

            title=itemView.findViewById(R.id.txt_title);
            content=itemView.findViewById(R.id.txt_content);
            date=itemView.findViewById(R.id.txt_date);
            image=itemView.findViewById(R.id.img_activities);
            linearLayout=itemView.findViewById(R.id.linear_activities);
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
