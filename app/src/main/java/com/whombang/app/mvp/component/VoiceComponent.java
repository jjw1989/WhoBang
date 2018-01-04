package com.whombang.app.mvp.component;

import com.whombang.app.features.sendtask.VoiceActivity;
import com.whombang.app.mvp.module.VoiceModule;

import dagger.Component;

/**
 * Created by sundy.jiang on 2018/1/4.
 */
@Component(modules = VoiceModule.class)
public interface VoiceComponent {
    void inject(VoiceActivity activity);
}
