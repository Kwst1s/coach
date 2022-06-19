package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import androidx.core.os.b;
import androidx.fragment.app.v;
import b.h.k.r;

/* access modifiers changed from: package-private */
/* compiled from: FragmentAnim */
public class e {

    /* access modifiers changed from: package-private */
    /* compiled from: FragmentAnim */
    public static class a implements b.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Fragment f1253a;

        a(Fragment fragment) {
            this.f1253a = fragment;
        }

        @Override // androidx.core.os.b.a
        public void a() {
            if (this.f1253a.r() != null) {
                View r = this.f1253a.r();
                this.f1253a.t1(null);
                r.clearAnimation();
            }
            this.f1253a.u1(null);
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: FragmentAnim */
    public static class b implements Animation.AnimationListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ViewGroup f1254b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Fragment f1255c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ v.g f1256d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ androidx.core.os.b f1257e;

        /* compiled from: FragmentAnim */
        class a implements Runnable {
            a() {
            }

            public void run() {
                if (b.this.f1255c.r() != null) {
                    b.this.f1255c.t1(null);
                    b bVar = b.this;
                    bVar.f1256d.a(bVar.f1255c, bVar.f1257e);
                }
            }
        }

        b(ViewGroup viewGroup, Fragment fragment, v.g gVar, androidx.core.os.b bVar) {
            this.f1254b = viewGroup;
            this.f1255c = fragment;
            this.f1256d = gVar;
            this.f1257e = bVar;
        }

        public void onAnimationEnd(Animation animation) {
            this.f1254b.post(new a());
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: FragmentAnim */
    public static class c extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ViewGroup f1259b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f1260c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Fragment f1261d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ v.g f1262e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ androidx.core.os.b f1263f;

        c(ViewGroup viewGroup, View view, Fragment fragment, v.g gVar, androidx.core.os.b bVar) {
            this.f1259b = viewGroup;
            this.f1260c = view;
            this.f1261d = fragment;
            this.f1262e = gVar;
            this.f1263f = bVar;
        }

        public void onAnimationEnd(Animator animator) {
            this.f1259b.endViewTransition(this.f1260c);
            Animator s = this.f1261d.s();
            this.f1261d.u1(null);
            if (s != null && this.f1259b.indexOfChild(this.f1260c) < 0) {
                this.f1262e.a(this.f1261d, this.f1263f);
            }
        }
    }

    static void a(Fragment fragment, d dVar, v.g gVar) {
        View view = fragment.H;
        ViewGroup viewGroup = fragment.G;
        viewGroup.startViewTransition(view);
        androidx.core.os.b bVar = new androidx.core.os.b();
        bVar.c(new a(fragment));
        gVar.b(fragment, bVar);
        if (dVar.f1264a != null) {
            RunnableC0020e eVar = new RunnableC0020e(dVar.f1264a, viewGroup, view);
            fragment.t1(fragment.H);
            eVar.setAnimationListener(new b(viewGroup, fragment, gVar, bVar));
            fragment.H.startAnimation(eVar);
            return;
        }
        Animator animator = dVar.f1265b;
        fragment.u1(animator);
        animator.addListener(new c(viewGroup, view, fragment, gVar, bVar));
        animator.setTarget(fragment.H);
        animator.start();
    }

    static d b(Context context, f fVar, Fragment fragment, boolean z) {
        int c2;
        int G = fragment.G();
        int F = fragment.F();
        boolean z2 = false;
        fragment.z1(0);
        View b2 = fVar.b(fragment.x);
        if (b2 != null) {
            int i2 = b.l.b.visible_removing_fragment_view_tag;
            if (b2.getTag(i2) != null) {
                b2.setTag(i2, null);
            }
        }
        ViewGroup viewGroup = fragment.G;
        if (viewGroup != null && viewGroup.getLayoutTransition() != null) {
            return null;
        }
        Animation p0 = fragment.p0(G, z, F);
        if (p0 != null) {
            return new d(p0);
        }
        Animator q0 = fragment.q0(G, z, F);
        if (q0 != null) {
            return new d(q0);
        }
        if (F != 0) {
            boolean equals = "anim".equals(context.getResources().getResourceTypeName(F));
            if (equals) {
                try {
                    Animation loadAnimation = AnimationUtils.loadAnimation(context, F);
                    if (loadAnimation != null) {
                        return new d(loadAnimation);
                    }
                    z2 = true;
                } catch (Resources.NotFoundException e2) {
                    throw e2;
                } catch (RuntimeException unused) {
                }
            }
            if (!z2) {
                try {
                    Animator loadAnimator = AnimatorInflater.loadAnimator(context, F);
                    if (loadAnimator != null) {
                        return new d(loadAnimator);
                    }
                } catch (RuntimeException e3) {
                    if (!equals) {
                        Animation loadAnimation2 = AnimationUtils.loadAnimation(context, F);
                        if (loadAnimation2 != null) {
                            return new d(loadAnimation2);
                        }
                    } else {
                        throw e3;
                    }
                }
            }
        }
        if (G != 0 && (c2 = c(G, z)) >= 0) {
            return new d(AnimationUtils.loadAnimation(context, c2));
        }
        return null;
    }

    private static int c(int i2, boolean z) {
        if (i2 == 4097) {
            return z ? b.l.a.fragment_open_enter : b.l.a.fragment_open_exit;
        }
        if (i2 == 4099) {
            return z ? b.l.a.fragment_fade_enter : b.l.a.fragment_fade_exit;
        }
        if (i2 != 8194) {
            return -1;
        }
        return z ? b.l.a.fragment_close_enter : b.l.a.fragment_close_exit;
    }

    /* access modifiers changed from: package-private */
    /* compiled from: FragmentAnim */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public final Animation f1264a;

        /* renamed from: b  reason: collision with root package name */
        public final Animator f1265b;

        d(Animation animation) {
            this.f1264a = animation;
            this.f1265b = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }

        d(Animator animator) {
            this.f1264a = null;
            this.f1265b = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: androidx.fragment.app.e$e  reason: collision with other inner class name */
    /* compiled from: FragmentAnim */
    public static class RunnableC0020e extends AnimationSet implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final ViewGroup f1266b;

        /* renamed from: c  reason: collision with root package name */
        private final View f1267c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f1268d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f1269e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f1270f = true;

        RunnableC0020e(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.f1266b = viewGroup;
            this.f1267c = view;
            addAnimation(animation);
            viewGroup.post(this);
        }

        public boolean getTransformation(long j2, Transformation transformation) {
            this.f1270f = true;
            if (this.f1268d) {
                return !this.f1269e;
            }
            if (!super.getTransformation(j2, transformation)) {
                this.f1268d = true;
                r.a(this.f1266b, this);
            }
            return true;
        }

        public void run() {
            if (this.f1268d || !this.f1270f) {
                this.f1266b.endViewTransition(this.f1267c);
                this.f1269e = true;
                return;
            }
            this.f1270f = false;
            this.f1266b.post(this);
        }

        public boolean getTransformation(long j2, Transformation transformation, float f2) {
            this.f1270f = true;
            if (this.f1268d) {
                return !this.f1269e;
            }
            if (!super.getTransformation(j2, transformation, f2)) {
                this.f1268d = true;
                r.a(this.f1266b, this);
            }
            return true;
        }
    }
}
