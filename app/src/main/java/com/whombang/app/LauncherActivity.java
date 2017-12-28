package com.whombang.app;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.whombang.app.common.base.BaseActivity;
import com.whombang.app.mvp.component.DaggerLauncherActivityComponent;
import com.whombang.app.mvp.module.LauncherActivityModule;
import com.whombang.app.mvp.presenter.LauncherPresenter;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * 启动页
 */
public class LauncherActivity extends BaseActivity {
    @BindView(R.id.img_logo)
    ImageView imgLogo;

    @Inject
    LauncherPresenter presenter;

    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return R.layout.wb_lanucher_layout;
    }

    @Override
    protected void initInjector() {
        DaggerLauncherActivityComponent.builder().launcherActivityModule(new LauncherActivityModule(this)).build().inject(this);
    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {

    }

    @Override
    public void doBusiness() {
        titleBar.setVisibility(View.GONE);
        presenter.onStartAnimAndJump(imgLogo);
    }
}
