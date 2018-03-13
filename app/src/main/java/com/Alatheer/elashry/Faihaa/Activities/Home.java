package com.Alatheer.elashry.Faihaa.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.Alatheer.elashry.Faihaa.MVP.Display_AllSubStages.Presenter;
import com.Alatheer.elashry.Faihaa.MVP.Display_AllSubStages.PresenterImp;
import com.Alatheer.elashry.Faihaa.MVP.Display_AllSubStages.ViewData;
import com.Alatheer.elashry.Faihaa.Models.School_Stages1;
import com.Alatheer.elashry.Faihaa.Models.Schools_Stages;
import com.Alatheer.elashry.Faihaa.Preferense;
import com.Alatheer.elashry.Faihaa.R;
import com.szugyi.circlemenu.view.CircleLayout;

import java.util.List;

import me.anwarshahriar.calligrapher.Calligrapher;

public class Home extends AppCompatActivity  implements ViewData, CircleLayout.OnItemClickListener, CircleLayout.OnRotationFinishedListener{

    private CircleLayout circleLayout;
    private Presenter presenter;
    private String school_id;
    private String student_code,father_national_num;
    Button logout,student_fees,school_fees,classes,news;
    private Preferense preferense;
    private String user_type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        presenter = new PresenterImp(this,this);
        preferense = new Preferense(this);
        initView();
        getDataFromIntent();


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            /*    Intent i2 = new Intent(Home.this, NewsActivity.class);
                i2.putExtra("school_id",school_id);
                startActivity(i2);*/
            if (user_type.equals("student"))
            {
                preferense.clear();
                Intent intent = new Intent(Home.this, Chooser_Activity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }else if (user_type.equals("parent"))
            {
                preferense.clear();

                Intent intent = new Intent(Home.this, Chooser_Activity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }


            }
        });
        student_fees.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (user_type.equals("student"))
                {
                    Intent i4= new Intent(Home.this, Student_Fees.class);
                    i4.putExtra("student_code",student_code);
                    startActivity(i4);
                }else if (user_type.equals("parent"))
                {
                    Intent intent= new Intent(Home.this, ChildrenActivity.class);
                    intent.putExtra("father_national_num",father_national_num);
                    startActivity(intent);
                    //student
                }

            }
        });
        classes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.DisplayAll_SubStages(school_id);

            }
        });

        school_fees.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i3= new Intent(Home.this, Rsoom.class);
                i3.putExtra("school_id",school_id);
                startActivity(i3);
            }
        });
        news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i3= new Intent(Home.this, NewsActivity.class);
            //    i3.putExtra("school_id",school_id);
                startActivity(i3);
            }
        });
    }

    private void getDataFromIntent() {
        Intent intent = getIntent();
        if (intent !=null)
        {
            if (intent.hasExtra("user_type"))
            {
                user_type = intent.getStringExtra("user_type");
                Log.e("usertype",user_type);

                if(user_type.equals("student"))
                {
                    // school_id = intent.getStringExtra("school_id");
                    student_code   = intent.getStringExtra("student_code");
                    user_type = "student";
                    Log.e("scode",student_code);

                    //  Toast.makeText(this, ""+student_code, Toast.LENGTH_SHORT).show();
                }else if (user_type.equals("parent"))
                {
                    father_national_num = intent.getStringExtra("parent_code");

                    Log.e("pcode",""+father_national_num);
                    user_type = "parent";
                }
            }

        }
    }

    private void initView() {
        Calligrapher calligrapher = new Calligrapher(this);
        calligrapher.setFont(this, "JannaLT-Regular.ttf", true);

        logout=findViewById(R.id.btn_logout);
        student_fees=findViewById(R.id.btn_student_fees);
        school_fees=findViewById(R.id.btn_school_fees);
        classes=findViewById(R.id.classes);
        news=findViewById(R.id.btn_news);

       // circleLayout=findViewById(R.id.circle);
       // circleLayout.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(View view) {


}

    @Override
    public void onRotationFinished(View view) {

    }

    @Override
    public void OnDisplayDataSuccess(School_Stages1 schools_stages1) {

        List<Schools_Stages> schools_stagesList = schools_stages1.getArray_stages();
        Schools_Stages schools_stages = schools_stagesList.get(0);
        Intent intent = new Intent(Home.this,SafofActivity.class);
        intent.putExtra("schools_stages",schools_stages);
        startActivity(intent);

    }

    @Override
    public void OnFailed(String error) {

        Toast.makeText(this, ""+error, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        startActivity(intent);
    }
}
