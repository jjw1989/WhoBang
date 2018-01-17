package com.whombang.app.features.home.fragment;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.launcher.ARouter;
import com.alibaba.fastjson.JSON;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.whombang.app.R;
import com.whombang.app.adapter.HomeMultipleRecycleAdapter;
import com.whombang.app.common.base.BaseFragment;
import com.whombang.app.common.baseadapter.BaseQuickAdapter;
import com.whombang.app.common.net.EasyHttp;
import com.whombang.app.common.net.callback.SimpleCallBack;
import com.whombang.app.common.net.exception.ApiException;
import com.whombang.app.entity.GoodsEntity;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.Permission;
import com.yanzhenjie.permission.PermissionListener;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

import static android.support.v7.widget.DividerItemDecoration.VERTICAL;

/**
 * HomeFragment
 * 首页
 */
public class HomeFragment extends BaseFragment implements OnRefreshListener, OnLoadmoreListener,AMapLocationListener {
    private static final int REQUEST_CODE_PERMISSION_MULTI = 101;
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.refreshLayout)
    RefreshLayout mRefreshLayout;
    @BindView(R.id.tv_location_address)
    TextView tvAddress;
    HomeMultipleRecycleAdapter adapter;
    private int pageNum = 1;
    private AMapLocationClient mlocationClient = null;
    private AMapLocationClientOption mLocationOption = null;
    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return R.layout.wb_home_fgt_layout;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        adapter = new HomeMultipleRecycleAdapter();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(mActivity, VERTICAL));
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
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                GoodsEntity.DataBean item= (GoodsEntity.DataBean) adapter.getData().get(position);
                ARouter.getInstance().build("/shop/details").withInt("goodsSellId", item.itemContentList.get(0).goodsSellId).navigation(mActivity);
            }
        });
        requestPermission();
    }
    /**
     * 请求权限
     */
    private void requestPermission() {
        AndPermission.with(this)
                .requestCode(REQUEST_CODE_PERMISSION_MULTI)
                .permission(Permission.LOCATION)
                .callback(listener)
                .start();

    }
    private PermissionListener listener = new PermissionListener() {
        @Override
        public void onSucceed(int requestCode, List<String> grantedPermissions) {
            // Successfully.
            if(requestCode == REQUEST_CODE_PERMISSION_MULTI) {
                locationPosition();
            }
        }

        @Override
        public void onFailed(int requestCode, List<String> deniedPermissions) {
            // Failure.
            if(requestCode == REQUEST_CODE_PERMISSION_MULTI) {

            }
        }
    };

    public void locationPosition() {
        if (mlocationClient == null) {
            initLocation();
        } else {
            mlocationClient.startLocation();
        }

    }
    /**
     * 获取定位坐标
     */
    public void initLocation() {
        mlocationClient = new AMapLocationClient(mActivity);
        //初始化定位参数
        mLocationOption = new AMapLocationClientOption();
        //设置定位监听
        mlocationClient.setLocationListener(this);
        //设置定位模式为高精度模式，Battery_Saving为低功耗模式，Device_Sensors是仅设备模式
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        //设置定位间隔,单位毫秒,默认为2000ms
        mLocationOption.setInterval(2000);
        //设置是否只定位一次,默认为false
        mLocationOption.setOnceLocation(true);
        //设置setOnceLocationLatest(boolean b)接口为true，启动定位时SDK会返回最近3s内精度最高的一次定位结果。
        //如果设置其为true，setOnceLocation(boolean b)接口也会被设置为true，反之不会。
        mLocationOption.setOnceLocationLatest(true);
        //设置定位参数
        mlocationClient.setLocationOption(mLocationOption);
        // 此方法为每隔固定时间会发起一次定位请求，为了减少电量消耗或网络流量消耗，
        // 注意设置合适的定位时间的间隔（最小间隔支持为2000ms），并且在合适时间调用stopLocation()方法来取消定位请求
        // 在定位结束后，在合适的生命周期调用onDestroy()方法
        // 在单次定位情况下，定位无论成功与否，都无需调用stopLocation()方法移除请求，定位sdk内部会移除
        //启动定位
        mlocationClient.startLocation();
    }
    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {
        requestNetMoreData();
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        requestNetData();
    }

    /**
     * 请求网络数据
     */
    private void requestNetData() {
        pageNum = 1;
        final Map<String, Object> params = new HashMap<>();
        params.put("pageSize", 20);
        params.put("currentPageNum", pageNum);

        EasyHttp.post("goodsListNew")
                .upJson(new JSONObject(params).toString())
                .execute(new SimpleCallBack<String>() {

                    @Override
                    public void onError(ApiException e) {
                        Toast.makeText(mActivity, e.getMessage(), Toast.LENGTH_SHORT).show();
                        mRefreshLayout.finishRefresh();
                    }

                    @Override
                    public void onSuccess(String entity) {
                        //数据结构不一样需要特别处理
                        GoodsEntity goodsEntity = JSON.parseObject(entity, GoodsEntity.class);
                        adapter.resetMaxHasLoadPosition();
                        adapter.setNewData(goodsEntity.data);
                        mRefreshLayout.finishRefresh();
                        pageNum++;
                    }
                });
    }

    private void requestNetMoreData() {

        Map<String, Object> params = new HashMap<>();
        params.put("pageSize", 20);
        params.put("currentPageNum", pageNum);

        EasyHttp.post("goodsListNew")
                .upJson(new JSONObject(params).toString())
                .execute(new SimpleCallBack<String>() {

                    @Override
                    public void onError(ApiException e) {
                        Toast.makeText(mActivity, e.getMessage(), Toast.LENGTH_SHORT).show();
                        mRefreshLayout.finishLoadmore();
                    }

                    @Override
                    public void onSuccess(String entity) {
                        //数据结构不一样需要特别处理
                        GoodsEntity goodsEntity = JSON.parseObject(entity, GoodsEntity.class);
                        adapter.addData(goodsEntity.data);
                        mRefreshLayout.finishLoadmore();
                        pageNum++;
                    }
                });
    }

    @Override
    public void onLocationChanged(AMapLocation aMapLocation) {
        if (aMapLocation != null && aMapLocation.getErrorCode() == 0) {
//            Log.i("wwww","城市="+aMapLocation.getCity());
//            Log.i("wwww","唯独="+aMapLocation.getLatitude());
//            Log.i("wwww","精度="+aMapLocation.getLongitude());
//            Log.i("wwww","地址="+aMapLocation.getAddress());

            tvAddress.setText(aMapLocation.getCity());
        }
    }
}
