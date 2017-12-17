package com.whombang.app.mvp.presenter;

import com.whombang.app.features.mycenter.activity.EvaluateActivity;

import javax.inject.Inject;

/**
 * Created by David on 2017/12/17.
 */

public class EvaluatePresenter {
    private EvaluateActivity activity;

    @Inject
    public EvaluatePresenter(EvaluateActivity activity){
        this.activity=activity;
    }
}
