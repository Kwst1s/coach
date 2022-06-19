package com.google.android.material.bottomsheet;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b.h.k.c0;
import b.h.k.d0.c;
import b.h.k.d0.f;
import b.h.k.u;
import b.j.b.c;
import c.e.a.b.j;
import c.e.a.b.k;
import c.e.a.b.l;
import com.github.mikephil.charting.utils.Utils;
import com.google.android.material.internal.k;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.c<V> {
    private static final int R = k.Widget_Design_BottomSheet_Modal;
    b.j.b.c A;
    private boolean B;
    private int C;
    private boolean D;
    private int E;
    int F;
    int G;
    WeakReference<V> H;
    WeakReference<View> I;
    private final ArrayList<f> J = new ArrayList<>();
    private VelocityTracker K;
    int L;
    private int M;
    boolean N;
    private Map<View, Integer> O;
    private int P = -1;
    private final c.AbstractC0054c Q = new d();

    /* renamed from: a  reason: collision with root package name */
    private int f7576a = 0;

    /* renamed from: b  reason: collision with root package name */
    private boolean f7577b = true;

    /* renamed from: c  reason: collision with root package name */
    private boolean f7578c = false;

    /* renamed from: d  reason: collision with root package name */
    private float f7579d;

    /* renamed from: e  reason: collision with root package name */
    private int f7580e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f7581f;

    /* renamed from: g  reason: collision with root package name */
    private int f7582g;

    /* renamed from: h  reason: collision with root package name */
    private int f7583h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f7584i;

    /* renamed from: j  reason: collision with root package name */
    private c.e.a.b.c0.g f7585j;

    /* renamed from: k  reason: collision with root package name */
    private int f7586k;
    private boolean l;
    private c.e.a.b.c0.k m;
    private boolean n;
    private BottomSheetBehavior<V>.h o = null;
    private ValueAnimator p;
    int q;
    int r;
    int s;
    float t = 0.5f;
    int u;
    float v = -1.0f;
    boolean w;
    private boolean x;
    private boolean y = true;
    int z = 4;

    /* access modifiers changed from: package-private */
    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f7587b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f7588c;

        a(View view, int i2) {
            this.f7587b = view;
            this.f7588c = i2;
        }

        public void run() {
            BottomSheetBehavior.this.o0(this.f7587b, this.f7588c);
        }
    }

    /* access modifiers changed from: package-private */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (BottomSheetBehavior.this.f7585j != null) {
                BottomSheetBehavior.this.f7585j.Y(floatValue);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public class c implements k.c {
        c() {
        }

        @Override // com.google.android.material.internal.k.c
        public c0 a(View view, c0 c0Var, k.d dVar) {
            BottomSheetBehavior.this.f7586k = c0Var.e().f2475d;
            BottomSheetBehavior.this.v0(false);
            return c0Var;
        }
    }

    class d extends c.AbstractC0054c {
        d() {
        }

        private boolean n(View view) {
            int top = view.getTop();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return top > (bottomSheetBehavior.G + bottomSheetBehavior.V()) / 2;
        }

        @Override // b.j.b.c.AbstractC0054c
        public int a(View view, int i2, int i3) {
            return view.getLeft();
        }

        @Override // b.j.b.c.AbstractC0054c
        public int b(View view, int i2, int i3) {
            int V = BottomSheetBehavior.this.V();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return b.h.g.a.b(i2, V, bottomSheetBehavior.w ? bottomSheetBehavior.G : bottomSheetBehavior.u);
        }

        @Override // b.j.b.c.AbstractC0054c
        public int e(View view) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            if (bottomSheetBehavior.w) {
                return bottomSheetBehavior.G;
            }
            return bottomSheetBehavior.u;
        }

        @Override // b.j.b.c.AbstractC0054c
        public void j(int i2) {
            if (i2 == 1 && BottomSheetBehavior.this.y) {
                BottomSheetBehavior.this.m0(1);
            }
        }

        @Override // b.j.b.c.AbstractC0054c
        public void k(View view, int i2, int i3, int i4, int i5) {
            BottomSheetBehavior.this.T(i3);
        }

        @Override // b.j.b.c.AbstractC0054c
        public void l(View view, float f2, float f3) {
            int i2;
            int i3 = 4;
            if (f3 >= Utils.FLOAT_EPSILON) {
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                if (!bottomSheetBehavior.w || !bottomSheetBehavior.q0(view, f3)) {
                    if (f3 == Utils.FLOAT_EPSILON || Math.abs(f2) > Math.abs(f3)) {
                        int top = view.getTop();
                        if (!BottomSheetBehavior.this.f7577b) {
                            BottomSheetBehavior bottomSheetBehavior2 = BottomSheetBehavior.this;
                            int i4 = bottomSheetBehavior2.s;
                            if (top < i4) {
                                if (top < Math.abs(top - bottomSheetBehavior2.u)) {
                                    i2 = BottomSheetBehavior.this.q;
                                } else {
                                    i2 = BottomSheetBehavior.this.s;
                                }
                            } else if (Math.abs(top - i4) < Math.abs(top - BottomSheetBehavior.this.u)) {
                                i2 = BottomSheetBehavior.this.s;
                            } else {
                                i2 = BottomSheetBehavior.this.u;
                                BottomSheetBehavior.this.r0(view, i3, i2, true);
                            }
                            i3 = 6;
                            BottomSheetBehavior.this.r0(view, i3, i2, true);
                        } else if (Math.abs(top - BottomSheetBehavior.this.r) < Math.abs(top - BottomSheetBehavior.this.u)) {
                            i2 = BottomSheetBehavior.this.r;
                        } else {
                            i2 = BottomSheetBehavior.this.u;
                            BottomSheetBehavior.this.r0(view, i3, i2, true);
                        }
                    } else {
                        if (BottomSheetBehavior.this.f7577b) {
                            i2 = BottomSheetBehavior.this.u;
                        } else {
                            int top2 = view.getTop();
                            if (Math.abs(top2 - BottomSheetBehavior.this.s) < Math.abs(top2 - BottomSheetBehavior.this.u)) {
                                i2 = BottomSheetBehavior.this.s;
                                i3 = 6;
                            } else {
                                i2 = BottomSheetBehavior.this.u;
                            }
                        }
                        BottomSheetBehavior.this.r0(view, i3, i2, true);
                    }
                } else if ((Math.abs(f2) < Math.abs(f3) && f3 > 500.0f) || n(view)) {
                    i2 = BottomSheetBehavior.this.G;
                    i3 = 5;
                    BottomSheetBehavior.this.r0(view, i3, i2, true);
                } else if (BottomSheetBehavior.this.f7577b) {
                    i2 = BottomSheetBehavior.this.r;
                } else if (Math.abs(view.getTop() - BottomSheetBehavior.this.q) < Math.abs(view.getTop() - BottomSheetBehavior.this.s)) {
                    i2 = BottomSheetBehavior.this.q;
                } else {
                    i2 = BottomSheetBehavior.this.s;
                    i3 = 6;
                    BottomSheetBehavior.this.r0(view, i3, i2, true);
                }
            } else if (BottomSheetBehavior.this.f7577b) {
                i2 = BottomSheetBehavior.this.r;
            } else {
                int top3 = view.getTop();
                BottomSheetBehavior bottomSheetBehavior3 = BottomSheetBehavior.this;
                int i5 = bottomSheetBehavior3.s;
                if (top3 > i5) {
                    i2 = i5;
                    i3 = 6;
                    BottomSheetBehavior.this.r0(view, i3, i2, true);
                }
                i2 = bottomSheetBehavior3.q;
            }
            i3 = 3;
            BottomSheetBehavior.this.r0(view, i3, i2, true);
        }

        @Override // b.j.b.c.AbstractC0054c
        public boolean m(View view, int i2) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            int i3 = bottomSheetBehavior.z;
            if (i3 == 1 || bottomSheetBehavior.N) {
                return false;
            }
            if (i3 == 3 && bottomSheetBehavior.L == i2) {
                WeakReference<View> weakReference = bottomSheetBehavior.I;
                View view2 = weakReference != null ? weakReference.get() : null;
                if (view2 != null && view2.canScrollVertically(-1)) {
                    return false;
                }
            }
            WeakReference<V> weakReference2 = BottomSheetBehavior.this.H;
            if (weakReference2 == null || weakReference2.get() != view) {
                return false;
            }
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public class e implements b.h.k.d0.f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f7593a;

        e(int i2) {
            this.f7593a = i2;
        }

        @Override // b.h.k.d0.f
        public boolean a(View view, f.a aVar) {
            BottomSheetBehavior.this.l0(this.f7593a);
            return true;
        }
    }

    public static abstract class f {
        public abstract void a(View view, float f2);

        public abstract void b(View view, int i2);
    }

    /* access modifiers changed from: private */
    public class h implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final View f7600b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f7601c;

        /* renamed from: d  reason: collision with root package name */
        int f7602d;

        h(View view, int i2) {
            this.f7600b = view;
            this.f7602d = i2;
        }

        public void run() {
            b.j.b.c cVar = BottomSheetBehavior.this.A;
            if (cVar == null || !cVar.n(true)) {
                BottomSheetBehavior.this.m0(this.f7602d);
            } else {
                u.e0(this.f7600b, this);
            }
            this.f7601c = false;
        }
    }

    public BottomSheetBehavior() {
    }

    private int L(V v2, int i2, int i3) {
        return u.b(v2, v2.getResources().getString(i2), P(i3));
    }

    private void M() {
        int O2 = O();
        if (this.f7577b) {
            this.u = Math.max(this.G - O2, this.r);
        } else {
            this.u = this.G - O2;
        }
    }

    private void N() {
        this.s = (int) (((float) this.G) * (1.0f - this.t));
    }

    private int O() {
        int i2;
        if (this.f7581f) {
            return Math.min(Math.max(this.f7582g, this.G - ((this.F * 9) / 16)), this.E);
        }
        if (this.l || (i2 = this.f7586k) <= 0) {
            return this.f7580e;
        }
        return Math.max(this.f7580e, i2 + this.f7583h);
    }

    private b.h.k.d0.f P(int i2) {
        return new e(i2);
    }

    private void Q(Context context, AttributeSet attributeSet, boolean z2) {
        R(context, attributeSet, z2, null);
    }

    private void R(Context context, AttributeSet attributeSet, boolean z2, ColorStateList colorStateList) {
        if (this.f7584i) {
            this.m = c.e.a.b.c0.k.e(context, attributeSet, c.e.a.b.b.bottomSheetStyle, R).m();
            c.e.a.b.c0.g gVar = new c.e.a.b.c0.g(this.m);
            this.f7585j = gVar;
            gVar.M(context);
            if (!z2 || colorStateList == null) {
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(16842801, typedValue, true);
                this.f7585j.setTint(typedValue.data);
                return;
            }
            this.f7585j.X(colorStateList);
        }
    }

    private void S() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(Utils.FLOAT_EPSILON, 1.0f);
        this.p = ofFloat;
        ofFloat.setDuration(500L);
        this.p.addUpdateListener(new b());
    }

    private float W() {
        VelocityTracker velocityTracker = this.K;
        if (velocityTracker == null) {
            return Utils.FLOAT_EPSILON;
        }
        velocityTracker.computeCurrentVelocity(1000, this.f7579d);
        return this.K.getYVelocity(this.L);
    }

    private void Y(V v2, c.a aVar, int i2) {
        u.i0(v2, aVar, null, P(i2));
    }

    private void Z() {
        this.L = -1;
        VelocityTracker velocityTracker = this.K;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.K = null;
        }
    }

    private void a0(g gVar) {
        int i2 = this.f7576a;
        if (i2 != 0) {
            if (i2 == -1 || (i2 & 1) == 1) {
                this.f7580e = gVar.f7596e;
            }
            if (i2 == -1 || (i2 & 2) == 2) {
                this.f7577b = gVar.f7597f;
            }
            if (i2 == -1 || (i2 & 4) == 4) {
                this.w = gVar.f7598g;
            }
            if (i2 == -1 || (i2 & 8) == 8) {
                this.x = gVar.f7599h;
            }
        }
    }

    private void n0(View view) {
        if (Build.VERSION.SDK_INT >= 29 && !X() && !this.f7581f) {
            com.google.android.material.internal.k.a(view, new c());
        }
    }

    private void p0(int i2) {
        V v2 = this.H.get();
        if (v2 != null) {
            ViewParent parent = v2.getParent();
            if (parent == null || !parent.isLayoutRequested() || !u.R(v2)) {
                o0(v2, i2);
            } else {
                v2.post(new a(v2, i2));
            }
        }
    }

    private void s0() {
        V v2;
        WeakReference<V> weakReference = this.H;
        if (weakReference != null && (v2 = weakReference.get()) != null) {
            u.g0(v2, 524288);
            u.g0(v2, 262144);
            u.g0(v2, 1048576);
            int i2 = this.P;
            if (i2 != -1) {
                u.g0(v2, i2);
            }
            int i3 = 6;
            if (this.z != 6) {
                this.P = L(v2, j.bottomsheet_action_expand_halfway, 6);
            }
            if (this.w && this.z != 5) {
                Y(v2, c.a.l, 5);
            }
            int i4 = this.z;
            if (i4 == 3) {
                if (this.f7577b) {
                    i3 = 4;
                }
                Y(v2, c.a.f2646k, i3);
            } else if (i4 == 4) {
                if (this.f7577b) {
                    i3 = 3;
                }
                Y(v2, c.a.f2645j, i3);
            } else if (i4 == 6) {
                Y(v2, c.a.f2646k, 4);
                Y(v2, c.a.f2645j, 3);
            }
        }
    }

    private void t0(int i2) {
        ValueAnimator valueAnimator;
        if (i2 != 2) {
            boolean z2 = i2 == 3;
            if (this.n != z2) {
                this.n = z2;
                if (this.f7585j != null && (valueAnimator = this.p) != null) {
                    if (valueAnimator.isRunning()) {
                        this.p.reverse();
                        return;
                    }
                    float f2 = z2 ? Utils.FLOAT_EPSILON : 1.0f;
                    this.p.setFloatValues(1.0f - f2, f2);
                    this.p.start();
                }
            }
        }
    }

    private void u0(boolean z2) {
        Map<View, Integer> map;
        WeakReference<V> weakReference = this.H;
        if (weakReference != null) {
            ViewParent parent = weakReference.get().getParent();
            if (parent instanceof CoordinatorLayout) {
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
                int childCount = coordinatorLayout.getChildCount();
                if (Build.VERSION.SDK_INT >= 16 && z2) {
                    if (this.O == null) {
                        this.O = new HashMap(childCount);
                    } else {
                        return;
                    }
                }
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = coordinatorLayout.getChildAt(i2);
                    if (childAt != this.H.get()) {
                        if (z2) {
                            if (Build.VERSION.SDK_INT >= 16) {
                                this.O.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                            }
                            if (this.f7578c) {
                                u.x0(childAt, 4);
                            }
                        } else if (this.f7578c && (map = this.O) != null && map.containsKey(childAt)) {
                            u.x0(childAt, this.O.get(childAt).intValue());
                        }
                    }
                }
                if (!z2) {
                    this.O = null;
                } else if (this.f7578c) {
                    this.H.get().sendAccessibilityEvent(8);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void v0(boolean z2) {
        V v2;
        if (this.H != null) {
            M();
            if (this.z == 4 && (v2 = this.H.get()) != null) {
                if (z2) {
                    p0(this.z);
                } else {
                    v2.requestLayout();
                }
            }
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean A(CoordinatorLayout coordinatorLayout, V v2, View view, View view2, int i2, int i3) {
        this.C = 0;
        this.D = false;
        if ((i2 & 2) != 0) {
            return true;
        }
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void C(CoordinatorLayout coordinatorLayout, V v2, View view, int i2) {
        int i3;
        int i4 = 3;
        if (v2.getTop() == V()) {
            m0(3);
            return;
        }
        WeakReference<View> weakReference = this.I;
        if (weakReference != null && view == weakReference.get() && this.D) {
            if (this.C > 0) {
                if (this.f7577b) {
                    i3 = this.r;
                } else {
                    int top = v2.getTop();
                    int i5 = this.s;
                    if (top > i5) {
                        i3 = i5;
                    } else {
                        i3 = this.q;
                    }
                }
                r0(v2, i4, i3, false);
                this.D = false;
            } else if (!this.w || !q0(v2, W())) {
                if (this.C == 0) {
                    int top2 = v2.getTop();
                    if (!this.f7577b) {
                        int i6 = this.s;
                        if (top2 < i6) {
                            if (top2 < Math.abs(top2 - this.u)) {
                                i3 = this.q;
                                r0(v2, i4, i3, false);
                                this.D = false;
                            }
                            i3 = this.s;
                        } else if (Math.abs(top2 - i6) < Math.abs(top2 - this.u)) {
                            i3 = this.s;
                        } else {
                            i3 = this.u;
                        }
                    } else if (Math.abs(top2 - this.r) < Math.abs(top2 - this.u)) {
                        i3 = this.r;
                        r0(v2, i4, i3, false);
                        this.D = false;
                    } else {
                        i3 = this.u;
                    }
                } else if (this.f7577b) {
                    i3 = this.u;
                } else {
                    int top3 = v2.getTop();
                    if (Math.abs(top3 - this.s) < Math.abs(top3 - this.u)) {
                        i3 = this.s;
                    } else {
                        i3 = this.u;
                    }
                }
                i4 = 4;
                r0(v2, i4, i3, false);
                this.D = false;
            } else {
                i3 = this.G;
                i4 = 5;
                r0(v2, i4, i3, false);
                this.D = false;
            }
            i4 = 6;
            r0(v2, i4, i3, false);
            this.D = false;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean D(CoordinatorLayout coordinatorLayout, V v2, MotionEvent motionEvent) {
        if (!v2.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.z == 1 && actionMasked == 0) {
            return true;
        }
        b.j.b.c cVar = this.A;
        if (cVar != null) {
            cVar.F(motionEvent);
        }
        if (actionMasked == 0) {
            Z();
        }
        if (this.K == null) {
            this.K = VelocityTracker.obtain();
        }
        this.K.addMovement(motionEvent);
        if (this.A != null && actionMasked == 2 && !this.B && Math.abs(((float) this.M) - motionEvent.getY()) > ((float) this.A.z())) {
            this.A.c(v2, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.B;
    }

    /* access modifiers changed from: package-private */
    public void T(int i2) {
        float f2;
        float f3;
        V v2 = this.H.get();
        if (!(v2 == null || this.J.isEmpty())) {
            int i3 = this.u;
            if (i2 > i3 || i3 == V()) {
                int i4 = this.u;
                f2 = (float) (i4 - i2);
                f3 = (float) (this.G - i4);
            } else {
                int i5 = this.u;
                f2 = (float) (i5 - i2);
                f3 = (float) (i5 - V());
            }
            float f4 = f2 / f3;
            for (int i6 = 0; i6 < this.J.size(); i6++) {
                this.J.get(i6).a(v2, f4);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public View U(View view) {
        if (u.T(view)) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View U = U(viewGroup.getChildAt(i2));
            if (U != null) {
                return U;
            }
        }
        return null;
    }

    public int V() {
        return this.f7577b ? this.r : this.q;
    }

    public boolean X() {
        return this.l;
    }

    public void b0(boolean z2) {
        this.y = z2;
    }

    public void c0(int i2) {
        if (i2 >= 0) {
            this.q = i2;
            return;
        }
        throw new IllegalArgumentException("offset must be greater than or equal to 0");
    }

    public void d0(boolean z2) {
        if (this.f7577b != z2) {
            this.f7577b = z2;
            if (this.H != null) {
                M();
            }
            m0((!this.f7577b || this.z != 6) ? this.z : 3);
            s0();
        }
    }

    public void e0(boolean z2) {
        this.l = z2;
    }

    public void f0(float f2) {
        if (f2 <= Utils.FLOAT_EPSILON || f2 >= 1.0f) {
            throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
        }
        this.t = f2;
        if (this.H != null) {
            N();
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void g(CoordinatorLayout.f fVar) {
        super.g(fVar);
        this.H = null;
        this.A = null;
    }

    public void g0(boolean z2) {
        if (this.w != z2) {
            this.w = z2;
            if (!z2 && this.z == 5) {
                l0(4);
            }
            s0();
        }
    }

    public void h0(int i2) {
        i0(i2, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0021  */
    /* JADX WARNING: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void i0(int r4, boolean r5) {
        /*
            r3 = this;
            r0 = 1
            r1 = 0
            r2 = -1
            if (r4 != r2) goto L_0x000c
            boolean r4 = r3.f7581f
            if (r4 != 0) goto L_0x0015
            r3.f7581f = r0
            goto L_0x001f
        L_0x000c:
            boolean r2 = r3.f7581f
            if (r2 != 0) goto L_0x0017
            int r2 = r3.f7580e
            if (r2 == r4) goto L_0x0015
            goto L_0x0017
        L_0x0015:
            r0 = 0
            goto L_0x001f
        L_0x0017:
            r3.f7581f = r1
            int r4 = java.lang.Math.max(r1, r4)
            r3.f7580e = r4
        L_0x001f:
            if (r0 == 0) goto L_0x0024
            r3.v0(r5)
        L_0x0024:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.i0(int, boolean):void");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void j() {
        super.j();
        this.H = null;
        this.A = null;
    }

    public void j0(int i2) {
        this.f7576a = i2;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean k(CoordinatorLayout coordinatorLayout, V v2, MotionEvent motionEvent) {
        b.j.b.c cVar;
        if (!v2.isShown() || !this.y) {
            this.B = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            Z();
        }
        if (this.K == null) {
            this.K = VelocityTracker.obtain();
        }
        this.K.addMovement(motionEvent);
        View view = null;
        if (actionMasked == 0) {
            int x2 = (int) motionEvent.getX();
            this.M = (int) motionEvent.getY();
            if (this.z != 2) {
                WeakReference<View> weakReference = this.I;
                View view2 = weakReference != null ? weakReference.get() : null;
                if (view2 != null && coordinatorLayout.B(view2, x2, this.M)) {
                    this.L = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.N = true;
                }
            }
            this.B = this.L == -1 && !coordinatorLayout.B(v2, x2, this.M);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.N = false;
            this.L = -1;
            if (this.B) {
                this.B = false;
                return false;
            }
        }
        if (!this.B && (cVar = this.A) != null && cVar.O(motionEvent)) {
            return true;
        }
        WeakReference<View> weakReference2 = this.I;
        if (weakReference2 != null) {
            view = weakReference2.get();
        }
        if (actionMasked != 2 || view == null || this.B || this.z == 1 || coordinatorLayout.B(view, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.A == null || Math.abs(((float) this.M) - motionEvent.getY()) <= ((float) this.A.z())) {
            return false;
        }
        return true;
    }

    public void k0(boolean z2) {
        this.x = z2;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean l(CoordinatorLayout coordinatorLayout, V v2, int i2) {
        c.e.a.b.c0.g gVar;
        if (u.y(coordinatorLayout) && !u.y(v2)) {
            v2.setFitsSystemWindows(true);
        }
        if (this.H == null) {
            this.f7582g = coordinatorLayout.getResources().getDimensionPixelSize(c.e.a.b.d.design_bottom_sheet_peek_height_min);
            n0(v2);
            this.H = new WeakReference<>(v2);
            if (this.f7584i && (gVar = this.f7585j) != null) {
                u.q0(v2, gVar);
            }
            c.e.a.b.c0.g gVar2 = this.f7585j;
            if (gVar2 != null) {
                float f2 = this.v;
                if (f2 == -1.0f) {
                    f2 = u.w(v2);
                }
                gVar2.W(f2);
                boolean z2 = this.z == 3;
                this.n = z2;
                this.f7585j.Y(z2 ? Utils.FLOAT_EPSILON : 1.0f);
            }
            s0();
            if (u.z(v2) == 0) {
                u.x0(v2, 1);
            }
        }
        if (this.A == null) {
            this.A = b.j.b.c.p(coordinatorLayout, this.Q);
        }
        int top = v2.getTop();
        coordinatorLayout.I(v2, i2);
        this.F = coordinatorLayout.getWidth();
        this.G = coordinatorLayout.getHeight();
        int height = v2.getHeight();
        this.E = height;
        this.r = Math.max(0, this.G - height);
        N();
        M();
        int i3 = this.z;
        if (i3 == 3) {
            u.Y(v2, V());
        } else if (i3 == 6) {
            u.Y(v2, this.s);
        } else if (this.w && i3 == 5) {
            u.Y(v2, this.G);
        } else if (i3 == 4) {
            u.Y(v2, this.u);
        } else if (i3 == 1 || i3 == 2) {
            u.Y(v2, top - v2.getTop());
        }
        this.I = new WeakReference<>(U(v2));
        return true;
    }

    public void l0(int i2) {
        if (i2 != this.z) {
            if (this.H != null) {
                p0(i2);
            } else if (i2 == 4 || i2 == 3 || i2 == 6 || (this.w && i2 == 5)) {
                this.z = i2;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void m0(int i2) {
        V v2;
        if (this.z != i2) {
            this.z = i2;
            WeakReference<V> weakReference = this.H;
            if (!(weakReference == null || (v2 = weakReference.get()) == null)) {
                if (i2 == 3) {
                    u0(true);
                } else if (i2 == 6 || i2 == 5 || i2 == 4) {
                    u0(false);
                }
                t0(i2);
                for (int i3 = 0; i3 < this.J.size(); i3++) {
                    this.J.get(i3).b(v2, i2);
                }
                s0();
            }
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean o(CoordinatorLayout coordinatorLayout, V v2, View view, float f2, float f3) {
        WeakReference<View> weakReference = this.I;
        if (weakReference == null || view != weakReference.get()) {
            return false;
        }
        if (this.z != 3 || super.o(coordinatorLayout, v2, view, f2, f3)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void o0(View view, int i2) {
        int i3;
        int i4;
        if (i2 == 4) {
            i3 = this.u;
        } else if (i2 == 6) {
            int i5 = this.s;
            if (!this.f7577b || i5 > (i4 = this.r)) {
                i3 = i5;
            } else {
                i3 = i4;
                i2 = 3;
            }
        } else if (i2 == 3) {
            i3 = V();
        } else if (!this.w || i2 != 5) {
            throw new IllegalArgumentException("Illegal state argument: " + i2);
        } else {
            i3 = this.G;
        }
        r0(view, i2, i3, false);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void q(CoordinatorLayout coordinatorLayout, V v2, View view, int i2, int i3, int[] iArr, int i4) {
        if (i4 != 1) {
            WeakReference<View> weakReference = this.I;
            if (view == (weakReference != null ? weakReference.get() : null)) {
                int top = v2.getTop();
                int i5 = top - i3;
                if (i3 > 0) {
                    if (i5 < V()) {
                        iArr[1] = top - V();
                        u.Y(v2, -iArr[1]);
                        m0(3);
                    } else if (this.y) {
                        iArr[1] = i3;
                        u.Y(v2, -i3);
                        m0(1);
                    } else {
                        return;
                    }
                } else if (i3 < 0 && !view.canScrollVertically(-1)) {
                    int i6 = this.u;
                    if (i5 > i6 && !this.w) {
                        iArr[1] = top - i6;
                        u.Y(v2, -iArr[1]);
                        m0(4);
                    } else if (this.y) {
                        iArr[1] = i3;
                        u.Y(v2, -i3);
                        m0(1);
                    } else {
                        return;
                    }
                }
                T(v2.getTop());
                this.C = i3;
                this.D = true;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean q0(View view, float f2) {
        if (this.x) {
            return true;
        }
        if (view.getTop() < this.u) {
            return false;
        }
        if (Math.abs((((float) view.getTop()) + (f2 * 0.1f)) - ((float) this.u)) / ((float) O()) > 0.5f) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void r0(View view, int i2, int i3, boolean z2) {
        b.j.b.c cVar = this.A;
        if (cVar != null && (!z2 ? cVar.P(view, view.getLeft(), i3) : cVar.N(view.getLeft(), i3))) {
            m0(2);
            t0(i2);
            if (this.o == null) {
                this.o = new h(view, i2);
            }
            if (!((h) this.o).f7601c) {
                BottomSheetBehavior<V>.h hVar = this.o;
                hVar.f7602d = i2;
                u.e0(view, hVar);
                ((h) this.o).f7601c = true;
                return;
            }
            this.o.f7602d = i2;
            return;
        }
        m0(i2);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void t(CoordinatorLayout coordinatorLayout, V v2, View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void x(CoordinatorLayout coordinatorLayout, V v2, Parcelable parcelable) {
        g gVar = (g) parcelable;
        super.x(coordinatorLayout, v2, gVar.g());
        a0(gVar);
        int i2 = gVar.f7595d;
        if (i2 == 1 || i2 == 2) {
            this.z = 4;
        } else {
            this.z = i2;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public Parcelable y(CoordinatorLayout coordinatorLayout, V v2) {
        return new g(super.y(coordinatorLayout, v2), (BottomSheetBehavior<?>) this);
    }

    /* access modifiers changed from: protected */
    public static class g extends b.j.a.a {
        public static final Parcelable.Creator<g> CREATOR = new a();

        /* renamed from: d  reason: collision with root package name */
        final int f7595d;

        /* renamed from: e  reason: collision with root package name */
        int f7596e;

        /* renamed from: f  reason: collision with root package name */
        boolean f7597f;

        /* renamed from: g  reason: collision with root package name */
        boolean f7598g;

        /* renamed from: h  reason: collision with root package name */
        boolean f7599h;

        static class a implements Parcelable.ClassLoaderCreator<g> {
            a() {
            }

            /* renamed from: a */
            public g createFromParcel(Parcel parcel) {
                return new g(parcel, (ClassLoader) null);
            }

            /* renamed from: b */
            public g createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new g(parcel, classLoader);
            }

            /* renamed from: c */
            public g[] newArray(int i2) {
                return new g[i2];
            }
        }

        public g(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f7595d = parcel.readInt();
            this.f7596e = parcel.readInt();
            boolean z = false;
            this.f7597f = parcel.readInt() == 1;
            this.f7598g = parcel.readInt() == 1;
            this.f7599h = parcel.readInt() == 1 ? true : z;
        }

        @Override // b.j.a.a
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f7595d);
            parcel.writeInt(this.f7596e);
            parcel.writeInt(this.f7597f ? 1 : 0);
            parcel.writeInt(this.f7598g ? 1 : 0);
            parcel.writeInt(this.f7599h ? 1 : 0);
        }

        public g(Parcelable parcelable, BottomSheetBehavior<?> bottomSheetBehavior) {
            super(parcelable);
            this.f7595d = bottomSheetBehavior.z;
            this.f7596e = ((BottomSheetBehavior) bottomSheetBehavior).f7580e;
            this.f7597f = ((BottomSheetBehavior) bottomSheetBehavior).f7577b;
            this.f7598g = bottomSheetBehavior.w;
            this.f7599h = ((BottomSheetBehavior) bottomSheetBehavior).x;
        }
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int i2;
        this.f7583h = context.getResources().getDimensionPixelSize(c.e.a.b.d.mtrl_min_touch_target_size);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.l);
        this.f7584i = obtainStyledAttributes.hasValue(l.x);
        int i3 = l.n;
        boolean hasValue = obtainStyledAttributes.hasValue(i3);
        if (hasValue) {
            R(context, attributeSet, hasValue, c.e.a.b.z.c.a(context, obtainStyledAttributes, i3));
        } else {
            Q(context, attributeSet, hasValue);
        }
        S();
        if (Build.VERSION.SDK_INT >= 21) {
            this.v = obtainStyledAttributes.getDimension(l.m, -1.0f);
        }
        int i4 = l.t;
        TypedValue peekValue = obtainStyledAttributes.peekValue(i4);
        if (peekValue == null || (i2 = peekValue.data) != -1) {
            h0(obtainStyledAttributes.getDimensionPixelSize(i4, -1));
        } else {
            h0(i2);
        }
        g0(obtainStyledAttributes.getBoolean(l.s, false));
        e0(obtainStyledAttributes.getBoolean(l.w, false));
        d0(obtainStyledAttributes.getBoolean(l.q, true));
        k0(obtainStyledAttributes.getBoolean(l.v, false));
        b0(obtainStyledAttributes.getBoolean(l.o, true));
        j0(obtainStyledAttributes.getInt(l.u, 0));
        f0(obtainStyledAttributes.getFloat(l.r, 0.5f));
        int i5 = l.p;
        TypedValue peekValue2 = obtainStyledAttributes.peekValue(i5);
        if (peekValue2 == null || peekValue2.type != 16) {
            c0(obtainStyledAttributes.getDimensionPixelOffset(i5, 0));
        } else {
            c0(peekValue2.data);
        }
        obtainStyledAttributes.recycle();
        this.f7579d = (float) ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }
}
