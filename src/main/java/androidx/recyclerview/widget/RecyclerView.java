package androidx.recyclerview.widget;

import android.animation.LayoutTransition;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.recyclerview.widget.a;
import androidx.recyclerview.widget.b;
import androidx.recyclerview.widget.e;
import androidx.recyclerview.widget.n;
import androidx.recyclerview.widget.r;
import androidx.recyclerview.widget.s;
import b.h.k.d0.c;
import com.github.mikephil.charting.BuildConfig;
import com.github.mikephil.charting.utils.Utils;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecyclerView extends ViewGroup implements b.h.k.k {
    static final boolean A0;
    static final boolean B0;
    static final boolean C0;
    static final boolean D0;
    private static final boolean E0;
    private static final boolean F0;
    private static final Class<?>[] G0;
    static final Interpolator H0 = new c();
    private static final int[] z0 = {16843830};
    private int A;
    boolean B;
    private final AccessibilityManager C;
    private List<q> D;
    boolean E;
    boolean F;
    private int G;
    private int H;
    private k I;
    private EdgeEffect J;
    private EdgeEffect K;
    private EdgeEffect L;
    private EdgeEffect M;
    l N;
    private int O;
    private int P;
    private VelocityTracker Q;
    private int R;
    private int S;
    private int T;
    private int U;
    private int V;
    private r W;
    private final int a0;

    /* renamed from: b  reason: collision with root package name */
    private final x f1534b;
    private final int b0;

    /* renamed from: c  reason: collision with root package name */
    final v f1535c;
    private float c0;

    /* renamed from: d  reason: collision with root package name */
    private y f1536d;
    private float d0;

    /* renamed from: e  reason: collision with root package name */
    a f1537e;
    private boolean e0;

    /* renamed from: f  reason: collision with root package name */
    b f1538f;
    final c0 f0;

    /* renamed from: g  reason: collision with root package name */
    final s f1539g;
    e g0;

    /* renamed from: h  reason: collision with root package name */
    boolean f1540h;
    e.b h0;

    /* renamed from: i  reason: collision with root package name */
    final Runnable f1541i;
    final a0 i0;

    /* renamed from: j  reason: collision with root package name */
    final Rect f1542j;
    private t j0;

    /* renamed from: k  reason: collision with root package name */
    private final Rect f1543k;
    private List<t> k0;
    final RectF l;
    boolean l0;
    g m;
    boolean m0;
    o n;
    private l.b n0;
    w o;
    boolean o0;
    final ArrayList<n> p;
    n p0;
    private final ArrayList<s> q;
    private j q0;
    private s r;
    private final int[] r0;
    boolean s;
    private b.h.k.l s0;
    boolean t;
    private final int[] t0;
    boolean u;
    private final int[] u0;
    boolean v;
    final int[] v0;
    private int w;
    final List<d0> w0;
    boolean x;
    private Runnable x0;
    boolean y;
    private final s.b y0;
    private boolean z;

    class a implements Runnable {
        a() {
        }

        public void run() {
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.v && !recyclerView.isLayoutRequested()) {
                RecyclerView recyclerView2 = RecyclerView.this;
                if (!recyclerView2.s) {
                    recyclerView2.requestLayout();
                } else if (recyclerView2.y) {
                    recyclerView2.x = true;
                } else {
                    recyclerView2.v();
                }
            }
        }
    }

    public static class a0 {

        /* renamed from: a  reason: collision with root package name */
        int f1545a = -1;

        /* renamed from: b  reason: collision with root package name */
        private SparseArray<Object> f1546b;

        /* renamed from: c  reason: collision with root package name */
        int f1547c = 0;

        /* renamed from: d  reason: collision with root package name */
        int f1548d = 0;

        /* renamed from: e  reason: collision with root package name */
        int f1549e = 1;

        /* renamed from: f  reason: collision with root package name */
        int f1550f = 0;

        /* renamed from: g  reason: collision with root package name */
        boolean f1551g = false;

        /* renamed from: h  reason: collision with root package name */
        boolean f1552h = false;

        /* renamed from: i  reason: collision with root package name */
        boolean f1553i = false;

        /* renamed from: j  reason: collision with root package name */
        boolean f1554j = false;

        /* renamed from: k  reason: collision with root package name */
        boolean f1555k = false;
        boolean l = false;
        int m;
        long n;
        int o;
        int p;
        int q;

        /* access modifiers changed from: package-private */
        public void a(int i2) {
            if ((this.f1549e & i2) == 0) {
                throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i2) + " but it is " + Integer.toBinaryString(this.f1549e));
            }
        }

        public int b() {
            return this.f1552h ? this.f1547c - this.f1548d : this.f1550f;
        }

        public int c() {
            return this.f1545a;
        }

        public boolean d() {
            return this.f1545a != -1;
        }

        public boolean e() {
            return this.f1552h;
        }

        /* access modifiers changed from: package-private */
        public void f(g gVar) {
            this.f1549e = 1;
            this.f1550f = gVar.c();
            this.f1552h = false;
            this.f1553i = false;
            this.f1554j = false;
        }

        public boolean g() {
            return this.l;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.f1545a + ", mData=" + this.f1546b + ", mItemCount=" + this.f1550f + ", mIsMeasuring=" + this.f1554j + ", mPreviousLayoutItemCount=" + this.f1547c + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f1548d + ", mStructureChanged=" + this.f1551g + ", mInPreLayout=" + this.f1552h + ", mRunSimpleAnimations=" + this.f1555k + ", mRunPredictiveAnimations=" + this.l + '}';
        }
    }

    class b implements Runnable {
        b() {
        }

        public void run() {
            l lVar = RecyclerView.this.N;
            if (lVar != null) {
                lVar.v();
            }
            RecyclerView.this.o0 = false;
        }
    }

    public static abstract class b0 {
        public abstract View a(v vVar, int i2, int i3);
    }

    static class c implements Interpolator {
        c() {
        }

        public float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }
    }

    /* access modifiers changed from: package-private */
    public class c0 implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private int f1557b;

        /* renamed from: c  reason: collision with root package name */
        private int f1558c;

        /* renamed from: d  reason: collision with root package name */
        OverScroller f1559d;

        /* renamed from: e  reason: collision with root package name */
        Interpolator f1560e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f1561f = false;

        /* renamed from: g  reason: collision with root package name */
        private boolean f1562g = false;

        c0() {
            Interpolator interpolator = RecyclerView.H0;
            this.f1560e = interpolator;
            this.f1559d = new OverScroller(RecyclerView.this.getContext(), interpolator);
        }

        private int a(int i2, int i3, int i4, int i5) {
            int i6;
            int abs = Math.abs(i2);
            int abs2 = Math.abs(i3);
            boolean z = abs > abs2;
            int sqrt = (int) Math.sqrt((double) ((i4 * i4) + (i5 * i5)));
            int sqrt2 = (int) Math.sqrt((double) ((i2 * i2) + (i3 * i3)));
            RecyclerView recyclerView = RecyclerView.this;
            int width = z ? recyclerView.getWidth() : recyclerView.getHeight();
            int i7 = width / 2;
            float f2 = (float) width;
            float f3 = (float) i7;
            float b2 = f3 + (b(Math.min(1.0f, (((float) sqrt2) * 1.0f) / f2)) * f3);
            if (sqrt > 0) {
                i6 = Math.round(Math.abs(b2 / ((float) sqrt)) * 1000.0f) * 4;
            } else {
                if (!z) {
                    abs = abs2;
                }
                i6 = (int) (((((float) abs) / f2) + 1.0f) * 300.0f);
            }
            return Math.min(i6, 2000);
        }

        private float b(float f2) {
            return (float) Math.sin((double) ((f2 - 0.5f) * 0.47123894f));
        }

        private void d() {
            RecyclerView.this.removeCallbacks(this);
            b.h.k.u.e0(RecyclerView.this, this);
        }

        public void c(int i2, int i3) {
            RecyclerView.this.setScrollState(2);
            this.f1558c = 0;
            this.f1557b = 0;
            Interpolator interpolator = this.f1560e;
            Interpolator interpolator2 = RecyclerView.H0;
            if (interpolator != interpolator2) {
                this.f1560e = interpolator2;
                this.f1559d = new OverScroller(RecyclerView.this.getContext(), interpolator2);
            }
            this.f1559d.fling(0, 0, i2, i3, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            e();
        }

        /* access modifiers changed from: package-private */
        public void e() {
            if (this.f1561f) {
                this.f1562g = true;
            } else {
                d();
            }
        }

        public void f(int i2, int i3, int i4, Interpolator interpolator) {
            if (i4 == Integer.MIN_VALUE) {
                i4 = a(i2, i3, 0, 0);
            }
            if (interpolator == null) {
                interpolator = RecyclerView.H0;
            }
            if (this.f1560e != interpolator) {
                this.f1560e = interpolator;
                this.f1559d = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            this.f1558c = 0;
            this.f1557b = 0;
            RecyclerView.this.setScrollState(2);
            this.f1559d.startScroll(0, 0, i2, i3, i4);
            if (Build.VERSION.SDK_INT < 23) {
                this.f1559d.computeScrollOffset();
            }
            e();
        }

        public void g() {
            RecyclerView.this.removeCallbacks(this);
            this.f1559d.abortAnimation();
        }

        public void run() {
            int i2;
            int i3;
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.n == null) {
                g();
                return;
            }
            this.f1562g = false;
            this.f1561f = true;
            recyclerView.v();
            OverScroller overScroller = this.f1559d;
            if (overScroller.computeScrollOffset()) {
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i4 = currX - this.f1557b;
                int i5 = currY - this.f1558c;
                this.f1557b = currX;
                this.f1558c = currY;
                RecyclerView recyclerView2 = RecyclerView.this;
                int[] iArr = recyclerView2.v0;
                iArr[0] = 0;
                iArr[1] = 0;
                if (recyclerView2.G(i4, i5, iArr, null, 1)) {
                    int[] iArr2 = RecyclerView.this.v0;
                    i4 -= iArr2[0];
                    i5 -= iArr2[1];
                }
                if (RecyclerView.this.getOverScrollMode() != 2) {
                    RecyclerView.this.u(i4, i5);
                }
                RecyclerView recyclerView3 = RecyclerView.this;
                if (recyclerView3.m != null) {
                    int[] iArr3 = recyclerView3.v0;
                    iArr3[0] = 0;
                    iArr3[1] = 0;
                    recyclerView3.j1(i4, i5, iArr3);
                    RecyclerView recyclerView4 = RecyclerView.this;
                    int[] iArr4 = recyclerView4.v0;
                    i2 = iArr4[0];
                    i3 = iArr4[1];
                    i4 -= i2;
                    i5 -= i3;
                    z zVar = recyclerView4.n.f1595g;
                    if (zVar != null && !zVar.g() && zVar.h()) {
                        int b2 = RecyclerView.this.i0.b();
                        if (b2 == 0) {
                            zVar.r();
                        } else if (zVar.f() >= b2) {
                            zVar.p(b2 - 1);
                            zVar.j(i2, i3);
                        } else {
                            zVar.j(i2, i3);
                        }
                    }
                } else {
                    i3 = 0;
                    i2 = 0;
                }
                if (!RecyclerView.this.p.isEmpty()) {
                    RecyclerView.this.invalidate();
                }
                RecyclerView recyclerView5 = RecyclerView.this;
                int[] iArr5 = recyclerView5.v0;
                iArr5[0] = 0;
                iArr5[1] = 0;
                recyclerView5.H(i2, i3, i4, i5, null, 1, iArr5);
                RecyclerView recyclerView6 = RecyclerView.this;
                int[] iArr6 = recyclerView6.v0;
                int i6 = i4 - iArr6[0];
                int i7 = i5 - iArr6[1];
                if (!(i2 == 0 && i3 == 0)) {
                    recyclerView6.J(i2, i3);
                }
                if (!RecyclerView.this.awakenScrollBars()) {
                    RecyclerView.this.invalidate();
                }
                boolean z = overScroller.isFinished() || (((overScroller.getCurrX() == overScroller.getFinalX()) || i6 != 0) && ((overScroller.getCurrY() == overScroller.getFinalY()) || i7 != 0));
                z zVar2 = RecyclerView.this.n.f1595g;
                if ((zVar2 != null && zVar2.g()) || !z) {
                    e();
                    RecyclerView recyclerView7 = RecyclerView.this;
                    e eVar = recyclerView7.g0;
                    if (eVar != null) {
                        eVar.f(recyclerView7, i2, i3);
                    }
                } else {
                    if (RecyclerView.this.getOverScrollMode() != 2) {
                        int currVelocity = (int) overScroller.getCurrVelocity();
                        int i8 = i6 < 0 ? -currVelocity : i6 > 0 ? currVelocity : 0;
                        if (i7 < 0) {
                            currVelocity = -currVelocity;
                        } else if (i7 <= 0) {
                            currVelocity = 0;
                        }
                        RecyclerView.this.a(i8, currVelocity);
                    }
                    if (RecyclerView.D0) {
                        RecyclerView.this.h0.b();
                    }
                }
            }
            z zVar3 = RecyclerView.this.n.f1595g;
            if (zVar3 != null && zVar3.g()) {
                zVar3.j(0, 0);
            }
            this.f1561f = false;
            if (this.f1562g) {
                d();
                return;
            }
            RecyclerView.this.setScrollState(0);
            RecyclerView.this.w1(1);
        }
    }

    class d implements s.b {
        d() {
        }

        @Override // androidx.recyclerview.widget.s.b
        public void a(d0 d0Var) {
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.n.n1(d0Var.f1565a, recyclerView.f1535c);
        }

        @Override // androidx.recyclerview.widget.s.b
        public void b(d0 d0Var, l.c cVar, l.c cVar2) {
            RecyclerView.this.m(d0Var, cVar, cVar2);
        }

        @Override // androidx.recyclerview.widget.s.b
        public void c(d0 d0Var, l.c cVar, l.c cVar2) {
            RecyclerView.this.f1535c.J(d0Var);
            RecyclerView.this.o(d0Var, cVar, cVar2);
        }

        @Override // androidx.recyclerview.widget.s.b
        public void d(d0 d0Var, l.c cVar, l.c cVar2) {
            d0Var.G(false);
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.E) {
                if (recyclerView.N.b(d0Var, d0Var, cVar, cVar2)) {
                    RecyclerView.this.O0();
                }
            } else if (recyclerView.N.d(d0Var, cVar, cVar2)) {
                RecyclerView.this.O0();
            }
        }
    }

    public static abstract class d0 {
        private static final List<Object> s = Collections.emptyList();

        /* renamed from: a  reason: collision with root package name */
        public final View f1565a;

        /* renamed from: b  reason: collision with root package name */
        WeakReference<RecyclerView> f1566b;

        /* renamed from: c  reason: collision with root package name */
        int f1567c = -1;

        /* renamed from: d  reason: collision with root package name */
        int f1568d = -1;

        /* renamed from: e  reason: collision with root package name */
        long f1569e = -1;

        /* renamed from: f  reason: collision with root package name */
        int f1570f = -1;

        /* renamed from: g  reason: collision with root package name */
        int f1571g = -1;

        /* renamed from: h  reason: collision with root package name */
        d0 f1572h = null;

        /* renamed from: i  reason: collision with root package name */
        d0 f1573i = null;

        /* renamed from: j  reason: collision with root package name */
        int f1574j;

        /* renamed from: k  reason: collision with root package name */
        List<Object> f1575k = null;
        List<Object> l = null;
        private int m = 0;
        v n = null;
        boolean o = false;
        private int p = 0;
        int q = -1;
        RecyclerView r;

        public d0(View view) {
            if (view != null) {
                this.f1565a = view;
                return;
            }
            throw new IllegalArgumentException("itemView may not be null");
        }

        private void g() {
            if (this.f1575k == null) {
                ArrayList arrayList = new ArrayList();
                this.f1575k = arrayList;
                this.l = Collections.unmodifiableList(arrayList);
            }
        }

        /* access modifiers changed from: package-private */
        public void A(int i2, boolean z) {
            if (this.f1568d == -1) {
                this.f1568d = this.f1567c;
            }
            if (this.f1571g == -1) {
                this.f1571g = this.f1567c;
            }
            if (z) {
                this.f1571g += i2;
            }
            this.f1567c += i2;
            if (this.f1565a.getLayoutParams() != null) {
                ((p) this.f1565a.getLayoutParams()).f1608c = true;
            }
        }

        /* access modifiers changed from: package-private */
        public void B(RecyclerView recyclerView) {
            int i2 = this.q;
            if (i2 != -1) {
                this.p = i2;
            } else {
                this.p = b.h.k.u.z(this.f1565a);
            }
            recyclerView.m1(this, 4);
        }

        /* access modifiers changed from: package-private */
        public void C(RecyclerView recyclerView) {
            recyclerView.m1(this, this.p);
            this.p = 0;
        }

        /* access modifiers changed from: package-private */
        public void D() {
            this.f1574j = 0;
            this.f1567c = -1;
            this.f1568d = -1;
            this.f1569e = -1;
            this.f1571g = -1;
            this.m = 0;
            this.f1572h = null;
            this.f1573i = null;
            d();
            this.p = 0;
            this.q = -1;
            RecyclerView.s(this);
        }

        /* access modifiers changed from: package-private */
        public void E() {
            if (this.f1568d == -1) {
                this.f1568d = this.f1567c;
            }
        }

        /* access modifiers changed from: package-private */
        public void F(int i2, int i3) {
            this.f1574j = (i2 & i3) | (this.f1574j & (i3 ^ -1));
        }

        public final void G(boolean z) {
            int i2 = this.m;
            int i3 = z ? i2 - 1 : i2 + 1;
            this.m = i3;
            if (i3 < 0) {
                this.m = 0;
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
            } else if (!z && i3 == 1) {
                this.f1574j |= 16;
            } else if (z && i3 == 0) {
                this.f1574j &= -17;
            }
        }

        /* access modifiers changed from: package-private */
        public void H(v vVar, boolean z) {
            this.n = vVar;
            this.o = z;
        }

        /* access modifiers changed from: package-private */
        public boolean I() {
            return (this.f1574j & 16) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean J() {
            return (this.f1574j & 128) != 0;
        }

        /* access modifiers changed from: package-private */
        public void K() {
            this.n.J(this);
        }

        /* access modifiers changed from: package-private */
        public boolean L() {
            return (this.f1574j & 32) != 0;
        }

        /* access modifiers changed from: package-private */
        public void a(Object obj) {
            if (obj == null) {
                b(1024);
            } else if ((1024 & this.f1574j) == 0) {
                g();
                this.f1575k.add(obj);
            }
        }

        /* access modifiers changed from: package-private */
        public void b(int i2) {
            this.f1574j = i2 | this.f1574j;
        }

        /* access modifiers changed from: package-private */
        public void c() {
            this.f1568d = -1;
            this.f1571g = -1;
        }

        /* access modifiers changed from: package-private */
        public void d() {
            List<Object> list = this.f1575k;
            if (list != null) {
                list.clear();
            }
            this.f1574j &= -1025;
        }

        /* access modifiers changed from: package-private */
        public void e() {
            this.f1574j &= -33;
        }

        /* access modifiers changed from: package-private */
        public void f() {
            this.f1574j &= -257;
        }

        /* access modifiers changed from: package-private */
        public boolean h() {
            return (this.f1574j & 16) == 0 && b.h.k.u.P(this.f1565a);
        }

        /* access modifiers changed from: package-private */
        public void i(int i2, int i3, boolean z) {
            b(8);
            A(i3, z);
            this.f1567c = i2;
        }

        public final int j() {
            RecyclerView recyclerView = this.r;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.d0(this);
        }

        public final long k() {
            return this.f1569e;
        }

        public final int l() {
            return this.f1570f;
        }

        public final int m() {
            int i2 = this.f1571g;
            return i2 == -1 ? this.f1567c : i2;
        }

        public final int n() {
            return this.f1568d;
        }

        /* access modifiers changed from: package-private */
        public List<Object> o() {
            if ((this.f1574j & 1024) != 0) {
                return s;
            }
            List<Object> list = this.f1575k;
            if (list == null || list.size() == 0) {
                return s;
            }
            return this.l;
        }

        /* access modifiers changed from: package-private */
        public boolean p(int i2) {
            return (i2 & this.f1574j) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean q() {
            return (this.f1574j & 512) != 0 || t();
        }

        /* access modifiers changed from: package-private */
        public boolean r() {
            return (this.f1565a.getParent() == null || this.f1565a.getParent() == this.r) ? false : true;
        }

        /* access modifiers changed from: package-private */
        public boolean s() {
            return (this.f1574j & 1) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean t() {
            return (this.f1574j & 4) != 0;
        }

        public String toString() {
            String simpleName = getClass().isAnonymousClass() ? "ViewHolder" : getClass().getSimpleName();
            StringBuilder sb = new StringBuilder(simpleName + "{" + Integer.toHexString(hashCode()) + " position=" + this.f1567c + " id=" + this.f1569e + ", oldPos=" + this.f1568d + ", pLpos:" + this.f1571g);
            if (w()) {
                sb.append(" scrap ");
                sb.append(this.o ? "[changeScrap]" : "[attachedScrap]");
            }
            if (t()) {
                sb.append(" invalid");
            }
            if (!s()) {
                sb.append(" unbound");
            }
            if (z()) {
                sb.append(" update");
            }
            if (v()) {
                sb.append(" removed");
            }
            if (J()) {
                sb.append(" ignored");
            }
            if (x()) {
                sb.append(" tmpDetached");
            }
            if (!u()) {
                sb.append(" not recyclable(" + this.m + ")");
            }
            if (q()) {
                sb.append(" undefined adapter position");
            }
            if (this.f1565a.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }

        public final boolean u() {
            return (this.f1574j & 16) == 0 && !b.h.k.u.P(this.f1565a);
        }

        /* access modifiers changed from: package-private */
        public boolean v() {
            return (this.f1574j & 8) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean w() {
            return this.n != null;
        }

        /* access modifiers changed from: package-private */
        public boolean x() {
            return (this.f1574j & 256) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean y() {
            return (this.f1574j & 2) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean z() {
            return (this.f1574j & 2) != 0;
        }
    }

    /* access modifiers changed from: package-private */
    public class e implements b.AbstractC0024b {
        e() {
        }

        @Override // androidx.recyclerview.widget.b.AbstractC0024b
        public View a(int i2) {
            return RecyclerView.this.getChildAt(i2);
        }

        @Override // androidx.recyclerview.widget.b.AbstractC0024b
        public void b(View view) {
            d0 i0 = RecyclerView.i0(view);
            if (i0 != null) {
                i0.B(RecyclerView.this);
            }
        }

        @Override // androidx.recyclerview.widget.b.AbstractC0024b
        public d0 c(View view) {
            return RecyclerView.i0(view);
        }

        @Override // androidx.recyclerview.widget.b.AbstractC0024b
        public void d(int i2) {
            d0 i0;
            View a2 = a(i2);
            if (!(a2 == null || (i0 = RecyclerView.i0(a2)) == null)) {
                if (!i0.x() || i0.J()) {
                    i0.b(256);
                } else {
                    throw new IllegalArgumentException("called detach on an already detached child " + i0 + RecyclerView.this.Q());
                }
            }
            RecyclerView.this.detachViewFromParent((RecyclerView) i2);
        }

        @Override // androidx.recyclerview.widget.b.AbstractC0024b
        public void e(View view) {
            d0 i0 = RecyclerView.i0(view);
            if (i0 != null) {
                i0.C(RecyclerView.this);
            }
        }

        @Override // androidx.recyclerview.widget.b.AbstractC0024b
        public void f(View view, int i2) {
            RecyclerView.this.addView(view, i2);
            RecyclerView.this.z(view);
        }

        @Override // androidx.recyclerview.widget.b.AbstractC0024b
        public int g() {
            return RecyclerView.this.getChildCount();
        }

        @Override // androidx.recyclerview.widget.b.AbstractC0024b
        public void h(int i2) {
            View childAt = RecyclerView.this.getChildAt(i2);
            if (childAt != null) {
                RecyclerView.this.A(childAt);
                childAt.clearAnimation();
            }
            RecyclerView.this.removeViewAt(i2);
        }

        @Override // androidx.recyclerview.widget.b.AbstractC0024b
        public void i() {
            int g2 = g();
            for (int i2 = 0; i2 < g2; i2++) {
                View a2 = a(i2);
                RecyclerView.this.A(a2);
                a2.clearAnimation();
            }
            RecyclerView.this.removeAllViews();
        }

        @Override // androidx.recyclerview.widget.b.AbstractC0024b
        public void j(View view, int i2, ViewGroup.LayoutParams layoutParams) {
            d0 i0 = RecyclerView.i0(view);
            if (i0 != null) {
                if (i0.x() || i0.J()) {
                    i0.f();
                } else {
                    throw new IllegalArgumentException("Called attach on a child which is not detached: " + i0 + RecyclerView.this.Q());
                }
            }
            RecyclerView.this.attachViewToParent(view, i2, layoutParams);
        }

        @Override // androidx.recyclerview.widget.b.AbstractC0024b
        public int k(View view) {
            return RecyclerView.this.indexOfChild(view);
        }
    }

    /* access modifiers changed from: package-private */
    public class f implements a.AbstractC0023a {
        f() {
        }

        @Override // androidx.recyclerview.widget.a.AbstractC0023a
        public void a(int i2, int i3) {
            RecyclerView.this.E0(i2, i3);
            RecyclerView.this.l0 = true;
        }

        @Override // androidx.recyclerview.widget.a.AbstractC0023a
        public void b(a.b bVar) {
            i(bVar);
        }

        @Override // androidx.recyclerview.widget.a.AbstractC0023a
        public d0 c(int i2) {
            d0 b0 = RecyclerView.this.b0(i2, true);
            if (b0 != null && !RecyclerView.this.f1538f.n(b0.f1565a)) {
                return b0;
            }
            return null;
        }

        @Override // androidx.recyclerview.widget.a.AbstractC0023a
        public void d(int i2, int i3) {
            RecyclerView.this.F0(i2, i3, false);
            RecyclerView.this.l0 = true;
        }

        @Override // androidx.recyclerview.widget.a.AbstractC0023a
        public void e(int i2, int i3) {
            RecyclerView.this.D0(i2, i3);
            RecyclerView.this.l0 = true;
        }

        @Override // androidx.recyclerview.widget.a.AbstractC0023a
        public void f(int i2, int i3) {
            RecyclerView.this.F0(i2, i3, true);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.l0 = true;
            recyclerView.i0.f1548d += i3;
        }

        @Override // androidx.recyclerview.widget.a.AbstractC0023a
        public void g(a.b bVar) {
            i(bVar);
        }

        @Override // androidx.recyclerview.widget.a.AbstractC0023a
        public void h(int i2, int i3, Object obj) {
            RecyclerView.this.z1(i2, i3, obj);
            RecyclerView.this.m0 = true;
        }

        /* access modifiers changed from: package-private */
        public void i(a.b bVar) {
            int i2 = bVar.f1682a;
            if (i2 == 1) {
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.n.S0(recyclerView, bVar.f1683b, bVar.f1685d);
            } else if (i2 == 2) {
                RecyclerView recyclerView2 = RecyclerView.this;
                recyclerView2.n.V0(recyclerView2, bVar.f1683b, bVar.f1685d);
            } else if (i2 == 4) {
                RecyclerView recyclerView3 = RecyclerView.this;
                recyclerView3.n.X0(recyclerView3, bVar.f1683b, bVar.f1685d, bVar.f1684c);
            } else if (i2 == 8) {
                RecyclerView recyclerView4 = RecyclerView.this;
                recyclerView4.n.U0(recyclerView4, bVar.f1683b, bVar.f1685d, 1);
            }
        }
    }

    public static abstract class g<VH extends d0> {

        /* renamed from: a  reason: collision with root package name */
        private final h f1578a = new h();

        /* renamed from: b  reason: collision with root package name */
        private boolean f1579b = false;

        public final void a(VH vh, int i2) {
            vh.f1567c = i2;
            if (g()) {
                vh.f1569e = d(i2);
            }
            vh.F(1, 519);
            androidx.core.os.h.a("RV OnBindView");
            n(vh, i2, vh.o());
            vh.d();
            ViewGroup.LayoutParams layoutParams = vh.f1565a.getLayoutParams();
            if (layoutParams instanceof p) {
                ((p) layoutParams).f1608c = true;
            }
            androidx.core.os.h.b();
        }

        public final VH b(ViewGroup viewGroup, int i2) {
            try {
                androidx.core.os.h.a("RV CreateView");
                VH o = o(viewGroup, i2);
                if (o.f1565a.getParent() == null) {
                    o.f1570f = i2;
                    return o;
                }
                throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
            } finally {
                androidx.core.os.h.b();
            }
        }

        public abstract int c();

        public long d(int i2) {
            return -1;
        }

        public int e(int i2) {
            return 0;
        }

        public final boolean f() {
            return this.f1578a.a();
        }

        public final boolean g() {
            return this.f1579b;
        }

        public final void h() {
            this.f1578a.b();
        }

        public final void i(int i2) {
            this.f1578a.d(i2, 1);
        }

        public final void j(int i2, int i3) {
            this.f1578a.c(i2, i3);
        }

        public final void k(int i2) {
            this.f1578a.f(i2, 1);
        }

        public void l(RecyclerView recyclerView) {
        }

        public abstract void m(VH vh, int i2);

        public void n(VH vh, int i2, List<Object> list) {
            m(vh, i2);
        }

        public abstract VH o(ViewGroup viewGroup, int i2);

        public void p(RecyclerView recyclerView) {
        }

        public boolean q(VH vh) {
            return false;
        }

        public void r(VH vh) {
        }

        public void s(VH vh) {
        }

        public void t(VH vh) {
        }

        public void u(i iVar) {
            this.f1578a.registerObserver(iVar);
        }

        public void v(boolean z) {
            if (!f()) {
                this.f1579b = z;
                return;
            }
            throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
        }

        public void w(i iVar) {
            this.f1578a.unregisterObserver(iVar);
        }
    }

    /* access modifiers changed from: package-private */
    public static class h extends Observable<i> {
        h() {
        }

        public boolean a() {
            return !((Observable) this).mObservers.isEmpty();
        }

        public void b() {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((i) ((Observable) this).mObservers.get(size)).a();
            }
        }

        public void c(int i2, int i3) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((i) ((Observable) this).mObservers.get(size)).d(i2, i3, 1);
            }
        }

        public void d(int i2, int i3) {
            e(i2, i3, null);
        }

        public void e(int i2, int i3, Object obj) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((i) ((Observable) this).mObservers.get(size)).c(i2, i3, obj);
            }
        }

        public void f(int i2, int i3) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((i) ((Observable) this).mObservers.get(size)).e(i2, i3);
            }
        }
    }

    public static abstract class i {
        public void a() {
        }

        public void b(int i2, int i3) {
        }

        public void c(int i2, int i3, Object obj) {
            b(i2, i3);
        }

        public void d(int i2, int i3, int i4) {
        }

        public void e(int i2, int i3) {
        }
    }

    public interface j {
        int a(int i2, int i3);
    }

    public static class k {
        /* access modifiers changed from: protected */
        public EdgeEffect a(RecyclerView recyclerView, int i2) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    public static abstract class l {

        /* renamed from: a  reason: collision with root package name */
        private b f1580a = null;

        /* renamed from: b  reason: collision with root package name */
        private ArrayList<a> f1581b = new ArrayList<>();

        /* renamed from: c  reason: collision with root package name */
        private long f1582c = 120;

        /* renamed from: d  reason: collision with root package name */
        private long f1583d = 120;

        /* renamed from: e  reason: collision with root package name */
        private long f1584e = 250;

        /* renamed from: f  reason: collision with root package name */
        private long f1585f = 250;

        public interface a {
            void a();
        }

        /* access modifiers changed from: package-private */
        public interface b {
            void a(d0 d0Var);
        }

        public static class c {

            /* renamed from: a  reason: collision with root package name */
            public int f1586a;

            /* renamed from: b  reason: collision with root package name */
            public int f1587b;

            public c a(d0 d0Var) {
                b(d0Var, 0);
                return this;
            }

            public c b(d0 d0Var, int i2) {
                View view = d0Var.f1565a;
                this.f1586a = view.getLeft();
                this.f1587b = view.getTop();
                view.getRight();
                view.getBottom();
                return this;
            }
        }

        static int e(d0 d0Var) {
            int i2 = d0Var.f1574j & 14;
            if (d0Var.t()) {
                return 4;
            }
            if ((i2 & 4) != 0) {
                return i2;
            }
            int n = d0Var.n();
            int j2 = d0Var.j();
            return (n == -1 || j2 == -1 || n == j2) ? i2 : i2 | 2048;
        }

        public abstract boolean a(d0 d0Var, c cVar, c cVar2);

        public abstract boolean b(d0 d0Var, d0 d0Var2, c cVar, c cVar2);

        public abstract boolean c(d0 d0Var, c cVar, c cVar2);

        public abstract boolean d(d0 d0Var, c cVar, c cVar2);

        public abstract boolean f(d0 d0Var);

        public boolean g(d0 d0Var, List<Object> list) {
            return f(d0Var);
        }

        public final void h(d0 d0Var) {
            s(d0Var);
            b bVar = this.f1580a;
            if (bVar != null) {
                bVar.a(d0Var);
            }
        }

        public final void i() {
            int size = this.f1581b.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f1581b.get(i2).a();
            }
            this.f1581b.clear();
        }

        public abstract void j(d0 d0Var);

        public abstract void k();

        public long l() {
            return this.f1582c;
        }

        public long m() {
            return this.f1585f;
        }

        public long n() {
            return this.f1584e;
        }

        public long o() {
            return this.f1583d;
        }

        public abstract boolean p();

        public final boolean q(a aVar) {
            boolean p = p();
            if (aVar != null) {
                if (!p) {
                    aVar.a();
                } else {
                    this.f1581b.add(aVar);
                }
            }
            return p;
        }

        public c r() {
            return new c();
        }

        public void s(d0 d0Var) {
        }

        public c t(a0 a0Var, d0 d0Var) {
            c r = r();
            r.a(d0Var);
            return r;
        }

        public c u(a0 a0Var, d0 d0Var, int i2, List<Object> list) {
            c r = r();
            r.a(d0Var);
            return r;
        }

        public abstract void v();

        /* access modifiers changed from: package-private */
        public void w(b bVar) {
            this.f1580a = bVar;
        }
    }

    private class m implements l.b {
        m() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.l.b
        public void a(d0 d0Var) {
            d0Var.G(true);
            if (d0Var.f1572h != null && d0Var.f1573i == null) {
                d0Var.f1572h = null;
            }
            d0Var.f1573i = null;
            if (!d0Var.I() && !RecyclerView.this.X0(d0Var.f1565a) && d0Var.x()) {
                RecyclerView.this.removeDetachedView(d0Var.f1565a, false);
            }
        }
    }

    public static abstract class n {
        @Deprecated
        public void f(Rect rect, int i2, RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        public void g(Rect rect, View view, RecyclerView recyclerView, a0 a0Var) {
            f(rect, ((p) view.getLayoutParams()).a(), recyclerView);
        }

        @Deprecated
        public void h(Canvas canvas, RecyclerView recyclerView) {
        }

        public void i(Canvas canvas, RecyclerView recyclerView, a0 a0Var) {
            h(canvas, recyclerView);
        }

        @Deprecated
        public void j(Canvas canvas, RecyclerView recyclerView) {
        }

        public void k(Canvas canvas, RecyclerView recyclerView, a0 a0Var) {
            j(canvas, recyclerView);
        }
    }

    public static abstract class o {

        /* renamed from: a  reason: collision with root package name */
        b f1589a;

        /* renamed from: b  reason: collision with root package name */
        RecyclerView f1590b;

        /* renamed from: c  reason: collision with root package name */
        private final r.b f1591c;

        /* renamed from: d  reason: collision with root package name */
        private final r.b f1592d;

        /* renamed from: e  reason: collision with root package name */
        r f1593e;

        /* renamed from: f  reason: collision with root package name */
        r f1594f;

        /* renamed from: g  reason: collision with root package name */
        z f1595g;

        /* renamed from: h  reason: collision with root package name */
        boolean f1596h = false;

        /* renamed from: i  reason: collision with root package name */
        boolean f1597i = false;

        /* renamed from: j  reason: collision with root package name */
        boolean f1598j = false;

        /* renamed from: k  reason: collision with root package name */
        private boolean f1599k = true;
        private boolean l = true;
        int m;
        boolean n;
        private int o;
        private int p;
        private int q;
        private int r;

        class a implements r.b {
            a() {
            }

            @Override // androidx.recyclerview.widget.r.b
            public View a(int i2) {
                return o.this.J(i2);
            }

            @Override // androidx.recyclerview.widget.r.b
            public int b() {
                return o.this.p0() - o.this.g0();
            }

            @Override // androidx.recyclerview.widget.r.b
            public int c(View view) {
                return o.this.R(view) - ((ViewGroup.MarginLayoutParams) ((p) view.getLayoutParams())).leftMargin;
            }

            @Override // androidx.recyclerview.widget.r.b
            public int d() {
                return o.this.f0();
            }

            @Override // androidx.recyclerview.widget.r.b
            public int e(View view) {
                return o.this.U(view) + ((ViewGroup.MarginLayoutParams) ((p) view.getLayoutParams())).rightMargin;
            }
        }

        class b implements r.b {
            b() {
            }

            @Override // androidx.recyclerview.widget.r.b
            public View a(int i2) {
                return o.this.J(i2);
            }

            @Override // androidx.recyclerview.widget.r.b
            public int b() {
                return o.this.X() - o.this.e0();
            }

            @Override // androidx.recyclerview.widget.r.b
            public int c(View view) {
                return o.this.V(view) - ((ViewGroup.MarginLayoutParams) ((p) view.getLayoutParams())).topMargin;
            }

            @Override // androidx.recyclerview.widget.r.b
            public int d() {
                return o.this.h0();
            }

            @Override // androidx.recyclerview.widget.r.b
            public int e(View view) {
                return o.this.P(view) + ((ViewGroup.MarginLayoutParams) ((p) view.getLayoutParams())).bottomMargin;
            }
        }

        public interface c {
            void a(int i2, int i3);
        }

        public static class d {

            /* renamed from: a  reason: collision with root package name */
            public int f1602a;

            /* renamed from: b  reason: collision with root package name */
            public int f1603b;

            /* renamed from: c  reason: collision with root package name */
            public boolean f1604c;

            /* renamed from: d  reason: collision with root package name */
            public boolean f1605d;
        }

        public o() {
            a aVar = new a();
            this.f1591c = aVar;
            b bVar = new b();
            this.f1592d = bVar;
            this.f1593e = new r(aVar);
            this.f1594f = new r(bVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0017, code lost:
            if (r5 == 1073741824) goto L_0x0021;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static int L(int r4, int r5, int r6, int r7, boolean r8) {
            /*
                int r4 = r4 - r6
                r6 = 0
                int r4 = java.lang.Math.max(r6, r4)
                r0 = -2
                r1 = -1
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = 1073741824(0x40000000, float:2.0)
                if (r8 == 0) goto L_0x001a
                if (r7 < 0) goto L_0x0011
                goto L_0x001c
            L_0x0011:
                if (r7 != r1) goto L_0x002f
                if (r5 == r2) goto L_0x0021
                if (r5 == 0) goto L_0x002f
                if (r5 == r3) goto L_0x0021
                goto L_0x002f
            L_0x001a:
                if (r7 < 0) goto L_0x001f
            L_0x001c:
                r5 = 1073741824(0x40000000, float:2.0)
                goto L_0x0031
            L_0x001f:
                if (r7 != r1) goto L_0x0023
            L_0x0021:
                r7 = r4
                goto L_0x0031
            L_0x0023:
                if (r7 != r0) goto L_0x002f
                if (r5 == r2) goto L_0x002c
                if (r5 != r3) goto L_0x002a
                goto L_0x002c
            L_0x002a:
                r5 = 0
                goto L_0x0021
            L_0x002c:
                r5 = -2147483648(0xffffffff80000000, float:-0.0)
                goto L_0x0021
            L_0x002f:
                r5 = 0
                r7 = 0
            L_0x0031:
                int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r5)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.o.L(int, int, int, int, boolean):int");
        }

        private int[] M(View view, Rect rect) {
            int[] iArr = new int[2];
            int f0 = f0();
            int h0 = h0();
            int p0 = p0() - g0();
            int X = X() - e0();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int width = rect.width() + left;
            int height = rect.height() + top;
            int i2 = left - f0;
            int min = Math.min(0, i2);
            int i3 = top - h0;
            int min2 = Math.min(0, i3);
            int i4 = width - p0;
            int max = Math.max(0, i4);
            int max2 = Math.max(0, height - X);
            if (a0() != 1) {
                if (min == 0) {
                    min = Math.min(i2, max);
                }
                max = min;
            } else if (max == 0) {
                max = Math.max(min, i4);
            }
            if (min2 == 0) {
                min2 = Math.min(i3, max2);
            }
            iArr[0] = max;
            iArr[1] = min2;
            return iArr;
        }

        private void g(View view, int i2, boolean z) {
            d0 i0 = RecyclerView.i0(view);
            if (z || i0.v()) {
                this.f1590b.f1539g.b(i0);
            } else {
                this.f1590b.f1539g.p(i0);
            }
            p pVar = (p) view.getLayoutParams();
            if (i0.L() || i0.w()) {
                if (i0.w()) {
                    i0.K();
                } else {
                    i0.e();
                }
                this.f1589a.c(view, i2, view.getLayoutParams(), false);
            } else if (view.getParent() == this.f1590b) {
                int m2 = this.f1589a.m(view);
                if (i2 == -1) {
                    i2 = this.f1589a.g();
                }
                if (m2 == -1) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.f1590b.indexOfChild(view) + this.f1590b.Q());
                } else if (m2 != i2) {
                    this.f1590b.n.C0(m2, i2);
                }
            } else {
                this.f1589a.a(view, i2, false);
                pVar.f1608c = true;
                z zVar = this.f1595g;
                if (zVar != null && zVar.h()) {
                    this.f1595g.k(view);
                }
            }
            if (pVar.f1609d) {
                i0.f1565a.invalidate();
                pVar.f1609d = false;
            }
        }

        public static d j0(Context context, AttributeSet attributeSet, int i2, int i3) {
            d dVar = new d();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.q.d.f2822a, i2, i3);
            dVar.f1602a = obtainStyledAttributes.getInt(b.q.d.f2823b, 1);
            dVar.f1603b = obtainStyledAttributes.getInt(b.q.d.l, 1);
            dVar.f1604c = obtainStyledAttributes.getBoolean(b.q.d.f2832k, false);
            dVar.f1605d = obtainStyledAttributes.getBoolean(b.q.d.m, false);
            obtainStyledAttributes.recycle();
            return dVar;
        }

        public static int o(int i2, int i3, int i4) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (mode != Integer.MIN_VALUE) {
                return mode != 1073741824 ? Math.max(i3, i4) : size;
            }
            return Math.min(size, Math.max(i3, i4));
        }

        private boolean u0(RecyclerView recyclerView, int i2, int i3) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int f0 = f0();
            int h0 = h0();
            int p0 = p0() - g0();
            int X = X() - e0();
            Rect rect = this.f1590b.f1542j;
            Q(focusedChild, rect);
            if (rect.left - i2 >= p0 || rect.right - i2 <= f0 || rect.top - i3 >= X || rect.bottom - i3 <= h0) {
                return false;
            }
            return true;
        }

        private void w1(v vVar, int i2, View view) {
            d0 i0 = RecyclerView.i0(view);
            if (!i0.J()) {
                if (!i0.t() || i0.v() || this.f1590b.m.g()) {
                    y(i2);
                    vVar.D(view);
                    this.f1590b.f1539g.k(i0);
                    return;
                }
                r1(i2);
                vVar.C(i0);
            }
        }

        private static boolean x0(int i2, int i3, int i4) {
            int mode = View.MeasureSpec.getMode(i3);
            int size = View.MeasureSpec.getSize(i3);
            if (i4 > 0 && i2 != i4) {
                return false;
            }
            if (mode == Integer.MIN_VALUE) {
                return size >= i2;
            }
            if (mode != 0) {
                return mode == 1073741824 && size == i2;
            }
            return true;
        }

        private void z(int i2, View view) {
            this.f1589a.d(i2);
        }

        /* access modifiers changed from: package-private */
        public void A(RecyclerView recyclerView) {
            this.f1597i = true;
            H0(recyclerView);
        }

        public void A0(View view, int i2, int i3, int i4, int i5) {
            p pVar = (p) view.getLayoutParams();
            Rect rect = pVar.f1607b;
            view.layout(i2 + rect.left + ((ViewGroup.MarginLayoutParams) pVar).leftMargin, i3 + rect.top + ((ViewGroup.MarginLayoutParams) pVar).topMargin, (i4 - rect.right) - ((ViewGroup.MarginLayoutParams) pVar).rightMargin, (i5 - rect.bottom) - ((ViewGroup.MarginLayoutParams) pVar).bottomMargin);
        }

        /* access modifiers changed from: package-private */
        public void A1(RecyclerView recyclerView) {
            B1(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        /* access modifiers changed from: package-private */
        public void B(RecyclerView recyclerView, v vVar) {
            this.f1597i = false;
            J0(recyclerView, vVar);
        }

        public void B0(View view, int i2, int i3) {
            p pVar = (p) view.getLayoutParams();
            Rect m0 = this.f1590b.m0(view);
            int i4 = i2 + m0.left + m0.right;
            int i5 = i3 + m0.top + m0.bottom;
            int L = L(p0(), q0(), f0() + g0() + ((ViewGroup.MarginLayoutParams) pVar).leftMargin + ((ViewGroup.MarginLayoutParams) pVar).rightMargin + i4, ((ViewGroup.MarginLayoutParams) pVar).width, l());
            int L2 = L(X(), Y(), h0() + e0() + ((ViewGroup.MarginLayoutParams) pVar).topMargin + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin + i5, ((ViewGroup.MarginLayoutParams) pVar).height, m());
            if (G1(view, L, L2, pVar)) {
                view.measure(L, L2);
            }
        }

        /* access modifiers changed from: package-private */
        public void B1(int i2, int i3) {
            this.q = View.MeasureSpec.getSize(i2);
            int mode = View.MeasureSpec.getMode(i2);
            this.o = mode;
            if (mode == 0 && !RecyclerView.B0) {
                this.q = 0;
            }
            this.r = View.MeasureSpec.getSize(i3);
            int mode2 = View.MeasureSpec.getMode(i3);
            this.p = mode2;
            if (mode2 == 0 && !RecyclerView.B0) {
                this.r = 0;
            }
        }

        public View C(View view) {
            View T;
            RecyclerView recyclerView = this.f1590b;
            if (recyclerView == null || (T = recyclerView.T(view)) == null || this.f1589a.n(T)) {
                return null;
            }
            return T;
        }

        public void C0(int i2, int i3) {
            View J = J(i2);
            if (J != null) {
                y(i2);
                i(J, i3);
                return;
            }
            throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i2 + this.f1590b.toString());
        }

        public void C1(int i2, int i3) {
            this.f1590b.setMeasuredDimension(i2, i3);
        }

        public View D(int i2) {
            int K = K();
            for (int i3 = 0; i3 < K; i3++) {
                View J = J(i3);
                d0 i0 = RecyclerView.i0(J);
                if (i0 != null && i0.m() == i2 && !i0.J() && (this.f1590b.i0.e() || !i0.v())) {
                    return J;
                }
            }
            return null;
        }

        public void D0(int i2) {
            RecyclerView recyclerView = this.f1590b;
            if (recyclerView != null) {
                recyclerView.B0(i2);
            }
        }

        public void D1(Rect rect, int i2, int i3) {
            C1(o(i2, rect.width() + f0() + g0(), d0()), o(i3, rect.height() + h0() + e0(), c0()));
        }

        public abstract p E();

        public void E0(int i2) {
            RecyclerView recyclerView = this.f1590b;
            if (recyclerView != null) {
                recyclerView.C0(i2);
            }
        }

        /* access modifiers changed from: package-private */
        public void E1(int i2, int i3) {
            int K = K();
            if (K == 0) {
                this.f1590b.x(i2, i3);
                return;
            }
            int i4 = Integer.MIN_VALUE;
            int i5 = Integer.MIN_VALUE;
            int i6 = Integer.MAX_VALUE;
            int i7 = Integer.MAX_VALUE;
            for (int i8 = 0; i8 < K; i8++) {
                View J = J(i8);
                Rect rect = this.f1590b.f1542j;
                Q(J, rect);
                int i9 = rect.left;
                if (i9 < i6) {
                    i6 = i9;
                }
                int i10 = rect.right;
                if (i10 > i4) {
                    i4 = i10;
                }
                int i11 = rect.top;
                if (i11 < i7) {
                    i7 = i11;
                }
                int i12 = rect.bottom;
                if (i12 > i5) {
                    i5 = i12;
                }
            }
            this.f1590b.f1542j.set(i6, i7, i4, i5);
            D1(this.f1590b.f1542j, i2, i3);
        }

        public p F(Context context, AttributeSet attributeSet) {
            return new p(context, attributeSet);
        }

        public void F0(g gVar, g gVar2) {
        }

        /* access modifiers changed from: package-private */
        public void F1(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.f1590b = null;
                this.f1589a = null;
                this.q = 0;
                this.r = 0;
            } else {
                this.f1590b = recyclerView;
                this.f1589a = recyclerView.f1538f;
                this.q = recyclerView.getWidth();
                this.r = recyclerView.getHeight();
            }
            this.o = 1073741824;
            this.p = 1073741824;
        }

        public p G(ViewGroup.LayoutParams layoutParams) {
            if (layoutParams instanceof p) {
                return new p((p) layoutParams);
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                return new p((ViewGroup.MarginLayoutParams) layoutParams);
            }
            return new p(layoutParams);
        }

        public boolean G0(RecyclerView recyclerView, ArrayList<View> arrayList, int i2, int i3) {
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean G1(View view, int i2, int i3, p pVar) {
            return view.isLayoutRequested() || !this.f1599k || !x0(view.getWidth(), i2, ((ViewGroup.MarginLayoutParams) pVar).width) || !x0(view.getHeight(), i3, ((ViewGroup.MarginLayoutParams) pVar).height);
        }

        public int H() {
            return -1;
        }

        public void H0(RecyclerView recyclerView) {
        }

        /* access modifiers changed from: package-private */
        public boolean H1() {
            return false;
        }

        public int I(View view) {
            return ((p) view.getLayoutParams()).f1607b.bottom;
        }

        @Deprecated
        public void I0(RecyclerView recyclerView) {
        }

        /* access modifiers changed from: package-private */
        public boolean I1(View view, int i2, int i3, p pVar) {
            return !this.f1599k || !x0(view.getMeasuredWidth(), i2, ((ViewGroup.MarginLayoutParams) pVar).width) || !x0(view.getMeasuredHeight(), i3, ((ViewGroup.MarginLayoutParams) pVar).height);
        }

        public View J(int i2) {
            b bVar = this.f1589a;
            if (bVar != null) {
                return bVar.f(i2);
            }
            return null;
        }

        public void J0(RecyclerView recyclerView, v vVar) {
            I0(recyclerView);
        }

        public void J1(RecyclerView recyclerView, a0 a0Var, int i2) {
            Log.e("RecyclerView", "You must override smoothScrollToPosition to support smooth scrolling");
        }

        public int K() {
            b bVar = this.f1589a;
            if (bVar != null) {
                return bVar.g();
            }
            return 0;
        }

        public View K0(View view, int i2, v vVar, a0 a0Var) {
            return null;
        }

        public void K1(z zVar) {
            z zVar2 = this.f1595g;
            if (!(zVar2 == null || zVar == zVar2 || !zVar2.h())) {
                this.f1595g.r();
            }
            this.f1595g = zVar;
            zVar.q(this.f1590b, this);
        }

        public void L0(AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f1590b;
            M0(recyclerView.f1535c, recyclerView.i0, accessibilityEvent);
        }

        /* access modifiers changed from: package-private */
        public void L1() {
            z zVar = this.f1595g;
            if (zVar != null) {
                zVar.r();
            }
        }

        public void M0(v vVar, a0 a0Var, AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f1590b;
            if (recyclerView != null && accessibilityEvent != null) {
                boolean z = true;
                if (!recyclerView.canScrollVertically(1) && !this.f1590b.canScrollVertically(-1) && !this.f1590b.canScrollHorizontally(-1) && !this.f1590b.canScrollHorizontally(1)) {
                    z = false;
                }
                accessibilityEvent.setScrollable(z);
                g gVar = this.f1590b.m;
                if (gVar != null) {
                    accessibilityEvent.setItemCount(gVar.c());
                }
            }
        }

        public boolean M1() {
            return false;
        }

        public boolean N() {
            RecyclerView recyclerView = this.f1590b;
            return recyclerView != null && recyclerView.f1540h;
        }

        /* access modifiers changed from: package-private */
        public void N0(b.h.k.d0.c cVar) {
            RecyclerView recyclerView = this.f1590b;
            O0(recyclerView.f1535c, recyclerView.i0, cVar);
        }

        public int O(v vVar, a0 a0Var) {
            RecyclerView recyclerView = this.f1590b;
            if (recyclerView == null || recyclerView.m == null || !l()) {
                return 1;
            }
            return this.f1590b.m.c();
        }

        public void O0(v vVar, a0 a0Var, b.h.k.d0.c cVar) {
            if (this.f1590b.canScrollVertically(-1) || this.f1590b.canScrollHorizontally(-1)) {
                cVar.a(8192);
                cVar.u0(true);
            }
            if (this.f1590b.canScrollVertically(1) || this.f1590b.canScrollHorizontally(1)) {
                cVar.a(4096);
                cVar.u0(true);
            }
            cVar.c0(c.b.a(l0(vVar, a0Var), O(vVar, a0Var), w0(vVar, a0Var), m0(vVar, a0Var)));
        }

        public int P(View view) {
            return view.getBottom() + I(view);
        }

        /* access modifiers changed from: package-private */
        public void P0(View view, b.h.k.d0.c cVar) {
            d0 i0 = RecyclerView.i0(view);
            if (i0 != null && !i0.v() && !this.f1589a.n(i0.f1565a)) {
                RecyclerView recyclerView = this.f1590b;
                Q0(recyclerView.f1535c, recyclerView.i0, view, cVar);
            }
        }

        public void Q(View view, Rect rect) {
            RecyclerView.j0(view, rect);
        }

        public void Q0(v vVar, a0 a0Var, View view, b.h.k.d0.c cVar) {
            cVar.d0(c.C0048c.a(m() ? i0(view) : 0, 1, l() ? i0(view) : 0, 1, false, false));
        }

        public int R(View view) {
            return view.getLeft() - b0(view);
        }

        public View R0(View view, int i2) {
            return null;
        }

        public int S(View view) {
            Rect rect = ((p) view.getLayoutParams()).f1607b;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public void S0(RecyclerView recyclerView, int i2, int i3) {
        }

        public int T(View view) {
            Rect rect = ((p) view.getLayoutParams()).f1607b;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public void T0(RecyclerView recyclerView) {
        }

        public int U(View view) {
            return view.getRight() + k0(view);
        }

        public void U0(RecyclerView recyclerView, int i2, int i3, int i4) {
        }

        public int V(View view) {
            return view.getTop() - n0(view);
        }

        public void V0(RecyclerView recyclerView, int i2, int i3) {
        }

        public View W() {
            View focusedChild;
            RecyclerView recyclerView = this.f1590b;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.f1589a.n(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public void W0(RecyclerView recyclerView, int i2, int i3) {
        }

        public int X() {
            return this.r;
        }

        public void X0(RecyclerView recyclerView, int i2, int i3, Object obj) {
            W0(recyclerView, i2, i3);
        }

        public int Y() {
            return this.p;
        }

        public void Y0(v vVar, a0 a0Var) {
            Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public int Z() {
            RecyclerView recyclerView = this.f1590b;
            g adapter = recyclerView != null ? recyclerView.getAdapter() : null;
            if (adapter != null) {
                return adapter.c();
            }
            return 0;
        }

        public void Z0(a0 a0Var) {
        }

        public int a0() {
            return b.h.k.u.B(this.f1590b);
        }

        public void a1(v vVar, a0 a0Var, int i2, int i3) {
            this.f1590b.x(i2, i3);
        }

        public int b0(View view) {
            return ((p) view.getLayoutParams()).f1607b.left;
        }

        @Deprecated
        public boolean b1(RecyclerView recyclerView, View view, View view2) {
            return y0() || recyclerView.w0();
        }

        public void c(View view) {
            d(view, -1);
        }

        public int c0() {
            return b.h.k.u.C(this.f1590b);
        }

        public boolean c1(RecyclerView recyclerView, a0 a0Var, View view, View view2) {
            return b1(recyclerView, view, view2);
        }

        public void d(View view, int i2) {
            g(view, i2, true);
        }

        public int d0() {
            return b.h.k.u.D(this.f1590b);
        }

        public void d1(Parcelable parcelable) {
        }

        public void e(View view) {
            f(view, -1);
        }

        public int e0() {
            RecyclerView recyclerView = this.f1590b;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public Parcelable e1() {
            return null;
        }

        public void f(View view, int i2) {
            g(view, i2, false);
        }

        public int f0() {
            RecyclerView recyclerView = this.f1590b;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public void f1(int i2) {
        }

        public int g0() {
            RecyclerView recyclerView = this.f1590b;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        /* access modifiers changed from: package-private */
        public void g1(z zVar) {
            if (this.f1595g == zVar) {
                this.f1595g = null;
            }
        }

        public void h(String str) {
            RecyclerView recyclerView = this.f1590b;
            if (recyclerView != null) {
                recyclerView.p(str);
            }
        }

        public int h0() {
            RecyclerView recyclerView = this.f1590b;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        /* access modifiers changed from: package-private */
        public boolean h1(int i2, Bundle bundle) {
            RecyclerView recyclerView = this.f1590b;
            return i1(recyclerView.f1535c, recyclerView.i0, i2, bundle);
        }

        public void i(View view, int i2) {
            j(view, i2, (p) view.getLayoutParams());
        }

        public int i0(View view) {
            return ((p) view.getLayoutParams()).a();
        }

        /* JADX WARNING: Removed duplicated region for block: B:25:0x0075 A[ADDED_TO_REGION] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean i1(androidx.recyclerview.widget.RecyclerView.v r8, androidx.recyclerview.widget.RecyclerView.a0 r9, int r10, android.os.Bundle r11) {
            /*
            // Method dump skipped, instructions count: 130
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.o.i1(androidx.recyclerview.widget.RecyclerView$v, androidx.recyclerview.widget.RecyclerView$a0, int, android.os.Bundle):boolean");
        }

        public void j(View view, int i2, p pVar) {
            d0 i0 = RecyclerView.i0(view);
            if (i0.v()) {
                this.f1590b.f1539g.b(i0);
            } else {
                this.f1590b.f1539g.p(i0);
            }
            this.f1589a.c(view, i2, pVar, i0.v());
        }

        /* access modifiers changed from: package-private */
        public boolean j1(View view, int i2, Bundle bundle) {
            RecyclerView recyclerView = this.f1590b;
            return k1(recyclerView.f1535c, recyclerView.i0, view, i2, bundle);
        }

        public void k(View view, Rect rect) {
            RecyclerView recyclerView = this.f1590b;
            if (recyclerView == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(recyclerView.m0(view));
            }
        }

        public int k0(View view) {
            return ((p) view.getLayoutParams()).f1607b.right;
        }

        public boolean k1(v vVar, a0 a0Var, View view, int i2, Bundle bundle) {
            return false;
        }

        public boolean l() {
            return false;
        }

        public int l0(v vVar, a0 a0Var) {
            RecyclerView recyclerView = this.f1590b;
            if (recyclerView == null || recyclerView.m == null || !m()) {
                return 1;
            }
            return this.f1590b.m.c();
        }

        public void l1(v vVar) {
            for (int K = K() - 1; K >= 0; K--) {
                if (!RecyclerView.i0(J(K)).J()) {
                    o1(K, vVar);
                }
            }
        }

        public boolean m() {
            return false;
        }

        public int m0(v vVar, a0 a0Var) {
            return 0;
        }

        /* access modifiers changed from: package-private */
        public void m1(v vVar) {
            int j2 = vVar.j();
            for (int i2 = j2 - 1; i2 >= 0; i2--) {
                View n2 = vVar.n(i2);
                d0 i0 = RecyclerView.i0(n2);
                if (!i0.J()) {
                    i0.G(false);
                    if (i0.x()) {
                        this.f1590b.removeDetachedView(n2, false);
                    }
                    l lVar = this.f1590b.N;
                    if (lVar != null) {
                        lVar.j(i0);
                    }
                    i0.G(true);
                    vVar.y(n2);
                }
            }
            vVar.e();
            if (j2 > 0) {
                this.f1590b.invalidate();
            }
        }

        public boolean n(p pVar) {
            return pVar != null;
        }

        public int n0(View view) {
            return ((p) view.getLayoutParams()).f1607b.top;
        }

        public void n1(View view, v vVar) {
            q1(view);
            vVar.B(view);
        }

        public void o0(View view, boolean z, Rect rect) {
            Matrix matrix;
            if (z) {
                Rect rect2 = ((p) view.getLayoutParams()).f1607b;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (!(this.f1590b == null || (matrix = view.getMatrix()) == null || matrix.isIdentity())) {
                RectF rectF = this.f1590b.l;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor((double) rectF.left), (int) Math.floor((double) rectF.top), (int) Math.ceil((double) rectF.right), (int) Math.ceil((double) rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public void o1(int i2, v vVar) {
            View J = J(i2);
            r1(i2);
            vVar.B(J);
        }

        public void p(int i2, int i3, a0 a0Var, c cVar) {
        }

        public int p0() {
            return this.q;
        }

        public boolean p1(Runnable runnable) {
            RecyclerView recyclerView = this.f1590b;
            if (recyclerView != null) {
                return recyclerView.removeCallbacks(runnable);
            }
            return false;
        }

        public void q(int i2, c cVar) {
        }

        public int q0() {
            return this.o;
        }

        public void q1(View view) {
            this.f1589a.p(view);
        }

        public int r(a0 a0Var) {
            return 0;
        }

        /* access modifiers changed from: package-private */
        public boolean r0() {
            int K = K();
            for (int i2 = 0; i2 < K; i2++) {
                ViewGroup.LayoutParams layoutParams = J(i2).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }

        public void r1(int i2) {
            if (J(i2) != null) {
                this.f1589a.q(i2);
            }
        }

        public int s(a0 a0Var) {
            return 0;
        }

        public boolean s0() {
            return this.f1597i;
        }

        public boolean s1(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            return t1(recyclerView, view, rect, z, false);
        }

        public int t(a0 a0Var) {
            return 0;
        }

        public boolean t0() {
            return this.f1598j;
        }

        public boolean t1(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
            int[] M = M(view, rect);
            int i2 = M[0];
            int i3 = M[1];
            if ((z2 && !u0(recyclerView, i2, i3)) || (i2 == 0 && i3 == 0)) {
                return false;
            }
            if (z) {
                recyclerView.scrollBy(i2, i3);
            } else {
                recyclerView.o1(i2, i3);
            }
            return true;
        }

        public int u(a0 a0Var) {
            return 0;
        }

        public void u1() {
            RecyclerView recyclerView = this.f1590b;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public int v(a0 a0Var) {
            return 0;
        }

        public final boolean v0() {
            return this.l;
        }

        public void v1() {
            this.f1596h = true;
        }

        public int w(a0 a0Var) {
            return 0;
        }

        public boolean w0(v vVar, a0 a0Var) {
            return false;
        }

        public void x(v vVar) {
            for (int K = K() - 1; K >= 0; K--) {
                w1(vVar, K, J(K));
            }
        }

        public int x1(int i2, v vVar, a0 a0Var) {
            return 0;
        }

        public void y(int i2) {
            z(i2, J(i2));
        }

        public boolean y0() {
            z zVar = this.f1595g;
            return zVar != null && zVar.h();
        }

        public void y1(int i2) {
        }

        public boolean z0(View view, boolean z, boolean z2) {
            boolean z3 = this.f1593e.b(view, 24579) && this.f1594f.b(view, 24579);
            return z ? z3 : !z3;
        }

        public int z1(int i2, v vVar, a0 a0Var) {
            return 0;
        }
    }

    public interface q {
        void b(View view);

        void d(View view);
    }

    public static abstract class r {
        public abstract boolean a(int i2, int i3);
    }

    public interface s {
        boolean a(RecyclerView recyclerView, MotionEvent motionEvent);

        void c(RecyclerView recyclerView, MotionEvent motionEvent);

        void e(boolean z);
    }

    public static abstract class t {
        public void a(RecyclerView recyclerView, int i2) {
        }

        public void b(RecyclerView recyclerView, int i2, int i3) {
        }
    }

    public static class u {

        /* renamed from: a  reason: collision with root package name */
        SparseArray<a> f1610a = new SparseArray<>();

        /* renamed from: b  reason: collision with root package name */
        private int f1611b = 0;

        /* access modifiers changed from: package-private */
        public static class a {

            /* renamed from: a  reason: collision with root package name */
            final ArrayList<d0> f1612a = new ArrayList<>();

            /* renamed from: b  reason: collision with root package name */
            int f1613b = 5;

            /* renamed from: c  reason: collision with root package name */
            long f1614c = 0;

            /* renamed from: d  reason: collision with root package name */
            long f1615d = 0;

            a() {
            }
        }

        private a g(int i2) {
            a aVar = this.f1610a.get(i2);
            if (aVar != null) {
                return aVar;
            }
            a aVar2 = new a();
            this.f1610a.put(i2, aVar2);
            return aVar2;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f1611b++;
        }

        public void b() {
            for (int i2 = 0; i2 < this.f1610a.size(); i2++) {
                this.f1610a.valueAt(i2).f1612a.clear();
            }
        }

        /* access modifiers changed from: package-private */
        public void c() {
            this.f1611b--;
        }

        /* access modifiers changed from: package-private */
        public void d(int i2, long j2) {
            a g2 = g(i2);
            g2.f1615d = j(g2.f1615d, j2);
        }

        /* access modifiers changed from: package-private */
        public void e(int i2, long j2) {
            a g2 = g(i2);
            g2.f1614c = j(g2.f1614c, j2);
        }

        public d0 f(int i2) {
            a aVar = this.f1610a.get(i2);
            if (aVar == null || aVar.f1612a.isEmpty()) {
                return null;
            }
            ArrayList<d0> arrayList = aVar.f1612a;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (!arrayList.get(size).r()) {
                    return arrayList.remove(size);
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public void h(g gVar, g gVar2, boolean z) {
            if (gVar != null) {
                c();
            }
            if (!z && this.f1611b == 0) {
                b();
            }
            if (gVar2 != null) {
                a();
            }
        }

        public void i(d0 d0Var) {
            int l = d0Var.l();
            ArrayList<d0> arrayList = g(l).f1612a;
            if (this.f1610a.get(l).f1613b > arrayList.size()) {
                d0Var.D();
                arrayList.add(d0Var);
            }
        }

        /* access modifiers changed from: package-private */
        public long j(long j2, long j3) {
            return j2 == 0 ? j3 : ((j2 / 4) * 3) + (j3 / 4);
        }

        /* access modifiers changed from: package-private */
        public boolean k(int i2, long j2, long j3) {
            long j4 = g(i2).f1615d;
            return j4 == 0 || j2 + j4 < j3;
        }

        /* access modifiers changed from: package-private */
        public boolean l(int i2, long j2, long j3) {
            long j4 = g(i2).f1614c;
            return j4 == 0 || j2 + j4 < j3;
        }
    }

    public final class v {

        /* renamed from: a  reason: collision with root package name */
        final ArrayList<d0> f1616a;

        /* renamed from: b  reason: collision with root package name */
        ArrayList<d0> f1617b = null;

        /* renamed from: c  reason: collision with root package name */
        final ArrayList<d0> f1618c = new ArrayList<>();

        /* renamed from: d  reason: collision with root package name */
        private final List<d0> f1619d;

        /* renamed from: e  reason: collision with root package name */
        private int f1620e;

        /* renamed from: f  reason: collision with root package name */
        int f1621f;

        /* renamed from: g  reason: collision with root package name */
        u f1622g;

        /* renamed from: h  reason: collision with root package name */
        private b0 f1623h;

        public v() {
            ArrayList<d0> arrayList = new ArrayList<>();
            this.f1616a = arrayList;
            this.f1619d = Collections.unmodifiableList(arrayList);
            this.f1620e = 2;
            this.f1621f = 2;
        }

        private boolean H(d0 d0Var, int i2, int i3, long j2) {
            d0Var.r = RecyclerView.this;
            int l = d0Var.l();
            long nanoTime = RecyclerView.this.getNanoTime();
            if (j2 != Long.MAX_VALUE && !this.f1622g.k(l, nanoTime, j2)) {
                return false;
            }
            RecyclerView.this.m.a(d0Var, i2);
            this.f1622g.d(d0Var.l(), RecyclerView.this.getNanoTime() - nanoTime);
            b(d0Var);
            if (!RecyclerView.this.i0.e()) {
                return true;
            }
            d0Var.f1571g = i3;
            return true;
        }

        private void b(d0 d0Var) {
            if (RecyclerView.this.v0()) {
                View view = d0Var.f1565a;
                if (b.h.k.u.z(view) == 0) {
                    b.h.k.u.x0(view, 1);
                }
                n nVar = RecyclerView.this.p0;
                if (nVar != null) {
                    b.h.k.a n = nVar.n();
                    if (n instanceof n.a) {
                        ((n.a) n).o(view);
                    }
                    b.h.k.u.m0(view, n);
                }
            }
        }

        private void q(ViewGroup viewGroup, boolean z) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    q((ViewGroup) childAt, true);
                }
            }
            if (z) {
                if (viewGroup.getVisibility() == 4) {
                    viewGroup.setVisibility(0);
                    viewGroup.setVisibility(4);
                    return;
                }
                int visibility = viewGroup.getVisibility();
                viewGroup.setVisibility(4);
                viewGroup.setVisibility(visibility);
            }
        }

        private void r(d0 d0Var) {
            View view = d0Var.f1565a;
            if (view instanceof ViewGroup) {
                q((ViewGroup) view, false);
            }
        }

        /* access modifiers changed from: package-private */
        public void A(int i2) {
            a(this.f1618c.get(i2), true);
            this.f1618c.remove(i2);
        }

        public void B(View view) {
            d0 i0 = RecyclerView.i0(view);
            if (i0.x()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (i0.w()) {
                i0.K();
            } else if (i0.L()) {
                i0.e();
            }
            C(i0);
            if (RecyclerView.this.N != null && !i0.u()) {
                RecyclerView.this.N.j(i0);
            }
        }

        /* access modifiers changed from: package-private */
        public void C(d0 d0Var) {
            boolean z;
            boolean z2 = false;
            boolean z3 = true;
            if (d0Var.w() || d0Var.f1565a.getParent() != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Scrapped or attached views may not be recycled. isScrap:");
                sb.append(d0Var.w());
                sb.append(" isAttached:");
                if (d0Var.f1565a.getParent() != null) {
                    z2 = true;
                }
                sb.append(z2);
                sb.append(RecyclerView.this.Q());
                throw new IllegalArgumentException(sb.toString());
            } else if (d0Var.x()) {
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + d0Var + RecyclerView.this.Q());
            } else if (!d0Var.J()) {
                boolean h2 = d0Var.h();
                g gVar = RecyclerView.this.m;
                if ((gVar != null && h2 && gVar.q(d0Var)) || d0Var.u()) {
                    if (this.f1621f <= 0 || d0Var.p(526)) {
                        z = false;
                    } else {
                        int size = this.f1618c.size();
                        if (size >= this.f1621f && size > 0) {
                            A(0);
                            size--;
                        }
                        if (RecyclerView.D0 && size > 0 && !RecyclerView.this.h0.d(d0Var.f1567c)) {
                            int i2 = size - 1;
                            while (i2 >= 0) {
                                if (!RecyclerView.this.h0.d(this.f1618c.get(i2).f1567c)) {
                                    break;
                                }
                                i2--;
                            }
                            size = i2 + 1;
                        }
                        this.f1618c.add(size, d0Var);
                        z = true;
                    }
                    if (!z) {
                        a(d0Var, true);
                        z2 = z;
                        RecyclerView.this.f1539g.q(d0Var);
                        if (!z2 && !z3 && h2) {
                            d0Var.r = null;
                            return;
                        }
                        return;
                    }
                    z2 = z;
                }
                z3 = false;
                RecyclerView.this.f1539g.q(d0Var);
                if (!z2) {
                }
            } else {
                throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.Q());
            }
        }

        /* access modifiers changed from: package-private */
        public void D(View view) {
            d0 i0 = RecyclerView.i0(view);
            if (!i0.p(12) && i0.y() && !RecyclerView.this.q(i0)) {
                if (this.f1617b == null) {
                    this.f1617b = new ArrayList<>();
                }
                i0.H(this, true);
                this.f1617b.add(i0);
            } else if (!i0.t() || i0.v() || RecyclerView.this.m.g()) {
                i0.H(this, false);
                this.f1616a.add(i0);
            } else {
                throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + RecyclerView.this.Q());
            }
        }

        /* access modifiers changed from: package-private */
        public void E(u uVar) {
            u uVar2 = this.f1622g;
            if (uVar2 != null) {
                uVar2.c();
            }
            this.f1622g = uVar;
            if (uVar != null && RecyclerView.this.getAdapter() != null) {
                this.f1622g.a();
            }
        }

        /* access modifiers changed from: package-private */
        public void F(b0 b0Var) {
        }

        public void G(int i2) {
            this.f1620e = i2;
            K();
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x0037  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x005c  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x005f  */
        /* JADX WARNING: Removed duplicated region for block: B:79:0x01a2  */
        /* JADX WARNING: Removed duplicated region for block: B:82:0x01c5  */
        /* JADX WARNING: Removed duplicated region for block: B:95:0x01fe  */
        /* JADX WARNING: Removed duplicated region for block: B:96:0x020c  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public androidx.recyclerview.widget.RecyclerView.d0 I(int r17, boolean r18, long r19) {
            /*
            // Method dump skipped, instructions count: 615
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.v.I(int, boolean, long):androidx.recyclerview.widget.RecyclerView$d0");
        }

        /* access modifiers changed from: package-private */
        public void J(d0 d0Var) {
            if (d0Var.o) {
                this.f1617b.remove(d0Var);
            } else {
                this.f1616a.remove(d0Var);
            }
            d0Var.n = null;
            d0Var.o = false;
            d0Var.e();
        }

        /* access modifiers changed from: package-private */
        public void K() {
            o oVar = RecyclerView.this.n;
            this.f1621f = this.f1620e + (oVar != null ? oVar.m : 0);
            for (int size = this.f1618c.size() - 1; size >= 0 && this.f1618c.size() > this.f1621f; size--) {
                A(size);
            }
        }

        /* access modifiers changed from: package-private */
        public boolean L(d0 d0Var) {
            if (d0Var.v()) {
                return RecyclerView.this.i0.e();
            }
            int i2 = d0Var.f1567c;
            if (i2 < 0 || i2 >= RecyclerView.this.m.c()) {
                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + d0Var + RecyclerView.this.Q());
            } else if (!RecyclerView.this.i0.e() && RecyclerView.this.m.e(d0Var.f1567c) != d0Var.l()) {
                return false;
            } else {
                if (!RecyclerView.this.m.g() || d0Var.k() == RecyclerView.this.m.d(d0Var.f1567c)) {
                    return true;
                }
                return false;
            }
        }

        /* access modifiers changed from: package-private */
        public void M(int i2, int i3) {
            int i4;
            int i5 = i3 + i2;
            for (int size = this.f1618c.size() - 1; size >= 0; size--) {
                d0 d0Var = this.f1618c.get(size);
                if (d0Var != null && (i4 = d0Var.f1567c) >= i2 && i4 < i5) {
                    d0Var.b(2);
                    A(size);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void a(d0 d0Var, boolean z) {
            RecyclerView.s(d0Var);
            View view = d0Var.f1565a;
            n nVar = RecyclerView.this.p0;
            if (nVar != null) {
                b.h.k.a n = nVar.n();
                b.h.k.u.m0(view, n instanceof n.a ? ((n.a) n).n(view) : null);
            }
            if (z) {
                g(d0Var);
            }
            d0Var.r = null;
            i().i(d0Var);
        }

        public void c() {
            this.f1616a.clear();
            z();
        }

        /* access modifiers changed from: package-private */
        public void d() {
            int size = this.f1618c.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f1618c.get(i2).c();
            }
            int size2 = this.f1616a.size();
            for (int i3 = 0; i3 < size2; i3++) {
                this.f1616a.get(i3).c();
            }
            ArrayList<d0> arrayList = this.f1617b;
            if (arrayList != null) {
                int size3 = arrayList.size();
                for (int i4 = 0; i4 < size3; i4++) {
                    this.f1617b.get(i4).c();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void e() {
            this.f1616a.clear();
            ArrayList<d0> arrayList = this.f1617b;
            if (arrayList != null) {
                arrayList.clear();
            }
        }

        public int f(int i2) {
            if (i2 < 0 || i2 >= RecyclerView.this.i0.b()) {
                throw new IndexOutOfBoundsException("invalid position " + i2 + ". State item count is " + RecyclerView.this.i0.b() + RecyclerView.this.Q());
            } else if (!RecyclerView.this.i0.e()) {
                return i2;
            } else {
                return RecyclerView.this.f1537e.m(i2);
            }
        }

        /* access modifiers changed from: package-private */
        public void g(d0 d0Var) {
            w wVar = RecyclerView.this.o;
            if (wVar != null) {
                wVar.a(d0Var);
            }
            g gVar = RecyclerView.this.m;
            if (gVar != null) {
                gVar.t(d0Var);
            }
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.i0 != null) {
                recyclerView.f1539g.q(d0Var);
            }
        }

        /* access modifiers changed from: package-private */
        public d0 h(int i2) {
            int size;
            int m;
            ArrayList<d0> arrayList = this.f1617b;
            if (!(arrayList == null || (size = arrayList.size()) == 0)) {
                for (int i3 = 0; i3 < size; i3++) {
                    d0 d0Var = this.f1617b.get(i3);
                    if (!d0Var.L() && d0Var.m() == i2) {
                        d0Var.b(32);
                        return d0Var;
                    }
                }
                if (RecyclerView.this.m.g() && (m = RecyclerView.this.f1537e.m(i2)) > 0 && m < RecyclerView.this.m.c()) {
                    long d2 = RecyclerView.this.m.d(m);
                    for (int i4 = 0; i4 < size; i4++) {
                        d0 d0Var2 = this.f1617b.get(i4);
                        if (!d0Var2.L() && d0Var2.k() == d2) {
                            d0Var2.b(32);
                            return d0Var2;
                        }
                    }
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public u i() {
            if (this.f1622g == null) {
                this.f1622g = new u();
            }
            return this.f1622g;
        }

        /* access modifiers changed from: package-private */
        public int j() {
            return this.f1616a.size();
        }

        public List<d0> k() {
            return this.f1619d;
        }

        /* access modifiers changed from: package-private */
        public d0 l(long j2, int i2, boolean z) {
            for (int size = this.f1616a.size() - 1; size >= 0; size--) {
                d0 d0Var = this.f1616a.get(size);
                if (d0Var.k() == j2 && !d0Var.L()) {
                    if (i2 == d0Var.l()) {
                        d0Var.b(32);
                        if (d0Var.v() && !RecyclerView.this.i0.e()) {
                            d0Var.F(2, 14);
                        }
                        return d0Var;
                    } else if (!z) {
                        this.f1616a.remove(size);
                        RecyclerView.this.removeDetachedView(d0Var.f1565a, false);
                        y(d0Var.f1565a);
                    }
                }
            }
            int size2 = this.f1618c.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    return null;
                }
                d0 d0Var2 = this.f1618c.get(size2);
                if (d0Var2.k() == j2 && !d0Var2.r()) {
                    if (i2 == d0Var2.l()) {
                        if (!z) {
                            this.f1618c.remove(size2);
                        }
                        return d0Var2;
                    } else if (!z) {
                        A(size2);
                        return null;
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public d0 m(int i2, boolean z) {
            View e2;
            int size = this.f1616a.size();
            for (int i3 = 0; i3 < size; i3++) {
                d0 d0Var = this.f1616a.get(i3);
                if (!d0Var.L() && d0Var.m() == i2 && !d0Var.t() && (RecyclerView.this.i0.f1552h || !d0Var.v())) {
                    d0Var.b(32);
                    return d0Var;
                }
            }
            if (z || (e2 = RecyclerView.this.f1538f.e(i2)) == null) {
                int size2 = this.f1618c.size();
                for (int i4 = 0; i4 < size2; i4++) {
                    d0 d0Var2 = this.f1618c.get(i4);
                    if (!d0Var2.t() && d0Var2.m() == i2 && !d0Var2.r()) {
                        if (!z) {
                            this.f1618c.remove(i4);
                        }
                        return d0Var2;
                    }
                }
                return null;
            }
            d0 i0 = RecyclerView.i0(e2);
            RecyclerView.this.f1538f.s(e2);
            int m = RecyclerView.this.f1538f.m(e2);
            if (m != -1) {
                RecyclerView.this.f1538f.d(m);
                D(e2);
                i0.b(8224);
                return i0;
            }
            throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + i0 + RecyclerView.this.Q());
        }

        /* access modifiers changed from: package-private */
        public View n(int i2) {
            return this.f1616a.get(i2).f1565a;
        }

        public View o(int i2) {
            return p(i2, false);
        }

        /* access modifiers changed from: package-private */
        public View p(int i2, boolean z) {
            return I(i2, z, Long.MAX_VALUE).f1565a;
        }

        /* access modifiers changed from: package-private */
        public void s() {
            int size = this.f1618c.size();
            for (int i2 = 0; i2 < size; i2++) {
                p pVar = (p) this.f1618c.get(i2).f1565a.getLayoutParams();
                if (pVar != null) {
                    pVar.f1608c = true;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void t() {
            int size = this.f1618c.size();
            for (int i2 = 0; i2 < size; i2++) {
                d0 d0Var = this.f1618c.get(i2);
                if (d0Var != null) {
                    d0Var.b(6);
                    d0Var.a(null);
                }
            }
            g gVar = RecyclerView.this.m;
            if (gVar == null || !gVar.g()) {
                z();
            }
        }

        /* access modifiers changed from: package-private */
        public void u(int i2, int i3) {
            int size = this.f1618c.size();
            for (int i4 = 0; i4 < size; i4++) {
                d0 d0Var = this.f1618c.get(i4);
                if (d0Var != null && d0Var.f1567c >= i2) {
                    d0Var.A(i3, true);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void v(int i2, int i3) {
            int i4;
            int i5;
            int i6;
            int i7;
            if (i2 < i3) {
                i6 = -1;
                i5 = i2;
                i4 = i3;
            } else {
                i6 = 1;
                i4 = i2;
                i5 = i3;
            }
            int size = this.f1618c.size();
            for (int i8 = 0; i8 < size; i8++) {
                d0 d0Var = this.f1618c.get(i8);
                if (d0Var != null && (i7 = d0Var.f1567c) >= i5 && i7 <= i4) {
                    if (i7 == i2) {
                        d0Var.A(i3 - i2, false);
                    } else {
                        d0Var.A(i6, false);
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void w(int i2, int i3, boolean z) {
            int i4 = i2 + i3;
            for (int size = this.f1618c.size() - 1; size >= 0; size--) {
                d0 d0Var = this.f1618c.get(size);
                if (d0Var != null) {
                    int i5 = d0Var.f1567c;
                    if (i5 >= i4) {
                        d0Var.A(-i3, z);
                    } else if (i5 >= i2) {
                        d0Var.b(8);
                        A(size);
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void x(g gVar, g gVar2, boolean z) {
            c();
            i().h(gVar, gVar2, z);
        }

        /* access modifiers changed from: package-private */
        public void y(View view) {
            d0 i0 = RecyclerView.i0(view);
            i0.n = null;
            i0.o = false;
            i0.e();
            C(i0);
        }

        /* access modifiers changed from: package-private */
        public void z() {
            for (int size = this.f1618c.size() - 1; size >= 0; size--) {
                A(size);
            }
            this.f1618c.clear();
            if (RecyclerView.D0) {
                RecyclerView.this.h0.b();
            }
        }
    }

    public interface w {
        void a(d0 d0Var);
    }

    /* access modifiers changed from: private */
    public class x extends i {
        x() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void a() {
            RecyclerView.this.p(null);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.i0.f1551g = true;
            recyclerView.R0(true);
            if (!RecyclerView.this.f1537e.p()) {
                RecyclerView.this.requestLayout();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void c(int i2, int i3, Object obj) {
            RecyclerView.this.p(null);
            if (RecyclerView.this.f1537e.r(i2, i3, obj)) {
                f();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void d(int i2, int i3, int i4) {
            RecyclerView.this.p(null);
            if (RecyclerView.this.f1537e.s(i2, i3, i4)) {
                f();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void e(int i2, int i3) {
            RecyclerView.this.p(null);
            if (RecyclerView.this.f1537e.t(i2, i3)) {
                f();
            }
        }

        /* access modifiers changed from: package-private */
        public void f() {
            if (RecyclerView.C0) {
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.t && recyclerView.s) {
                    b.h.k.u.e0(recyclerView, recyclerView.f1541i);
                    return;
                }
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            recyclerView2.B = true;
            recyclerView2.requestLayout();
        }
    }

    public static abstract class z {

        /* renamed from: a  reason: collision with root package name */
        private int f1627a = -1;

        /* renamed from: b  reason: collision with root package name */
        private RecyclerView f1628b;

        /* renamed from: c  reason: collision with root package name */
        private o f1629c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f1630d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f1631e;

        /* renamed from: f  reason: collision with root package name */
        private View f1632f;

        /* renamed from: g  reason: collision with root package name */
        private final a f1633g = new a(0, 0);

        /* renamed from: h  reason: collision with root package name */
        private boolean f1634h;

        public static class a {

            /* renamed from: a  reason: collision with root package name */
            private int f1635a;

            /* renamed from: b  reason: collision with root package name */
            private int f1636b;

            /* renamed from: c  reason: collision with root package name */
            private int f1637c;

            /* renamed from: d  reason: collision with root package name */
            private int f1638d;

            /* renamed from: e  reason: collision with root package name */
            private Interpolator f1639e;

            /* renamed from: f  reason: collision with root package name */
            private boolean f1640f;

            /* renamed from: g  reason: collision with root package name */
            private int f1641g;

            public a(int i2, int i3) {
                this(i2, i3, Integer.MIN_VALUE, null);
            }

            private void e() {
                if (this.f1639e != null && this.f1637c < 1) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                } else if (this.f1637c < 1) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
            }

            /* access modifiers changed from: package-private */
            public boolean a() {
                return this.f1638d >= 0;
            }

            public void b(int i2) {
                this.f1638d = i2;
            }

            /* access modifiers changed from: package-private */
            public void c(RecyclerView recyclerView) {
                int i2 = this.f1638d;
                if (i2 >= 0) {
                    this.f1638d = -1;
                    recyclerView.y0(i2);
                    this.f1640f = false;
                } else if (this.f1640f) {
                    e();
                    recyclerView.f0.f(this.f1635a, this.f1636b, this.f1637c, this.f1639e);
                    int i3 = this.f1641g + 1;
                    this.f1641g = i3;
                    if (i3 > 10) {
                        Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                    }
                    this.f1640f = false;
                } else {
                    this.f1641g = 0;
                }
            }

            public void d(int i2, int i3, int i4, Interpolator interpolator) {
                this.f1635a = i2;
                this.f1636b = i3;
                this.f1637c = i4;
                this.f1639e = interpolator;
                this.f1640f = true;
            }

            public a(int i2, int i3, int i4, Interpolator interpolator) {
                this.f1638d = -1;
                this.f1640f = false;
                this.f1641g = 0;
                this.f1635a = i2;
                this.f1636b = i3;
                this.f1637c = i4;
                this.f1639e = interpolator;
            }
        }

        public interface b {
            PointF a(int i2);
        }

        public PointF a(int i2) {
            o e2 = e();
            if (e2 instanceof b) {
                return ((b) e2).a(i2);
            }
            Log.w("RecyclerView", "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + b.class.getCanonicalName());
            return null;
        }

        public View b(int i2) {
            return this.f1628b.n.D(i2);
        }

        public int c() {
            return this.f1628b.n.K();
        }

        public int d(View view) {
            return this.f1628b.g0(view);
        }

        public o e() {
            return this.f1629c;
        }

        public int f() {
            return this.f1627a;
        }

        public boolean g() {
            return this.f1630d;
        }

        public boolean h() {
            return this.f1631e;
        }

        /* access modifiers changed from: protected */
        public void i(PointF pointF) {
            float f2 = pointF.x;
            float f3 = pointF.y;
            float sqrt = (float) Math.sqrt((double) ((f2 * f2) + (f3 * f3)));
            pointF.x /= sqrt;
            pointF.y /= sqrt;
        }

        /* access modifiers changed from: package-private */
        public void j(int i2, int i3) {
            PointF a2;
            RecyclerView recyclerView = this.f1628b;
            if (this.f1627a == -1 || recyclerView == null) {
                r();
            }
            if (this.f1630d && this.f1632f == null && this.f1629c != null && (a2 = a(this.f1627a)) != null) {
                float f2 = a2.x;
                if (!(f2 == Utils.FLOAT_EPSILON && a2.y == Utils.FLOAT_EPSILON)) {
                    recyclerView.j1((int) Math.signum(f2), (int) Math.signum(a2.y), null);
                }
            }
            this.f1630d = false;
            View view = this.f1632f;
            if (view != null) {
                if (d(view) == this.f1627a) {
                    o(this.f1632f, recyclerView.i0, this.f1633g);
                    this.f1633g.c(recyclerView);
                    r();
                } else {
                    Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                    this.f1632f = null;
                }
            }
            if (this.f1631e) {
                l(i2, i3, recyclerView.i0, this.f1633g);
                boolean a3 = this.f1633g.a();
                this.f1633g.c(recyclerView);
                if (a3 && this.f1631e) {
                    this.f1630d = true;
                    recyclerView.f0.e();
                }
            }
        }

        /* access modifiers changed from: protected */
        public void k(View view) {
            if (d(view) == f()) {
                this.f1632f = view;
            }
        }

        /* access modifiers changed from: protected */
        public abstract void l(int i2, int i3, a0 a0Var, a aVar);

        /* access modifiers changed from: protected */
        public abstract void m();

        /* access modifiers changed from: protected */
        public abstract void n();

        /* access modifiers changed from: protected */
        public abstract void o(View view, a0 a0Var, a aVar);

        public void p(int i2) {
            this.f1627a = i2;
        }

        /* access modifiers changed from: package-private */
        public void q(RecyclerView recyclerView, o oVar) {
            recyclerView.f0.g();
            if (this.f1634h) {
                Log.w("RecyclerView", "An instance of " + getClass().getSimpleName() + " was started more than once. Each instance of" + getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.");
            }
            this.f1628b = recyclerView;
            this.f1629c = oVar;
            int i2 = this.f1627a;
            if (i2 != -1) {
                recyclerView.i0.f1545a = i2;
                this.f1631e = true;
                this.f1630d = true;
                this.f1632f = b(f());
                m();
                this.f1628b.f0.e();
                this.f1634h = true;
                return;
            }
            throw new IllegalArgumentException("Invalid target position");
        }

        /* access modifiers changed from: protected */
        public final void r() {
            if (this.f1631e) {
                this.f1631e = false;
                n();
                this.f1628b.i0.f1545a = -1;
                this.f1632f = null;
                this.f1627a = -1;
                this.f1630d = false;
                this.f1629c.g1(this);
                this.f1629c = null;
                this.f1628b = null;
            }
        }
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        A0 = i2 == 18 || i2 == 19 || i2 == 20;
        B0 = i2 >= 23;
        C0 = i2 >= 16;
        D0 = i2 >= 21;
        E0 = i2 <= 15;
        F0 = i2 <= 15;
        Class<?> cls = Integer.TYPE;
        G0 = new Class[]{Context.class, AttributeSet.class, cls, cls};
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.q.a.recyclerViewStyle);
    }

    private void B() {
        int i2 = this.A;
        this.A = 0;
        if (i2 != 0 && v0()) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain();
            obtain.setEventType(2048);
            b.h.k.d0.b.b(obtain, i2);
            sendAccessibilityEventUnchecked(obtain);
        }
    }

    private void D() {
        boolean z2 = true;
        this.i0.a(1);
        R(this.i0);
        this.i0.f1554j = false;
        t1();
        this.f1539g.f();
        I0();
        Q0();
        g1();
        a0 a0Var = this.i0;
        if (!a0Var.f1555k || !this.m0) {
            z2 = false;
        }
        a0Var.f1553i = z2;
        this.m0 = false;
        this.l0 = false;
        a0Var.f1552h = a0Var.l;
        a0Var.f1550f = this.m.c();
        W(this.r0);
        if (this.i0.f1555k) {
            int g2 = this.f1538f.g();
            for (int i2 = 0; i2 < g2; i2++) {
                d0 i02 = i0(this.f1538f.f(i2));
                if (!i02.J() && (!i02.t() || this.m.g())) {
                    this.f1539g.e(i02, this.N.u(this.i0, i02, l.e(i02), i02.o()));
                    if (this.i0.f1553i && i02.y() && !i02.v() && !i02.J() && !i02.t()) {
                        this.f1539g.c(e0(i02), i02);
                    }
                }
            }
        }
        if (this.i0.l) {
            h1();
            a0 a0Var2 = this.i0;
            boolean z3 = a0Var2.f1551g;
            a0Var2.f1551g = false;
            this.n.Y0(this.f1535c, a0Var2);
            this.i0.f1551g = z3;
            for (int i3 = 0; i3 < this.f1538f.g(); i3++) {
                d0 i03 = i0(this.f1538f.f(i3));
                if (!i03.J() && !this.f1539g.i(i03)) {
                    int e2 = l.e(i03);
                    boolean p2 = i03.p(8192);
                    if (!p2) {
                        e2 |= 4096;
                    }
                    l.c u2 = this.N.u(this.i0, i03, e2, i03.o());
                    if (p2) {
                        T0(i03, u2);
                    } else {
                        this.f1539g.a(i03, u2);
                    }
                }
            }
            t();
        } else {
            t();
        }
        J0();
        v1(false);
        this.i0.f1549e = 2;
    }

    private void E() {
        t1();
        I0();
        this.i0.a(6);
        this.f1537e.j();
        this.i0.f1550f = this.m.c();
        a0 a0Var = this.i0;
        a0Var.f1548d = 0;
        a0Var.f1552h = false;
        this.n.Y0(this.f1535c, a0Var);
        a0 a0Var2 = this.i0;
        a0Var2.f1551g = false;
        this.f1536d = null;
        a0Var2.f1555k = a0Var2.f1555k && this.N != null;
        a0Var2.f1549e = 4;
        J0();
        v1(false);
    }

    private void F() {
        this.i0.a(4);
        t1();
        I0();
        a0 a0Var = this.i0;
        a0Var.f1549e = 1;
        if (a0Var.f1555k) {
            for (int g2 = this.f1538f.g() - 1; g2 >= 0; g2--) {
                d0 i02 = i0(this.f1538f.f(g2));
                if (!i02.J()) {
                    long e02 = e0(i02);
                    l.c t2 = this.N.t(this.i0, i02);
                    d0 g3 = this.f1539g.g(e02);
                    if (g3 == null || g3.J()) {
                        this.f1539g.d(i02, t2);
                    } else {
                        boolean h2 = this.f1539g.h(g3);
                        boolean h3 = this.f1539g.h(i02);
                        if (!h2 || g3 != i02) {
                            l.c n2 = this.f1539g.n(g3);
                            this.f1539g.d(i02, t2);
                            l.c m2 = this.f1539g.m(i02);
                            if (n2 == null) {
                                n0(e02, i02, g3);
                            } else {
                                n(g3, i02, n2, m2, h2, h3);
                            }
                        } else {
                            this.f1539g.d(i02, t2);
                        }
                    }
                }
            }
            this.f1539g.o(this.y0);
        }
        this.n.m1(this.f1535c);
        a0 a0Var2 = this.i0;
        a0Var2.f1547c = a0Var2.f1550f;
        this.E = false;
        this.F = false;
        a0Var2.f1555k = false;
        a0Var2.l = false;
        this.n.f1596h = false;
        ArrayList<d0> arrayList = this.f1535c.f1617b;
        if (arrayList != null) {
            arrayList.clear();
        }
        o oVar = this.n;
        if (oVar.n) {
            oVar.m = 0;
            oVar.n = false;
            this.f1535c.K();
        }
        this.n.Z0(this.i0);
        J0();
        v1(false);
        this.f1539g.f();
        int[] iArr = this.r0;
        if (y(iArr[0], iArr[1])) {
            J(0, 0);
        }
        U0();
        e1();
    }

    private boolean L(MotionEvent motionEvent) {
        s sVar = this.r;
        if (sVar != null) {
            sVar.c(this, motionEvent);
            int action = motionEvent.getAction();
            if (action == 3 || action == 1) {
                this.r = null;
            }
            return true;
        } else if (motionEvent.getAction() == 0) {
            return false;
        } else {
            return V(motionEvent);
        }
    }

    private void L0(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.P) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.P = motionEvent.getPointerId(i2);
            int x2 = (int) (motionEvent.getX(i2) + 0.5f);
            this.T = x2;
            this.R = x2;
            int y2 = (int) (motionEvent.getY(i2) + 0.5f);
            this.U = y2;
            this.S = y2;
        }
    }

    private boolean P0() {
        return this.N != null && this.n.M1();
    }

    private void Q0() {
        boolean z2;
        if (this.E) {
            this.f1537e.x();
            if (this.F) {
                this.n.T0(this);
            }
        }
        if (P0()) {
            this.f1537e.v();
        } else {
            this.f1537e.j();
        }
        boolean z3 = false;
        boolean z4 = this.l0 || this.m0;
        this.i0.f1555k = this.v && this.N != null && ((z2 = this.E) || z4 || this.n.f1596h) && (!z2 || this.m.g());
        a0 a0Var = this.i0;
        if (a0Var.f1555k && z4 && !this.E && P0()) {
            z3 = true;
        }
        a0Var.l = z3;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0056  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void S0(float r7, float r8, float r9, float r10) {
        /*
        // Method dump skipped, instructions count: 128
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.S0(float, float, float, float):void");
    }

    private void U0() {
        View findViewById;
        if (this.e0 && this.m != null && hasFocus() && getDescendantFocusability() != 393216) {
            if (getDescendantFocusability() != 131072 || !isFocused()) {
                if (!isFocused()) {
                    View focusedChild = getFocusedChild();
                    if (!F0 || (focusedChild.getParent() != null && focusedChild.hasFocus())) {
                        if (!this.f1538f.n(focusedChild)) {
                            return;
                        }
                    } else if (this.f1538f.g() == 0) {
                        requestFocus();
                        return;
                    }
                }
                View view = null;
                d0 a02 = (this.i0.n == -1 || !this.m.g()) ? null : a0(this.i0.n);
                if (a02 != null && !this.f1538f.n(a02.f1565a) && a02.f1565a.hasFocusable()) {
                    view = a02.f1565a;
                } else if (this.f1538f.g() > 0) {
                    view = Y();
                }
                if (view != null) {
                    int i2 = this.i0.o;
                    if (!(((long) i2) == -1 || (findViewById = view.findViewById(i2)) == null || !findViewById.isFocusable())) {
                        view = findViewById;
                    }
                    view.requestFocus();
                }
            }
        }
    }

    private boolean V(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int size = this.q.size();
        for (int i2 = 0; i2 < size; i2++) {
            s sVar = this.q.get(i2);
            if (sVar.a(this, motionEvent) && action != 3) {
                this.r = sVar;
                return true;
            }
        }
        return false;
    }

    private void V0() {
        boolean z2;
        EdgeEffect edgeEffect = this.J;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            z2 = this.J.isFinished();
        } else {
            z2 = false;
        }
        EdgeEffect edgeEffect2 = this.K;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            z2 |= this.K.isFinished();
        }
        EdgeEffect edgeEffect3 = this.L;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            z2 |= this.L.isFinished();
        }
        EdgeEffect edgeEffect4 = this.M;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            z2 |= this.M.isFinished();
        }
        if (z2) {
            b.h.k.u.d0(this);
        }
    }

    private void W(int[] iArr) {
        int g2 = this.f1538f.g();
        if (g2 == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i2 = Integer.MAX_VALUE;
        int i3 = Integer.MIN_VALUE;
        for (int i4 = 0; i4 < g2; i4++) {
            d0 i02 = i0(this.f1538f.f(i4));
            if (!i02.J()) {
                int m2 = i02.m();
                if (m2 < i2) {
                    i2 = m2;
                }
                if (m2 > i3) {
                    i3 = m2;
                }
            }
        }
        iArr[0] = i2;
        iArr[1] = i3;
    }

    static RecyclerView X(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            RecyclerView X = X(viewGroup.getChildAt(i2));
            if (X != null) {
                return X;
            }
        }
        return null;
    }

    private View Y() {
        d0 Z;
        a0 a0Var = this.i0;
        int i2 = a0Var.m;
        if (i2 == -1) {
            i2 = 0;
        }
        int b2 = a0Var.b();
        for (int i3 = i2; i3 < b2; i3++) {
            d0 Z2 = Z(i3);
            if (Z2 == null) {
                break;
            } else if (Z2.f1565a.hasFocusable()) {
                return Z2.f1565a;
            }
        }
        int min = Math.min(b2, i2);
        while (true) {
            min--;
            if (min < 0 || (Z = Z(min)) == null) {
                return null;
            }
            if (Z.f1565a.hasFocusable()) {
                return Z.f1565a;
            }
        }
    }

    private void d1(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.f1542j.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof p) {
            p pVar = (p) layoutParams;
            if (!pVar.f1608c) {
                Rect rect = pVar.f1607b;
                Rect rect2 = this.f1542j;
                rect2.left -= rect.left;
                rect2.right += rect.right;
                rect2.top -= rect.top;
                rect2.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.f1542j);
            offsetRectIntoDescendantCoords(view, this.f1542j);
        }
        this.n.t1(this, view, this.f1542j, !this.v, view2 == null);
    }

    private void e1() {
        a0 a0Var = this.i0;
        a0Var.n = -1;
        a0Var.m = -1;
        a0Var.o = -1;
    }

    private void f1() {
        VelocityTracker velocityTracker = this.Q;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        w1(0);
        V0();
    }

    private void g(d0 d0Var) {
        View view = d0Var.f1565a;
        boolean z2 = view.getParent() == this;
        this.f1535c.J(h0(view));
        if (d0Var.x()) {
            this.f1538f.c(view, -1, view.getLayoutParams(), true);
        } else if (!z2) {
            this.f1538f.b(view, true);
        } else {
            this.f1538f.k(view);
        }
    }

    private void g1() {
        int i2;
        d0 d0Var = null;
        View focusedChild = (!this.e0 || !hasFocus() || this.m == null) ? null : getFocusedChild();
        if (focusedChild != null) {
            d0Var = U(focusedChild);
        }
        if (d0Var == null) {
            e1();
            return;
        }
        this.i0.n = this.m.g() ? d0Var.k() : -1;
        a0 a0Var = this.i0;
        if (this.E) {
            i2 = -1;
        } else if (d0Var.v()) {
            i2 = d0Var.f1568d;
        } else {
            i2 = d0Var.j();
        }
        a0Var.m = i2;
        this.i0.o = k0(d0Var.f1565a);
    }

    private b.h.k.l getScrollingChildHelper() {
        if (this.s0 == null) {
            this.s0 = new b.h.k.l(this);
        }
        return this.s0;
    }

    static d0 i0(View view) {
        if (view == null) {
            return null;
        }
        return ((p) view.getLayoutParams()).f1606a;
    }

    static void j0(View view, Rect rect) {
        p pVar = (p) view.getLayoutParams();
        Rect rect2 = pVar.f1607b;
        rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) pVar).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) pVar).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) pVar).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin);
    }

    private int k0(View view) {
        int id = view.getId();
        while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
            view = ((ViewGroup) view).getFocusedChild();
            if (view.getId() != -1) {
                id = view.getId();
            }
        }
        return id;
    }

    private String l0(Context context, String str) {
        if (str.charAt(0) == '.') {
            return context.getPackageName() + str;
        } else if (str.contains(".")) {
            return str;
        } else {
            return RecyclerView.class.getPackage().getName() + '.' + str;
        }
    }

    private void l1(g gVar, boolean z2, boolean z3) {
        g gVar2 = this.m;
        if (gVar2 != null) {
            gVar2.w(this.f1534b);
            this.m.p(this);
        }
        if (!z2 || z3) {
            W0();
        }
        this.f1537e.x();
        g gVar3 = this.m;
        this.m = gVar;
        if (gVar != null) {
            gVar.u(this.f1534b);
            gVar.l(this);
        }
        o oVar = this.n;
        if (oVar != null) {
            oVar.F0(gVar3, this.m);
        }
        this.f1535c.x(gVar3, this.m, z2);
        this.i0.f1551g = true;
    }

    private void n(d0 d0Var, d0 d0Var2, l.c cVar, l.c cVar2, boolean z2, boolean z3) {
        d0Var.G(false);
        if (z2) {
            g(d0Var);
        }
        if (d0Var != d0Var2) {
            if (z3) {
                g(d0Var2);
            }
            d0Var.f1572h = d0Var2;
            g(d0Var);
            this.f1535c.J(d0Var);
            d0Var2.G(false);
            d0Var2.f1573i = d0Var;
        }
        if (this.N.b(d0Var, d0Var2, cVar, cVar2)) {
            O0();
        }
    }

    private void n0(long j2, d0 d0Var, d0 d0Var2) {
        int g2 = this.f1538f.g();
        for (int i2 = 0; i2 < g2; i2++) {
            d0 i02 = i0(this.f1538f.f(i2));
            if (i02 != d0Var && e0(i02) == j2) {
                g gVar = this.m;
                if (gVar == null || !gVar.g()) {
                    throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + i02 + " \n View Holder 2:" + d0Var + Q());
                }
                throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + i02 + " \n View Holder 2:" + d0Var + Q());
            }
        }
        Log.e("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + d0Var2 + " cannot be found but it is necessary for " + d0Var + Q());
    }

    private boolean p0() {
        int g2 = this.f1538f.g();
        for (int i2 = 0; i2 < g2; i2++) {
            d0 i02 = i0(this.f1538f.f(i2));
            if (!(i02 == null || i02.J() || !i02.y())) {
                return true;
            }
        }
        return false;
    }

    private void r() {
        f1();
        setScrollState(0);
    }

    @SuppressLint({"InlinedApi"})
    private void r0() {
        if (b.h.k.u.A(this) == 0) {
            b.h.k.u.y0(this, 8);
        }
    }

    static void s(d0 d0Var) {
        WeakReference<RecyclerView> weakReference = d0Var.f1566b;
        if (weakReference != null) {
            RecyclerView recyclerView = weakReference.get();
            while (recyclerView != null) {
                if (recyclerView != d0Var.f1565a) {
                    ViewParent parent = recyclerView.getParent();
                    recyclerView = parent instanceof View ? (View) parent : null;
                } else {
                    return;
                }
            }
            d0Var.f1566b = null;
        }
    }

    private void s0() {
        this.f1538f = new b(new e());
    }

    private void w(Context context, String str, AttributeSet attributeSet, int i2, int i3) {
        ClassLoader classLoader;
        Constructor<? extends U> constructor;
        if (str != null) {
            String trim = str.trim();
            if (!trim.isEmpty()) {
                String l02 = l0(context, trim);
                try {
                    if (isInEditMode()) {
                        classLoader = getClass().getClassLoader();
                    } else {
                        classLoader = context.getClassLoader();
                    }
                    Class<? extends U> asSubclass = Class.forName(l02, false, classLoader).asSubclass(o.class);
                    Object[] objArr = null;
                    try {
                        constructor = asSubclass.getConstructor(G0);
                        objArr = new Object[]{context, attributeSet, Integer.valueOf(i2), Integer.valueOf(i3)};
                    } catch (NoSuchMethodException e2) {
                        try {
                            constructor = asSubclass.getConstructor(new Class[0]);
                        } catch (NoSuchMethodException e3) {
                            e3.initCause(e2);
                            throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + l02, e3);
                        }
                    }
                    constructor.setAccessible(true);
                    setLayoutManager((o) constructor.newInstance(objArr));
                } catch (ClassNotFoundException e4) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + l02, e4);
                } catch (InvocationTargetException e5) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + l02, e5);
                } catch (InstantiationException e6) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + l02, e6);
                } catch (IllegalAccessException e7) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + l02, e7);
                } catch (ClassCastException e8) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + l02, e8);
                }
            }
        }
    }

    private boolean x0(View view, View view2, int i2) {
        int i3;
        if (view2 == null || view2 == this || T(view2) == null) {
            return false;
        }
        if (view == null || T(view) == null) {
            return true;
        }
        this.f1542j.set(0, 0, view.getWidth(), view.getHeight());
        this.f1543k.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.f1542j);
        offsetDescendantRectToMyCoords(view2, this.f1543k);
        char c2 = 65535;
        int i4 = this.n.a0() == 1 ? -1 : 1;
        Rect rect = this.f1542j;
        int i5 = rect.left;
        Rect rect2 = this.f1543k;
        int i6 = rect2.left;
        if ((i5 < i6 || rect.right <= i6) && rect.right < rect2.right) {
            i3 = 1;
        } else {
            int i7 = rect.right;
            int i8 = rect2.right;
            i3 = ((i7 > i8 || i5 >= i8) && i5 > i6) ? -1 : 0;
        }
        int i9 = rect.top;
        int i10 = rect2.top;
        if ((i9 < i10 || rect.bottom <= i10) && rect.bottom < rect2.bottom) {
            c2 = 1;
        } else {
            int i11 = rect.bottom;
            int i12 = rect2.bottom;
            if ((i11 <= i12 && i9 < i12) || i9 <= i10) {
                c2 = 0;
            }
        }
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 17) {
                    if (i2 != 33) {
                        if (i2 != 66) {
                            if (i2 != 130) {
                                throw new IllegalArgumentException("Invalid direction: " + i2 + Q());
                            } else if (c2 > 0) {
                                return true;
                            } else {
                                return false;
                            }
                        } else if (i3 > 0) {
                            return true;
                        } else {
                            return false;
                        }
                    } else if (c2 < 0) {
                        return true;
                    } else {
                        return false;
                    }
                } else if (i3 < 0) {
                    return true;
                } else {
                    return false;
                }
            } else if (c2 > 0 || (c2 == 0 && i3 * i4 >= 0)) {
                return true;
            } else {
                return false;
            }
        } else if (c2 < 0 || (c2 == 0 && i3 * i4 <= 0)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean y(int i2, int i3) {
        W(this.r0);
        int[] iArr = this.r0;
        return (iArr[0] == i2 && iArr[1] == i3) ? false : true;
    }

    private void y1() {
        this.f0.g();
        o oVar = this.n;
        if (oVar != null) {
            oVar.L1();
        }
    }

    /* access modifiers changed from: package-private */
    public void A(View view) {
        d0 i02 = i0(view);
        H0(view);
        g gVar = this.m;
        if (!(gVar == null || i02 == null)) {
            gVar.s(i02);
        }
        List<q> list = this.D;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.D.get(size).d(view);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void A0() {
        int j2 = this.f1538f.j();
        for (int i2 = 0; i2 < j2; i2++) {
            d0 i02 = i0(this.f1538f.i(i2));
            if (i02 != null && !i02.J()) {
                i02.b(6);
            }
        }
        z0();
        this.f1535c.t();
    }

    public void B0(int i2) {
        int g2 = this.f1538f.g();
        for (int i3 = 0; i3 < g2; i3++) {
            this.f1538f.f(i3).offsetLeftAndRight(i2);
        }
    }

    /* access modifiers changed from: package-private */
    public void C() {
        if (this.m == null) {
            Log.e("RecyclerView", "No adapter attached; skipping layout");
        } else if (this.n == null) {
            Log.e("RecyclerView", "No layout manager attached; skipping layout");
        } else {
            a0 a0Var = this.i0;
            a0Var.f1554j = false;
            if (a0Var.f1549e == 1) {
                D();
                this.n.A1(this);
                E();
            } else if (!this.f1537e.q() && this.n.p0() == getWidth() && this.n.X() == getHeight()) {
                this.n.A1(this);
            } else {
                this.n.A1(this);
                E();
            }
            F();
        }
    }

    public void C0(int i2) {
        int g2 = this.f1538f.g();
        for (int i3 = 0; i3 < g2; i3++) {
            this.f1538f.f(i3).offsetTopAndBottom(i2);
        }
    }

    /* access modifiers changed from: package-private */
    public void D0(int i2, int i3) {
        int j2 = this.f1538f.j();
        for (int i4 = 0; i4 < j2; i4++) {
            d0 i02 = i0(this.f1538f.i(i4));
            if (i02 != null && !i02.J() && i02.f1567c >= i2) {
                i02.A(i3, false);
                this.i0.f1551g = true;
            }
        }
        this.f1535c.u(i2, i3);
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    public void E0(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int j2 = this.f1538f.j();
        if (i2 < i3) {
            i6 = -1;
            i5 = i2;
            i4 = i3;
        } else {
            i4 = i2;
            i5 = i3;
            i6 = 1;
        }
        for (int i8 = 0; i8 < j2; i8++) {
            d0 i02 = i0(this.f1538f.i(i8));
            if (i02 != null && (i7 = i02.f1567c) >= i5 && i7 <= i4) {
                if (i7 == i2) {
                    i02.A(i3 - i2, false);
                } else {
                    i02.A(i6, false);
                }
                this.i0.f1551g = true;
            }
        }
        this.f1535c.v(i2, i3);
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    public void F0(int i2, int i3, boolean z2) {
        int i4 = i2 + i3;
        int j2 = this.f1538f.j();
        for (int i5 = 0; i5 < j2; i5++) {
            d0 i02 = i0(this.f1538f.i(i5));
            if (i02 != null && !i02.J()) {
                int i6 = i02.f1567c;
                if (i6 >= i4) {
                    i02.A(-i3, z2);
                    this.i0.f1551g = true;
                } else if (i6 >= i2) {
                    i02.i(i2 - 1, -i3, z2);
                    this.i0.f1551g = true;
                }
            }
        }
        this.f1535c.w(i2, i3, z2);
        requestLayout();
    }

    public boolean G(int i2, int i3, int[] iArr, int[] iArr2, int i4) {
        return getScrollingChildHelper().d(i2, i3, iArr, iArr2, i4);
    }

    public void G0(View view) {
    }

    public final void H(int i2, int i3, int i4, int i5, int[] iArr, int i6, int[] iArr2) {
        getScrollingChildHelper().e(i2, i3, i4, i5, iArr, i6, iArr2);
    }

    public void H0(View view) {
    }

    /* access modifiers changed from: package-private */
    public void I(int i2) {
        o oVar = this.n;
        if (oVar != null) {
            oVar.f1(i2);
        }
        M0(i2);
        t tVar = this.j0;
        if (tVar != null) {
            tVar.a(this, i2);
        }
        List<t> list = this.k0;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.k0.get(size).a(this, i2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void I0() {
        this.G++;
    }

    /* access modifiers changed from: package-private */
    public void J(int i2, int i3) {
        this.H++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i2, scrollY - i3);
        N0(i2, i3);
        t tVar = this.j0;
        if (tVar != null) {
            tVar.b(this, i2, i3);
        }
        List<t> list = this.k0;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.k0.get(size).b(this, i2, i3);
            }
        }
        this.H--;
    }

    /* access modifiers changed from: package-private */
    public void J0() {
        K0(true);
    }

    /* access modifiers changed from: package-private */
    public void K() {
        int i2;
        for (int size = this.w0.size() - 1; size >= 0; size--) {
            d0 d0Var = this.w0.get(size);
            if (d0Var.f1565a.getParent() == this && !d0Var.J() && (i2 = d0Var.q) != -1) {
                b.h.k.u.x0(d0Var.f1565a, i2);
                d0Var.q = -1;
            }
        }
        this.w0.clear();
    }

    /* access modifiers changed from: package-private */
    public void K0(boolean z2) {
        int i2 = this.G - 1;
        this.G = i2;
        if (i2 < 1) {
            this.G = 0;
            if (z2) {
                B();
                K();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void M() {
        if (this.M == null) {
            EdgeEffect a2 = this.I.a(this, 3);
            this.M = a2;
            if (this.f1540h) {
                a2.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                a2.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    public void M0(int i2) {
    }

    /* access modifiers changed from: package-private */
    public void N() {
        if (this.J == null) {
            EdgeEffect a2 = this.I.a(this, 0);
            this.J = a2;
            if (this.f1540h) {
                a2.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                a2.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    public void N0(int i2, int i3) {
    }

    /* access modifiers changed from: package-private */
    public void O() {
        if (this.L == null) {
            EdgeEffect a2 = this.I.a(this, 2);
            this.L = a2;
            if (this.f1540h) {
                a2.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                a2.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void O0() {
        if (!this.o0 && this.s) {
            b.h.k.u.e0(this, this.x0);
            this.o0 = true;
        }
    }

    /* access modifiers changed from: package-private */
    public void P() {
        if (this.K == null) {
            EdgeEffect a2 = this.I.a(this, 1);
            this.K = a2;
            if (this.f1540h) {
                a2.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                a2.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public String Q() {
        return " " + super.toString() + ", adapter:" + this.m + ", layout:" + this.n + ", context:" + getContext();
    }

    /* access modifiers changed from: package-private */
    public final void R(a0 a0Var) {
        if (getScrollState() == 2) {
            OverScroller overScroller = this.f0.f1559d;
            a0Var.p = overScroller.getFinalX() - overScroller.getCurrX();
            a0Var.q = overScroller.getFinalY() - overScroller.getCurrY();
            return;
        }
        a0Var.p = 0;
        a0Var.q = 0;
    }

    /* access modifiers changed from: package-private */
    public void R0(boolean z2) {
        this.F = z2 | this.F;
        this.E = true;
        A0();
    }

    public View S(float f2, float f3) {
        for (int g2 = this.f1538f.g() - 1; g2 >= 0; g2--) {
            View f4 = this.f1538f.f(g2);
            float translationX = f4.getTranslationX();
            float translationY = f4.getTranslationY();
            if (f2 >= ((float) f4.getLeft()) + translationX && f2 <= ((float) f4.getRight()) + translationX && f3 >= ((float) f4.getTop()) + translationY && f3 <= ((float) f4.getBottom()) + translationY) {
                return f4;
            }
        }
        return null;
    }

    public View T(View view) {
        ViewParent parent = view.getParent();
        while (parent != null && parent != this && (parent instanceof View)) {
            view = (View) parent;
            parent = view.getParent();
        }
        if (parent == this) {
            return view;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void T0(d0 d0Var, l.c cVar) {
        d0Var.F(0, 8192);
        if (this.i0.f1553i && d0Var.y() && !d0Var.v() && !d0Var.J()) {
            this.f1539g.c(e0(d0Var), d0Var);
        }
        this.f1539g.e(d0Var, cVar);
    }

    public d0 U(View view) {
        View T2 = T(view);
        if (T2 == null) {
            return null;
        }
        return h0(T2);
    }

    /* access modifiers changed from: package-private */
    public void W0() {
        l lVar = this.N;
        if (lVar != null) {
            lVar.k();
        }
        o oVar = this.n;
        if (oVar != null) {
            oVar.l1(this.f1535c);
            this.n.m1(this.f1535c);
        }
        this.f1535c.c();
    }

    /* access modifiers changed from: package-private */
    public boolean X0(View view) {
        t1();
        boolean r2 = this.f1538f.r(view);
        if (r2) {
            d0 i02 = i0(view);
            this.f1535c.J(i02);
            this.f1535c.C(i02);
        }
        v1(!r2);
        return r2;
    }

    public void Y0(n nVar) {
        o oVar = this.n;
        if (oVar != null) {
            oVar.h("Cannot remove item decoration during a scroll  or layout");
        }
        this.p.remove(nVar);
        if (this.p.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        z0();
        requestLayout();
    }

    public d0 Z(int i2) {
        d0 d0Var = null;
        if (this.E) {
            return null;
        }
        int j2 = this.f1538f.j();
        for (int i3 = 0; i3 < j2; i3++) {
            d0 i02 = i0(this.f1538f.i(i3));
            if (i02 != null && !i02.v() && d0(i02) == i2) {
                if (!this.f1538f.n(i02.f1565a)) {
                    return i02;
                }
                d0Var = i02;
            }
        }
        return d0Var;
    }

    public void Z0(q qVar) {
        List<q> list = this.D;
        if (list != null) {
            list.remove(qVar);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, int i3) {
        if (i2 < 0) {
            N();
            if (this.J.isFinished()) {
                this.J.onAbsorb(-i2);
            }
        } else if (i2 > 0) {
            O();
            if (this.L.isFinished()) {
                this.L.onAbsorb(i2);
            }
        }
        if (i3 < 0) {
            P();
            if (this.K.isFinished()) {
                this.K.onAbsorb(-i3);
            }
        } else if (i3 > 0) {
            M();
            if (this.M.isFinished()) {
                this.M.onAbsorb(i3);
            }
        }
        if (i2 != 0 || i3 != 0) {
            b.h.k.u.d0(this);
        }
    }

    public d0 a0(long j2) {
        g gVar = this.m;
        d0 d0Var = null;
        if (gVar != null && gVar.g()) {
            int j3 = this.f1538f.j();
            for (int i2 = 0; i2 < j3; i2++) {
                d0 i02 = i0(this.f1538f.i(i2));
                if (i02 != null && !i02.v() && i02.k() == j2) {
                    if (!this.f1538f.n(i02.f1565a)) {
                        return i02;
                    }
                    d0Var = i02;
                }
            }
        }
        return d0Var;
    }

    public void a1(s sVar) {
        this.q.remove(sVar);
        if (this.r == sVar) {
            this.r = null;
        }
    }

    @Override // android.view.View, android.view.ViewGroup
    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        o oVar = this.n;
        if (oVar == null || !oVar.G0(this, arrayList, i2, i3)) {
            super.addFocusables(arrayList, i2, i3);
        }
    }

    /* access modifiers changed from: package-private */
    public d0 b0(int i2, boolean z2) {
        int j2 = this.f1538f.j();
        d0 d0Var = null;
        for (int i3 = 0; i3 < j2; i3++) {
            d0 i02 = i0(this.f1538f.i(i3));
            if (i02 != null && !i02.v()) {
                if (z2) {
                    if (i02.f1567c != i2) {
                        continue;
                    }
                } else if (i02.m() != i2) {
                    continue;
                }
                if (!this.f1538f.n(i02.f1565a)) {
                    return i02;
                }
                d0Var = i02;
            }
        }
        return d0Var;
    }

    public void b1(t tVar) {
        List<t> list = this.k0;
        if (list != null) {
            list.remove(tVar);
        }
    }

    public boolean c0(int i2, int i3) {
        o oVar = this.n;
        int i4 = 0;
        if (oVar == null) {
            Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        } else if (this.y) {
            return false;
        } else {
            boolean l2 = oVar.l();
            boolean m2 = this.n.m();
            if (!l2 || Math.abs(i2) < this.a0) {
                i2 = 0;
            }
            if (!m2 || Math.abs(i3) < this.a0) {
                i3 = 0;
            }
            if (i2 == 0 && i3 == 0) {
                return false;
            }
            float f2 = (float) i2;
            float f3 = (float) i3;
            if (!dispatchNestedPreFling(f2, f3)) {
                boolean z2 = l2 || m2;
                dispatchNestedFling(f2, f3, z2);
                r rVar = this.W;
                if (rVar != null && rVar.a(i2, i3)) {
                    return true;
                }
                if (z2) {
                    if (l2) {
                        i4 = 1;
                    }
                    if (m2) {
                        i4 |= 2;
                    }
                    u1(i4, 1);
                    int i5 = this.b0;
                    int max = Math.max(-i5, Math.min(i2, i5));
                    int i6 = this.b0;
                    this.f0.c(max, Math.max(-i6, Math.min(i3, i6)));
                    return true;
                }
            }
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public void c1() {
        d0 d0Var;
        int g2 = this.f1538f.g();
        for (int i2 = 0; i2 < g2; i2++) {
            View f2 = this.f1538f.f(i2);
            d0 h02 = h0(f2);
            if (!(h02 == null || (d0Var = h02.f1573i) == null)) {
                View view = d0Var.f1565a;
                int left = f2.getLeft();
                int top = f2.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof p) && this.n.n((p) layoutParams);
    }

    public int computeHorizontalScrollExtent() {
        o oVar = this.n;
        if (oVar != null && oVar.l()) {
            return this.n.r(this.i0);
        }
        return 0;
    }

    public int computeHorizontalScrollOffset() {
        o oVar = this.n;
        if (oVar != null && oVar.l()) {
            return this.n.s(this.i0);
        }
        return 0;
    }

    public int computeHorizontalScrollRange() {
        o oVar = this.n;
        if (oVar != null && oVar.l()) {
            return this.n.t(this.i0);
        }
        return 0;
    }

    public int computeVerticalScrollExtent() {
        o oVar = this.n;
        if (oVar != null && oVar.m()) {
            return this.n.u(this.i0);
        }
        return 0;
    }

    public int computeVerticalScrollOffset() {
        o oVar = this.n;
        if (oVar != null && oVar.m()) {
            return this.n.v(this.i0);
        }
        return 0;
    }

    public int computeVerticalScrollRange() {
        o oVar = this.n;
        if (oVar != null && oVar.m()) {
            return this.n.w(this.i0);
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int d0(d0 d0Var) {
        if (d0Var.p(524) || !d0Var.s()) {
            return -1;
        }
        return this.f1537e.e(d0Var.f1567c);
    }

    public boolean dispatchNestedFling(float f2, float f3, boolean z2) {
        return getScrollingChildHelper().a(f2, f3, z2);
    }

    public boolean dispatchNestedPreFling(float f2, float f3) {
        return getScrollingChildHelper().b(f2, f3);
    }

    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().c(i2, i3, iArr, iArr2);
    }

    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return getScrollingChildHelper().f(i2, i3, i4, i5, iArr);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // android.view.View, android.view.ViewGroup
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    /* access modifiers changed from: protected */
    @Override // android.view.View, android.view.ViewGroup
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    public void draw(Canvas canvas) {
        boolean z2;
        super.draw(canvas);
        int size = this.p.size();
        boolean z3 = false;
        for (int i2 = 0; i2 < size; i2++) {
            this.p.get(i2).k(canvas, this, this.i0);
        }
        EdgeEffect edgeEffect = this.J;
        boolean z4 = true;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z2 = false;
        } else {
            int save = canvas.save();
            int paddingBottom = this.f1540h ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((float) ((-getHeight()) + paddingBottom), Utils.FLOAT_EPSILON);
            EdgeEffect edgeEffect2 = this.J;
            z2 = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(save);
        }
        EdgeEffect edgeEffect3 = this.K;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int save2 = canvas.save();
            if (this.f1540h) {
                canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.K;
            z2 |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(save2);
        }
        EdgeEffect edgeEffect5 = this.L;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int save3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.f1540h ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate((float) (-paddingTop), (float) (-width));
            EdgeEffect edgeEffect6 = this.L;
            z2 |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(save3);
        }
        EdgeEffect edgeEffect7 = this.M;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int save4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.f1540h) {
                canvas.translate((float) ((-getWidth()) + getPaddingRight()), (float) ((-getHeight()) + getPaddingBottom()));
            } else {
                canvas.translate((float) (-getWidth()), (float) (-getHeight()));
            }
            EdgeEffect edgeEffect8 = this.M;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z3 = true;
            }
            z2 |= z3;
            canvas.restoreToCount(save4);
        }
        if (z2 || this.N == null || this.p.size() <= 0 || !this.N.p()) {
            z4 = z2;
        }
        if (z4) {
            b.h.k.u.d0(this);
        }
    }

    public boolean drawChild(Canvas canvas, View view, long j2) {
        return super.drawChild(canvas, view, j2);
    }

    /* access modifiers changed from: package-private */
    public long e0(d0 d0Var) {
        return this.m.g() ? d0Var.k() : (long) d0Var.f1567c;
    }

    public int f0(View view) {
        d0 i02 = i0(view);
        if (i02 != null) {
            return i02.j();
        }
        return -1;
    }

    public View focusSearch(View view, int i2) {
        View view2;
        boolean z2;
        View R0 = this.n.R0(view, i2);
        if (R0 != null) {
            return R0;
        }
        boolean z3 = true;
        boolean z4 = this.m != null && this.n != null && !w0() && !this.y;
        FocusFinder instance = FocusFinder.getInstance();
        if (!z4 || !(i2 == 2 || i2 == 1)) {
            View findNextFocus = instance.findNextFocus(this, view, i2);
            if (findNextFocus != null || !z4) {
                view2 = findNextFocus;
            } else {
                v();
                if (T(view) == null) {
                    return null;
                }
                t1();
                view2 = this.n.K0(view, i2, this.f1535c, this.i0);
                v1(false);
            }
        } else {
            if (this.n.m()) {
                int i3 = i2 == 2 ? 130 : 33;
                z2 = instance.findNextFocus(this, view, i3) == null;
                if (E0) {
                    i2 = i3;
                }
            } else {
                z2 = false;
            }
            if (!z2 && this.n.l()) {
                int i4 = (this.n.a0() == 1) ^ (i2 == 2) ? 66 : 17;
                if (instance.findNextFocus(this, view, i4) != null) {
                    z3 = false;
                }
                if (E0) {
                    i2 = i4;
                }
                z2 = z3;
            }
            if (z2) {
                v();
                if (T(view) == null) {
                    return null;
                }
                t1();
                this.n.K0(view, i2, this.f1535c, this.i0);
                v1(false);
            }
            view2 = instance.findNextFocus(this, view, i2);
        }
        if (view2 == null || view2.hasFocusable()) {
            return x0(view, view2, i2) ? view2 : super.focusSearch(view, i2);
        }
        if (getFocusedChild() == null) {
            return super.focusSearch(view, i2);
        }
        d1(view2, null);
        return view;
    }

    public int g0(View view) {
        d0 i02 = i0(view);
        if (i02 != null) {
            return i02.m();
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        o oVar = this.n;
        if (oVar != null) {
            return oVar.E();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + Q());
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        o oVar = this.n;
        if (oVar != null) {
            return oVar.F(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + Q());
    }

    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    public g getAdapter() {
        return this.m;
    }

    public int getBaseline() {
        o oVar = this.n;
        if (oVar != null) {
            return oVar.H();
        }
        return super.getBaseline();
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i2, int i3) {
        j jVar = this.q0;
        if (jVar == null) {
            return super.getChildDrawingOrder(i2, i3);
        }
        return jVar.a(i2, i3);
    }

    public boolean getClipToPadding() {
        return this.f1540h;
    }

    public n getCompatAccessibilityDelegate() {
        return this.p0;
    }

    public k getEdgeEffectFactory() {
        return this.I;
    }

    public l getItemAnimator() {
        return this.N;
    }

    public int getItemDecorationCount() {
        return this.p.size();
    }

    public o getLayoutManager() {
        return this.n;
    }

    public int getMaxFlingVelocity() {
        return this.b0;
    }

    public int getMinFlingVelocity() {
        return this.a0;
    }

    /* access modifiers changed from: package-private */
    public long getNanoTime() {
        if (D0) {
            return System.nanoTime();
        }
        return 0;
    }

    public r getOnFlingListener() {
        return this.W;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.e0;
    }

    public u getRecycledViewPool() {
        return this.f1535c.i();
    }

    public int getScrollState() {
        return this.O;
    }

    public void h(n nVar) {
        i(nVar, -1);
    }

    public d0 h0(View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return i0(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    /* access modifiers changed from: package-private */
    public void h1() {
        int j2 = this.f1538f.j();
        for (int i2 = 0; i2 < j2; i2++) {
            d0 i02 = i0(this.f1538f.i(i2));
            if (!i02.J()) {
                i02.E();
            }
        }
    }

    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().j();
    }

    public void i(n nVar, int i2) {
        o oVar = this.n;
        if (oVar != null) {
            oVar.h("Cannot add item decoration during a scroll  or layout");
        }
        if (this.p.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i2 < 0) {
            this.p.add(nVar);
        } else {
            this.p.add(i2, nVar);
        }
        z0();
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    public boolean i1(int i2, int i3, MotionEvent motionEvent) {
        int i4;
        int i5;
        int i6;
        int i7;
        v();
        if (this.m != null) {
            int[] iArr = this.v0;
            iArr[0] = 0;
            iArr[1] = 0;
            j1(i2, i3, iArr);
            int[] iArr2 = this.v0;
            int i8 = iArr2[0];
            int i9 = iArr2[1];
            i7 = i9;
            i6 = i8;
            i5 = i2 - i8;
            i4 = i3 - i9;
        } else {
            i7 = 0;
            i6 = 0;
            i5 = 0;
            i4 = 0;
        }
        if (!this.p.isEmpty()) {
            invalidate();
        }
        int[] iArr3 = this.v0;
        iArr3[0] = 0;
        iArr3[1] = 0;
        H(i6, i7, i5, i4, this.t0, 0, iArr3);
        int[] iArr4 = this.v0;
        int i10 = i5 - iArr4[0];
        int i11 = i4 - iArr4[1];
        boolean z2 = (iArr4[0] == 0 && iArr4[1] == 0) ? false : true;
        int i12 = this.T;
        int[] iArr5 = this.t0;
        this.T = i12 - iArr5[0];
        this.U -= iArr5[1];
        int[] iArr6 = this.u0;
        iArr6[0] = iArr6[0] + iArr5[0];
        iArr6[1] = iArr6[1] + iArr5[1];
        if (getOverScrollMode() != 2) {
            if (motionEvent != null && !b.h.k.j.a(motionEvent, 8194)) {
                S0(motionEvent.getX(), (float) i10, motionEvent.getY(), (float) i11);
            }
            u(i2, i3);
        }
        if (!(i6 == 0 && i7 == 0)) {
            J(i6, i7);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        if (!z2 && i6 == 0 && i7 == 0) {
            return false;
        }
        return true;
    }

    public boolean isAttachedToWindow() {
        return this.s;
    }

    public final boolean isLayoutSuppressed() {
        return this.y;
    }

    @Override // b.h.k.k
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().l();
    }

    public void j(q qVar) {
        if (this.D == null) {
            this.D = new ArrayList();
        }
        this.D.add(qVar);
    }

    /* access modifiers changed from: package-private */
    public void j1(int i2, int i3, int[] iArr) {
        t1();
        I0();
        androidx.core.os.h.a("RV Scroll");
        R(this.i0);
        int x1 = i2 != 0 ? this.n.x1(i2, this.f1535c, this.i0) : 0;
        int z1 = i3 != 0 ? this.n.z1(i3, this.f1535c, this.i0) : 0;
        androidx.core.os.h.b();
        c1();
        J0();
        v1(false);
        if (iArr != null) {
            iArr[0] = x1;
            iArr[1] = z1;
        }
    }

    public void k(s sVar) {
        this.q.add(sVar);
    }

    public void k1(int i2) {
        if (!this.y) {
            x1();
            o oVar = this.n;
            if (oVar == null) {
                Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
                return;
            }
            oVar.y1(i2);
            awakenScrollBars();
        }
    }

    public void l(t tVar) {
        if (this.k0 == null) {
            this.k0 = new ArrayList();
        }
        this.k0.add(tVar);
    }

    /* access modifiers changed from: package-private */
    public void m(d0 d0Var, l.c cVar, l.c cVar2) {
        d0Var.G(false);
        if (this.N.a(d0Var, cVar, cVar2)) {
            O0();
        }
    }

    /* access modifiers changed from: package-private */
    public Rect m0(View view) {
        p pVar = (p) view.getLayoutParams();
        if (!pVar.f1608c) {
            return pVar.f1607b;
        }
        if (this.i0.e() && (pVar.b() || pVar.d())) {
            return pVar.f1607b;
        }
        Rect rect = pVar.f1607b;
        rect.set(0, 0, 0, 0);
        int size = this.p.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f1542j.set(0, 0, 0, 0);
            this.p.get(i2).g(this.f1542j, view, this, this.i0);
            int i3 = rect.left;
            Rect rect2 = this.f1542j;
            rect.left = i3 + rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        pVar.f1608c = false;
        return rect;
    }

    /* access modifiers changed from: package-private */
    public boolean m1(d0 d0Var, int i2) {
        if (w0()) {
            d0Var.q = i2;
            this.w0.add(d0Var);
            return false;
        }
        b.h.k.u.x0(d0Var.f1565a, i2);
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean n1(AccessibilityEvent accessibilityEvent) {
        int i2 = 0;
        if (!w0()) {
            return false;
        }
        int a2 = accessibilityEvent != null ? b.h.k.d0.b.a(accessibilityEvent) : 0;
        if (a2 != 0) {
            i2 = a2;
        }
        this.A |= i2;
        return true;
    }

    /* access modifiers changed from: package-private */
    public void o(d0 d0Var, l.c cVar, l.c cVar2) {
        g(d0Var);
        d0Var.G(false);
        if (this.N.c(d0Var, cVar, cVar2)) {
            O0();
        }
    }

    public boolean o0() {
        return !this.v || this.E || this.f1537e.p();
    }

    public void o1(int i2, int i3) {
        p1(i2, i3, null);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.G = 0;
        boolean z2 = true;
        this.s = true;
        if (!this.v || isLayoutRequested()) {
            z2 = false;
        }
        this.v = z2;
        o oVar = this.n;
        if (oVar != null) {
            oVar.A(this);
        }
        this.o0 = false;
        if (D0) {
            ThreadLocal<e> threadLocal = e.f1750f;
            e eVar = threadLocal.get();
            this.g0 = eVar;
            if (eVar == null) {
                this.g0 = new e();
                Display v2 = b.h.k.u.v(this);
                float f2 = 60.0f;
                if (!isInEditMode() && v2 != null) {
                    float refreshRate = v2.getRefreshRate();
                    if (refreshRate >= 30.0f) {
                        f2 = refreshRate;
                    }
                }
                e eVar2 = this.g0;
                eVar2.f1754d = (long) (1.0E9f / f2);
                threadLocal.set(eVar2);
            }
            this.g0.a(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        e eVar;
        super.onDetachedFromWindow();
        l lVar = this.N;
        if (lVar != null) {
            lVar.k();
        }
        x1();
        this.s = false;
        o oVar = this.n;
        if (oVar != null) {
            oVar.B(this, this.f1535c);
        }
        this.w0.clear();
        removeCallbacks(this.x0);
        this.f1539g.j();
        if (D0 && (eVar = this.g0) != null) {
            eVar.j(this);
            this.g0 = null;
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.p.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.p.get(i2).i(canvas, this, this.i0);
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float f2;
        float f3;
        if (this.n != null && !this.y && motionEvent.getAction() == 8) {
            if ((motionEvent.getSource() & 2) != 0) {
                f3 = this.n.m() ? -motionEvent.getAxisValue(9) : Utils.FLOAT_EPSILON;
                if (this.n.l()) {
                    f2 = motionEvent.getAxisValue(10);
                    if (!(f3 == Utils.FLOAT_EPSILON && f2 == Utils.FLOAT_EPSILON)) {
                        i1((int) (f2 * this.c0), (int) (f3 * this.d0), motionEvent);
                    }
                }
            } else {
                if ((motionEvent.getSource() & 4194304) != 0) {
                    float axisValue = motionEvent.getAxisValue(26);
                    if (this.n.m()) {
                        f3 = -axisValue;
                    } else if (this.n.l()) {
                        f2 = axisValue;
                        f3 = Utils.FLOAT_EPSILON;
                        i1((int) (f2 * this.c0), (int) (f3 * this.d0), motionEvent);
                    }
                }
                f3 = Utils.FLOAT_EPSILON;
            }
            f2 = Utils.FLOAT_EPSILON;
            i1((int) (f2 * this.c0), (int) (f3 * this.d0), motionEvent);
        }
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z2;
        if (this.y) {
            return false;
        }
        this.r = null;
        if (V(motionEvent)) {
            r();
            return true;
        }
        o oVar = this.n;
        if (oVar == null) {
            return false;
        }
        boolean l2 = oVar.l();
        boolean m2 = this.n.m();
        if (this.Q == null) {
            this.Q = VelocityTracker.obtain();
        }
        this.Q.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.z) {
                this.z = false;
            }
            this.P = motionEvent.getPointerId(0);
            int x2 = (int) (motionEvent.getX() + 0.5f);
            this.T = x2;
            this.R = x2;
            int y2 = (int) (motionEvent.getY() + 0.5f);
            this.U = y2;
            this.S = y2;
            if (this.O == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
                w1(1);
            }
            int[] iArr = this.u0;
            iArr[1] = 0;
            iArr[0] = 0;
            if (m2) {
                boolean z3 = l2 ? 1 : 0;
                char c2 = l2 ? 1 : 0;
                l2 = z3 | true;
            }
            int i2 = l2 ? 1 : 0;
            int i3 = l2 ? 1 : 0;
            int i4 = l2 ? 1 : 0;
            u1(i2, 0);
        } else if (actionMasked == 1) {
            this.Q.clear();
            w1(0);
        } else if (actionMasked == 2) {
            int findPointerIndex = motionEvent.findPointerIndex(this.P);
            if (findPointerIndex < 0) {
                Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.P + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x3 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
            int y3 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
            if (this.O != 1) {
                int i5 = x3 - this.R;
                int i6 = y3 - this.S;
                if (!l2 || Math.abs(i5) <= this.V) {
                    z2 = false;
                } else {
                    this.T = x3;
                    z2 = true;
                }
                if (m2 && Math.abs(i6) > this.V) {
                    this.U = y3;
                    z2 = true;
                }
                if (z2) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            r();
        } else if (actionMasked == 5) {
            this.P = motionEvent.getPointerId(actionIndex);
            int x4 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.T = x4;
            this.R = x4;
            int y4 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.U = y4;
            this.S = y4;
        } else if (actionMasked == 6) {
            L0(motionEvent);
        }
        if (this.O == 1) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        androidx.core.os.h.a("RV OnLayout");
        C();
        androidx.core.os.h.b();
        this.v = true;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        o oVar = this.n;
        if (oVar == null) {
            x(i2, i3);
            return;
        }
        boolean z2 = false;
        if (oVar.t0()) {
            int mode = View.MeasureSpec.getMode(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            this.n.a1(this.f1535c, this.i0, i2, i3);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z2 = true;
            }
            if (!z2 && this.m != null) {
                if (this.i0.f1549e == 1) {
                    D();
                }
                this.n.B1(i2, i3);
                this.i0.f1554j = true;
                E();
                this.n.E1(i2, i3);
                if (this.n.H1()) {
                    this.n.B1(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                    this.i0.f1554j = true;
                    E();
                    this.n.E1(i2, i3);
                }
            }
        } else if (this.t) {
            this.n.a1(this.f1535c, this.i0, i2, i3);
        } else {
            if (this.B) {
                t1();
                I0();
                Q0();
                J0();
                a0 a0Var = this.i0;
                if (a0Var.l) {
                    a0Var.f1552h = true;
                } else {
                    this.f1537e.j();
                    this.i0.f1552h = false;
                }
                this.B = false;
                v1(false);
            } else if (this.i0.l) {
                setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
                return;
            }
            g gVar = this.m;
            if (gVar != null) {
                this.i0.f1550f = gVar.c();
            } else {
                this.i0.f1550f = 0;
            }
            t1();
            this.n.a1(this.f1535c, this.i0, i2, i3);
            v1(false);
            this.i0.f1552h = false;
        }
    }

    /* access modifiers changed from: protected */
    public boolean onRequestFocusInDescendants(int i2, Rect rect) {
        if (w0()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i2, rect);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof y)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        y yVar = (y) parcelable;
        this.f1536d = yVar;
        super.onRestoreInstanceState(yVar.g());
        o oVar = this.n;
        if (oVar != null && (parcelable2 = this.f1536d.f1626d) != null) {
            oVar.d1(parcelable2);
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        y yVar = new y(super.onSaveInstanceState());
        y yVar2 = this.f1536d;
        if (yVar2 != null) {
            yVar.k(yVar2);
        } else {
            o oVar = this.n;
            if (oVar != null) {
                yVar.f1626d = oVar.e1();
            } else {
                yVar.f1626d = null;
            }
        }
        return yVar;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 != i4 || i3 != i5) {
            u0();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00f8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
        // Method dump skipped, instructions count: 480
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* access modifiers changed from: package-private */
    public void p(String str) {
        if (w0()) {
            if (str == null) {
                throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + Q());
            }
            throw new IllegalStateException(str);
        } else if (this.H > 0) {
            Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException(BuildConfig.FLAVOR + Q()));
        }
    }

    public void p1(int i2, int i3, Interpolator interpolator) {
        q1(i2, i3, interpolator, Integer.MIN_VALUE);
    }

    /* access modifiers changed from: package-private */
    public boolean q(d0 d0Var) {
        l lVar = this.N;
        return lVar == null || lVar.g(d0Var, d0Var.o());
    }

    /* access modifiers changed from: package-private */
    public void q0() {
        this.f1537e = new a(new f());
    }

    public void q1(int i2, int i3, Interpolator interpolator, int i4) {
        r1(i2, i3, interpolator, i4, false);
    }

    /* access modifiers changed from: package-private */
    public void r1(int i2, int i3, Interpolator interpolator, int i4, boolean z2) {
        o oVar = this.n;
        if (oVar == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.y) {
            int i5 = 0;
            if (!oVar.l()) {
                i2 = 0;
            }
            if (!this.n.m()) {
                i3 = 0;
            }
            if (i2 != 0 || i3 != 0) {
                if (i4 == Integer.MIN_VALUE || i4 > 0) {
                    if (z2) {
                        if (i2 != 0) {
                            i5 = 1;
                        }
                        if (i3 != 0) {
                            i5 |= 2;
                        }
                        u1(i5, 1);
                    }
                    this.f0.f(i2, i3, i4, interpolator);
                    return;
                }
                scrollBy(i2, i3);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void removeDetachedView(View view, boolean z2) {
        d0 i02 = i0(view);
        if (i02 != null) {
            if (i02.x()) {
                i02.f();
            } else if (!i02.J()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + i02 + Q());
            }
        }
        view.clearAnimation();
        A(view);
        super.removeDetachedView(view, z2);
    }

    public void requestChildFocus(View view, View view2) {
        if (!this.n.c1(this, this.i0, view, view2) && view2 != null) {
            d1(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z2) {
        return this.n.s1(this, view, rect, z2);
    }

    public void requestDisallowInterceptTouchEvent(boolean z2) {
        int size = this.q.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.q.get(i2).e(z2);
        }
        super.requestDisallowInterceptTouchEvent(z2);
    }

    public void requestLayout() {
        if (this.w != 0 || this.y) {
            this.x = true;
        } else {
            super.requestLayout();
        }
    }

    public void s1(int i2) {
        if (!this.y) {
            o oVar = this.n;
            if (oVar == null) {
                Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            } else {
                oVar.J1(this, this.i0, i2);
            }
        }
    }

    public void scrollBy(int i2, int i3) {
        o oVar = this.n;
        if (oVar == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.y) {
            boolean l2 = oVar.l();
            boolean m2 = this.n.m();
            if (l2 || m2) {
                if (!l2) {
                    i2 = 0;
                }
                if (!m2) {
                    i3 = 0;
                }
                i1(i2, i3, null);
            }
        }
    }

    public void scrollTo(int i2, int i3) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (!n1(accessibilityEvent)) {
            super.sendAccessibilityEventUnchecked(accessibilityEvent);
        }
    }

    public void setAccessibilityDelegateCompat(n nVar) {
        this.p0 = nVar;
        b.h.k.u.m0(this, nVar);
    }

    public void setAdapter(g gVar) {
        setLayoutFrozen(false);
        l1(gVar, false, true);
        R0(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(j jVar) {
        if (jVar != this.q0) {
            this.q0 = jVar;
            setChildrenDrawingOrderEnabled(jVar != null);
        }
    }

    public void setClipToPadding(boolean z2) {
        if (z2 != this.f1540h) {
            u0();
        }
        this.f1540h = z2;
        super.setClipToPadding(z2);
        if (this.v) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(k kVar) {
        b.h.j.h.c(kVar);
        this.I = kVar;
        u0();
    }

    public void setHasFixedSize(boolean z2) {
        this.t = z2;
    }

    public void setItemAnimator(l lVar) {
        l lVar2 = this.N;
        if (lVar2 != null) {
            lVar2.k();
            this.N.w(null);
        }
        this.N = lVar;
        if (lVar != null) {
            lVar.w(this.n0);
        }
    }

    public void setItemViewCacheSize(int i2) {
        this.f1535c.G(i2);
    }

    @Deprecated
    public void setLayoutFrozen(boolean z2) {
        suppressLayout(z2);
    }

    public void setLayoutManager(o oVar) {
        if (oVar != this.n) {
            x1();
            if (this.n != null) {
                l lVar = this.N;
                if (lVar != null) {
                    lVar.k();
                }
                this.n.l1(this.f1535c);
                this.n.m1(this.f1535c);
                this.f1535c.c();
                if (this.s) {
                    this.n.B(this, this.f1535c);
                }
                this.n.F1(null);
                this.n = null;
            } else {
                this.f1535c.c();
            }
            this.f1538f.o();
            this.n = oVar;
            if (oVar != null) {
                if (oVar.f1590b == null) {
                    oVar.F1(this);
                    if (this.s) {
                        this.n.A(this);
                    }
                } else {
                    throw new IllegalArgumentException("LayoutManager " + oVar + " is already attached to a RecyclerView:" + oVar.f1590b.Q());
                }
            }
            this.f1535c.K();
            requestLayout();
        }
    }

    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (Build.VERSION.SDK_INT < 18) {
            if (layoutTransition == null) {
                suppressLayout(false);
                return;
            } else if (layoutTransition.getAnimator(0) == null && layoutTransition.getAnimator(1) == null && layoutTransition.getAnimator(2) == null && layoutTransition.getAnimator(3) == null && layoutTransition.getAnimator(4) == null) {
                suppressLayout(true);
                return;
            }
        }
        if (layoutTransition == null) {
            super.setLayoutTransition(null);
            return;
        }
        throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
    }

    public void setNestedScrollingEnabled(boolean z2) {
        getScrollingChildHelper().m(z2);
    }

    public void setOnFlingListener(r rVar) {
        this.W = rVar;
    }

    @Deprecated
    public void setOnScrollListener(t tVar) {
        this.j0 = tVar;
    }

    public void setPreserveFocusAfterLayout(boolean z2) {
        this.e0 = z2;
    }

    public void setRecycledViewPool(u uVar) {
        this.f1535c.E(uVar);
    }

    public void setRecyclerListener(w wVar) {
        this.o = wVar;
    }

    /* access modifiers changed from: package-private */
    public void setScrollState(int i2) {
        if (i2 != this.O) {
            this.O = i2;
            if (i2 != 2) {
                y1();
            }
            I(i2);
        }
    }

    public void setScrollingTouchSlop(int i2) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i2 != 0) {
            if (i2 != 1) {
                Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i2 + "; using default value");
            } else {
                this.V = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
        }
        this.V = viewConfiguration.getScaledTouchSlop();
    }

    public void setViewCacheExtension(b0 b0Var) {
        this.f1535c.F(b0Var);
    }

    public boolean startNestedScroll(int i2) {
        return getScrollingChildHelper().o(i2);
    }

    @Override // b.h.k.k
    public void stopNestedScroll() {
        getScrollingChildHelper().q();
    }

    public final void suppressLayout(boolean z2) {
        if (z2 != this.y) {
            p("Do not suppressLayout in layout or scroll");
            if (!z2) {
                this.y = false;
                if (!(!this.x || this.n == null || this.m == null)) {
                    requestLayout();
                }
                this.x = false;
                return;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, Utils.FLOAT_EPSILON, Utils.FLOAT_EPSILON, 0));
            this.y = true;
            this.z = true;
            x1();
        }
    }

    /* access modifiers changed from: package-private */
    public void t() {
        int j2 = this.f1538f.j();
        for (int i2 = 0; i2 < j2; i2++) {
            d0 i02 = i0(this.f1538f.i(i2));
            if (!i02.J()) {
                i02.c();
            }
        }
        this.f1535c.d();
    }

    /* access modifiers changed from: package-private */
    public void t0(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable == null || drawable == null || stateListDrawable2 == null || drawable2 == null) {
            throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + Q());
        }
        Resources resources = getContext().getResources();
        new d(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(b.q.b.fastscroll_default_thickness), resources.getDimensionPixelSize(b.q.b.fastscroll_minimum_range), resources.getDimensionPixelOffset(b.q.b.fastscroll_margin));
    }

    /* access modifiers changed from: package-private */
    public void t1() {
        int i2 = this.w + 1;
        this.w = i2;
        if (i2 == 1 && !this.y) {
            this.x = false;
        }
    }

    /* access modifiers changed from: package-private */
    public void u(int i2, int i3) {
        boolean z2;
        EdgeEffect edgeEffect = this.J;
        if (edgeEffect == null || edgeEffect.isFinished() || i2 <= 0) {
            z2 = false;
        } else {
            this.J.onRelease();
            z2 = this.J.isFinished();
        }
        EdgeEffect edgeEffect2 = this.L;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i2 < 0) {
            this.L.onRelease();
            z2 |= this.L.isFinished();
        }
        EdgeEffect edgeEffect3 = this.K;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i3 > 0) {
            this.K.onRelease();
            z2 |= this.K.isFinished();
        }
        EdgeEffect edgeEffect4 = this.M;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i3 < 0) {
            this.M.onRelease();
            z2 |= this.M.isFinished();
        }
        if (z2) {
            b.h.k.u.d0(this);
        }
    }

    /* access modifiers changed from: package-private */
    public void u0() {
        this.M = null;
        this.K = null;
        this.L = null;
        this.J = null;
    }

    public boolean u1(int i2, int i3) {
        return getScrollingChildHelper().p(i2, i3);
    }

    /* access modifiers changed from: package-private */
    public void v() {
        if (!this.v || this.E) {
            androidx.core.os.h.a("RV FullInvalidate");
            C();
            androidx.core.os.h.b();
        } else if (this.f1537e.p()) {
            if (this.f1537e.o(4) && !this.f1537e.o(11)) {
                androidx.core.os.h.a("RV PartialInvalidate");
                t1();
                I0();
                this.f1537e.v();
                if (!this.x) {
                    if (p0()) {
                        C();
                    } else {
                        this.f1537e.i();
                    }
                }
                v1(true);
                J0();
                androidx.core.os.h.b();
            } else if (this.f1537e.p()) {
                androidx.core.os.h.a("RV FullInvalidate");
                C();
                androidx.core.os.h.b();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean v0() {
        AccessibilityManager accessibilityManager = this.C;
        return accessibilityManager != null && accessibilityManager.isEnabled();
    }

    /* access modifiers changed from: package-private */
    public void v1(boolean z2) {
        if (this.w < 1) {
            this.w = 1;
        }
        if (!z2 && !this.y) {
            this.x = false;
        }
        if (this.w == 1) {
            if (z2 && this.x && !this.y && this.n != null && this.m != null) {
                C();
            }
            if (!this.y) {
                this.x = false;
            }
        }
        this.w--;
    }

    public boolean w0() {
        return this.G > 0;
    }

    public void w1(int i2) {
        getScrollingChildHelper().r(i2);
    }

    /* access modifiers changed from: package-private */
    public void x(int i2, int i3) {
        setMeasuredDimension(o.o(i2, getPaddingLeft() + getPaddingRight(), b.h.k.u.D(this)), o.o(i3, getPaddingTop() + getPaddingBottom(), b.h.k.u.C(this)));
    }

    public void x1() {
        setScrollState(0);
        y1();
    }

    /* access modifiers changed from: package-private */
    public void y0(int i2) {
        if (this.n != null) {
            setScrollState(2);
            this.n.y1(i2);
            awakenScrollBars();
        }
    }

    /* access modifiers changed from: package-private */
    public void z(View view) {
        d0 i02 = i0(view);
        G0(view);
        g gVar = this.m;
        if (!(gVar == null || i02 == null)) {
            gVar.r(i02);
        }
        List<q> list = this.D;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.D.get(size).b(view);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void z0() {
        int j2 = this.f1538f.j();
        for (int i2 = 0; i2 < j2; i2++) {
            ((p) this.f1538f.i(i2).getLayoutParams()).f1608c = true;
        }
        this.f1535c.s();
    }

    /* access modifiers changed from: package-private */
    public void z1(int i2, int i3, Object obj) {
        int i4;
        int j2 = this.f1538f.j();
        int i5 = i2 + i3;
        for (int i6 = 0; i6 < j2; i6++) {
            View i7 = this.f1538f.i(i6);
            d0 i02 = i0(i7);
            if (i02 != null && !i02.J() && (i4 = i02.f1567c) >= i2 && i4 < i5) {
                i02.b(2);
                i02.a(obj);
                ((p) i7.getLayoutParams()).f1608c = true;
            }
        }
        this.f1535c.M(i2, i3);
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f1534b = new x();
        this.f1535c = new v();
        this.f1539g = new s();
        this.f1541i = new a();
        this.f1542j = new Rect();
        this.f1543k = new Rect();
        this.l = new RectF();
        this.p = new ArrayList<>();
        this.q = new ArrayList<>();
        this.w = 0;
        this.E = false;
        this.F = false;
        this.G = 0;
        this.H = 0;
        this.I = new k();
        this.N = new c();
        this.O = 0;
        this.P = -1;
        this.c0 = Float.MIN_VALUE;
        this.d0 = Float.MIN_VALUE;
        boolean z2 = true;
        this.e0 = true;
        this.f0 = new c0();
        this.h0 = D0 ? new e.b() : null;
        this.i0 = new a0();
        this.l0 = false;
        this.m0 = false;
        this.n0 = new m();
        this.o0 = false;
        this.r0 = new int[2];
        this.t0 = new int[2];
        this.u0 = new int[2];
        this.v0 = new int[2];
        this.w0 = new ArrayList();
        this.x0 = new b();
        this.y0 = new d();
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.V = viewConfiguration.getScaledTouchSlop();
        this.c0 = b.h.k.v.b(viewConfiguration, context);
        this.d0 = b.h.k.v.d(viewConfiguration, context);
        this.a0 = viewConfiguration.getScaledMinimumFlingVelocity();
        this.b0 = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.N.w(this.n0);
        q0();
        s0();
        r0();
        if (b.h.k.u.z(this) == 0) {
            b.h.k.u.x0(this, 1);
        }
        this.C = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new n(this));
        int[] iArr = b.q.d.f2822a;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i2, 0);
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 29) {
            saveAttributeDataForStyleable(context, iArr, attributeSet, obtainStyledAttributes, i2, 0);
        }
        String string = obtainStyledAttributes.getString(b.q.d.f2831j);
        if (obtainStyledAttributes.getInt(b.q.d.f2825d, -1) == -1) {
            setDescendantFocusability(262144);
        }
        this.f1540h = obtainStyledAttributes.getBoolean(b.q.d.f2824c, true);
        boolean z3 = obtainStyledAttributes.getBoolean(b.q.d.f2826e, false);
        this.u = z3;
        if (z3) {
            t0((StateListDrawable) obtainStyledAttributes.getDrawable(b.q.d.f2829h), obtainStyledAttributes.getDrawable(b.q.d.f2830i), (StateListDrawable) obtainStyledAttributes.getDrawable(b.q.d.f2827f), obtainStyledAttributes.getDrawable(b.q.d.f2828g));
        }
        obtainStyledAttributes.recycle();
        w(context, string, attributeSet, i2, 0);
        if (i3 >= 21) {
            int[] iArr2 = z0;
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr2, i2, 0);
            if (i3 >= 29) {
                saveAttributeDataForStyleable(context, iArr2, attributeSet, obtainStyledAttributes2, i2, 0);
            }
            z2 = obtainStyledAttributes2.getBoolean(0, true);
            obtainStyledAttributes2.recycle();
        }
        setNestedScrollingEnabled(z2);
    }

    public static class p extends ViewGroup.MarginLayoutParams {

        /* renamed from: a  reason: collision with root package name */
        d0 f1606a;

        /* renamed from: b  reason: collision with root package name */
        final Rect f1607b = new Rect();

        /* renamed from: c  reason: collision with root package name */
        boolean f1608c = true;

        /* renamed from: d  reason: collision with root package name */
        boolean f1609d = false;

        public p(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public int a() {
            return this.f1606a.m();
        }

        public boolean b() {
            return this.f1606a.y();
        }

        public boolean c() {
            return this.f1606a.v();
        }

        public boolean d() {
            return this.f1606a.t();
        }

        public p(int i2, int i3) {
            super(i2, i3);
        }

        public p(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public p(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public p(p pVar) {
            super((ViewGroup.LayoutParams) pVar);
        }
    }

    public static class y extends b.j.a.a {
        public static final Parcelable.Creator<y> CREATOR = new a();

        /* renamed from: d  reason: collision with root package name */
        Parcelable f1626d;

        static class a implements Parcelable.ClassLoaderCreator<y> {
            a() {
            }

            /* renamed from: a */
            public y createFromParcel(Parcel parcel) {
                return new y(parcel, null);
            }

            /* renamed from: b */
            public y createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new y(parcel, classLoader);
            }

            /* renamed from: c */
            public y[] newArray(int i2) {
                return new y[i2];
            }
        }

        y(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f1626d = parcel.readParcelable(classLoader == null ? o.class.getClassLoader() : classLoader);
        }

        /* access modifiers changed from: package-private */
        public void k(y yVar) {
            this.f1626d = yVar.f1626d;
        }

        @Override // b.j.a.a
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeParcelable(this.f1626d, 0);
        }

        y(Parcelable parcelable) {
            super(parcelable);
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        o oVar = this.n;
        if (oVar != null) {
            return oVar.G(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + Q());
    }
}
