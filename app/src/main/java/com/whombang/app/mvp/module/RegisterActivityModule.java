package com.whombang.app.mvp.module;

import com.whombang.app.features.login.RegisterActivity;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sundy.jiang on 2017/12/13.
 */
@Module
public class RegisterActivityModule {
    private RegisterActivity registerActivity;


    public RegisterActivityModule(RegisterActivity registerActivity){
        this.registerActivity=registerActivity;
    }

    @Provides
    RegisterActivity provideRegisterActivity(){
        return registerActivity;
    }
}
