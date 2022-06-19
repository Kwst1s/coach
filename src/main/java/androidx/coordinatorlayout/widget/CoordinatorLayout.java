package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import b.h.k.c0;
import b.h.k.m;
import b.h.k.n;
import b.h.k.p;
import b.h.k.q;
import b.h.k.u;
import com.github.mikephil.charting.utils.Utils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoordinatorLayout extends ViewGroup implements m, n {
    static final String v;
    static final Class<?>[] w = {Context.class, AttributeSet.class};
    static final ThreadLocal<Map<String, Constructor<c>>> x = new ThreadLocal<>();
    static final Comparator<View> y;
    private static final b.h.j.e<Rect> z = new b.h.j.g(12);

    /* renamed from: b  reason: collision with root package name */
    private final List<View> f987b;

    /* renamed from: c  reason: collision with root package name */
    private final a<View> f988c;

    /* renamed from: d  reason: collision with root package name */
    private final List<View> f989d;

    /* renamed from: e  reason: collision with root package name */
    private final List<View> f990e;

    /* renamed from: f  reason: collision with root package name */
    private Paint f991f;

    /* renamed from: g  reason: collision with root package name */
    private final int[] f992g;

    /* renamed from: h  reason: collision with root package name */
    private final int[] f993h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f994i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f995j;

    /* renamed from: k  reason: collision with root package name */
    private int[] f996k;
    private View l;
    private View m;
    private g n;
    private boolean o;
    private c0 p;
    private boolean q;
    private Drawable r;
    ViewGroup.OnHierarchyChangeListener s;
    private q t;
    private final p u;

    /* access modifiers changed from: package-private */
    public class a implements q {
        a() {
        }

        @Override // b.h.k.q
        public c0 a(View view, c0 c0Var) {
            CoordinatorLayout.this.W(c0Var);
            return c0Var;
        }
    }

    public interface b {
        c getBehavior();
    }

    public static abstract class c<V extends View> {
        public c() {
        }

        public boolean A(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i2, int i3) {
            if (i3 == 0) {
                return z(coordinatorLayout, v, view, view2, i2);
            }
            return false;
        }

        @Deprecated
        public void B(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        public void C(CoordinatorLayout coordinatorLayout, V v, View view, int i2) {
            if (i2 == 0) {
                B(coordinatorLayout, v, view);
            }
        }

        public boolean D(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v) {
            return d(coordinatorLayout, v) > Utils.FLOAT_EPSILON;
        }

        public boolean b(CoordinatorLayout coordinatorLayout, V v, Rect rect) {
            return false;
        }

        public int c(CoordinatorLayout coordinatorLayout, V v) {
            return -16777216;
        }

        public float d(CoordinatorLayout coordinatorLayout, V v) {
            return Utils.FLOAT_EPSILON;
        }

        public boolean e(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        public c0 f(CoordinatorLayout coordinatorLayout, V v, c0 c0Var) {
            return c0Var;
        }

        public void g(f fVar) {
        }

        public boolean h(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        public void i(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        public void j() {
        }

        public boolean k(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public boolean l(CoordinatorLayout coordinatorLayout, V v, int i2) {
            return false;
        }

        public boolean m(CoordinatorLayout coordinatorLayout, V v, int i2, int i3, int i4, int i5) {
            return false;
        }

        public boolean n(CoordinatorLayout coordinatorLayout, V v, View view, float f2, float f3, boolean z) {
            return false;
        }

        public boolean o(CoordinatorLayout coordinatorLayout, V v, View view, float f2, float f3) {
            return false;
        }

        @Deprecated
        public void p(CoordinatorLayout coordinatorLayout, V v, View view, int i2, int i3, int[] iArr) {
        }

        public void q(CoordinatorLayout coordinatorLayout, V v, View view, int i2, int i3, int[] iArr, int i4) {
            if (i4 == 0) {
                p(coordinatorLayout, v, view, i2, i3, iArr);
            }
        }

        @Deprecated
        public void r(CoordinatorLayout coordinatorLayout, V v, View view, int i2, int i3, int i4, int i5) {
        }

        @Deprecated
        public void s(CoordinatorLayout coordinatorLayout, V v, View view, int i2, int i3, int i4, int i5, int i6) {
            if (i6 == 0) {
                r(coordinatorLayout, v, view, i2, i3, i4, i5);
            }
        }

        public void t(CoordinatorLayout coordinatorLayout, V v, View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
            iArr[0] = iArr[0] + i4;
            iArr[1] = iArr[1] + i5;
            s(coordinatorLayout, v, view, i2, i3, i4, i5, i6);
        }

        @Deprecated
        public void u(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i2) {
        }

        public void v(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i2, int i3) {
            if (i3 == 0) {
                u(coordinatorLayout, v, view, view2, i2);
            }
        }

        public boolean w(CoordinatorLayout coordinatorLayout, V v, Rect rect, boolean z) {
            return false;
        }

        public void x(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        }

        public Parcelable y(CoordinatorLayout coordinatorLayout, V v) {
            return View.BaseSavedState.EMPTY_STATE;
        }

        @Deprecated
        public boolean z(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i2) {
            return false;
        }

        public c(Context context, AttributeSet attributeSet) {
        }
    }

    @Deprecated
    @Retention(RetentionPolicy.RUNTIME)
    public @interface d {
        Class<? extends c> value();
    }

    private class e implements ViewGroup.OnHierarchyChangeListener {
        e() {
        }

        public void onChildViewAdded(View view, View view2) {
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.s;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        public void onChildViewRemoved(View view, View view2) {
            CoordinatorLayout.this.H(2);
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.s;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public class g implements ViewTreeObserver.OnPreDrawListener {
        g() {
        }

        public boolean onPreDraw() {
            CoordinatorLayout.this.H(0);
            return true;
        }
    }

    static class i implements Comparator<View> {
        i() {
        }

        /* renamed from: a */
        public int compare(View view, View view2) {
            float M = u.M(view);
            float M2 = u.M(view2);
            if (M > M2) {
                return -1;
            }
            return M < M2 ? 1 : 0;
        }
    }

    static {
        Package r0 = CoordinatorLayout.class.getPackage();
        v = r0 != null ? r0.getName() : null;
        if (Build.VERSION.SDK_INT >= 21) {
            y = new i();
        } else {
            y = null;
        }
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.g.a.coordinatorLayoutStyle);
    }

    private boolean A(View view) {
        return this.f988c.j(view);
    }

    private void C(View view, int i2) {
        f fVar = (f) view.getLayoutParams();
        Rect a2 = a();
        a2.set(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin, getPaddingTop() + ((ViewGroup.MarginLayoutParams) fVar).topMargin, (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin, (getHeight() - getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin);
        if (this.p != null && u.y(this) && !u.y(view)) {
            a2.left += this.p.g();
            a2.top += this.p.i();
            a2.right -= this.p.h();
            a2.bottom -= this.p.f();
        }
        Rect a3 = a();
        b.h.k.e.a(S(fVar.f1001c), view.getMeasuredWidth(), view.getMeasuredHeight(), a2, a3, i2);
        view.layout(a3.left, a3.top, a3.right, a3.bottom);
        O(a2);
        O(a3);
    }

    private void D(View view, View view2, int i2) {
        Rect a2 = a();
        Rect a3 = a();
        try {
            t(view2, a2);
            u(view, i2, a2, a3);
            view.layout(a3.left, a3.top, a3.right, a3.bottom);
        } finally {
            O(a2);
            O(a3);
        }
    }

    private void E(View view, int i2, int i3) {
        f fVar = (f) view.getLayoutParams();
        int b2 = b.h.k.e.b(T(fVar.f1001c), i3);
        int i4 = b2 & 7;
        int i5 = b2 & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (i3 == 1) {
            i2 = width - i2;
        }
        int w2 = w(i2) - measuredWidth;
        int i6 = 0;
        if (i4 == 1) {
            w2 += measuredWidth / 2;
        } else if (i4 == 5) {
            w2 += measuredWidth;
        }
        if (i5 == 16) {
            i6 = 0 + (measuredHeight / 2);
        } else if (i5 == 80) {
            i6 = measuredHeight + 0;
        }
        int max = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin, Math.min(w2, ((width - getPaddingRight()) - measuredWidth) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin));
        int max2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) fVar).topMargin, Math.min(i6, ((height - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin));
        view.layout(max, max2, measuredWidth + max, measuredHeight + max2);
    }

    private void F(View view, Rect rect, int i2) {
        boolean z2;
        boolean z3;
        int width;
        int i3;
        int i4;
        int i5;
        int height;
        int i6;
        int i7;
        int i8;
        if (u.S(view) && view.getWidth() > 0 && view.getHeight() > 0) {
            f fVar = (f) view.getLayoutParams();
            c f2 = fVar.f();
            Rect a2 = a();
            Rect a3 = a();
            a3.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            if (f2 == null || !f2.b(this, view, a2)) {
                a2.set(a3);
            } else if (!a3.contains(a2)) {
                throw new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + a2.toShortString() + " | Bounds:" + a3.toShortString());
            }
            O(a3);
            if (a2.isEmpty()) {
                O(a2);
                return;
            }
            int b2 = b.h.k.e.b(fVar.f1006h, i2);
            boolean z4 = true;
            if ((b2 & 48) != 48 || (i7 = (a2.top - ((ViewGroup.MarginLayoutParams) fVar).topMargin) - fVar.f1008j) >= (i8 = rect.top)) {
                z2 = false;
            } else {
                V(view, i8 - i7);
                z2 = true;
            }
            if ((b2 & 80) == 80 && (height = ((getHeight() - a2.bottom) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin) + fVar.f1008j) < (i6 = rect.bottom)) {
                V(view, height - i6);
                z2 = true;
            }
            if (!z2) {
                V(view, 0);
            }
            if ((b2 & 3) != 3 || (i4 = (a2.left - ((ViewGroup.MarginLayoutParams) fVar).leftMargin) - fVar.f1007i) >= (i5 = rect.left)) {
                z3 = false;
            } else {
                U(view, i5 - i4);
                z3 = true;
            }
            if ((b2 & 5) != 5 || (width = ((getWidth() - a2.right) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin) + fVar.f1007i) >= (i3 = rect.right)) {
                z4 = z3;
            } else {
                U(view, width - i3);
            }
            if (!z4) {
                U(view, 0);
            }
            O(a2);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v9, resolved type: java.lang.Class<?> */
    /* JADX WARN: Multi-variable type inference failed */
    static c K(Context context, AttributeSet attributeSet, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(".")) {
            str = context.getPackageName() + str;
        } else if (str.indexOf(46) < 0) {
            String str2 = v;
            if (!TextUtils.isEmpty(str2)) {
                str = str2 + '.' + str;
            }
        }
        try {
            ThreadLocal<Map<String, Constructor<c>>> threadLocal = x;
            Map<String, Constructor<c>> map = threadLocal.get();
            if (map == null) {
                map = new HashMap<>();
                threadLocal.set(map);
            }
            Constructor<c> constructor = map.get(str);
            if (constructor == null) {
                constructor = Class.forName(str, false, context.getClassLoader()).getConstructor(w);
                constructor.setAccessible(true);
                map.put(str, constructor);
            }
            return constructor.newInstance(context, attributeSet);
        } catch (Exception e2) {
            throw new RuntimeException("Could not inflate Behavior subclass " + str, e2);
        }
    }

    private boolean L(MotionEvent motionEvent, int i2) {
        int actionMasked = motionEvent.getActionMasked();
        List<View> list = this.f989d;
        z(list);
        int size = list.size();
        MotionEvent motionEvent2 = null;
        boolean z2 = false;
        boolean z3 = false;
        for (int i3 = 0; i3 < size; i3++) {
            View view = list.get(i3);
            f fVar = (f) view.getLayoutParams();
            c f2 = fVar.f();
            if (!(z2 || z3) || actionMasked == 0) {
                if (!z2 && f2 != null) {
                    if (i2 == 0) {
                        z2 = f2.k(this, view, motionEvent);
                    } else if (i2 == 1) {
                        z2 = f2.D(this, view, motionEvent);
                    }
                    if (z2) {
                        this.l = view;
                    }
                }
                boolean c2 = fVar.c();
                boolean i4 = fVar.i(this, view);
                z3 = i4 && !c2;
                if (i4 && !z3) {
                    break;
                }
            } else if (f2 != null) {
                if (motionEvent2 == null) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    motionEvent2 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, Utils.FLOAT_EPSILON, Utils.FLOAT_EPSILON, 0);
                }
                if (i2 == 0) {
                    f2.k(this, view, motionEvent2);
                } else if (i2 == 1) {
                    f2.D(this, view, motionEvent2);
                }
            }
        }
        list.clear();
        return z2;
    }

    private void M() {
        this.f987b.clear();
        this.f988c.c();
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            f y2 = y(childAt);
            y2.d(this, childAt);
            this.f988c.b(childAt);
            for (int i3 = 0; i3 < childCount; i3++) {
                if (i3 != i2) {
                    View childAt2 = getChildAt(i3);
                    if (y2.b(this, childAt, childAt2)) {
                        if (!this.f988c.d(childAt2)) {
                            this.f988c.b(childAt2);
                        }
                        this.f988c.a(childAt2, childAt);
                    }
                }
            }
        }
        this.f987b.addAll(this.f988c.i());
        Collections.reverse(this.f987b);
    }

    private static void O(Rect rect) {
        rect.setEmpty();
        z.a(rect);
    }

    private void Q(boolean z2) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            c f2 = ((f) childAt.getLayoutParams()).f();
            if (f2 != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, Utils.FLOAT_EPSILON, Utils.FLOAT_EPSILON, 0);
                if (z2) {
                    f2.k(this, childAt, obtain);
                } else {
                    f2.D(this, childAt, obtain);
                }
                obtain.recycle();
            }
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            ((f) getChildAt(i3).getLayoutParams()).m();
        }
        this.l = null;
        this.f994i = false;
    }

    private static int R(int i2) {
        if (i2 == 0) {
            return 17;
        }
        return i2;
    }

    private static int S(int i2) {
        if ((i2 & 7) == 0) {
            i2 |= 8388611;
        }
        return (i2 & 112) == 0 ? i2 | 48 : i2;
    }

    private static int T(int i2) {
        if (i2 == 0) {
            return 8388661;
        }
        return i2;
    }

    private void U(View view, int i2) {
        f fVar = (f) view.getLayoutParams();
        int i3 = fVar.f1007i;
        if (i3 != i2) {
            u.X(view, i2 - i3);
            fVar.f1007i = i2;
        }
    }

    private void V(View view, int i2) {
        f fVar = (f) view.getLayoutParams();
        int i3 = fVar.f1008j;
        if (i3 != i2) {
            u.Y(view, i2 - i3);
            fVar.f1008j = i2;
        }
    }

    private void X() {
        if (Build.VERSION.SDK_INT >= 21) {
            if (u.y(this)) {
                if (this.t == null) {
                    this.t = new a();
                }
                u.z0(this, this.t);
                setSystemUiVisibility(1280);
                return;
            }
            u.z0(this, null);
        }
    }

    private static Rect a() {
        Rect b2 = z.b();
        return b2 == null ? new Rect() : b2;
    }

    private static int c(int i2, int i3, int i4) {
        return i2 < i3 ? i3 : i2 > i4 ? i4 : i2;
    }

    private void d(f fVar, Rect rect, int i2, int i3) {
        int width = getWidth();
        int height = getHeight();
        int max = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i2) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin));
        int max2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) fVar).topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i3) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin));
        rect.set(max, max2, i2 + max, i3 + max2);
    }

    private c0 e(c0 c0Var) {
        c f2;
        if (c0Var.l()) {
            return c0Var;
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (u.y(childAt) && (f2 = ((f) childAt.getLayoutParams()).f()) != null) {
                f2.f(this, childAt, c0Var);
                if (c0Var.l()) {
                    break;
                }
            }
        }
        return c0Var;
    }

    private void v(View view, int i2, Rect rect, Rect rect2, f fVar, int i3, int i4) {
        int i5;
        int i6;
        int b2 = b.h.k.e.b(R(fVar.f1001c), i2);
        int b3 = b.h.k.e.b(S(fVar.f1002d), i2);
        int i7 = b2 & 7;
        int i8 = b2 & 112;
        int i9 = b3 & 7;
        int i10 = b3 & 112;
        if (i9 == 1) {
            i5 = rect.left + (rect.width() / 2);
        } else if (i9 != 5) {
            i5 = rect.left;
        } else {
            i5 = rect.right;
        }
        if (i10 == 16) {
            i6 = rect.top + (rect.height() / 2);
        } else if (i10 != 80) {
            i6 = rect.top;
        } else {
            i6 = rect.bottom;
        }
        if (i7 == 1) {
            i5 -= i3 / 2;
        } else if (i7 != 5) {
            i5 -= i3;
        }
        if (i8 == 16) {
            i6 -= i4 / 2;
        } else if (i8 != 80) {
            i6 -= i4;
        }
        rect2.set(i5, i6, i3 + i5, i4 + i6);
    }

    private int w(int i2) {
        int[] iArr = this.f996k;
        if (iArr == null) {
            Log.e("CoordinatorLayout", "No keylines defined for " + this + " - attempted index lookup " + i2);
            return 0;
        } else if (i2 >= 0 && i2 < iArr.length) {
            return iArr[i2];
        } else {
            Log.e("CoordinatorLayout", "Keyline index " + i2 + " out of range for " + this);
            return 0;
        }
    }

    private void z(List<View> list) {
        list.clear();
        boolean isChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i2 = childCount - 1; i2 >= 0; i2--) {
            list.add(getChildAt(isChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i2) : i2));
        }
        Comparator<View> comparator = y;
        if (comparator != null) {
            Collections.sort(list, comparator);
        }
    }

    public boolean B(View view, int i2, int i3) {
        Rect a2 = a();
        t(view, a2);
        try {
            return a2.contains(i2, i3);
        } finally {
            O(a2);
        }
    }

    /* access modifiers changed from: package-private */
    public void G(View view, int i2) {
        c f2;
        f fVar = (f) view.getLayoutParams();
        if (fVar.f1009k != null) {
            Rect a2 = a();
            Rect a3 = a();
            Rect a4 = a();
            t(fVar.f1009k, a2);
            boolean z2 = false;
            q(view, false, a3);
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            v(view, i2, a2, a4, fVar, measuredWidth, measuredHeight);
            if (!(a4.left == a3.left && a4.top == a3.top)) {
                z2 = true;
            }
            d(fVar, a4, measuredWidth, measuredHeight);
            int i3 = a4.left - a3.left;
            int i4 = a4.top - a3.top;
            if (i3 != 0) {
                u.X(view, i3);
            }
            if (i4 != 0) {
                u.Y(view, i4);
            }
            if (z2 && (f2 = fVar.f()) != null) {
                f2.h(this, view, fVar.f1009k);
            }
            O(a2);
            O(a3);
            O(a4);
        }
    }

    /* access modifiers changed from: package-private */
    public final void H(int i2) {
        boolean z2;
        int B = u.B(this);
        int size = this.f987b.size();
        Rect a2 = a();
        Rect a3 = a();
        Rect a4 = a();
        for (int i3 = 0; i3 < size; i3++) {
            View view = this.f987b.get(i3);
            f fVar = (f) view.getLayoutParams();
            if (i2 != 0 || view.getVisibility() != 8) {
                for (int i4 = 0; i4 < i3; i4++) {
                    if (fVar.l == this.f987b.get(i4)) {
                        G(view, B);
                    }
                }
                q(view, true, a3);
                if (fVar.f1005g != 0 && !a3.isEmpty()) {
                    int b2 = b.h.k.e.b(fVar.f1005g, B);
                    int i5 = b2 & 112;
                    if (i5 == 48) {
                        a2.top = Math.max(a2.top, a3.bottom);
                    } else if (i5 == 80) {
                        a2.bottom = Math.max(a2.bottom, getHeight() - a3.top);
                    }
                    int i6 = b2 & 7;
                    if (i6 == 3) {
                        a2.left = Math.max(a2.left, a3.right);
                    } else if (i6 == 5) {
                        a2.right = Math.max(a2.right, getWidth() - a3.left);
                    }
                }
                if (fVar.f1006h != 0 && view.getVisibility() == 0) {
                    F(view, a2, B);
                }
                if (i2 != 2) {
                    x(view, a4);
                    if (!a4.equals(a3)) {
                        N(view, a3);
                    }
                }
                for (int i7 = i3 + 1; i7 < size; i7++) {
                    View view2 = this.f987b.get(i7);
                    f fVar2 = (f) view2.getLayoutParams();
                    c f2 = fVar2.f();
                    if (f2 != null && f2.e(this, view2, view)) {
                        if (i2 != 0 || !fVar2.g()) {
                            if (i2 != 2) {
                                z2 = f2.h(this, view2, view);
                            } else {
                                f2.i(this, view2, view);
                                z2 = true;
                            }
                            if (i2 == 1) {
                                fVar2.p(z2);
                            }
                        } else {
                            fVar2.k();
                        }
                    }
                }
            }
        }
        O(a2);
        O(a3);
        O(a4);
    }

    public void I(View view, int i2) {
        f fVar = (f) view.getLayoutParams();
        if (!fVar.a()) {
            View view2 = fVar.f1009k;
            if (view2 != null) {
                D(view, view2, i2);
                return;
            }
            int i3 = fVar.f1003e;
            if (i3 >= 0) {
                E(view, i3, i2);
            } else {
                C(view, i2);
            }
        } else {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        }
    }

    public void J(View view, int i2, int i3, int i4, int i5) {
        measureChildWithMargins(view, i2, i3, i4, i5);
    }

    /* access modifiers changed from: package-private */
    public void N(View view, Rect rect) {
        ((f) view.getLayoutParams()).q(rect);
    }

    /* access modifiers changed from: package-private */
    public void P() {
        if (this.f995j && this.n != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.n);
        }
        this.o = false;
    }

    /* access modifiers changed from: package-private */
    public final c0 W(c0 c0Var) {
        if (!b.h.j.c.a(this.p, c0Var)) {
            this.p = c0Var;
            boolean z2 = true;
            boolean z3 = c0Var != null && c0Var.i() > 0;
            this.q = z3;
            if (z3 || getBackground() != null) {
                z2 = false;
            }
            setWillNotDraw(z2);
            e(c0Var);
            requestLayout();
        }
        return c0Var;
    }

    /* access modifiers changed from: package-private */
    public void b() {
        if (this.f995j) {
            if (this.n == null) {
                this.n = new g();
            }
            getViewTreeObserver().addOnPreDrawListener(this.n);
        }
        this.o = true;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof f) && super.checkLayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j2) {
        f fVar = (f) view.getLayoutParams();
        c cVar = fVar.f999a;
        if (cVar != null) {
            float d2 = cVar.d(this, view);
            if (d2 > Utils.FLOAT_EPSILON) {
                if (this.f991f == null) {
                    this.f991f = new Paint();
                }
                this.f991f.setColor(fVar.f999a.c(this, view));
                this.f991f.setAlpha(c(Math.round(d2 * 255.0f), 0, 255));
                int save = canvas.save();
                if (view.isOpaque()) {
                    canvas.clipRect((float) view.getLeft(), (float) view.getTop(), (float) view.getRight(), (float) view.getBottom(), Region.Op.DIFFERENCE);
                }
                canvas.drawRect((float) getPaddingLeft(), (float) getPaddingTop(), (float) (getWidth() - getPaddingRight()), (float) (getHeight() - getPaddingBottom()), this.f991f);
                canvas.restoreToCount(save);
            }
        }
        return super.drawChild(canvas, view, j2);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.r;
        boolean z2 = false;
        if (drawable != null && drawable.isStateful()) {
            z2 = false | drawable.setState(drawableState);
        }
        if (z2) {
            invalidate();
        }
    }

    public void f(View view) {
        List g2 = this.f988c.g(view);
        if (!(g2 == null || g2.isEmpty())) {
            for (int i2 = 0; i2 < g2.size(); i2++) {
                View view2 = (View) g2.get(i2);
                c f2 = ((f) view2.getLayoutParams()).f();
                if (f2 != null) {
                    f2.h(this, view2, view);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void g() {
        int childCount = getChildCount();
        boolean z2 = false;
        int i2 = 0;
        while (true) {
            if (i2 >= childCount) {
                break;
            } else if (A(getChildAt(i2))) {
                z2 = true;
                break;
            } else {
                i2++;
            }
        }
        if (z2 == this.o) {
            return;
        }
        if (z2) {
            b();
        } else {
            P();
        }
    }

    /* access modifiers changed from: package-private */
    public final List<View> getDependencySortedChildren() {
        M();
        return Collections.unmodifiableList(this.f987b);
    }

    public final c0 getLastWindowInsets() {
        return this.p;
    }

    public int getNestedScrollAxes() {
        return this.u.a();
    }

    public Drawable getStatusBarBackground() {
        return this.r;
    }

    /* access modifiers changed from: protected */
    public int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    /* access modifiers changed from: protected */
    public int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    @Override // b.h.k.m
    public void h(View view, View view2, int i2, int i3) {
        c f2;
        this.u.c(view, view2, i2, i3);
        this.m = view2;
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            f fVar = (f) childAt.getLayoutParams();
            if (fVar.j(i3) && (f2 = fVar.f()) != null) {
                f2.v(this, childAt, view, view2, i2, i3);
            }
        }
    }

    @Override // b.h.k.m
    public void i(View view, int i2) {
        this.u.d(view, i2);
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            f fVar = (f) childAt.getLayoutParams();
            if (fVar.j(i2)) {
                c f2 = fVar.f();
                if (f2 != null) {
                    f2.C(this, childAt, view, i2);
                }
                fVar.l(i2);
                fVar.k();
            }
        }
        this.m = null;
    }

    @Override // b.h.k.m
    public void j(View view, int i2, int i3, int[] iArr, int i4) {
        c f2;
        int i5;
        int i6;
        int childCount = getChildCount();
        boolean z2 = false;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.j(i4) && (f2 = fVar.f()) != null) {
                    int[] iArr2 = this.f992g;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    f2.q(this, childAt, view, i2, i3, iArr2, i4);
                    int[] iArr3 = this.f992g;
                    if (i2 > 0) {
                        i5 = Math.max(i7, iArr3[0]);
                    } else {
                        i5 = Math.min(i7, iArr3[0]);
                    }
                    i7 = i5;
                    int[] iArr4 = this.f992g;
                    if (i3 > 0) {
                        i6 = Math.max(i8, iArr4[1]);
                    } else {
                        i6 = Math.min(i8, iArr4[1]);
                    }
                    i8 = i6;
                    z2 = true;
                }
            }
        }
        iArr[0] = i7;
        iArr[1] = i8;
        if (z2) {
            H(1);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public f generateDefaultLayoutParams() {
        return new f(-2, -2);
    }

    /* renamed from: l */
    public f generateLayoutParams(AttributeSet attributeSet) {
        return new f(getContext(), attributeSet);
    }

    @Override // b.h.k.n
    public void m(View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
        c f2;
        int i7;
        int i8;
        int childCount = getChildCount();
        boolean z2 = false;
        int i9 = 0;
        int i10 = 0;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.j(i6) && (f2 = fVar.f()) != null) {
                    int[] iArr2 = this.f992g;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    f2.t(this, childAt, view, i2, i3, i4, i5, i6, iArr2);
                    int[] iArr3 = this.f992g;
                    if (i4 > 0) {
                        i7 = Math.max(i9, iArr3[0]);
                    } else {
                        i7 = Math.min(i9, iArr3[0]);
                    }
                    i9 = i7;
                    if (i5 > 0) {
                        i8 = Math.max(i10, this.f992g[1]);
                    } else {
                        i8 = Math.min(i10, this.f992g[1]);
                    }
                    i10 = i8;
                    z2 = true;
                }
            }
        }
        iArr[0] = iArr[0] + i9;
        iArr[1] = iArr[1] + i10;
        if (z2) {
            H(1);
        }
    }

    @Override // b.h.k.m
    public void n(View view, int i2, int i3, int i4, int i5, int i6) {
        m(view, i2, i3, i4, i5, 0, this.f993h);
    }

    @Override // b.h.k.m
    public boolean o(View view, View view2, int i2, int i3) {
        int childCount = getChildCount();
        boolean z2 = false;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                c f2 = fVar.f();
                if (f2 != null) {
                    boolean A = f2.A(this, childAt, view, view2, i2, i3);
                    z2 |= A;
                    fVar.r(i3, A);
                } else {
                    fVar.r(i3, false);
                }
            }
        }
        return z2;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Q(false);
        if (this.o) {
            if (this.n == null) {
                this.n = new g();
            }
            getViewTreeObserver().addOnPreDrawListener(this.n);
        }
        if (this.p == null && u.y(this)) {
            u.j0(this);
        }
        this.f995j = true;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Q(false);
        if (this.o && this.n != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.n);
        }
        View view = this.m;
        if (view != null) {
            onStopNestedScroll(view);
        }
        this.f995j = false;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.q && this.r != null) {
            c0 c0Var = this.p;
            int i2 = c0Var != null ? c0Var.i() : 0;
            if (i2 > 0) {
                this.r.setBounds(0, 0, getWidth(), i2);
                this.r.draw(canvas);
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            Q(true);
        }
        boolean L = L(motionEvent, 0);
        if (actionMasked == 1 || actionMasked == 3) {
            Q(true);
        }
        return L;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        c f2;
        int B = u.B(this);
        int size = this.f987b.size();
        for (int i6 = 0; i6 < size; i6++) {
            View view = this.f987b.get(i6);
            if (view.getVisibility() != 8 && ((f2 = ((f) view.getLayoutParams()).f()) == null || !f2.l(this, view, B))) {
                I(view, B);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x011a, code lost:
        if (r0.m(r30, r20, r11, r21, r23, 0) == false) goto L_0x012a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x011d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r31, int r32) {
        /*
        // Method dump skipped, instructions count: 391
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onMeasure(int, int):void");
    }

    @Override // b.h.k.o
    public boolean onNestedFling(View view, float f2, float f3, boolean z2) {
        c f4;
        int childCount = getChildCount();
        boolean z3 = false;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.j(0) && (f4 = fVar.f()) != null) {
                    z3 |= f4.n(this, childAt, view, f2, f3, z2);
                }
            }
        }
        if (z3) {
            H(1);
        }
        return z3;
    }

    @Override // b.h.k.o
    public boolean onNestedPreFling(View view, float f2, float f3) {
        c f4;
        int childCount = getChildCount();
        boolean z2 = false;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.j(0) && (f4 = fVar.f()) != null) {
                    z2 |= f4.o(this, childAt, view, f2, f3);
                }
            }
        }
        return z2;
    }

    @Override // b.h.k.o
    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
        j(view, i2, i3, iArr, 0);
    }

    @Override // b.h.k.o
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        n(view, i2, i3, i4, i5, 0);
    }

    @Override // b.h.k.o
    public void onNestedScrollAccepted(View view, View view2, int i2) {
        h(view, view2, i2, 0);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof h)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        h hVar = (h) parcelable;
        super.onRestoreInstanceState(hVar.g());
        SparseArray<Parcelable> sparseArray = hVar.f1011d;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            int id = childAt.getId();
            c f2 = y(childAt).f();
            if (!(id == -1 || f2 == null || (parcelable2 = sparseArray.get(id)) == null)) {
                f2.x(this, childAt, parcelable2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Parcelable y2;
        h hVar = new h(super.onSaveInstanceState());
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            int id = childAt.getId();
            c f2 = ((f) childAt.getLayoutParams()).f();
            if (!(id == -1 || f2 == null || (y2 = f2.y(this, childAt)) == null)) {
                sparseArray.append(id, y2);
            }
        }
        hVar.f1011d = sparseArray;
        return hVar;
    }

    @Override // b.h.k.o
    public boolean onStartNestedScroll(View view, View view2, int i2) {
        return o(view, view2, i2, 0);
    }

    @Override // b.h.k.o
    public void onStopNestedScroll(View view) {
        i(view, 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0012, code lost:
        if (r3 != false) goto L_0x0016;
     */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            int r2 = r18.getActionMasked()
            android.view.View r3 = r0.l
            r4 = 1
            r5 = 0
            if (r3 != 0) goto L_0x0015
            boolean r3 = r0.L(r1, r4)
            if (r3 == 0) goto L_0x002b
            goto L_0x0016
        L_0x0015:
            r3 = 0
        L_0x0016:
            android.view.View r6 = r0.l
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            androidx.coordinatorlayout.widget.CoordinatorLayout$f r6 = (androidx.coordinatorlayout.widget.CoordinatorLayout.f) r6
            androidx.coordinatorlayout.widget.CoordinatorLayout$c r6 = r6.f()
            if (r6 == 0) goto L_0x002b
            android.view.View r7 = r0.l
            boolean r6 = r6.D(r0, r7, r1)
            goto L_0x002c
        L_0x002b:
            r6 = 0
        L_0x002c:
            android.view.View r7 = r0.l
            r8 = 0
            if (r7 != 0) goto L_0x0037
            boolean r1 = super.onTouchEvent(r18)
            r6 = r6 | r1
            goto L_0x004a
        L_0x0037:
            if (r3 == 0) goto L_0x004a
            long r11 = android.os.SystemClock.uptimeMillis()
            r13 = 3
            r14 = 0
            r15 = 0
            r16 = 0
            r9 = r11
            android.view.MotionEvent r8 = android.view.MotionEvent.obtain(r9, r11, r13, r14, r15, r16)
            super.onTouchEvent(r8)
        L_0x004a:
            if (r8 == 0) goto L_0x004f
            r8.recycle()
        L_0x004f:
            if (r2 == r4) goto L_0x0054
            r1 = 3
            if (r2 != r1) goto L_0x0057
        L_0x0054:
            r0.Q(r5)
        L_0x0057:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* access modifiers changed from: protected */
    /* renamed from: p */
    public f generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof f) {
            return new f((f) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new f((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new f(layoutParams);
    }

    /* access modifiers changed from: package-private */
    public void q(View view, boolean z2, Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z2) {
            t(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    public List<View> r(View view) {
        List<View> h2 = this.f988c.h(view);
        this.f990e.clear();
        if (h2 != null) {
            this.f990e.addAll(h2);
        }
        return this.f990e;
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z2) {
        c f2 = ((f) view.getLayoutParams()).f();
        if (f2 == null || !f2.w(this, view, rect, z2)) {
            return super.requestChildRectangleOnScreen(view, rect, z2);
        }
        return true;
    }

    public void requestDisallowInterceptTouchEvent(boolean z2) {
        super.requestDisallowInterceptTouchEvent(z2);
        if (z2 && !this.f994i) {
            Q(false);
            this.f994i = true;
        }
    }

    public List<View> s(View view) {
        List g2 = this.f988c.g(view);
        this.f990e.clear();
        if (g2 != null) {
            this.f990e.addAll(g2);
        }
        return this.f990e;
    }

    public void setFitsSystemWindows(boolean z2) {
        super.setFitsSystemWindows(z2);
        X();
    }

    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.s = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(Drawable drawable) {
        Drawable drawable2 = this.r;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.r = drawable3;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.r.setState(getDrawableState());
                }
                androidx.core.graphics.drawable.a.m(this.r, u.B(this));
                this.r.setVisible(getVisibility() == 0, false);
                this.r.setCallback(this);
            }
            u.d0(this);
        }
    }

    public void setStatusBarBackgroundColor(int i2) {
        setStatusBarBackground(new ColorDrawable(i2));
    }

    public void setStatusBarBackgroundResource(int i2) {
        setStatusBarBackground(i2 != 0 ? b.h.d.a.d(getContext(), i2) : null);
    }

    public void setVisibility(int i2) {
        super.setVisibility(i2);
        boolean z2 = i2 == 0;
        Drawable drawable = this.r;
        if (drawable != null && drawable.isVisible() != z2) {
            this.r.setVisible(z2, false);
        }
    }

    /* access modifiers changed from: package-private */
    public void t(View view, Rect rect) {
        b.a(this, view, rect);
    }

    /* access modifiers changed from: package-private */
    public void u(View view, int i2, Rect rect, Rect rect2) {
        f fVar = (f) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        v(view, i2, rect, rect2, fVar, measuredWidth, measuredHeight);
        d(fVar, rect2, measuredWidth, measuredHeight);
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.r;
    }

    /* access modifiers changed from: package-private */
    public void x(View view, Rect rect) {
        rect.set(((f) view.getLayoutParams()).h());
    }

    /* access modifiers changed from: package-private */
    public f y(View view) {
        f fVar = (f) view.getLayoutParams();
        if (!fVar.f1000b) {
            if (view instanceof b) {
                c behavior = ((b) view).getBehavior();
                if (behavior == null) {
                    Log.e("CoordinatorLayout", "Attached behavior class is null");
                }
                fVar.o(behavior);
                fVar.f1000b = true;
            } else {
                d dVar = null;
                for (Class<?> cls = view.getClass(); cls != null; cls = cls.getSuperclass()) {
                    dVar = (d) cls.getAnnotation(d.class);
                    if (dVar != null) {
                        break;
                    }
                }
                if (dVar != null) {
                    try {
                        fVar.o((c) dVar.value().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                    } catch (Exception e2) {
                        Log.e("CoordinatorLayout", "Default behavior class " + dVar.value().getName() + " could not be instantiated. Did you forget a default constructor?", e2);
                    }
                }
                fVar.f1000b = true;
            }
        }
        return fVar;
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        TypedArray typedArray;
        this.f987b = new ArrayList();
        this.f988c = new a<>();
        this.f989d = new ArrayList();
        this.f990e = new ArrayList();
        this.f992g = new int[2];
        this.f993h = new int[2];
        this.u = new p(this);
        if (i2 == 0) {
            typedArray = context.obtainStyledAttributes(attributeSet, b.g.c.f2419a, 0, b.g.b.Widget_Support_CoordinatorLayout);
        } else {
            typedArray = context.obtainStyledAttributes(attributeSet, b.g.c.f2419a, i2, 0);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            if (i2 == 0) {
                saveAttributeDataForStyleable(context, b.g.c.f2419a, attributeSet, typedArray, 0, b.g.b.Widget_Support_CoordinatorLayout);
            } else {
                saveAttributeDataForStyleable(context, b.g.c.f2419a, attributeSet, typedArray, i2, 0);
            }
        }
        int resourceId = typedArray.getResourceId(b.g.c.f2420b, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            this.f996k = resources.getIntArray(resourceId);
            float f2 = resources.getDisplayMetrics().density;
            int length = this.f996k.length;
            for (int i3 = 0; i3 < length; i3++) {
                int[] iArr = this.f996k;
                iArr[i3] = (int) (((float) iArr[i3]) * f2);
            }
        }
        this.r = typedArray.getDrawable(b.g.c.f2421c);
        typedArray.recycle();
        X();
        super.setOnHierarchyChangeListener(new e());
        if (u.z(this) == 0) {
            u.x0(this, 1);
        }
    }

    /* access modifiers changed from: protected */
    public static class h extends b.j.a.a {
        public static final Parcelable.Creator<h> CREATOR = new a();

        /* renamed from: d  reason: collision with root package name */
        SparseArray<Parcelable> f1011d;

        static class a implements Parcelable.ClassLoaderCreator<h> {
            a() {
            }

            /* renamed from: a */
            public h createFromParcel(Parcel parcel) {
                return new h(parcel, null);
            }

            /* renamed from: b */
            public h createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new h(parcel, classLoader);
            }

            /* renamed from: c */
            public h[] newArray(int i2) {
                return new h[i2];
            }
        }

        public h(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int readInt = parcel.readInt();
            int[] iArr = new int[readInt];
            parcel.readIntArray(iArr);
            Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
            this.f1011d = new SparseArray<>(readInt);
            for (int i2 = 0; i2 < readInt; i2++) {
                this.f1011d.append(iArr[i2], readParcelableArray[i2]);
            }
        }

        @Override // b.j.a.a
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            SparseArray<Parcelable> sparseArray = this.f1011d;
            int size = sparseArray != null ? sparseArray.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            for (int i3 = 0; i3 < size; i3++) {
                iArr[i3] = this.f1011d.keyAt(i3);
                parcelableArr[i3] = this.f1011d.valueAt(i3);
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i2);
        }

        public h(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public static class f extends ViewGroup.MarginLayoutParams {

        /* renamed from: a  reason: collision with root package name */
        c f999a;

        /* renamed from: b  reason: collision with root package name */
        boolean f1000b = false;

        /* renamed from: c  reason: collision with root package name */
        public int f1001c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f1002d = 0;

        /* renamed from: e  reason: collision with root package name */
        public int f1003e = -1;

        /* renamed from: f  reason: collision with root package name */
        int f1004f = -1;

        /* renamed from: g  reason: collision with root package name */
        public int f1005g = 0;

        /* renamed from: h  reason: collision with root package name */
        public int f1006h = 0;

        /* renamed from: i  reason: collision with root package name */
        int f1007i;

        /* renamed from: j  reason: collision with root package name */
        int f1008j;

        /* renamed from: k  reason: collision with root package name */
        View f1009k;
        View l;
        private boolean m;
        private boolean n;
        private boolean o;
        private boolean p;
        final Rect q = new Rect();

        public f(int i2, int i3) {
            super(i2, i3);
        }

        private void n(View view, CoordinatorLayout coordinatorLayout) {
            View findViewById = coordinatorLayout.findViewById(this.f1004f);
            this.f1009k = findViewById;
            if (findViewById != null) {
                if (findViewById != coordinatorLayout) {
                    ViewParent parent = findViewById.getParent();
                    while (parent != coordinatorLayout && parent != null) {
                        if (parent != view) {
                            if (parent instanceof View) {
                                findViewById = (View) parent;
                            }
                            parent = parent.getParent();
                        } else if (coordinatorLayout.isInEditMode()) {
                            this.l = null;
                            this.f1009k = null;
                            return;
                        } else {
                            throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                        }
                    }
                    this.l = findViewById;
                } else if (coordinatorLayout.isInEditMode()) {
                    this.l = null;
                    this.f1009k = null;
                } else {
                    throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                }
            } else if (coordinatorLayout.isInEditMode()) {
                this.l = null;
                this.f1009k = null;
            } else {
                throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + coordinatorLayout.getResources().getResourceName(this.f1004f) + " to anchor view " + view);
            }
        }

        private boolean s(View view, int i2) {
            int b2 = b.h.k.e.b(((f) view.getLayoutParams()).f1005g, i2);
            return b2 != 0 && (b.h.k.e.b(this.f1006h, i2) & b2) == b2;
        }

        private boolean t(View view, CoordinatorLayout coordinatorLayout) {
            if (this.f1009k.getId() != this.f1004f) {
                return false;
            }
            View view2 = this.f1009k;
            for (ViewParent parent = view2.getParent(); parent != coordinatorLayout; parent = parent.getParent()) {
                if (parent == null || parent == view) {
                    this.l = null;
                    this.f1009k = null;
                    return false;
                }
                if (parent instanceof View) {
                    view2 = (View) parent;
                }
            }
            this.l = view2;
            return true;
        }

        /* access modifiers changed from: package-private */
        public boolean a() {
            return this.f1009k == null && this.f1004f != -1;
        }

        /* access modifiers changed from: package-private */
        public boolean b(CoordinatorLayout coordinatorLayout, View view, View view2) {
            c cVar;
            return view2 == this.l || s(view2, u.B(coordinatorLayout)) || ((cVar = this.f999a) != null && cVar.e(coordinatorLayout, view, view2));
        }

        /* access modifiers changed from: package-private */
        public boolean c() {
            if (this.f999a == null) {
                this.m = false;
            }
            return this.m;
        }

        /* access modifiers changed from: package-private */
        public View d(CoordinatorLayout coordinatorLayout, View view) {
            if (this.f1004f == -1) {
                this.l = null;
                this.f1009k = null;
                return null;
            }
            if (this.f1009k == null || !t(view, coordinatorLayout)) {
                n(view, coordinatorLayout);
            }
            return this.f1009k;
        }

        public int e() {
            return this.f1004f;
        }

        public c f() {
            return this.f999a;
        }

        /* access modifiers changed from: package-private */
        public boolean g() {
            return this.p;
        }

        /* access modifiers changed from: package-private */
        public Rect h() {
            return this.q;
        }

        /* access modifiers changed from: package-private */
        public boolean i(CoordinatorLayout coordinatorLayout, View view) {
            boolean z = this.m;
            if (z) {
                return true;
            }
            c cVar = this.f999a;
            boolean a2 = (cVar != null ? cVar.a(coordinatorLayout, view) : false) | z;
            this.m = a2;
            return a2;
        }

        /* access modifiers changed from: package-private */
        public boolean j(int i2) {
            if (i2 == 0) {
                return this.n;
            }
            if (i2 != 1) {
                return false;
            }
            return this.o;
        }

        /* access modifiers changed from: package-private */
        public void k() {
            this.p = false;
        }

        /* access modifiers changed from: package-private */
        public void l(int i2) {
            r(i2, false);
        }

        /* access modifiers changed from: package-private */
        public void m() {
            this.m = false;
        }

        public void o(c cVar) {
            c cVar2 = this.f999a;
            if (cVar2 != cVar) {
                if (cVar2 != null) {
                    cVar2.j();
                }
                this.f999a = cVar;
                this.f1000b = true;
                if (cVar != null) {
                    cVar.g(this);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void p(boolean z) {
            this.p = z;
        }

        /* access modifiers changed from: package-private */
        public void q(Rect rect) {
            this.q.set(rect);
        }

        /* access modifiers changed from: package-private */
        public void r(int i2, boolean z) {
            if (i2 == 0) {
                this.n = z;
            } else if (i2 == 1) {
                this.o = z;
            }
        }

        f(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.g.c.f2422d);
            this.f1001c = obtainStyledAttributes.getInteger(b.g.c.f2423e, 0);
            this.f1004f = obtainStyledAttributes.getResourceId(b.g.c.f2424f, -1);
            this.f1002d = obtainStyledAttributes.getInteger(b.g.c.f2425g, 0);
            this.f1003e = obtainStyledAttributes.getInteger(b.g.c.f2429k, -1);
            this.f1005g = obtainStyledAttributes.getInt(b.g.c.f2428j, 0);
            this.f1006h = obtainStyledAttributes.getInt(b.g.c.f2427i, 0);
            int i2 = b.g.c.f2426h;
            boolean hasValue = obtainStyledAttributes.hasValue(i2);
            this.f1000b = hasValue;
            if (hasValue) {
                this.f999a = CoordinatorLayout.K(context, attributeSet, obtainStyledAttributes.getString(i2));
            }
            obtainStyledAttributes.recycle();
            c cVar = this.f999a;
            if (cVar != null) {
                cVar.g(this);
            }
        }

        public f(f fVar) {
            super((ViewGroup.MarginLayoutParams) fVar);
        }

        public f(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public f(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }
}
