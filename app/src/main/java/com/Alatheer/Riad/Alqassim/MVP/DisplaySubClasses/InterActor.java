package com.Alatheer.Riad.Alqassim.MVP.DisplaySubClasses;

import android.content.Context;

import com.Alatheer.Riad.Alqassim.Models.SubClasses;

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
