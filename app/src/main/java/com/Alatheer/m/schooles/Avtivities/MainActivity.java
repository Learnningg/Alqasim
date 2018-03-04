package com.Alatheer.m.schooles.Avtivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.Alatheer.m.schooles.R;

public class MainActivity extends AppCompatActivity {
Button sfof,news;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        news=findViewById(R.id.news);

        sfof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,SafofActivity.class);
                startActivity(i);
            }
        });
        news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,NewsActivity.class);
                startActivity(i);
            }
        });

    }
}
