package com.whombang.app.features.mycenter.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.whombang.app.R;
import com.whombang.app.common.base.BaseActivity;

/**
 * 设置性别：
 */
@Route(path = "/set/modifysex")
public class SetSexActivity extends BaseActivity {
    @Override
    protected int bindLayout() {
        return R.layout.wb_set_sex_layout;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
       titleBar.setTitle("修改性别");
    }

    @Override
    public void doBusiness() {

    }
}
