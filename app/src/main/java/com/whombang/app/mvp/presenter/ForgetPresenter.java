package com.whombang.app.mvp.presenter;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.Toast;

import com.alibaba.android.arouter.launcher.ARouter;
import com.whombang.app.R;
import com.whombang.app.common.constants.Contents;
import com.whombang.app.common.net.EasyHttp;
import com.whombang.app.common.net.callback.ProgressDialogCallBack;
import com.whombang.app.common.net.exception.ApiException;
import com.whombang.app.common.net.subsciber.IProgressDialog;
import com.whombang.app.common.utils.PreferenceUtil;
import com.whombang.app.entity.UserInfoEntity;
import com.whombang.app.entity.UserLocalData;
import com.whombang.app.features.login.ForgetActivity;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

/**
 * Created by sundy.jiang on 2017/12/14.
 */

public class ForgetPresenter {
    private ForgetActivity forgetActivity;
    private float scale = 0.2f; //logo缩放比例
    @Inject
    public ForgetPresenter(ForgetActivity forgetActivity){
        this.forgetActivity=forgetActivity;
    }

    /**
     * 获取密码
     */
    public void requestPassword(String phone,String code,String password){
        IProgressDialog mProgressDialog = new IProgressDialog() {
            @Override
            public Dialog getDialog() {
                ProgressDialog dialog = new ProgressDialog(forgetActivity);
                dialog.setMessage("更新密码中...");
                return dialog;
            }
        };
        Map<String,String> params=new HashMap<>();
        params.put("userTel",phone);
        params.put("smsCode",code);
        params.put("passWord",password);
        EasyHttp.post("forgetUserPassword")
                .upJson(new JSONObject(params).toString())
                .execute(new ProgressDialogCallBack<UserInfoEntity>(mProgressDialog,true,true) {

                    @Override
                    public void onSuccess(UserInfoEntity userInfoEntity) {
                        ARouter.getInstance().build("/user/login").withTransition(R.anim.push_right_in, R.anim.push_left_out).navigation(forgetActivity);
                    }

                    @Override
                    public void onError(ApiException e) {
                        super.onError(e);
                        Toast.makeText(forgetActivity,e.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                });


   }

}
