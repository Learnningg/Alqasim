package com.Alatheer.Riad.Alqassim.MVP.ParentLogin;

import android.content.Context;

import com.Alatheer.Riad.Alqassim.Models.ParentLoginModel;

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
