package com.whombang.app.features.mycenter.fragment;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.arouter.launcher.ARouter;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.whombang.app.R;
import com.whombang.app.adapter.AwaitServiceAdapter;
import com.whombang.app.common.base.BaseFragment;
import com.whombang.app.common.base.LazyFragment;
import com.whombang.app.common.baseadapter.BaseQuickAdapter;
import com.whombang.app.common.net.EasyHttp;
import com.whombang.app.common.net.callback.SimpleCallBack;
import com.whombang.app.common.net.exception.ApiException;
import com.whombang.app.entity.MyServiceEntity;
import com.whombang.app.entity.UserLocalData;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static android.support.v7.widget.DividerItemDecoration.VERTICAL;

/**
 * 我的服务：已完成
 */
public class FinishFragment extends LazyFragment implements OnRefreshListener,OnLoadmoreListener,BaseQuickAdapter.OnItemClickListener{
    RecyclerView mRecyclerView;
    RefreshLayout mRefreshLayout;
    private int pageNum=1;
    private AwaitServiceAdapter adapter;


    @Override
    protected void onCreateViewLazy(Bundle savedInstanceState) {
        super.onCreateViewLazy(savedInstanceState);
        setContentView(R.layout.wb_finish_layout);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRefreshLayout = (RefreshLayout) findViewById(R.id.refreshLayout);

        adapter = new AwaitServiceAdapter();
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
    public void onRefresh(RefreshLayout refreshlayout) {
        pageNum=1;
        final Map<String, Object> params = new HashMap<>();
        params.put("userId", UserLocalData.getUserInfo(context).getUserInfo().getUserId());
        params.put("orderStatus",3);
        params.put("pageSize", 20);
        params.put("currentPageNum", pageNum);//

        EasyHttp.post("getUserOrderServiceList")
                .upJson(new JSONObject(params).toString())
                .execute(new SimpleCallBack<MyServiceEntity>() {

                    @Override
                    public void onError(ApiException e) {
                        Toast.makeText(context,e.getMessage(),Toast.LENGTH_SHORT).show();
                        mRefreshLayout.finishRefresh();
                    }

                    @Override
                    public void onSuccess(MyServiceEntity entity) {
                        //adapter.addData(entity.getServiceOrderList());
                        adapter.setNewData(entity.getServiceOrderList());
                        mRefreshLayout.finishRefresh();
                        pageNum++;
                    }
                });
    }

    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {
        final Map<String, Object> params = new HashMap<>();
        params.put("userId", UserLocalData.getUserInfo(context).getUserInfo().getUserId());
        params.put("orderStatus",3);
        params.put("pageSize", 20);
        params.put("currentPageNum", pageNum);//
        EasyHttp.post("getUserOrderServiceList")
                .upJson(new JSONObject(params).toString())
                .execute(new SimpleCallBack<MyServiceEntity>() {

                    @Override
                    public void onError(ApiException e) {
                        Toast.makeText(context,e.getMessage(),Toast.LENGTH_SHORT).show();
                        mRefreshLayout.finishLoadmore();
                    }

                    @Override
                    public void onSuccess(MyServiceEntity entity) {
                        adapter.addData(entity.getServiceOrderList());
                        mRefreshLayout.finishLoadmore();
                        pageNum++;
                    }
                });
    }


    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        MyServiceEntity.ServiceOrderListBean item= (MyServiceEntity.ServiceOrderListBean) adapter.getData().get(position);
        ARouter.getInstance().build("/myservice/orderdetails").withString("serviceOrderId",item.getServiceOrderId()).withString("userId",item.getUserId()).navigation();
    }
}
