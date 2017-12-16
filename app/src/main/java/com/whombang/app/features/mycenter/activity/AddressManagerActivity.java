package com.whombang.app.features.mycenter.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.whombang.app.R;
import com.whombang.app.adapter.ConsigneeAddressAdapter;
import com.whombang.app.common.base.BaseActivity;
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
                ARouter.getInstance().build("/address/newly").navigation();
            }
        });

        presenter.requestAddressList(UserLocalData.getUserInfo(this).getUserInfo().getUserId());
    }

    @Override
    public void doBusiness() {

    }

    /**
     * 载入地址列表
     * @param addressList
     */
    public void loadAddress(List<ConsigneeEntity.UserAddressInfosBean> addressList){
        adapter=new ConsigneeAddressAdapter(this,addressList,R.layout.wb_adress_item_layout);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new MyDivider());
        mRecyclerView.setAdapter(adapter);
    }
//    private List<ConsigneeEntity> getDatas(){
//        List<ConsigneeEntity> items=new ArrayList<>();
//        ConsigneeEntity entity=new ConsigneeEntity();
//        entity.setAddr("昌平区回龙观");
//        entity.setDefault(true);
//        entity.setPhone("18611766105");
//        entity.setConsignee("张三");
//
//        ConsigneeEntity entity2=new ConsigneeEntity();
//        entity2.setAddr("昌平区回龙观问问");
//        entity2.setDefault(false);
//        entity2.setPhone("18611766105");
//        entity2.setConsignee("张三1");
//        items.add(entity);
//        items.add(entity2);
//        return items;
//    }
}
