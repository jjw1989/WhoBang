package com.whombang.app.mvp.presenter;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.Toast;

import com.alibaba.android.arouter.launcher.ARouter;
import com.whombang.app.common.constants.Contents;
import com.whombang.app.common.net.EasyHttp;
import com.whombang.app.common.net.callback.ProgressDialogCallBack;
import com.whombang.app.common.net.exception.ApiException;
import com.whombang.app.common.net.subsciber.IProgressDialog;
import com.whombang.app.common.utils.PreferenceUtil;
import com.whombang.app.common.utils.Validator;
import com.whombang.app.entity.UserInfoEntity;
import com.whombang.app.entity.UserLocalData;
import com.whombang.app.features.login.RegisterActivity;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

/**
 * Created by sundy.jiang on 2017/12/14.
 */

public class RegisterPresenter {
    private float scale = 0.2f; //logo缩放比例
    private RegisterActivity registerActivity;

    @Inject
    public RegisterPresenter(RegisterActivity registerActivity) {
        this.registerActivity = registerActivity;
    }

    /**
     * 注册用户
     *
     * @param phone
     * @param newPassword
     * @param invitation
     */
    public void registerUser(String phone, String newPassword, String invitation) {
        if (validatorData(phone, newPassword, invitation)) {
            IProgressDialog mProgressDialog = new IProgressDialog() {
                @Override
                public Dialog getDialog() {
                    ProgressDialog dialog = new ProgressDialog(registerActivity);
                    dialog.setMessage("注册中...");
                    return dialog;
                }
            };
            Map<String, String> params = new HashMap<>();
            params.put("userTel", phone);
            params.put("smsCode", newPassword);
            params.put("invitationCode", invitation);
            EasyHttp.post("userRegist")
                    .upJson(new JSONObject(params).toString())
                    .execute(new ProgressDialogCallBack<UserInfoEntity>(mProgressDialog, true, true) {

                        @Override
                        public void onSuccess(UserInfoEntity userInfoEntity) {
                            // Log.i("wwww","userInfoEntity="+userInfoEntity.getUserInfo().toString());
                            UserLocalData.putUser(registerActivity, userInfoEntity);
                            PreferenceUtil.putBoolean(registerActivity, Contents.LOGIN, true);
                            ARouter.getInstance().build("/main/tab").navigation();
                        }

                        @Override
                        public void onError(ApiException e) {
                            super.onError(e);
                            Toast.makeText(registerActivity, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
        }
    }

    /**
     * 校验数据
     */
    private boolean validatorData(String phone, String newPassword, String invitation) {
        if (!Validator.isMobile(phone)) {
            Toast.makeText(registerActivity, "请输入正确格式的手机号", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(newPassword)) {
            Toast.makeText(registerActivity, "验证码不能为空", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(invitation)) {
            Toast.makeText(registerActivity, "邀请码不能为空", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    public void onSoftKeyboardOpened(int keyboardSize, View body, ImageView imgLogo, int screenHeight) {
        keyboardSize += 100;
        int[] location = new int[2];
        body.getLocationOnScreen(location); //获取body在屏幕中的坐标,控件左上角
        int x = location[0];
        int y = location[1];
        int bottom = screenHeight - (y + body.getHeight());
        if (keyboardSize > bottom) {
            ObjectAnimator mAnimatorTranslateY = ObjectAnimator.ofFloat(body, "translationY", 0.0f, -(keyboardSize - bottom));
            mAnimatorTranslateY.setDuration(300);
            mAnimatorTranslateY.setInterpolator(new AccelerateDecelerateInterpolator());
            mAnimatorTranslateY.start();
            zoomIn(imgLogo, keyboardSize - bottom);

        }
    }

    public void onSoftKeyboardClosed(View body, ImageView imgLogo) {
        ObjectAnimator mAnimatorTranslateY = ObjectAnimator.ofFloat(body, "translationY", body.getTranslationY(), 0);
        mAnimatorTranslateY.setDuration(300);
        mAnimatorTranslateY.setInterpolator(new AccelerateDecelerateInterpolator());
        mAnimatorTranslateY.start();
        zoomOut(imgLogo);
    }

    /**
     * 缩小
     *
     * @param view
     */
    public void zoomIn(final View view, float dist) {
        view.setPivotY(view.getHeight());
        view.setPivotX(view.getWidth() / 2);
        AnimatorSet mAnimatorSet = new AnimatorSet();
        ObjectAnimator mAnimatorScaleX = ObjectAnimator.ofFloat(view, "scaleX", 1.0f, scale);
        ObjectAnimator mAnimatorScaleY = ObjectAnimator.ofFloat(view, "scaleY", 1.0f, scale);
        ObjectAnimator mAnimatorTranslateY = ObjectAnimator.ofFloat(view, "translationY", 0.0f, -dist);
        mAnimatorSet.play(mAnimatorTranslateY).with(mAnimatorScaleX).with(mAnimatorScaleY);
        mAnimatorSet.setDuration(300);
        mAnimatorSet.start();

    }

    /**
     * f放大
     *
     * @param view
     */
    public void zoomOut(final View view) {
        if (view.getTranslationY() == 0) {
            return;
        }
        view.setPivotY(view.getHeight());
        view.setPivotX(view.getWidth() / 2);
        AnimatorSet mAnimatorSet = new AnimatorSet();

        ObjectAnimator mAnimatorScaleX = ObjectAnimator.ofFloat(view, "scaleX", scale, 1.0f);
        ObjectAnimator mAnimatorScaleY = ObjectAnimator.ofFloat(view, "scaleY", scale, 1.0f);
        ObjectAnimator mAnimatorTranslateY = ObjectAnimator.ofFloat(view, "translationY", view.getTranslationY(), 0);

        mAnimatorSet.play(mAnimatorTranslateY).with(mAnimatorScaleX).with(mAnimatorScaleY);
        mAnimatorSet.setDuration(300);
        mAnimatorSet.start();

    }
}
