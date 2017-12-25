package com.whombang.app.adapter;

import com.whombang.app.R;
import com.whombang.app.common.baseadapter.BaseQuickAdapter;
import com.whombang.app.common.baseadapter.BaseViewHolder;
import com.whombang.app.entity.OfferServiceEntity;

/**
 * 提供服务者适配器
 * Created by David on 2017/12/23.
 */

public class OfferServiceAdapter extends BaseQuickAdapter<OfferServiceEntity.ServiceOrderListBean, BaseViewHolder>{

        public OfferServiceAdapter() {
            super(R.layout.wb_await_service_item_layout);
        }
        @Override
        protected void convert(BaseViewHolder helper, OfferServiceEntity.ServiceOrderListBean item, int position) {

            helper.setText(R.id.tv_station_name,item.getStationName());
            helper.setText(R.id.tv_service_status,getServiceStation(item.getServiceOrderStatus()));
            helper.setText(R.id.tv_station_owner_name,item.getStationManagerName());
            helper.setText(R.id.tv_station_owner_phone,item.getStationManagerTel());
            helper.setText(R.id.tv_service_brief,item.getIndividuationServiceDesc());
            helper.setText(R.id.tv_server_name,item.getUserRealName());
            helper.setText(R.id.tv_server_phone,item.getPhone());
            helper.setText(R.id.tv_order_time,item.getIndividuationServiceAddTime());
            if(item.getServiceOrderStatus()==1){
                helper.setVisible(R.id.rlt_service, false);

            }else{
                helper.setVisible(R.id.rlt_service, true);
                helper.setText(R.id.tv_server_name,item.getUserRealName());
                helper.setText(R.id.tv_server_phone,item.getPhone());
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
        }else if(station==4){
            return "已完成";
        }
        return "";
    }
}
