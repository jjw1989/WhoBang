package com.whombang.app.features.home.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.whombang.app.R;
import com.whombang.app.common.base.BaseActivity;
import com.whombang.app.common.constants.Contents;
import com.whombang.app.common.net.EasyHttp;
import com.whombang.app.common.net.callback.SimpleCallBack;
import com.whombang.app.common.net.exception.ApiException;
import com.whombang.app.common.view.selectview.AnimShopButton;
import com.whombang.app.common.view.selectview.IOnAddDelListener;
import com.whombang.app.common.view.spinner.NiceSpinner;
import com.whombang.app.entity.DefaultAddressEntity;
import com.whombang.app.entity.GroupingDesEntity;
import com.whombang.app.entity.UserLocalData;

import org.json.JSONObject;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 团购下单
 */
@Route(path = "/shop/order")
public class ShopOrderActivity extends BaseActivity {
    @BindView(R.id.nice_spinner)
    NiceSpinner niceSpinner;
    @BindView(R.id.nice_spinner2)
    NiceSpinner niceSpinner2;
    @BindView(R.id.img_pay_way)
    ImageView imgPayWay;
    @BindView(R.id.tv_pay_way)
    TextView tvPayWay;
    @BindView(R.id.img_present)
    ImageView imgPresent;
    @BindView(R.id.tv_present)
    TextView tvPresent;
    @BindView(R.id.btn_submit)
    Button btnSubmit;
    @BindView(R.id.btnEle)
    AnimShopButton animShopButton;
    String address;
    @BindView(R.id.tv_consignee)
    TextView tvConsignee;
    @BindView(R.id.tv_consignee_address)
    TextView tvConsigneeAddress;
    @BindView(R.id.tv_consignee_phone)
    TextView tvConsigneePhone;

    @BindView(R.id.tv_station_name)
    TextView tvStationName;
    @BindView(R.id.tv_station_address)
    TextView tvStationAddress;
    @BindView(R.id.tv_station_phone)
    TextView tvStationPhone;
    @BindView(R.id.address1)
    RelativeLayout rltAddress;
    @BindView(R.id.no_address)
    RelativeLayout rltNoAddress;
    @BindView(R.id.tv_unit_price)
    TextView tvUnitPrice;
    @BindView(R.id.tv_total_prices)
     TextView tvTotalPrices;
    int goodsGroupSellId;
    double goodsGroupSellPrice;
    int goodsGroupSellOrderAmount;
    int goodsGroupSellOrderDeliverMode;
    String goodsGroupSellReceiverTel = "";
    String goodsGroupSellReceiverAddress = "";
    String goodsGroupSellReceiverName = "";

