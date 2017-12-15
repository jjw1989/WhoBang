package com.whombang.app.features.mycenter.activity;

import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.whombang.app.R;
import com.whombang.app.common.base.BaseActivity;

/**
 * 提供商品列表
 */
@Route(path = "/my/goods")
public class OfferGoodsActivity extends BaseActivity {

    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return R.layout.wb_user_information_layout;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        titleBar.setTitle("提供商品列表");
    }

    @Override
    public void doBusiness() {

    }
}
