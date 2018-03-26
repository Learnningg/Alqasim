package com.Alatheer.Riad.Alqassim.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.Alatheer.Riad.Alqassim.Models.School_Fees_Model;
import com.Alatheer.Riad.Alqassim.R;
import com.Alatheer.Riad.Alqassim.Services.Service;
import com.Alatheer.Riad.Alqassim.Services.ServicesApi;


import java.util.List;

import me.anwarshahriar.calligrapher.Calligrapher;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivitySchoolFees extends AppCompatActivity {
    TextView school_name,school_fees,transport_fees;
    String school_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_fees);

        getDataFromIntent();
        initView();
        getDataFromServer();
    }

    private void getDataFromServer() {

        Service service = ServicesApi.CreateApiClient().create(Service.class);
        Call<List<School_Fees_Model>> call = service.GetSchoolFeesData(school_id);

        call.enqueue(new Callback<List<School_Fees_Model>>() {
            @Override
            public void onResponse(Call<List<School_Fees_Model>> call, Response<List<School_Fees_Model>> response) {

                if (response.isSuccessful()){
                    school_name.setText(response.body().get(0).getSchool_name());
                    school_fees.setText(response.body().get(0).getTuition_fees());
                    transport_fees.setText(response.body().get(0).getTransfer_fees_1());
                }else {
                    Toast.makeText(ActivitySchoolFees.this, "No Data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<School_Fees_Model>> call, Throwable t) {

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
        Calligrapher calligrapher = new Calligrapher(this);
        calligrapher.setFont(this, "JannaLT-Regular.ttf", true);

        school_name =findViewById(R.id.txt_school_name);
        school_fees =findViewById(R.id.txt_school_fees);
        transport_fees=findViewById(R.id.txt_school_trans);


    }
}
