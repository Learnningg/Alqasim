package com.Alatheer.Riad.Alqassim.MVP.ParentLogin;

import com.Alatheer.Riad.Alqassim.Models.ParentLoginModel;

/**
 * Created by elashry on 3/3/2018.
 */

public interface ViewData {

    void setUserIdError();
    void setNationalIdError();
    void OnDisplayDataSuccess(ParentLoginModel parentLoginModel);
    void OnFailed(String error);
}
