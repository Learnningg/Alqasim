package com.Alatheer.m.schooles.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.Alatheer.m.schooles.MVP.Display_AllSubClasses.Presenter;
import com.Alatheer.m.schooles.MVP.Display_AllSubClasses.PresenterImp;
import com.Alatheer.m.schooles.MVP.Display_AllSubClasses.ViewData;
import com.Alatheer.m.schooles.Models.School_Stages1;
import com.Alatheer.m.schooles.Models.Schools_Stages;
import com.Alatheer.m.schooles.R;
import com.szugyi.circlemenu.view.CircleLayout;

import java.util.List;

public class Home extends AppCompatActivity  implements ViewData, CircleLayout.OnItemClickListener, CircleLayout.OnRotationFinishedListener{

    private CircleLayout circleLayout;
    private Presenter presenter;
    private String school_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        presenter = new PresenterImp(this,this);
        initView();
        getDataFromIntent();
    }

    private void getDataFromIntent() {
        Intent intent = getIntent();
        if (intent !=null)
        {
            if(intent.hasExtra("school_id"))
            {
                school_id = intent.getStringExtra("school_id");
            }
        }
    }

    private void initView() {

        circleLayout=findViewById(R.id.circle);
        circleLayout.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(View view) {





            switch (view.getId()) {

                case R.id.activity:
                    presenter.DisplayAllSubClasses(school_id);
                       break;
                case R.id.news:

                        Intent i2 = new Intent(Home.this, NewsActivity.class);
                        startActivity(i2);

    }}

    @Override
    public void onRotationFinished(View view) {

    }

    @Override
    public void OnDisplayDataSuccess(School_Stages1 schools_stages1) {

        List<Schools_Stages> schools_stagesList = schools_stages1.getArray_stages();
        Schools_Stages schools_stages = schools_stagesList.get(0);
        Intent intent = new Intent(Home.this,SafofActivity.class);
        intent.putExtra("schools_stages",schools_stages);
        startActivity(intent);

    }

    @Override
    public void OnFailed(String error) {

        Toast.makeText(this, ""+error, Toast.LENGTH_SHORT).show();

    }
}
