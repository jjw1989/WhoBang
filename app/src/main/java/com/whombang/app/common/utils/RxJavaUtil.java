package com.whombang.app.common.utils;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * Created by sundy.jiang on 2017/12/14.
 */

public class RxJavaUtil {
    /**
     * 倒计时
     *
     * @param time
     * @return
     */
    public static Observable<Long> countdown(final long time) {
        return Observable.interval(1, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread())
                .map(new Function<Long, Long>() {
                    @Override
                    public Long apply(Long aLong) throws Exception {
                        return time - aLong;
                    }
                }).take(time + 1);
    }

    /**
     * 路由延迟跳转
     */
    private static void arouterJump() {
        Flowable.interval(3, TimeUnit.SECONDS)
                .take(1)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        Log.i("www", "long=" + aLong);

                    }
                });


    }

}
