package com.whombang.app.mvp.component;

import com.whombang.app.features.mycenter.activity.ServiceOrderDetailsActivity;
import com.whombang.app.mvp.module.ServiceOrderDetailsModule;

import dagger.Component;

/**
 * Created by David on 2017/12/21.
 */
@Component(modules = ServiceOrderDetailsModule.class)
public interface ServiceOrderDetailsComponent {
    void inject(ServiceOrderDetailsActivity activity);
}
