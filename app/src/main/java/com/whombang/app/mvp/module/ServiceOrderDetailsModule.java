package com.whombang.app.mvp.module;

import com.whombang.app.features.mycenter.activity.ServiceOrderDetailsActivity;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

/**
 * Created by David on 2017/12/21.
 */
@Module
public class ServiceOrderDetailsModule {
    private ServiceOrderDetailsActivity activity;

    @Inject
    public ServiceOrderDetailsModule(ServiceOrderDetailsActivity activity){
        this.activity=activity;
    }

    @Provides
    ServiceOrderDetailsActivity provideServiceOrderDetails(){
        return activity;
    }
}
