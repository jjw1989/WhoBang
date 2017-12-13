package com.whombang.app.mvp.module;

import com.whombang.app.features.login.LoginActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sundy.jiang on 2017/12/13.
 */
@Module
public class LoginActivityModule {
    private LoginActivity loginActivity;
    public LoginActivityModule(LoginActivity loginActivity){
        this.loginActivity=loginActivity;
    }

    @Provides
    LoginActivity provideTrailActivity(){
        return loginActivity;
    }
}
