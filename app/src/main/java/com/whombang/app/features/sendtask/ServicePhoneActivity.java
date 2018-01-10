package com.whombang.app.features.sendtask;

import android.content.Intent;
import android.net.Uri;
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
import com.whombang.app.adapter.ServicePhoneAdapter;
import com.whombang.app.common.base.BaseActivity;
import com.whombang.app.common.baseadapter.BaseQuickAdapter;
import com.whombang.app.entity.PhoneEntity;
import com.whombang.app.mvp.component.DaggerServicePhoneComponent;
import com.whombang.app.mvp.module.ServicePhoneModule;
import com.whombang.app.mvp.presenter.ServicePhonePresenter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

import static android.support.v7.widget.DividerItemDecoration.VERTICAL;

/**
 * 电话服务列表(完成)
 */
@Route(path = "/task/phone")
public class ServicePhoneActivity extends BaseActivity implements OnRefreshListener, OnLoadmoreListener, BaseQuickAdapter.OnItemClickListener {
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.refreshLayout)
  public   RefreshLayout mRefreshLayout;
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
        initRecyclerView();
        initRefreshView();

    }

    private void initRecyclerView() {
        adapter = new ServicePhoneAdapter();
        adapter.setOnItemClickListener(this);
        View view = getLayoutInflater().inflate(R.layout.wb_phone_list_head_layout, null);
        adapter.addHeaderView(view);
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
        presenter.requestNetMoreData(20, pageNum);
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        pageNum = 1;
        presenter.requestNetData(20, pageNum);
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        PhoneEntity.GetProviderUserPhoneInfoListBean item= (PhoneEntity.GetProviderUserPhoneInfoListBean) adapter.getData().get(position);
        Intent intent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:"+item.getPhone()));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
