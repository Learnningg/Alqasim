package com.Alatheer.m.schooles.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.Alatheer.m.schooles.Adapters.Adapter;
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
    Adapter adapter;
    ArrayList<News_Model> newsList ;

    public static String [] title={
            "اول خبر",
            "ثاني خبر ",

    };
    public static String [] desc={
            "اول خبراول خبراول خبراول خبراول خبراول خبر",
            "ثاني خبرثاني خبرثاني خبرثاني خبرثاني خبر ",

    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyc);
        newsList = new ArrayList<>();
        recyclerView.setLayoutManager(new GridLayoutManager(NewsActivity.this, 1));
        recyclerView.setHasFixedSize(true);

        adapter = new Adapter(NewsActivity.this,newsList);

        recyclerView.setAdapter(adapter);


        Service service = ServicesApi.CreateApiClient().create(Service.class);
        Call<List<News_Model>> call = service.getNewsData("2");

        call.enqueue(new Callback<List<News_Model>>() {
            @Override
            public void onResponse(Call<List<News_Model>> call, Response<List<News_Model>> response) {

                newsList.addAll(response.body());
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<List<News_Model>> call, Throwable t) {
                Toast.makeText(NewsActivity.this, "fail"+t, Toast.LENGTH_SHORT).show();


            }
        });
    }
}
