package com.Alatheer.m.schooles.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.Alatheer.m.schooles.Activities.SafofActivity;
import com.Alatheer.m.schooles.Models.SubStages;
import com.Alatheer.m.schooles.R;

import java.util.List;

/**
 * Created by elashry on 3/5/2018.
 */

public class SubStagesAdapter extends RecyclerView.Adapter <SubStagesAdapter.mViewHolder>{

    Context context;
    List<SubStages> subStagesList;
    SafofActivity safofActivity;

    public SubStagesAdapter(Context context, List<SubStages> subStagesList) {
        this.context = context;
        this.subStagesList = subStagesList;
        safofActivity = (SafofActivity) context;
    }

    @Override
    public mViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sub_stages_row,parent,false);
        return new mViewHolder(view);
    }

    @Override
    public void onBindViewHolder(mViewHolder holder, int position) {
        SubStages subStages = subStagesList.get(position);
        holder.BindData(subStages);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return subStagesList.size();
    }

    public class mViewHolder extends RecyclerView.ViewHolder
    {
        private TextView sub_stage_name;

        public mViewHolder(View itemView) {
            super(itemView);

            sub_stage_name = itemView.findViewById(R.id.sub_stage_name);

        }
        public void BindData(SubStages subStages)
        {
            sub_stage_name.setText(subStages.getSub_stages_name());
        }
    }
}
