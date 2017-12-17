package com.whombang.app.mvp.module;

import com.whombang.app.features.mycenter.activity.EvaluateActivity;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

/**
 * Created by David on 2017/12/17.
 */
@Module
public class EvaluateModule {
    private EvaluateActivity activity;

    @Inject
    public EvaluateModule(EvaluateActivity activity){
        this.activity=activity;
    }

    @Provides
    EvaluateActivity provideEvaluateActivity(){
        return activity;
    }
}
