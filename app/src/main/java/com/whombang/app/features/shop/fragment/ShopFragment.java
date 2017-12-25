package com.whombang.app.features.shop.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.alibaba.android.arouter.launcher.ARouter;
import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.bumptech.glide.Glide;
import com.whombang.app.R;
import com.whombang.app.adapter.BaseDelegateAdapter;
import com.whombang.app.common.base.BaseFragment;
import com.whombang.app.common.baseadapter.BaseViewHolder;
import com.whombang.app.common.utils.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import butterknife.BindView;

import static com.whombang.app.adapter.MyCenterAdapter.BANNER_VIEW_TYPE;
import static com.whombang.app.features.shop.fragment.ShopFragment.Config.GRID_URL;
import static com.whombang.app.features.shop.fragment.ShopFragment.Config.GRID_VIEW_TYPE;
import static com.whombang.app.features.shop.fragment.ShopFragment.Config.NEWS_VIEW_TYPE;

/**
 *商城主页
 */
public class ShopFragment extends BaseFragment {
    @BindView(R.id.recycler)
    RecyclerView mRecyclerView;
    private List<DelegateAdapter.Adapter> mAdapters; //存放各个模块的适配器

    public interface Config {
        //不同item必须不同的viewtype
        int BANNER_VIEW_TYPE = 1;
        int MENU_VIEW_TYPE = 2;
        int NEWS_VIEW_TYPE = 3;
        int TITLE_VIEW_TYPE = 4;
        int GRID_VIEW_TYPE = 5;
        int[] GRID_URL = {R.mipmap.flashsale1, R.mipmap.flashsale2, R.mipmap.flashsale3, R.mipmap.flashsale4,R.mipmap.flashsale1, R.mipmap.flashsale2, R.mipmap.flashsale3, R.mipmap.flashsale4,R.mipmap.flashsale1, R.mipmap.flashsale2, R.mipmap.flashsale3, R.mipmap.flashsale4};
    }
    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return R.layout.wb_shop_fragment_layout;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        mAdapters = new LinkedList<>();
        //初始化
        VirtualLayoutManager layoutManager = new VirtualLayoutManager(mActivity);
        mRecyclerView.setLayoutManager(layoutManager);
        //设置回收复用池大小，（如果一屏内相同类型的 View 个数比较多，需要设置一个合适的大小，防止来回滚动时重新创建 View）：
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        mRecyclerView.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(0, 10);

        DelegateAdapter delegateAdapter = new DelegateAdapter(layoutManager, true);
        mRecyclerView.setAdapter(delegateAdapter);

        //banner
        BaseDelegateAdapter bannerAdapter = new BaseDelegateAdapter(mActivity, new LinearLayoutHelper()
                , R.layout.wb_goods_banner, 1, BANNER_VIEW_TYPE) {
            @Override
            public void onBindViewHolder(BaseViewHolder holder, int position) {
                super.onBindViewHolder(holder, position);
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add("http://bpic.wotucdn.com/11/66/23/55bOOOPIC3c_1024.jpg!/fw/780/quality/90/unsharp/true/compress/true/watermark/url/L2xvZ28ud2F0ZXIudjIucG5n/repeat/true");
                arrayList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1505470629546&di=194a9a92bfcb7754c5e4d19ff1515355&imgtype=0&src=http%3A%2F%2Fpics.jiancai.com%2Fimgextra%2Fimg01%2F656928666%2Fi1%2FT2_IffXdxaXXXXXXXX_%2521%2521656928666.jpg");
                // 绑定数据
                Banner mBanner = holder.getView(R.id.banner);
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
        };
        //把轮播器添加到集合
        mAdapters.add(bannerAdapter);
        //news
//        BaseDelegateAdapter newsAdapter = new BaseDelegateAdapter(mActivity, new LinearLayoutHelper()
//                , R.layout.vlayout_news, 1, NEWS_VIEW_TYPE) {
//            @Override
//            public void onBindViewHolder(BaseViewHolder holder, int position) {
//                super.onBindViewHolder(holder, position);
//                MarqueeView marqueeView1 = holder.getView(R.id.marqueeView1);
//                MarqueeView marqueeView2 = holder.getView(R.id.marqueeView2);
//
//                List<String> info1 = new ArrayList<>();
//                info1.add("鸡蛋便宜啦，鸡蛋便宜啦，惊爆价！");
//                info1.add("鸡蛋便宜啦，鸡蛋便宜啦，惊爆价！！");
//
//                List<String> info2 = new ArrayList<>();
//                info2.add("全套服务还免费，看来看啊！");
//                info2.add("全套服务还免费，看来看啊！！");
//
//                marqueeView1.startWithList(info1);
//                marqueeView2.startWithList(info2);
//                // 在代码里设置自己的动画
//                marqueeView1.startWithList(info1, R.anim.anim_bottom_in, R.anim.anim_top_out);
//                marqueeView2.startWithList(info2, R.anim.anim_bottom_in, R.anim.anim_top_out);
//
//                marqueeView1.setOnItemClickListener(new MarqueeView.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(int position, TextView textView) {
//                        Toast.makeText(mActivity, textView.getText().toString(), Toast.LENGTH_SHORT).show();
//                    }
//                });
//                marqueeView2.setOnItemClickListener(new MarqueeView.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(int position, TextView textView) {
//                        Toast.makeText(mActivity, textView.getText().toString(), Toast.LENGTH_SHORT).show();
//                    }
//                });
//            }
//        };
//        mAdapters.add(newsAdapter);
        BaseDelegateAdapter titleAdapter = new BaseDelegateAdapter(mActivity, new LinearLayoutHelper()
                , R.layout.wb_shop_title_layout, 1, NEWS_VIEW_TYPE) {
            @Override
            public void onBindViewHolder(BaseViewHolder holder, int position) {
                super.onBindViewHolder(holder, position);

            }
        };
        mAdapters.add(titleAdapter);


        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(2);
        gridLayoutHelper.setMargin(0, 0, 0, 0);
        gridLayoutHelper.setPadding(0, 0, 0, 0);
        gridLayoutHelper.setVGap(0);// 控制子元素之间的垂直间距
        gridLayoutHelper.setHGap(0);// 控制子元素之间的水平间距
        gridLayoutHelper.setBgColor(Color.WHITE);
        gridLayoutHelper.setAutoExpand(true);//是否自动填充空白区域
        BaseDelegateAdapter girdAdapter = new BaseDelegateAdapter(mActivity, gridLayoutHelper, R.layout.vlayout_grid
                , 12, GRID_VIEW_TYPE) {
            @Override
            public void onBindViewHolder(BaseViewHolder holder, final int position) {
                super.onBindViewHolder(holder, position);
                int item = GRID_URL[position];
                ImageView iv = holder.getView(R.id.iv);
                Glide.with(mActivity).load(item).into(iv);

                iv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(mActivity, "item" + position, Toast.LENGTH_SHORT).show();
                        ARouter.getInstance().build("/shop/details").navigation();
                    }
                });
            }
        };
        mAdapters.add(girdAdapter);
        //设置适配器
        delegateAdapter.setAdapters(mAdapters);
    }

    @Override
    public void doBusiness() {

    }
}
