package com.Alatheer.m.schooles.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.Alatheer.m.schooles.Adapters.HonorBoardStudentAdapter;
import com.Alatheer.m.schooles.Models.HonerModel;
import com.Alatheer.m.schooles.R;
import com.Alatheer.m.schooles.Services.Service;
import com.Alatheer.m.schooles.Services.ServicesApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HonorBoardStudent extends AppCompatActivity {
    ArrayList<HonerModel> model;
    HonorBoardStudentAdapter adapter;
    RecyclerView recyclerView;
    //String id;
    private LinearLayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_honor_board_student);


        recyclerView = findViewById(R.id.rec_honor);

        model = new ArrayList<>();

        mLayoutManager=new LinearLayoutManager(this);
        mLayoutManager.setReverseLayout(true);
        mLayoutManager.setStackFromEnd(true);

        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setHasFixedSize(true);

        adapter = new HonorBoardStudentAdapter(this, model);
        recyclerView.setAdapter(adapter);


        Service service = ServicesApi.CreateApiClient().create(Service.class);
        Call<List<HonerModel>> call = service.HonorBoardStudent("");
        call.enqueue(new Callback<List<HonerModel>>() {
            @Override
            public void onResponse(Call<List<HonerModel>> call, Response<List<HonerModel> > response) {


                model.addAll( response.body());
                adapter.notifyDataSetChanged();


            }

            @Override
            public void onFailure(Call<List<HonerModel>> call, Throwable t) {

                 Toast.makeText(HonorBoardStudent.this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });


    }
}
