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
import com.whombang.app.features.mycenter.fragment.OfferAwaitServiceFragment;
import com.whombang.app.features.mycenter.fragment.OfferFinishFragment;
import com.whombang.app.features.mycenter.fragment.OfferInServiceFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 提供服务列表
 */
@Route(path = "/my/offer")
public class OfferServiceActivity extends BaseActivity {
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
        return R.layout.wb_shop_order_layout;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        titleBar.setTitle("提供服务列表");
        fragmentList = new ArrayList<>();
        fragmentList.add(new OfferAwaitServiceFragment());
        fragmentList.add(new OfferInServiceFragment());
        fragmentList.add(new OfferFinishFragment());
        viewPager.setOffscreenPageLimit(4);
        tabStrip.setTabTitles(new String[]{"待服务","服务中","已完成"});
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
