package com.whombang.app.features.mycenter.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.whombang.app.R;
import com.whombang.app.common.base.LazyFragment;

import butterknife.BindView;

/**
 * 我的拼团：全部商品列表
 */
public class GoodsListFragment extends LazyFragment implements OnRefreshListener,OnLoadmoreListener {
    RecyclerView mRecyclerView;
    RefreshLayout mRefreshLayout;
    private int pageNum=1;
    @Override
    protected void onCreateViewLazy(Bundle savedInstanceState) {
        super.onCreateViewLazy(savedInstanceState);
        setContentView(R.layout.wb_goods_list_layout);
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
