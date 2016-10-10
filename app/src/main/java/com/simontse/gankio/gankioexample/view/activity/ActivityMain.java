package com.simontse.gankio.gankioexample.view.activity;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;

import com.jude.beam.bijection.RequiresPresenter;
import com.jude.beam.expansion.BeamBaseActivity;
import com.simontse.gankio.gankioexample.R;
import com.simontse.gankio.gankioexample.presenter.presenterActivity.PresenterMain;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by simon_pc on 2016/10/9.
 * Email: xiejx_op@foxmail.com
 * Description:主页
 */
@RequiresPresenter(PresenterMain.class)
public class ActivityMain extends BeamBaseActivity<PresenterMain> {

    @BindView(R.id.main_tabs)
    TabLayout mainTabs;
    @BindView(R.id.main_vp)
    ViewPager mainVp;
    @BindView(R.id.main_coordinator_layout)
    CoordinatorLayout mainCoordinatorLayout;
    @BindView(R.id.main_navigationView)
    NavigationView mainNavigationView;
    @BindView(R.id.main_drawerLayout)
    DrawerLayout mainDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setupDrawerContent();
    }

    private void setupDrawerContent() {
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this, mainDrawerLayout, getToolbar(), R.string.app_name, R.string.app_name);
        mDrawerToggle.syncState();
        mainDrawerLayout.addDrawerListener(mDrawerToggle);
        mainNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                item.setCheckable(true);
                mainDrawerLayout.closeDrawers();
                return true;
            }
        });

    }

    public ViewPager getViewPager() {
        return mainVp;
    }

    public TabLayout getTabLayout() {
        return mainTabs;
    }

}
