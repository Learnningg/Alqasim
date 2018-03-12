package com.Alatheer.elashry.Faihaa.MVP.ParentLogin;

import android.content.Context;

import com.Alatheer.elashry.Faihaa.Models.LoginModel;
import com.Alatheer.elashry.Faihaa.Models.ParentLoginModel;

/**
 * Created by elashry on 3/3/2018.
 */

public interface InterActor {

    interface onCompleteListener
    {
        void setUserIdError();
        void setNationalIdError();
        void OnDisplayDataSuccess(ParentLoginModel parentLoginModel);
        void OnFailed(String error);
    }

    void Login(String user_id, InterActor.onCompleteListener listener, Context context);

}
