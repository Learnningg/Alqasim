package com.Alatheer.m.schooles.MVP.LoginMVP;

import android.content.Context;

import com.Alatheer.m.schooles.Models.AllSchoolModel;
import com.Alatheer.m.schooles.Models.LoginModel;

import java.util.List;

/**
 * Created by elashry on 3/3/2018.
 */

public interface InterActor {

    interface onCompleteListener
    {
        void setUserIdError();
        void setNationalIdError();
        void OnDisplayDataSuccess(LoginModel loginModel);
        void OnFailed(String error);
    }

    void Login(String user_id,InterActor.onCompleteListener listener,Context context);

}
