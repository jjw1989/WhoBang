package com.whombang.app.mvp.presenter;

import android.widget.Toast;

import com.whombang.app.common.net.EasyHttp;
import com.whombang.app.common.net.callback.SimpleCallBack;
import com.whombang.app.common.net.exception.ApiException;
import com.whombang.app.entity.ServiceInfoEntity;
import com.whombang.app.entity.UserLocalData;
import com.whombang.app.features.mycenter.activity.ServerInfoActivity;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

/**
 * Created by sundy.jiang on 2017/12/27.
 */

public class ServerInfoPresenter {
    private ServerInfoActivity activity;
    private int pageNum = 1;

    @Inject
    public ServerInfoPresenter(ServerInfoActivity activity) {
        this.activity = activity;
    }

    public void requestNetData() {
        pageNum = 1;
        final Map<String, Object> params = new HashMap<>();
        params.put("stationId", UserLocalData.getUserInfo(activity).getStationInfo().getStationId());
        params.put("status", 1);
        params.put("pageSize", 20);
        params.put("currentPageNum", 1);

        EasyHttp.post("getStationProviderUserInfoList")
                .upJson(new JSONObject(params).toString())
                .execute(new SimpleCallBack<ServiceInfoEntity>() {

                    @Override
                    public void onError(ApiException e) {
                        Toast.makeText(activity, e.getMessage(), Toast.LENGTH_SHORT).show();
                        activity.mRefreshLayout.finishRefresh();
                    }

                    @Override
                    public void onSuccess(ServiceInfoEntity entity) {
                        activity.requestNetData(entity.getProviderUserInfoList());
                        activity.mRefreshLayout.finishRefresh();
                        pageNum++;
                    }
                });
    }

    public void requestNetMoreData() {
        final Map<String, Object> params = new HashMap<>();
        params.put("stationId", UserLocalData.getUserInfo(activity).getStationInfo().getStationId());
        params.put("status", 1);
        params.put("pageSize", 20);
        params.put("currentPageNum", pageNum);

        EasyHttp.post("getStationProviderUserInfoList")
                .upJson(new JSONObject(params).toString())
                .execute(new SimpleCallBack<ServiceInfoEntity>() {

                    @Override
                    public void onError(ApiException e) {
                        Toast.makeText(activity, e.getMessage(), Toast.LENGTH_SHORT).show();
                        activity.mRefreshLayout.finishLoadmore();
                    }

                    @Override
                    public void onSuccess(ServiceInfoEntity entity) {
                        activity.requestNetMoreData(entity.getProviderUserInfoList());
                        activity.mRefreshLayout.finishLoadmore();
                        pageNum++;
                    }
                });
    }
}
