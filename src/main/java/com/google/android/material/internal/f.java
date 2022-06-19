package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.util.StateSet;
import java.util.ArrayList;

/* compiled from: StateListAnimator */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<b> f7834a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private b f7835b = null;

    /* renamed from: c  reason: collision with root package name */
    ValueAnimator f7836c = null;

    /* renamed from: d  reason: collision with root package name */
    private final Animator.AnimatorListener f7837d = new a();

    /* compiled from: StateListAnimator */
    class a extends AnimatorListenerAdapter {
        a() {
        }

        public void onAnimationEnd(Animator animator) {
            f fVar = f.this;
            if (fVar.f7836c == animator) {
                fVar.f7836c = null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: StateListAnimator */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        final int[] f7839a;

        /* renamed from: b  reason: collision with root package name */
        final ValueAnimator f7840b;

        b(int[] iArr, ValueAnimator valueAnimator) {
            this.f7839a = iArr;
            this.f7840b = valueAnimator;
        }
    }

    private void b() {
        ValueAnimator valueAnimator = this.f7836c;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f7836c = null;
        }
    }

    private void e(b bVar) {
        ValueAnimator valueAnimator = bVar.f7840b;
        this.f7836c = valueAnimator;
        valueAnimator.start();
    }

    public void a(int[] iArr, ValueAnimator valueAnimator) {
        b bVar = new b(iArr, valueAnimator);
        valueAnimator.addListener(this.f7837d);
        this.f7834a.add(bVar);
    }

    public void c() {
        ValueAnimator valueAnimator = this.f7836c;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.f7836c = null;
        }
    }

    public void d(int[] iArr) {
        b bVar;
        int size = this.f7834a.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                bVar = null;
                break;
            }
            bVar = this.f7834a.get(i2);
            if (StateSet.stateSetMatches(bVar.f7839a, iArr)) {
                break;
            }
            i2++;
        }
        b bVar2 = this.f7835b;
        if (bVar != bVar2) {
            if (bVar2 != null) {
                b();
            }
            this.f7835b = bVar;
            if (bVar != null) {
                e(bVar);
            }
        }
    }
}
