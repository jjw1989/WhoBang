package com.whombang.app.mvp.presenter;

import android.widget.Toast;

import com.whombang.app.common.net.EasyHttp;
import com.whombang.app.common.net.callback.SimpleCallBack;
import com.whombang.app.common.net.exception.ApiException;
import com.whombang.app.entity.PhoneEntity;
import com.whombang.app.entity.UserLocalData;
import com.whombang.app.features.sendtask.ServicePhoneActivity;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

/**
 * Created by sundy.jiang on 2018/1/3.
 */

public class ServicePhonePresenter {
    private ServicePhoneActivity activity;
    @Inject
    public ServicePhonePresenter(ServicePhoneActivity activity){
        this.activity=activity;
    }

    public void requestNetData(int pageSize,int currentPageNum){
        Map<String, Object> params = new HashMap<>();
        params.put("userId", UserLocalData.getUserInfo(activity).getUserInfo().getUserId());
        params.put("pageSize", pageSize);
        params.put("currentPageNum", currentPageNum);
        EasyHttp.post("getProviderUserPhoneInfoList")
                .upJson(new JSONObject(params).toString())
                .execute(new SimpleCallBack<PhoneEntity>() {

                    @Override
                    public void onError(ApiException e) {
                        Toast.makeText(activity,e.getMessage(),Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onSuccess(PhoneEntity entity) {
                        activity.updatePhoneList(entity.getGetProviderUserPhoneInfoList());
                    }
                });
    }

    public void requestNetMoreData(int pageSize,int currentPageNum){
        Map<String, Object> params = new HashMap<>();
        params.put("userId", UserLocalData.getUserInfo(activity).getUserInfo().getUserId());
        params.put("pageSize", pageSize);
        params.put("currentPageNum", currentPageNum);
        EasyHttp.post("getProviderUserPhoneInfoList")
                .upJson(new JSONObject(params).toString())
                .execute(new SimpleCallBack<PhoneEntity>() {

                    @Override
                    public void onError(ApiException e) {
                        Toast.makeText(activity,e.getMessage(),Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onSuccess(PhoneEntity entity) {
                        activity.updateMorePhoneList(entity.getGetProviderUserPhoneInfoList());
                    }
                });
    }
}
