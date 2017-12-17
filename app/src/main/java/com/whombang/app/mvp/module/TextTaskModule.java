package com.whombang.app.mvp.module;

import com.whombang.app.features.sendtask.TextTaskActivity;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

/**
 * Created by David on 2017/12/17.
 */
@Module
public class TextTaskModule {
    private TextTaskActivity activity;

    @Inject
    public TextTaskModule(TextTaskActivity activity){
        this.activity=activity;
    }

    @Provides
    TextTaskActivity provideTextTaskActivity(){
        return activity;
    }
}
