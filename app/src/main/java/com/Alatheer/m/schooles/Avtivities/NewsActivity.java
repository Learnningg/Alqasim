package com.Alatheer.m.schooles.Avtivities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.Alatheer.m.schooles.Adapters.Adapter;
import com.Alatheer.m.schooles.Models.News_Model;
import com.Alatheer.m.schooles.R;

import java.util.ArrayList;

public class NewsActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Adapter adapter;
    ArrayList<News_Model> atmArray = new ArrayList<>();

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
            News_Model atmModel = new News_Model(title[i],desc[i]);

            atmArray.add(atmModel);
        }

        recyclerView.setLayoutManager(new GridLayoutManager(NewsActivity.this, 1));
        recyclerView.setHasFixedSize(true);

        adapter = new Adapter(NewsActivity.this, atmArray);

        recyclerView.setAdapter(adapter);
    }
}
