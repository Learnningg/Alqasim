package com.Alatheer.Riad.Alqassim.MVP.DisplaySubClasses;

import com.Alatheer.Riad.Alqassim.Models.SubClasses;

import java.util.List;

/**
 * Created by elashry on 3/3/2018.
 */

public interface ViewData {

    void OnDisplayDataSuccess(List<SubClasses> subClasses);
    void OnFailed(String error);
}
