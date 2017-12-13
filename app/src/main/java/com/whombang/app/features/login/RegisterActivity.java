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
    @BindView(R.id.easy_indicator)
    EasyIndicator tabStrip;
    @BindView(R.id.vp_content)
    NoScrollViewPager viewPager;
    private List<Fragment> fragmentList;
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
        fragmentList = new ArrayList<>();
        fragmentList.add(new GoodsInfoFragment());
        fragmentList.add(new GoodsDetailFragment());
        viewPager.setNoScroll(true);
        tabStrip.setTabTitles(new String[]{"密码登录", "验证码登录"});
        tabStrip.setViewPage(viewPager,new ItemTitlePagerAdapter(getSupportFragmentManager(), fragmentList, new String[]{"密码登录", "验证码登录"}));
        tabStrip.setOnTabClickListener(new EasyIndicator.onTabClickListener() {
            @Override
            public void onTabClick(String title, int position) {

            }
        });
    }

    @Override
    public void doBusiness() {

    }
}
