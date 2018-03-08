package com.Alatheer.m.schooles.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.Alatheer.m.schooles.R;

import me.anwarshahriar.calligrapher.Calligrapher;

public class Chooser_Activity extends AppCompatActivity {
    ImageView student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chooser_);

        initView();
        student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Chooser_Activity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        Calligrapher calligrapher = new Calligrapher(this);
        calligrapher.setFont(this, "JannaLT-Regular.ttf", true);
        student=findViewById(R.id.img_student);
    }
}
