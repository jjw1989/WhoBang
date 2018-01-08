package com.whombang.app.mvp.component;

import com.whombang.app.features.sendtask.StationServiceActivity;
import com.whombang.app.mvp.module.StationServiceModule;

import dagger.Component;

/**
 * Created by sundy.jiang on 2018/1/8.
 */
@Component(modules = StationServiceModule.class)
public interface StationServiceComponent {
    void inject(StationServiceActivity activity);
}
