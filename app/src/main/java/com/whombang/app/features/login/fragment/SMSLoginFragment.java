package com.whombang.app.features.login.fragment;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.launcher.ARouter;
import com.google.gson.Gson;
import com.whombang.app.R;
import com.whombang.app.common.base.BaseFragment;
import com.whombang.app.common.utils.RxJavaUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import okhttp3.RequestBody;

/**
 * 短信登录
 */
public class SMSLoginFragment extends BaseFragment {
    @BindView(R.id.btn_sms_code)
    Button btnCode;
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

    }

    @OnClick({R.id.tv_register,R.id.tv_forget,R.id.btn_sms_code})
    public void onAllClick(View v){
        switch (v.getId()){
            case R.id.tv_register:
                ARouter.getInstance().build("/user/register").navigation();
                break;
            case R.id.tv_forget:
                ARouter.getInstance().build("/user/forget").navigation();
                break;
            case R.id.btn_sms_code:
                onSmsCode();
                break;

        }
    }

    private void onSmsCode() {
       RxJavaUtil.countdown(59).subscribe(new Consumer<Long>() {
            @Override
            public void accept(Long aLong) throws Exception {
                String content=String.format(getString(R.string.residue),aLong);
                btnCode.setText(content);
            }
        });
    }


}
