package com.whombang.app.features.shop.fragment;


import android.app.Activity;
import android.content.Context;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.whombang.app.R;
import com.whombang.app.adapter.ImageDetailsAdapter;
import com.whombang.app.adapter.OfferServiceAdapter;
import com.whombang.app.common.base.BaseFragment;
import com.whombang.app.common.net.EasyHttp;
import com.whombang.app.common.net.callback.SimpleCallBack;
import com.whombang.app.common.net.exception.ApiException;
import com.whombang.app.common.utils.GlideImageLoader;
import com.whombang.app.common.view.MyRecycleView;
import com.whombang.app.common.view.SlideDetailsLayout;
import com.whombang.app.common.view.imageview.ExpandImageView;
import com.whombang.app.entity.GoodsDetailEntity;
import com.whombang.app.features.home.fragment.GoodsInfoWebFragment;
import com.whombang.app.features.shop.activity.CommodityDetailsActivity;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

import static android.support.v7.widget.DividerItemDecoration.VERTICAL;

/**
 * 商品详情：item1 商品介绍
 */
public class GoodsInfoFragment extends BaseFragment implements SlideDetailsLayout.OnSlideDetailsListener {
    private int goodsSellId;
    @BindView(R.id.banner)
    Banner mBanner;
    @BindView(R.id.tv_goods_title)
    TextView tvTitile;
    @BindView(R.id.tv_new_price)
    TextView tvSellPrice;
    @BindView(R.id.tv_old_price)
    TextView tvOldPrice;
    @BindView(R.id.tv_current_goods)
    TextView tvTip;
    @BindView(R.id.fab_up_slide)
    FloatingActionButton fab_up_slide;
    @BindView(R.id.sv_switch)
    SlideDetailsLayout sv_switch;
    @BindView(R.id.sv_goods_info)
    ScrollView sv_goods_info;
    CommodityDetailsActivity activity;
    public GoodsInfoWebFragment goodsInfoWebFragment;
    private FragmentTransaction fragmentTransaction;
    private FragmentManager fragmentManager;
    public   int goodsGroupSellId;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (CommodityDetailsActivity) context;
    }

    @Override
    public void initData(Bundle bundle) {
        goodsSellId = bundle.getInt("goodsSellId", 0);
    }

    @Override
    public int bindLayout() {
        return R.layout.wb_goods_info_layout;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        requestNetData();
        sv_switch.setOnSlideDetailsListener(this);
        fab_up_slide.hide();
    }

    @Override
    public void doBusiness() {
        fab_up_slide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sv_goods_info.smoothScrollTo(0, 0);
                sv_switch.smoothClose(true);
            }
        });
    }

    /**
     * 请求网络数据
     */
    private void requestNetData() {
        final Map<String, Object> params = new HashMap<>();
        params.put("goodsGroupSellId", goodsSellId);

        EasyHttp.post("initGroupGoodsDetail")
                .upJson(new JSONObject(params).toString())
                .execute(new SimpleCallBack<GoodsDetailEntity>() {

                    @Override
                    public void onError(ApiException e) {
                        Toast.makeText(mActivity, e.getMessage(), Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onSuccess(GoodsDetailEntity entity) {
                        //数据结构不一样需要特别处理
                        initBanner(entity.getGoodsImgInfos());
                        initGoodsInfo(entity.getGoodsGroupSellInfo());
                        initImgDetails(entity.getGoodsDetailImgInfos());
                    }
                });
    }

    /**
     * 图片详情
     *
     * @param goodsDetailImgInfos
     */
    private void initImgDetails(List<GoodsDetailEntity.GoodsDetailImgInfosBean> goodsDetailImgInfos) {
        Bundle bundle = new Bundle();
        bundle.putString("url", goodsDetailImgInfos.get(0).getGoodsDetailImgUrl());
        goodsInfoWebFragment = new GoodsInfoWebFragment();
        goodsInfoWebFragment.setArguments(bundle);
        fragmentManager = getChildFragmentManager();
        //默认显示商品详情tab
        fragmentManager.beginTransaction().replace(R.id.fl_content, goodsInfoWebFragment).commitAllowingStateLoss();
    }

    /**
     * 初始化头部banner
     *
     * @param goodsImgInfos
     */
    private void initBanner(List<GoodsDetailEntity.GoodsImgInfosBean> goodsImgInfos) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < goodsImgInfos.size(); i++) {
            arrayList.add(goodsImgInfos.get(i).getGoodsImgUrl());
        }
        //设置banner样式
        mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        //设置图片加载器
        mBanner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        mBanner.setImages(arrayList);
        //设置banner动画效果
        mBanner.setBannerAnimation(Transformer.DepthPage);
        //设置标题集合（当banner样式有显示title时）
        //        mBanner.setBannerTitles(titles);
        //设置自动轮播，默认为true
        mBanner.isAutoPlay(true);
        //设置轮播时间
        mBanner.setDelayTime(5000);
        //设置指示器位置（当banner模式中有指示器时）
        mBanner.setIndicatorGravity(BannerConfig.CENTER);
        //banner设置方法全部调用完毕时最后调用
        mBanner.start();

        mBanner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                Toast.makeText(mActivity, "banner点击了" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * 初始化团购商品基本信息
     *
     * @param goodsGroupSellInfo
     */
    private void initGoodsInfo(GoodsDetailEntity.GoodsGroupSellInfoBean goodsGroupSellInfo) {
        goodsGroupSellId = goodsGroupSellInfo.getGoodsGroupSellId();
        tvTitile.setText(goodsGroupSellInfo.getGoodsGroupSellName() + " " + goodsGroupSellInfo.getGoodsGroupSellUnit());
        tvSellPrice.setText("团购价￥" + goodsGroupSellInfo.getGoodsGroupSellPrice());
        tvOldPrice.setText("原价￥" + goodsGroupSellInfo.getGoodsGroupSellOrigPrice());
        tvOldPrice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        tvTip.setText("本商品" + goodsGroupSellInfo.getGoodsGroupOriginalCount() + "件成团");
    }

    @Override
    public void onStatucChanged(SlideDetailsLayout.Status status) {
        if (status == SlideDetailsLayout.Status.OPEN) {
            //当前为图文详情页
            fab_up_slide.show();
            activity.viewPager.setNoScroll(true);
        } else {
            //当前为商品详情页
            fab_up_slide.hide();
            activity.viewPager.setNoScroll(false);
        }
    }
}
