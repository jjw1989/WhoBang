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
import com.whombang.app.common.view.TitleBar;
import com.whombang.app.entity.UserLocalData;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * 添加服务者
 */
@Route(path = "/my/server")
public class AddServerActivity extends BaseActivity {
    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return R.layout.wb_my_order_layout;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        titleBar.setTitle("添加服务者");
        titleBar.addAction(new TitleBar.TextAction("添加") {
            @Override
            public void performAction(View view) {
                addServer();
            }
        });
    }

    /**
     * 添加服务者
     */
    private void addServer() {
        Map<String, Object> params = new HashMap<>();
        params.put("userId", UserLocalData.getUserInfo(this).getUserInfo().getUserId());
        params.put("stationId", UserLocalData.getUserInfo(this).getStationInfo().getStationId());
        params.put("individuationServiceDesc", "");
        params.put("contact", UserLocalData.getUserInfo(this).getUserInfo().getUserTel());
        params.put("userInvitationUserId", UserLocalData.getUserInfo(this).getStationManagerInfo().getStationId());
        params.put("type", 3);
        params.put("longitude", "114.00000");
        params.put("latitude", "32.000000");
        params.put("currentLocation", "中国");
        params.put("demanderName", "张三");

        EasyHttp.post("startAService")
                .upJson(new JSONObject(params).toString())
                .execute(new SimpleCallBack<String>() {

                    @Override
                    public void onError(ApiException e) {
                        Toast.makeText(mContext,e.getMessage(),Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onSuccess(String entity) {
                        Log.i("www","data="+entity);
                    }
                });
    }

    @Override
    public void doBusiness() {

    }
}
