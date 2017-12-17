package com.whombang.app.features.sendtask;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.whombang.app.R;
import com.whombang.app.common.base.BaseActivity;
import com.whombang.app.common.view.TitleBar;
import com.whombang.app.mvp.component.DaggerTextTaskComponent;
import com.whombang.app.mvp.module.TextTaskModule;
import com.whombang.app.mvp.presenter.TextTaskPresenter;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * 发布文本任务
 */
@Route(path = "/task/text")
public class TextTaskActivity extends BaseActivity {
    @BindView(R.id.et_text_content)
    EditText etContent;
    @Inject
    TextTaskPresenter presenter;

    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return R.layout.wb_text_task_layout;
    }

    @Override
    protected void initInjector() {
        DaggerTextTaskComponent.builder().textTaskModule(new TextTaskModule(this)).build().inject(this);
    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
      //  ARouter.getInstance().build("/service/map").navigation();
        titleBar.setTitle(getString(R.string.issue_service));
        titleBar.addAction(new TitleBar.TextAction(getString(R.string.issue)) {
            @Override
            public void performAction(View view) {
                //Toast.makeText(mContext,"发布",Toast.LENGTH_SHORT).show();
                presenter.sendTaskSerivce(etContent.getText().toString());
            }
        });
    }

    @Override
    public void doBusiness() {

    }
}
