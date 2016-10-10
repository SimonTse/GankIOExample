package com.simontse.gankio.gankioexample;

import android.app.Application;

import com.jude.beam.Beam;
import com.jude.beam.bijection.ActivityLifeCycleDelegate;
import com.jude.beam.bijection.ActivityLifeCycleDelegateProvider;
import com.jude.beam.bijection.BeamAppCompatActivity;
import com.jude.beam.expansion.BeamBaseActivity;
import com.jude.beam.expansion.list.ListConfig;
import com.jude.beam.expansion.overlay.ViewExpansionDelegate;
import com.jude.beam.expansion.overlay.ViewExpansionDelegateProvider;
import com.karumi.dexter.Dexter;
import com.simontse.gankio.gankioexample.delegate.MyActivityLifeCycleDelegate;

/**
 * Created by simon_pc on 2016/10/8.
 * Email: xiejx_op@foxmail.com
 * Description: Application DIY
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        BeamInit();
        Dexter.initialize(this);

    }

    private void BeamInit() {

        Beam.init(this);
        Beam.setViewExpansionDelegateProvider(new ViewExpansionDelegateProvider() {
            @Override
            public ViewExpansionDelegate createViewExpansionDelegate(BeamBaseActivity activity) {
                return null;
            }
        });

        ListConfig.setDefaultListConfig(
                new ListConfig()
                .setLoadmoreAble(true)
                .setRefreshAble(true)
                .setNoMoreAble(true)
                .setErrorAble(true)
                .setErrorTouchToResumeAble(true));

        Beam.setActivityLifeCycleDelegateProvider(new ActivityLifeCycleDelegateProvider() {
            @Override
            public ActivityLifeCycleDelegate createActivityLifeCycleDelegate(BeamAppCompatActivity activity) {
                return new MyActivityLifeCycleDelegate(activity);
            }
        });

    }

}
