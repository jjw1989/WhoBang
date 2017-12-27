package com.whombang.app.mvp.component;

import com.whombang.app.features.mycenter.activity.ServerInfoActivity;
import com.whombang.app.mvp.module.ServerInfoModule;

import dagger.Component;

/**
 * Created by sundy.jiang on 2017/12/27.
 */
@Component(modules = ServerInfoModule.class)
public interface ServerInfoComponent {
    void inject(ServerInfoActivity activity);
}
