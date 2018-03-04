package com.Alatheer.m.schooles.Avtivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.Alatheer.m.schooles.R;
import com.romainpiel.shimmer.Shimmer;
import com.romainpiel.shimmer.ShimmerTextView;

public class LoginActivity extends AppCompatActivity {

    private ShimmerTextView shimmer;
    private Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this,Home.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        shimmer = findViewById(R.id.shimmer);
        login =findViewById(R.id.btnlogin);
        Shimmer shimmer2 = new Shimmer();
        shimmer2.setDuration(1500)
                .setStartDelay(300);
        shimmer2.start(shimmer);

    }
}
