package com.whombang.app.features.sendtask;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.EventLog;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.services.core.LatLonSharePoint;
import com.bumptech.glide.Glide;
import com.koushikdutta.ion.Ion;
import com.whombang.amaplibrary.clustering.Cluster;
import com.whombang.amaplibrary.clustering.ClusterItem;
import com.whombang.amaplibrary.clustering.ClusterManager;
import com.whombang.amaplibrary.model.MarkerInfo;
import com.whombang.app.R;
import com.whombang.app.common.base.BaseActivity;
import com.whombang.app.common.net.EasyHttp;
import com.whombang.app.common.net.callback.SimpleCallBack;
import com.whombang.app.common.net.exception.ApiException;
import com.whombang.app.entity.StationEntity;
import com.whombang.app.entity.UserLocalData;
import com.whombang.app.entity.event.EventAddress;
import com.whombang.app.mvp.component.DaggerServicePhoneComponent;
import com.whombang.app.mvp.component.DaggerStationServiceComponent;
import com.whombang.app.mvp.module.ServicePhoneModule;
import com.whombang.app.mvp.module.StationServiceModule;
import com.whombang.app.mvp.presenter.StationServicePresenter;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * 站点显示和选择
 */
@Route(path = "/service/map")
public class StationServiceActivity extends BaseActivity implements AMapLocationListener {
    @BindView(R.id.service_map)
    MapView mapView;
    private AMap aMap;

    private AMapLocationClient mlocationClient;
    private AMapLocationClientOption mLocationOption;

    //自定义定位小蓝点的Marker
    Marker locationMarker;
    @Inject
    StationServicePresenter presenter;

