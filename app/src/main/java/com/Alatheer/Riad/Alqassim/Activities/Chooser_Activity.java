package com.Alatheer.Riad.Alqassim.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.Alatheer.Riad.Alqassim.R;

import me.anwarshahriar.calligrapher.Calligrapher;

public class Chooser_Activity extends AppCompatActivity {
    LinearLayout student,employee,visitor,parent;
    String id ,user_type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chooser_);

        initView();

        SharedPreferences sharedPreferences=getSharedPreferences("id",MODE_PRIVATE);
        id=sharedPreferences.getString("user_id","");
        if (!TextUtils.isEmpty(id)) {
            user_type = sharedPreferences.getString("user_type","");

            Log.e("user_type idddd",user_type+"\n"+id);
            if (user_type.equals("student"))
            {
                Intent intent = new Intent(Chooser_Activity.this, Home.class);
                intent.putExtra("student_code", id);
                intent.putExtra("user_type",user_type);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

                finish();
            }else if (user_type.equals("parent"))
            {
                Intent intent = new Intent(Chooser_Activity.this, Home.class);
                intent.putExtra("parent_code", id);
                intent.putExtra("user_type",user_type);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }

        }

        student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(Chooser_Activity.this,LoginActivity.class);
                intent.putExtra("user_type","student");
                startActivity(intent);
                finish();

            }
        });

        employee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(Chooser_Activity.this,WebViewEmployee.class);
                intent.putExtra("user_type","employee");
                startActivity(intent);
                finish();

            }
        });
        visitor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(Chooser_Activity.this,AllSchools.class);
                intent.putExtra("user_type","visitor");
                startActivity(intent);
                finish();

            }
        });
        parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(Chooser_Activity.this,LoginParentActivity.class);
                intent.putExtra("user_type","parent");
                startActivity(intent);
                finish();

            }
        });

    }

    private void initView() {
        Calligrapher calligrapher = new Calligrapher(this);
        calligrapher.setFont(this, "JannaLT-Regular.ttf", true);
        student=findViewById(R.id.student);
        employee=findViewById(R.id.employee);
        visitor=findViewById(R.id.visitor);
        parent = findViewById(R.id.parent);

    }

 }
