package com.whombang.app.common.base;

import android.content.Context;
import android.support.multidex.MultiDexApplication;

import com.alibaba.android.arouter.launcher.ARouter;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.whombang.app.common.net.EasyHttp;
import com.whombang.app.common.net.cache.converter.SerializableDiskConverter;
import com.whombang.app.common.net.utils.HttpLog;
import com.whombang.app.mvp.component.ApplicationComponent;
import com.whombang.app.mvp.component.DaggerApplicationComponent;
import com.whombang.app.mvp.module.ApplicationModule;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/**
 * Description:全局初始化和属性在此定义
 * Company:
 * Created by 蒋建伟 on 2017/11/10.
 */

public class BaseApplication extends MultiDexApplication {
    private boolean isDebug=true;
    private BaseApplication baseApplication;
    private  ApplicationComponent appComponent;

    private static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        baseApplication=this;
        Fresco.initialize(this);
        initArouter();
        initInjector();
        initHttp();
    }

    private void initHttp() {
        EasyHttp.init(this);

        //这里涉及到安全我把url去掉了，demo都是调试通的
        String Url = "http://47.104.105.135:8080/WhomBangServer/";


        //设置请求头
       // HttpHeaders headers = new HttpHeaders();
       // headers.put("User-Agent", SystemInfoUtils.getUserAgent(this, AppConstant.APPID));
        //设置请求参数
       // HttpParams params = new HttpParams();
        //params.put("appId", AppConstant.APPID);
        EasyHttp.getInstance()
                .debug("whombang", true)
                .setReadTimeOut(60 * 1000)
                .setWriteTimeOut(60 * 1000)
                .setConnectTimeout(60 * 1000)
                .setRetryCount(3)//默认网络不好自动重试3次
                .setRetryDelay(500)//每次延时500ms重试
                .setRetryIncreaseDelay(500)//每次延时叠加500ms
                .setBaseUrl(Url)
                .setCacheDiskConverter(new SerializableDiskConverter())//默认缓存使用序列化转化
                .setCacheMaxSize(50 * 1024 * 1024)//设置缓存大小为50M
                .setCacheVersion(1)//缓存版本为1
                .setHostnameVerifier(new UnSafeHostnameVerifier(Url))//全局访问规则
                .setCertificates();//信任所有证书
                //.addConverterFactory(GsonConverterFactory.create(gson))//本框架没有采用Retrofit的Gson转化，所以不用配置
               // .addCommonHeaders(headers)//设置全局公共头
               // .addCommonParams(params)//设置全局公共参数
               // .addInterceptor(new CustomSignInterceptor());//添加参数签名拦截器
        //.addInterceptor(new HeTInterceptor());//处理自己业务的拦截器
    }
    public class UnSafeHostnameVerifier implements HostnameVerifier {
        private String host;

        public UnSafeHostnameVerifier(String host) {
            this.host = host;
            HttpLog.i("###############　UnSafeHostnameVerifier " + host);
        }

        @Override
        public boolean verify(String hostname, SSLSession session) {
            HttpLog.i("############### verify " + hostname + " " + this.host);
            if (this.host == null || "".equals(this.host) || !this.host.contains(hostname))
                return false;
            return true;
        }
    }

    /**
     * 初始化注射器
     */
    private void initInjector() {
        appComponent = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
    }

    /**
     * 初始化路由管理
     */
    private void initArouter() {
        if (isDebug) {                  // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();          // 打印日志
            ARouter.openDebug();        // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this); // 尽可能早，推荐在Application中初始化
    }

    public ApplicationComponent getAppComponent() {
        return appComponent;
    }

    public BaseApplication getBaseApplication() {
        return baseApplication;
    }
}
