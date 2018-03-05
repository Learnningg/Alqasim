package com.Alatheer.m.schooles.MVP.Display_AllSubStages;

import com.Alatheer.m.schooles.Models.School_Stages1;

/**
 * Created by elashry on 3/3/2018.
 */

public interface ViewData {

    void OnDisplayDataSuccess(School_Stages1 schools_stages1);
    void OnFailed(String error);
}
