package com.Alatheer.Riad.Alqassim.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.Alatheer.Riad.Alqassim.Models.AllActivities_Model;
import com.Alatheer.Riad.Alqassim.R;
import com.squareup.picasso.Picasso;

import me.anwarshahriar.calligrapher.Calligrapher;

public class DescActivity extends AppCompatActivity {
    private TextView act_title,act_content,act_school_name,act_date,act_class_subStage;
    private ImageView act_img,back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desc);
        Calligrapher calligrapher = new Calligrapher(this);
        calligrapher.setFont(this, "JannaLT-Regular.ttf", true);

        initView();
        getDataFromIntent();
    }

    private void getDataFromIntent() {

        Intent intent = getIntent();
        if (intent!=null)
        {
            if (intent.hasExtra("activities_details"))
            {
                AllActivities_Model allActivities_model = (AllActivities_Model) intent.getSerializableExtra("activities_details");
                UpdateUi(allActivities_model);
            }
        }
    }

    private void UpdateUi(AllActivities_Model allActivities_model) {
        act_title.setText(allActivities_model.getActivity_title());
        act_content.setText(allActivities_model.getActivity_content());
        act_date.setText(allActivities_model.getActivity_date());
        act_school_name.setText(allActivities_model.getSchool_name());
        act_class_subStage.setText(allActivities_model.getSub_stages_name()+" "+"("+allActivities_model.getClassrooms_name()+")");
        if (allActivities_model.getImage_name()!=null || !TextUtils.isEmpty(allActivities_model.getImage_name())|| !allActivities_model.getImage_name().equals("0"))
        {
            Picasso.with(this).load("http://anwaralfyaha.anwaralfyaha.com/uploads/images/"+allActivities_model.getImage_name()).into(act_img);

        }
    }

    private void initView() {
        act_title = findViewById(R.id.title);
        act_content = findViewById(R.id.activity_details);
        act_school_name = findViewById(R.id.school_name);
        act_date = findViewById(R.id.activity_date);
        act_class_subStage = findViewById(R.id.class_subStage);
        act_img = findViewById(R.id.activity_img);
        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
