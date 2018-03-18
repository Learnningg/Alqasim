package com.Alatheer.elashry.Faihaa.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.Alatheer.elashry.Faihaa.R;

import me.anwarshahriar.calligrapher.Calligrapher;

public class ActivityAboutUs extends AppCompatActivity implements View.OnClickListener {

    String school_id,user_type,phone,fax,email,school_google_long,school_google_lat, school_name ;
    Button location;
    TextView tphone,tfax,temail, tschool_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

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
                school_google_long=intent.getStringExtra("school_google_long");
                school_google_lat =intent.getStringExtra("school_google_lat" );
                school_name       =intent.getStringExtra("school_name"       );
            }
        }

    }

    private void initView() {
        Calligrapher calligrapher = new Calligrapher(this);
        calligrapher.setFont(this, "JannaLT-Regular.ttf", true);

        tschool_name=findViewById(R.id.txt_schoolName);
        temail=findViewById(R.id.txt_schoolemail);
        tfax=findViewById(R.id.txt_schoolfax);
        tphone=findViewById(R.id.txt_schoolphone);
        location=findViewById(R.id.btn_school_location);

        tschool_name.setText(school_name);
        temail.setText(email);
        tfax.setText(fax);
        tphone.setText(phone);

        location.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btn_school_location:
                Intent intent=new Intent(ActivityAboutUs.this,LocationActivity.class);
                intent.putExtra("latitude",school_google_long);
                intent.putExtra("longitude",school_google_lat);
                startActivity(intent);        }

    }
}
