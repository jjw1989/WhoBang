package com.whombang.app.mvp.component;

import com.whombang.app.features.mycenter.activity.ModifyPwdActivity;
import com.whombang.app.mvp.module.ModifyPwdModule;

import dagger.Component;

/**
 * Created by sundy.jiang on 2018/1/10.
 */
@Component(modules = ModifyPwdModule.class)
public interface ModifyPwdComponent {
    void inject(ModifyPwdActivity activity);
}
