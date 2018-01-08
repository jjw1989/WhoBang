package com.whombang.app.mvp.module;

import com.whombang.app.features.sendtask.StationServiceActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sundy.jiang on 2018/1/8.
 */
@Module
public class StationServiceModule {
    private StationServiceActivity activity;

    public StationServiceModule(StationServiceActivity activity){
        this.activity=activity;
    }

    @Provides
    StationServiceActivity provideStationServiceActivity(){
        return activity;
    }
}
