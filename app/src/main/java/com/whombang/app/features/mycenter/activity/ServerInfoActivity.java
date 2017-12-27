package com.whombang.app.features.mycenter.activity;

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
import com.whombang.app.adapter.AwaitServiceAdapter;
import com.whombang.app.adapter.GroudBookAdapter;
import com.whombang.app.adapter.ServerInfoAdapter;
import com.whombang.app.common.base.BaseActivity;
import com.whombang.app.common.net.EasyHttp;
import com.whombang.app.common.net.callback.SimpleCallBack;
import com.whombang.app.common.net.exception.ApiException;
import com.whombang.app.entity.ServiceEntity;
import com.whombang.app.entity.ServiceInfoEntity;
import com.whombang.app.entity.UserLocalData;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

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
    RefreshLayout mRefreshLayout;
    private int pageNum = 1;
    private ServerInfoAdapter adapter;

    @Override
    protected int bindLayout() {
        return R.layout.wb_server_info_layout;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        titleBar.setTitle("服务提供者信息列表");
        adapter = new ServerInfoAdapter();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, VERTICAL));
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

    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {
        requestNetMoreData();
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        requestNetData();
    }

    private void requestNetData() {
        pageNum = 1;
        final Map<String, Object> params = new HashMap<>();
        params.put("stationId", UserLocalData.getUserInfo(mContext).getStationInfo().getStationId());
        params.put("status", 1);
        params.put("pageSize", 20);
        params.put("currentPageNum", 1);

        EasyHttp.post("getStationProviderUserInfoList")
                .upJson(new JSONObject(params).toString())
                .execute(new SimpleCallBack<ServiceInfoEntity>() {

                    @Override
                    public void onError(ApiException e) {
                        Toast.makeText(mActivity, e.getMessage(), Toast.LENGTH_SHORT).show();
                        mRefreshLayout.finishRefresh();
                    }

                    @Override
                    public void onSuccess(ServiceInfoEntity entity) {
                        adapter.setNewData(entity.getProviderUserInfoList());
                        mRefreshLayout.finishRefresh();
                        pageNum++;
                    }
                });
    }

    private void requestNetMoreData() {
        final Map<String, Object> params = new HashMap<>();
        params.put("stationId", UserLocalData.getUserInfo(mContext).getStationInfo().getStationId());
        params.put("status", 1);
        params.put("pageSize", 20);
        params.put("currentPageNum", pageNum);

        EasyHttp.post("getStationProviderUserInfoList")
                .upJson(new JSONObject(params).toString())
                .execute(new SimpleCallBack<ServiceInfoEntity>() {

                    @Override
                    public void onError(ApiException e) {
                        Toast.makeText(mActivity, e.getMessage(), Toast.LENGTH_SHORT).show();
                        mRefreshLayout.finishLoadmore();
                    }

                    @Override
                    public void onSuccess(ServiceInfoEntity entity) {
                        adapter.addData(entity.getProviderUserInfoList());
                        mRefreshLayout.finishLoadmore();
                        pageNum++;
                    }
                });
    }
}
