package c.b.a.a.l.a;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import b.m.a.a.c;
import com.github.mikephil.charting.utils.Utils;

/* compiled from: TopViewHideShowAnimation */
public class b extends AnimationSet {

    /* renamed from: b  reason: collision with root package name */
    private View f3155b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f3156c;

    /* renamed from: c.b.a.a.l.a.b$b  reason: collision with other inner class name */
    /* compiled from: TopViewHideShowAnimation */
    private class animation.Animation$AnimationListenerC0073b implements Animation.AnimationListener {
        private animation.Animation$AnimationListenerC0073b() {
        }

        public void onAnimationEnd(Animation animation) {
            b.this.f3155b.setVisibility(b.this.f3156c ? 0 : 8);
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
            b.this.f3155b.setVisibility(0);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(View view, boolean z, long j2) {
        super(false);
        int i2 = 0;
        this.f3156c = z;
        this.f3155b = view;
        AlphaAnimation alphaAnimation = new AlphaAnimation(z ? Utils.FLOAT_EPSILON : 1.0f, !z ? Utils.FLOAT_EPSILON : 1.0f);
        alphaAnimation.setDuration(j2);
        TranslateAnimation translateAnimation = new TranslateAnimation(Utils.FLOAT_EPSILON, Utils.FLOAT_EPSILON, (float) (z ? -view.getHeight() : 0), (float) (!z ? -view.getHeight() : i2));
        translateAnimation.setInterpolator(z ? new c() : new b.m.a.a.a());
        translateAnimation.setDuration(j2);
        addAnimation(alphaAnimation);
        addAnimation(translateAnimation);
        setAnimationListener(new animation.Animation$AnimationListenerC0073b());
    }
}
