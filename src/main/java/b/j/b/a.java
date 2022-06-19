package b.j.b;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import b.e.h;
import b.h.k.d0.d;
import b.h.k.d0.e;
import b.h.k.u;
import b.h.k.x;
import b.j.b.b;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ExploreByTouchHelper */
public abstract class a extends b.h.k.a {
    private static final Rect n = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
    private static final b.a<b.h.k.d0.c> o = new C0052a();
    private static final b.AbstractC0053b<h<b.h.k.d0.c>, b.h.k.d0.c> p = new b();

    /* renamed from: d  reason: collision with root package name */
    private final Rect f2722d = new Rect();

    /* renamed from: e  reason: collision with root package name */
    private final Rect f2723e = new Rect();

    /* renamed from: f  reason: collision with root package name */
    private final Rect f2724f = new Rect();

    /* renamed from: g  reason: collision with root package name */
    private final int[] f2725g = new int[2];

    /* renamed from: h  reason: collision with root package name */
    private final AccessibilityManager f2726h;

    /* renamed from: i  reason: collision with root package name */
    private final View f2727i;

    /* renamed from: j  reason: collision with root package name */
    private c f2728j;

    /* renamed from: k  reason: collision with root package name */
    int f2729k = Integer.MIN_VALUE;
    int l = Integer.MIN_VALUE;
    private int m = Integer.MIN_VALUE;

    /* renamed from: b.j.b.a$a  reason: collision with other inner class name */
    /* compiled from: ExploreByTouchHelper */
    static class C0052a implements b.a<b.h.k.d0.c> {
        C0052a() {
        }

        /* renamed from: b */
        public void a(b.h.k.d0.c cVar, Rect rect) {
            cVar.m(rect);
        }
    }

    /* compiled from: ExploreByTouchHelper */
    static class b implements b.AbstractC0053b<h<b.h.k.d0.c>, b.h.k.d0.c> {
        b() {
        }

        /* renamed from: c */
        public b.h.k.d0.c a(h<b.h.k.d0.c> hVar, int i2) {
            return hVar.n(i2);
        }

        /* renamed from: d */
        public int b(h<b.h.k.d0.c> hVar) {
            return hVar.m();
        }
    }

    /* compiled from: ExploreByTouchHelper */
    private class c extends d {
        c() {
        }

        @Override // b.h.k.d0.d
        public b.h.k.d0.c b(int i2) {
            return b.h.k.d0.c.P(a.this.H(i2));
        }

        @Override // b.h.k.d0.d
        public b.h.k.d0.c d(int i2) {
            int i3 = i2 == 2 ? a.this.f2729k : a.this.l;
            if (i3 == Integer.MIN_VALUE) {
                return null;
            }
            return b(i3);
        }

        @Override // b.h.k.d0.d
        public boolean f(int i2, int i3, Bundle bundle) {
            return a.this.P(i2, i3, bundle);
        }
    }

