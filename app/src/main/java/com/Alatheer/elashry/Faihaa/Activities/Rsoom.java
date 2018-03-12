package com.Alatheer.elashry.Faihaa.Activities;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.Alatheer.elashry.Faihaa.Adapters.Fees_Adapter;
import com.Alatheer.elashry.Faihaa.Models.School_Fees_Model;
import com.Alatheer.elashry.Faihaa.R;
import com.Alatheer.elashry.Faihaa.Services.Service;
import com.Alatheer.elashry.Faihaa.Services.ServicesApi;

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
    private ProgressBar progBar;
    private LinearLayout nodata_container;
    private SwipeRefreshLayout sr;
    String school_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rsoom);


        initView();
        getDataFromIntent();
        getDataFromServer();

    }

    private void initView() {
        sr = findViewById(R.id.sr);
        sr.setRefreshing(false);
        progBar = findViewById(R.id.progBar);
        progBar.getIndeterminateDrawable().setColorFilter(ContextCompat.getColor(this,R.color.colorPrimary), PorterDuff.Mode.SRC_IN);
        nodata_container = findViewById(R.id.nodata_container);
        Calligrapher calligrapher = new Calligrapher(this);
        calligrapher.setFont(this, "JannaLT-Regular.ttf", true);
        recyclerView = findViewById(R.id.recView_fees);
        feesList = new ArrayList<>();
        recyclerView.setLayoutManager(new GridLayoutManager(Rsoom.this, 1));
        recyclerView.setHasFixedSize(true);
        allNewsAdapter = new Fees_Adapter(Rsoom.this,feesList);
        recyclerView.setAdapter(allNewsAdapter);

        sr.setColorSchemeResources(R.color.colorPrimary);
        sr.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getDataFromServer();
            }
        });
    }

    private void getDataFromServer() {
        progBar.setVisibility(View.VISIBLE);

        Service service = ServicesApi.CreateApiClient().create(Service.class);
        Call<List<School_Fees_Model>> call = service.GetSchoolFees("1");

        call.enqueue(new Callback<List<School_Fees_Model>>() {
            @Override
            public void onResponse(Call<List<School_Fees_Model>> call, Response<List<School_Fees_Model>> response) {


                feesList.clear();
                feesList.addAll(response.body());
                allNewsAdapter.notifyDataSetChanged();

                if (feesList.size()>0)
                {
                    progBar.setVisibility(View.GONE);
                    sr.setRefreshing(false);

                }else
                    {
                        progBar.setVisibility(View.GONE);
                        nodata_container.setVisibility(View.VISIBLE);
                        sr.setRefreshing(false);
                    }
            }

            @Override
            public void onFailure(Call<List<School_Fees_Model>> call, Throwable t) {
                nodata_container.setVisibility(View.GONE);
                sr.setRefreshing(false);
                progBar.setVisibility(View.GONE);



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
