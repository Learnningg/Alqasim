package com.Alatheer.m.schooles.Services;

import com.Alatheer.m.schooles.Models.AllSchoolModel;
import com.Alatheer.m.schooles.Models.School_Stages1;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by elashry on 3/3/2018.
 */

public interface Service {

    ///////////////////////////////---------Display All Schools---------//////////////////
    @GET("Api/AllSchool")
    Call<List<AllSchoolModel>>DiaplayAll_Schools();

    ///////////////////////////////---------Schools_SubClasses---------//////////////////
    @GET("Api/SchoolStages/{id_school}")
    Call <School_Stages1> DisplayAll_SubClasses(@Path("id_school") String id_school);

}
