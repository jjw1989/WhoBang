package com.whombang.app.common.utils;

/**
 * 单例工具类
 * Created by sundy.jiang on 2017/12/15.
 */

public abstract class SingletonUtils <T>{
    private T instance;

    protected abstract T newInstance();

    public final T getInstance() {
        if (instance == null) {
            synchronized (SingletonUtils.class) {
                if (instance == null) {
                    instance = newInstance();
                }
            }
        }
        return instance;
    }
}
