package com.whombang.app.features.mycenter.fragment;


import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.whombang.app.R;
import com.whombang.app.adapter.GroudBookAdapter;
import com.whombang.app.common.base.LazyFragment;
import com.whombang.app.common.net.EasyHttp;
import com.whombang.app.common.net.callback.SimpleCallBack;
import com.whombang.app.common.net.exception.ApiException;
import com.whombang.app.entity.GroudBookEntity;
import com.whombang.app.entity.UserLocalData;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static android.support.v7.widget.DividerItemDecoration.VERTICAL;

/**
 * 我的拼团：已完成
 */
public class GoodsFinishFragment extends LazyFragment implements OnRefreshListener, OnLoadmoreListener {
    RecyclerView mRecyclerView;
    RefreshLayout mRefreshLayout;
    GroudBookAdapter adapter;
    private int pageNum = 1;

    @Override
    protected void onCreateViewLazy(Bundle savedInstanceState) {
        super.onCreateViewLazy(savedInstanceState);
        setContentView(R.layout.wb_goods_finish_layout);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRefreshLayout = (RefreshLayout) findViewById(R.id.refreshLayout);
        adapter = new GroudBookAdapter();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(context, VERTICAL));
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
        params.put("userId", UserLocalData.getUserInfo(context).getUserInfo().getUserId());
        params.put("goodOrderStatus", 3);
        params.put("pageSize", 20);
        params.put("currentPageNum", pageNum);//

        EasyHttp.post("getGoodsListByUser")
                .upJson(new JSONObject(params).toString())
                .execute(new SimpleCallBack<GroudBookEntity>() {

                    @Override
                    public void onError(ApiException e) {
                        Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
                        mRefreshLayout.finishRefresh();
                    }

                    @Override
                    public void onSuccess(GroudBookEntity entity) {
                        adapter.setNewData(entity.getGoodsInfoList());
                        mRefreshLayout.finishRefresh();
                        pageNum++;
                    }
                });
    }

    private void requestNetMoreData() {
        final Map<String, Object> params = new HashMap<>();
        params.put("userId", UserLocalData.getUserInfo(context).getUserInfo().getUserId());
        params.put("goodOrderStatus", 3);
        params.put("pageSize", 20);
        params.put("currentPageNum", pageNum);//

        EasyHttp.post("getGoodsListByUser")
                .upJson(new JSONObject(params).toString())
                .execute(new SimpleCallBack<GroudBookEntity>() {

                    @Override
                    public void onError(ApiException e) {
                        Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
                        mRefreshLayout.finishLoadmore();
                    }

                    @Override
                    public void onSuccess(GroudBookEntity entity) {
                        adapter.addData(entity.getGoodsInfoList());
                        mRefreshLayout.finishLoadmore();
                        pageNum++;
                    }
                });
    }
}
