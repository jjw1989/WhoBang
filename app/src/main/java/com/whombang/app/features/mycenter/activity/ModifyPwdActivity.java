package com.whombang.app.features.mycenter.activity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.whombang.app.R;
import com.whombang.app.common.base.BaseActivity;
import com.whombang.app.common.view.KeyboardWatcher;
import com.whombang.app.common.view.TitleBar;
import com.whombang.app.common.view.hideime.HideIMEUtil;
import com.whombang.app.common.view.keyboard.KeyboardLayout;
import com.whombang.app.entity.UserLocalData;
import com.whombang.app.mvp.component.DaggerModifyPwdComponent;
import com.whombang.app.mvp.module.ModifyPwdModule;
import com.whombang.app.mvp.presenter.ModifyPwdPresenter;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * 修改密码
 */
@Route(path = "/set/modifypwd")
public class ModifyPwdActivity extends BaseActivity implements KeyboardWatcher.SoftKeyboardStateListener {
    @Inject
    ModifyPwdPresenter presenter;
    @BindView(R.id.img_logo_forget)
    ImageView imgLogo;
    @BindView(R.id.et_forget_phone)
    EditText etPhone;
    @BindView(R.id.et_forget_code)
    EditText etCode;
    @BindView(R.id.et_new_password)
    EditText etNewPassWord;
    @BindView(R.id.et_affirm_password)
    EditText etAffirmPassWord;
    @BindView(R.id.body)
    View body;
    @BindView(R.id.login_ll)
    ScrollView scrollView;
    @BindView(R.id.main_ll)
    KeyboardLayout keyboardLayout;
    private int screenHeight = 0;//屏幕高度
    private KeyboardWatcher keyboardWatcher;

    @Override
    protected int bindLayout() {
        return R.layout.wb_modify_pwd_layout;
    }

    @Override
    protected void initInjector() {
        DaggerModifyPwdComponent.builder().modifyPwdModule(new ModifyPwdModule(this)).build().inject(this);
    }

    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        titleBar.setTitle("修改密码");
        titleBar.setLeftText("取消");
        titleBar.addAction(new TitleBar.TextAction("完成") {
            @Override
            public void performAction(View view) {
                if (etAffirmPassWord.getText().toString().equals(etNewPassWord.getText().toString())) {
                    presenter.requestPassword(etPhone.getText().toString(), etCode.getText().toString(), etNewPassWord.getText().toString());
                    finish();
                }else{
                    Toast.makeText(mContext,"密码不一致",Toast.LENGTH_SHORT).show();
                }


            }
        });
        screenHeight = this.getResources().getDisplayMetrics().heightPixels; //获取屏幕高度
        keyboardWatcher = new KeyboardWatcher(findViewById(Window.ID_ANDROID_CONTENT));
        keyboardWatcher.addSoftKeyboardStateListener(this);
        HideIMEUtil.wrap(this);
        keyboardLayout.setKeyboardListener(new KeyboardLayout.KeyboardLayoutListener() {
            @Override
            public void onKeyboardStateChanged(boolean isActive, int keyboardHeight) {
                if (isActive) {
                    scrollToBottom();
                }
            }
        });
    }

    /**
     * 弹出软键盘时将SVContainer滑到底
     */
    private void scrollToBottom() {
        scrollView.postDelayed(new Runnable() {

            @Override
            public void run() {
                scrollView.smoothScrollTo(0, 0);//scrollView.getBottom() + SoftKeyInputHidWidget.getStatusBarHeight(mContext)
            }
        }, 100);

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
        {
            presenter.onSoftKeyboardClosed(body, imgLogo);
        }
    }
}
