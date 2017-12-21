package com.whombang.app.features.sendtask;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.whombang.app.R;
import com.whombang.app.common.base.BaseActivity;
import com.whombang.app.common.net.EasyHttp;
import com.whombang.app.common.net.callback.SimpleCallBack;
import com.whombang.app.common.net.exception.ApiException;
import com.whombang.app.entity.ConsigneeEntity;
import com.whombang.app.entity.UserLocalData;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * 电话服务列表
 */
@Route(path = "/task/phone")
public class ServicePhoneActivity extends BaseActivity {

    @Override
    protected int bindLayout() {
        return R.layout.wb_service_phone_layout;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        titleBar.setTitle("电话列表");
        Map<String, Object> params = new HashMap<>();
        params.put("stationId", UserLocalData.getUserInfo(this).getStationInfo().getStationId());
        params.put("pageSize", 20);
        params.put("currentPageNum", 1);
        EasyHttp.post("getProviderUserPhoneInfoList")
                .upJson(new JSONObject(params).toString())
                .execute(new SimpleCallBack<String>() {

                    @Override
                    public void onError(ApiException e) {
                        Toast.makeText(ServicePhoneActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onSuccess(String entity) {
                        Log.i("qwert", "onSuccess: ="+entity);
                    }
                });
    }



    @Override
    public void doBusiness() {

    }
}
