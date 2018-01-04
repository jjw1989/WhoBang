package com.whombang.app;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.whombang.app.common.base.BaseActivity;
import com.whombang.app.mvp.component.DaggerLauncherActivityComponent;
import com.whombang.app.mvp.module.LauncherActivityModule;
import com.whombang.app.mvp.presenter.LauncherPresenter;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * 启动页
 */
public class LauncherActivity extends BaseActivity {
    @BindView(R.id.img_logo)
    ImageView imgLogo;

    @Inject
    LauncherPresenter presenter;

    @Override
    public void initData(Bundle bundle) {
    }

    @Override
    public int bindLayout() {
        return R.layout.wb_lanucher_layout;
    }

    @Override
    protected void initInjector() {
        DaggerLauncherActivityComponent.builder().launcherActivityModule(new LauncherActivityModule(this)).build().inject(this);
    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
      //  Log.i("wwww", "initView: "+ sHA1(this));

    }

    @Override
    public void doBusiness() {
        titleBar.setVisibility(View.GONE);
        presenter.onStartAnimAndJump(imgLogo);
    }

    public  String sHA1(Context context) {
        try {
            PackageInfo info = context.getPackageManager().getPackageInfo(
                    context.getPackageName(), PackageManager.GET_SIGNATURES);
            byte[] cert = info.signatures[0].toByteArray();
            MessageDigest md = MessageDigest.getInstance("SHA1");
            byte[] publicKey = md.digest(cert);
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < publicKey.length; i++) {
                String appendString = Integer.toHexString(0xFF & publicKey[i])
                        .toUpperCase(Locale.US);
                if (appendString.length() == 1)
                    hexString.append("0");
                hexString.append(appendString);
                hexString.append(":");
            }
            String result= hexString.toString();
            return result.substring(0, result.length()-1);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
