package com.simontse.gankio.gankioexample.config;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.module.GlideModule;
import com.bumptech.glide.request.target.ViewTarget;
import com.simontse.gankio.gankioexample.R;

/**
 * Created by simon_pc on 2016/10/8.
 * Email: xiejx_op@foxmail.com
 * Description:
 */

public class MyGlideMoudle  implements GlideModule{
    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
        ViewTarget.setTagId(R.id.image_tag);
    }

    @Override
    public void registerComponents(Context context, Glide glide) {

    }
}
