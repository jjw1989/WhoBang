package com.whombang.app.mvp.module;

import com.whombang.app.features.sendtask.ServicePhoneActivity;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sundy.jiang on 2018/1/3.
 */
@Module
public class ServicePhoneModule {
    private ServicePhoneActivity activity;

    @Inject
    public ServicePhoneModule(ServicePhoneActivity activity){
        this.activity=activity;
    }
    @Provides
    ServicePhoneActivity provideServicePhoneActivity(){
        return activity;
    }
}
