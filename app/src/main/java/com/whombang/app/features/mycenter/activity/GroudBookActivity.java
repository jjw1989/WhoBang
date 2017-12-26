package com.whombang.app.features.mycenter.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.whombang.app.R;
import com.whombang.app.adapter.ItemTitlePagerAdapter;
import com.whombang.app.common.base.BaseActivity;
import com.whombang.app.common.view.EasyIndicator;
import com.whombang.app.common.view.NoScrollViewPager;
import com.whombang.app.features.login.fragment.PassWordLoginFragment;
import com.whombang.app.features.login.fragment.SMSLoginFragment;
import com.whombang.app.features.mycenter.fragment.AwaitHarvestFragment;
import com.whombang.app.features.mycenter.fragment.AwaitServiceFragment;
import com.whombang.app.features.mycenter.fragment.EvaluatedFragment;
import com.whombang.app.features.mycenter.fragment.FinishFragment;
import com.whombang.app.features.mycenter.fragment.GoodsFinishFragment;
import com.whombang.app.features.mycenter.fragment.GoodsListFragment;
import com.whombang.app.features.mycenter.fragment.GroupBookingFragment;
import com.whombang.app.features.mycenter.fragment.InServiceFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 我的拼团
 */
@Route(path = "/my/groud")
public class GroudBookActivity extends BaseActivity {
    @BindView(R.id.common_indicator)
    EasyIndicator tabStrip;
    @BindView(R.id.vp_common)
    ViewPager viewPager;
    private List<Fragment> fragmentList;
    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return R.layout.wb_my_evaluate_layout;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        titleBar.setTitle("我的拼团");
        viewPager.setOffscreenPageLimit(3);
        fragmentList = new ArrayList<>();
      //  fragmentList.add(new GoodsListFragment());
        fragmentList.add(new GroupBookingFragment());
        fragmentList.add(new AwaitHarvestFragment());
        fragmentList.add(new GoodsFinishFragment());
        tabStrip.setTabTitles(new String[]{"拼团中","待收货","已完成"});//"全部",
        tabStrip.setViewPage(viewPager, new ItemTitlePagerAdapter(getSupportFragmentManager(), fragmentList));
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
