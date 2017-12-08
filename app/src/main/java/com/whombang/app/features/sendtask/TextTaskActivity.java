package com.whombang.app.features.sendtask;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.githang.statusbar.StatusBarCompat;
import com.whombang.app.R;
import com.whombang.app.common.base.BaseActivity;
import com.whombang.app.common.view.TitleBar;

import butterknife.BindView;

/**
 * 发布文本任务
 */
@Route(path = "/task/text")
public class TextTaskActivity extends BaseActivity {
    @BindView(R.id.common_titleBar)
    TitleBar titleBar;
    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return R.layout.activity_text_task;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
       // ARouter.getInstance().build("/service/map").navigation();
        StatusBarCompat.setStatusBarColor(this, Color.WHITE);
        initTitleBar();
    }
    private void initTitleBar() {
        titleBar.setImmersive(false);
        titleBar.setBackgroundColor(Color.parseColor("#ffffff"));
        titleBar.setLeftImageResource(R.mipmap.back_green);
        titleBar.setLeftClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        titleBar.setTitle("发布服务");
        titleBar.setTitleColor(Color.BLACK);
        titleBar.setDividerColor(Color.WHITE);

        titleBar.setActionTextColor(Color.WHITE);
    }

    @Override
    public void doBusiness() {

    }
}
