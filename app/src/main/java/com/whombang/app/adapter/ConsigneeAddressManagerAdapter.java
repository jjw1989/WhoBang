package com.whombang.app.adapter;

import com.whombang.app.R;
import com.whombang.app.common.baseadapter.BaseQuickAdapter;
import com.whombang.app.common.baseadapter.BaseViewHolder;
import com.whombang.app.entity.ConsigneeEntity;

/**
 * Created by sundy.jiang on 2018/1/11.
 */

public class ConsigneeAddressManagerAdapter extends BaseQuickAdapter<ConsigneeEntity.UserAddressInfosBean,BaseViewHolder>{

    public ConsigneeAddressManagerAdapter() {
        super(R.layout.wb_consignee_manager_layout);
    }

    @Override
    protected void convert(BaseViewHolder helper, ConsigneeEntity.UserAddressInfosBean item, int position) {

    }
}