    @Override
    protected int bindLayout() {
        return R.layout.wb_shoporder_layout;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    public void initData(Bundle bundle) {
        goodsGroupSellId = bundle.getInt("goodsGroupSellId");
        goodsGroupSellPrice = bundle.getDouble("goodsGroupSellPrice");
    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        titleBar.setTitle("确认订单");
        List<String> dataset = new LinkedList<>(Arrays.asList("线下支付", "微信支付", "支付宝", "银联支付"));
        niceSpinner.attachDataSource(dataset);
        List<String> dataset2 = new LinkedList<>(Arrays.asList("站主配送", "到站自提"));
        niceSpinner2.attachDataSource(dataset2);
        requestSellInfo();
        getUserDefaultAddress();
        updateView();
        tvUnitPrice.setText("单价:"+goodsGroupSellPrice);
        tvTotalPrices.setText("总价："+goodsGroupSellPrice);
    }

    @Override
    public void doBusiness() {
        niceSpinner.addOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        imgPayWay.setImageResource(R.mipmap.xianxia);
                        tvPayWay.setText("线下支付");
                        break;
                    case 1:
                        imgPayWay.setImageResource(R.mipmap.wx);
                        tvPayWay.setText("微信支付");
                        break;
                    case 2:
                        imgPayWay.setImageResource(R.mipmap.zfb);
                        tvPayWay.setText("支付宝");
                        break;

                    case 3:
                        imgPayWay.setImageResource(R.mipmap.yinlian);
                        tvPayWay.setText("银联支付");
                        break;
                }
            }
        });
        niceSpinner2.addOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        imgPresent.setImageResource(R.mipmap.peisongdianji);
                        tvPresent.setText("站主配送");
                        goodsGroupSellOrderDeliverMode = 2;
                        break;
                    case 1:
                        imgPresent.setImageResource(R.mipmap.ziquyidianji);
                        tvPresent.setText("到站自提");
                        goodsGroupSellOrderDeliverMode = 1;
                        break;
                }
            }
        });
        animShopButton.setOnAddDelListener(new IOnAddDelListener() {
            @Override
            public void onAddSuccess(int count) {
                goodsGroupSellOrderAmount = count;
                Log.i("qazx", "onAddSuccess: " + goodsGroupSellOrderAmount);
                tvTotalPrices.setText("总价："+goodsGroupSellPrice*goodsGroupSellOrderAmount);
            }

            @Override
            public void onAddFailed(int count, FailType failType) {

            }

            @Override
            public void onDelSuccess(int count) {
                goodsGroupSellOrderAmount = count;
                if (count==0){
                    animShopButton.setCount(1);
                    goodsGroupSellOrderAmount=1;
                }

                Log.i("qazx", "onAddSuccess: " + goodsGroupSellOrderAmount);
                tvTotalPrices.setText("总价："+goodsGroupSellPrice*goodsGroupSellOrderAmount);
            }

            @Override
            public void onDelFaild(int count, FailType failType) {

            }
        });
    }

    @OnClick({R.id.no_address,R.id.address1})
    public void addAddress(View view) {
        switch (view.getId()){
            case R.id.no_address:
                ARouter.getInstance().build("/address/newly").withBoolean("isEdite", false).withBoolean("isDefault",true).navigation(mActivity, Contents.REQUEST_CONSIGNEE_ADR);
                break;
            case R.id.address1:
                ARouter.getInstance().build("/address/manager").navigation(mActivity, Contents.REQUEST_CONSIGNEE_ADR);
                break;
        }

    }

    @OnClick(R.id.address2)
    public void jumpMap() {
        ARouter.getInstance().build("/service/map").navigation();
    }

    @OnClick(R.id.btn_submit)
    public void onSubmit() {
        if (TextUtils.isEmpty(goodsGroupSellReceiverTel)) {
            Toast.makeText(ShopOrderActivity.this, "请添加地址", Toast.LENGTH_SHORT).show();
            return;
        }
        Map<String, Object> params = new HashMap<>();
        params.put("stationId", UserLocalData.getUserInfo(this).getStationInfo().getStationId());
        params.put("userId", UserLocalData.getUserInfo(this).getUserInfo().getUserId());
        params.put("goodsGroupSellId", goodsGroupSellId);
        params.put("goodsGroupSellOrderAmount", goodsGroupSellOrderAmount);
        params.put("goodsGroupSellOrderDeliverMode", goodsGroupSellOrderDeliverMode);
        params.put("goodsGroupSellPayMode", 1);
        params.put("goodsGroupSellReceiverTel", goodsGroupSellReceiverTel);
        params.put("goodsGroupSellReceiverAddress", goodsGroupSellReceiverAddress);
        params.put("goodsGroupSellReceiverName",goodsGroupSellReceiverName);
        params.put("goodsGroupSellStationMasterName", UserLocalData.getUserInfo(this).getStationManagerInfo().getStationManagerName());
        params.put("goodsGroupSellStationTel", UserLocalData.getUserInfo(this).getStationManagerInfo().getStationManagerTel());
        EasyHttp.post("createNewGoodsGroupSellOrder")
                .upJson(new JSONObject(params).toString())
                .execute(new SimpleCallBack<String>() {

                    @Override
                    public void onError(ApiException e) {
                        Toast.makeText(mContext, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onSuccess(String entity) {
                        Log.i("www", "data=" + entity);
                        ARouter.getInstance().build("/main/tab").navigation();
                        finish();
                    }
                });

    }

    /**
     * 请求成团数量
     */
    private void requestSellInfo() {
        Map<String, Object> params = new HashMap<>();
        params.put("stationId", UserLocalData.getUserInfo(this).getStationInfo().getStationId());
        params.put("goodsGroupSellId", goodsGroupSellId);

        EasyHttp.post("getGroupedAmountByStation")
                .upJson(new JSONObject(params).toString())
                .execute(new SimpleCallBack<GroupingDesEntity>() {

                    @Override
                    public void onError(ApiException e) {
                        Toast.makeText(mContext, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onSuccess(GroupingDesEntity entity) {
                        if (entity.getAmountOrdered() == entity.getGoodsGroupRequiredCount()) {
                            animShopButton.setReplenish(true);
                        } else {
                            //animShopButton.setReplenish(true);
                            animShopButton.setCount(1);
                            animShopButton.setMaxCount(entity.getGoodsGroupRequiredCount() - entity.getAmountOrdered());
                        }

                    }
                });

    }

    /**
     * 获取默认地址
     */
    public void getUserDefaultAddress() {
        Map<String, Object> params = new HashMap<>();
        params.put("userId", UserLocalData.getUserInfo(this).getUserInfo().getUserId());

        EasyHttp.post("getUserDefaultAddress")
                .upJson(new JSONObject(params).toString())
                .execute(new SimpleCallBack<DefaultAddressEntity>() {

                    @Override
                    public void onError(ApiException e) {
                        Toast.makeText(mContext, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onSuccess(DefaultAddressEntity entity) {
                        if (null != entity.getUserDefaultAddress())
                            updataAddress(entity);
                    }
                });

    }

    private void updataAddress(DefaultAddressEntity entity) {
        address = entity.getUserDefaultAddress().getUserAddressDetail();
        goodsGroupSellReceiverTel = entity.getUserDefaultAddress().getUserAddressContactTel();
        goodsGroupSellReceiverAddress = entity.getUserDefaultAddress().getUserAddressDetail();
        goodsGroupSellReceiverName = entity.getUserDefaultAddress().getUserAddressContactPeople();
        Log.i("qazx", "updataAddress: " + address);
        Log.i("qazx", "updataAddress: " + goodsGroupSellReceiverTel);
        rltNoAddress.setVisibility(View.GONE);
        rltAddress.setVisibility(View.VISIBLE);
        tvConsignee.setText("收货人：" + entity.getUserDefaultAddress().getUserAddressContactPeople());
        tvConsigneeAddress.setText("收货地址：" + entity.getUserDefaultAddress().getUserAddressDetail());
        tvConsigneePhone.setText(entity.getUserDefaultAddress().getUserAddressContactTel());
    }

    private void updateView() {
        tvStationName.setText("站主姓名：" + UserLocalData.getUserInfo(mContext).getStationManagerInfo().getStationManagerName());
        tvStationAddress.setText("站主地址：" + UserLocalData.getUserInfo(mContext).getStationManagerInfo().getStationManagerAddress());
        tvStationPhone.setText(UserLocalData.getUserInfo(mContext).getStationManagerInfo().getStationManagerTel());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Contents.REQUEST_CONSIGNEE_ADR) {
            if (resultCode == RESULT_OK) {
                getUserDefaultAddress();
            }
        }
    }
}
