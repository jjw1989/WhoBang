package com.whombang.app.features.mycenter.activity;

import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.whombang.app.R;
import com.whombang.app.common.base.BaseActivity;

import butterknife.OnClick;

/**
 * 设置界面
 */
@Route(path = "/my/userset")
public class SettingActivity extends BaseActivity {

    @Override
    protected int bindLayout() {
        return R.layout.wb_user_setting_layout;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        titleBar.setTitle("设置");
    }

    @Override
    public void doBusiness() {

    }

    @OnClick({R.id.rlt_address,R.id.rlt_nickname})
    public void onClickView(View v){
        switch (v.getId()){
            case R.id.rlt_address:
                ARouter.getInstance().build("/address/manager").navigation();
                break;
//            case R.id.rlt_name:
//                ARouter.getInstance().build("/set/name").withInt("type",1).navigation();
//                break;
            case R.id.rlt_nickname:
                ARouter.getInstance().build("/set/name").withInt("type",0).navigation();
                break;
        }


    }
}
