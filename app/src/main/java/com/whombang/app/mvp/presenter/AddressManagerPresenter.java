package com.whombang.app.mvp.presenter;

import android.widget.Toast;

import com.whombang.app.common.net.EasyHttp;
import com.whombang.app.common.net.callback.SimpleCallBack;
import com.whombang.app.common.net.exception.ApiException;
import com.whombang.app.entity.ConsigneeEntity;
import com.whombang.app.features.mycenter.activity.AddressManagerActivity;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

/**
 * Created by David on 2017/12/16.
 */

public class AddressManagerPresenter {
    private AddressManagerActivity activity;

    @Inject
    public AddressManagerPresenter(AddressManagerActivity activity) {
        this.activity = activity;
    }

    /**
     * 获取地址列表
     *
     * @param userId
     */
    public void requestAddressList(String userId) {
        Map<String, String> params = new HashMap<>();
        params.put("userId", userId);
        EasyHttp.post("getUserAddressList")
                .upJson(new JSONObject(params).toString())
                .execute(new SimpleCallBack<ConsigneeEntity>() {

                    @Override
                    public void onError(ApiException e) {
                        Toast.makeText(activity,e.getMessage(),Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onSuccess(ConsigneeEntity entity) {
                        activity.loadAddress(entity.getUserAddressInfos());
                    }
                });
    }

}
