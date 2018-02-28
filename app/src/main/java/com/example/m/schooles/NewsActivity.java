package com.example.m.schooles;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class NewsActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Adapter adapter;
    ArrayList<Model> atmArray = new ArrayList<>();

    public static String [] title={
            "اول خبر",
            "ثاني خبر ",

    };
    public static String [] desc={
            "اول خبراول خبراول خبراول خبراول خبراول خبر",
            "ثاني خبرثاني خبرثاني خبرثاني خبرثاني خبر ",

    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyc);

        for (int i = 0 ; i<title.length;i++) {
            Model atmModel = new Model(title[i],desc[i]);

            atmArray.add(atmModel);
        }

        recyclerView.setLayoutManager(new GridLayoutManager(NewsActivity.this, 1));
        recyclerView.setHasFixedSize(true);

        adapter = new Adapter(NewsActivity.this, atmArray);

        recyclerView.setAdapter(adapter);
    }
}
