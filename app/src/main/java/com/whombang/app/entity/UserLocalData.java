package com.whombang.app.entity;

import android.content.Context;
import android.text.TextUtils;

import com.whombang.app.common.constants.Contents;
import com.whombang.app.common.utils.JsonUtil;
import com.whombang.app.common.utils.PreferenceUtil;

/**
 * 保存用户信息
 * Created by sundy.jiang on 2017/12/14.
 */

public class UserLocalData {

    public static void putUser(Context context, UserInfoEntity userInfo) {
        PreferenceUtil.putString(context, Contents.USER_JSON, JsonUtil.toJSON(userInfo));
    }

    public static UserInfoEntity getUserInfo(Context context) {
        String userInfo = PreferenceUtil.getString(context, Contents.USER_JSON, null);
        if (!TextUtils.isEmpty(userInfo)) {
            return JsonUtil.fromJson(userInfo, UserInfoEntity.class);
        }
        return null;
    }
}
