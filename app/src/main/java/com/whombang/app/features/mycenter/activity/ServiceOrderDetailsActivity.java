package com.whombang.app.features.mycenter.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.whombang.app.R;
import com.whombang.app.common.base.BaseActivity;
import com.whombang.app.common.net.EasyHttp;
import com.whombang.app.common.net.callback.SimpleCallBack;
import com.whombang.app.common.net.exception.ApiException;
import com.whombang.app.entity.MyServiceEntity;
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
public class ServiceOrderDetailsActivity extends BaseActivity {
    String serviceOrderId;

    @BindView(R.id.btn_order)
    Button btnOrder;

    @Override
    protected int bindLayout() {
        return R.layout.wb_service_order_details_layout;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    public void initData(Bundle bundle) {

            serviceOrderId = bundle.getString("serviceOrderId","");
            Log.i("wwww", "initData: " + serviceOrderId);

    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        titleBar.setTitle("订单详情");


    }

    @OnClick(R.id.btn_order)
    public void onStartOrder() {
        final Map<String, Object> params = new HashMap<>();
        params.put("serviceOrderId", serviceOrderId);
        params.put("inUserId", UserLocalData.getUserInfo(mContext).getUserInfo().getUserId());

        EasyHttp.post("userAcceptOrderService")
                .upJson(new JSONObject(params).toString())
                .execute(new SimpleCallBack<String>() {

                    @Override
                    public void onError(ApiException e) {
                        Toast.makeText(mActivity, e.getMessage(), Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onSuccess(String entity) {
                        Log.i("wwww", "onSuccess: " + entity);
                    }
                });
    }

    @Override
    public void doBusiness() {

    }
}
