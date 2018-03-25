package com.Alatheer.elashry.Faihaa.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.Alatheer.elashry.Faihaa.R;

import me.anwarshahriar.calligrapher.Calligrapher;

public class ActivityVisitorHome extends AppCompatActivity implements View.OnClickListener{

    Button news,activitiyschool,fees,about;
    ImageView copy;
    String school_id,user_type,phone,fax,email, school_name       ;
    Double school_google_long,school_google_lat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visitor_home);

        getDataFromIntent();
        initView();
    }

    private void getDataFromIntent() {
        Intent intent = getIntent();
        if (intent!=null)
        {
            if (intent.hasExtra("school_id"))
            {
                school_id         =intent.getStringExtra("school_id"         );
                user_type         =intent.getStringExtra("user_type"         );
                phone             =intent.getStringExtra("phone"             );
                fax               =intent.getStringExtra("fax"               );
                email             =intent.getStringExtra("email"             );
                school_google_long=intent.getDoubleExtra("school_google_long",1.1);
                school_google_lat =intent.getDoubleExtra("school_google_lat",1.1 );
                school_name       =intent.getStringExtra("school_name"       );
            }
        }
    }

    private void initView() {

        Calligrapher calligrapher = new Calligrapher(this);
        calligrapher.setFont(this, "JannaLT-Regular.ttf", true);

        news=findViewById(R.id.btn_news);
        activitiyschool=findViewById(R.id.btn_activities);
        fees=findViewById(R.id.btn_school_fees);
        about=findViewById(R.id.btn_school_about);
        copy=findViewById(R.id.copyRight);

        news.setOnClickListener(this);
        activitiyschool.setOnClickListener(this);
        fees.setOnClickListener(this);
        about.setOnClickListener(this);
        copy.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.btn_news:
                Intent intent1=new Intent(ActivityVisitorHome.this,NewsActivity.class);
                intent1.putExtra("school_id",school_id);
                intent1.putExtra("user_type",user_type);
                startActivity(intent1);
                break;

            case R.id.btn_activities:
                Intent intent2=new Intent(ActivityVisitorHome.this,SchoolActivity.class);
                intent2.putExtra("school_id",school_id);
                startActivity(intent2);
                break;

            case R.id.btn_school_fees:
                Intent intent3=new Intent(ActivityVisitorHome.this,ActivitySchoolFees.class);
                intent3.putExtra("school_id",school_id);

                startActivity(intent3);
                break;

            case R.id.btn_school_about:
            Intent intent4=new Intent(ActivityVisitorHome.this,ActivityAboutUs.class);
                intent4.putExtra("school_id"         ,school_id          );
                intent4.putExtra("user_type"         , user_type         );
                intent4.putExtra("phone"             , phone             );
                intent4.putExtra("fax"               , fax               );
                intent4.putExtra("email"             , email             );
                intent4.putExtra("school_google_long", school_google_long);
                intent4.putExtra("school_google_lat" , school_google_lat );
                intent4.putExtra("school_name"       , school_name       );

                startActivity(intent4);
            break;
            case R.id.copyRight:
                Intent intent5=new Intent(ActivityVisitorHome.this,CopyRight.class);

                startActivity(intent5);
                break;
        }

    }
}