    public a(View view) {
        if (view != null) {
            this.f2727i = view;
            this.f2726h = (AccessibilityManager) view.getContext().getSystemService("accessibility");
            view.setFocusable(true);
            if (u.z(view) == 0) {
                u.x0(view, 1);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("View may not be null");
    }

    private static Rect D(View view, int i2, Rect rect) {
        int width = view.getWidth();
        int height = view.getHeight();
        if (i2 == 17) {
            rect.set(width, 0, width, height);
        } else if (i2 == 33) {
            rect.set(0, height, width, height);
        } else if (i2 == 66) {
            rect.set(-1, 0, -1, height);
        } else if (i2 == 130) {
            rect.set(0, -1, width, -1);
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        return rect;
    }

    private boolean E(Rect rect) {
        if (rect == null || rect.isEmpty() || this.f2727i.getWindowVisibility() != 0) {
            return false;
        }
        ViewParent parent = this.f2727i.getParent();
        while (parent instanceof View) {
            View view = (View) parent;
            if (view.getAlpha() <= Utils.FLOAT_EPSILON || view.getVisibility() != 0) {
                return false;
            }
            parent = view.getParent();
        }
        if (parent != null) {
            return true;
        }
        return false;
    }

    private static int F(int i2) {
        if (i2 == 19) {
            return 33;
        }
        if (i2 != 21) {
            return i2 != 22 ? 130 : 66;
        }
        return 17;
    }

    private boolean G(int i2, Rect rect) {
        b.h.k.d0.c cVar;
        b.h.k.d0.c cVar2;
        h<b.h.k.d0.c> y = y();
        int i3 = this.l;
        int i4 = Integer.MIN_VALUE;
        if (i3 == Integer.MIN_VALUE) {
            cVar = null;
        } else {
            cVar = y.e(i3);
        }
        if (i2 == 1 || i2 == 2) {
            cVar2 = (b.h.k.d0.c) b.d(y, p, o, cVar, i2, u.B(this.f2727i) == 1, false);
        } else if (i2 == 17 || i2 == 33 || i2 == 66 || i2 == 130) {
            Rect rect2 = new Rect();
            int i5 = this.l;
            if (i5 != Integer.MIN_VALUE) {
                z(i5, rect2);
            } else if (rect != null) {
                rect2.set(rect);
            } else {
                D(this.f2727i, i2, rect2);
            }
            cVar2 = (b.h.k.d0.c) b.c(y, p, o, cVar, rect2, i2);
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        if (cVar2 != null) {
            i4 = y.i(y.h(cVar2));
        }
        return T(i4);
    }

    private boolean Q(int i2, int i3, Bundle bundle) {
        if (i3 == 1) {
            return T(i2);
        }
        if (i3 == 2) {
            return o(i2);
        }
        if (i3 == 64) {
            return S(i2);
        }
        if (i3 != 128) {
            return J(i2, i3, bundle);
        }
        return n(i2);
    }

    private boolean R(int i2, Bundle bundle) {
        return u.c0(this.f2727i, i2, bundle);
    }

    private boolean S(int i2) {
        int i3;
        if (!this.f2726h.isEnabled() || !this.f2726h.isTouchExplorationEnabled() || (i3 = this.f2729k) == i2) {
            return false;
        }
        if (i3 != Integer.MIN_VALUE) {
            n(i3);
        }
        this.f2729k = i2;
        this.f2727i.invalidate();
        U(i2, 32768);
        return true;
    }

    private void V(int i2) {
        int i3 = this.m;
        if (i3 != i2) {
            this.m = i2;
            U(i2, 128);
            U(i3, 256);
        }
    }

    private boolean n(int i2) {
        if (this.f2729k != i2) {
            return false;
        }
        this.f2729k = Integer.MIN_VALUE;
        this.f2727i.invalidate();
        U(i2, 65536);
        return true;
    }

    private boolean p() {
        int i2 = this.l;
        return i2 != Integer.MIN_VALUE && J(i2, 16, null);
    }

    private AccessibilityEvent q(int i2, int i3) {
        if (i2 != -1) {
            return r(i2, i3);
        }
        return s(i3);
    }

    private AccessibilityEvent r(int i2, int i3) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i3);
        b.h.k.d0.c H = H(i2);
        obtain.getText().add(H.w());
        obtain.setContentDescription(H.r());
        obtain.setScrollable(H.J());
        obtain.setPassword(H.I());
        obtain.setEnabled(H.E());
        obtain.setChecked(H.C());
        L(i2, obtain);
        if (!obtain.getText().isEmpty() || obtain.getContentDescription() != null) {
            obtain.setClassName(H.p());
            e.c(obtain, this.f2727i, i2);
            obtain.setPackageName(this.f2727i.getContext().getPackageName());
            return obtain;
        }
        throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
    }

    private AccessibilityEvent s(int i2) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i2);
        this.f2727i.onInitializeAccessibilityEvent(obtain);
        return obtain;
    }

    private b.h.k.d0.c t(int i2) {
        b.h.k.d0.c N = b.h.k.d0.c.N();
        N.g0(true);
        N.i0(true);
        N.a0("android.view.View");
        Rect rect = n;
        N.W(rect);
        N.X(rect);
        N.q0(this.f2727i);
        N(i2, N);
        if (N.w() == null && N.r() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        N.m(this.f2723e);
        if (!this.f2723e.equals(rect)) {
            int k2 = N.k();
            if ((k2 & 64) != 0) {
                throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
            } else if ((k2 & 128) == 0) {
                N.o0(this.f2727i.getContext().getPackageName());
                N.y0(this.f2727i, i2);
                if (this.f2729k == i2) {
                    N.U(true);
                    N.a(128);
                } else {
                    N.U(false);
                    N.a(64);
                }
                boolean z = this.l == i2;
                if (z) {
                    N.a(2);
                } else if (N.F()) {
                    N.a(1);
                }
                N.j0(z);
                this.f2727i.getLocationOnScreen(this.f2725g);
                N.n(this.f2722d);
                if (this.f2722d.equals(rect)) {
                    N.m(this.f2722d);
                    if (N.f2638b != -1) {
                        b.h.k.d0.c N2 = b.h.k.d0.c.N();
                        for (int i3 = N.f2638b; i3 != -1; i3 = N2.f2638b) {
                            N2.r0(this.f2727i, -1);
                            N2.W(n);
                            N(i3, N2);
                            N2.m(this.f2723e);
                            Rect rect2 = this.f2722d;
                            Rect rect3 = this.f2723e;
                            rect2.offset(rect3.left, rect3.top);
                        }
                        N2.R();
                    }
                    this.f2722d.offset(this.f2725g[0] - this.f2727i.getScrollX(), this.f2725g[1] - this.f2727i.getScrollY());
                }
                if (this.f2727i.getLocalVisibleRect(this.f2724f)) {
                    this.f2724f.offset(this.f2725g[0] - this.f2727i.getScrollX(), this.f2725g[1] - this.f2727i.getScrollY());
                    if (this.f2722d.intersect(this.f2724f)) {
                        N.X(this.f2722d);
                        if (E(this.f2722d)) {
                            N.C0(true);
                        }
                    }
                }
                return N;
            } else {
                throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
            }
        } else {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
    }

    private b.h.k.d0.c u() {
        b.h.k.d0.c O = b.h.k.d0.c.O(this.f2727i);
        u.a0(this.f2727i, O);
        ArrayList arrayList = new ArrayList();
        C(arrayList);
        if (O.o() <= 0 || arrayList.size() <= 0) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                O.d(this.f2727i, ((Integer) arrayList.get(i2)).intValue());
            }
            return O;
        }
        throw new RuntimeException("Views cannot have both real and virtual children");
    }

