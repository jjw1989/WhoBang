package com.whombang.app.mvp.module;

import com.whombang.app.features.sendtask.VoiceActivity;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sundy.jiang on 2018/1/4.
 */
@Module
public class VoiceModule {
    private VoiceActivity activity;

    @Inject
    public VoiceModule(VoiceActivity activity){
        this.activity=activity;
    }

    @Provides
    VoiceActivity provideVoiceActivity(){
        return  activity;
    }
}
