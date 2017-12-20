package com.whombang.app.adapter;

import com.whombang.app.R;
import com.whombang.app.common.baseadapter.BaseQuickAdapter;
import com.whombang.app.common.baseadapter.BaseViewHolder;
import com.whombang.app.entity.MyServiceEntity;



/**
 * 我的服务：待服务
 * Created by sundy.jiang on 2017/12/20.
 */

public class AwaitServiceAdapter extends BaseQuickAdapter<MyServiceEntity.ServiceOrderListBean, BaseViewHolder> {

    public AwaitServiceAdapter() {
        super(R.layout.wb_await_service_item_layout);
    }

    @Override
    protected void convert(BaseViewHolder helper, MyServiceEntity.ServiceOrderListBean item, int position) {
        helper.setText(R.id.tv_station_name,item.getStationName());
      //  helper.setText(R.id.tv_service_status,item.getServiceOrderStatus());
      //  helper.setText(R.id.tv_service_type,item.getType());
        helper.setText(R.id.tv_service_brief,item.getIndividuationServiceDesc());
       // TextView tvNum=holder.findTextView(R.id.tv_num);

    }
}

