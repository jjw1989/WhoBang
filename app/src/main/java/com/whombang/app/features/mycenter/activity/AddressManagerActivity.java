package com.whombang.app.features.mycenter.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.whombang.app.R;
import com.whombang.app.adapter.ConsigneeAddressAdapter;
import com.whombang.app.common.base.BaseActivity;
import com.whombang.app.common.base.BaseAdapter;
import com.whombang.app.common.constants.Contents;
import com.whombang.app.common.view.MyDivider;
import com.whombang.app.common.view.TitleBar;
import com.whombang.app.entity.ConsigneeEntity;
import com.whombang.app.entity.UserLocalData;
import com.whombang.app.mvp.component.DaggerAddressManagerComponent;
import com.whombang.app.mvp.module.AddressManagerModule;
import com.whombang.app.mvp.presenter.AddressManagerPresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * 地址管理页面
 */
@Route(path = "/address/manager")
public class AddressManagerActivity extends BaseActivity {
    @BindView(R.id.rv_common_view)
    RecyclerView mRecyclerView;
    ConsigneeAddressAdapter adapter;
    List<ConsigneeEntity.UserAddressInfosBean> addressAll;
    @Inject
    AddressManagerPresenter presenter;
    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return R.layout.wb_address_manage_layout;
    }

    @Override
    protected void initInjector() {
        DaggerAddressManagerComponent.builder().addressManagerModule(new AddressManagerModule(this)).build().inject(this);
    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        titleBar.setTitle("地址管理");
        titleBar.addAction(new TitleBar.ImageAction(R.mipmap.add) {
            @Override
            public void performAction(View view) {
                ARouter.getInstance().build("/address/newly").withBoolean("isEdite",false).navigation(mActivity, Contents.REQUEST_CONSIGNEE_ADR);
            }
        });

        presenter.requestAddressList(UserLocalData.getUserInfo(this).getUserInfo().getUserId());
    }

    @Override
    public void doBusiness() {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==Contents.REQUEST_CONSIGNEE_ADR){
            if(resultCode==RESULT_OK){
                presenter.requestAddressList(UserLocalData.getUserInfo(this).getUserInfo().getUserId());
            }
        }
    }

    /**
     * 载入地址列表
     * @param addressList
     */
    public void loadAddress(List<ConsigneeEntity.UserAddressInfosBean> addressList){
        this.addressAll.addAll(addressList);
        if(addressList!=null && addressList.size()>0){
            orderItem(addressAll);
        }
        adapter=new ConsigneeAddressAdapter(this,addressAll,R.layout.wb_adress_item_layout);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new MyDivider());
        mRecyclerView.setAdapter(adapter);
        addConsigneeAddressAdapterListener() ;
    }

    private void addConsigneeAddressAdapterListener() {
        adapter.setOnItemClickListener(new BaseAdapter.onItemClickListener() {
            @Override
            public void onClick(View view, int position) throws Exception {
                if (view.getId() == R.id.radio_selected && !addressAll.get(position).getUserAddressDefault()) {
                    for (int i = 0; i < addressAll.size() ; i++) {
                        if (addressAll.get(i).getUserAddressDefault()){
                             //设置默认地址
                             //刷数据
                            return;
                        }
                    }
                    //
                }else if(view.getId()==R.id.delete_address){
                    Log.i("qwert","delete_address..............");
                }else if(view.getId()==R.id.edite_address){
                    Log.i("qwert","edite_address.................");
                }
            }
        });
    }

    /**
     * 将默认地址排序到第一个位置
     * @param addressList
     */
    private void orderItem(List<ConsigneeEntity.UserAddressInfosBean> addressList) {
        for (int i = 0; i < addressList.size() ; i++) {
            if (addressList.get(i).getUserAddressDefault()){
               // MyApplication.getInstance().getUser().setDefauteConsigen(consigneeMsgs.get(i));
                ConsigneeEntity.UserAddressInfosBean tmp = addressList.get(i) ;
                addressList.remove(i) ;
                addressList.add(0 , tmp);
                return;
            }
        }

    }
}
