package com.github.mikephil.charting.animation;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Build;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.utils.Utils;

public class ChartAnimator {
    private ValueAnimator.AnimatorUpdateListener mListener;
    protected float mPhaseX = 1.0f;
    protected float mPhaseY = 1.0f;

    public ChartAnimator() {
    }

    public void animateX(int i2, EasingFunction easingFunction) {
        if (Build.VERSION.SDK_INT >= 11) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "phaseX", Utils.FLOAT_EPSILON, 1.0f);
            ofFloat.setInterpolator(easingFunction);
            ofFloat.setDuration((long) i2);
            ofFloat.addUpdateListener(this.mListener);
            ofFloat.start();
        }
    }

    public void animateXY(int i2, int i3, EasingFunction easingFunction, EasingFunction easingFunction2) {
        if (Build.VERSION.SDK_INT >= 11) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "phaseY", Utils.FLOAT_EPSILON, 1.0f);
            ofFloat.setInterpolator(easingFunction2);
            ofFloat.setDuration((long) i3);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, "phaseX", Utils.FLOAT_EPSILON, 1.0f);
            ofFloat2.setInterpolator(easingFunction);
            ofFloat2.setDuration((long) i2);
            if (i2 > i3) {
                ofFloat2.addUpdateListener(this.mListener);
            } else {
                ofFloat.addUpdateListener(this.mListener);
            }
            ofFloat2.start();
            ofFloat.start();
        }
    }

    public void animateY(int i2, EasingFunction easingFunction) {
        if (Build.VERSION.SDK_INT >= 11) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "phaseY", Utils.FLOAT_EPSILON, 1.0f);
            ofFloat.setInterpolator(easingFunction);
            ofFloat.setDuration((long) i2);
            ofFloat.addUpdateListener(this.mListener);
            ofFloat.start();
        }
    }

    public float getPhaseX() {
        return this.mPhaseX;
    }

    public float getPhaseY() {
        return this.mPhaseY;
    }

    public void setPhaseX(float f2) {
        this.mPhaseX = f2;
    }

    public void setPhaseY(float f2) {
        this.mPhaseY = f2;
    }

    public ChartAnimator(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.mListener = animatorUpdateListener;
    }

    public void animateX(int i2, Easing.EasingOption easingOption) {
        if (Build.VERSION.SDK_INT >= 11) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "phaseX", Utils.FLOAT_EPSILON, 1.0f);
            ofFloat.setInterpolator(Easing.getEasingFunctionFromOption(easingOption));
            ofFloat.setDuration((long) i2);
            ofFloat.addUpdateListener(this.mListener);
            ofFloat.start();
        }
    }

    public void animateY(int i2, Easing.EasingOption easingOption) {
        if (Build.VERSION.SDK_INT >= 11) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "phaseY", Utils.FLOAT_EPSILON, 1.0f);
            ofFloat.setInterpolator(Easing.getEasingFunctionFromOption(easingOption));
            ofFloat.setDuration((long) i2);
            ofFloat.addUpdateListener(this.mListener);
            ofFloat.start();
        }
    }

    public void animateXY(int i2, int i3, Easing.EasingOption easingOption, Easing.EasingOption easingOption2) {
        if (Build.VERSION.SDK_INT >= 11) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "phaseY", Utils.FLOAT_EPSILON, 1.0f);
            ofFloat.setInterpolator(Easing.getEasingFunctionFromOption(easingOption2));
            ofFloat.setDuration((long) i3);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, "phaseX", Utils.FLOAT_EPSILON, 1.0f);
            ofFloat2.setInterpolator(Easing.getEasingFunctionFromOption(easingOption));
            ofFloat2.setDuration((long) i2);
            if (i2 > i3) {
                ofFloat2.addUpdateListener(this.mListener);
            } else {
                ofFloat.addUpdateListener(this.mListener);
            }
            ofFloat2.start();
            ofFloat.start();
        }
    }

    public void animateX(int i2) {
        if (Build.VERSION.SDK_INT >= 11) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "phaseX", Utils.FLOAT_EPSILON, 1.0f);
            ofFloat.setDuration((long) i2);
            ofFloat.addUpdateListener(this.mListener);
            ofFloat.start();
        }
    }

    public void animateY(int i2) {
        if (Build.VERSION.SDK_INT >= 11) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "phaseY", Utils.FLOAT_EPSILON, 1.0f);
            ofFloat.setDuration((long) i2);
            ofFloat.addUpdateListener(this.mListener);
            ofFloat.start();
        }
    }

    public void animateXY(int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 11) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "phaseY", Utils.FLOAT_EPSILON, 1.0f);
            ofFloat.setDuration((long) i3);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, "phaseX", Utils.FLOAT_EPSILON, 1.0f);
            ofFloat2.setDuration((long) i2);
            if (i2 > i3) {
                ofFloat2.addUpdateListener(this.mListener);
            } else {
                ofFloat.addUpdateListener(this.mListener);
            }
            ofFloat2.start();
            ofFloat.start();
        }
    }
}
