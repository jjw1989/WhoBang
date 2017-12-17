package com.whombang.app.features.login;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
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
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * 登陆页面
 */
@Route(path = "/user/login")
public class LoginActivity extends BaseActivity implements KeyboardWatcher.SoftKeyboardStateListener {
    @BindView(R.id.img_logo_login)
    ImageView imgLogo;
    @BindView(R.id.easy_indicator)
    EasyIndicator tabStrip;
    @BindView(R.id.vp_content)
    NoScrollViewPager viewPager;
    private List<Fragment> fragmentList;
    @BindView(R.id.llt_body)
    View body;
    @Inject
    LoginPresenter presenter;
    private KeyboardWatcher keyboardWatcher;

    private int screenHeight = 0;//屏幕高度

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
        titleBar.setVisibility(View.GONE);
        titleBar.setTitle(getString(R.string.login));
        titleBar.setLeftClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                askExit();
            }
        });
        screenHeight = this.getResources().getDisplayMetrics().heightPixels; //获取屏幕高度
        fragmentList = new ArrayList<>();
        fragmentList.add(new PassWordLoginFragment());
        fragmentList.add(new SMSLoginFragment());
        viewPager.setNoScroll(true);
        tabStrip.setTabTitles(new String[]{getString(R.string.login_password), getString(R.string.login_sms)});
        tabStrip.setViewPage(viewPager, new ItemTitlePagerAdapter(getSupportFragmentManager(), fragmentList));
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
    public void onSoftKeyboardOpened(int keyboardSize) {
        presenter.onSoftKeyboardOpened(keyboardSize, body, imgLogo, screenHeight);
    }

    @Override
    public void onSoftKeyboardClosed() {
        presenter.onSoftKeyboardClosed(body, imgLogo);
    }
    /***
     * 监听用户点击事件
     *
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            askExit();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    private long exitTime = 0;
    /**
     * 退出程序询问
     */
    private void askExit() {
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            Toast.makeText(getApplicationContext(), getString(R.string.pass_again_exti), Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        } else {
            finish();
            System.exit(0);
        }
    }
}
