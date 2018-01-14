package com.whombang.app.features.sendtask;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.whombang.app.R;
import com.whombang.app.common.base.BaseActivity;
import com.whombang.app.common.constants.Contents;
import com.whombang.app.common.view.TitleBar;
import com.whombang.app.entity.DefaultAddressEntity;
import com.whombang.app.entity.UserLocalData;
import com.whombang.app.mvp.component.DaggerTextTaskComponent;
import com.whombang.app.mvp.module.TextTaskModule;
import com.whombang.app.mvp.presenter.TextTaskPresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 发布文本任务
 */
@Route(path = "/task/text")
public class TextTaskActivity extends BaseActivity {
    @BindView(R.id.et_text_content)
    EditText etContent;
    @Inject
    TextTaskPresenter presenter;
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

    String address="";
    String name="";
    String phone="";
    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return R.layout.wb_text_task_layout;
    }

    @Override
    protected void initInjector() {
        DaggerTextTaskComponent.builder().textTaskModule(new TextTaskModule(this)).build().inject(this);
    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        titleBar.setTitle(getString(R.string.issue_service));
        titleBar.addAction(new TitleBar.TextAction(getString(R.string.issue)) {
            @Override
            public void performAction(View view) {
                if (!TextUtils.isEmpty(address)) {
                    if (!TextUtils.isEmpty(etContent.getText().toString())) {
                        presenter.sendTaskSerivce(etContent.getText().toString(), address,phone,name);
                    }else{
                        Toast.makeText(mContext,"请添加内容",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(mContext,"请添加地址",Toast.LENGTH_SHORT).show();
                }
            }
        });
        presenter.getUserDefaultAddress();
        updateView();
    }

    private void updateView() {
        tvStationName.setText("站主姓名："+UserLocalData.getUserInfo(mContext).getStationManagerInfo().getStationManagerName());
        tvStationAddress.setText("站主地址："+UserLocalData.getUserInfo(mContext).getStationManagerInfo().getStationManagerAddress());
        tvStationPhone.setText(UserLocalData.getUserInfo(mContext).getStationManagerInfo().getStationManagerTel());
    }

    @Override
    public void doBusiness() {

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
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode== Contents.REQUEST_CONSIGNEE_ADR){
            if(resultCode==RESULT_OK){
                presenter.getUserDefaultAddress();
            }
        }else if(requestCode==Contents.REQUEST_STATION_ADDRESS){
            if(resultCode==RESULT_OK){
                Log.i("wwww", "onActivityResult: 22222222222222222222222222");
            }
        }
    }
    @OnClick(R.id.address2)
    public void jumpMap(){
        ARouter.getInstance().build("/service/map").navigation();
    }

    public void updataAddress(DefaultAddressEntity entity) {
        address=entity.getUserDefaultAddress().getUserAddressDetail();
        name=entity.getUserDefaultAddress().getUserAddressContactPeople();
        phone=entity.getUserDefaultAddress().getUserAddressContactTel();
        rltNoAddress.setVisibility(View.GONE);
        rltAddress.setVisibility(View.VISIBLE);
        tvConsignee.setText("收货人："+entity.getUserDefaultAddress().getUserAddressContactPeople());
        tvConsigneeAddress.setText("收货地址："+entity.getUserDefaultAddress().getUserAddressDetail());
        tvConsigneePhone.setText(entity.getUserDefaultAddress().getUserAddressContactTel());
    }
}
