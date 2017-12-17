package com.whombang.app.mvp.component;

import com.whombang.app.features.mycenter.activity.NewlyAddressActivity;
import com.whombang.app.mvp.module.NewlyAddressModule;

import dagger.Component;

/**
 * Created by David on 2017/12/17.
 */
@Component(modules = NewlyAddressModule.class)
public interface NewlyAddressComponent {
    void inject(NewlyAddressActivity activity);
}