    private h<b.h.k.d0.c> y() {
        ArrayList arrayList = new ArrayList();
        C(arrayList);
        h<b.h.k.d0.c> hVar = new h<>();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            hVar.j(i2, t(i2));
        }
        return hVar;
    }

    private void z(int i2, Rect rect) {
        H(i2).m(rect);
    }

    public final int A() {
        return this.l;
    }

    /* access modifiers changed from: protected */
    public abstract int B(float f2, float f3);

    /* access modifiers changed from: protected */
    public abstract void C(List<Integer> list);

    /* access modifiers changed from: package-private */
    public b.h.k.d0.c H(int i2) {
        if (i2 == -1) {
            return u();
        }
        return t(i2);
    }

    public final void I(boolean z, int i2, Rect rect) {
        int i3 = this.l;
        if (i3 != Integer.MIN_VALUE) {
            o(i3);
        }
        if (z) {
            G(i2, rect);
        }
    }

    /* access modifiers changed from: protected */
    public abstract boolean J(int i2, int i3, Bundle bundle);

    /* access modifiers changed from: protected */
    public void K(AccessibilityEvent accessibilityEvent) {
    }

    /* access modifiers changed from: protected */
    public void L(int i2, AccessibilityEvent accessibilityEvent) {
    }

    /* access modifiers changed from: protected */
    public void M(b.h.k.d0.c cVar) {
    }

    /* access modifiers changed from: protected */
    public abstract void N(int i2, b.h.k.d0.c cVar);

    /* access modifiers changed from: protected */
    public void O(int i2, boolean z) {
    }

    /* access modifiers changed from: package-private */
    public boolean P(int i2, int i3, Bundle bundle) {
        if (i2 != -1) {
            return Q(i2, i3, bundle);
        }
        return R(i3, bundle);
    }

    public final boolean T(int i2) {
        int i3;
        if ((!this.f2727i.isFocused() && !this.f2727i.requestFocus()) || (i3 = this.l) == i2) {
            return false;
        }
        if (i3 != Integer.MIN_VALUE) {
            o(i3);
        }
        this.l = i2;
        O(i2, true);
        U(i2, 8);
        return true;
    }

    public final boolean U(int i2, int i3) {
        ViewParent parent;
        if (i2 == Integer.MIN_VALUE || !this.f2726h.isEnabled() || (parent = this.f2727i.getParent()) == null) {
            return false;
        }
        return x.h(parent, this.f2727i, q(i2, i3));
    }

    @Override // b.h.k.a
    public d b(View view) {
        if (this.f2728j == null) {
            this.f2728j = new c();
        }
        return this.f2728j;
    }

    @Override // b.h.k.a
    public void f(View view, AccessibilityEvent accessibilityEvent) {
        super.f(view, accessibilityEvent);
        K(accessibilityEvent);
    }

    @Override // b.h.k.a
    public void g(View view, b.h.k.d0.c cVar) {
        super.g(view, cVar);
        M(cVar);
    }

    public final boolean o(int i2) {
        if (this.l != i2) {
            return false;
        }
        this.l = Integer.MIN_VALUE;
        O(i2, false);
        U(i2, 8);
        return true;
    }

    public final boolean v(MotionEvent motionEvent) {
        if (!this.f2726h.isEnabled() || !this.f2726h.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 7 || action == 9) {
            int B = B(motionEvent.getX(), motionEvent.getY());
            V(B);
            if (B != Integer.MIN_VALUE) {
                return true;
            }
            return false;
        } else if (action != 10 || this.m == Integer.MIN_VALUE) {
            return false;
        } else {
            V(Integer.MIN_VALUE);
            return true;
        }
    }

    public final boolean w(KeyEvent keyEvent) {
        int i2 = 0;
        if (keyEvent.getAction() == 1) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode != 61) {
            if (keyCode != 66) {
                switch (keyCode) {
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                        if (!keyEvent.hasNoModifiers()) {
                            return false;
                        }
                        int F = F(keyCode);
                        int repeatCount = keyEvent.getRepeatCount() + 1;
                        boolean z = false;
                        while (i2 < repeatCount && G(F, null)) {
                            i2++;
                            z = true;
                        }
                        return z;
                    case 23:
                        break;
                    default:
                        return false;
                }
            }
            if (!keyEvent.hasNoModifiers() || keyEvent.getRepeatCount() != 0) {
                return false;
            }
            p();
            return true;
        } else if (keyEvent.hasNoModifiers()) {
            return G(2, null);
        } else {
            if (keyEvent.hasModifiers(1)) {
                return G(1, null);
            }
            return false;
        }
    }

    public final int x() {
        return this.f2729k;
    }
}
