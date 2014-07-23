package com.lang;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;

/**
 * Created by 771407 on 7/17/2014.
 */
public class AwesomeProgressDot extends View {


    public Animation animation;
    public static final int RADIUS = 50;

    public AwesomeProgressDot(Context context) {
        super(context);
        init(context);
    }

    public AwesomeProgressDot(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public AwesomeProgressDot(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        setBackgroundDrawable(context.getResources().getDrawable(R.drawable.glow_circle));
    }


    public void startAnime() {
        Animation scaleUp = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleUp.setRepeatMode(Animation.REVERSE);
        scaleUp.setRepeatCount(Animation.INFINITE);
        scaleUp.setDuration(800);
        AnimationSet animSet = new AnimationSet(true);
        animSet.setFillEnabled(true);
        animSet.addAnimation(scaleUp);
        startAnimation(animSet);
    }


    public void startRectAnime() {
        setBackgroundDrawable(getResources().getDrawable(R.drawable.glow_rect));
        Animation scaleUp = new ScaleAnimation(0.0f, 0.0f, 0.0f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleUp.setRepeatMode(Animation.REVERSE);
        scaleUp.setRepeatCount(Animation.INFINITE);
        scaleUp.setDuration(1000);
        AnimationSet animSet = new AnimationSet(true);
        animSet.setFillEnabled(true);
        animSet.addAnimation(scaleUp);
        startAnimation(animSet);
    }

    public void startRotateAnimation() {
        setBackgroundDrawable(getResources().getDrawable(R.drawable.image_for_rotation));
        AnimationSet animationSet = new AnimationSet(true);
        RotateAnimation rotateAnimation = new RotateAnimation(0f, (360f * 1), 40 / 2, 40 / 2); // HERE
        rotateAnimation.setRepeatCount(Animation.INFINITE);
        rotateAnimation.setDuration(1000);
        animationSet.addAnimation(rotateAnimation);
        animationSet.setFillEnabled(true);
        animationSet.setInterpolator(new LinearInterpolator());
        startAnimation(animationSet);
    }

}
