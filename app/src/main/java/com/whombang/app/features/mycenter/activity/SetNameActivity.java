package com.whombang.app.features.mycenter.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.whombang.app.R;
import com.whombang.app.common.base.BaseActivity;
import com.whombang.app.common.view.TitleBar;

/**
 * 设置名字
 */
@Route(path = "/set/name")
public class SetNameActivity extends BaseActivity {
    int type;

    @Override
    protected int bindLayout() {
        return R.layout.wb_set_name_layout;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    public void initData(Bundle bundle) {
        type=bundle.getInt("type");
    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        if (type==0){
            titleBar.setTitle("设置昵称");
        }else{
            titleBar.setTitle("设置名字");
        }

        titleBar.setLeftText("取消");
        titleBar.addAction(new TitleBar.TextAction("完成") {
            @Override
            public void performAction(View view) {
                Toast.makeText(mContext,"发布",Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void doBusiness() {

    }
}
