package com.whombang.app.mvp.module;

import com.whombang.app.features.mycenter.activity.ServerInfoActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sundy.jiang on 2017/12/27.
 */
@Module
public class ServerInfoModule {
    private ServerInfoActivity activity;

    public ServerInfoModule(ServerInfoActivity activity){
        this.activity=activity;
    }

    @Provides
    ServerInfoActivity provideServerInfoActivity(){
        return activity;
    }
}
