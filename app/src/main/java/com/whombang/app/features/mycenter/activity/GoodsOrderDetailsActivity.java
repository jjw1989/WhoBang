package com.whombang.app.features.mycenter.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.whombang.app.R;
import com.whombang.app.common.base.BaseActivity;
import com.whombang.app.common.constants.Contents;
import com.whombang.app.common.entity.BaseEntity;
import com.whombang.app.common.net.EasyHttp;
import com.whombang.app.common.net.callback.SimpleCallBack;
import com.whombang.app.common.net.exception.ApiException;
import com.whombang.app.common.view.imageview.ExpandImageView;
import com.whombang.app.entity.GoodsGroupDetailsEntity;
import com.whombang.app.entity.OfferGoodsEntity;
import com.whombang.app.entity.UserLocalData;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 商品订单详情
 */
@Route(path = "/order/details")
public class GoodsOrderDetailsActivity extends BaseActivity {
    @BindView(R.id.tv_consignee_address)
    TextView tvAddress;
    @BindView(R.id.tv_consignee)
    TextView tvConsignee;
    @BindView(R.id.tv_consignee_phone)
    TextView tvConsigneePhone;
    @BindView(R.id.img_goods)
    ExpandImageView expandImageView;
    @BindView(R.id.tv_goods_name)
    TextView tvGoodsName;
    @BindView(R.id.tv_service_status)
    TextView tvServiceStatus;
    @BindView(R.id.tv_unit_price)
    TextView tvUnitPrice;
    @BindView(R.id.tv_goods_des)
    TextView tvGoodsDes;
    @BindView(R.id.tv_goods_num)
    TextView tvGoodsNum;
    @BindView(R.id.tv_total_prices)
    TextView tvTotalPrices;
    @BindView(R.id.tv_order_code)
    TextView tvOrderCode;
    @BindView(R.id.tv_order_time)
    TextView tvOrderTime;
    @BindView(R.id.btn_cancel)
    Button btnCancel;
    @BindView(R.id.btn_sales_return)
    Button btnSalesReturn;
    String goodsGroupSellOrderId;
    String userId;
    GoodsGroupDetailsEntity itemInfo;
    int tag;

    @Override
    protected int bindLayout() {
        return R.layout.wb_goods_order_details_layout;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    public void initData(Bundle bundle) {
        goodsGroupSellOrderId = bundle.getString("goodsGroupSellOrderId", "");
        userId=bundle.getString("userId","");
        tag = bundle.getInt("tag", -1);
    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        titleBar.setTitle("订单详情");
        requestOrderData();
    }

    private void requestOrderData() {
        final Map<String, Object> params = new HashMap<>();
        params.put("goodsGroupSellOrderId", goodsGroupSellOrderId);
        EasyHttp.post("getGoodsOrderDetail")
                .upJson(new JSONObject(params).toString())
                .execute(new SimpleCallBack<GoodsGroupDetailsEntity>() {

                    @Override
                    public void onError(ApiException e) {
                        Toast.makeText(mContext, e.getMessage(), Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onSuccess(GoodsGroupDetailsEntity entity) {
                        itemInfo = entity;
                        upView(entity);
                    }
                });
    }

    private void upView(GoodsGroupDetailsEntity entity) {
        tvAddress.setText("详情地址:" + entity.getGoodsGroupSellReceiverAddress());
        tvConsignee.setText("收货人:" + entity.getGoodsGroupSellReceiverName());
        tvConsigneePhone.setText(entity.getGoodsGroupSellReceiverTel());
        expandImageView.setImageURI(entity.getGoodsGroupSellTitleImgUrl());
        tvGoodsName.setText(entity.getStationName());
        tvServiceStatus.setText(entity.getStatusStr());
        tvUnitPrice.setText("￥" + entity.getGoodsGroupSellPrice());
        tvGoodsNum.setText("x" + entity.getGoodsGroupSellOrderAmount());
        tvGoodsDes.setText(entity.getGroupingDes());
        tvTotalPrices.setText("共" + entity.getGoodsGroupSellOrderAmount() + "件商品 合计：￥" + entity.getGoodsGroupSellPayTotalMoney());
        tvOrderCode.setText("订单编号:" + entity.getOrderId());
        tvOrderTime.setText("下单时间:" + entity.getGoodsGroupSellOrderTime());
        if (entity.getGoodsGroupSellOrderStatus() == 1) {
            btnCancel.setText("取消订单");
        } else if (entity.getGoodsGroupSellOrderStatus() == 8) {
            btnCancel.setText("确认收货");
        }else if (entity.getGoodsGroupSellOrderStatus()==3){
            btnCancel.setText("退货");
           // btnSalesReturn.setVisibility(View.VISIBLE);
        }
        if (entity.getGoodsGroupSellOrderStatus() == 1 || entity.getGoodsGroupSellOrderStatus() == 8|| entity.getGoodsGroupSellOrderStatus()==3) {
            btnCancel.setVisibility(View.VISIBLE);
        } else {
            btnCancel.setVisibility(View.GONE);
        }
    }

    @Override
    public void doBusiness() {

    }

    @OnClick(R.id.btn_cancel)
    public void cancelGroupBook() {
        if (itemInfo.getGoodsGroupSellOrderStatus()==1) {
            final Map<String, Object> params = new HashMap<>();
            params.put("goodsGroupSellOrderId", goodsGroupSellOrderId);
            EasyHttp.post("goodsCancel")
                    .upJson(new JSONObject(params).toString())
                    .execute(new SimpleCallBack<BaseEntity>() {

                        @Override
                        public void onError(ApiException e) {
                            Toast.makeText(mContext, e.getMessage(), Toast.LENGTH_SHORT).show();

                        }

                        @Override
                        public void onSuccess(BaseEntity entity) {
                            setResult(RESULT_OK);
                            finish();
                        }
                    });
        } else if (itemInfo.getGoodsGroupSellOrderStatus()==8) {
            final Map<String, Object> params = new HashMap<>();
            params.put("goodsGroupSellOrderId", goodsGroupSellOrderId);
            EasyHttp.post("confirmGoodsRecieved")
                    .upJson(new JSONObject(params).toString())
                    .execute(new SimpleCallBack<BaseEntity>() {

                        @Override
                        public void onError(ApiException e) {
                            Toast.makeText(mContext, e.getMessage(), Toast.LENGTH_SHORT).show();

                        }

                        @Override
                        public void onSuccess(BaseEntity entity) {
                            setResult(RESULT_OK);
                            finish();
                        }
                    });
        }else if(itemInfo.getGoodsGroupSellOrderStatus()==3){
            final Map<String, Object> params = new HashMap<>();
            params.put("goodsGroupSellOrderId", goodsGroupSellOrderId);
            EasyHttp.post("askForGoodsReturn")
                    .upJson(new JSONObject(params).toString())
                    .execute(new SimpleCallBack<BaseEntity>() {

                        @Override
                        public void onError(ApiException e) {
                            Toast.makeText(mContext, e.getMessage(), Toast.LENGTH_SHORT).show();

                        }

                        @Override
                        public void onSuccess(BaseEntity entity) {
                            setResult(RESULT_OK);
                            finish();
                        }
                    });
        }
    }
}
