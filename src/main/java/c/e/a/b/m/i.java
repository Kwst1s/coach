package c.e.a.b.m;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

/* compiled from: MotionTiming */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private long f3390a = 0;

    /* renamed from: b  reason: collision with root package name */
    private long f3391b = 300;

    /* renamed from: c  reason: collision with root package name */
    private TimeInterpolator f3392c = null;

    /* renamed from: d  reason: collision with root package name */
    private int f3393d = 0;

    /* renamed from: e  reason: collision with root package name */
    private int f3394e = 1;

    public i(long j2, long j3) {
        this.f3390a = j2;
        this.f3391b = j3;
    }

    static i b(ValueAnimator valueAnimator) {
        i iVar = new i(valueAnimator.getStartDelay(), valueAnimator.getDuration(), f(valueAnimator));
        iVar.f3393d = valueAnimator.getRepeatCount();
        iVar.f3394e = valueAnimator.getRepeatMode();
        return iVar;
    }

    private static TimeInterpolator f(ValueAnimator valueAnimator) {
        TimeInterpolator interpolator = valueAnimator.getInterpolator();
        if ((interpolator instanceof AccelerateDecelerateInterpolator) || interpolator == null) {
            return a.f3376b;
        }
        if (interpolator instanceof AccelerateInterpolator) {
            return a.f3377c;
        }
        return interpolator instanceof DecelerateInterpolator ? a.f3378d : interpolator;
    }

    public void a(Animator animator) {
        animator.setStartDelay(c());
        animator.setDuration(d());
        animator.setInterpolator(e());
        if (animator instanceof ValueAnimator) {
            ValueAnimator valueAnimator = (ValueAnimator) animator;
            valueAnimator.setRepeatCount(g());
            valueAnimator.setRepeatMode(h());
        }
    }

    public long c() {
        return this.f3390a;
    }

    public long d() {
        return this.f3391b;
    }

    public TimeInterpolator e() {
        TimeInterpolator timeInterpolator = this.f3392c;
        return timeInterpolator != null ? timeInterpolator : a.f3376b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        if (c() == iVar.c() && d() == iVar.d() && g() == iVar.g() && h() == iVar.h()) {
            return e().getClass().equals(iVar.e().getClass());
        }
        return false;
    }

    public int g() {
        return this.f3393d;
    }

    public int h() {
        return this.f3394e;
    }

    public int hashCode() {
        return (((((((((int) (c() ^ (c() >>> 32))) * 31) + ((int) (d() ^ (d() >>> 32)))) * 31) + e().getClass().hashCode()) * 31) + g()) * 31) + h();
    }

    public String toString() {
        return '\n' + i.class.getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " delay: " + c() + " duration: " + d() + " interpolator: " + e().getClass() + " repeatCount: " + g() + " repeatMode: " + h() + "}\n";
    }

    public i(long j2, long j3, TimeInterpolator timeInterpolator) {
        this.f3390a = j2;
        this.f3391b = j3;
        this.f3392c = timeInterpolator;
    }
}
