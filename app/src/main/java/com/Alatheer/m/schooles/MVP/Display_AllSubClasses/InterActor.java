package com.Alatheer.m.schooles.MVP.Display_AllSubClasses;

import android.content.Context;

import com.Alatheer.m.schooles.Models.School_Stages1;

/**
 * Created by elashry on 3/3/2018.
 */

public interface InterActor {

    interface onCompleteListener
    {
        void OnDisplayDataSuccess(School_Stages1 schools_stages1);
        void OnFailed(String error);
    }

    void DisplayAllSubClasses(String id_school,InterActor.onCompleteListener listener, Context context);

}
