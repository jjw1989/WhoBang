package com.whombang.app.features.login;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.gxz.PagerSlidingTabStrip;
import com.whombang.app.R;
import com.whombang.app.adapter.ItemTitlePagerAdapter;
import com.whombang.app.common.base.BaseActivity;
import com.whombang.app.common.view.EasyIndicator;
import com.whombang.app.common.view.NoScrollViewPager;
import com.whombang.app.features.login.fragment.PassWordLoginFragment;
import com.whombang.app.features.login.fragment.SMSLoginFragment;
import com.whombang.app.features.shop.fragment.GoodsCommentFragment;
import com.whombang.app.features.shop.fragment.GoodsDetailFragment;
import com.whombang.app.features.shop.fragment.GoodsInfoFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 用户注册
 */
@Route(path = "/user/register")
public class RegisterActivity extends BaseActivity {

    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return R.layout.wb_register_layout;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        titleBar.setTitle("注册");

    }

    @Override
    public void doBusiness() {

    }
}
