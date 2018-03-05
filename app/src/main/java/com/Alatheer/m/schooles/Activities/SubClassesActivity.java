package com.Alatheer.m.schooles.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.Alatheer.m.schooles.Adapters.SubClassesAdapter;
import com.Alatheer.m.schooles.Models.SubClasses;
import com.Alatheer.m.schooles.R;

import java.util.ArrayList;
import java.util.List;

public class SubClassesActivity extends AppCompatActivity {

    private RecyclerView recView_SubClasses;
    private RecyclerView.LayoutManager manager;
    private RecyclerView.Adapter adapter;
    private List<SubClasses> subClassesList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_classes);
        initView();
        getDataFromIntent();
    }

    private void getDataFromIntent() {
        Intent intent = getIntent();
        if (intent!=null)
        {
            if (intent.hasExtra("subClassesList"))
            {
                subClassesList = (List<SubClasses>) intent.getSerializableExtra("subClassesList");
                UpdateUi(subClassesList);
            }
        }
    }

    private void UpdateUi(List<SubClasses> subClassesList) {
        adapter = new SubClassesAdapter(this,subClassesList);
        recView_SubClasses.setAdapter(adapter);
    }

    private void initView() {
        subClassesList = new ArrayList<>();
        recView_SubClasses = findViewById(R.id.recView_SubClasses);
        manager = new GridLayoutManager(this,3);
        recView_SubClasses.setLayoutManager(manager);
        recView_SubClasses.setHasFixedSize(true);



    }
    public void setPos(int pos)
    {
        SubClasses subClasses =subClassesList.get(pos);
        Toast.makeText(this, ""+subClasses.getId_class_room(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,ClassRoom.class);
        intent.putExtra("class_room_id",subClasses.getId_class_room());
        startActivity(intent);
    }
}
