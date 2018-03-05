package com.Alatheer.m.schooles.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.Alatheer.m.schooles.Adapters.SubStagesAdapter;
import com.Alatheer.m.schooles.Models.School_Stages1;
import com.Alatheer.m.schooles.Models.Schools_Stages;
import com.Alatheer.m.schooles.Models.SubStages;
import com.Alatheer.m.schooles.R;

import java.util.ArrayList;
import java.util.List;

public class SafofActivity extends AppCompatActivity {

    private RecyclerView recView_sufouf;
    private RecyclerView.LayoutManager manager;
    private RecyclerView.Adapter adapter;
    private Schools_Stages school_stages;
    private TextView stage_name;
    private List<SubStages> subStages;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safof);
        initView();
        getDataFromIntent();
    }

    private void initView() {
        subStages = new ArrayList<>();
        stage_name = findViewById(R.id.stage_name);
        recView_sufouf = findViewById(R.id.recView_sufouf);
        manager = new GridLayoutManager(this,3);
        recView_sufouf.setLayoutManager(manager);
        recView_sufouf.setHasFixedSize(true);


    }

    private void getDataFromIntent() {
        Intent intent = getIntent();
        if (intent!=null)
        {
            if (intent.hasExtra("schools_stages"))
            {
                school_stages = (Schools_Stages) intent.getSerializableExtra("schools_stages");
                UpdateUi(school_stages);

            }
        }

    }

    private void UpdateUi(Schools_Stages school_stages) {
        stage_name.setText(school_stages.getStage_name());
        subStages = school_stages.getSub_stage();
        adapter = new SubStagesAdapter(this,subStages);
        recView_sufouf.setAdapter(adapter);
    }

    public void setPos(int pos)
    {
        Toast.makeText(this, ""+subStages.get(pos).getSub_stages_name(), Toast.LENGTH_SHORT).show();
    }
}
