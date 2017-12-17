package com.whombang.app.features.mycenter.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.whombang.app.R;
import com.whombang.app.common.base.BaseActivity;
import com.whombang.app.common.view.TitleBar;
import com.whombang.app.mvp.component.DaggerAddressManagerComponent;
import com.whombang.app.mvp.component.DaggerNewlyAddressComponent;
import com.whombang.app.mvp.module.NewlyAddressModule;
import com.whombang.app.mvp.presenter.NewlyAddressPresenter;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * 新增地址
 */
@Route(path = "/address/newly")
public class NewlyAddressActivity extends BaseActivity {
    @BindView(R.id.et_person)
    EditText etName;
    @BindView(R.id.et_add_phone)
    EditText etPhone;
    @BindView(R.id.et_detail_address)
    EditText etAddress;
    @Inject
    NewlyAddressPresenter presenter;

    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return R.layout.wb_newly_address_layout;
    }

    @Override
    protected void initInjector() {
        DaggerNewlyAddressComponent.builder().newlyAddressModule(new NewlyAddressModule(this)).build().inject(this);
    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        titleBar.setTitle("新增地址");
        titleBar.addAction(new TitleBar.TextAction("完成") {
            @Override
            public void performAction(View view) {
                presenter.addAddress(etName.getText().toString(),etPhone.getText().toString(),etAddress.getText().toString());
            }
        });
    }

    @Override
    public void doBusiness() {

    }
}
