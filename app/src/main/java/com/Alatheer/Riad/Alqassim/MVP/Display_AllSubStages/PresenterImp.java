package com.Alatheer.Riad.Alqassim.MVP.Display_AllSubStages;

import android.content.Context;

import com.Alatheer.Riad.Alqassim.Models.School_Stages1;

/**
 * Created by elashry on 3/3/2018.
 */

public class PresenterImp implements Presenter ,InterActor.onCompleteListener{

    private ViewData viewData;
    private InterActor interActor;
    private Context context;

    public PresenterImp(ViewData viewData, Context context) {
        this.viewData = viewData;
        this.context = context;
        interActor = new InterActorImp();
    }

    @Override
    public void DisplayAll_SubStages(String id_school) {
        interActor.DisplayAll_SubStages(id_school,this,context);
    }

    @Override
    public void OnDisplayDataSuccess(School_Stages1 schools_stages1) {
        if (viewData!=null)
        {
            viewData.OnDisplayDataSuccess(schools_stages1);
        }
    }

    @Override
    public void OnFailed(String error) {
        if (viewData!=null)
        {
            viewData.OnFailed(error);
        }
    }
}
