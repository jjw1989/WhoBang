package com.whombang.app.features.mycenter.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.whombang.app.R;
import com.whombang.app.adapter.OfferServiceAdapter;
import com.whombang.app.common.base.BaseFragment;
import com.whombang.app.common.base.LazyFragment;
import com.whombang.app.common.baseadapter.BaseQuickAdapter;
import com.whombang.app.common.constants.Contents;
import com.whombang.app.common.net.EasyHttp;
import com.whombang.app.common.net.callback.SimpleCallBack;
import com.whombang.app.common.net.exception.ApiException;
import com.whombang.app.entity.OfferServiceEntity;
import com.whombang.app.entity.UserLocalData;
import com.whombang.app.features.mycenter.activity.GoodsOrderDetailsActivity;
import com.whombang.app.features.mycenter.activity.ServiceOrderDetailsActivity;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

import static android.support.v7.widget.DividerItemDecoration.VERTICAL;

/**
 * 公共服务列表：已完成
 */
public class OfferFinishFragment extends LazyFragment implements OnRefreshListener,OnLoadmoreListener,BaseQuickAdapter.OnItemClickListener{
    RecyclerView mRecyclerView;
    RefreshLayout mRefreshLayout;
    private int pageNum=1;
    private OfferServiceAdapter adapter;
    @Override
    protected void onCreateViewLazy(Bundle savedInstanceState) {
        super.onCreateViewLazy(savedInstanceState);
        setContentView(R.layout.wb_offer_finish_layout);
        mRecyclerView= (RecyclerView) findViewById(R.id.recyclerView);
        mRefreshLayout= (RefreshLayout) findViewById(R.id.refreshLayout);
        initView();
    }

    public void initView() {
        adapter=new OfferServiceAdapter();
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
        final Map<String, Object> params = new HashMap<>();
        params.put("inUserId", UserLocalData.getUserInfo(context).getUserInfo().getUserId());
        params.put("orderStatus", 3);
        params.put("pageSize", 20);
        params.put("currentPageNum", pageNum);//

        EasyHttp.post("getProviderUserOrderServiceByStatusList")
                .upJson(new JSONObject(params).toString())
                .execute(new SimpleCallBack<OfferServiceEntity>() {

                    @Override
                    public void onError(ApiException e) {
                        Toast.makeText(context,e.getMessage(),Toast.LENGTH_SHORT).show();
                        mRefreshLayout.finishLoadmore();
                    }

                    @Override
                    public void onSuccess(OfferServiceEntity entity) {
                        adapter.addData(entity.getServiceOrderList());
                        mRefreshLayout.finishLoadmore();
                        pageNum++;
                    }
                });
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        pageNum = 1;
        final Map<String, Object> params = new HashMap<>();
        params.put("inUserId", UserLocalData.getUserInfo(context).getUserInfo().getUserId());
        params.put("orderStatus", 3);
        params.put("pageSize", 20);
        params.put("currentPageNum", 1);//

        EasyHttp.post("getProviderUserOrderServiceByStatusList")
                .upJson(new JSONObject(params).toString())
                .execute(new SimpleCallBack<OfferServiceEntity>() {

                    @Override
                    public void onError(ApiException e) {
                        Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
                        mRefreshLayout.finishLoadmore();
                    }

                    @Override
                    public void onSuccess(OfferServiceEntity entity) {
                        adapter.setNewData(entity.getServiceOrderList());
                        mRefreshLayout.finishRefresh();
                        pageNum++;
                    }
                });
    }


    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        OfferServiceEntity.ServiceOrderListBean item= (OfferServiceEntity.ServiceOrderListBean) adapter.getData().get(position);
        String serviceOrderId=item.getServiceOrderId();
        Bundle bundle=new Bundle();
        bundle.putString("serviceOrderId",serviceOrderId);
        bundle.putString("userId",item.getUserId());
        Intent intent=new Intent(getActivity(), ServiceOrderDetailsActivity.class);
        intent.putExtras(bundle);
        startActivityForResult(intent, Contents.REQUEST_STATION_GOODS,bundle);
        // ARouter.getInstance().build("/myservice/orderdetails").withString("serviceOrderId",serviceOrderId).navigation(mActivity);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Contents.REQUEST_STATION_GOODS) {
            mRefreshLayout.autoRefresh();
        }

    }
}
