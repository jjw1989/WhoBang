package com.whombang.app.adapter;

import android.view.View;

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
        helper.setText(R.id.tv_service_status,getServiceStation(item.getServiceOrderStatus()));
        helper.setText(R.id.tv_service_need,"服务需求:"+item.getIndividuationServiceDesc());
        helper.setText(R.id.tv_order_time,"下单时间:"+item.getIndividuationServiceAddTime());
        if (item.getServiceOrderStatus()==3){
            helper.getView(R.id.btn_evaluate).setVisibility(View.GONE);
        }else{
            helper.getView(R.id.btn_evaluate).setVisibility(View.GONE);
        }
    }

    /**
     * 订单状态含义转化
     * @param station
     * @return
     */
    private String getServiceStation(int station){
        if(station==1){
            return "等待接单";
        }else if (station==2){
            return "服务中";
        }else if(station==3){
            return "已完成";
        }
        return "";
    }
}

