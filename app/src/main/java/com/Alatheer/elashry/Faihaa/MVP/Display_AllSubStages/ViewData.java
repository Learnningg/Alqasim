package com.Alatheer.elashry.Faihaa.MVP.Display_AllSubStages;

import com.Alatheer.elashry.Faihaa.Models.School_Stages1;

/**
 * Created by elashry on 3/3/2018.
 */

public interface ViewData {

    void OnDisplayDataSuccess(School_Stages1 schools_stages1);
    void OnFailed(String error);
}
