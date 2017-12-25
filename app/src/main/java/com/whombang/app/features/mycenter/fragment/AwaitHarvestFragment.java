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
 * 我的拼团：等待收货
 */
public class AwaitHarvestFragment extends LazyFragment implements OnRefreshListener,OnLoadmoreListener {
    RecyclerView mRecyclerView;
    RefreshLayout mRefreshLayout;
    private int pageNum=1;
    @Override
    protected void onCreateViewLazy(Bundle savedInstanceState) {
        super.onCreateViewLazy(savedInstanceState);
        setContentView(R.layout.wb_await_harvest_layout);
        mRecyclerView= (RecyclerView) findViewById(R.id.recyclerView);
        mRefreshLayout= (RefreshLayout) findViewById(R.id.refreshLayout);
        initRefreshView();
        requestNetData();
    }

    private void requestNetData() {
        final Map<String, Object> params = new HashMap<>();
        params.put("userId", UserLocalData.getUserInfo(context).getUserInfo().getUserId());
        params.put("orderStatus",2);
        params.put("pageSize", 20);
        params.put("currentPageNum", pageNum);//

        EasyHttp.post("getGoodsListByUser")
                .upJson(new JSONObject(params).toString())
                .execute(new SimpleCallBack<String>() {

                    @Override
                    public void onError(ApiException e) {
                        Toast.makeText(context,e.getMessage(),Toast.LENGTH_SHORT).show();
                        mRefreshLayout.finishRefresh();
                    }

                    @Override
                    public void onSuccess(String entity) {
                        Log.i("wwww","entity="+entity);
                        mRefreshLayout.finishRefresh();
                        pageNum++;
                    }
                });
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
