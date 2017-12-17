package com.whombang.app.mvp.component;

import com.whombang.app.features.sendtask.TextTaskActivity;
import com.whombang.app.mvp.module.TextTaskModule;

import dagger.Component;

/**
 * Created by David on 2017/12/17.
 */
@Component(modules = TextTaskModule.class)
public interface TextTaskComponent {
    void inject(TextTaskActivity activity);
}
