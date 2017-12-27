package com.whombang.app.features.mycenter.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.whombang.app.R;
import com.whombang.app.common.base.BaseActivity;
import com.whombang.app.common.constants.Contents;
import com.whombang.app.common.net.EasyHttp;
import com.whombang.app.common.net.callback.SimpleCallBack;
import com.whombang.app.common.net.exception.ApiException;
import com.whombang.app.common.utils.PreferenceUtil;
import com.whombang.app.common.view.TitleBar;
import com.whombang.app.entity.UserInfoEntity;
import com.whombang.app.entity.UserLocalData;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;

/**
 * 修改昵称（完成）
 */
@Route(path = "/set/name")
public class SetNameActivity extends BaseActivity {
    @BindView(R.id.et_modify_nickname)
    EditText etModifyNickName;

    @Override
    protected int bindLayout() {
        return R.layout.wb_set_name_layout;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    public void initData(Bundle bundle) {
    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        titleBar.setTitle("设置昵称");
        titleBar.setLeftText("取消");
        titleBar.addAction(new TitleBar.TextAction("完成") {
            @Override
            public void performAction(View view) {
                modifyNickname();
            }
        });

    }

    private void modifyNickname() {
        final Map<String, Object> params = new HashMap<>();
        params.put("userId", UserLocalData.getUserInfo(mContext).getUserInfo().getUserId());
        params.put("nickName", etModifyNickName.getText().toString());

        EasyHttp.post("changeUserNickName")
                .upJson(new JSONObject(params).toString())
                .execute(new SimpleCallBack<UserInfoEntity>() {

                    @Override
                    public void onError(ApiException e) {
                        Toast.makeText(mContext, e.getMessage(), Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onSuccess(UserInfoEntity entity) {
                        //保存用户信息
                        UserLocalData.putUser(mActivity, entity);
                        setResult(Activity.RESULT_OK);
                        finish();
                    }
                });
    }

    @Override
    public void doBusiness() {

    }
}
