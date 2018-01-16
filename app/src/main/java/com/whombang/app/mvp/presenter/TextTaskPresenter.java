package com.whombang.app.mvp.presenter;

import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.whombang.app.common.net.EasyHttp;
import com.whombang.app.common.net.callback.SimpleCallBack;
import com.whombang.app.common.net.exception.ApiException;
import com.whombang.app.entity.ConsigneeEntity;
import com.whombang.app.entity.DefaultAddressEntity;
import com.whombang.app.entity.UserLocalData;
import com.whombang.app.features.sendtask.TextTaskActivity;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

/**
 * Created by David on 2017/12/17.
 */

public class TextTaskPresenter {
    private TextTaskActivity activity;

    @Inject
    public TextTaskPresenter(TextTaskActivity activity){
        this.activity=activity;
    }

    public void sendTaskSerivce(String individuationServiceDesc,String address,String phone,String name,int stationId){
        Map<String, Object> params = new HashMap<>();
        params.put("userId", UserLocalData.getUserInfo(activity).getUserInfo().getUserId());
        params.put("stationId", stationId);//选择返回的id
        params.put("individuationServiceDesc", individuationServiceDesc);
        params.put("contact", phone);
        params.put("userInvitationUserId", UserLocalData.getUserInfo(activity).getStationManagerInfo().getStationId());//登录默认id
        params.put("type", 3);
        params.put("longitude", "114.00000");
        params.put("latitude", "32.000000");
        params.put("currentLocation", address);
        params.put("demanderName", name);

        EasyHttp.post("startAService")
                .upJson(new JSONObject(params).toString())
                .execute(new SimpleCallBack<String>() {

                    @Override
                    public void onError(ApiException e) {
                        Toast.makeText(activity,e.getMessage(),Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onSuccess(String entity) {
                        Log.i("www","data="+entity);
                        activity.finish();
                    }
                });
    }

    /**
     * 获取默认地址
     */
    public void getUserDefaultAddress(){
        Map<String, Object> params = new HashMap<>();
        params.put("userId", UserLocalData.getUserInfo(activity).getUserInfo().getUserId());

        EasyHttp.post("getUserDefaultAddress")
                .upJson(new JSONObject(params).toString())
                .execute(new SimpleCallBack<DefaultAddressEntity>() {

                    @Override
                    public void onError(ApiException e) {
                        Toast.makeText(activity,e.getMessage(),Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onSuccess(DefaultAddressEntity entity) {
                        if (null!=entity.getUserDefaultAddress())
                            activity.updataAddress(entity);
                    }
                });
    }
}
