package com.whombang.app.features.mycenter.activity;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.whombang.app.R;
import com.whombang.app.common.base.BaseActivity;
import com.whombang.app.common.net.EasyHttp;
import com.whombang.app.common.net.callback.SimpleCallBack;
import com.whombang.app.common.net.exception.ApiException;
import com.whombang.app.common.tabGround.OneTagLabel;
import com.whombang.app.common.tabGround.TagBean;
import com.whombang.app.common.tabGround.TagContainerLayout;
import com.whombang.app.common.tabGround.TagFactory;
import com.whombang.app.common.tabGround.TagView;
import com.whombang.app.common.view.TitleBar;
import com.whombang.app.entity.UserLocalData;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

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
    TagContainerLayout tagSetviceType;
    private TagContainerLayout.ViewColor mBanViewColor;
    private TagContainerLayout.ViewColor mDefaultViewColor;
    private TagContainerLayout.ViewColor mClickViewColor;
    private TagFactory tagFactory;

    @Override
    public void initData(Bundle bundle) {
        mBanViewColor = new TagContainerLayout.ViewColor();
        mDefaultViewColor = new TagContainerLayout.ViewColor(ContextCompat.getColor(this, R.color.backGroundColor), 0, ContextCompat.getColor(this, R.color.textColor));
        mClickViewColor = new TagContainerLayout.ViewColor(ContextCompat.getColor(this, R.color.orange1), 0, ContextCompat.getColor(this, R.color.clickTextColor));
        initTagData();
    }

    /**
     * 初始化标签数据
     */
    private void initTagData() {
        mTagBean = new ArrayList<>();
        mTagBean.add(new TagBean("家政", 222, 1000));
        mTagBean.add(new TagBean("保洁", 10, 1));
        mTagBean.add(new TagBean("法律咨询", 20, 555));
        mTagBean.add(new TagBean("维修", 30, 1));
        mTagBean.add(new TagBean("其他", 40, 300));
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
        List<String> titles = new ArrayList<String>();
        for (TagBean tagBean : mTagBean) {
            titles.add(tagBean.getTitle());
        }
        tagSetviceType.setTitles(titles);
        tagFactory = new OneTagLabel(mTagBean, tagSetviceType.getAllChildViews(), mBanViewColor, mDefaultViewColor, mClickViewColor);
        tagSetviceType.setOnTagClickListener(new TagView.OnTagClickListener() {
            @Override
            public void onTagClick(TagView view, int position, String text) {
                tagFactory.onColorTagClick(position);
            }

            @Override
            public void onTagLongClick(int position, String text) {

            }

            @Override
            public void onTagCrossClick(int position) {

            }
        });
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
                        Toast.makeText(mContext, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onSuccess(String entity) {
                        Log.i("www", "data=" + entity);
                    }
                });
    }

    @Override
    public void doBusiness() {

    }
}
