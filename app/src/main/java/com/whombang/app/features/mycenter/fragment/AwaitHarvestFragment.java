package com.whombang.app.features.mycenter.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.alibaba.android.arouter.launcher.ARouter;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.whombang.app.R;
import com.whombang.app.adapter.GroudBookAdapter;
import com.whombang.app.common.base.BaseFragment;
import com.whombang.app.common.base.LazyFragment;
import com.whombang.app.common.baseadapter.BaseQuickAdapter;
import com.whombang.app.common.constants.Contents;
import com.whombang.app.common.net.EasyHttp;
import com.whombang.app.common.net.callback.SimpleCallBack;
import com.whombang.app.common.net.exception.ApiException;
import com.whombang.app.entity.GroudBookEntity;
import com.whombang.app.entity.UserLocalData;
import com.whombang.app.features.mycenter.activity.GoodsOrderDetailsActivity;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;

import static android.support.v7.widget.DividerItemDecoration.VERTICAL;

/**
 * 我的拼团：等待收货
 */
public class AwaitHarvestFragment extends LazyFragment implements OnRefreshListener, OnLoadmoreListener ,BaseQuickAdapter.OnItemClickListener{
    RecyclerView mRecyclerView;
    RefreshLayout mRefreshLayout;
    GroudBookAdapter adapter;
    private int pageNum = 1;

    @Override
    protected void onCreateViewLazy(Bundle savedInstanceState) {
        super.onCreateViewLazy(savedInstanceState);
        setContentView(R.layout.wb_await_harvest_layout);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRefreshLayout = (RefreshLayout) findViewById(R.id.refreshLayout);

        adapter = new GroudBookAdapter();
        adapter.setOnItemClickListener(this);
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
        params.put("goodOrderStatus", 2);
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
        params.put("goodOrderStatus", 2);
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

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        GroudBookEntity.GoodsInfoListBean item= (GroudBookEntity.GoodsInfoListBean) adapter.getData().get(position);
        Bundle bundle=new Bundle();
        bundle.putInt("tag",1);
        bundle.putString("goodsGroupSellOrderId",item.getGoodsSellOrderId());
        Intent intent=new Intent(getActivity(), GoodsOrderDetailsActivity.class);
        intent.putExtras(bundle);
        startActivityForResult(intent, Contents.REQUEST_STATION_GOODS,bundle);
       // ARouter.getInstance().build("/order/details").withInt("tag",1).withString("goodsGroupSellOrderId", item.getGoodsSellOrderId()).navigation(getActivity(), Contents.REQUEST_STATION_GOODS);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Contents.REQUEST_STATION_GOODS) {
            mRefreshLayout.autoRefresh();
        }

    }
}
