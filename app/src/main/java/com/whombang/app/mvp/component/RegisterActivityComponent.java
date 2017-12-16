package com.whombang.app.mvp.component;

import com.whombang.app.features.login.RegisterActivity;
import com.whombang.app.mvp.module.RegisterActivityModule;

import dagger.Component;

/**
 * Created by sundy.jiang on 2017/12/5.
 */
@Component(modules = RegisterActivityModule.class)
public interface RegisterActivityComponent{
    void inject(RegisterActivity registerActivity);
}