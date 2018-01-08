package com.whombang.app.mvp.presenter;

import android.util.Log;
import android.widget.Toast;

import com.whombang.app.common.net.EasyHttp;
import com.whombang.app.common.net.callback.SimpleCallBack;
import com.whombang.app.common.net.exception.ApiException;
import com.whombang.app.entity.StationEntity;
import com.whombang.app.entity.UserLocalData;
import com.whombang.app.features.sendtask.StationServiceActivity;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

/**
 * Created by sundy.jiang on 2018/1/8.
 */

public class StationServicePresenter {
    private StationServiceActivity activity;

    @Inject
    public StationServicePresenter(StationServiceActivity activity){
        this.activity=activity;
    }

   public void requestStationInfo(){
       final Map<String, Object> params = new HashMap<>();
       params.put("userId", UserLocalData.getUserInfo(activity).getUserInfo().getUserId());
       EasyHttp.post("getAllStationAndManagerInfo")
               .upJson(new JSONObject(params).toString())
               .execute(new SimpleCallBack<StationEntity>() {

                   @Override
                   public void onError(ApiException e) {
                       Toast.makeText(activity,e.getMessage(),Toast.LENGTH_SHORT).show();
                   }

                   @Override
                   public void onSuccess(StationEntity entity) {
                          activity.refreshStationToMap(entity.getStationInfo());
                   }
               });
   }
}
