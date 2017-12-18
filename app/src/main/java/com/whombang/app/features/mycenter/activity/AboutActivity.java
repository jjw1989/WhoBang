package com.whombang.app.features.mycenter.activity;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.whombang.app.R;
import com.whombang.app.common.base.BaseActivity;
import com.whombang.app.common.utils.AppUtils;

import butterknife.BindView;

/**
 * 关于我们
 */
@Route(path = "/my/about")
public class AboutActivity extends BaseActivity {
    @BindView(R.id.tv_vision)
    TextView tvVision;
    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return R.layout.wb_about_layout;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        titleBar.setVisibility(View.VISIBLE);
        titleBar.setTitle("关于我们");
        titleBar.setDividerColor(R.color.bg);

    }

    @Override
    public void doBusiness() {
         tvVision.setText("版本V"+ AppUtils.getAppVersionCode(this,getPackageName()));
    }
}
