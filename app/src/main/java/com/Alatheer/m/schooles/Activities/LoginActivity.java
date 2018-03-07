package com.Alatheer.m.schooles.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.Alatheer.m.schooles.MVP.LoginMVP.Presenter;
import com.Alatheer.m.schooles.MVP.LoginMVP.PresenterImp;
import com.Alatheer.m.schooles.MVP.LoginMVP.ViewData;
import com.Alatheer.m.schooles.Models.LoginModel;
import com.Alatheer.m.schooles.R;
import com.romainpiel.shimmer.Shimmer;
import com.romainpiel.shimmer.ShimmerTextView;

public class LoginActivity extends AppCompatActivity implements ViewData {

    private ShimmerTextView shimmer;
    private Button login;
    private String school_id;
    private EditText user_id;
    private Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        presenter = new PresenterImp(this,this);
        initView();
        getDataFromIntent();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = user_id.getText().toString();

                presenter.Login(id);

            }
        });
    }

    private void getDataFromIntent() {
        Intent intent = getIntent();
        if (intent!=null)
        {
            if (intent.hasExtra("school_id"))
            {
                school_id = intent.getStringExtra("school_id");
            }

        }
    }

    private void initView() {
        user_id = findViewById(R.id.user_id);
        shimmer = findViewById(R.id.shimmer);
        login =findViewById(R.id.btnlogin);
        Shimmer shimmer2 = new Shimmer();
        shimmer2.setDuration(1500)
                .setStartDelay(300);
        shimmer2.start(shimmer);

    }

    @Override
    public void setUserIdError() {
        user_id.setError("empty field");
    }


    @Override
    public void setNationalIdError() {
        user_id.setError("Wrong Student National Number");
    }

    @Override
    public void OnDisplayDataSuccess(LoginModel loginModel) {
         Intent intent=new Intent(LoginActivity.this,Home.class);
                intent.putExtra("school_id",school_id);
                intent.putExtra("student_code",loginModel.getStudent_code());
                startActivity(intent);
    }

    @Override
    public void OnFailed(String error) {

        Toast.makeText(this, ""+error, Toast.LENGTH_SHORT).show();
    }
}
