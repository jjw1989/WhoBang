package com.whombang.app.features.mycenter.activity;

import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.whombang.app.R;
import com.whombang.app.common.base.BaseActivity;

/**
 * 修改密码
 */
@Route(path = "/set/modifypwd")
public class ModifyPwdActivity extends BaseActivity {

    @Override
    protected int bindLayout() {
        return R.layout.wb_modify_pwd_layout;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        titleBar.setTitle("修改密码");
    }

    @Override
    public void doBusiness() {

    }
}
