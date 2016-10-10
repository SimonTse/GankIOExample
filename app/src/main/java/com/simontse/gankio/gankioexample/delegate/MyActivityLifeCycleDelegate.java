package com.simontse.gankio.gankioexample.delegate;

import android.os.Bundle;

import com.jude.beam.bijection.ActivityLifeCycleDelegate;
import com.jude.beam.bijection.BeamAppCompatActivity;

/**
 * Created by simon_pc on 2016/10/8.
 * Email: xiejx_op@foxmail.com
 * Description: 基类
 */

public class MyActivityLifeCycleDelegate  extends ActivityLifeCycleDelegate{
    public MyActivityLifeCycleDelegate(BeamAppCompatActivity act) {
        super(act);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            Window window = getActivity().getWindow();
//            window.setFlags(
//                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
//                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        }
    }
}
