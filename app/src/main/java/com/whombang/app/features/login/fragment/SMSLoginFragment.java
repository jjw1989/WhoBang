package com.whombang.app.features.login.fragment;


import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.BoolRes;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.alibaba.android.arouter.launcher.ARouter;
import com.google.gson.Gson;
import com.whombang.app.R;
import com.whombang.app.common.base.BaseFragment;
import com.whombang.app.common.constants.Contents;
import com.whombang.app.common.net.EasyHttp;
import com.whombang.app.common.net.callback.ProgressDialogCallBack;
import com.whombang.app.common.net.exception.ApiException;
import com.whombang.app.common.net.subsciber.IProgressDialog;
import com.whombang.app.common.utils.PreferenceUtil;
import com.whombang.app.common.utils.RxJavaUtil;
import com.whombang.app.common.utils.Validator;
import com.whombang.app.entity.UserInfoEntity;
import com.whombang.app.entity.UserLocalData;

import org.json.JSONObject;

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
    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.et_new_sms)
    EditText etSms;
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
        String phone = etPhone.getText().toString();
        String sms = etSms.getText().toString();
        if (login(phone)) {
            IProgressDialog mProgressDialog = new IProgressDialog() {
                @Override
                public Dialog getDialog() {
                    ProgressDialog dialog = new ProgressDialog(mActivity);
                    dialog.setMessage("登录中...");
                    return dialog;
                }
            };
            Map<String, String> params = new HashMap<>();
            params.put("userTel", etPhone.getText().toString());
            params.put("smsCode", etSms.getText().toString());
            EasyHttp.post("userLoginBySMSCode")
                    .upJson(new JSONObject(params).toString())
                    .execute(new ProgressDialogCallBack<UserInfoEntity>(mProgressDialog, true, true) {

                        @Override
                        public void onSuccess(UserInfoEntity userInfoEntity) {
                            //保存用户信息
                            UserLocalData.putUser(mActivity, userInfoEntity);
                            PreferenceUtil.putBoolean(mActivity, Contents.LOGIN, true);
                            ARouter.getInstance().build("/main/tab").navigation();
                            mActivity.finish();
                        }

                        @Override
                        public void onError(ApiException e) {
                            super.onError(e);
                            Toast.makeText(mActivity, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
        }
    }
        /**
         * 登录校验
         * @param phone
         * @return
         */
    private boolean login(String phone) {
        if (!Validator.isMobile(phone)) {
            Toast.makeText(mActivity, "请输入正确格式的手机号", Toast.LENGTH_SHORT).show();
            return false;
        }


        return true;
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
