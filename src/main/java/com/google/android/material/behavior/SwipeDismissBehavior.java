package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b.h.k.d0.c;
import b.h.k.d0.f;
import b.h.k.u;
import b.j.b.c;
import com.github.mikephil.charting.utils.Utils;

public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.c<V> {

    /* renamed from: a  reason: collision with root package name */
    b.j.b.c f7532a;

    /* renamed from: b  reason: collision with root package name */
    c f7533b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f7534c;

    /* renamed from: d  reason: collision with root package name */
    private float f7535d = Utils.FLOAT_EPSILON;

    /* renamed from: e  reason: collision with root package name */
    private boolean f7536e;

    /* renamed from: f  reason: collision with root package name */
    int f7537f = 2;

    /* renamed from: g  reason: collision with root package name */
    float f7538g = 0.5f;

    /* renamed from: h  reason: collision with root package name */
    float f7539h = Utils.FLOAT_EPSILON;

    /* renamed from: i  reason: collision with root package name */
    float f7540i = 0.5f;

    /* renamed from: j  reason: collision with root package name */
    private final c.AbstractC0054c f7541j = new a();

    class a extends c.AbstractC0054c {

        /* renamed from: a  reason: collision with root package name */
        private int f7542a;

        /* renamed from: b  reason: collision with root package name */
        private int f7543b = -1;

        a() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:15:0x0025 A[ORIG_RETURN, RETURN, SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x0034 A[ORIG_RETURN, RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private boolean n(android.view.View r6, float r7) {
            /*
                r5 = this;
                r0 = 0
                r1 = 0
                r2 = 1
                int r3 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
                if (r3 == 0) goto L_0x0036
                int r6 = b.h.k.u.B(r6)
                if (r6 != r2) goto L_0x000f
                r6 = 1
                goto L_0x0010
            L_0x000f:
                r6 = 0
            L_0x0010:
                com.google.android.material.behavior.SwipeDismissBehavior r3 = com.google.android.material.behavior.SwipeDismissBehavior.this
                int r3 = r3.f7537f
                r4 = 2
                if (r3 != r4) goto L_0x0018
                return r2
            L_0x0018:
                if (r3 != 0) goto L_0x0027
                if (r6 == 0) goto L_0x0021
                int r6 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
                if (r6 >= 0) goto L_0x0026
                goto L_0x0025
            L_0x0021:
                int r6 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
                if (r6 <= 0) goto L_0x0026
            L_0x0025:
                r1 = 1
            L_0x0026:
                return r1
            L_0x0027:
                if (r3 != r2) goto L_0x0035
                if (r6 == 0) goto L_0x0030
                int r6 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
                if (r6 <= 0) goto L_0x0035
                goto L_0x0034
            L_0x0030:
                int r6 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
                if (r6 >= 0) goto L_0x0035
            L_0x0034:
                r1 = 1
            L_0x0035:
                return r1
            L_0x0036:
                int r7 = r6.getLeft()
                int r0 = r5.f7542a
                int r7 = r7 - r0
                int r6 = r6.getWidth()
                float r6 = (float) r6
                com.google.android.material.behavior.SwipeDismissBehavior r0 = com.google.android.material.behavior.SwipeDismissBehavior.this
                float r0 = r0.f7538g
                float r6 = r6 * r0
                int r6 = java.lang.Math.round(r6)
                int r7 = java.lang.Math.abs(r7)
                if (r7 < r6) goto L_0x0053
                r1 = 1
            L_0x0053:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.behavior.SwipeDismissBehavior.a.n(android.view.View, float):boolean");
        }

        @Override // b.j.b.c.AbstractC0054c
        public int a(View view, int i2, int i3) {
            int i4;
            int i5;
            int width;
            boolean z = u.B(view) == 1;
            int i6 = SwipeDismissBehavior.this.f7537f;
            if (i6 != 0) {
                if (i6 != 1) {
                    i4 = this.f7542a - view.getWidth();
                    i5 = view.getWidth() + this.f7542a;
                } else if (z) {
                    i4 = this.f7542a;
                    width = view.getWidth();
                } else {
                    i4 = this.f7542a - view.getWidth();
                    i5 = this.f7542a;
                }
                return SwipeDismissBehavior.G(i4, i2, i5);
            } else if (z) {
                i4 = this.f7542a - view.getWidth();
                i5 = this.f7542a;
                return SwipeDismissBehavior.G(i4, i2, i5);
            } else {
                i4 = this.f7542a;
                width = view.getWidth();
            }
            i5 = width + i4;
            return SwipeDismissBehavior.G(i4, i2, i5);
        }

        @Override // b.j.b.c.AbstractC0054c
        public int b(View view, int i2, int i3) {
            return view.getTop();
        }

        @Override // b.j.b.c.AbstractC0054c
        public int d(View view) {
            return view.getWidth();
        }

        @Override // b.j.b.c.AbstractC0054c
        public void i(View view, int i2) {
            this.f7543b = i2;
            this.f7542a = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }

        @Override // b.j.b.c.AbstractC0054c
        public void j(int i2) {
            c cVar = SwipeDismissBehavior.this.f7533b;
            if (cVar != null) {
                cVar.a(i2);
            }
        }

        @Override // b.j.b.c.AbstractC0054c
        public void k(View view, int i2, int i3, int i4, int i5) {
            float width = ((float) this.f7542a) + (((float) view.getWidth()) * SwipeDismissBehavior.this.f7539h);
            float width2 = ((float) this.f7542a) + (((float) view.getWidth()) * SwipeDismissBehavior.this.f7540i);
            float f2 = (float) i2;
            if (f2 <= width) {
                view.setAlpha(1.0f);
            } else if (f2 >= width2) {
                view.setAlpha(Utils.FLOAT_EPSILON);
            } else {
                view.setAlpha(SwipeDismissBehavior.F(Utils.FLOAT_EPSILON, 1.0f - SwipeDismissBehavior.I(width, width2, f2), 1.0f));
            }
        }

        @Override // b.j.b.c.AbstractC0054c
        public void l(View view, float f2, float f3) {
            boolean z;
            int i2;
            c cVar;
            this.f7543b = -1;
            int width = view.getWidth();
            if (n(view, f2)) {
                int left = view.getLeft();
                int i3 = this.f7542a;
                i2 = left < i3 ? i3 - width : i3 + width;
                z = true;
            } else {
                i2 = this.f7542a;
                z = false;
            }
            if (SwipeDismissBehavior.this.f7532a.N(i2, view.getTop())) {
                u.e0(view, new d(view, z));
            } else if (z && (cVar = SwipeDismissBehavior.this.f7533b) != null) {
                cVar.b(view);
            }
        }

        @Override // b.j.b.c.AbstractC0054c
        public boolean m(View view, int i2) {
            int i3 = this.f7543b;
            return (i3 == -1 || i3 == i2) && SwipeDismissBehavior.this.E(view);
        }
    }

    /* access modifiers changed from: package-private */
    public class b implements f {
        b() {
        }

        @Override // b.h.k.d0.f
        public boolean a(View view, f.a aVar) {
            boolean z = false;
            if (!SwipeDismissBehavior.this.E(view)) {
                return false;
            }
            boolean z2 = u.B(view) == 1;
            int i2 = SwipeDismissBehavior.this.f7537f;
            if ((i2 == 0 && z2) || (i2 == 1 && !z2)) {
                z = true;
            }
            int width = view.getWidth();
            if (z) {
                width = -width;
            }
            u.X(view, width);
            view.setAlpha(Utils.FLOAT_EPSILON);
            c cVar = SwipeDismissBehavior.this.f7533b;
            if (cVar != null) {
                cVar.b(view);
            }
            return true;
        }
    }

    public interface c {
        void a(int i2);

        void b(View view);
    }

    private class d implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final View f7546b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f7547c;

        d(View view, boolean z) {
            this.f7546b = view;
            this.f7547c = z;
        }

        public void run() {
            c cVar;
            b.j.b.c cVar2 = SwipeDismissBehavior.this.f7532a;
            if (cVar2 != null && cVar2.n(true)) {
                u.e0(this.f7546b, this);
            } else if (this.f7547c && (cVar = SwipeDismissBehavior.this.f7533b) != null) {
                cVar.b(this.f7546b);
            }
        }
    }

    static float F(float f2, float f3, float f4) {
        return Math.min(Math.max(f2, f3), f4);
    }

    static int G(int i2, int i3, int i4) {
        return Math.min(Math.max(i2, i3), i4);
    }

    private void H(ViewGroup viewGroup) {
        b.j.b.c cVar;
        if (this.f7532a == null) {
            if (this.f7536e) {
                cVar = b.j.b.c.o(viewGroup, this.f7535d, this.f7541j);
            } else {
                cVar = b.j.b.c.p(viewGroup, this.f7541j);
            }
            this.f7532a = cVar;
        }
    }

    static float I(float f2, float f3, float f4) {
        return (f4 - f2) / (f3 - f2);
    }

    private void N(View view) {
        u.g0(view, 1048576);
        if (E(view)) {
            u.i0(view, c.a.l, null, new b());
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean D(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        b.j.b.c cVar = this.f7532a;
        if (cVar == null) {
            return false;
        }
        cVar.F(motionEvent);
        return true;
    }

    public boolean E(View view) {
        return true;
    }

    public void J(float f2) {
        this.f7540i = F(Utils.FLOAT_EPSILON, f2, 1.0f);
    }

    public void K(c cVar) {
        this.f7533b = cVar;
    }

    public void L(float f2) {
        this.f7539h = F(Utils.FLOAT_EPSILON, f2, 1.0f);
    }

    public void M(int i2) {
        this.f7537f = i2;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean k(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        boolean z = this.f7534c;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            z = coordinatorLayout.B(v, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.f7534c = z;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f7534c = false;
        }
        if (!z) {
            return false;
        }
        H(coordinatorLayout);
        return this.f7532a.O(motionEvent);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean l(CoordinatorLayout coordinatorLayout, V v, int i2) {
        boolean l = super.l(coordinatorLayout, v, i2);
        if (u.z(v) == 0) {
            u.x0(v, 1);
            N(v);
        }
        return l;
    }
}
