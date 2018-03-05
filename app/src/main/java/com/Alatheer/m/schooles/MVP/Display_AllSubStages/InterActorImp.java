package com.Alatheer.m.schooles.MVP.Display_AllSubStages;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.Alatheer.m.schooles.Models.School_Stages1;
import com.Alatheer.m.schooles.Services.Service;
import com.Alatheer.m.schooles.Services.ServicesApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by elashry on 3/3/2018.
 */

public class InterActorImp implements InterActor {



    @Override
    public void DisplayAll_SubStages(String id_school,final onCompleteListener listener, final Context context) {

        Retrofit retrofit = ServicesApi.CreateApiClient();
        Service service = retrofit.create(Service.class);
        Call<School_Stages1> call = service.DisplayAll_SubStages(id_school);
        call.enqueue(new Callback<School_Stages1>() {
            @Override
            public void onResponse(Call<School_Stages1> call, Response<School_Stages1> response) {
                if (response.isSuccessful())
                {
                    School_Stages1 schools_stages1 = response.body();
                    listener.OnDisplayDataSuccess(schools_stages1);
                }else
                    {
                        listener.OnFailed("error something went haywire");
                    }
            }

            @Override
            public void onFailure(Call<School_Stages1> call, Throwable t) {
                listener.OnFailed("error check network connection ");
                Log.e("error",t.getMessage());
                Toast.makeText(context, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
