package com.whombang.app.features.login;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.whombang.app.R;
import com.whombang.app.common.base.BaseActivity;
import com.whombang.app.common.entity.BaseEntity;
import com.whombang.app.common.net.EasyHttp;
import com.whombang.app.common.net.callback.SimpleCallBack;
import com.whombang.app.common.net.exception.ApiException;
import com.whombang.app.common.utils.DESUtil;
import com.whombang.app.common.utils.RxJavaUtil;
import com.whombang.app.common.view.KeyboardWatcher;
import com.whombang.app.common.view.hideime.HideIMEUtil;
import com.whombang.app.common.view.keyboard.KeyboardLayout;
import com.whombang.app.common.view.keyboard.SoftKeyInputHidWidget;
import com.whombang.app.mvp.component.DaggerForgetActivityComponent;
import com.whombang.app.mvp.module.ForgetActivityModule;
import com.whombang.app.mvp.presenter.ForgetPresenter;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.functions.Consumer;

/**
 * 忘记密码
 */
@Route(path = "/user/forget")
public class ForgetActivity extends BaseActivity {
    @BindView(R.id.img_logo_forget)
    ImageView imgLogo;
    @BindView(R.id.et_forget_phone)
    EditText etPhone;
    @BindView(R.id.et_forget_code)
    EditText etCode;
    @BindView(R.id.et_new_password)
    EditText etNewPassWord;
    @BindView(R.id.et_affirm_password)
    EditText etAffirmPassWord;
    @BindView(R.id.body)
    View body;
    @BindView(R.id.btn_forget_code)
    Button btnCode;
    @BindView(R.id.login_ll)
    ScrollView scrollView;
    @BindView(R.id.main_ll)
    KeyboardLayout keyboardLayout;
    @Inject
    ForgetPresenter presenter;
    private int screenHeight = 0;//屏幕高度

    @Override
    protected int bindLayout() {
        return R.layout.wb_forget_layout;
    }

    @Override
    protected void initInjector() {
        DaggerForgetActivityComponent.builder().forgetActivityModule(new ForgetActivityModule(this)).build().inject(this);
    }

    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        titleBar.setTitle(getString(R.string.tv_title));
        screenHeight = this.getResources().getDisplayMetrics().heightPixels; //获取屏幕高度
        HideIMEUtil.wrap(this);
        keyboardLayout.setKeyboardListener(new KeyboardLayout.KeyboardLayoutListener() {
            @Override
            public void onKeyboardStateChanged(boolean isActive, int keyboardHeight) {
                if (isActive) {
                    scrollToBottom();
                }
            }
        });
    }
    /**
     * 弹出软键盘时将SVContainer滑到底
     */
    private void scrollToBottom() {
        scrollView.postDelayed(new Runnable() {

            @Override
            public void run() {
                scrollView.smoothScrollTo(0, scrollView.getBottom() + SoftKeyInputHidWidget.getStatusBarHeight(mActivity));//scrollView.getBottom() + SoftKeyInputHidWidget.getStatusBarHeight(mContext)
            }
        }, 100);

    }
    @Override
    public void doBusiness() {

    }
    @OnClick({R.id.btn_affirm,R.id.btn_forget_code})
    public void requestCode(View v) {
        switch (v.getId()){
            case R.id.btn_forget_code:
                btnCode.setEnabled(false);
                onSmsCode();
                break;
            case R.id.btn_affirm:
                if (etAffirmPassWord.getText().toString().equals(etNewPassWord.getText().toString())) {
                    presenter.requestPassword(etPhone.getText().toString(), etCode.getText().toString(), etNewPassWord.getText().toString());
                    finish();
                }else{
                    Toast.makeText(mContext,"密码不一致",Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
    private void onSmsCode() {
        requestSms();
        RxJavaUtil.countdown(59).subscribe(new Consumer<Long>() {
            @Override
            public void accept(Long aLong) throws Exception {
                String content=String.format(getString(R.string.residue),aLong);
                if(aLong==0){
                    btnCode.setEnabled(true);
                }
                btnCode.setText(content);
            }
        });
    }

    private void requestSms() {
        String telNumEncrypted = DESUtil.encrypt(etPhone.getText().toString().trim(), "80f37a994f8d426c85e5b4d2a5f30350");
        Map<String, String> params = new HashMap<>();
        params.put("userTel", telNumEncrypted);
        EasyHttp.post("sendSMS")
                .upJson(new JSONObject(params).toString())
                .execute(new SimpleCallBack<BaseEntity>() {

                    @Override
                    public void onError(ApiException e) {
                        Toast.makeText(mActivity, e.getMessage(), Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onSuccess(BaseEntity entity) {
                        // Log.i("qazx", "onSuccess: sms="+entity);
                        ARouter.getInstance().build("/user/login").withTransition(R.anim.push_left_in, R.anim.push_right_out).navigation(ForgetActivity.this);
                    }
                });
    }
}
