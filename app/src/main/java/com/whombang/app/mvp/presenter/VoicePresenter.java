package com.whombang.app.mvp.presenter;

import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.whombang.app.common.net.EasyHttp;
import com.whombang.app.common.net.callback.SimpleCallBack;
import com.whombang.app.common.net.exception.ApiException;
import com.whombang.app.entity.DefaultAddressEntity;
import com.whombang.app.entity.UserLocalData;
import com.whombang.app.features.sendtask.VoiceActivity;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

/**
 * Created by sundy.jiang on 2018/1/4.
 */

public class VoicePresenter {
    private VoiceActivity activity;

    @Inject
    public VoicePresenter(VoiceActivity activity){
        this.activity=activity;
    }

    public void sendTaskSerivce(String individuationServiceDesc,String address){
        Map<String, Object> params = new HashMap<>();
        params.put("userId", UserLocalData.getUserInfo(activity).getUserInfo().getUserId());
        params.put("stationId", UserLocalData.getUserInfo(activity).getStationInfo().getStationId());
        params.put("individuationServiceDesc", individuationServiceDesc);
        params.put("contact", UserLocalData.getUserInfo(activity).getUserInfo().getUserTel());
        params.put("userInvitationUserId", UserLocalData.getUserInfo(activity).getStationManagerInfo().getStationId());
        params.put("type", 3);
        params.put("longitude", "114.00000");
        params.put("latitude", "32.000000");
        params.put("currentLocation", address);
        params.put("demanderName", UserLocalData.getUserInfo(activity).getUserInfo().getUserRealName());

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
                        if (!TextUtils.isEmpty(entity.getUserDefaultAddress().getUserAddressContactPeople()))
                            activity.updataAddress(entity);
                    }
                });
    }
}
