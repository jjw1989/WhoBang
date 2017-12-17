package com.whombang.app.mvp.presenter;

import android.util.Log;
import android.widget.Toast;

import com.whombang.app.common.net.EasyHttp;
import com.whombang.app.common.net.callback.SimpleCallBack;
import com.whombang.app.common.net.exception.ApiException;
import com.whombang.app.entity.ConsigneeEntity;
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

    public void sendTaskSerivce(String individuationServiceDesc){
        Map<String, Object> params = new HashMap<>();
        params.put("userId", UserLocalData.getUserInfo(activity).getUserInfo().getUserId());
        params.put("stationId", UserLocalData.getUserInfo(activity).getStationInfo().getStationId());
        params.put("individuationServiceDesc", individuationServiceDesc);
        params.put("contact", UserLocalData.getUserInfo(activity).getUserInfo().getUserTel());
        params.put("userInvitationUserId", UserLocalData.getUserInfo(activity).getStationManagerInfo().getStationId());
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
                        Toast.makeText(activity,e.getMessage(),Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onSuccess(String entity) {
                        Log.i("www","data="+entity);
                    }
                });
    }
}
