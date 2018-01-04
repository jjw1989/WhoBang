package com.whombang.app.features;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.whombang.app.R;
import com.whombang.app.common.base.BaseActivity;
import com.whombang.app.common.systembar.SystemBarManager;
import com.whombang.app.common.view.popupwindow.PopMenuView;
import com.whombang.app.common.view.tabbar.NavigateTabBar;
import com.whombang.app.features.home.fragment.HomeFragment;
import com.whombang.app.features.mycenter.fragment.MyCenterFragment;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.Permission;
import com.yanzhenjie.permission.PermissionListener;
import com.yanzhenjie.permission.PermissionYes;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

@Route(path = "/main/tab")
public class MainActivity extends BaseActivity {
    private static final int REQUEST_CODE_PERMISSION_MULTI = 101;
    /**
     * 底部导航控制器
     */
    @BindView(R.id.main_tabbar)
    NavigateTabBar mNavigateTabBar;
    /**
     * 呼叫器tab键
     */
    @BindView(R.id.fab_call)
    ImageView fabCall;

    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return R.layout.wb_main_layout;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        // SystemBarManager.translucentStatusBar(this,false);
        titleBar.setVisibility(View.GONE);
        mNavigateTabBar.onRestoreInstanceState(savedInstanceState);
        mNavigateTabBar.addTab(HomeFragment.class, new NavigateTabBar.TabParam(R.mipmap.navigate_tab_home, R.mipmap.navigate_tab_home_selected, getString(R.string.tab_txt_home)));
        // mNavigateTabBar.addTab(ShopFragment.class, new NavigateTabBar.TabParam(R.mipmap.navigate_tab_shop, R.mipmap.navigate_tab_shop_selected, getString(R.string.tab_txt_shop)));
        mNavigateTabBar.addTab(null, new NavigateTabBar.TabParam(0, 0, ""));
        //  mNavigateTabBar.addTab(ServiceFragment.class, new NavigateTabBar.TabParam(R.mipmap.navigate_tab_service, R.mipmap.navigate_tab_service_selected, getString(R.string.tab_txt_service)));
        mNavigateTabBar.addTab(MyCenterFragment.class, new NavigateTabBar.TabParam(R.mipmap.navigate_tab_my, R.mipmap.navigate_tab_my_selected, getString(R.string.tab_txt_my)));

    }

    @OnClick(R.id.fab_call)
    public void onBeeper() {
        PopMenuView.getInstance().show(MainActivity.this, fabCall);
        PopMenuView.getInstance().setListener(new PopMenuView.PopupMenuListener() {
            @SuppressLint("MissingPermission")
            @Override
            public void onPopupMenu(int position) {
                switch (position) {
                    case 1:
                        ARouter.getInstance().build("/task/phone").navigation();
                        break;
                    case 2:
                        ARouter.getInstance().build("/task/voice").navigation();
                        break;
                    case 3:
                        ARouter.getInstance().build("/task/text").navigation();
                        break;
                    default:
                }
                PopMenuView.getInstance().closePopupWindowAction();
            }
        });
    }

    @Override
    public void doBusiness() {
        requestPermission();
    }

    /**
     * 请求权限
     */
    private void requestPermission() {
        AndPermission.with(this)
                .requestCode(REQUEST_CODE_PERMISSION_MULTI)
                .permission( Permission.STORAGE, Permission.MICROPHONE, Permission.LOCATION)
                .callback(listener)
                .start();

    }


    /**
     * 保存状态
     *
     * @param outState
     * @param outPersistentState
     */
    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        mNavigateTabBar.onSaveInstanceState(outState);
    }
    private PermissionListener listener = new PermissionListener() {
        @Override
        public void onSucceed(int requestCode, List<String> grantedPermissions) {
            // Successfully.
            if(requestCode == REQUEST_CODE_PERMISSION_MULTI) {
                Log.i("wwww", "getSingleYes: 111111111111111"+grantedPermissions.toString());
            }
        }

        @Override
        public void onFailed(int requestCode, List<String> deniedPermissions) {
            // Failure.
            if(requestCode == REQUEST_CODE_PERMISSION_MULTI) {
                Log.i("wwww", "getSingleNo: 222222222222222222222"+deniedPermissions.toString());
            }
        }
    };

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
            if (PopMenuView.getInstance().isShowing()) {
                PopMenuView.getInstance().closePopupWindowAction();
            } else {
                askExit();
            }
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
