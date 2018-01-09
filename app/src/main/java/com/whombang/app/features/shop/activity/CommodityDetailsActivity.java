package com.whombang.app.features.shop.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.alibaba.fastjson.JSON;
import com.gxz.PagerSlidingTabStrip;
import com.whombang.app.R;
import com.whombang.app.adapter.ItemTitlePagerAdapter;
import com.whombang.app.adapter.ItemTitlePagerAdapter1;
import com.whombang.app.common.base.BaseActivity;
import com.whombang.app.common.net.EasyHttp;
import com.whombang.app.common.net.callback.SimpleCallBack;
import com.whombang.app.common.net.exception.ApiException;
import com.whombang.app.entity.GoodsEntity;
import com.whombang.app.features.shop.fragment.GoodsCommentFragment;
import com.whombang.app.features.shop.fragment.GoodsDetailFragment;
import com.whombang.app.features.shop.fragment.GoodsInfoFragment;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 商品详情页
 */
@Route(path = "/shop/details")
public class CommodityDetailsActivity extends BaseActivity {
    @BindView(R.id.psts_tabs)
    PagerSlidingTabStrip tabStrip;
    @BindView(R.id.vp_content)
    ViewPager viewPager;
    private List<Fragment> fragmentList;

    Bundle bundle;
    @Override
    public void initData(Bundle bundle) {
        this.bundle=bundle;
    }

    @Override
    public int bindLayout() {
        return R.layout.wb_commodity_details_layout;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        titleBar.setVisibility(View.GONE);
        fragmentList = new ArrayList<>();
        GoodsInfoFragment goodsInfoFragment=new GoodsInfoFragment();
        goodsInfoFragment.setArguments(bundle);
        fragmentList.add(goodsInfoFragment);
        fragmentList.add(new GoodsDetailFragment());
        fragmentList.add(new GoodsCommentFragment());
        viewPager.setAdapter(new ItemTitlePagerAdapter1(getSupportFragmentManager(), fragmentList, new String[]{"商品", "详情", "评价"}));
        viewPager.setOffscreenPageLimit(3);
        tabStrip.setViewPager(viewPager);
    }


    @OnClick(R.id.imgBack)
    public void onImageViewBack(){
        finish();
    }


    @OnClick(R.id.tv_submit)
    public void onSubmit(){
        ARouter.getInstance().build("/shop/order").navigation();
    }
    @Override
    public void doBusiness() {

    }
}
