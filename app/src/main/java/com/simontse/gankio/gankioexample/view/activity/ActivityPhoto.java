package com.simontse.gankio.gankioexample.view.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.jude.beam.bijection.RequiresPresenter;
import com.jude.beam.expansion.data.BeamDataActivity;
import com.simontse.gankio.gankioexample.R;
import com.simontse.gankio.gankioexample.entity.Result;
import com.simontse.gankio.gankioexample.presenter.presenterActivity.PresenterPhoto;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by simon_pc on 2016/10/10.
 * Email: xiejx_op@foxmail.com
 * Description: 图片详情展示页
 */
@RequiresPresenter(PresenterPhoto.class)
public class ActivityPhoto extends BeamDataActivity<PresenterPhoto,Result> {

    @BindView(R.id.photo)
    ImageView mPhoto;
    @BindView(R.id.appbar_layout)
    AppBarLayout mAppBarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
        ButterKnife.bind(this);
    }


    public ImageView getImageView() {
        return  mPhoto;
    }

    public AppBarLayout getAppBarLayout() {
        return mAppBarLayout;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_photo,menu);
        return  true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.savePhoto) {
            return  true;
        }

        return super.onOptionsItemSelected(item);
    }
}
