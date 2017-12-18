package com.whombang.app.mvp.presenter;

import android.app.Activity;
import android.widget.Toast;

import com.alibaba.android.arouter.launcher.ARouter;
import com.whombang.app.common.net.EasyHttp;
import com.whombang.app.common.net.callback.SimpleCallBack;
import com.whombang.app.common.net.exception.ApiException;
import com.whombang.app.entity.ConsigneeEntity;
import com.whombang.app.entity.UserLocalData;
import com.whombang.app.features.mycenter.activity.NewlyAddressActivity;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

/**
 * Created by David on 2017/12/17.
 */

public class NewlyAddressPresenter {
    private NewlyAddressActivity activity;

    @Inject
    public NewlyAddressPresenter(NewlyAddressActivity activity){
        this.activity=activity;
    }

    /**
     * 添加详情地址
     * @param userAddressContactPeople
     * @param userAddressContactTel
     * @param userAddressDetail
     */
    public void addAddress(String userAddressContactPeople,String userAddressContactTel,String contactAddress,String userAddressDetail){
        Map<String, String> params = new HashMap<>();
        params.put("userId", UserLocalData.getUserInfo(activity).getUserInfo().getUserId());
        params.put("userAddressDetail", contactAddress+userAddressDetail);
        params.put("userAddressContactTel", userAddressContactTel);
        params.put("userAddressContactPeople", userAddressContactPeople);
        params.put("userAddressDefault", "false");
        EasyHttp.post("addNewAddress")
                .upJson(new JSONObject(params).toString())
                .execute(new SimpleCallBack<ConsigneeEntity>() {

                    @Override
                    public void onError(ApiException e) {
                        Toast.makeText(activity,e.getMessage(),Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onSuccess(ConsigneeEntity entity) {
                        activity.setResult(Activity.RESULT_OK);
                        activity.finish();
                    }
                });
    }
}
