package com.whombang.app.features.home.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
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
import com.whombang.app.common.view.spinner.NiceSpinner;
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
 *
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
    @Override
    protected int bindLayout() {
        return R.layout.wb_shoporder_layout;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        titleBar.setTitle("确认订单");
        List<String> dataset = new LinkedList<>(Arrays.asList("线下支付", "微信支付", "支付宝", "银联支付"));
        niceSpinner.attachDataSource(dataset);
        List<String> dataset2 = new LinkedList<>(Arrays.asList("站主配送", "到站自提"));
        niceSpinner2.attachDataSource(dataset2);
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
                        tvPresent.setText("银联支付");
                        break;
                    case 1:
                        imgPresent.setImageResource(R.mipmap.ziquyidianji);
                        tvPresent.setText("银联支付");
                        break;
                }
            }
        });
    }

    @OnClick(R.id.no_address)
    public void addAddress(){
        ARouter.getInstance().build("/address/newly").withBoolean("isEdite",false).navigation(mActivity, Contents.REQUEST_CONSIGNEE_ADR);
    }

    @OnClick(R.id.address2)
    public void jumpMap(){
        ARouter.getInstance().build("/service/map").navigation();
    }

    @OnClick(R.id.btn_submit)
    public void onSubmit(){
        Map<String, Object> params = new HashMap<>();
        params.put("stationId", UserLocalData.getUserInfo(this).getStationInfo().getStationId());
        params.put("userId",UserLocalData.getUserInfo(this).getUserInfo().getUserId() );
        params.put("goodsGroupSellId", 1);
        params.put("goodsGroupSellOrderAmount",5);
        params.put("goodsGroupSellOrderDeliverMode", 1);
        params.put("goodsGroupSellPayMode", 1);
        params.put("goodsGroupSellReceiverTel","18611766105" );
        params.put("goodsGroupSellReceiverAddress","18611766105" );
        params.put("goodsGroupSellReceiverName","张三" );
        params.put("goodsGroupSellStationMasterName","牛魔王" );
        params.put("goodsGroupSellStationTel","13126556729" );
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
                        finish();
                    }
                });

    }
}
