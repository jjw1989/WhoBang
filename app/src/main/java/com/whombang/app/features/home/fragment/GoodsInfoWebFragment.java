package com.whombang.app.features.home.fragment;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.whombang.app.R;
import com.whombang.app.common.base.BaseFragment;


/**
 * 图文详情webview的Fragment
 */
public class GoodsInfoWebFragment extends BaseFragment {
    public WebView wv_detail;
    private WebSettings webSettings;
    String url;
    @Override
    protected int bindLayout() {
        return R.layout.wb_fragment_item_info_web_layout;
    }

    @Override
    protected void initInjector() {

    }

    public void initWebView(View rootView) {
        wv_detail = rootView.findViewById(R.id.wv_detail);
        wv_detail.setFocusable(false);
        wv_detail.loadUrl(url);
        webSettings = wv_detail.getSettings();
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setBuiltInZoomControls(false);
        webSettings.setLoadsImagesAutomatically(true);
        webSettings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        webSettings.setBlockNetworkImage(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        wv_detail.setWebViewClient(new GoodsDetailWebViewClient());
    }

    @Override
    public void initData(Bundle bundle) {
         url=bundle.getString("url");
    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        initWebView(contentView);
    }

    @Override
    public void doBusiness() {

    }

    private class GoodsDetailWebViewClient extends WebViewClient {
        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            webSettings.setBlockNetworkImage(false);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return true;
        }
    }
}
