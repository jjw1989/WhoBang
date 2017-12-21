package com.whombang.app.mvp.presenter;

import com.whombang.app.features.mycenter.activity.ServiceOrderDetailsActivity;

import javax.inject.Inject;

/**
 * 我的服务：服务订单详情
 * Created by David on 2017/12/21.
 */

public class ServiceOrderDetailsPresenter {
    private ServiceOrderDetailsActivity activity;

    @Inject
    public ServiceOrderDetailsPresenter(ServiceOrderDetailsActivity activity){
        this.activity=activity;
    }

}
