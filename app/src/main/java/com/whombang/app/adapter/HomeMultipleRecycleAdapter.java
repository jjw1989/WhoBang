package com.whombang.app.adapter;

import android.os.CountDownTimer;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;

import com.whombang.app.R;
import com.whombang.app.common.baseadapter.BaseMultiItemQuickAdapter;
import com.whombang.app.common.baseadapter.BaseQuickAdapter;
import com.whombang.app.common.baseadapter.BaseViewHolder;
import com.whombang.app.entity.GoodsEntity;

import cn.bingoogolapple.bgabanner.BGABanner;


/**
 * @author admin 数据绑定未进行详细的数据验证，再实际使用中不可取
 */
public class HomeMultipleRecycleAdapter extends BaseMultiItemQuickAdapter<GoodsEntity, BaseViewHolder> implements BaseQuickAdapter.SpanSizeLookup, BaseQuickAdapter.OnItemChildClickListener {

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
//        addItemType(Constant.TYPE_TOP_BANNER, R.layout.homerecycle_item_top_banner);
//        addItemType(Constant.TYPE_ICON_LIST, R.layout.homerecycle_item_icon_list);
//        addItemType(Constant.TYPE_NEW_USER, R.layout.homerecycle_item_new_user);
    }

    /**
     * 数据绑定未进行详细的数据验证，在实际使用中不可取
     * @param helper A fully initialized helper.
     * @param item   The item that needs to be displayed.
     * @param position
     */
    @Override
    protected void convert(BaseViewHolder helper,GoodsEntity item, int position) {
        if (listener != null) {
            listener.currentPosition(position);
        }
        if (maxHasLoadPosition < position) {
            maxHasLoadPosition = position;
        }

//        if ("topBanner".equals(item.itemType) && maxHasLoadPosition <= position) {
//            bindTopBannerData(helper, item, position);
//        } else if ("iconList".equals(item.itemType) && maxHasLoadPosition <= position) {
//            bindIconListData(helper, item, position);
//        } else if ("newUser".equals(item.itemType)) {
//            bindNewUserData(helper, item, position);
//        }
    }


    /**
     * 填充下标 或 推荐 内容
     *
     * @param helper
     * @param item
     * @param id
     * @param index
     */
    private void setRecommendedLanguage(BaseViewHolder helper,GoodsEntity item, int id, int index) {
//        String itemRecommendedLanguage = item.itemContentList.get(index).itemRecommendedLanguage;
//        if (TextUtils.isEmpty(itemRecommendedLanguage)) {
//            helper.getView(id).setVisibility(View.GONE);
//        } else {
//            helper.getView(id).setVisibility(View.VISIBLE);
//            helper.setText(id, itemRecommendedLanguage);
//            if ("loveLife".equals(item.module)) {
//                helper.getView(id).setBackgroundResource(R.drawable.home_love_life_subscript_gradient_bg);
//            } else if ("enjoyQuality".equals(item.module)) {
//                helper.getView(id).setBackgroundResource(R.drawable.home_enjoy_quality_subscript_gradient_bg);
//            } else if ("buyFeatures".equals(item.module)) {
//                helper.getView(id).setBackgroundResource(R.drawable.home_buy_feature_subscript_gradient_bg);
//            }
//        }
    }



    private void bindNewUserData(BaseViewHolder helper, GoodsEntity item, int position) {

//        ((ExpandImageView) helper.getView(R.id.new_user_bg_img)).setImageURI(item.itemContentList.get(0).imageUrl);
//        ((ExpandImageView) helper.getView(R.id.new_user_red_envelopes)).setImageURI(item.itemContentList.get(1).imageUrl);
//        ((ExpandImageView) helper.getView(R.id.new_uer_free_postage)).setImageURI(item.itemContentList.get(2).imageUrl);
//        ((ExpandImageView) helper.getView(R.id.new_user_basic_necessities_of_life)).setImageURI(item.itemContentList.get(3).imageUrl);
//        ((ExpandImageView) helper.getView(R.id.new_user_packs)).setImageURI(item.itemContentList.get(4).imageUrl);
    }

    private void bindIconListData(BaseViewHolder helper, GoodsEntity item, int position) {

    }

    /**
     * 绑定banner数据
     *
     * @param helper
     * @param item
     * @param position
     */
    private void bindTopBannerData(BaseViewHolder helper, final GoodsEntity item, int position) {
        BGABanner banner = helper.getView(R.id.banner);
//        banner.setDelegate(new BGABanner.Delegate<View, HomeIndex.ItemInfoListBean.ItemContentListBean>() {
//            @Override
//            public void onBannerItemClick(BGABanner banner, View itemView, HomeIndex.ItemInfoListBean.ItemContentListBean model, int position) {
//                Toast.makeText(itemView.getContext(), "" + item.itemContentList.get(position).clickUrl, Toast.LENGTH_SHORT).show();
//            }
//        });
//        banner.setAdapter(new BGABanner.Adapter<View, HomeIndex.ItemInfoListBean.ItemContentListBean>() {
//            @Override
//            public void fillBannerItem(BGABanner banner, View itemView, HomeIndex.ItemInfoListBean.ItemContentListBean model, int position) {
//                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) itemView.findViewById(R.id.sdv_item_fresco_content);
//                simpleDraweeView.setImageURI(Uri.parse(model.imageUrl));
//            }
//        });
//
//        banner.setData(R.layout.homerecycle_top_banner_content, item.itemContentList, null);
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


