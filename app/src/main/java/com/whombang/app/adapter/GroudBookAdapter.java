package com.whombang.app.adapter;

import android.util.Log;
import android.widget.ImageView;

import com.whombang.app.R;
import com.whombang.app.common.baseadapter.BaseQuickAdapter;
import com.whombang.app.common.baseadapter.BaseViewHolder;
import com.whombang.app.common.view.imageview.ExpandImageView;
import com.whombang.app.entity.GroudBookEntity;

/**
 * 我的拼团适配器
 * Created by sundy.jiang on 2017/12/25.
 */

public class GroudBookAdapter extends BaseQuickAdapter<GroudBookEntity.GoodsInfoListBean,BaseViewHolder> {
    public GroudBookAdapter() {
        super(R.layout.wb_groudbook_item_layout);
    }

    @Override
    protected void convert(BaseViewHolder helper, GroudBookEntity.GoodsInfoListBean item, int position) {
        ((ExpandImageView)helper.getView(R.id.img_goods)).setImageURI(item.getImgUrl());
        helper.setText(R.id.tv_station_name,item.getStationName());
        helper.setText(R.id.tv_service_status,item.getOrderStatus());
        helper.setText(R.id.tv_goods_name,item.getGoodsName());
        helper.setText(R.id.tv_unit_price,item.getPrice()+"");
        helper.setText(R.id.tv_goods_num,item.getAmount()+"");
        helper.setText(R.id.tv_total_prices,item.getSumPrice());
        helper.setText(R.id.tv_goods_des,item.getGroupingDes());
     //   helper.setText(R.id.tv_goods_des,item.)
        Log.i("wwww", "convert: "+position);
    }
}
