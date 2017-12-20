package com.whombang.app.mvp.presenter;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.widget.ImageView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.whombang.app.LauncherActivity;
import com.whombang.app.R;
import com.whombang.app.common.constants.Contents;
import com.whombang.app.common.utils.PreferenceUtil;
import com.whombang.app.features.GuideActivity;
import com.whombang.app.features.MainActivity;
import com.whombang.app.features.login.LoginActivity;

import javax.inject.Inject;

/**
 * Created by sundy.jiang on 2017/12/5.
 */

public class LauncherPresenter {
    private LauncherActivity mActivity;

    @Inject
    public LauncherPresenter(LauncherActivity mActivity) {
        this.mActivity = mActivity;
    }

    public void onStartAnimAndJump(ImageView imgLogo) {
        ObjectAnimator animatorX = ObjectAnimator.ofFloat(imgLogo, "scaleX", 0f, 1f);
        animatorX.setDuration(3000);
        animatorX.start();
        ObjectAnimator animatorY = ObjectAnimator.ofFloat(imgLogo, "scaleY", 0f, 1f);
        animatorY.setDuration(3000);
        animatorY.start();
        ObjectAnimator alpha = ObjectAnimator.ofFloat(imgLogo, "alpha", 0f, 1f);
        alpha.setDuration(3000);
        alpha.start();
        AnimatorSet set = new AnimatorSet();
        set.playTogether(animatorX, animatorY, alpha);
        set.start();
        set.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

                if (PreferenceUtil.getBoolean(mActivity, Contents.GUIDE, true)) {
                    ARouter.getInstance().build("/main/guide").withTransition(R.anim.push_right_in, R.anim.push_left_out).navigation(mActivity);

                } else {
                    if (PreferenceUtil.getBoolean(mActivity, Contents.LOGIN, false)) {
                        ARouter.getInstance().build("/main/tab").withTransition(R.anim.push_right_in, R.anim.push_left_out).navigation(mActivity);

                    } else {
                        ARouter.getInstance().build("/user/login").withTransition(R.anim.push_right_in, R.anim.push_left_out).navigation(mActivity);

                    }

                }
                mActivity.finish();

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
}
