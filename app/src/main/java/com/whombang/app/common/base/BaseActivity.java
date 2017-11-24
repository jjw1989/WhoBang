package com.whombang.app.common.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

import butterknife.ButterKnife;

/**
 * Description:Activity的基类 注意：除非特殊，要不必须继承
 * Company:
 * Created by sundy.jiang on 2017/11/10.
 */

public abstract class BaseActivity extends AppCompatActivity implements IBaseView{
    /**
     * 当前Activity渲染的视图View
     */
    public View rootView;
    protected Activity mActivity;
    protected Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity=this;
        mContext=getApplicationContext();
        Bundle bundle=getIntent().getExtras();
        initData(bundle);
        setBaseView(bindLayout());
        ButterKnife.bind(this);
        initView(savedInstanceState,rootView);
        doBusiness();
    }

    /**
     * 设置视图
     * @param layoutId
     */
    protected void setBaseView(int layoutId){
        rootView= LayoutInflater.from(this).inflate(layoutId,null);
        setContentView(rootView);
    }

    /**
     * 设置屏幕属性
     */
    protected void setScreenArrts(){
         getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
         getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
             @Override
             public void onSystemUiVisibilityChange(int visibility) {
                 getWindow().getDecorView().setSystemUiVisibility(5895);
                 getWindow().getDecorView().requestFocus();
             }
         });
    }
}
