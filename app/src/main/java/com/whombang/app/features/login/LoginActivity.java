package com.whombang.app.features.login;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.view.Window;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.google.gson.Gson;
import com.whombang.app.R;
import com.whombang.app.adapter.ItemTitlePagerAdapter;
import com.whombang.app.common.base.BaseActivity;
import com.whombang.app.common.view.EasyIndicator;
import com.whombang.app.common.view.KeyboardWatcher;
import com.whombang.app.common.view.NoScrollViewPager;
import com.whombang.app.common.view.hideime.HideIMEUtil;
import com.whombang.app.features.login.fragment.PassWordLoginFragment;
import com.whombang.app.features.login.fragment.SMSLoginFragment;
import com.whombang.app.mvp.component.DaggerLoginActivityComponent;
import com.whombang.app.mvp.module.LoginActivityModule;
import com.whombang.app.mvp.presenter.LoginPresenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.RequestBody;

/**
 * 登陆页面
 */
@Route(path = "/user/login")
public class LoginActivity extends BaseActivity implements KeyboardWatcher.SoftKeyboardStateListener{
    @BindView(R.id.easy_indicator)
    EasyIndicator tabStrip;
    @BindView(R.id.vp_content)
    NoScrollViewPager viewPager;
    private List<Fragment> fragmentList;
    @Inject
    LoginPresenter presenter;
    private KeyboardWatcher keyboardWatcher;
    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return R.layout.wb_login_layout;
    }

    @Override
    protected void initInjector() {
        DaggerLoginActivityComponent.builder().loginActivityModule(new LoginActivityModule(this)).build().inject(this);
    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        titleBar.setTitle("登陆");
        fragmentList = new ArrayList<>();
        fragmentList.add(new PassWordLoginFragment());
        fragmentList.add(new SMSLoginFragment());
        viewPager.setNoScroll(true);
        tabStrip.setTabTitles(new String[]{"密码登录", "验证码登录"});
        tabStrip.setViewPage(viewPager,new ItemTitlePagerAdapter(getSupportFragmentManager(), fragmentList, new String[]{"密码登录", "验证码登录"}));
        tabStrip.setOnTabClickListener(new EasyIndicator.onTabClickListener() {
            @Override
            public void onTabClick(String title, int position) {

            }
        });
        HideIMEUtil.wrap(this);
        keyboardWatcher = new KeyboardWatcher(findViewById(Window.ID_ANDROID_CONTENT));
        keyboardWatcher.addSoftKeyboardStateListener(this);
    }


    @Override
    public void doBusiness() {

    }


    @Override
    public void onSoftKeyboardOpened(int keyboardHeightInPx) {
        Log.i("wwww","11111111111111111111");
    }

    @Override
    public void onSoftKeyboardClosed() {
        Log.i("wwww","2222222222222222222222222");
    }
}
