package com.whombang.app.features.home.fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import com.whombang.app.R;
import com.whombang.app.adapter.HomeMultipleRecycleAdapter;
import com.whombang.app.common.base.BaseFragment;
import com.whombang.app.common.net.EasyHttp;
import com.whombang.app.common.net.callback.SimpleCallBack;
import com.whombang.app.common.net.exception.ApiException;
import com.whombang.app.common.view.WBHeaderView;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;
/**
 * HomeFragment
 * 首页
 */
public class HomeFragment extends BaseFragment implements WBHeaderView.RefreshDistanceListener {

    HomeMultipleRecycleAdapter adapter;

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

    }

    @Override
    public void doBusiness() {
        Map<String, Object> params = new HashMap<>();
        params.put("pageSize",20);
        params.put("currentPageNum", 1);

        EasyHttp.post("goodsList")
                .upJson(new JSONObject(params).toString())
                .execute(new SimpleCallBack<String>() {

                    @Override
                    public void onError(ApiException e) {
                        Toast.makeText(mActivity,e.getMessage(),Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onSuccess(String entity) {
                        Log.i("www","data="+entity);

                    }
                });
    }

    @Override
    public void onPositionChange(int currentPosY) {

    }
}
