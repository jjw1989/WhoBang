package com.whombang.app.features.shop.fragment;


import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.whombang.app.R;
import com.whombang.app.common.base.BaseFragment;
import com.whombang.app.common.net.EasyHttp;
import com.whombang.app.common.net.callback.SimpleCallBack;
import com.whombang.app.common.net.exception.ApiException;
import com.whombang.app.common.utils.GlideImageLoader;
import com.whombang.app.entity.GoodsDetailEntity;
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

/**
 * 商品详情：item1 商品介绍
 */
public class GoodsInfoFragment extends BaseFragment {
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
    @Override
    public void initData(Bundle bundle) {
        goodsSellId=bundle.getInt("goodsSellId",0);
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
    }

    @Override
    public void doBusiness() {

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
                        Log.i("qaz", "onSuccess: "+entity);
                        initBanner(entity.getGoodsImgInfos());
                        initGoodsInfo(entity.getGoodsGroupSellInfo());
                    }
                });
    }

    /**
     * 初始化头部banner
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
     * @param goodsGroupSellInfo
     */
    private void initGoodsInfo(GoodsDetailEntity.GoodsGroupSellInfoBean goodsGroupSellInfo) {
        tvTitile.setText(goodsGroupSellInfo.getGoodsGroupSellName()+" "+goodsGroupSellInfo.getGoodsGroupSellUnit());
        tvSellPrice.setText("团购价￥"+goodsGroupSellInfo.getGoodsGroupSellPrice());
        tvOldPrice.setText("原价￥"+goodsGroupSellInfo.getGoodsGroupSellOrigPrice());
        tvOldPrice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        tvTip.setText("本商品"+goodsGroupSellInfo.getGoodsGroupOriginalCount()+"件成团");
    }
}
