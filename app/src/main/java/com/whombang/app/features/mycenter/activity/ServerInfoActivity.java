package com.whombang.app.features.mycenter.activity;

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
import com.whombang.app.entity.UserLocalData;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * 服务者列表
 */
@Route(path = "/my/info")
public class ServerInfoActivity extends BaseActivity {

    @Override
    protected int bindLayout() {
        return R.layout.wb_server_info_layout;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
      titleBar.setTitle("服务提供者信息列表");
        final Map<String, Object> params = new HashMap<>();
        params.put("stationId", UserLocalData.getUserInfo(mContext).getStationInfo().getStationId());
        params.put("status", 1);
        params.put("pageSize", 20);
        params.put("currentPageNum", 1);

        EasyHttp.post("getStationProviderUserInfoList")
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
