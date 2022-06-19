package b.h.k;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

/* compiled from: ViewPropertyAnimatorCompat */
public final class y {

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<View> f2697a;

    /* renamed from: b  reason: collision with root package name */
    Runnable f2698b = null;

    /* renamed from: c  reason: collision with root package name */
    Runnable f2699c = null;

    /* renamed from: d  reason: collision with root package name */
    int f2700d = -1;

    /* access modifiers changed from: package-private */
    /* compiled from: ViewPropertyAnimatorCompat */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ z f2701b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f2702c;

        a(y yVar, z zVar, View view) {
            this.f2701b = zVar;
            this.f2702c = view;
        }

        public void onAnimationCancel(Animator animator) {
            this.f2701b.a(this.f2702c);
        }

        public void onAnimationEnd(Animator animator) {
            this.f2701b.b(this.f2702c);
        }

        public void onAnimationStart(Animator animator) {
            this.f2701b.c(this.f2702c);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: ViewPropertyAnimatorCompat */
    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b0 f2703b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f2704c;

        b(y yVar, b0 b0Var, View view) {
            this.f2703b = b0Var;
            this.f2704c = view;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f2703b.a(this.f2704c);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: ViewPropertyAnimatorCompat */
    public static class c implements z {

        /* renamed from: a  reason: collision with root package name */
        y f2705a;

        /* renamed from: b  reason: collision with root package name */
        boolean f2706b;

        c(y yVar) {
            this.f2705a = yVar;
        }

        @Override // b.h.k.z
        public void a(View view) {
            Object tag = view.getTag(2113929216);
            z zVar = tag instanceof z ? (z) tag : null;
            if (zVar != null) {
                zVar.a(view);
            }
        }

        @Override // b.h.k.z
        @SuppressLint({"WrongConstant"})
        public void b(View view) {
            int i2 = this.f2705a.f2700d;
            z zVar = null;
            if (i2 > -1) {
                view.setLayerType(i2, null);
                this.f2705a.f2700d = -1;
            }
            if (Build.VERSION.SDK_INT >= 16 || !this.f2706b) {
                y yVar = this.f2705a;
                Runnable runnable = yVar.f2699c;
                if (runnable != null) {
                    yVar.f2699c = null;
                    runnable.run();
                }
                Object tag = view.getTag(2113929216);
                if (tag instanceof z) {
                    zVar = (z) tag;
                }
                if (zVar != null) {
                    zVar.b(view);
                }
                this.f2706b = true;
            }
        }

        @Override // b.h.k.z
        public void c(View view) {
            this.f2706b = false;
            z zVar = null;
            if (this.f2705a.f2700d > -1) {
                view.setLayerType(2, null);
            }
            y yVar = this.f2705a;
            Runnable runnable = yVar.f2698b;
            if (runnable != null) {
                yVar.f2698b = null;
                runnable.run();
            }
            Object tag = view.getTag(2113929216);
            if (tag instanceof z) {
                zVar = (z) tag;
            }
            if (zVar != null) {
                zVar.c(view);
            }
        }
    }

    y(View view) {
        this.f2697a = new WeakReference<>(view);
    }

    private void g(View view, z zVar) {
        if (zVar != null) {
            view.animate().setListener(new a(this, zVar, view));
        } else {
            view.animate().setListener(null);
        }
    }

    public y a(float f2) {
        View view = this.f2697a.get();
        if (view != null) {
            view.animate().alpha(f2);
        }
        return this;
    }

    public void b() {
        View view = this.f2697a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public long c() {
        View view = this.f2697a.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0;
    }

    public y d(long j2) {
        View view = this.f2697a.get();
        if (view != null) {
            view.animate().setDuration(j2);
        }
        return this;
    }

    public y e(Interpolator interpolator) {
        View view = this.f2697a.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    public y f(z zVar) {
        View view = this.f2697a.get();
        if (view != null) {
            if (Build.VERSION.SDK_INT >= 16) {
                g(view, zVar);
            } else {
                view.setTag(2113929216, zVar);
                g(view, new c(this));
            }
        }
        return this;
    }

    public y h(long j2) {
        View view = this.f2697a.get();
        if (view != null) {
            view.animate().setStartDelay(j2);
        }
        return this;
    }

    public y i(b0 b0Var) {
        View view = this.f2697a.get();
        if (view != null && Build.VERSION.SDK_INT >= 19) {
            b bVar = null;
            if (b0Var != null) {
                bVar = new b(this, b0Var, view);
            }
            view.animate().setUpdateListener(bVar);
        }
        return this;
    }

    public void j() {
        View view = this.f2697a.get();
        if (view != null) {
            view.animate().start();
        }
    }

    public y k(float f2) {
        View view = this.f2697a.get();
        if (view != null) {
            view.animate().translationY(f2);
        }
        return this;
    }

    public y l(Runnable runnable) {
        View view = this.f2697a.get();
        if (view != null) {
            if (Build.VERSION.SDK_INT >= 16) {
                view.animate().withEndAction(runnable);
            } else {
                g(view, new c(this));
                this.f2699c = runnable;
            }
        }
        return this;
    }
}
