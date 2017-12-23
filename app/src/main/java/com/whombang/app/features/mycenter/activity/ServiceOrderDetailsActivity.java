package com.whombang.app.features.mycenter.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.whombang.app.R;
import com.whombang.app.common.base.BaseActivity;

/**
 * 服务订单详情
 */
@Route(path = "")
public class ServiceOrderDetailsActivity extends BaseActivity {

    @Override
    protected int bindLayout() {
        return R.layout.wb_service_order_details_layout;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        titleBar.setTitle("订单详情");
    }

    @Override
    public void doBusiness() {

    }
}
