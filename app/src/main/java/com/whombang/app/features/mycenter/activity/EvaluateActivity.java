package com.whombang.app.features.mycenter.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.whombang.app.R;
import com.whombang.app.common.base.BaseActivity;
import com.whombang.app.common.entity.BaseEntity;
import com.whombang.app.common.net.EasyHttp;
import com.whombang.app.common.net.callback.SimpleCallBack;
import com.whombang.app.common.net.exception.ApiException;
import com.whombang.app.common.view.TitleBar;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;

/**
 * 评价
 */
@Route(path = "/server/evalute")
public class EvaluateActivity extends BaseActivity {
@BindView(R.id.et_content)
    EditText etContent;
    String userId;
    String serviceOrderId;
    @Override
    protected int bindLayout() {
        return R.layout.wb_evaluate_layout;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    public void initData(Bundle bundle) {
          userId=bundle.getString("userId","");
          serviceOrderId=bundle.getString("serviceOrderId","");
    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
      titleBar.setTitle("评价");
      titleBar.addAction(new TitleBar.TextAction("完成") {
          @Override
          public void performAction(View view) {
              if (!TextUtils.isEmpty(etContent.getText().toString())) {
                  addEvaluate();
              }else{
                  Toast.makeText(mContext,"内容不能为空",Toast.LENGTH_SHORT).show();
              }
          }
      });

    }

   private void addEvaluate(){
       final Map<String, Object> params = new HashMap<>();
       params.put("userId",userId);
       params.put("serviceOrderId", serviceOrderId);
       params.put("evaluationContent ", etContent.getText().toString());
       EasyHttp.post("addServiceOrderEvaluationInfo")
               .upJson(new JSONObject(params).toString())
               .execute(new SimpleCallBack<BaseEntity>() {

                   @Override
                   public void onError(ApiException e) {
                       Toast.makeText(mActivity, e.getMessage(), Toast.LENGTH_SHORT).show();

                   }

                   @Override
                   public void onSuccess(BaseEntity entity) {
                       finish();
                   }
               });
    }
    @Override
    public void doBusiness() {

    }
}
