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
import com.whombang.app.features.mycenter.fragment.AwaitServiceFragment;
import com.whombang.app.features.mycenter.fragment.EvaluatedFragment;
import com.whombang.app.features.mycenter.fragment.FinishFragment;
import com.whombang.app.features.mycenter.fragment.InServiceFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 我的服务
 */
@Route(path = "/my/service")
public class MyServiceActivity extends BaseActivity {
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
        return R.layout.wb_station_layout;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        titleBar.setTitle("我的服务");
        fragmentList = new ArrayList<>();
        fragmentList.add(new AwaitServiceFragment());
        fragmentList.add(new InServiceFragment());
        fragmentList.add(new EvaluatedFragment());
        fragmentList.add(new FinishFragment());
        viewPager.setOffscreenPageLimit(2);
        tabStrip.setTabTitles(new String[]{"待服务","服务中","待评价","已完成"});
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
