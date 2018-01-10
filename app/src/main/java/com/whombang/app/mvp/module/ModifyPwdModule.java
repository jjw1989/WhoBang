package com.whombang.app.mvp.module;

import com.whombang.app.features.mycenter.activity.ModifyPwdActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sundy.jiang on 2018/1/10.
 */
@Module
public class ModifyPwdModule {
    private ModifyPwdActivity activity;

    public ModifyPwdModule(ModifyPwdActivity activity){
        this.activity=activity;
    }

    @Provides
    ModifyPwdActivity provideModifyPwdActivity(){
        return activity;
    }
}
