package com.whombang.app.features.mycenter.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.whombang.app.R;
import com.whombang.app.common.base.BaseActivity;
import com.whombang.app.common.net.EasyHttp;
import com.whombang.app.common.net.callback.SimpleCallBack;
import com.whombang.app.common.net.exception.ApiException;
import com.whombang.app.common.tabGround.TagBean;
import com.whombang.app.common.tabGround.TagContainerLayout;
import com.whombang.app.common.view.TitleBar;
import com.whombang.app.entity.UserLocalData;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Observer;

/**
 * 添加服务者
 */
@Route(path = "/my/server")
public class AddServerActivity extends BaseActivity {
    /**
     * 标签集合
     */
    private List<TagBean> mTagBean;
    @BindView(R.id.tag_service_type)
    TagContainerLayout  tagSetviceType;
    @Override
    public void initData(Bundle bundle) {
         initTagData();
    }

    /**
     * 初始化标签数据
     */
    private void initTagData() {
       mTagBean=new ArrayList<>();
       TagBean tagBean1=new TagBean();
       tagBean1.setTitle("家政");
       TagBean tagBean2=new TagBean();
       tagBean2.setTitle("保洁");
       TagBean tagBean3=new TagBean();
       tagBean3.setTitle("法律咨询");
       TagBean tagBean4=new TagBean();
       tagBean4.setTitle("维修");
       TagBean tagBean5=new TagBean();
       tagBean5.setTitle("其他");
       mTagBean.add(tagBean1);
       mTagBean.add(tagBean2);
       mTagBean.add(tagBean3);
       mTagBean.add(tagBean4);
       mTagBean.add(tagBean5);
    }

    @Override
    public int bindLayout() {
        return R.layout.wb_my_order_layout;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        titleBar.setTitle("添加服务者");
        titleBar.addAction(new TitleBar.TextAction("添加") {
            @Override
            public void performAction(View view) {
                addServer();
            }
        });
        initTagView();
    }

    /**
     * 初始化标签控件
     */
    private void initTagView() {

    }

    /**
     * 添加服务者
     */
    private void addServer() {
        Map<String, Object> params = new HashMap<>();
        params.put("userId", UserLocalData.getUserInfo(this).getUserInfo().getUserId());
        params.put("stationId", UserLocalData.getUserInfo(this).getStationInfo().getStationId());
        params.put("individuationServiceDesc", "");
        params.put("contact", UserLocalData.getUserInfo(this).getUserInfo().getUserTel());
        params.put("userInvitationUserId", UserLocalData.getUserInfo(this).getStationManagerInfo().getStationId());
        params.put("type", 3);
        params.put("longitude", "114.00000");
        params.put("latitude", "32.000000");
        params.put("currentLocation", "中国");
        params.put("demanderName", "张三");

        EasyHttp.post("startAService")
                .upJson(new JSONObject(params).toString())
                .execute(new SimpleCallBack<String>() {

                    @Override
                    public void onError(ApiException e) {
                        Toast.makeText(mContext,e.getMessage(),Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onSuccess(String entity) {
                        Log.i("www","data="+entity);
                    }
                });
    }

    @Override
    public void doBusiness() {

    }
}
