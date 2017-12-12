package com.whombang.app.features.login;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.google.gson.Gson;
import com.whombang.app.R;
import com.whombang.app.common.base.BaseActivity;
import com.whombang.app.common.net.BaseResponse;
import com.whombang.app.common.net.BaseSubscriber;
import com.whombang.app.common.net.ExceptionHandle;
import com.whombang.app.common.net.RetrofitClient;
import com.whombang.app.entity.UserInfoEntity;

import java.util.HashMap;
import java.util.Map;

import butterknife.OnClick;
import io.reactivex.functions.Consumer;
import okhttp3.RequestBody;

/**
 * 登陆页面
 */
@Route(path = "/user/login")
public class LoginActivity extends BaseActivity {

    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return R.layout.wb_login_layout;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        titleBar.setTitle("登陆");
    }


    @Override
    public void doBusiness() {

    }

    @OnClick(R.id.btn_login)
    public void onStartLogin(View v){
        Map<String,String> params=new HashMap<>();
        params.put("userTel","15011112111");
        params.put("userPassword","111111");
        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), new Gson().toJson(params));
        RetrofitClient.getInstance(this)
                .createBaseApi()
                .json("userLoginByPassword",body)
                .subscribe(new BaseSubscriber<BaseResponse>(this) {
                    @Override
                    public void onError(ExceptionHandle.ResponeThrowable e) {

                    }

                    @Override
                    public void onNext(BaseResponse baseResponse) {
                        Log.d("wwww", "onNext: 11111111111111111111111");
                    }
                });

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
