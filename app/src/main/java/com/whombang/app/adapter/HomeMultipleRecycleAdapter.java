package com.whombang.app.adapter;

import android.graphics.Paint;
import android.os.CountDownTimer;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.whombang.app.R;
import com.whombang.app.common.baseadapter.BaseMultiItemQuickAdapter;
import com.whombang.app.common.baseadapter.BaseQuickAdapter;
import com.whombang.app.common.baseadapter.BaseViewHolder;
import com.whombang.app.common.config.ViewType;
import com.whombang.app.common.utils.GlideImageLoader;
import com.whombang.app.common.view.imageview.ExpandImageView;
import com.whombang.app.entity.GoodsEntity;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;


/**
 * 首页:商品列表适配器
 */
public class HomeMultipleRecycleAdapter extends BaseMultiItemQuickAdapter<GoodsEntity.DataBean, BaseViewHolder> implements BaseQuickAdapter.SpanSizeLookup, BaseQuickAdapter.OnItemChildClickListener {

    private CountDownTimer timer;
    private int maxHasLoadPosition;
    /**
     * 当前position监听
     */
    private PositionChangedListener listener;

    public void setListener(PositionChangedListener listener) {
        this.listener = listener;
    }

    public void resetMaxHasLoadPosition() {
        maxHasLoadPosition = 0;
    }

    public HomeMultipleRecycleAdapter() {
        setSpanSizeLookup(this);
        addItemType(ViewType.VIEW_TYPE_BANNER, R.layout.wb_goods_banner);
        addItemType(ViewType.VIEW_TYPE_ANNOUNCEMENT, R.layout.vlayout_news);
        addItemType(ViewType.VIEW_TYPE_GOODSINFO, R.layout.vlayout_grid);
    }

    /**
     * 数据绑定未进行详细的数据验证，在实际使用中不可取
     *
     * @param helper   A fully initialized helper.
     * @param item     The item that needs to be displayed.
     * @param position
     */
    @Override
    protected void convert(BaseViewHolder helper, GoodsEntity.DataBean item, int position) {
        if (listener != null) {
            listener.currentPosition(position);
        }
        if (maxHasLoadPosition < position) {
            maxHasLoadPosition = position;
        }

        if ("banner".equals(item.itemType) && maxHasLoadPosition <= position) {
            bindTopBannerData(helper, item, position);
        } else if ("announcement".equals(item.itemType) && maxHasLoadPosition <= position) {
            bindAnnouncementData(helper, item, position);
        } else if ("goodsInfo".equals(item.itemType)) {
            bindGoodsInfoData(helper, item, position);
        }
    }


    private void bindGoodsInfoData(BaseViewHolder helper, GoodsEntity.DataBean item, int position) {

        ((ExpandImageView) helper.getView(R.id.img_goods_head)).setImageURI(item.itemContentList.get(0).imageUrl);
        helper.setText(R.id.tv_goods_name, item.itemContentList.get(0).goodsName);
        helper.setText(R.id.tv_sell_unit, item.itemContentList.get(0).sellUnit);
        ((TextView) helper.getView(R.id.tv_original_price)).getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        helper.setText(R.id.tv_original_price, "原价："+item.itemContentList.get(0).originalPrice );
        helper.setText(R.id.tv_sell_price, "团购价格："+item.itemContentList.get(0).sellPrice );
        helper.setText(R.id.tv_end_time, "倒计时："+item.itemContentList.get(0).endTime);


    }

    private void bindAnnouncementData(BaseViewHolder helper, GoodsEntity.DataBean item, int position) {

    }

    /**
     * 绑定banner数据
     *
     * @param helper
     * @param item
     * @param position
     */
    private void bindTopBannerData(BaseViewHolder helper, final GoodsEntity.DataBean item, int position) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < item.itemContentList.size(); i++) {
            arrayList.add(item.itemContentList.get(i).imageUrl);
        }
        // 绑定数据
        Banner mBanner = helper.getView(R.id.banner);
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
                Toast.makeText(mContext, "banner点击了" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public int getSpanSize(GridLayoutManager gridLayoutManager, int position) {
        return 4;
    }


    @Override
    public boolean onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
//        switch (view.getId()) {
//            case R.id.icon_list_one:
//                ARouter.getInstance().build("/test1/activity").navigation(view.getContext());
//                break;
//        }
        return false;
    }
}


