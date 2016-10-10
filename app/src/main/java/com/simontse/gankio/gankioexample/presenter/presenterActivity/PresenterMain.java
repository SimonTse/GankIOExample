package com.simontse.gankio.gankioexample.presenter.presenterActivity;


import android.Manifest;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;

import com.jude.beam.expansion.BeamBasePresenter;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.simontse.gankio.gankioexample.R;
import com.simontse.gankio.gankioexample.presenter.adapter.TabFragmentAdapter;
import com.simontse.gankio.gankioexample.view.activity.ActivityMain;

import java.util.List;

/**
 * Created by simon_pc on 2016/10/9.
 * Email: xiejx_op@foxmail.com
 * Description:
 */

public class PresenterMain extends BeamBasePresenter<ActivityMain>{

    private TabFragmentAdapter adapter;
    private FragmentManager fragmentManager;
    private int item = -1;

    @Override
    protected void onCreateView(@NonNull ActivityMain view) {
        super.onCreateView(view);
        view.getTabLayout().setSelectedTabIndicatorColor(view.getResources().getColor(R.color.colorAccent));
        fragmentManager = view.getSupportFragmentManager();
        replaceFragment(0);
        checkPermission();
    }

    private void replaceFragment(int position) {
        item = position;
        adapter = new TabFragmentAdapter(getView(), fragmentManager);
        getView().getViewPager().setAdapter(adapter);
        getView().getTabLayout().setupWithViewPager(getView().getViewPager());
    }

    public void setupDrawerContent(NavigationView navigationView, final DrawerLayout drawerLayout) {

    }


    private void checkPermission() {
        if (Build.VERSION.SDK_INT < 23) {
            return;
        }

        try {
            Dexter.checkPermissionsOnSameThread(new MultiplePermissionsListener() {
                @Override
                public void onPermissionsChecked(MultiplePermissionsReport report) {

                }

                @Override
                public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                    token.continuePermissionRequest();
                }
            }, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
