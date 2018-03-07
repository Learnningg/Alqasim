package com.Alatheer.m.schooles.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.Alatheer.m.schooles.R;

import me.anwarshahriar.calligrapher.Calligrapher;

public class DescActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desc);
        Calligrapher calligrapher = new Calligrapher(this);
        calligrapher.setFont(this, "JannaLT-Regular.ttf", true);
    }
}
