package com.whombang.app.features.mycenter.fragment;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.whombang.app.R;
import com.whombang.app.adapter.BaseDelegateAdapter;
import com.whombang.app.common.base.BaseFragment;
import com.whombang.app.common.baseadapter.BaseViewHolder;
import com.whombang.app.common.config.ViewType;
import com.whombang.app.entity.CenterEntity;
import com.whombang.app.entity.UserInfoEntity;
import com.whombang.app.entity.UserLocalData;

import java.util.LinkedList;
import java.util.List;

import butterknife.BindView;


/**
 * 个人中心
 */
public class MyCenterFragment extends BaseFragment {
    @BindView(R.id.work_recyclerview)
    RecyclerView mRecyclerView;
    List<CenterEntity> entityList;
    private List<DelegateAdapter.Adapter> mAdapters; //存放各个模块的适配器
    private int count = 0;
    private int userType=0;
    @Override
    public void initData(Bundle bundle) {
        initData();
    }

    @Override
    public int bindLayout() {
        return R.layout.wb_mycenter_fgt_layout;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        mAdapters = new LinkedList<>();
        VirtualLayoutManager  layoutManager = new VirtualLayoutManager(mActivity);
        mRecyclerView.setLayoutManager(layoutManager);

        //步骤2：设置组件复用回收池
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        mRecyclerView.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(0, 10);
        //1头部
        DelegateAdapter delegateAdapter = new DelegateAdapter(layoutManager, true);
        mRecyclerView.setAdapter(delegateAdapter);
        final View.OnClickListener listener=new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                ARouter.getInstance().build("/user/login").navigation();
            }
        };
        BaseDelegateAdapter headAdapter = new BaseDelegateAdapter(mActivity, new LinearLayoutHelper() , R.layout.item_work_banner, 1, ViewType.VIEW_TYPE_HEAD) {
            @Override
            public void onBindViewHolder(BaseViewHolder holder, int position) {
                super.onBindViewHolder(holder, position);
                ImageView imgSet=holder.getView(R.id.img_user_set);
                 ImageView imgHead=holder.getView(R.id.avatar);
                 TextView tvLogin=holder.getView(R.id.tv_user_tip);
                 //tvLogin.setText(UserLocalData.getUserInfo(mActivity).getUserInfo().);
                 imgHead.setOnClickListener(listener);
                 tvLogin.setOnClickListener(listener);
                 imgSet.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View view) {
                         ARouter.getInstance().build("/my/userset").navigation();
                     }
                 });
            }
        };

        mAdapters.add(headAdapter);

      //  viewPool.setMaxRecycledViews(1, 8);
        //2功能列表
        BaseDelegateAdapter functionAdapter = new BaseDelegateAdapter(mActivity,  new LinearLayoutHelper(), R.layout.item_work_func ,count, ViewType.VIEW_TYPE_LIST) {
            @Override
            public void onBindViewHolder(BaseViewHolder holder, final int position) {
                super.onBindViewHolder(holder, position);
                 TextView tvName=holder.getView(R.id.function_name);
                 View line=holder.getView(R.id.my_line);
                 View line_top=holder.getView(R.id.my_line_top);
                 tvName.setText(entityList.get(position).name);
                 if (entityList.get(position).isShowBottom){
                     line.setVisibility(View.VISIBLE);
                 }else{
                     line.setVisibility(View.GONE);
                 }
                 if (entityList.get(position).isShowTop){
                     line_top.setVisibility(View.VISIBLE);
                 }else{
                     line_top.setVisibility(View.GONE);
                 }
                 holder.getConvertView().setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {
                         if(userType==0){
                             switch (position){
                                 case 0:
                                     ARouter.getInstance().build("/my/groud").navigation();
                                     break;
                                 case 1:
                                     ARouter.getInstance().build("/my/service").navigation();
                                     break;
//                                 case 2:
//                                     ARouter.getInstance().build("/my/setting").navigation();
//                                     break;
                                 case 2:
                                     ARouter.getInstance().build("/my/about").navigation();
                                     break;
                             }
                         }else if(userType==1){
                             switch (position){
                                 case 0:
                                     ARouter.getInstance().build("/my/groud").navigation();
                                     break;
                                 case 1:
                                     ARouter.getInstance().build("/my/service").navigation();
                                     break;
                                 case 2:
                                     ARouter.getInstance().build("/my/server").navigation();
                                     break;

                                 case 3:
                                     ARouter.getInstance().build("/my/offer").navigation();
                                     break;

                                 case 4:
                                     ARouter.getInstance().build("/my/goods").navigation();
                                     break;

                                 case 5:
                                     ARouter.getInstance().build("/my/info").navigation();
                                     break;

//                                 case 6:
//                                     ARouter.getInstance().build("/my/setting").navigation();
//                                     break;
                                 case 6:
                                     ARouter.getInstance().build("/my/about").navigation();
                                     break;
                             }
                         }else{
                             switch (position){
                                 case 0:
                                     ARouter.getInstance().build("/my/groud").navigation();
                                     break;
                                 case 1:
                                     ARouter.getInstance().build("/my/service").navigation();
                                     break;

                                 case 2:
                                     ARouter.getInstance().build("/my/offer").navigation();
                                     break;

//                                 case 3:
//                                     ARouter.getInstance().build("/my/setting").navigation();
//                                     break;
                                 case 3:
                                     ARouter.getInstance().build("/my/about").navigation();
                                     break;
                             }
                         }

                     }
                 });

            }

        };
        mAdapters.add(functionAdapter);
        //设置适配器
        delegateAdapter.setAdapters(mAdapters);
    }

    @Override
    public void doBusiness() {

    }

    /**
     * 添加本地数据
     */
    private void initData() {
        UserInfoEntity item = UserLocalData.getUserInfo(mActivity);
        userType=item.getUserInfo().getUserType();
        /**
         *   0:普通用户   1：站主   2：服务者
         */
        if (userType == 0) {
            count = 3;
            entityList = new LinkedList<>();
            CenterEntity entity0 = new CenterEntity(getString(R.string.my_group_booking), true, false);
            CenterEntity entity1 = new CenterEntity(getString(R.string.my_service), true, false);
           // CenterEntity entity2 = new CenterEntity(getString(R.string.my_setting), true, false);
            CenterEntity entity3 = new CenterEntity(getString(R.string.my_about), true, true);
            entityList.add(entity0);
            entityList.add(entity1);
           // entityList.add(entity2);
            entityList.add(entity3);
        } else if (userType == 1) {
            count = 7;
            entityList = new LinkedList<>();
            CenterEntity entity0 = new CenterEntity(getString(R.string.my_group_booking), true, false);
            CenterEntity entity1 = new CenterEntity(getString(R.string.my_service), false, false);
            CenterEntity entity2 = new CenterEntity(getString(R.string.my_add_service), true, false);
            CenterEntity entity3 = new CenterEntity(getString(R.string.my_offer_service_list), false, false);
            CenterEntity entity4 = new CenterEntity(getString(R.string.my_goods_list), false, false);
            CenterEntity entity5 = new CenterEntity(getString(R.string.my_service_info_list), false, false);
          //  CenterEntity entity6 = new CenterEntity(getString(R.string.my_setting), true, false);
            CenterEntity entity7 = new CenterEntity(getString(R.string.my_about), true, false);
            entityList.add(entity0);
            entityList.add(entity1);
            entityList.add(entity2);
            entityList.add(entity3);
            entityList.add(entity4);
            entityList.add(entity5);
           // entityList.add(entity6);
            entityList.add(entity7);
        } else {
            count = 4;
            entityList = new LinkedList<>();
            CenterEntity entity0 = new CenterEntity(getString(R.string.my_group_booking), true, false);
            CenterEntity entity1 = new CenterEntity(getString(R.string.my_service), false, false);
            CenterEntity entity2 = new CenterEntity(getString(R.string.my_offer_service_list), true, true);
           // CenterEntity entity3 = new CenterEntity(getString(R.string.my_setting), true, false);
            CenterEntity entity4 = new CenterEntity(getString(R.string.my_about), true, true);
            entityList.add(entity0);
            entityList.add(entity1);
            entityList.add(entity2);
           // entityList.add(entity3);
            entityList.add(entity4);
        }
    }

}
