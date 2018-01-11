package com.whombang.app.features.home.activity;

import android.os.Bundle;
import android.view.View;

import com.whombang.app.R;
import com.whombang.app.common.base.BaseActivity;

/**
 * 收货地址
 */
public class ConsigneeAddressManagerActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wb_consignee_address_manager_layout);
    }

    @Override
    protected int bindLayout() {
        return R.layout.wb_consignee_address_manager_layout;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
       titleBar.setTitle("收货地址");
    }

    @Override
    public void doBusiness() {

    }
}
