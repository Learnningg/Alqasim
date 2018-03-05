package com.Alatheer.m.schooles.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.Alatheer.m.schooles.Adapters.All_News_Adapter;
import com.Alatheer.m.schooles.Models.News_Model;
import com.Alatheer.m.schooles.R;
import com.Alatheer.m.schooles.Services.ServicesApi;
import com.Alatheer.m.schooles.Services.Service;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    All_News_Adapter allNewsAdapter;
    ArrayList<News_Model> newsList ;

    String school_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getDataFromIntent();
        initView();
        getDataFromServer();

    }

    private void initView() {
        recyclerView = findViewById(R.id.recyc);
        newsList = new ArrayList<>();
        recyclerView.setLayoutManager(new GridLayoutManager(NewsActivity.this, 1));
        recyclerView.setHasFixedSize(true);
        allNewsAdapter = new All_News_Adapter(NewsActivity.this,newsList);
        recyclerView.setAdapter(allNewsAdapter);

    }

    private void getDataFromServer() {

        Service service = ServicesApi.CreateApiClient().create(Service.class);
        Call<List<News_Model>> call = service.getNewsData(school_id);

        call.enqueue(new Callback<List<News_Model>>() {
            @Override
            public void onResponse(Call<List<News_Model>> call, Response<List<News_Model>> response) {

                newsList.addAll(response.body());
                allNewsAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<List<News_Model>> call, Throwable t) {
                Toast.makeText(NewsActivity.this, "fail"+t, Toast.LENGTH_SHORT).show();


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
