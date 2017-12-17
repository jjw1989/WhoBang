package com.whombang.app.features.mycenter.activity;

import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.whombang.app.R;
import com.whombang.app.common.base.BaseActivity;
import com.whombang.app.common.view.TitleBar;

/**
 * 评价
 */
@Route(path = "/server/evalute")
public class EvaluateActivity extends BaseActivity {


    @Override
    protected int bindLayout() {
        return R.layout.wb_evaluate_layout;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
      titleBar.setTitle("评价");
      titleBar.addAction(new TitleBar.TextAction("完成") {
          @Override
          public void performAction(View view) {

          }
      });

    }

    @Override
    public void doBusiness() {

    }
}
