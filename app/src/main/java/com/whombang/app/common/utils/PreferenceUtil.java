package com.whombang.app.common.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 *
 */

public class PreferenceUtil {

    private static SharedPreferences sharedPreferences = null;
    private static SharedPreferences.Editor editor = null;
    private static Context mcontext = null;
    public static String CAINIAO_SHOPPING = "cainiao_shopping";

    private static void GetPreferenceUtil(Context context) {
        mcontext = context;
        sharedPreferences = context.getSharedPreferences("Cainiao", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public static void putString(Context context, String key, String value) {

        if (mcontext == null || sharedPreferences == null) {
            GetPreferenceUtil(context);
        }

        editor.putString(key, value);
        editor.commit();

    }


    public static String getString(Context context, String key, String defautString) {

        if (mcontext == null || sharedPreferences == null) {
            GetPreferenceUtil(context);
        }

        return sharedPreferences.getString(key, defautString);
    }

    public static void putBoolean(Context context, String key, boolean isGuide) {
        if (mcontext == null || sharedPreferences == null) {
            GetPreferenceUtil(context);
        }
        editor.putBoolean(key, isGuide);
        editor.commit();
    }

    public static boolean getBoolean(Context context,String key,boolean defautBoolean){
        if (mcontext == null || sharedPreferences == null) {
            GetPreferenceUtil(context);
        }
        return sharedPreferences.getBoolean(key,defautBoolean);
    }
}
