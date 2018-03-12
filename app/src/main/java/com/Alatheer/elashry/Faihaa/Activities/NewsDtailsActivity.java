package com.Alatheer.elashry.Faihaa.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.Alatheer.elashry.Faihaa.Models.News_Model;
import com.Alatheer.elashry.Faihaa.R;

public class NewsDtailsActivity extends AppCompatActivity {

    private ImageView back,news_img;
    private TextView school_name,news_date,news_title,news_content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_dtails);

        initView();

        getDataFromIntent();
    }

    private void getDataFromIntent() {
        Intent intent = getIntent() ;
        if (intent!=null)
        {
            News_Model news_model = (News_Model) intent.getSerializableExtra("details");

            UpdateUI(news_model);
        }
    }

    private void UpdateUI(News_Model news_model) {

        school_name.setText(news_model.getSchool_name());
        news_date.setText(news_model.getNews_date());
        news_title.setText(news_model.getNews_title());
        news_content.setText(news_model.getNews_content());
    }

    private void initView() {
        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        news_img = findViewById(R.id.news_img);
        school_name = findViewById(R.id.school_name);
        news_date = findViewById(R.id.news_date);
        news_title = findViewById(R.id.news_title);
        news_content = findViewById(R.id.news_details);

    }
}
