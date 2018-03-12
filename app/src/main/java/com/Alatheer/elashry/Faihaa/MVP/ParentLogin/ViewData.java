package com.Alatheer.elashry.Faihaa.MVP.ParentLogin;

import com.Alatheer.elashry.Faihaa.Models.LoginModel;
import com.Alatheer.elashry.Faihaa.Models.ParentLoginModel;

/**
 * Created by elashry on 3/3/2018.
 */

public interface ViewData {

    void setUserIdError();
    void setNationalIdError();
    void OnDisplayDataSuccess(ParentLoginModel parentLoginModel);
    void OnFailed(String error);
}
