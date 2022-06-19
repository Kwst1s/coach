package c.b.a.a.l.a;

import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import b.m.a.a.c;
import com.github.mikephil.charting.utils.Utils;

/* compiled from: BottomViewHideShowAnimation */
public class a extends AnimationSet {

    /* renamed from: b  reason: collision with root package name */
    private View f3152b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f3153c;

    /* compiled from: BottomViewHideShowAnimation */
    private class b implements Animation.AnimationListener {
        private b() {
        }

        public void onAnimationEnd(Animation animation) {
            a.this.f3152b.setVisibility(a.this.f3153c ? 0 : 8);
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
            a.this.f3152b.setVisibility(0);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(View view, boolean z, long j2) {
        super(false);
        int i2 = 0;
        this.f3153c = z;
        this.f3152b = view;
        AlphaAnimation alphaAnimation = new AlphaAnimation(z ? Utils.FLOAT_EPSILON : 1.0f, !z ? Utils.FLOAT_EPSILON : 1.0f);
        alphaAnimation.setDuration(j2);
        TranslateAnimation translateAnimation = new TranslateAnimation(Utils.FLOAT_EPSILON, Utils.FLOAT_EPSILON, (float) (z ? c(view) : 0), (float) (!z ? c(view) : i2));
        translateAnimation.setInterpolator(z ? new c() : new b.m.a.a.a());
        translateAnimation.setDuration(j2);
        addAnimation(alphaAnimation);
        addAnimation(translateAnimation);
        setAnimationListener(new b());
    }

    private int c(View view) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels - view.getTop();
    }
}
