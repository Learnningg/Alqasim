package com.Alatheer.Riad.Alqassim.MVP.Display_AllSubStages;

import android.content.Context;

import com.Alatheer.Riad.Alqassim.Models.School_Stages1;

/**
 * Created by elashry on 3/3/2018.
 */

public interface InterActor {

    interface onCompleteListener
    {
        void OnDisplayDataSuccess(School_Stages1 schools_stages1);
        void OnFailed(String error);
    }

    void DisplayAll_SubStages(String id_school,InterActor.onCompleteListener listener, Context context);

}
