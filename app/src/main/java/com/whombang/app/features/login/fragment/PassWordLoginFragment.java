package com.whombang.app.features.login.fragment;


import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.alibaba.android.arouter.launcher.ARouter;
import com.google.gson.Gson;
import com.whombang.app.R;
import com.whombang.app.common.base.BaseFragment;
import com.whombang.app.common.constants.Contents;
import com.whombang.app.common.enctypt.DESUtil;
import com.whombang.app.common.net.EasyHttp;
import com.whombang.app.common.net.callback.ProgressDialogCallBack;
import com.whombang.app.common.net.callback.SimpleCallBack;
import com.whombang.app.common.net.exception.ApiException;
import com.whombang.app.common.net.subsciber.IProgressDialog;
import com.whombang.app.common.utils.PreferenceUtil;
import com.whombang.app.common.utils.Validator;
import com.whombang.app.entity.UserInfoEntity;
import com.whombang.app.entity.UserLocalData;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.RequestBody;

/**
 * 密码登录
 */
public class PassWordLoginFragment extends BaseFragment {
    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.et_password_one)
    EditText etPassWord;

    @Override
    protected int bindLayout() {
        return R.layout.wb_pass_word_login_layout;
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
    public void onStartLogin() {
        String phone = etPhone.getText().toString();
        String password = etPassWord.getText().toString();
        if (login(phone, password)) {
            IProgressDialog mProgressDialog = new IProgressDialog() {
                @Override
                public Dialog getDialog() {
                    ProgressDialog dialog = new ProgressDialog(mActivity);
                    dialog.setMessage("登录中...");
                    return dialog;
                }
            };
            Map<String, String> params = new HashMap<>();
          //  String phone1 = DESUtil.encrypt(etPhone.getText().toString(), "80f37a994f8d426c85e5b4d2a5f30350");
           // Log.i("qazxc", "onStartLogin: "+phone1);
            params.put("userTel", etPhone.getText().toString());
            params.put("userPassword", etPassWord.getText().toString());
            EasyHttp.post("userLoginByPassword")
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
     *
     * @param phone
     * @param password
     * @return
     */
    private boolean login(String phone, String password) {
        if (!Validator.isMobile(phone)) {
            Toast.makeText(mActivity, "请输入正确格式的手机号", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!Validator.isPassword(password)) {
            Toast.makeText(mActivity, "请设置为6~16位数字和字母", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    @OnClick(R.id.tv_register)
    public void registerUser() {
        ARouter.getInstance().build("/user/register").navigation();
    }

    @OnClick(R.id.tv_forget)
    public void forgetPassWord() {
        ARouter.getInstance().build("/user/forget").navigation();
    }
}
