package com.Alatheer.m.schooles.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.Alatheer.m.schooles.Models.School_Stages1;
import com.Alatheer.m.schooles.R;

public class SafofActivity extends AppCompatActivity {

    private RecyclerView recView_sufouf;
    private RecyclerView.LayoutManager manager;
    private RecyclerView.Adapter adapter;
    private School_Stages1 school_stages1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safof);
        getDataFromIntent();
    }

    private void getDataFromIntent() {
        Intent intent = getIntent();
        if (intent!=null)
        {
            if (intent.hasExtra("School_Stages1"))
            {
                school_stages1 = (School_Stages1) intent.getSerializableExtra("School_Stages1");

            }
        }

    }
}
