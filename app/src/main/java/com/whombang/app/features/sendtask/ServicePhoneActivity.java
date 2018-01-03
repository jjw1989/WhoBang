package com.whombang.app.features.sendtask;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.whombang.app.R;
import com.whombang.app.adapter.ServicePhoneAdapter;
import com.whombang.app.common.base.BaseActivity;
import com.whombang.app.common.baseadapter.BaseQuickAdapter;
import com.whombang.app.common.net.EasyHttp;
import com.whombang.app.common.net.callback.SimpleCallBack;
import com.whombang.app.common.net.exception.ApiException;
import com.whombang.app.entity.ConsigneeEntity;
import com.whombang.app.entity.PhoneEntity;
import com.whombang.app.entity.UserLocalData;
import com.whombang.app.mvp.component.DaggerServicePhoneComponent;
import com.whombang.app.mvp.module.ServicePhoneModule;
import com.whombang.app.mvp.presenter.ServicePhonePresenter;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import butterknife.BindView;

import static android.support.v7.widget.DividerItemDecoration.VERTICAL;

/**
 * 电话服务列表
 */
@Route(path = "/task/phone")
public class ServicePhoneActivity extends BaseActivity implements OnRefreshListener, OnLoadmoreListener, BaseQuickAdapter.OnItemClickListener {
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.refreshLayout)
    RefreshLayout mRefreshLayout;
    private int pageNum = 1;
    ServicePhoneAdapter adapter;
    @Inject
    ServicePhonePresenter presenter;

    @Override
    protected int bindLayout() {
        return R.layout.wb_service_phone_layout;
    }

    @Override
    protected void initInjector() {
        DaggerServicePhoneComponent.builder().servicePhoneModule(new ServicePhoneModule(this)).build().inject(this);
    }

    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        titleBar.setTitle("电话列表");
        adapter = new ServicePhoneAdapter();
        adapter.setOnItemClickListener(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(mActivity, VERTICAL));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(adapter);
        initRefreshView();

    }


    private void initRefreshView() {
        mRefreshLayout.autoRefresh();
        mRefreshLayout.setOnRefreshListener(this);
        mRefreshLayout.setOnLoadmoreListener(this);

    }


    @Override
    public void doBusiness() {

    }

    public void updatePhoneList(List<PhoneEntity.GetProviderUserPhoneInfoListBean> getProviderUserPhoneInfoList) {
        adapter.setNewData(getProviderUserPhoneInfoList);
        mRefreshLayout.finishRefresh();
    }

    public void updateMorePhoneList(List<PhoneEntity.GetProviderUserPhoneInfoListBean> getProviderUserPhoneInfoList) {
        adapter.addData(getProviderUserPhoneInfoList);
        mRefreshLayout.finishLoadmore();
    }

    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {
        pageNum++;
        presenter.requestNetMoreData(pageNum, 20);
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        pageNum = 1;
        presenter.requestNetData(pageNum, 20);
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

    }
}
