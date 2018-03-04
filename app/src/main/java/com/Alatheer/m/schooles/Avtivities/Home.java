package com.Alatheer.m.schooles.Avtivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.Alatheer.m.schooles.MVP.Display_AllSubClasses.Presenter;
import com.Alatheer.m.schooles.MVP.Display_AllSubClasses.PresenterImp;
import com.Alatheer.m.schooles.MVP.Display_AllSubClasses.ViewData;
import com.Alatheer.m.schooles.Models.School_Stages1;
import com.Alatheer.m.schooles.R;
import com.szugyi.circlemenu.view.CircleLayout;

public class Home extends AppCompatActivity  implements ViewData,CircleLayout.OnItemClickListener, CircleLayout.OnRotationFinishedListener{

    private String school_id;
    private Presenter presenter;
    private CircleLayout circle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
        presenter = new PresenterImp(this,this);
        getDataFromIntent();


    }

    private void initView() {
        circle = findViewById(R.id.circle);
        circle.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(View view) {





            switch (view.getId()) {

                case R.id.activity:

                    presenter.DisplayAllSubClasses(school_id);
                    /*Intent intent = new Intent(this,SafofActivity.class);
                    intent.putExtra("school_id",school_id);
                    startActivity(intent);*/


//                    Intent i1 =new Intent(Home.this,Activites.class);
//                    startActivity(i1);
                    break;
                case R.id.news:

                        Intent i2 = new Intent(Home.this, NewsActivity.class);
                        startActivity(i2);

    }

    }
    private void getDataFromIntent() {
        Intent intent = getIntent();
        if (intent!=null)
        {
            if (intent.hasExtra("school_id"))
            {
                school_id = intent.getStringExtra("school_id");
            }

        }
    }


    @Override
    public void onRotationFinished(View view) {

    }

    @Override
    public void OnDisplayDataSuccess(School_Stages1 schools_stages1) {
        Intent intent = new Intent(this,SafofActivity.class);
        intent.putExtra("School_Stages1",schools_stages1);
        startActivity(intent);
    }

    @Override
    public void OnFailed(String error) {

    }
}
