package com.whombang.app.mvp.component;

import com.whombang.app.features.login.LoginActivity;
import com.whombang.app.mvp.module.LoginActivityModule;

import dagger.Component;

/**
 * Created by sundy.jiang on 2017/12/13.
 */
@Component(modules = LoginActivityModule.class)
public interface LoginActivityComponent {
    void inject(LoginActivity loginActivity);
}
