package com.whombang.app.adapter;

import com.whombang.app.R;
import com.whombang.app.common.baseadapter.BaseQuickAdapter;
import com.whombang.app.common.baseadapter.BaseViewHolder;
import com.whombang.app.common.view.imageview.ExpandImageView;
import com.whombang.app.entity.OfferGoodsEntity;

import java.util.List;

/**
 * 提供商品列表适配器
 * Created by sundy.jiang on 2017/12/27.
 */

public class OfferGoodsAdapter extends BaseQuickAdapter<OfferGoodsEntity.GoodsInfoListBean,BaseViewHolder>{

    public OfferGoodsAdapter() {
        super(R.layout.wb_offer_goods_item_layout);
    }

    @Override
    protected void convert(BaseViewHolder helper, OfferGoodsEntity.GoodsInfoListBean item, int position) {
        ((ExpandImageView)helper.getView(R.id.img_goods)).setImageURI(item.getImgUrl());
        helper.setText(R.id.tv_send_time,item.getOrderTime());
        helper.setText(R.id.tv_order_status,item.getOrderStatus());
        helper.setText(R.id.tv_goods_name,item.getGoodsName());
        helper.setText(R.id.tv_unit_price,"￥"+item.getPrice());
        helper.setText(R.id.tv_goods_num,"x"+item.getAmount());
        helper.setText(R.id.tv_total_prices,"共"+item.getAmount()+"件商品 合计：￥"+item.getSumPrice());
        helper.setText(R.id.tv_goods_des,item.getSellUnit());
    }
}
