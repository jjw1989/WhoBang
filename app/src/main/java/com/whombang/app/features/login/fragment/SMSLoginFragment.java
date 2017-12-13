package com.whombang.app.features.login.fragment;


import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;
import com.google.gson.Gson;
import com.whombang.app.R;
import com.whombang.app.common.base.BaseFragment;

import java.util.HashMap;
import java.util.Map;

import butterknife.OnClick;
import okhttp3.RequestBody;

/**
 * 短信登录
 */
public class SMSLoginFragment extends BaseFragment {

    @Override
    protected int bindLayout() {
        return R.layout.wb_smslogin_layout;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {

    }

    @Override
    public void doBusiness() {

    }
    @OnClick(R.id.btn_login)
    public void onStartLogin(){
        Map<String,String> params=new HashMap<>();
        params.put("userTel","15011112111");
        params.put("userPassword","111111");
        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), new Gson().toJson(params));
//        RetrofitClient.getInstance(this)
//                .createBaseApi()
//                .json("userLoginByPassword",body)
//                .subscribe(new BaseSubscriber<BaseResponse>(this) {
//                    @Override
//                    public void onError(ExceptionHandle.ResponeThrowable e) {
//
//                    }
//
//                    @Override
//                    public void onNext(BaseResponse baseResponse) {
//                        Log.d("wwww", "onNext: 11111111111111111111111");
//                    }
//                });

        ARouter.getInstance().build("/main/tab").navigation();
    }

    @OnClick(R.id.tv_register)
    public void registerUser(){
        ARouter.getInstance().build("/user/register").navigation();
    }

    @OnClick(R.id.tv_forget)
    public void forgetPassWord(){
        ARouter.getInstance().build("/user/forget").navigation();
    }
}
