package com.simontse.gankio.gankioexample.presenter.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.simontse.gankio.gankioexample.config.Constant;
import com.simontse.gankio.gankioexample.view.fragment.FragmentListImage;
import com.simontse.gankio.gankioexample.view.fragment.FragmentListText;

/**
 * Created by simon_pc on 2016/10/9.
 * Email: xiejx_op@foxmail.com
 * Description:
 */

public class TabFragmentAdapter extends FragmentPagerAdapter{
    public TabFragmentAdapter(Context context,FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment  fragment;
        switch (position) {
            case  0 :
                fragment = new FragmentListImage();
                break;
            default :
                fragment = FragmentListText.getInstance(Constant.TABS[position]);
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return Constant.TABS.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return Constant.TABS[position];
    }
}
