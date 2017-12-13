package com.whombang.app.mvp.presenter;

import com.whombang.app.features.login.LoginActivity;

import javax.inject.Inject;

/**
 * Created by sundy.jiang on 2017/12/13.
 */

public class LoginPresenter {

    private LoginActivity loginActivity;
    @Inject
    public LoginPresenter(LoginActivity loginActivity){
      this.loginActivity=loginActivity;
    }

    /**
     * 密码登录
     */
    public void onPasswordLogin(String account,String passWord){


    }


}
