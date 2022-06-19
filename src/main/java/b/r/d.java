package b.r;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import b.h.k.u;
import com.github.mikephil.charting.utils.Utils;

/* compiled from: Fade */
public class d extends j0 {

    /* access modifiers changed from: package-private */
    /* compiled from: Fade */
    public class a extends n {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f2858b;

        a(d dVar, View view) {
            this.f2858b = view;
        }

        @Override // b.r.m.f
        public void e(m mVar) {
            c0.g(this.f2858b, 1.0f);
            c0.a(this.f2858b);
            mVar.Q(this);
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Fade */
    public static class b extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        private final View f2859b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f2860c = false;

        b(View view) {
            this.f2859b = view;
        }

        public void onAnimationEnd(Animator animator) {
            c0.g(this.f2859b, 1.0f);
            if (this.f2860c) {
                this.f2859b.setLayerType(0, null);
            }
        }

        public void onAnimationStart(Animator animator) {
            if (u.O(this.f2859b) && this.f2859b.getLayerType() == 0) {
                this.f2860c = true;
                this.f2859b.setLayerType(2, null);
            }
        }
    }

    public d(int i2) {
        j0(i2);
    }

    private Animator k0(View view, float f2, float f3) {
        if (f2 == f3) {
            return null;
        }
        c0.g(view, f2);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, c0.f2857b, f3);
        ofFloat.addListener(new b(view));
        a(new a(this, view));
        return ofFloat;
    }

    private static float l0(s sVar, float f2) {
        Float f3;
        return (sVar == null || (f3 = (Float) sVar.f2936a.get("android:fade:transitionAlpha")) == null) ? f2 : f3.floatValue();
    }

    @Override // b.r.j0
    public Animator f0(ViewGroup viewGroup, View view, s sVar, s sVar2) {
        float f2 = Utils.FLOAT_EPSILON;
        float l0 = l0(sVar, Utils.FLOAT_EPSILON);
        if (l0 != 1.0f) {
            f2 = l0;
        }
        return k0(view, f2, 1.0f);
    }

    @Override // b.r.j0
    public Animator h0(ViewGroup viewGroup, View view, s sVar, s sVar2) {
        c0.e(view);
        return k0(view, l0(sVar, 1.0f), Utils.FLOAT_EPSILON);
    }

    @Override // b.r.j0, b.r.m
    public void j(s sVar) {
        super.j(sVar);
        sVar.f2936a.put("android:fade:transitionAlpha", Float.valueOf(c0.c(sVar.f2937b)));
    }
}
