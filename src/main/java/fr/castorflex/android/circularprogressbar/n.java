package fr.castorflex.android.circularprogressbar;

import android.animation.Animator;

/* access modifiers changed from: package-private */
/* compiled from: SimpleAnimatorListener */
public abstract class n implements Animator.AnimatorListener {

    /* renamed from: b  reason: collision with root package name */
    private boolean f9739b = false;

    /* renamed from: c  reason: collision with root package name */
    private boolean f9740c = false;

    n() {
    }

    public boolean a() {
        return this.f9739b && !this.f9740c;
    }

    /* access modifiers changed from: protected */
    public abstract void b(Animator animator);

    public void onAnimationCancel(Animator animator) {
        this.f9740c = true;
    }

    public final void onAnimationEnd(Animator animator) {
        b(animator);
        this.f9739b = false;
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
        this.f9740c = false;
        this.f9739b = true;
    }
}
