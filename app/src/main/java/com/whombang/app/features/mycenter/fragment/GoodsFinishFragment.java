package com.whombang.app.features.mycenter.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.whombang.app.R;
import com.whombang.app.common.base.BaseFragment;
import com.whombang.app.common.net.EasyHttp;
import com.whombang.app.common.net.callback.SimpleCallBack;
import com.whombang.app.common.net.exception.ApiException;
import com.whombang.app.entity.UserLocalData;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * 商品完成
 */
public class GoodsFinishFragment extends BaseFragment {

    @Override
    protected int bindLayout() {
        return R.layout.wb_goods_finish_layout;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        Map<String, Object> params = new HashMap<>();
        params.put("userId", UserLocalData.getUserInfo(mActivity).getUserInfo().getUserId());
        params.put("orderStatus","1");
        params.put("pageSize", "20");
        params.put("currentPageNum", "1");//

//        EasyHttp.post("getProviderUserOrderServiceList")
//                .upJson(new JSONObject(params).toString())
//                .execute(new SimpleCallBack<String>() {
//
//                    @Override
//                    public void onError(ApiException e) {
//                        Toast.makeText(mActivity,e.getMessage(),Toast.LENGTH_SHORT).show();
//                    }
//
//                    @Override
//                    public void onSuccess(String entity) {
//                        Log.i("www","data="+entity);
//                    }
//                });
    }

    @Override
    public void doBusiness() {

    }
}
