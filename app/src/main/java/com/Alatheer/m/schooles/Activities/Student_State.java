package com.Alatheer.m.schooles.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.Alatheer.m.schooles.Adapters.HonorBoardStudentAdapter;
import com.Alatheer.m.schooles.Adapters.StudentStateAdapter;
import com.Alatheer.m.schooles.Models.HonerModel;
import com.Alatheer.m.schooles.Models.Student_State_Model;
import com.Alatheer.m.schooles.R;
import com.Alatheer.m.schooles.Services.Service;
import com.Alatheer.m.schooles.Services.ServicesApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class Student_State extends AppCompatActivity {
    ArrayList<Student_State_Model> model;
    StudentStateAdapter adapter;
    RecyclerView recyclerView;
    private LinearLayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_state);

        getDataFromIntent();
        initView();
        getDataFromServer();

    }

    private void getDataFromServer() {


        Service service = ServicesApi.CreateApiClient().create(Service.class);
        Call<List<Student_State_Model>> call = service.EvaluationStudent("");
        call.enqueue(new Callback<List<Student_State_Model>>() {
            @Override
            public void onResponse(Call<List<Student_State_Model>> call, Response<List<Student_State_Model> > response) {


                model.addAll( response.body());
                adapter.notifyDataSetChanged();


            }

            @Override
            public void onFailure(Call<List<Student_State_Model>> call, Throwable t) {

                Toast.makeText(Student_State.this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void initView() {
        recyclerView = findViewById(R.id.rec_student_state);
        model = new ArrayList<>();
        mLayoutManager=new LinearLayoutManager(this);
        mLayoutManager.setReverseLayout(true);
        mLayoutManager.setStackFromEnd(true);

        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setHasFixedSize(true);

        adapter = new StudentStateAdapter(this, model);
        recyclerView.setAdapter(adapter);
    }

    private void getDataFromIntent() {



    }


}