    private List<MarkerInfo> markerInfoList;
    private ClusterManager<MarkerItem> mClusterManager;
    //地图热点和热点列表同时存在的情况下和列表联动的MarkerItemMap
    private Map<Integer, MarkerItem> mMarkerItemMap = new HashMap<>();
    private int mLastClickPosition = -1;

    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return R.layout.wb_station_service_layout;
    }

    @Override
    protected void initInjector() {
        DaggerStationServiceComponent.builder().stationServiceModule(new StationServiceModule(this)).build().inject(this);
    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        titleBar.setTitle("选择站主");
        mapView.onCreate(savedInstanceState);
        initMapView();
        presenter.requestStationInfo();
    }

    private void initMapView() {
        if (aMap == null) {
            aMap = mapView.getMap();
            setUpMap();
        }
    }

    private void setUpMap() {
        // 定义点聚合管理类ClusterManager
        mClusterManager = new ClusterManager<>(mContext, aMap);
        // 设置地图监听，当地图状态发生改变时，进行点聚合运算
        aMap.setOnCameraChangeListener(mClusterManager);
        // 设置maker点击时的响应
        aMap.setOnMarkerClickListener(mClusterManager);
        aMap.getUiSettings().setZoomControlsEnabled(false);
        aMap.getUiSettings().setTiltGesturesEnabled(false);
        aMap.getUiSettings().setRotateGesturesEnabled(false);
    }
    /**
     * 点击开始定位
     */
    @OnClick(R.id.img_position)
    public void locationPosition() {
      Toast.makeText(mContext,"正在定位中....",Toast.LENGTH_SHORT).show();
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
        mlocationClient = new AMapLocationClient(mContext);
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
    public void doBusiness() {
        mClusterManager.setOnClusterClickListener(new ClusterManager.OnClusterClickListener<MarkerItem>() {
            @Override
            public boolean onClusterClick(Cluster<MarkerItem> cluster) {
                ClusterOnClick(cluster);
                return true;
            }
        });
        mClusterManager.setOnClusterItemClickListener(new ClusterManager.OnClusterItemClickListener<MarkerItem>() {
            @Override
            public boolean onClusterItemClick(MarkerItem item) {
                for (Integer getKey : mMarkerItemMap.keySet()) {
                    if (mMarkerItemMap.get(getKey).equals(item)) {
                        mLastClickPosition = getKey;
                        MarkerItem markerItem = mMarkerItemMap.get(mLastClickPosition);
                        break;
                    }
                }
                return false;
            }
        });
        aMap.setInfoWindowAdapter(new AMap.InfoWindowAdapter() {
            @Override
            public View getInfoWindow(final Marker marker) {
                final MarkerItem item = mMarkerItemMap.get(mLastClickPosition);
                View mView = getLayoutInflater().inflate(R.layout.wb_infowindow_layout, null);
                ImageView imgClose = mView.findViewById(R.id.img_close);
                Button btnSwitch = mView.findViewById(R.id.btn_switch);
                TextView tvStationMapName = mView.findViewById(R.id.tv_station_map_name);
                tvStationMapName.setText("站点的名字:" + item.getStationName());
                TextView tvStationMapAddress = mView.findViewById(R.id.tv_station_map_address);
                tvStationMapAddress.setText("站点的详情地址:" + item.getStationAddress());
                TextView tvPhone = mView.findViewById(R.id.tv_station_map_phone);
                tvPhone.setText("站点的电话:" + item.getStationManagerTel());
                btnSwitch.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        EventAddress eventAddress = new EventAddress(item.getStationName(), item.getStationAddress(), item.getStationManagerTel(), item.getStationId());
                        EventBus.getDefault().post(eventAddress);
                        finish();
                    }
                });
                imgClose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        marker.hideInfoWindow();
                    }
                });
                return mView;
            }

            @Override
            public View getInfoContents(Marker marker) {
                return null;
            }
        });
    }

    /**
     * 聚合点击
     */
    private void ClusterOnClick(Cluster<MarkerItem> markerItemCluster) {
        if (aMap == null) {
            return;
        }
        if (markerItemCluster.getItems().size() > 0) {
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            for (MarkerItem markerItem : markerItemCluster.getItems()) {
                builder.include(markerItem.getPosition());
            }
            aMap.animateCamera(CameraUpdateFactory.newLatLngBounds(builder.build(), 15));
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        mapView.onSaveInstanceState(outState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
        if (null != mlocationClient) {
            mlocationClient.onDestroy();
        }
    }

    @Override
    public void onLocationChanged(AMapLocation amapLocation) {
        if (amapLocation != null
                && amapLocation.getErrorCode() == 0) {
            LatLng latLng = new LatLng(amapLocation.getLatitude(), amapLocation.getLongitude());
            //展示自定义定位小蓝点
            if (locationMarker == null) {
                //首次定位
                locationMarker = aMap.addMarker(new MarkerOptions().position(latLng)
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.location_marker))
                        .anchor(0.5f, 0.5f));

                //首次定位,选择移动到地图中心点并修改级别到15级
              //  aMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15));
            }
            aMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15));
        }
    }

    public void refreshStationToMap(List<StationEntity.StationInfoBean> entitys) {
        markerInfoList = new ArrayList<>();
        for (StationEntity.StationInfoBean item : entitys) {
            String iconPath = "http://47.104.105.135:8080/WhomBangServer/static/station/station-icon.png";
            MarkerInfo markerInfo = new MarkerInfo();
            markerInfo.setMarkerIcon(iconPath);
            markerInfo.setMarkerLat(Double.parseDouble(item.getStationLatitude()));
            markerInfo.setMarkerLon(Double.parseDouble(item.getStationLongitude()));
            markerInfo.setMarkerId(item.getStationId() + "");
            markerInfo.setMarkerName(item.getStationName());
            markerInfo.setStationName(item.getStationManagerName());
            markerInfo.setStationAddress(item.getStationAddress());
            markerInfo.setStationManagerTel(item.getStationManagerTel());
            markerInfo.setStationId(item.getStationId());
            markerInfoList.add(markerInfo);
        }
        List<MarkerItem> markerItemLists = markerItemLogic(markerInfoList);
        mClusterManager.addItems(markerItemLists);
    }

    /**
     * 组装高德需要的item
     */
    private List<MarkerItem> markerItemLogic(List<MarkerInfo> list) {
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        List<MarkerItem> items = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            MarkerInfo markerInfo = list.get(i);
            LatLng latLng = new LatLng(markerInfo.getMarkerLat(), markerInfo.getMarkerLon());
            MarkerItem markerItem = new MarkerItem(latLng);
            markerItem.setMarkerIconUrl(markerInfo.getMarkerIcon());
            markerItem.setTitle(markerInfo.getMarkerName());
            markerItem.setStationName(markerInfo.getStationName());
            markerItem.setStationAddress(markerInfo.getStationAddress());
            markerItem.setStationManagerTel(markerInfo.getStationManagerTel());
            markerItem.setStationId(markerInfo.getStationId());
            items.add(markerItem);
            mMarkerItemMap.put(i, markerItem);
            builder.include(markerItem.getPosition());
        }
        aMap.moveCamera(CameraUpdateFactory.newLatLngBounds(builder.build(), 100));
        return items;
    }

    /**
     * 每个Marker点，包含Marker点坐标以及图标,infowindow数据
     */
    public class MarkerItem implements ClusterItem {
        private final LatLng mPosition;
        private String markerIconUrl;
        private int markerIconResource = -1;
        private float markerIconDefault = 0.0F;
        private String title;
        private String snippet;
        private String stationName;
        private String stationAddress;
        private String stationManagerTel;
        private int stationId;

        public MarkerItem(LatLng latLng) {
            mPosition = latLng;
        }

        public void setMarkerIconUrl(String markerIconUrl) {
            this.markerIconUrl = markerIconUrl;
        }

        public void setMarkerIconResource(int markerIconResource) {
            this.markerIconResource = markerIconResource;
        }

        public void setMarkerIconDefault(float markerIconDefault) {
            this.markerIconDefault = markerIconDefault;
        }


        public void setTitle(String title) {
            this.title = title;
        }

        public void setSnippet(String snippet) {
            this.snippet = snippet;
        }

        public String getStationName() {
            return stationName;
        }

        public void setStationName(String stationName) {
            this.stationName = stationName;
        }

        public String getStationAddress() {
            return stationAddress;
        }

        public void setStationAddress(String stationAddress) {
            this.stationAddress = stationAddress;
        }

        public String getStationManagerTel() {
            return stationManagerTel;
        }

        public void setStationManagerTel(String stationManagerTel) {
            this.stationManagerTel = stationManagerTel;
        }

        public int getStationId() {
            return stationId;
        }

        public void setStationId(int stationId) {
            this.stationId = stationId;
        }

        @Override
        public LatLng getPosition() {
            return mPosition;
        }

        @Override
        public BitmapDescriptor getBitmapDescriptor() {
            if (markerIconUrl != null) {
                try {
                    return BitmapDescriptorFactory.fromBitmap(Ion.with(mContext)
                            .load(markerIconUrl).asBitmap().get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            } else if (markerIconResource != -1) {
                return BitmapDescriptorFactory
                        .fromResource(markerIconResource);
            }
            return BitmapDescriptorFactory
                    .defaultMarker(markerIconDefault);
        }

        @Override
        public String getTitle() {
            return title;
        }

        @Override
        public String getSnippet() {
            return snippet;
        }
    }

}
