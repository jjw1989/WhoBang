package com.whombang.app.features.mycenter.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.whombang.app.R;
import com.whombang.app.common.base.BaseFragment;
import com.whombang.app.common.base.LazyFragment;
import com.whombang.app.common.net.EasyHttp;
import com.whombang.app.common.net.callback.SimpleCallBack;
import com.whombang.app.common.net.exception.ApiException;
import com.whombang.app.entity.UserLocalData;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;

/**
 * 我的拼团：已完成
 */
public class GoodsFinishFragment extends LazyFragment implements OnRefreshListener,OnLoadmoreListener {
    RecyclerView mRecyclerView;
    RefreshLayout mRefreshLayout;
    private int pageNum=1;
    @Override
    protected void onCreateViewLazy(Bundle savedInstanceState) {
        super.onCreateViewLazy(savedInstanceState);
        setContentView(R.layout.wb_goods_finish_layout);
        mRecyclerView= (RecyclerView) findViewById(R.id.recyclerView);
        mRefreshLayout= (RefreshLayout) findViewById(R.id.refreshLayout);
        initRefreshView();
    }
    private void initRefreshView() {
        mRefreshLayout.autoRefresh();
        mRefreshLayout.setOnRefreshListener(this);
        mRefreshLayout.setOnLoadmoreListener(this);

    }


    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {

    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {

    }
}
