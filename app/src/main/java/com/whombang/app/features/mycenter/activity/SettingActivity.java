package com.whombang.app.features.mycenter.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.whombang.app.R;
import com.whombang.app.common.base.BaseActivity;
import com.whombang.app.common.constants.Contents;
import com.whombang.app.entity.UserLocalData;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 设置界面
 */
@Route(path = "/my/userset")
public class SettingActivity extends BaseActivity {
    @BindView(R.id.tv_nickname)
    TextView etNickName;

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
        etNickName.setText(UserLocalData.getUserInfo(mContext).getUserInfo().getUserNickName());
    }

    @Override
    public void doBusiness() {

    }

    @OnClick({R.id.rlt_address,R.id.rlt_nickname,R.id.rlt_feedback})
    public void onClickView(View v){
        switch (v.getId()){
            case R.id.rlt_address:
                ARouter.getInstance().build("/address/manager").navigation();
                break;
            case R.id.rlt_feedback:
                ARouter.getInstance().build("/set/feedback").navigation();
                break;
            case R.id.rlt_nickname:
                ARouter.getInstance().build("/set/name").navigation(mActivity,Contents.SET_NICKNAME);
                break;
        }


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode== Contents.SET_NICKNAME){
            if(resultCode==RESULT_OK){
                Log.i("qwert", "onActivityResult: "+UserLocalData.getUserInfo(mContext).getUserInfo().getUserNickName());
                etNickName.setText(UserLocalData.getUserInfo(mContext).getUserInfo().getUserNickName());
            }
        }
    }
}
