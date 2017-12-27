package com.whombang.app.features.mycenter.activity;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.whombang.app.R;
import com.whombang.app.adapter.ServerInfoAdapter;
import com.whombang.app.common.base.BaseActivity;
import com.whombang.app.entity.ServiceInfoEntity;
import com.whombang.app.mvp.component.DaggerServerInfoComponent;
import com.whombang.app.mvp.module.ServerInfoModule;
import com.whombang.app.mvp.presenter.ServerInfoPresenter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

import static android.support.v7.widget.DividerItemDecoration.VERTICAL;

/**
 * 服务者列表
 */
@Route(path = "/my/info")
public class ServerInfoActivity extends BaseActivity implements OnRefreshListener, OnLoadmoreListener {
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.refreshLayout)
    public RefreshLayout mRefreshLayout;
    private ServerInfoAdapter adapter;
    @Inject
    ServerInfoPresenter presenter;

    @Override
    protected int bindLayout() {
        return R.layout.wb_server_info_layout;
    }

    @Override
    protected void initInjector() {
        DaggerServerInfoComponent.builder().serverInfoModule(new ServerInfoModule(this)).build().inject(this);
    }

    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        titleBar.setTitle("服务提供者信息列表");
        initRecyclerView();
        initRefreshView();
    }

    private void initRecyclerView() {
        adapter = new ServerInfoAdapter();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, VERTICAL));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(adapter);
    }

    private void initRefreshView() {
        mRefreshLayout.autoRefresh();
        mRefreshLayout.setOnRefreshListener(this);
        mRefreshLayout.setOnLoadmoreListener(this);

    }

    @Override
    public void doBusiness() {

    }

    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {
        presenter.requestNetMoreData();
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        presenter.requestNetData();
    }

    public void requestNetData(List<ServiceInfoEntity.ProviderUserInfoListBean> listBeans) {
        adapter.setNewData(listBeans);

    }

    public void requestNetMoreData(List<ServiceInfoEntity.ProviderUserInfoListBean> listBeans) {
        adapter.addData(listBeans);
    }
}
