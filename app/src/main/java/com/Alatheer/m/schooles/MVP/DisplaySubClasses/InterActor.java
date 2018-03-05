package com.Alatheer.m.schooles.MVP.DisplaySubClasses;

import android.content.Context;

import com.Alatheer.m.schooles.Models.School_Stages1;
import com.Alatheer.m.schooles.Models.SubClasses;

import java.util.List;

/**
 * Created by elashry on 3/3/2018.
 */

public interface InterActor {

    interface onCompleteListener
    {
        void OnDisplayDataSuccess(List<SubClasses> subClasses);
        void OnFailed(String error);
    }

    void DisplayAllSubClasses(String id_school, InterActor.onCompleteListener listener, Context context);

}
