package com.whombang.app.mvp.component;

import com.whombang.app.features.login.ForgetActivity;
import com.whombang.app.mvp.module.ForgetActivityModule;

import dagger.Component;

/**
 * Created by sundy.jiang on 2017/12/14.
 */
@Component(modules = ForgetActivityModule.class)
public interface ForgetActivityComponent {
    void inject(ForgetActivity forgetActivity);
}
