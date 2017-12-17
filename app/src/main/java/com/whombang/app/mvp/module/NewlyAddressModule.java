package com.whombang.app.mvp.module;

import com.whombang.app.features.mycenter.activity.NewlyAddressActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by David on 2017/12/17.
 */
@Module
public class NewlyAddressModule {
    private NewlyAddressActivity activity;

    public NewlyAddressModule(NewlyAddressActivity activity) {
        this.activity = activity;
    }

    @Provides
    NewlyAddressActivity provideNewlyAddressActivity() {
        return activity;
    }
}
