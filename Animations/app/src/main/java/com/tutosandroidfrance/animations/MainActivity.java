package com.tutosandroidfrance.animations;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.image)
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.alpha)
    public void animateAlpha() {
        ObjectAnimator animator =ObjectAnimator.ofFloat(image, "alpha", 1, 0.1f, 1).setDuration(1000);
        animator.setInterpolator(new AccelerateDecelerateInterpolator());
        animator.start();
    }

    @OnClick(R.id.scale)
    public void animateScale() {
        ObjectAnimator.ofFloat(image, "scaleX", 1, 10, 1).setDuration(1500).start();
        ObjectAnimator.ofFloat(image, "scaleY", 1, 0.5f, 1).setDuration(1500).start();
    }

    @OnClick(R.id.translatedX)
    public void animateTranslationX() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(image, "translationX", 0, 100, 0).setDuration(800);
        animator.setInterpolator(new BounceInterpolator());
        animator.start();
    }

    @OnClick(R.id.translatedY)
    public void animateTranslationY() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(image, "translationY", 0, -100, 200, 0).setDuration(800);
        animator.setInterpolator(new DecelerateInterpolator());
        animator.start();
    }

    @OnClick(R.id.together)
     public void animateTogether() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(
                ObjectAnimator.ofFloat(image, "translationX", 0, 100, -100, 0),
                ObjectAnimator.ofFloat(image, "translationY", 0, 100, -100, 0),
                ObjectAnimator.ofFloat(image, "alpha", 1, 0.5f, 1)
        );
        animatorSet.setDuration(1000);
        animatorSet.setInterpolator(new AccelerateInterpolator());
        animatorSet.start();
    }

    @OnClick(R.id.sequentially)
    public void animateSequentially() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(
                ObjectAnimator.ofFloat(image, "translationX", 0, 100, -100, 0),
                ObjectAnimator.ofFloat(image, "translationY", 0, 100, -100, 0),
                ObjectAnimator.ofFloat(image, "alpha", 1, 0.5f, 1)
        );
        animatorSet.setDuration(1000);
        animatorSet.setInterpolator(new AccelerateInterpolator());
        animatorSet.start();
    }

    @OnClick(R.id.newApi)
    public void animateNewApi() {

        ((View) image).setAlpha(1);
        image.setTranslationY(0);
        image.setTranslationX(0);

        image.animate().setDuration(1000)
                .translationX(100)
                .translationY(100)
                .alpha(0.5f)

                .setInterpolator(new AccelerateInterpolator())
                .start();
    }

}
