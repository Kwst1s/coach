package c.e.a.b.r;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Build;
import android.view.View;
import android.view.ViewAnimationUtils;
import c.e.a.b.r.d;

/* compiled from: CircularRevealCompat */
public final class a {

    /* renamed from: c.e.a.b.r.a$a  reason: collision with other inner class name */
    /* compiled from: CircularRevealCompat */
    static class C0081a extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ d f3424b;

        C0081a(d dVar) {
            this.f3424b = dVar;
        }

        public void onAnimationEnd(Animator animator) {
            this.f3424b.a();
        }

        public void onAnimationStart(Animator animator) {
            this.f3424b.b();
        }
    }

    public static Animator a(d dVar, float f2, float f3, float f4) {
        ObjectAnimator ofObject = ObjectAnimator.ofObject(dVar, d.c.f3429a, d.b.f3427b, new d.e(f2, f3, f4));
        if (Build.VERSION.SDK_INT < 21) {
            return ofObject;
        }
        d.e revealInfo = dVar.getRevealInfo();
        if (revealInfo != null) {
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal((View) dVar, (int) f2, (int) f3, revealInfo.f3433c, f4);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(ofObject, createCircularReveal);
            return animatorSet;
        }
        throw new IllegalStateException("Caller must set a non-null RevealInfo before calling this.");
    }

    public static Animator.AnimatorListener b(d dVar) {
        return new C0081a(dVar);
    }
}
