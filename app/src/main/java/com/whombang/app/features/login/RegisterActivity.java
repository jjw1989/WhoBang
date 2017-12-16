package com.whombang.app.features.login;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.gxz.PagerSlidingTabStrip;
import com.whombang.app.R;
import com.whombang.app.adapter.ItemTitlePagerAdapter;
import com.whombang.app.common.base.BaseActivity;
import com.whombang.app.common.utils.RxJavaUtil;
import com.whombang.app.common.view.EasyIndicator;
import com.whombang.app.common.view.KeyboardWatcher;
import com.whombang.app.common.view.NoScrollViewPager;
import com.whombang.app.features.login.fragment.PassWordLoginFragment;
import com.whombang.app.features.login.fragment.SMSLoginFragment;
import com.whombang.app.features.shop.fragment.GoodsCommentFragment;
import com.whombang.app.features.shop.fragment.GoodsDetailFragment;
import com.whombang.app.features.shop.fragment.GoodsInfoFragment;
import com.whombang.app.mvp.component.DaggerLoginActivityComponent;
import com.whombang.app.mvp.component.DaggerRegisterActivityComponent;
import com.whombang.app.mvp.module.RegisterActivityModule;
import com.whombang.app.mvp.presenter.RegisterPresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.functions.Consumer;

/**
 * 用户注册
 */
@Route(path = "/user/register")
public class RegisterActivity extends BaseActivity implements KeyboardWatcher.SoftKeyboardStateListener {
    @BindView(R.id.img_logo_register)
    ImageView imgLogo;
    @BindView(R.id.register_body)
    View body;
    @BindView(R.id.btn_register_code)
    Button btnCode;
    @BindView(R.id.et_register_password)
    EditText etPassWord;
    @BindView(R.id.et_register_new_password)
    EditText etNewPassword;
    @BindView(R.id.et_invitation_code)
    EditText etInvitationCode;

    @Inject
    RegisterPresenter presenter;
    private KeyboardWatcher keyboardWatcher;

    private int screenHeight = 0;//屏幕高度

    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return R.layout.wb_register_layout;
    }

    @Override
    protected void initInjector() {
        DaggerRegisterActivityComponent.builder().registerActivityModule(new RegisterActivityModule(this)).build().inject(this);
    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        titleBar.setTitle(getString(R.string.register));
        screenHeight = this.getResources().getDisplayMetrics().heightPixels; //获取屏幕高度
        keyboardWatcher = new KeyboardWatcher(findViewById(Window.ID_ANDROID_CONTENT));
        keyboardWatcher.addSoftKeyboardStateListener(this);
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

    @OnClick({R.id.btn_register_code,R.id.btn_register})
    public void onClickView(View v) {
        switch (v.getId()){
            case R.id.btn_register_code:
                onSmsCode();
                break;
            case R.id.btn_register:
                presenter.registerUser(etPassWord.getText().toString(),etNewPassword.getText().toString(),etInvitationCode.getText().toString());
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
