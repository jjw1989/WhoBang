package com.whombang.app.features.mycenter.fragment;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.whombang.app.R;
import com.whombang.app.adapter.AwaitServiceAdapter;
import com.whombang.app.common.base.BaseFragment;
import com.whombang.app.common.base.IBasePresenter;
import com.whombang.app.common.base.ILoadDataView;
import com.whombang.app.common.baseadapter.BaseQuickAdapter;
import com.whombang.app.common.net.EasyHttp;
import com.whombang.app.common.net.callback.SimpleCallBack;
import com.whombang.app.common.net.exception.ApiException;
import com.whombang.app.common.view.WBHeaderView;
import com.whombang.app.entity.MyServiceEntity;
import com.whombang.app.entity.UserLocalData;

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

import butterknife.BindView;

import static android.support.v7.widget.DividerItemDecoration.VERTICAL;

/**
 * 等待服务
 */
public class AwaitServiceFragment extends BaseFragment implements OnRefreshListener,OnLoadmoreListener,BaseQuickAdapter.OnItemClickListener{
   @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.refreshLayout)
    RefreshLayout mRefreshLayout;
    private int pageNum=1;
    private AwaitServiceAdapter adapter;
    @Override
    protected int bindLayout() {
        return R.layout.wb_await_service_layout;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        adapter=new AwaitServiceAdapter();
        adapter.setOnItemClickListener(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(mActivity, VERTICAL));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(adapter);
        initRefreshView();

    }

    private List<MyServiceEntity.ServiceOrderListBean> getData() {
        List<MyServiceEntity.ServiceOrderListBean> list=new ArrayList<>();

        for (int i = 0; i <30 ; i++) {
            MyServiceEntity.ServiceOrderListBean bean=new MyServiceEntity.ServiceOrderListBean();
            list.add(bean);
        }
        return list;
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
    public void onRefresh(RefreshLayout refreshlayout) {
        pageNum=1;
        final Map<String, Object> params = new HashMap<>();
        params.put("userId", UserLocalData.getUserInfo(mActivity).getUserInfo().getUserId());
        params.put("orderStatus","1");
        params.put("pageSize", 20);
        params.put("currentPageNum", pageNum);//

        EasyHttp.post("getUserOrderServiceList")
                .upJson(new JSONObject(params).toString())
                .execute(new SimpleCallBack<MyServiceEntity>() {

                    @Override
                    public void onError(ApiException e) {
                        Toast.makeText(mActivity,e.getMessage(),Toast.LENGTH_SHORT).show();
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
        params.put("userId", UserLocalData.getUserInfo(mActivity).getUserInfo().getUserId());
        params.put("orderStatus","1");
        params.put("pageSize", 20);
        params.put("currentPageNum", pageNum);//
        EasyHttp.post("getUserOrderServiceList")
                .upJson(new JSONObject(params).toString())
                .execute(new SimpleCallBack<MyServiceEntity>() {

                    @Override
                    public void onError(ApiException e) {
                        Toast.makeText(mActivity,e.getMessage(),Toast.LENGTH_SHORT).show();
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

    }
}
