package com.whombang.app.features.mycenter.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.whombang.app.R;
import com.whombang.app.common.base.BaseActivity;
import com.whombang.app.common.net.EasyHttp;
import com.whombang.app.common.net.callback.SimpleCallBack;
import com.whombang.app.common.net.exception.ApiException;
import com.whombang.app.common.view.TitleBar;
import com.whombang.app.entity.UserLocalData;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;

/**
 * 反馈（完成）
 */
@Route(path = "/set/feedback")
public class FeedbackActivity extends BaseActivity{
@BindView(R.id.et_feedback)
    EditText etFeedBack;
    @Override
    protected int bindLayout() {
        return R.layout.wb_feedback_layout;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
            titleBar.setTitle("反馈");
            titleBar.addAction(new TitleBar.TextAction("发送") {
                @Override
                public void performAction(View view) {
                    if (!TextUtils.isEmpty(etFeedBack.getText().toString())) {
                        sendFeedback();
                    }else{
                        Toast.makeText(mContext,"内容不能为空",Toast.LENGTH_SHORT).show();
                    }
                }
            });
    }

    @Override
    public void doBusiness() {

    }

    private void sendFeedback() {
        final Map<String, Object> params = new HashMap<>();
        params.put("userId", UserLocalData.getUserInfo(mContext).getUserInfo().getUserId());
        params.put("feedbackContent", etFeedBack.getText().toString());

        EasyHttp.post("userFeedback")
                .upJson(new JSONObject(params).toString())
                .execute(new SimpleCallBack<String>() {

                    @Override
                    public void onError(ApiException e) {
                        Toast.makeText(mContext, e.getMessage(), Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onSuccess(String entity) {
                        Toast.makeText(mContext, "发送成功", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });
    }

}
