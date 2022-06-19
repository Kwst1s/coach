package androidx.drawerlayout.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import b.h.k.d0.c;
import b.h.k.u;
import b.j.b.c;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

public class DrawerLayout extends ViewGroup {
    private static final int[] L = {16843828};
    static final int[] M = {16842931};
    static final boolean N;
    private static final boolean O;
    private CharSequence A;
    private CharSequence B;
    private Object C;
    private boolean D;
    private Drawable E;
    private Drawable F;
    private Drawable G;
    private Drawable H;
    private final ArrayList<View> I;
    private Rect J;
    private Matrix K;

    /* renamed from: b  reason: collision with root package name */
    private final c f1184b;

    /* renamed from: c  reason: collision with root package name */
    private float f1185c;

    /* renamed from: d  reason: collision with root package name */
    private int f1186d;

    /* renamed from: e  reason: collision with root package name */
    private int f1187e;

    /* renamed from: f  reason: collision with root package name */
    private float f1188f;

    /* renamed from: g  reason: collision with root package name */
    private Paint f1189g;

    /* renamed from: h  reason: collision with root package name */
    private final b.j.b.c f1190h;

    /* renamed from: i  reason: collision with root package name */
    private final b.j.b.c f1191i;

    /* renamed from: j  reason: collision with root package name */
    private final g f1192j;

    /* renamed from: k  reason: collision with root package name */
    private final g f1193k;
    private int l;
    private boolean m;
    private boolean n;
    private int o;
    private int p;
    private int q;
    private int r;
    private boolean s;
    private d t;
    private List<d> u;
    private float v;
    private float w;
    private Drawable x;
    private Drawable y;
    private Drawable z;

