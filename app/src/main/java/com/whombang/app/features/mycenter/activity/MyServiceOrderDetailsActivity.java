package com.whombang.app.features.mycenter.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.whombang.app.R;
import com.whombang.app.common.base.BaseActivity;
import com.whombang.app.common.entity.BaseEntity;
import com.whombang.app.common.net.EasyHttp;
import com.whombang.app.common.net.callback.SimpleCallBack;
import com.whombang.app.common.net.exception.ApiException;
import com.whombang.app.entity.ServiceDetailsEntity;
import com.whombang.app.entity.UserLocalData;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 服务订单详情
 */
@Route(path = "/myservice/orderdetails")
public class MyServiceOrderDetailsActivity extends BaseActivity {
    @BindView(R.id.tv_consignee_address)
    TextView tvAddress;
    @BindView(R.id.tv_consignee)
    TextView tvConsignee;
    @BindView(R.id.tv_consignee_phone)
    TextView tvConsigneePhone;

    @BindView(R.id.tv_station_name)
    TextView tvStationName;
    @BindView(R.id.tv_service_need)
    TextView tvServiceNeed;


    @BindView(R.id.tv_order_code)
    TextView tvOrderCode;
    @BindView(R.id.tv_order_time)
    TextView tvOrderTime;
    @BindView(R.id.btn_order)
            Button btnOrder;
    String serviceOrderId;
    String userId;
    @Override
    protected int bindLayout() {
        return R.layout.wb_my_service_order_details_layout;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    public void initData(Bundle bundle) {
        serviceOrderId = bundle.getString("serviceOrderId", "");
        userId=bundle.getString("userId","");
        Log.i("wwww", "initData: " + serviceOrderId);

    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        titleBar.setTitle("订单详情");
        requestOrderDetails();
    }

    /**
     * 获取订单详情
     */
    private void requestOrderDetails() {
        final Map<String, Object> params = new HashMap<>();
        params.put("serviceOrderId", serviceOrderId);
        params.put("userId",userId);

        EasyHttp.post("getUserOrderServiceDetail")
                .upJson(new JSONObject(params).toString())
                .execute(new SimpleCallBack<ServiceDetailsEntity>() {

                    @Override
                    public void onError(ApiException e) {
                        Toast.makeText(mActivity, e.getMessage(), Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onSuccess(ServiceDetailsEntity entity) {

                       upView(entity.getUserorderserviceInfo());
                    }
                });
    }

    /**
     * 更新view
     * @param
     */
    private void upView(ServiceDetailsEntity.UserorderserviceInfoBean entity) {
        tvConsignee.setText("服务需求者："+entity.getDemanderName());
        tvAddress.setText("服务需求者地址："+entity.getCurrentLocation());
        tvConsigneePhone.setText(entity.getContact());

        tvStationName.setText("站主名称："+entity.getStationName());
        tvServiceNeed.setText("服务需求："+entity.getIndividuationServiceDesc());
        tvOrderCode.setText("订单编号:" + entity.getOrderId());
        tvOrderTime.setText("下单时间:" + entity.getIndividuationServiceAddTime());
    }

    @OnClick(R.id.btn_order)
    public void onStartOrder() {
        final Map<String, Object> params = new HashMap<>();
        params.put("serviceOrderId", serviceOrderId);
        params.put("inUserId", UserLocalData.getUserInfo(mContext).getUserInfo().getUserId());

        EasyHttp.post("userAcceptOrderService")
                .upJson(new JSONObject(params).toString())
                .execute(new SimpleCallBack<BaseEntity>() {

                    @Override
                    public void onError(ApiException e) {
                        Toast.makeText(mActivity, e.getMessage(), Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onSuccess(BaseEntity entity) {
                        setResult(RESULT_OK);
                        finish();
                    }
                });
    }

    @Override
    public void doBusiness() {

    }
}
