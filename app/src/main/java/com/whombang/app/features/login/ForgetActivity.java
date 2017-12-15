package com.whombang.app.features.login;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.whombang.app.R;
import com.whombang.app.common.base.BaseActivity;
import com.whombang.app.common.utils.RxJavaUtil;
import com.whombang.app.common.view.KeyboardWatcher;
import com.whombang.app.common.view.hideime.HideIMEUtil;
import com.whombang.app.mvp.component.DaggerForgetActivityComponent;
import com.whombang.app.mvp.module.ForgetActivityModule;
import com.whombang.app.mvp.presenter.ForgetPresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.functions.Consumer;

/**
 * 忘记密码
 */
@Route(path = "/user/forget")
public class ForgetActivity extends BaseActivity implements KeyboardWatcher.SoftKeyboardStateListener {
    @BindView(R.id.img_logo_forget)
    ImageView imgLogo;
    @BindView(R.id.et_new_password)
    EditText etNewPassWord;
    @BindView(R.id.et_affirm_password)
    EditText etAffirmPassWord;
    @BindView(R.id.body)
    View body;
    @BindView(R.id.btn_forget_code)
    Button btnCode;
    @Inject
    ForgetPresenter presenter;
    private float scale = 0.2f; //logo缩放比例
    private int screenHeight = 0;//屏幕高度
    private KeyboardWatcher keyboardWatcher;

    @Override
    protected int bindLayout() {
        return R.layout.wb_forget_layout;
    }

    @Override
    protected void initInjector() {
        DaggerForgetActivityComponent.builder().forgetActivityModule(new ForgetActivityModule(this)).build().inject(this);
    }

    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        titleBar.setTitle(getString(R.string.tv_title));
        screenHeight = this.getResources().getDisplayMetrics().heightPixels; //获取屏幕高度
        keyboardWatcher = new KeyboardWatcher(findViewById(Window.ID_ANDROID_CONTENT));
        keyboardWatcher.addSoftKeyboardStateListener(this);
        HideIMEUtil.wrap(this);
    }

    @Override
    public void doBusiness() {

    }

    @Override
    public void onSoftKeyboardOpened(int keyboardSize) {
        presenter.onSoftKeyboardOpened(keyboardSize, body, imgLogo, screenHeight);
    }

    @Override
    public void onSoftKeyboardClosed() {
        presenter.onSoftKeyboardClosed(body, imgLogo);
    }
    @OnClick({R.id.btn_affirm,R.id.btn_forget_code})
    public void requestCode(View v) {
        switch (v.getId()){
            case R.id.btn_forget_code:
                onSmsCode();
                break;
            case R.id.btn_register_code:

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