    class a implements View.OnApplyWindowInsetsListener {
        a(DrawerLayout drawerLayout) {
        }

        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            ((DrawerLayout) view).M(windowInsets, windowInsets.getSystemWindowInsetTop() > 0);
            return windowInsets.consumeSystemWindowInsets();
        }
    }

    class b extends b.h.k.a {

        /* renamed from: d  reason: collision with root package name */
        private final Rect f1194d = new Rect();

        b() {
        }

        private void n(b.h.k.d0.c cVar, ViewGroup viewGroup) {
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (DrawerLayout.y(childAt)) {
                    cVar.c(childAt);
                }
            }
        }

        private void o(b.h.k.d0.c cVar, b.h.k.d0.c cVar2) {
            Rect rect = this.f1194d;
            cVar2.m(rect);
            cVar.W(rect);
            cVar2.n(rect);
            cVar.X(rect);
            cVar.C0(cVar2.M());
            cVar.o0(cVar2.u());
            cVar.a0(cVar2.p());
            cVar.e0(cVar2.r());
            cVar.g0(cVar2.E());
            cVar.b0(cVar2.D());
            cVar.i0(cVar2.F());
            cVar.j0(cVar2.G());
            cVar.U(cVar2.A());
            cVar.v0(cVar2.K());
            cVar.m0(cVar2.H());
            cVar.a(cVar2.k());
        }

        @Override // b.h.k.a
        public boolean a(View view, AccessibilityEvent accessibilityEvent) {
            CharSequence q;
            if (accessibilityEvent.getEventType() != 32) {
                return super.a(view, accessibilityEvent);
            }
            List<CharSequence> text = accessibilityEvent.getText();
            View n = DrawerLayout.this.n();
            if (n == null || (q = DrawerLayout.this.q(DrawerLayout.this.r(n))) == null) {
                return true;
            }
            text.add(q);
            return true;
        }

        @Override // b.h.k.a
        public void f(View view, AccessibilityEvent accessibilityEvent) {
            super.f(view, accessibilityEvent);
            accessibilityEvent.setClassName(DrawerLayout.class.getName());
        }

        @Override // b.h.k.a
        public void g(View view, b.h.k.d0.c cVar) {
            if (DrawerLayout.N) {
                super.g(view, cVar);
            } else {
                b.h.k.d0.c P = b.h.k.d0.c.P(cVar);
                super.g(view, P);
                cVar.x0(view);
                ViewParent H = u.H(view);
                if (H instanceof View) {
                    cVar.q0((View) H);
                }
                o(cVar, P);
                P.R();
                n(cVar, (ViewGroup) view);
            }
            cVar.a0(DrawerLayout.class.getName());
            cVar.i0(false);
            cVar.j0(false);
            cVar.S(c.a.f2640e);
            cVar.S(c.a.f2641f);
        }

        @Override // b.h.k.a
        public boolean i(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (DrawerLayout.N || DrawerLayout.y(view)) {
                return super.i(viewGroup, view, accessibilityEvent);
            }
            return false;
        }
    }

    static final class c extends b.h.k.a {
        c() {
        }

        @Override // b.h.k.a
        public void g(View view, b.h.k.d0.c cVar) {
            super.g(view, cVar);
            if (!DrawerLayout.y(view)) {
                cVar.q0(null);
            }
        }
    }

    public interface d {
        void a(int i2);

        void b(View view, float f2);

        void c(View view);

        void d(View view);
    }

    /* access modifiers changed from: private */
    public class g extends c.AbstractC0054c {

        /* renamed from: a  reason: collision with root package name */
        private final int f1205a;

        /* renamed from: b  reason: collision with root package name */
        private b.j.b.c f1206b;

        /* renamed from: c  reason: collision with root package name */
        private final Runnable f1207c = new a();

        class a implements Runnable {
            a() {
            }

            public void run() {
                g.this.o();
            }
        }

        g(int i2) {
            this.f1205a = i2;
        }

        private void n() {
            int i2 = 3;
            if (this.f1205a == 3) {
                i2 = 5;
            }
            View l = DrawerLayout.this.l(i2);
            if (l != null) {
                DrawerLayout.this.d(l);
            }
        }

        @Override // b.j.b.c.AbstractC0054c
        public int a(View view, int i2, int i3) {
            if (DrawerLayout.this.c(view, 3)) {
                return Math.max(-view.getWidth(), Math.min(i2, 0));
            }
            int width = DrawerLayout.this.getWidth();
            return Math.max(width - view.getWidth(), Math.min(i2, width));
        }

        @Override // b.j.b.c.AbstractC0054c
        public int b(View view, int i2, int i3) {
            return view.getTop();
        }

        @Override // b.j.b.c.AbstractC0054c
        public int d(View view) {
            if (DrawerLayout.this.B(view)) {
                return view.getWidth();
            }
            return 0;
        }

        @Override // b.j.b.c.AbstractC0054c
        public void f(int i2, int i3) {
            View view;
            if ((i2 & 1) == 1) {
                view = DrawerLayout.this.l(3);
            } else {
                view = DrawerLayout.this.l(5);
            }
            if (view != null && DrawerLayout.this.p(view) == 0) {
                this.f1206b.c(view, i3);
            }
        }

        @Override // b.j.b.c.AbstractC0054c
        public boolean g(int i2) {
            return false;
        }

        @Override // b.j.b.c.AbstractC0054c
        public void h(int i2, int i3) {
            DrawerLayout.this.postDelayed(this.f1207c, 160);
        }

        @Override // b.j.b.c.AbstractC0054c
        public void i(View view, int i2) {
            ((e) view.getLayoutParams()).f1198c = false;
            n();
        }

        @Override // b.j.b.c.AbstractC0054c
        public void j(int i2) {
            DrawerLayout.this.Q(this.f1205a, i2, this.f1206b.w());
        }

        @Override // b.j.b.c.AbstractC0054c
        public void k(View view, int i2, int i3, int i4, int i5) {
            float f2;
            int width = view.getWidth();
            if (DrawerLayout.this.c(view, 3)) {
                f2 = (float) (i2 + width);
            } else {
                f2 = (float) (DrawerLayout.this.getWidth() - i2);
            }
            float f3 = f2 / ((float) width);
            DrawerLayout.this.O(view, f3);
            view.setVisibility(f3 == Utils.FLOAT_EPSILON ? 4 : 0);
            DrawerLayout.this.invalidate();
        }

        @Override // b.j.b.c.AbstractC0054c
        public void l(View view, float f2, float f3) {
            int i2;
            float s = DrawerLayout.this.s(view);
            int width = view.getWidth();
            if (DrawerLayout.this.c(view, 3)) {
                i2 = (f2 > Utils.FLOAT_EPSILON || (f2 == Utils.FLOAT_EPSILON && s > 0.5f)) ? 0 : -width;
            } else {
                int width2 = DrawerLayout.this.getWidth();
                if (f2 < Utils.FLOAT_EPSILON || (f2 == Utils.FLOAT_EPSILON && s > 0.5f)) {
                    width2 -= width;
                }
                i2 = width2;
            }
            this.f1206b.N(i2, view.getTop());
            DrawerLayout.this.invalidate();
        }

        @Override // b.j.b.c.AbstractC0054c
        public boolean m(View view, int i2) {
            return DrawerLayout.this.B(view) && DrawerLayout.this.c(view, this.f1205a) && DrawerLayout.this.p(view) == 0;
        }

        /* access modifiers changed from: package-private */
        public void o() {
            View view;
            int i2;
            int x = this.f1206b.x();
            int i3 = 0;
            boolean z = this.f1205a == 3;
            if (z) {
                view = DrawerLayout.this.l(3);
                if (view != null) {
                    i3 = -view.getWidth();
                }
                i2 = i3 + x;
            } else {
                view = DrawerLayout.this.l(5);
                i2 = DrawerLayout.this.getWidth() - x;
            }
            if (view == null) {
                return;
            }
            if (((z && view.getLeft() < i2) || (!z && view.getLeft() > i2)) && DrawerLayout.this.p(view) == 0) {
                this.f1206b.P(view, i2, view.getTop());
                ((e) view.getLayoutParams()).f1198c = true;
                DrawerLayout.this.invalidate();
                n();
                DrawerLayout.this.b();
            }
        }

        public void p() {
            DrawerLayout.this.removeCallbacks(this.f1207c);
        }

        public void q(b.j.b.c cVar) {
            this.f1206b = cVar;
        }
    }

    static {
        boolean z2 = true;
        int i2 = Build.VERSION.SDK_INT;
        N = i2 >= 19;
        if (i2 < 21) {
            z2 = false;
        }
        O = z2;
    }

    public DrawerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private boolean D(float f2, float f3, View view) {
        if (this.J == null) {
            this.J = new Rect();
        }
        view.getHitRect(this.J);
        return this.J.contains((int) f2, (int) f3);
    }

    private boolean E(Drawable drawable, int i2) {
        if (drawable == null || !androidx.core.graphics.drawable.a.h(drawable)) {
            return false;
        }
        androidx.core.graphics.drawable.a.m(drawable, i2);
        return true;
    }

    private Drawable J() {
        int B2 = u.B(this);
        if (B2 == 0) {
            Drawable drawable = this.E;
            if (drawable != null) {
                E(drawable, B2);
                return this.E;
            }
        } else {
            Drawable drawable2 = this.F;
            if (drawable2 != null) {
                E(drawable2, B2);
                return this.F;
            }
        }
        return this.G;
    }

    private Drawable K() {
        int B2 = u.B(this);
        if (B2 == 0) {
            Drawable drawable = this.F;
            if (drawable != null) {
                E(drawable, B2);
                return this.F;
            }
        } else {
            Drawable drawable2 = this.E;
            if (drawable2 != null) {
                E(drawable2, B2);
                return this.E;
            }
        }
        return this.H;
    }

    private void L() {
        if (!O) {
            this.y = J();
            this.z = K();
        }
    }

    private void P(View view, boolean z2) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((z2 || B(childAt)) && (!z2 || childAt != view)) {
                u.x0(childAt, 4);
            } else {
                u.x0(childAt, 1);
            }
        }
    }

    private boolean k(MotionEvent motionEvent, View view) {
        if (!view.getMatrix().isIdentity()) {
            MotionEvent t2 = t(motionEvent, view);
            boolean dispatchGenericMotionEvent = view.dispatchGenericMotionEvent(t2);
            t2.recycle();
            return dispatchGenericMotionEvent;
        }
        float scrollX = (float) (getScrollX() - view.getLeft());
        float scrollY = (float) (getScrollY() - view.getTop());
        motionEvent.offsetLocation(scrollX, scrollY);
        boolean dispatchGenericMotionEvent2 = view.dispatchGenericMotionEvent(motionEvent);
        motionEvent.offsetLocation(-scrollX, -scrollY);
        return dispatchGenericMotionEvent2;
    }

    private MotionEvent t(MotionEvent motionEvent, View view) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.offsetLocation((float) (getScrollX() - view.getLeft()), (float) (getScrollY() - view.getTop()));
        Matrix matrix = view.getMatrix();
        if (!matrix.isIdentity()) {
            if (this.K == null) {
                this.K = new Matrix();
            }
            matrix.invert(this.K);
            obtain.transform(this.K);
        }
        return obtain;
    }

    static String u(int i2) {
        if ((i2 & 3) == 3) {
            return "LEFT";
        }
        return (i2 & 5) == 5 ? "RIGHT" : Integer.toHexString(i2);
    }

    private static boolean v(View view) {
        Drawable background = view.getBackground();
        if (background == null || background.getOpacity() != -1) {
            return false;
        }
        return true;
    }

    private boolean w() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            if (((e) getChildAt(i2).getLayoutParams()).f1198c) {
                return true;
            }
        }
        return false;
    }

    private boolean x() {
        return n() != null;
    }

    static boolean y(View view) {
        return (u.z(view) == 4 || u.z(view) == 2) ? false : true;
    }

    public boolean A(View view) {
        if (B(view)) {
            return (((e) view.getLayoutParams()).f1199d & 1) == 1;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    /* access modifiers changed from: package-private */
    public boolean B(View view) {
        int b2 = b.h.k.e.b(((e) view.getLayoutParams()).f1196a, u.B(view));
        return ((b2 & 3) == 0 && (b2 & 5) == 0) ? false : true;
    }

    public boolean C(View view) {
        if (B(view)) {
            return ((e) view.getLayoutParams()).f1197b > Utils.FLOAT_EPSILON;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    /* access modifiers changed from: package-private */
    public void F(View view, float f2) {
        float s2 = s(view);
        float width = (float) view.getWidth();
        int i2 = ((int) (width * f2)) - ((int) (s2 * width));
        if (!c(view, 3)) {
            i2 = -i2;
        }
        view.offsetLeftAndRight(i2);
        O(view, f2);
    }

    public void G(View view) {
        H(view, true);
    }

    public void H(View view, boolean z2) {
        if (B(view)) {
            e eVar = (e) view.getLayoutParams();
            if (this.n) {
                eVar.f1197b = 1.0f;
                eVar.f1199d = 1;
                P(view, true);
            } else if (z2) {
                eVar.f1199d |= 2;
                if (c(view, 3)) {
                    this.f1190h.P(view, 0, view.getTop());
                } else {
                    this.f1191i.P(view, getWidth() - view.getWidth(), view.getTop());
                }
            } else {
                F(view, 1.0f);
                Q(eVar.f1196a, 0, view);
                view.setVisibility(0);
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    public void I(d dVar) {
        List<d> list;
        if (dVar != null && (list = this.u) != null) {
            list.remove(dVar);
        }
    }

    public void M(Object obj, boolean z2) {
        this.C = obj;
        this.D = z2;
        setWillNotDraw(!z2 && getBackground() == null);
        requestLayout();
    }

    public void N(int i2, int i3) {
        View l2;
        int b2 = b.h.k.e.b(i3, u.B(this));
        if (i3 == 3) {
            this.o = i2;
        } else if (i3 == 5) {
            this.p = i2;
        } else if (i3 == 8388611) {
            this.q = i2;
        } else if (i3 == 8388613) {
            this.r = i2;
        }
        if (i2 != 0) {
            (b2 == 3 ? this.f1190h : this.f1191i).b();
        }
        if (i2 == 1) {
            View l3 = l(b2);
            if (l3 != null) {
                d(l3);
            }
        } else if (i2 == 2 && (l2 = l(b2)) != null) {
            G(l2);
        }
    }

    /* access modifiers changed from: package-private */
    public void O(View view, float f2) {
        e eVar = (e) view.getLayoutParams();
        if (f2 != eVar.f1197b) {
            eVar.f1197b = f2;
            j(view, f2);
        }
    }

    /* access modifiers changed from: package-private */
    public void Q(int i2, int i3, View view) {
        int A2 = this.f1190h.A();
        int A3 = this.f1191i.A();
        int i4 = 2;
        if (A2 == 1 || A3 == 1) {
            i4 = 1;
        } else if (!(A2 == 2 || A3 == 2)) {
            i4 = 0;
        }
        if (view != null && i3 == 0) {
            float f2 = ((e) view.getLayoutParams()).f1197b;
            if (f2 == Utils.FLOAT_EPSILON) {
                h(view);
            } else if (f2 == 1.0f) {
                i(view);
            }
        }
        if (i4 != this.l) {
            this.l = i4;
            List<d> list = this.u;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.u.get(size).a(i4);
                }
            }
        }
    }

    public void a(d dVar) {
        if (dVar != null) {
            if (this.u == null) {
                this.u = new ArrayList();
            }
            this.u.add(dVar);
        }
    }

    @Override // android.view.View, android.view.ViewGroup
    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        if (getDescendantFocusability() != 393216) {
            int childCount = getChildCount();
            boolean z2 = false;
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                if (!B(childAt)) {
                    this.I.add(childAt);
                } else if (A(childAt)) {
                    childAt.addFocusables(arrayList, i2, i3);
                    z2 = true;
                }
            }
            if (!z2) {
                int size = this.I.size();
                for (int i5 = 0; i5 < size; i5++) {
                    View view = this.I.get(i5);
                    if (view.getVisibility() == 0) {
                        view.addFocusables(arrayList, i2, i3);
                    }
                }
            }
            this.I.clear();
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i2, layoutParams);
        if (m() != null || B(view)) {
            u.x0(view, 4);
        } else {
            u.x0(view, 1);
        }
        if (!N) {
            u.m0(view, this.f1184b);
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        if (!this.s) {
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, Utils.FLOAT_EPSILON, Utils.FLOAT_EPSILON, 0);
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                getChildAt(i2).dispatchTouchEvent(obtain);
            }
            obtain.recycle();
            this.s = true;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean c(View view, int i2) {
        return (r(view) & i2) == i2;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof e) && super.checkLayoutParams(layoutParams);
    }

    public void computeScroll() {
        int childCount = getChildCount();
        float f2 = Utils.FLOAT_EPSILON;
        for (int i2 = 0; i2 < childCount; i2++) {
            f2 = Math.max(f2, ((e) getChildAt(i2).getLayoutParams()).f1197b);
        }
        this.f1188f = f2;
        boolean n2 = this.f1190h.n(true);
        boolean n3 = this.f1191i.n(true);
        if (n2 || n3) {
            u.d0(this);
        }
    }

    public void d(View view) {
        e(view, true);
    }

    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) == 0 || motionEvent.getAction() == 10 || this.f1188f <= Utils.FLOAT_EPSILON) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        int childCount = getChildCount();
        if (childCount == 0) {
            return false;
        }
        float x2 = motionEvent.getX();
        float y2 = motionEvent.getY();
        for (int i2 = childCount - 1; i2 >= 0; i2--) {
            View childAt = getChildAt(i2);
            if (D(x2, y2, childAt) && !z(childAt) && k(motionEvent, childAt)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j2) {
        int height = getHeight();
        boolean z2 = z(view);
        int width = getWidth();
        int save = canvas.save();
        int i2 = 0;
        if (z2) {
            int childCount = getChildCount();
            int i3 = 0;
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                if (childAt != view && childAt.getVisibility() == 0 && v(childAt) && B(childAt) && childAt.getHeight() >= height) {
                    if (c(childAt, 3)) {
                        int right = childAt.getRight();
                        if (right > i3) {
                            i3 = right;
                        }
                    } else {
                        int left = childAt.getLeft();
                        if (left < width) {
                            width = left;
                        }
                    }
                }
            }
            canvas.clipRect(i3, 0, width, getHeight());
            i2 = i3;
        }
        boolean drawChild = super.drawChild(canvas, view, j2);
        canvas.restoreToCount(save);
        float f2 = this.f1188f;
        if (f2 > Utils.FLOAT_EPSILON && z2) {
            int i5 = this.f1187e;
            this.f1189g.setColor((i5 & 16777215) | (((int) (((float) ((-16777216 & i5) >>> 24)) * f2)) << 24));
            canvas.drawRect((float) i2, Utils.FLOAT_EPSILON, (float) width, (float) getHeight(), this.f1189g);
        } else if (this.y != null && c(view, 3)) {
            int intrinsicWidth = this.y.getIntrinsicWidth();
            int right2 = view.getRight();
            float max = Math.max((float) Utils.FLOAT_EPSILON, Math.min(((float) right2) / ((float) this.f1190h.x()), 1.0f));
            this.y.setBounds(right2, view.getTop(), intrinsicWidth + right2, view.getBottom());
            this.y.setAlpha((int) (max * 255.0f));
            this.y.draw(canvas);
        } else if (this.z != null && c(view, 5)) {
            int intrinsicWidth2 = this.z.getIntrinsicWidth();
            int left2 = view.getLeft();
            float max2 = Math.max((float) Utils.FLOAT_EPSILON, Math.min(((float) (getWidth() - left2)) / ((float) this.f1191i.x()), 1.0f));
            this.z.setBounds(left2 - intrinsicWidth2, view.getTop(), left2, view.getBottom());
            this.z.setAlpha((int) (max2 * 255.0f));
            this.z.draw(canvas);
        }
        return drawChild;
    }

    public void e(View view, boolean z2) {
        if (B(view)) {
            e eVar = (e) view.getLayoutParams();
            if (this.n) {
                eVar.f1197b = Utils.FLOAT_EPSILON;
                eVar.f1199d = 0;
            } else if (z2) {
                eVar.f1199d |= 4;
                if (c(view, 3)) {
                    this.f1190h.P(view, -view.getWidth(), view.getTop());
                } else {
                    this.f1191i.P(view, getWidth(), view.getTop());
                }
            } else {
                F(view, Utils.FLOAT_EPSILON);
                Q(eVar.f1196a, 0, view);
                view.setVisibility(4);
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    public void f() {
        g(false);
    }

    /* access modifiers changed from: package-private */
    public void g(boolean z2) {
        boolean z3;
        int childCount = getChildCount();
        boolean z4 = false;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            e eVar = (e) childAt.getLayoutParams();
            if (B(childAt) && (!z2 || eVar.f1198c)) {
                int width = childAt.getWidth();
                if (c(childAt, 3)) {
                    z3 = this.f1190h.P(childAt, -width, childAt.getTop());
                } else {
                    z3 = this.f1191i.P(childAt, getWidth(), childAt.getTop());
                }
                z4 |= z3;
                eVar.f1198c = false;
            }
        }
        this.f1192j.p();
        this.f1193k.p();
        if (z4) {
            invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new e(-1, -1);
    }

    /* access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof e) {
            return new e((e) layoutParams);
        }
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new e((ViewGroup.MarginLayoutParams) layoutParams) : new e(layoutParams);
    }

    public float getDrawerElevation() {
        return O ? this.f1185c : Utils.FLOAT_EPSILON;
    }

    public Drawable getStatusBarBackgroundDrawable() {
        return this.x;
    }

    /* access modifiers changed from: package-private */
    public void h(View view) {
        View rootView;
        e eVar = (e) view.getLayoutParams();
        if ((eVar.f1199d & 1) == 1) {
            eVar.f1199d = 0;
            List<d> list = this.u;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.u.get(size).d(view);
                }
            }
            P(view, false);
            if (hasWindowFocus() && (rootView = getRootView()) != null) {
                rootView.sendAccessibilityEvent(32);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void i(View view) {
        e eVar = (e) view.getLayoutParams();
        if ((eVar.f1199d & 1) == 0) {
            eVar.f1199d = 1;
            List<d> list = this.u;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.u.get(size).c(view);
                }
            }
            P(view, true);
            if (hasWindowFocus()) {
                sendAccessibilityEvent(32);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void j(View view, float f2) {
        List<d> list = this.u;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.u.get(size).b(view, f2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public View l(int i2) {
        int b2 = b.h.k.e.b(i2, u.B(this)) & 7;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if ((r(childAt) & 7) == b2) {
                return childAt;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public View m() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((((e) childAt.getLayoutParams()).f1199d & 1) == 1) {
                return childAt;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public View n() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (B(childAt) && C(childAt)) {
                return childAt;
            }
        }
        return null;
    }

    public int o(int i2) {
        int B2 = u.B(this);
        if (i2 == 3) {
            int i3 = this.o;
            if (i3 != 3) {
                return i3;
            }
            int i4 = B2 == 0 ? this.q : this.r;
            if (i4 != 3) {
                return i4;
            }
            return 0;
        } else if (i2 == 5) {
            int i5 = this.p;
            if (i5 != 3) {
                return i5;
            }
            int i6 = B2 == 0 ? this.r : this.q;
            if (i6 != 3) {
                return i6;
            }
            return 0;
        } else if (i2 == 8388611) {
            int i7 = this.q;
            if (i7 != 3) {
                return i7;
            }
            int i8 = B2 == 0 ? this.o : this.p;
            if (i8 != 3) {
                return i8;
            }
            return 0;
        } else if (i2 != 8388613) {
            return 0;
        } else {
            int i9 = this.r;
            if (i9 != 3) {
                return i9;
            }
            int i10 = B2 == 0 ? this.p : this.o;
            if (i10 != 3) {
                return i10;
            }
            return 0;
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.n = true;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.n = true;
    }

    public void onDraw(Canvas canvas) {
        Object obj;
        super.onDraw(canvas);
        if (this.D && this.x != null) {
            int systemWindowInsetTop = (Build.VERSION.SDK_INT < 21 || (obj = this.C) == null) ? 0 : ((WindowInsets) obj).getSystemWindowInsetTop();
            if (systemWindowInsetTop > 0) {
                this.x.setBounds(0, 0, getWidth(), systemWindowInsetTop);
                this.x.draw(canvas);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001b, code lost:
        if (r0 != 3) goto L_0x0036;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r7) {
        /*
        // Method dump skipped, instructions count: 113
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 != 4 || !x()) {
            return super.onKeyDown(i2, keyEvent);
        }
        keyEvent.startTracking();
        return true;
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (i2 != 4) {
            return super.onKeyUp(i2, keyEvent);
        }
        View n2 = n();
        if (n2 != null && p(n2) == 0) {
            f();
        }
        return n2 != null;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        float f2;
        int i6;
        this.m = true;
        int i7 = i4 - i2;
        int childCount = getChildCount();
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                if (z(childAt)) {
                    int i9 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin;
                    childAt.layout(i9, ((ViewGroup.MarginLayoutParams) eVar).topMargin, childAt.getMeasuredWidth() + i9, ((ViewGroup.MarginLayoutParams) eVar).topMargin + childAt.getMeasuredHeight());
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (c(childAt, 3)) {
                        float f3 = (float) measuredWidth;
                        i6 = (-measuredWidth) + ((int) (eVar.f1197b * f3));
                        f2 = ((float) (measuredWidth + i6)) / f3;
                    } else {
                        float f4 = (float) measuredWidth;
                        int i10 = i7 - ((int) (eVar.f1197b * f4));
                        f2 = ((float) (i7 - i10)) / f4;
                        i6 = i10;
                    }
                    boolean z3 = f2 != eVar.f1197b;
                    int i11 = eVar.f1196a & 112;
                    if (i11 == 16) {
                        int i12 = i5 - i3;
                        int i13 = (i12 - measuredHeight) / 2;
                        int i14 = ((ViewGroup.MarginLayoutParams) eVar).topMargin;
                        if (i13 < i14) {
                            i13 = i14;
                        } else {
                            int i15 = i13 + measuredHeight;
                            int i16 = ((ViewGroup.MarginLayoutParams) eVar).bottomMargin;
                            if (i15 > i12 - i16) {
                                i13 = (i12 - i16) - measuredHeight;
                            }
                        }
                        childAt.layout(i6, i13, measuredWidth + i6, measuredHeight + i13);
                    } else if (i11 != 80) {
                        int i17 = ((ViewGroup.MarginLayoutParams) eVar).topMargin;
                        childAt.layout(i6, i17, measuredWidth + i6, measuredHeight + i17);
                    } else {
                        int i18 = i5 - i3;
                        childAt.layout(i6, (i18 - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + i6, i18 - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin);
                    }
                    if (z3) {
                        O(childAt, f2);
                    }
                    int i19 = eVar.f1197b > Utils.FLOAT_EPSILON ? 0 : 4;
                    if (childAt.getVisibility() != i19) {
                        childAt.setVisibility(i19);
                    }
                }
            }
        }
        this.m = false;
        this.n = false;
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"WrongConstant"})
    public void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        if (!(mode == 1073741824 && mode2 == 1073741824)) {
            if (isInEditMode()) {
                if (mode != Integer.MIN_VALUE && mode == 0) {
                    size = 300;
                }
                if (mode2 != Integer.MIN_VALUE && mode2 == 0) {
                    size2 = 300;
                }
            } else {
                throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
            }
        }
        setMeasuredDimension(size, size2);
        int i4 = 0;
        boolean z2 = this.C != null && u.y(this);
        int B2 = u.B(this);
        int childCount = getChildCount();
        int i5 = 0;
        boolean z3 = false;
        boolean z4 = false;
        while (i5 < childCount) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                if (z2) {
                    int b2 = b.h.k.e.b(eVar.f1196a, B2);
                    if (u.y(childAt)) {
                        if (Build.VERSION.SDK_INT >= 21) {
                            WindowInsets windowInsets = (WindowInsets) this.C;
                            if (b2 == 3) {
                                windowInsets = windowInsets.replaceSystemWindowInsets(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), i4, windowInsets.getSystemWindowInsetBottom());
                            } else if (b2 == 5) {
                                windowInsets = windowInsets.replaceSystemWindowInsets(i4, windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
                            }
                            childAt.dispatchApplyWindowInsets(windowInsets);
                        }
                    } else if (Build.VERSION.SDK_INT >= 21) {
                        WindowInsets windowInsets2 = (WindowInsets) this.C;
                        if (b2 == 3) {
                            windowInsets2 = windowInsets2.replaceSystemWindowInsets(windowInsets2.getSystemWindowInsetLeft(), windowInsets2.getSystemWindowInsetTop(), i4, windowInsets2.getSystemWindowInsetBottom());
                        } else if (b2 == 5) {
                            windowInsets2 = windowInsets2.replaceSystemWindowInsets(i4, windowInsets2.getSystemWindowInsetTop(), windowInsets2.getSystemWindowInsetRight(), windowInsets2.getSystemWindowInsetBottom());
                        }
                        ((ViewGroup.MarginLayoutParams) eVar).leftMargin = windowInsets2.getSystemWindowInsetLeft();
                        ((ViewGroup.MarginLayoutParams) eVar).topMargin = windowInsets2.getSystemWindowInsetTop();
                        ((ViewGroup.MarginLayoutParams) eVar).rightMargin = windowInsets2.getSystemWindowInsetRight();
                        ((ViewGroup.MarginLayoutParams) eVar).bottomMargin = windowInsets2.getSystemWindowInsetBottom();
                    }
                }
                if (z(childAt)) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec((size - ((ViewGroup.MarginLayoutParams) eVar).leftMargin) - ((ViewGroup.MarginLayoutParams) eVar).rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec((size2 - ((ViewGroup.MarginLayoutParams) eVar).topMargin) - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin, 1073741824));
                } else if (B(childAt)) {
                    if (O) {
                        float w2 = u.w(childAt);
                        float f2 = this.f1185c;
                        if (w2 != f2) {
                            u.u0(childAt, f2);
                        }
                    }
                    int r2 = r(childAt) & 7;
                    boolean z5 = r2 == 3;
                    if ((!z5 || !z3) && (z5 || !z4)) {
                        if (z5) {
                            z3 = true;
                        } else {
                            z4 = true;
                        }
                        childAt.measure(ViewGroup.getChildMeasureSpec(i2, this.f1186d + ((ViewGroup.MarginLayoutParams) eVar).leftMargin + ((ViewGroup.MarginLayoutParams) eVar).rightMargin, ((ViewGroup.MarginLayoutParams) eVar).width), ViewGroup.getChildMeasureSpec(i3, ((ViewGroup.MarginLayoutParams) eVar).topMargin + ((ViewGroup.MarginLayoutParams) eVar).bottomMargin, ((ViewGroup.MarginLayoutParams) eVar).height));
                        i5++;
                        i4 = 0;
                    } else {
                        throw new IllegalStateException("Child drawer has absolute gravity " + u(r2) + " but this " + "DrawerLayout" + " already has a " + "drawer view along that edge");
                    }
                } else {
                    throw new IllegalStateException("Child " + childAt + " at index " + i5 + " does not have a valid layout_gravity - must be Gravity.LEFT, " + "Gravity.RIGHT or Gravity.NO_GRAVITY");
                }
            }
            i5++;
            i4 = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        View l2;
        if (!(parcelable instanceof f)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        f fVar = (f) parcelable;
        super.onRestoreInstanceState(fVar.g());
        int i2 = fVar.f1200d;
        if (!(i2 == 0 || (l2 = l(i2)) == null)) {
            G(l2);
        }
        int i3 = fVar.f1201e;
        if (i3 != 3) {
            N(i3, 3);
        }
        int i4 = fVar.f1202f;
        if (i4 != 3) {
            N(i4, 5);
        }
        int i5 = fVar.f1203g;
        if (i5 != 3) {
            N(i5, 8388611);
        }
        int i6 = fVar.f1204h;
        if (i6 != 3) {
            N(i6, 8388613);
        }
    }

    public void onRtlPropertiesChanged(int i2) {
        L();
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        f fVar = new f(super.onSaveInstanceState());
        int childCount = getChildCount();
        int i2 = 0;
        while (true) {
            if (i2 >= childCount) {
                break;
            }
            e eVar = (e) getChildAt(i2).getLayoutParams();
            int i3 = eVar.f1199d;
            boolean z2 = true;
            boolean z3 = i3 == 1;
            if (i3 != 2) {
                z2 = false;
            }
            if (z3 || z2) {
                fVar.f1200d = eVar.f1196a;
            } else {
                i2++;
            }
        }
        fVar.f1201e = this.o;
        fVar.f1202f = this.p;
        fVar.f1203g = this.q;
        fVar.f1204h = this.r;
        return fVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x005b, code lost:
        if (p(r7) != 2) goto L_0x005e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
        // Method dump skipped, instructions count: 113
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public int p(View view) {
        if (B(view)) {
            return o(((e) view.getLayoutParams()).f1196a);
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public CharSequence q(int i2) {
        int b2 = b.h.k.e.b(i2, u.B(this));
        if (b2 == 3) {
            return this.A;
        }
        if (b2 == 5) {
            return this.B;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public int r(View view) {
        return b.h.k.e.b(((e) view.getLayoutParams()).f1196a, u.B(this));
    }

    public void requestDisallowInterceptTouchEvent(boolean z2) {
        super.requestDisallowInterceptTouchEvent(z2);
        if (z2) {
            g(true);
        }
    }

    public void requestLayout() {
        if (!this.m) {
            super.requestLayout();
        }
    }

    /* access modifiers changed from: package-private */
    public float s(View view) {
        return ((e) view.getLayoutParams()).f1197b;
    }

    public void setDrawerElevation(float f2) {
        this.f1185c = f2;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (B(childAt)) {
                u.u0(childAt, this.f1185c);
            }
        }
    }

    @Deprecated
    public void setDrawerListener(d dVar) {
        d dVar2 = this.t;
        if (dVar2 != null) {
            I(dVar2);
        }
        if (dVar != null) {
            a(dVar);
        }
        this.t = dVar;
    }

    public void setDrawerLockMode(int i2) {
        N(i2, 3);
        N(i2, 5);
    }

    public void setScrimColor(int i2) {
        this.f1187e = i2;
        invalidate();
    }

    public void setStatusBarBackground(Drawable drawable) {
        this.x = drawable;
        invalidate();
    }

    public void setStatusBarBackgroundColor(int i2) {
        this.x = new ColorDrawable(i2);
        invalidate();
    }

    /* access modifiers changed from: package-private */
    public boolean z(View view) {
        return ((e) view.getLayoutParams()).f1196a == 0;
    }

    public DrawerLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f1184b = new c();
        this.f1187e = -1728053248;
        this.f1189g = new Paint();
        this.n = true;
        this.o = 3;
        this.p = 3;
        this.q = 3;
        this.r = 3;
        this.E = null;
        this.F = null;
        this.G = null;
        this.H = null;
        setDescendantFocusability(262144);
        float f2 = getResources().getDisplayMetrics().density;
        this.f1186d = (int) ((64.0f * f2) + 0.5f);
        float f3 = 400.0f * f2;
        g gVar = new g(3);
        this.f1192j = gVar;
        g gVar2 = new g(5);
        this.f1193k = gVar2;
        b.j.b.c o2 = b.j.b.c.o(this, 1.0f, gVar);
        this.f1190h = o2;
        o2.L(1);
        o2.M(f3);
        gVar.q(o2);
        b.j.b.c o3 = b.j.b.c.o(this, 1.0f, gVar2);
        this.f1191i = o3;
        o3.L(2);
        o3.M(f3);
        gVar2.q(o3);
        setFocusableInTouchMode(true);
        u.x0(this, 1);
        u.m0(this, new b());
        setMotionEventSplittingEnabled(false);
        if (u.y(this)) {
            if (Build.VERSION.SDK_INT >= 21) {
                setOnApplyWindowInsetsListener(new a(this));
                setSystemUiVisibility(1280);
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(L);
                try {
                    this.x = obtainStyledAttributes.getDrawable(0);
                } finally {
                    obtainStyledAttributes.recycle();
                }
            } else {
                this.x = null;
            }
        }
        this.f1185c = f2 * 10.0f;
        this.I = new ArrayList<>();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    public void setStatusBarBackground(int i2) {
        this.x = i2 != 0 ? b.h.d.a.d(getContext(), i2) : null;
        invalidate();
    }

    public static class e extends ViewGroup.MarginLayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public int f1196a = 0;

        /* renamed from: b  reason: collision with root package name */
        float f1197b;

        /* renamed from: c  reason: collision with root package name */
        boolean f1198c;

        /* renamed from: d  reason: collision with root package name */
        int f1199d;

        public e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.M);
            this.f1196a = obtainStyledAttributes.getInt(0, 0);
            obtainStyledAttributes.recycle();
        }

        public e(int i2, int i3) {
            super(i2, i3);
        }

        public e(e eVar) {
            super((ViewGroup.MarginLayoutParams) eVar);
            this.f1196a = eVar.f1196a;
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public e(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    /* access modifiers changed from: protected */
    public static class f extends b.j.a.a {
        public static final Parcelable.Creator<f> CREATOR = new a();

        /* renamed from: d  reason: collision with root package name */
        int f1200d = 0;

        /* renamed from: e  reason: collision with root package name */
        int f1201e;

        /* renamed from: f  reason: collision with root package name */
        int f1202f;

        /* renamed from: g  reason: collision with root package name */
        int f1203g;

        /* renamed from: h  reason: collision with root package name */
        int f1204h;

        static class a implements Parcelable.ClassLoaderCreator<f> {
            a() {
            }

            /* renamed from: a */
            public f createFromParcel(Parcel parcel) {
                return new f(parcel, null);
            }

            /* renamed from: b */
            public f createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new f(parcel, classLoader);
            }

            /* renamed from: c */
            public f[] newArray(int i2) {
                return new f[i2];
            }
        }

        public f(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f1200d = parcel.readInt();
            this.f1201e = parcel.readInt();
            this.f1202f = parcel.readInt();
            this.f1203g = parcel.readInt();
            this.f1204h = parcel.readInt();
        }

        @Override // b.j.a.a
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f1200d);
            parcel.writeInt(this.f1201e);
            parcel.writeInt(this.f1202f);
            parcel.writeInt(this.f1203g);
            parcel.writeInt(this.f1204h);
        }

        public f(Parcelable parcelable) {
            super(parcelable);
        }
    }
}
