package com.Alatheer.m.schooles.Services;

import com.Alatheer.m.schooles.Models.AllSchoolModel;
import com.Alatheer.m.schooles.Models.HonerModel;
import com.Alatheer.m.schooles.Models.News_Model;
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

    ///////////////////////////////---------news Schools---------//////////////////

    @GET("Api/AllNews/{class_id}")
    Call<List<News_Model>> getNewsData(@Path( "class_id") String class_id);

    @GET("Api/HonorBoardStudent/{class_id")
    Call<List<HonerModel>> HonorBoardStudent(@Path( "class_id") String class_id);



    @GET("Api/SchoolStages/{id_school")
    Call<School_Stages1> DisplayAll_SubClasses(@Path( "id_school") String id_school);
}
