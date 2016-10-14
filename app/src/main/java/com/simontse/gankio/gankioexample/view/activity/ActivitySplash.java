package com.simontse.gankio.gankioexample.view.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.ImageView;
import android.widget.TextView;

import com.jude.beam.bijection.BeamAppCompatActivity;
import com.simontse.gankio.gankioexample.R;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by simon_pc on 2016/10/14.
 * Email: xiejx_op@foxmail.com
 * Description: 广告页
 */

public class ActivitySplash extends BeamAppCompatActivity {

    private static final int ANIMATION_DURATION = 2500;
    private static final float SCALE_END = 1.15F;

    private static final int[]  WELCOME_ARRAY = {
            R.mipmap.icon_welcome1,
            R.mipmap.icon_welcome2,
            R.mipmap.icon_welcome3,
            R.mipmap.icon_welcome4
    };

    @BindView(R.id.iv_splash)
    ImageView  mSplashImage;

    @BindView(R.id.tv_splash_name)
    TextView  mNameTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);

        Random random = new Random(SystemClock.elapsedRealtime());
        mSplashImage.setImageResource(WELCOME_ARRAY[random.nextInt(WELCOME_ARRAY.length)]);

        animateImg();
    }

    private void animateImg() {
        ObjectAnimator animatorX = ObjectAnimator.ofFloat(mSplashImage, "scaleX", 1f, SCALE_END);
        ObjectAnimator animatorY = ObjectAnimator.ofFloat(mSplashImage, "scaleY", 1f, SCALE_END);

        AnimatorSet  animSet = new AnimatorSet();
        animSet.setDuration(ANIMATION_DURATION).play(animatorX).with(animatorY);
        animSet.start();

        animSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                Intent intent = new Intent(ActivitySplash.this, ActivityMain.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
