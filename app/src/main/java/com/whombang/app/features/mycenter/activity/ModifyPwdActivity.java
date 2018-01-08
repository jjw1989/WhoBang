package com.whombang.app.features.mycenter.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.whombang.app.R;
import com.whombang.app.common.base.BaseActivity;
import com.whombang.app.common.view.TitleBar;
import com.whombang.app.entity.UserLocalData;

import butterknife.BindView;

/**
 * 修改密码
 */
@Route(path = "/set/modifypwd")
public class ModifyPwdActivity extends BaseActivity {
    @BindView(R.id.tv_modify_pwd)
    TextView tvModifyPwd;
    @Override
    protected int bindLayout() {
        return R.layout.wb_modify_pwd_layout;
    }

    @Override
    protected void initInjector() {

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


                finish();
            }
        });
        tvModifyPwd.setText(UserLocalData.getUserInfo(this).getUserInfo().getUserTel());
    }

    @Override
    public void doBusiness() {

    }
}
