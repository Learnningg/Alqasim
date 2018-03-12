package com.Alatheer.elashry.Faihaa.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.Alatheer.elashry.Faihaa.R;

import me.anwarshahriar.calligrapher.Calligrapher;

public class Chooser_Activity extends AppCompatActivity {
    ImageView student,employee,visitor,parent;
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
                startActivity(intent);

            }
        });

        employee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(Chooser_Activity.this,WebViewEmployee.class);
                startActivity(intent);

            }
        });
        visitor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(Chooser_Activity.this,Home.class);
                startActivity(intent);

            }
        });
        parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(Chooser_Activity.this,LoginParentActivity.class);
                startActivity(intent);

            }
        });

    }

    private void initView() {
        Calligrapher calligrapher = new Calligrapher(this);
        calligrapher.setFont(this, "JannaLT-Regular.ttf", true);
        student=findViewById(R.id.img_student);
        employee=findViewById(R.id.img_employee);
        visitor=findViewById(R.id.img_visitor);
        parent = findViewById(R.id.img_parent);

    }
 }
