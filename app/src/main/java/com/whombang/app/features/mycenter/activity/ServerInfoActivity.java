package com.whombang.app.features.mycenter.activity;

import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.whombang.app.R;
import com.whombang.app.common.base.BaseActivity;

/**
 * 服务提供者信息列表
 */
@Route(path = "/my/info")
public class ServerInfoActivity extends BaseActivity {
    @Override
    protected int bindLayout() {
        return R.layout.wb_server_info_layout;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
      titleBar.setTitle("服务提供者信息列表");
    }

    @Override
    public void doBusiness() {

    }
}
