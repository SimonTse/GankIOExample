package com.simontse.gankio.gankioexample.presenter.presenterActivity;

import android.Manifest;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.jude.beam.expansion.data.BeamDataActivityPresenter;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;
import com.simontse.gankio.gankioexample.R;
import com.simontse.gankio.gankioexample.entity.Result;
import com.simontse.gankio.gankioexample.view.activity.ActivityPhoto;
import com.simontse.gankio.library.utils.BitmapUtils;
import com.simontse.gankio.library.utils.NoDoubleMenuItemClickListener;
import com.simontse.gankio.library.utils.SnackBarUtils;
import com.simontse.gankio.library.utils.StringUtils;
import com.simontse.gankio.library.utils.io.FilenameUtils;

import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by simon_pc on 2016/10/11.
 * Email: xiejx_op@foxmail.com
 * Description:
 */

public class PresenterPhoto extends BeamDataActivityPresenter<ActivityPhoto, Result> {

    PhotoViewAttacher  mAttacher;
    private boolean mIsHidden = false;


    @Override
    protected void onCreateView(@NonNull ActivityPhoto view) {
        super.onCreateView(view);

        initToolBar();
        initPhoto();

    }

    private void initPhoto() {

        Glide.with(getView()).load(getData().getUrl()).asBitmap().thumbnail(0.1f).error(R.mipmap.ic_launcher)
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                        getView().getImageView().setImageBitmap(resource);
                        mAttacher = new PhotoViewAttacher(getView().getImageView());
                        mAttacher.update();
                        mAttacher.setOnViewTapListener(new PhotoViewAttacher.OnViewTapListener() {
                            @Override
                            public void onViewTap(View view, float x, float y) {
                                hideOrShowToolbar();
                            }
                        });
                    }
                });
    }

    //点击屏幕显示/隐藏toolbar
    public void hideOrShowToolbar() {
        getView().getAppBarLayout().animate()
                .translationY(mIsHidden ? 0 : -getView().getAppBarLayout().getHeight())
                .setInterpolator(new DecelerateInterpolator(2))
                .start();

        mIsHidden = !mIsHidden;
    }


    private void initToolBar() {

        getView().getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getView().getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_white_24dp);
        getView().getSupportActionBar().setTitle(getData().getDesc());
        getView().getToolbar().setOnMenuItemClickListener(new NoDoubleMenuItemClickListener() {
            @Override
            public void onNoDoubleClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.savePhoto:
                        checkPremission();
                        break;
                }
            }
        });
    }

    //获取权限
    private void checkPremission() {
        Dexter.checkPermission(new PermissionListener() {
            @Override
            public void onPermissionGranted(PermissionGrantedResponse response) {
                savePhoto();
            }

            @Override
            public void onPermissionDenied(PermissionDeniedResponse response) {
                SnackBarUtils.makeShort(getView().getToolbar(), "没有权限保存图片").danger();
            }

            @Override
            public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
                token.continuePermissionRequest();
            }
        }, Manifest.permission.WRITE_EXTERNAL_STORAGE);
    }

    //保存图片
    private void savePhoto() {

    String photoPath = BitmapUtils.saveImageToGallery(getView(),((BitmapDrawable)getView().getImageView().getDrawable()).getBitmap(),
            FilenameUtils.getName(getData().getUrl()));

        if(StringUtils.notBlankAndNull(photoPath))
            SnackBarUtils.makeShort(getView().getToolbar(), "图片位置:" + photoPath).info();
        else
            SnackBarUtils.makeShort(getView().getToolbar(),"保存失败").danger();

    }

}
