package com.whombang.app.mvp.component;

import com.whombang.app.features.sendtask.ServicePhoneActivity;
import com.whombang.app.mvp.module.ServicePhoneModule;

import dagger.Component;

/**
 * Created by sundy.jiang on 2018/1/3.
 */
@Component(modules = ServicePhoneModule.class)
public interface ServicePhoneComponent {
    void inject(ServicePhoneActivity activity);
}
