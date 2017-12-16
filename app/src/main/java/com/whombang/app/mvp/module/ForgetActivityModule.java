package com.whombang.app.mvp.module;

import com.whombang.app.features.login.ForgetActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sundy.jiang on 2017/12/14.
 */
@Module
public class ForgetActivityModule {
    private ForgetActivity forgetActivity;

    public ForgetActivityModule(ForgetActivity forgetActivity){
        this.forgetActivity=forgetActivity;
    }

    @Provides
    ForgetActivity provideForgetActivity(){
        return forgetActivity;
    }
}
