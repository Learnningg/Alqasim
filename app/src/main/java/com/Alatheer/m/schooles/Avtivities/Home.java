package com.Alatheer.m.schooles.Avtivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.Alatheer.m.schooles.R;
import com.szugyi.circlemenu.view.CircleLayout;

public class Home extends AppCompatActivity  implements CircleLayout.OnItemClickListener, CircleLayout.OnRotationFinishedListener{

    CircleLayout circleLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        initview();
    }

    private void initview() {

        circleLayout=findViewById(R.id.circle);
        circleLayout.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(View view) {





            switch (view.getId()) {

                case R.id.activity:
                    Intent i1 =new Intent(Home.this,SafofActivity.class);
                    startActivity(i1);
                    break;
                case R.id.news:

                        Intent i2 = new Intent(Home.this, NewsActivity.class);
                        startActivity(i2);

    }}

    @Override
    public void onRotationFinished(View view) {

    }
}
