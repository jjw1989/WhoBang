package com.whombang.app.adapter;

import com.whombang.app.R;
import com.whombang.app.common.baseadapter.BaseQuickAdapter;
import com.whombang.app.common.baseadapter.BaseViewHolder;
import com.whombang.app.entity.PhoneEntity;

/**
 * 电话列表适配器
 * Created by sundy.jiang on 2018/1/3.
 */

public class ServicePhoneAdapter extends BaseQuickAdapter<PhoneEntity.GetProviderUserPhoneInfoListBean, BaseViewHolder> {

    public ServicePhoneAdapter() {
        super(R.layout.wb_phone_list_item_layout);
    }

    @Override
    protected void convert(BaseViewHolder helper, PhoneEntity.GetProviderUserPhoneInfoListBean item, int position) {
        helper.setText(R.id.tv_phone_name, item.getServiceSkillsTypeName());
        helper.setText(R.id.tv_phone_des, item.getServiceSkillsSesc());
        helper.setText(R.id.tv_phone_num, item.getPhone());
    }
}
