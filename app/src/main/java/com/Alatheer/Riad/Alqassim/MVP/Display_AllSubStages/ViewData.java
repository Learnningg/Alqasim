package com.Alatheer.Riad.Alqassim.MVP.Display_AllSubStages;

import com.Alatheer.Riad.Alqassim.Models.School_Stages1;

/**
 * Created by elashry on 3/3/2018.
 */

public interface ViewData {

    void OnDisplayDataSuccess(School_Stages1 schools_stages1);
    void OnFailed(String error);
}
