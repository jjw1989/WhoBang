package com.whombang.app.adapter;

import com.whombang.app.R;
import com.whombang.app.common.baseadapter.BaseQuickAdapter;
import com.whombang.app.common.baseadapter.BaseViewHolder;
import com.whombang.app.common.view.imageview.ExpandImageView;
import com.whombang.app.entity.GoodsDetailEntity;

/**
 * Created by sundy.jiang on 2018/1/9.
 */

public class ImageDetailsAdapter extends BaseQuickAdapter<GoodsDetailEntity.GoodsDetailImgInfosBean,BaseViewHolder> {
    public ImageDetailsAdapter() {
        super(R.layout.wb_image_details_layout);
    }

    @Override
    protected void convert(BaseViewHolder helper, GoodsDetailEntity.GoodsDetailImgInfosBean item, int position) {
        ((ExpandImageView) helper.getView(R.id.img_goods_details)).setImageURI(item.getGoodsDetailImgUrl());
    }
}
