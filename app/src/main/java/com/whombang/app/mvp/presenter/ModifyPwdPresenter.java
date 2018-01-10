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
import com.whombang.app.common.net.EasyHttp;
import com.whombang.app.common.net.callback.ProgressDialogCallBack;
import com.whombang.app.common.net.exception.ApiException;
import com.whombang.app.common.net.subsciber.IProgressDialog;
import com.whombang.app.entity.UserInfoEntity;
import com.whombang.app.entity.UserLocalData;
import com.whombang.app.features.mycenter.activity.ModifyPwdActivity;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

/**
 * Created by sundy.jiang on 2018/1/10.
 */

public class ModifyPwdPresenter {
    private ModifyPwdActivity activity;
    private float scale = 0.2f; //logo缩放比例
    @Inject
    public ModifyPwdPresenter(ModifyPwdActivity activity){
           this.activity=activity;
    }
    /**
     * 获取密码
     */
    public void requestPassword(String phone,String code,String password){
        IProgressDialog mProgressDialog = new IProgressDialog() {
            @Override
            public Dialog getDialog() {
                ProgressDialog dialog = new ProgressDialog(activity);
                dialog.setMessage("更新密码中...");
                return dialog;
            }
        };
        Map<String,String> params=new HashMap<>();
        params.put("userId", UserLocalData.getUserInfo(activity).getUserInfo().getUserId());
        params.put("userTel",phone);
        params.put("smsCode",code);
        params.put("passWord",password);
        EasyHttp.post("alterUserPassword")
                .upJson(new JSONObject(params).toString())
                .execute(new ProgressDialogCallBack<UserInfoEntity>(mProgressDialog,true,true) {

                    @Override
                    public void onSuccess(UserInfoEntity userInfoEntity) {
                        ARouter.getInstance().build("/user/login").withTransition(R.anim.push_left_in, R.anim.push_right_out).navigation(activity);
                    }

                    @Override
                    public void onError(ApiException e) {
                        super.onError(e);
                        Toast.makeText(activity,e.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                });


    }
    public void onSoftKeyboardOpened(int keyboardSize, View body, ImageView imgLogo, int screenHeight){
        keyboardSize+=100;
        int[] location = new int[2];
        body.getLocationOnScreen(location); //获取body在屏幕中的坐标,控件左上角
        int x = location[0];
        int y = location[1];
        int bottom = screenHeight - (y+body.getHeight()) ;
        if (keyboardSize > bottom){
            ObjectAnimator mAnimatorTranslateY = ObjectAnimator.ofFloat(body, "translationY", 0.0f, -(keyboardSize - bottom));
            mAnimatorTranslateY.setDuration(300);
            mAnimatorTranslateY.setInterpolator(new AccelerateDecelerateInterpolator());
            mAnimatorTranslateY.start();
            zoomIn(imgLogo, keyboardSize - bottom);

        }
    }
    public void onSoftKeyboardClosed(View body, ImageView imgLogo){
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
        if (view.getTranslationY()==0){
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
