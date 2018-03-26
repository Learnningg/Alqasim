package com.Alatheer.Riad.Alqassim.MVP.LoginMVP;

import com.Alatheer.Riad.Alqassim.Models.LoginModel;

/**
 * Created by elashry on 3/3/2018.
 */

public interface ViewData {

    void setUserIdError();
    void setNationalIdError();
    void OnDisplayDataSuccess(LoginModel loginModel);
    void OnFailed(String error);
}
