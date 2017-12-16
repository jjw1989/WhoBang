package com.whombang.app.mvp.component;

import com.whombang.app.features.mycenter.activity.AddressManagerActivity;
import com.whombang.app.mvp.module.AddressManagerModule;

import dagger.Component;

/**
 * Created by David on 2017/12/16.
 */
@Component(modules = AddressManagerModule.class)
public interface AddressManagerComponent {
    void inject(AddressManagerActivity activity);
}
