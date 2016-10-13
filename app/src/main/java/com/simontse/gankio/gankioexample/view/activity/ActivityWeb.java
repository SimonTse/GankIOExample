package com.simontse.gankio.gankioexample.view.activity;

import android.os.Bundle;
import android.webkit.WebView;

import com.jude.beam.bijection.RequiresPresenter;
import com.jude.beam.expansion.BeamBaseActivity;
import com.simontse.gankio.gankioexample.R;
import com.simontse.gankio.gankioexample.presenter.presenterActivity.PresenterWeb;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by simon_pc on 2016/10/10.
 * Email: xiejx_op@foxmail.com
 * Description:
 */
@RequiresPresenter(PresenterWeb.class)
public class ActivityWeb extends BeamBaseActivity<PresenterWeb> {

    @BindView(R.id.web_view)
    WebView  webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        ButterKnife.bind(this);
    }

    public WebView getWebView() {
        return webView;
    }

}
