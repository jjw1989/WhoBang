package com.whombang.app.features.home.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.whombang.app.R;
import com.whombang.app.common.base.BaseActivity;
import com.whombang.app.common.view.spinner.NiceSpinner;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import butterknife.BindView;

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
}
