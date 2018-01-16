package com.whombang.app.features.mycenter.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.whombang.app.R;
import com.whombang.app.common.base.BaseActivity;
import com.whombang.app.common.entity.BaseEntity;
import com.whombang.app.common.net.EasyHttp;
import com.whombang.app.common.net.callback.SimpleCallBack;
import com.whombang.app.common.net.exception.ApiException;
import com.whombang.app.common.view.TitleBar;
import com.whombang.app.common.view.imageview.ExpandImageView;
import com.whombang.app.entity.GoodsGroupDetailsEntity;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;

/**
 * 评价
 */
@Route(path = "/server/evalute")
public class EvaluateActivity extends BaseActivity {
    @BindView(R.id.et_content)
    EditText etContent;
    @BindView(R.id.img_goods)
    ExpandImageView expandImageView;
    @BindView(R.id.tv_goods_name)
    TextView tvGoodsName;
    @BindView(R.id.tv_unit_price)
    TextView tvUnitPrice;
    @BindView(R.id.tv_goods_des)
    TextView tvGoodsDes;
    @BindView(R.id.tv_goods_num)
    TextView tvGoodsNum;
    @BindView(R.id.tv_total_prices)
    TextView tvTotalPrices;

    @BindView(R.id.ratingBar)
    RatingBar ratingBar;
    String userId;
    String goodsGroupSellOrderId;
    int commentStarLevel=1;
    @Override
    protected int bindLayout() {
        return R.layout.wb_evaluate_layout;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    public void initData(Bundle bundle) {
        userId = bundle.getString("userId", "");
        goodsGroupSellOrderId = bundle.getString("goodsGroupSellOrderId", "");
    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        titleBar.setTitle("评价");
        titleBar.addAction(new TitleBar.TextAction("完成") {
            @Override
            public void performAction(View view) {
                if (!TextUtils.isEmpty(etContent.getText().toString())) {
                    addEvaluate();
                } else {
                    Toast.makeText(mContext, "内容不能为空", Toast.LENGTH_SHORT).show();
                }
            }
        });
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
                        upView(entity);
                    }
                });
    }

    private void upView(GoodsGroupDetailsEntity entity) {
        expandImageView.setImageURI(entity.getGoodsGroupSellTitleImgUrl());
        tvGoodsName.setText(entity.getStationName());
        //tvServiceStatus.setText(entity.getStatusStr());
        tvUnitPrice.setText("￥" + entity.getGoodsGroupSellPrice());
        tvGoodsNum.setText("x" + entity.getGoodsGroupSellOrderAmount());
        tvGoodsDes.setText(entity.getGroupingDes());
        tvTotalPrices.setText("共" + entity.getGoodsGroupSellOrderAmount() + "件商品 合计：￥" + entity.getGoodsGroupSellPayTotalMoney());
    }

    private void addEvaluate() {
        final Map<String, Object> params = new HashMap<>();
        params.put("goodsGroupSellOrderId", goodsGroupSellOrderId);
        params.put("commentContent", etContent.getText().toString());
        params.put("commentStarLevel",commentStarLevel );
        EasyHttp.post("createGoodsComment")
                .upJson(new JSONObject(params).toString())
                .execute(new SimpleCallBack<BaseEntity>() {

                    @Override
                    public void onError(ApiException e) {
                        Toast.makeText(mActivity, e.getMessage(), Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onSuccess(BaseEntity entity) {
                        finish();
                    }
                });
    }

    @Override
    public void doBusiness() {
         ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
             @Override
             public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                 commentStarLevel= (int) rating;
                 Log.i("qazxc", "onRatingChanged: ="+commentStarLevel);
             }
         });
    }
}
