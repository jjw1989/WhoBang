package com.whombang.app.adapter;

import android.content.Context;
import android.widget.TextView;

import com.whombang.app.R;
import com.whombang.app.common.base.BaseViewHolder;
import com.whombang.app.entity.MyServiceEntity;

import java.util.List;

/**
 * 我的服务：待服务
 * Created by sundy.jiang on 2017/12/20.
 */

public class AwaitServiceAdapter extends SimpleAdapter<MyServiceEntity.ServiceOrderListBean>{
    public AwaitServiceAdapter(Context context, List<MyServiceEntity.ServiceOrderListBean> mDatas) {
        super(context, mDatas, R.layout.wb_await_service_item_layout);
    }

    @Override
    public void bindData(BaseViewHolder holder, MyServiceEntity.ServiceOrderListBean serviceOrderListBean, int position) {
        TextView tvStationName=holder.findTextView(R.id.tv_station_name);
        TextView tvServiceStatus=holder.findTextView(R.id.tv_service_status);
        TextView tvServiceType=holder.findTextView(R.id.tv_service_type);
        TextView tvBrief=holder.findTextView(R.id.tv_service_brief);
        TextView tvNum=holder.findTextView(R.id.tv_num);
        tvStationName.setText(serviceOrderListBean.getStationName());
        tvServiceStatus.setText(serviceOrderListBean.getServiceOrderStatus());
        tvServiceType.setText(serviceOrderListBean.getType());
        tvBrief.setText(serviceOrderListBean.getIndividuationServiceDesc());
    }
}
