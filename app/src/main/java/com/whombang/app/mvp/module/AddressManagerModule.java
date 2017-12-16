package com.whombang.app.mvp.module;

import com.whombang.app.features.mycenter.activity.AddressManagerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by David on 2017/12/16.
 */
@Module
public class AddressManagerModule {
    private AddressManagerActivity activity;

    public AddressManagerModule(AddressManagerActivity activity) {
        this.activity = activity;
    }
    @Provides
    AddressManagerActivity provideAddressManagerActivity() {
        return activity;
    }
}
