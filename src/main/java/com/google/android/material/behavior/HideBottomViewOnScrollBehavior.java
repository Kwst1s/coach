package com.google.android.material.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.c<V> {

    /* renamed from: a  reason: collision with root package name */
    private int f7527a = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f7528b = 2;

    /* renamed from: c  reason: collision with root package name */
    private int f7529c = 0;

    /* renamed from: d  reason: collision with root package name */
    private ViewPropertyAnimator f7530d;

    /* access modifiers changed from: package-private */
    public class a extends AnimatorListenerAdapter {
        a() {
        }

        public void onAnimationEnd(Animator animator) {
            HideBottomViewOnScrollBehavior.this.f7530d = null;
        }
    }

    public HideBottomViewOnScrollBehavior() {
    }

    private void F(V v, int i2, long j2, TimeInterpolator timeInterpolator) {
        this.f7530d = v.animate().translationY((float) i2).setInterpolator(timeInterpolator).setDuration(j2).setListener(new a());
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean A(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i2, int i3) {
        return i2 == 2;
    }

    public void G(V v, int i2) {
        this.f7529c = i2;
        if (this.f7528b == 1) {
            v.setTranslationY((float) (this.f7527a + i2));
        }
    }

    public void H(V v) {
        if (this.f7528b != 1) {
            ViewPropertyAnimator viewPropertyAnimator = this.f7530d;
            if (viewPropertyAnimator != null) {
                viewPropertyAnimator.cancel();
                v.clearAnimation();
            }
            this.f7528b = 1;
            F(v, this.f7527a + this.f7529c, 175, c.e.a.b.m.a.f3377c);
        }
    }

    public void I(V v) {
        if (this.f7528b != 2) {
            ViewPropertyAnimator viewPropertyAnimator = this.f7530d;
            if (viewPropertyAnimator != null) {
                viewPropertyAnimator.cancel();
                v.clearAnimation();
            }
            this.f7528b = 2;
            F(v, 0, 225, c.e.a.b.m.a.f3378d);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean l(CoordinatorLayout coordinatorLayout, V v, int i2) {
        this.f7527a = v.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) v.getLayoutParams()).bottomMargin;
        return super.l(coordinatorLayout, v, i2);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void t(CoordinatorLayout coordinatorLayout, V v, View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
        if (i3 > 0) {
            H(v);
        } else if (i3 < 0) {
            I(v);
        }
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
