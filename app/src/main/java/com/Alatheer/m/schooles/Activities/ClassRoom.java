package com.Alatheer.m.schooles.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

import com.Alatheer.m.schooles.R;

import me.anwarshahriar.calligrapher.Calligrapher;

public class ClassRoom extends AppCompatActivity implements View.OnClickListener {

    CardView homework,absent,activity,honorboard,rate,table;
    String class_room_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_room);
        initView();
        getDataFromIntent();
    }

    private void getDataFromIntent() {
        Intent intent = getIntent();
        if (intent!=null)
        {
            if (intent.hasExtra("class_room_id"))
            {
                class_room_id = intent.getStringExtra("class_room_id");
            }
        }
    }

    private void initView() {
        Calligrapher calligrapher = new Calligrapher(this);
        calligrapher.setFont(this, "JannaLT-Regular.ttf", true);
        homework   = findViewById(R.id.txt_homework);
        absent     = findViewById(R.id.txt_absent);
        activity   = findViewById(R.id.txt_activities);
        honorboard = findViewById(R.id.txt_honorbourd);
        rate       = findViewById(R.id.txt_rate);
        table      = findViewById(R.id.txt_table);



        homework  .setOnClickListener(this);
        absent    .setOnClickListener(this);
        activity  .setOnClickListener(this);
        honorboard.setOnClickListener(this);
        rate      .setOnClickListener(this);
        table     .setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.txt_homework:

                break;
            case R.id.txt_absent:
                break;
            case R.id.txt_activities:
                Intent intent3 = new Intent(this,Activities.class);
                intent3.putExtra("class_room_id",class_room_id);
                startActivity(intent3);
                break;
            case R.id.txt_honorbourd:
                Intent intent4 = new Intent(this,HonorBoardStudent.class);
                intent4.putExtra("class_room_id",class_room_id);
                startActivity(intent4);
                break;
            case R.id.txt_rate:
                Intent intent5 = new Intent(this,Student_State.class);
                intent5.putExtra("class_room_id",class_room_id);
                startActivity(intent5);
                break;
            case R.id.txt_table:
                break;
        }
    }
}
