package com.example.zhangxb.androidutils.utils;

import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;

/**
 * @author zhangxb
 * @since 20170511
 */
@SuppressWarnings("unused")
public final class AnimationUtil {

    private static final Interpolator DEFAULT_INTERPOLATOR = new AccelerateInterpolator();

    /**
     * Slide animations to enter a view from left.
     *
     * @param duration     the animation duration in milliseconds
     * @param interpolator the interpolator to use (pass {@code null} to use the {@link #DEFAULT_INTERPOLATOR} interpolator)
     * @return a slide transition animation
     */
    public static Animation inFromLeftAnimation(long duration, Interpolator interpolator) {
        Animation inFromLeft = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, -1.0f, Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f, Animation.RELATIVE_TO_PARENT, 0.0f
        );
        inFromLeft.setDuration(duration);
        inFromLeft.setInterpolator(interpolator == null ? DEFAULT_INTERPOLATOR : interpolator); //AccelerateInterpolator
        return inFromLeft;
    }

    /**
     * Slide animations to hide a view by sliding it to the left.
     *
     * @param duration     the animation duration in milliseconds
     * @param interpolator the interpolator to use (pass {@code null} to use the {@link #DEFAULT_INTERPOLATOR} interpolator)
     * @return a slide transition animation
     */
    public static Animation outToLeftAnimation(long duration, Interpolator interpolator) {
        Animation outToLeft = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, 0.0f, Animation.RELATIVE_TO_PARENT, -1.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f, Animation.RELATIVE_TO_PARENT, 0.0f
        );
        outToLeft.setDuration(duration);
        outToLeft.setInterpolator(interpolator == null ? DEFAULT_INTERPOLATOR : interpolator);
        return outToLeft;
    }

    /**
     * Slide animations to enter a view from right.
     *
     * @param duration     the animation duration in milliseconds
     * @param interpolator the interpolator to use (pass {@code null} to use the {@link #DEFAULT_INTERPOLATOR} interpolator)
     * @return a slide transition animation
     */
    public static Animation inFromRightAnimation(long duration, Interpolator interpolator) {
        Animation inFromRight = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, +1.0f, Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f, Animation.RELATIVE_TO_PARENT, 0.0f
        );
        inFromRight.setDuration(duration);
        inFromRight.setInterpolator(interpolator == null ? DEFAULT_INTERPOLATOR : interpolator);
        return inFromRight;
    }

    /**
     * Slide animations to hide a view by sliding it to the right
     *
     * @param duration     the animation duration in milliseconds
     * @param interpolator the interpolator to use (pass {@code null} to use the {@link #DEFAULT_INTERPOLATOR} interpolator)
     * @return a slide transition animation
     */
    public static Animation outToRightAnimation(long duration, Interpolator interpolator) {
        Animation outToRight = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, 0.0f, Animation.RELATIVE_TO_PARENT, +1.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f, Animation.RELATIVE_TO_PARENT, 0.0f
        );
        outToRight.setDuration(duration);
        outToRight.setInterpolator(interpolator == null ? DEFAULT_INTERPOLATOR : interpolator);
        return outToRight;
    }

    /**
     * Slide animations to enter a view from top.
     *
     * @param duration     the animation duration in milliseconds
     * @param interpolator the interpolator to use (pass {@code null} to use the {@link #DEFAULT_INTERPOLATOR} interpolator)
     * @return a slide transition animation
     */
    public static Animation inFromTopAnimation(long duration, Interpolator interpolator) {
        Animation inFromTop = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, 0.0f, Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, -1.0f, Animation.RELATIVE_TO_PARENT, 0.0f
        );
        inFromTop.setDuration(duration);
        inFromTop.setInterpolator(interpolator == null ? DEFAULT_INTERPOLATOR : interpolator);
        return inFromTop;
    }

    /**
     * Slide animations to hide a view by sliding it to the top
     *
     * @param duration     the animation duration in milliseconds
     * @param interpolator the interpolator to use (pass {@code null} to use the {@link #DEFAULT_INTERPOLATOR} interpolator)
     * @return a slide transition animation
     */
    public static Animation outToTopAnimation(long duration, Interpolator interpolator) {
        Animation outToTop = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, 0.0f, Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f, Animation.RELATIVE_TO_PARENT, -1.0f
        );
        outToTop.setDuration(duration);
        outToTop.setInterpolator(interpolator == null ? DEFAULT_INTERPOLATOR : interpolator);
        return outToTop;
    }

    public static Animation inFromBottomAnimation(long duration, Interpolator interpolator) {
        Animation inFromBottom = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, 0.0f, Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 1.0f, Animation.RELATIVE_TO_PARENT, 0.0f
        );
        inFromBottom.setDuration(duration);
        inFromBottom.setInterpolator(interpolator == null ? DEFAULT_INTERPOLATOR : interpolator);
        return inFromBottom;
    }

    public static Animation outToBottomAnimation(long duration, Interpolator interpolator) {
        Animation outToBottom = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, 0.0f, Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f, Animation.RELATIVE_TO_PARENT, 1.0f
        );
        outToBottom.setDuration(duration);
        outToBottom.setInterpolator(interpolator == null ? DEFAULT_INTERPOLATOR : interpolator);
        return outToBottom;
    }


    /**
     * A fade animation that will fade the subject in by changing alpha from 0 to 1.
     *
     * @param duration the animation duration in milliseconds
     * @param delay    how long to wait before starting the animation, in milliseconds
     * @return a fade animation
     */
    public static Animation fadeInAnimation(long duration, long delay) {
        Animation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setInterpolator(new DecelerateInterpolator());
        fadeIn.setDuration(duration);
        fadeIn.setStartOffset(delay);

        return fadeIn;
    }

    /**
     * A fade animation that will fade the subject out by changing alpha from 1 to 0.
     *
     * @param duration the animation duration in milliseconds
     * @param delay    how long to wait before starting the animation, in milliseconds
     * @return a fade animation
     */
    public static Animation fadeOutAnimation(long duration, long delay) {
        Animation fadeOut = new AlphaAnimation(1, 0);
        fadeOut.setInterpolator(new AccelerateInterpolator());
        fadeOut.setStartOffset(delay);
        fadeOut.setDuration(duration);

        return fadeOut;
    }

    /**
     * Creates a pair of animation that will fade in, delay, then fade out
     *
     * @param duration the animation duration in milliseconds
     * @param delay    how long to wait after fading in the subject and before starting the fade out
     * @return a fade in then out animations
     */
    public static Animation fadeInThenOutAnimation(long duration, long delay) {
        AnimationSet animation = new AnimationSet(true);
        animation.addAnimation(fadeInAnimation(duration, 0));
        animation.addAnimation(fadeOutAnimation(duration, duration + delay));
        return animation;
    }

    public static void fadeInThenOut(final View view, long duration, long delay) {
        Animation animation = fadeInThenOutAnimation(duration, delay);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                view.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                view.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

}
