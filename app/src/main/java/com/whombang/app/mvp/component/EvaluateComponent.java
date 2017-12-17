package com.whombang.app.mvp.component;

import com.whombang.app.features.mycenter.activity.EvaluateActivity;
import com.whombang.app.mvp.module.EvaluateModule;

import dagger.Component;

/**
 * Created by David on 2017/12/17.
 */
@Component(modules = EvaluateModule.class)
public interface EvaluateComponent {
    void inject(EvaluateActivity activity);
}
