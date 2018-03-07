package com.Alatheer.m.schooles.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.Alatheer.m.schooles.Adapters.All_News_Adapter;
import com.Alatheer.m.schooles.Adapters.Fees_Adapter;
import com.Alatheer.m.schooles.Models.News_Model;
import com.Alatheer.m.schooles.Models.School_Fees_Model;
import com.Alatheer.m.schooles.R;
import com.Alatheer.m.schooles.Services.Service;
import com.Alatheer.m.schooles.Services.ServicesApi;

import java.util.ArrayList;
import java.util.List;

import me.anwarshahriar.calligrapher.Calligrapher;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Rsoom extends AppCompatActivity {
    RecyclerView recyclerView;
    Fees_Adapter allNewsAdapter;
    ArrayList<School_Fees_Model> feesList ;

    String school_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rsoom);

        getDataFromIntent();
        initView();
        getDataFromServer();

    }

    private void initView() {
        Calligrapher calligrapher = new Calligrapher(this);
        calligrapher.setFont(this, "JannaLT-Regular.ttf", true);
        recyclerView = findViewById(R.id.recView_fees);
        feesList = new ArrayList<>();
        recyclerView.setLayoutManager(new GridLayoutManager(Rsoom.this, 1));
        recyclerView.setHasFixedSize(true);
        allNewsAdapter = new Fees_Adapter(Rsoom.this,feesList);
        recyclerView.setAdapter(allNewsAdapter);

    }

    private void getDataFromServer() {

        Service service = ServicesApi.CreateApiClient().create(Service.class);
        Call<List<School_Fees_Model>> call = service.GetSchoolFees(school_id);

        call.enqueue(new Callback<List<School_Fees_Model>>() {
            @Override
            public void onResponse(Call<List<School_Fees_Model>> call, Response<List<School_Fees_Model>> response) {

                feesList.clear();
                feesList.addAll(response.body());
                allNewsAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<List<School_Fees_Model>> call, Throwable t) {
                Toast.makeText(Rsoom.this, "fail"+t, Toast.LENGTH_SHORT).show();


            }
        });
    }


    private void getDataFromIntent() {
        Intent intent = getIntent();
        if (intent !=null)
        {
            if(intent.hasExtra("school_id"))
            {
                school_id = intent.getStringExtra("school_id");
            }
        }
    }




}
