package androidx.viewpager.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import b.h.k.c0;
import b.h.k.q;
import b.h.k.u;
import com.github.mikephil.charting.utils.Utils;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ViewPager extends ViewGroup {
    static final int[] g0 = {16842931};
    private static final Comparator<f> h0 = new a();
    private static final Interpolator i0 = new b();
    private static final n j0 = new n();
    private int A;
    private int B;
    private int C;
    private float D;
    private float E;
    private float F;
    private float G;
    private int H = -1;
    private VelocityTracker I;
    private int J;
    private int K;
    private int L;
    private int M;
    private boolean N;
    private EdgeEffect O;
    private EdgeEffect P;
    private boolean Q = true;
    private boolean R;
    private int S;
    private List<j> T;
    private j U;
    private j V;
    private List<i> W;
    private k a0;

    /* renamed from: b  reason: collision with root package name */
    private int f1862b;
    private int b0;

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList<f> f1863c = new ArrayList<>();
    private int c0;

    /* renamed from: d  reason: collision with root package name */
    private final f f1864d = new f();
    private ArrayList<View> d0;

    /* renamed from: e  reason: collision with root package name */
    private final Rect f1865e = new Rect();
    private final Runnable e0 = new c();

    /* renamed from: f  reason: collision with root package name */
    a f1866f;
    private int f0 = 0;

    /* renamed from: g  reason: collision with root package name */
    int f1867g;

    /* renamed from: h  reason: collision with root package name */
    private int f1868h = -1;

    /* renamed from: i  reason: collision with root package name */
    private Parcelable f1869i = null;

    /* renamed from: j  reason: collision with root package name */
    private ClassLoader f1870j = null;

    /* renamed from: k  reason: collision with root package name */
    private Scroller f1871k;
    private boolean l;
    private l m;
    private int n;
    private Drawable o;
    private int p;
    private int q;
    private float r = -3.4028235E38f;
    private float s = Float.MAX_VALUE;
    private int t;
    private boolean u;
    private boolean v;
    private boolean w;
    private int x = 1;
    private boolean y;
    private boolean z;

    static class a implements Comparator<f> {
        a() {
        }

        /* renamed from: a */
        public int compare(f fVar, f fVar2) {
            return fVar.f1876b - fVar2.f1876b;
        }
    }

    static class b implements Interpolator {
        b() {
        }

        public float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }
    }

    class c implements Runnable {
        c() {
        }

        public void run() {
            ViewPager.this.setScrollState(0);
            ViewPager.this.E();
        }
    }

    /* access modifiers changed from: package-private */
    public class d implements q {

        /* renamed from: a  reason: collision with root package name */
        private final Rect f1873a = new Rect();

        d() {
        }

        @Override // b.h.k.q
        public c0 a(View view, c0 c0Var) {
            c0 Z = u.Z(view, c0Var);
            if (Z.l()) {
                return Z;
            }
            Rect rect = this.f1873a;
            rect.left = Z.g();
            rect.top = Z.i();
            rect.right = Z.h();
            rect.bottom = Z.f();
            int childCount = ViewPager.this.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                c0 h2 = u.h(ViewPager.this.getChildAt(i2), Z);
                rect.left = Math.min(h2.g(), rect.left);
                rect.top = Math.min(h2.i(), rect.top);
                rect.right = Math.min(h2.h(), rect.right);
                rect.bottom = Math.min(h2.f(), rect.bottom);
            }
            return Z.m(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    public @interface e {
    }

    /* access modifiers changed from: package-private */
    public static class f {

        /* renamed from: a  reason: collision with root package name */
        Object f1875a;

        /* renamed from: b  reason: collision with root package name */
        int f1876b;

        /* renamed from: c  reason: collision with root package name */
        boolean f1877c;

        /* renamed from: d  reason: collision with root package name */
        float f1878d;

        /* renamed from: e  reason: collision with root package name */
        float f1879e;

        f() {
        }
    }

    /* access modifiers changed from: package-private */
    public class h extends b.h.k.a {
        h() {
        }

        private boolean n() {
            a aVar = ViewPager.this.f1866f;
            return aVar != null && aVar.d() > 1;
        }

        @Override // b.h.k.a
        public void f(View view, AccessibilityEvent accessibilityEvent) {
            a aVar;
            super.f(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            accessibilityEvent.setScrollable(n());
            if (accessibilityEvent.getEventType() == 4096 && (aVar = ViewPager.this.f1866f) != null) {
                accessibilityEvent.setItemCount(aVar.d());
                accessibilityEvent.setFromIndex(ViewPager.this.f1867g);
                accessibilityEvent.setToIndex(ViewPager.this.f1867g);
            }
        }

        @Override // b.h.k.a
        public void g(View view, b.h.k.d0.c cVar) {
            super.g(view, cVar);
            cVar.a0(ViewPager.class.getName());
            cVar.u0(n());
            if (ViewPager.this.canScrollHorizontally(1)) {
                cVar.a(4096);
            }
            if (ViewPager.this.canScrollHorizontally(-1)) {
                cVar.a(8192);
            }
        }

        @Override // b.h.k.a
        public boolean j(View view, int i2, Bundle bundle) {
            if (super.j(view, i2, bundle)) {
                return true;
            }
            if (i2 != 4096) {
                if (i2 != 8192 || !ViewPager.this.canScrollHorizontally(-1)) {
                    return false;
                }
                ViewPager viewPager = ViewPager.this;
                viewPager.setCurrentItem(viewPager.f1867g - 1);
                return true;
            } else if (!ViewPager.this.canScrollHorizontally(1)) {
                return false;
            } else {
                ViewPager viewPager2 = ViewPager.this;
                viewPager2.setCurrentItem(viewPager2.f1867g + 1);
                return true;
            }
        }
    }

    public interface i {
        void d(ViewPager viewPager, a aVar, a aVar2);
    }

    public interface j {
        void a(int i2, float f2, int i3);

        void b(int i2);

        void c(int i2);
    }

    public interface k {
        void a(View view, float f2);
    }

    private class l extends DataSetObserver {
        l() {
        }

        public void onChanged() {
            ViewPager.this.h();
        }

        public void onInvalidated() {
            ViewPager.this.h();
        }
    }

    public static class m extends b.j.a.a {
        public static final Parcelable.Creator<m> CREATOR = new a();

        /* renamed from: d  reason: collision with root package name */
        int f1888d;

        /* renamed from: e  reason: collision with root package name */
        Parcelable f1889e;

        /* renamed from: f  reason: collision with root package name */
        ClassLoader f1890f;

        static class a implements Parcelable.ClassLoaderCreator<m> {
            a() {
            }

            /* renamed from: a */
            public m createFromParcel(Parcel parcel) {
                return new m(parcel, null);
            }

            /* renamed from: b */
            public m createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new m(parcel, classLoader);
            }

            /* renamed from: c */
            public m[] newArray(int i2) {
                return new m[i2];
            }
        }

        public m(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f1888d + "}";
        }

        @Override // b.j.a.a
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f1888d);
            parcel.writeParcelable(this.f1889e, i2);
        }

        m(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            classLoader = classLoader == null ? m.class.getClassLoader() : classLoader;
            this.f1888d = parcel.readInt();
            this.f1889e = parcel.readParcelable(classLoader);
            this.f1890f = classLoader;
        }
    }

    /* access modifiers changed from: package-private */
    public static class n implements Comparator<View> {
        n() {
        }

        /* renamed from: a */
        public int compare(View view, View view2) {
            g gVar = (g) view.getLayoutParams();
            g gVar2 = (g) view2.getLayoutParams();
            boolean z = gVar.f1880a;
            if (z != gVar2.f1880a) {
                return z ? 1 : -1;
            }
            return gVar.f1884e - gVar2.f1884e;
        }
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        v();
    }

    private boolean C(int i2) {
        if (this.f1863c.size() != 0) {
            f t2 = t();
            int clientWidth = getClientWidth();
            int i3 = this.n;
            int i4 = clientWidth + i3;
            float f2 = (float) clientWidth;
            int i5 = t2.f1876b;
            float f3 = ((((float) i2) / f2) - t2.f1879e) / (t2.f1878d + (((float) i3) / f2));
            this.R = false;
            y(i5, f3, (int) (((float) i4) * f3));
            if (this.R) {
                return true;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        } else if (this.Q) {
            return false;
        } else {
            this.R = false;
            y(0, Utils.FLOAT_EPSILON, 0);
            if (this.R) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
    }

    private boolean D(float f2) {
        boolean z2;
        boolean z3;
        float f3 = this.D - f2;
        this.D = f2;
        float scrollX = ((float) getScrollX()) + f3;
        float clientWidth = (float) getClientWidth();
        float f4 = this.r * clientWidth;
        float f5 = this.s * clientWidth;
        boolean z4 = false;
        f fVar = this.f1863c.get(0);
        ArrayList<f> arrayList = this.f1863c;
        f fVar2 = arrayList.get(arrayList.size() - 1);
        if (fVar.f1876b != 0) {
            f4 = fVar.f1879e * clientWidth;
            z2 = false;
        } else {
            z2 = true;
        }
        if (fVar2.f1876b != this.f1866f.d() - 1) {
            f5 = fVar2.f1879e * clientWidth;
            z3 = false;
        } else {
            z3 = true;
        }
        if (scrollX < f4) {
            if (z2) {
                this.O.onPull(Math.abs(f4 - scrollX) / clientWidth);
                z4 = true;
            }
            scrollX = f4;
        } else if (scrollX > f5) {
            if (z3) {
                this.P.onPull(Math.abs(scrollX - f5) / clientWidth);
                z4 = true;
            }
            scrollX = f5;
        }
        int i2 = (int) scrollX;
        this.D += scrollX - ((float) i2);
        scrollTo(i2, getScrollY());
        C(i2);
        return z4;
    }

    private void G(int i2, int i3, int i4, int i5) {
        if (i3 <= 0 || this.f1863c.isEmpty()) {
            f u2 = u(this.f1867g);
            int min = (int) ((u2 != null ? Math.min(u2.f1879e, this.s) : Utils.FLOAT_EPSILON) * ((float) ((i2 - getPaddingLeft()) - getPaddingRight())));
            if (min != getScrollX()) {
                g(false);
                scrollTo(min, getScrollY());
            }
        } else if (!this.f1871k.isFinished()) {
            this.f1871k.setFinalX(getCurrentItem() * getClientWidth());
        } else {
            scrollTo((int) ((((float) getScrollX()) / ((float) (((i3 - getPaddingLeft()) - getPaddingRight()) + i5))) * ((float) (((i2 - getPaddingLeft()) - getPaddingRight()) + i4))), getScrollY());
        }
    }

    private void H() {
        int i2 = 0;
        while (i2 < getChildCount()) {
            if (!((g) getChildAt(i2).getLayoutParams()).f1880a) {
                removeViewAt(i2);
                i2--;
            }
            i2++;
        }
    }

    private void K(boolean z2) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z2);
        }
    }

    private boolean L() {
        this.H = -1;
        o();
        this.O.onRelease();
        this.P.onRelease();
        return this.O.isFinished() || this.P.isFinished();
    }

    private void M(int i2, boolean z2, int i3, boolean z3) {
        f u2 = u(i2);
        int clientWidth = u2 != null ? (int) (((float) getClientWidth()) * Math.max(this.r, Math.min(u2.f1879e, this.s))) : 0;
        if (z2) {
            Q(clientWidth, 0, i3);
            if (z3) {
                k(i2);
                return;
            }
            return;
        }
        if (z3) {
            k(i2);
        }
        g(false);
        scrollTo(clientWidth, 0);
        C(clientWidth);
    }

    private void R() {
        if (this.c0 != 0) {
            ArrayList<View> arrayList = this.d0;
            if (arrayList == null) {
                this.d0 = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                this.d0.add(getChildAt(i2));
            }
            Collections.sort(this.d0, j0);
        }
    }

    private void e(f fVar, int i2, f fVar2) {
        int i3;
        int i4;
        f fVar3;
        f fVar4;
        int d2 = this.f1866f.d();
        int clientWidth = getClientWidth();
        float f2 = clientWidth > 0 ? ((float) this.n) / ((float) clientWidth) : Utils.FLOAT_EPSILON;
        if (fVar2 != null) {
            int i5 = fVar2.f1876b;
            int i6 = fVar.f1876b;
            if (i5 < i6) {
                int i7 = 0;
                float f3 = fVar2.f1879e + fVar2.f1878d + f2;
                while (true) {
                    i5++;
                    if (i5 > fVar.f1876b || i7 >= this.f1863c.size()) {
                        break;
                    }
                    f fVar5 = this.f1863c.get(i7);
                    while (true) {
                        fVar4 = fVar5;
                        if (i5 > fVar4.f1876b && i7 < this.f1863c.size() - 1) {
                            i7++;
                            fVar5 = this.f1863c.get(i7);
                        }
                    }
                    while (i5 < fVar4.f1876b) {
                        f3 += this.f1866f.g(i5) + f2;
                        i5++;
                    }
                    fVar4.f1879e = f3;
                    f3 += fVar4.f1878d + f2;
                }
            } else if (i5 > i6) {
                int size = this.f1863c.size() - 1;
                float f4 = fVar2.f1879e;
                while (true) {
                    i5--;
                    if (i5 < fVar.f1876b || size < 0) {
                        break;
                    }
                    f fVar6 = this.f1863c.get(size);
                    while (true) {
                        fVar3 = fVar6;
                        if (i5 < fVar3.f1876b && size > 0) {
                            size--;
                            fVar6 = this.f1863c.get(size);
                        }
                    }
                    while (i5 > fVar3.f1876b) {
                        f4 -= this.f1866f.g(i5) + f2;
                        i5--;
                    }
                    f4 -= fVar3.f1878d + f2;
                    fVar3.f1879e = f4;
                }
            }
        }
        int size2 = this.f1863c.size();
        float f5 = fVar.f1879e;
        int i8 = fVar.f1876b;
        int i9 = i8 - 1;
        this.r = i8 == 0 ? f5 : -3.4028235E38f;
        int i10 = d2 - 1;
        this.s = i8 == i10 ? (fVar.f1878d + f5) - 1.0f : Float.MAX_VALUE;
        int i11 = i2 - 1;
        while (i11 >= 0) {
            f fVar7 = this.f1863c.get(i11);
            while (true) {
                i4 = fVar7.f1876b;
                if (i9 <= i4) {
                    break;
                }
                f5 -= this.f1866f.g(i9) + f2;
                i9--;
            }
            f5 -= fVar7.f1878d + f2;
            fVar7.f1879e = f5;
            if (i4 == 0) {
                this.r = f5;
            }
            i11--;
            i9--;
        }
        float f6 = fVar.f1879e + fVar.f1878d + f2;
        int i12 = fVar.f1876b + 1;
        int i13 = i2 + 1;
        while (i13 < size2) {
            f fVar8 = this.f1863c.get(i13);
            while (true) {
                i3 = fVar8.f1876b;
                if (i12 >= i3) {
                    break;
                }
                f6 += this.f1866f.g(i12) + f2;
                i12++;
            }
            if (i3 == i10) {
                this.s = (fVar8.f1878d + f6) - 1.0f;
            }
            fVar8.f1879e = f6;
            f6 += fVar8.f1878d + f2;
            i13++;
            i12++;
        }
    }

    private void g(boolean z2) {
        boolean z3 = this.f0 == 2;
        if (z3) {
            setScrollingCacheEnabled(false);
            if (!this.f1871k.isFinished()) {
                this.f1871k.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.f1871k.getCurrX();
                int currY = this.f1871k.getCurrY();
                if (!(scrollX == currX && scrollY == currY)) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        C(currX);
                    }
                }
            }
        }
        this.w = false;
        for (int i2 = 0; i2 < this.f1863c.size(); i2++) {
            f fVar = this.f1863c.get(i2);
            if (fVar.f1877c) {
                fVar.f1877c = false;
                z3 = true;
            }
        }
        if (!z3) {
            return;
        }
        if (z2) {
            u.e0(this, this.e0);
        } else {
            this.e0.run();
        }
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private int i(int i2, float f2, int i3, int i4) {
        if (Math.abs(i4) <= this.L || Math.abs(i3) <= this.J) {
            i2 += (int) (f2 + (i2 >= this.f1867g ? 0.4f : 0.6f));
        } else if (i3 <= 0) {
            i2++;
        }
        if (this.f1863c.size() <= 0) {
            return i2;
        }
        ArrayList<f> arrayList = this.f1863c;
        return Math.max(this.f1863c.get(0).f1876b, Math.min(i2, arrayList.get(arrayList.size() - 1).f1876b));
    }

    private void j(int i2, float f2, int i3) {
        j jVar = this.U;
        if (jVar != null) {
            jVar.a(i2, f2, i3);
        }
        List<j> list = this.T;
        if (list != null) {
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                j jVar2 = this.T.get(i4);
                if (jVar2 != null) {
                    jVar2.a(i2, f2, i3);
                }
            }
        }
        j jVar3 = this.V;
        if (jVar3 != null) {
            jVar3.a(i2, f2, i3);
        }
    }

    private void k(int i2) {
        j jVar = this.U;
        if (jVar != null) {
            jVar.c(i2);
        }
        List<j> list = this.T;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                j jVar2 = this.T.get(i3);
                if (jVar2 != null) {
                    jVar2.c(i2);
                }
            }
        }
        j jVar3 = this.V;
        if (jVar3 != null) {
            jVar3.c(i2);
        }
    }

    private void l(int i2) {
        j jVar = this.U;
        if (jVar != null) {
            jVar.b(i2);
        }
        List<j> list = this.T;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                j jVar2 = this.T.get(i3);
                if (jVar2 != null) {
                    jVar2.b(i2);
                }
            }
        }
        j jVar3 = this.V;
        if (jVar3 != null) {
            jVar3.b(i2);
        }
    }

    private void n(boolean z2) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            getChildAt(i2).setLayerType(z2 ? this.b0 : 0, null);
        }
    }

    private void o() {
        this.y = false;
        this.z = false;
        VelocityTracker velocityTracker = this.I;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.I = null;
        }
    }

    private Rect q(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left += viewGroup.getLeft();
            rect.right += viewGroup.getRight();
            rect.top += viewGroup.getTop();
            rect.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect;
    }

    private void setScrollingCacheEnabled(boolean z2) {
        if (this.v != z2) {
            this.v = z2;
        }
    }

    private f t() {
        int i2;
        int clientWidth = getClientWidth();
        float f2 = Utils.FLOAT_EPSILON;
        float scrollX = clientWidth > 0 ? ((float) getScrollX()) / ((float) clientWidth) : Utils.FLOAT_EPSILON;
        float f3 = clientWidth > 0 ? ((float) this.n) / ((float) clientWidth) : Utils.FLOAT_EPSILON;
        f fVar = null;
        float f4 = Utils.FLOAT_EPSILON;
        int i3 = -1;
        int i4 = 0;
        boolean z2 = true;
        while (i4 < this.f1863c.size()) {
            f fVar2 = this.f1863c.get(i4);
            if (!z2 && fVar2.f1876b != (i2 = i3 + 1)) {
                fVar2 = this.f1864d;
                fVar2.f1879e = f2 + f4 + f3;
                fVar2.f1876b = i2;
                fVar2.f1878d = this.f1866f.g(i2);
                i4--;
            }
            f2 = fVar2.f1879e;
            float f5 = fVar2.f1878d + f2 + f3;
            if (!z2 && scrollX < f2) {
                return fVar;
            }
            if (scrollX < f5 || i4 == this.f1863c.size() - 1) {
                return fVar2;
            }
            i3 = fVar2.f1876b;
            f4 = fVar2.f1878d;
            i4++;
            fVar = fVar2;
            z2 = false;
        }
        return fVar;
    }

    private static boolean w(View view) {
        return view.getClass().getAnnotation(e.class) != null;
    }

    private boolean x(float f2, float f3) {
        return (f2 < ((float) this.B) && f3 > Utils.FLOAT_EPSILON) || (f2 > ((float) (getWidth() - this.B)) && f3 < Utils.FLOAT_EPSILON);
    }

    private void z(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.H) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.D = motionEvent.getX(i2);
            this.H = motionEvent.getPointerId(i2);
            VelocityTracker velocityTracker = this.I;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean A() {
        int i2 = this.f1867g;
        if (i2 <= 0) {
            return false;
        }
        N(i2 - 1, true);
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean B() {
        a aVar = this.f1866f;
        if (aVar == null || this.f1867g >= aVar.d() - 1) {
            return false;
        }
        N(this.f1867g + 1, true);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void E() {
        F(this.f1867g);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0060, code lost:
        if (r9 == r10) goto L_0x0067;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0066, code lost:
        r8 = null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void F(int r18) {
        /*
        // Method dump skipped, instructions count: 616
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.F(int):void");
    }

    public void I(i iVar) {
        List<i> list = this.W;
        if (list != null) {
            list.remove(iVar);
        }
    }

    public void J(j jVar) {
        List<j> list = this.T;
        if (list != null) {
            list.remove(jVar);
        }
    }

    public void N(int i2, boolean z2) {
        this.w = false;
        O(i2, z2, false);
    }

    /* access modifiers changed from: package-private */
    public void O(int i2, boolean z2, boolean z3) {
        P(i2, z2, z3, 0);
    }

    /* access modifiers changed from: package-private */
    public void P(int i2, boolean z2, boolean z3, int i3) {
        a aVar = this.f1866f;
        boolean z4 = false;
        if (aVar == null || aVar.d() <= 0) {
            setScrollingCacheEnabled(false);
        } else if (z3 || this.f1867g != i2 || this.f1863c.size() == 0) {
            if (i2 < 0) {
                i2 = 0;
            } else if (i2 >= this.f1866f.d()) {
                i2 = this.f1866f.d() - 1;
            }
            int i4 = this.x;
            int i5 = this.f1867g;
            if (i2 > i5 + i4 || i2 < i5 - i4) {
                for (int i6 = 0; i6 < this.f1863c.size(); i6++) {
                    this.f1863c.get(i6).f1877c = true;
                }
            }
            if (this.f1867g != i2) {
                z4 = true;
            }
            if (this.Q) {
                this.f1867g = i2;
                if (z4) {
                    k(i2);
                }
                requestLayout();
                return;
            }
            F(i2);
            M(i2, z2, i3, z4);
        } else {
            setScrollingCacheEnabled(false);
        }
    }

    /* access modifiers changed from: package-private */
    public void Q(int i2, int i3, int i4) {
        int i5;
        int i6;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        Scroller scroller = this.f1871k;
        if (scroller != null && !scroller.isFinished()) {
            i5 = this.l ? this.f1871k.getCurrX() : this.f1871k.getStartX();
            this.f1871k.abortAnimation();
            setScrollingCacheEnabled(false);
        } else {
            i5 = getScrollX();
        }
        int scrollY = getScrollY();
        int i7 = i2 - i5;
        int i8 = i3 - scrollY;
        if (i7 == 0 && i8 == 0) {
            g(false);
            E();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i9 = clientWidth / 2;
        float f2 = (float) clientWidth;
        float f3 = (float) i9;
        float m2 = f3 + (m(Math.min(1.0f, (((float) Math.abs(i7)) * 1.0f) / f2)) * f3);
        int abs = Math.abs(i4);
        if (abs > 0) {
            i6 = Math.round(Math.abs(m2 / ((float) abs)) * 1000.0f) * 4;
        } else {
            i6 = (int) (((((float) Math.abs(i7)) / ((f2 * this.f1866f.g(this.f1867g)) + ((float) this.n))) + 1.0f) * 100.0f);
        }
        int min = Math.min(i6, 600);
        this.l = false;
        this.f1871k.startScroll(i5, scrollY, i7, i8, min);
        u.d0(this);
    }

    /* access modifiers changed from: package-private */
    public f a(int i2, int i3) {
        f fVar = new f();
        fVar.f1876b = i2;
        fVar.f1875a = this.f1866f.h(this, i2);
        fVar.f1878d = this.f1866f.g(i2);
        if (i3 < 0 || i3 >= this.f1863c.size()) {
            this.f1863c.add(fVar);
        } else {
            this.f1863c.add(i3, fVar);
        }
        return fVar;
    }

    @Override // android.view.View, android.view.ViewGroup
    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        f s2;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                View childAt = getChildAt(i4);
                if (childAt.getVisibility() == 0 && (s2 = s(childAt)) != null && s2.f1876b == this.f1867g) {
                    childAt.addFocusables(arrayList, i2, i3);
                }
            }
        }
        if ((descendantFocusability == 262144 && size != arrayList.size()) || !isFocusable()) {
            return;
        }
        if (((i3 & 1) != 1 || !isInTouchMode() || isFocusableInTouchMode()) && arrayList != null) {
            arrayList.add(this);
        }
    }

    @Override // android.view.View, android.view.ViewGroup
    public void addTouchables(ArrayList<View> arrayList) {
        f s2;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (s2 = s(childAt)) != null && s2.f1876b == this.f1867g) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        g gVar = (g) layoutParams;
        boolean w2 = gVar.f1880a | w(view);
        gVar.f1880a = w2;
        if (!this.u) {
            super.addView(view, i2, layoutParams);
        } else if (gVar == null || !w2) {
            gVar.f1883d = true;
            addViewInLayout(view, i2, layoutParams);
        } else {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
    }

    public void b(i iVar) {
        if (this.W == null) {
            this.W = new ArrayList();
        }
        this.W.add(iVar);
    }

    public void c(j jVar) {
        if (this.T == null) {
            this.T = new ArrayList();
        }
        this.T.add(jVar);
    }

    public boolean canScrollHorizontally(int i2) {
        if (this.f1866f == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        if (i2 < 0) {
            if (scrollX > ((int) (((float) clientWidth) * this.r))) {
                return true;
            }
            return false;
        } else if (i2 <= 0 || scrollX >= ((int) (((float) clientWidth) * this.s))) {
            return false;
        } else {
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof g) && super.checkLayoutParams(layoutParams);
    }

    public void computeScroll() {
        this.l = true;
        if (this.f1871k.isFinished() || !this.f1871k.computeScrollOffset()) {
            g(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.f1871k.getCurrX();
        int currY = this.f1871k.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            scrollTo(currX, currY);
            if (!C(currX)) {
                this.f1871k.abortAnimation();
                scrollTo(0, currY);
            }
        }
        u.d0(this);
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x00cf  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean d(int r7) {
        /*
        // Method dump skipped, instructions count: 215
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.d(int):boolean");
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || p(keyEvent);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        f s2;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (s2 = s(childAt)) != null && s2.f1876b == this.f1867g && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    public void draw(Canvas canvas) {
        a aVar;
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        boolean z2 = false;
        if (overScrollMode == 0 || (overScrollMode == 1 && (aVar = this.f1866f) != null && aVar.d() > 1)) {
            if (!this.O.isFinished()) {
                int save = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((float) ((-height) + getPaddingTop()), this.r * ((float) width));
                this.O.setSize(height, width);
                z2 = false | this.O.draw(canvas);
                canvas.restoreToCount(save);
            }
            if (!this.P.isFinished()) {
                int save2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate((float) (-getPaddingTop()), (-(this.s + 1.0f)) * ((float) width2));
                this.P.setSize(height2, width2);
                z2 |= this.P.draw(canvas);
                canvas.restoreToCount(save2);
            }
        } else {
            this.O.finish();
            this.P.finish();
        }
        if (z2) {
            u.d0(this);
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.o;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    /* access modifiers changed from: protected */
    public boolean f(View view, boolean z2, int i2, int i3, int i4) {
        int i5;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i6 = i3 + scrollX;
                if (i6 >= childAt.getLeft() && i6 < childAt.getRight() && (i5 = i4 + scrollY) >= childAt.getTop() && i5 < childAt.getBottom() && f(childAt, true, i2, i6 - childAt.getLeft(), i5 - childAt.getTop())) {
                    return true;
                }
            }
        }
        if (!z2 || !view.canScrollHorizontally(-i2)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new g();
    }

    /* access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public a getAdapter() {
        return this.f1866f;
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i2, int i3) {
        if (this.c0 == 2) {
            i3 = (i2 - 1) - i3;
        }
        return ((g) this.d0.get(i3).getLayoutParams()).f1885f;
    }

    public int getCurrentItem() {
        return this.f1867g;
    }

    public int getOffscreenPageLimit() {
        return this.x;
    }

    public int getPageMargin() {
        return this.n;
    }

    /* access modifiers changed from: package-private */
    public void h() {
        int d2 = this.f1866f.d();
        this.f1862b = d2;
        boolean z2 = this.f1863c.size() < (this.x * 2) + 1 && this.f1863c.size() < d2;
        int i2 = this.f1867g;
        int i3 = 0;
        boolean z3 = false;
        while (i3 < this.f1863c.size()) {
            f fVar = this.f1863c.get(i3);
            int e2 = this.f1866f.e(fVar.f1875a);
            if (e2 != -1) {
                if (e2 == -2) {
                    this.f1863c.remove(i3);
                    i3--;
                    if (!z3) {
                        this.f1866f.q(this);
                        z3 = true;
                    }
                    this.f1866f.a(this, fVar.f1876b, fVar.f1875a);
                    int i4 = this.f1867g;
                    if (i4 == fVar.f1876b) {
                        i2 = Math.max(0, Math.min(i4, d2 - 1));
                    }
                } else {
                    int i5 = fVar.f1876b;
                    if (i5 != e2) {
                        if (i5 == this.f1867g) {
                            i2 = e2;
                        }
                        fVar.f1876b = e2;
                    }
                }
                z2 = true;
            }
            i3++;
        }
        if (z3) {
            this.f1866f.c(this);
        }
        Collections.sort(this.f1863c, h0);
        if (z2) {
            int childCount = getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                g gVar = (g) getChildAt(i6).getLayoutParams();
                if (!gVar.f1880a) {
                    gVar.f1882c = Utils.FLOAT_EPSILON;
                }
            }
            O(i2, false, true);
            requestLayout();
        }
    }

    /* access modifiers changed from: package-private */
    public float m(float f2) {
        return (float) Math.sin((double) ((f2 - 0.5f) * 0.47123894f));
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.Q = true;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        removeCallbacks(this.e0);
        Scroller scroller = this.f1871k;
        if (scroller != null && !scroller.isFinished()) {
            this.f1871k.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0065  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDraw(android.graphics.Canvas r18) {
        /*
        // Method dump skipped, instructions count: 171
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onDraw(android.graphics.Canvas):void");
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            L();
            return false;
        }
        if (action != 0) {
            if (this.y) {
                return true;
            }
            if (this.z) {
                return false;
            }
        }
        if (action == 0) {
            float x2 = motionEvent.getX();
            this.F = x2;
            this.D = x2;
            float y2 = motionEvent.getY();
            this.G = y2;
            this.E = y2;
            this.H = motionEvent.getPointerId(0);
            this.z = false;
            this.l = true;
            this.f1871k.computeScrollOffset();
            if (this.f0 != 2 || Math.abs(this.f1871k.getFinalX() - this.f1871k.getCurrX()) <= this.M) {
                g(false);
                this.y = false;
            } else {
                this.f1871k.abortAnimation();
                this.w = false;
                E();
                this.y = true;
                K(true);
                setScrollState(1);
            }
        } else if (action == 2) {
            int i2 = this.H;
            if (i2 != -1) {
                int findPointerIndex = motionEvent.findPointerIndex(i2);
                float x3 = motionEvent.getX(findPointerIndex);
                float f2 = x3 - this.D;
                float abs = Math.abs(f2);
                float y3 = motionEvent.getY(findPointerIndex);
                float abs2 = Math.abs(y3 - this.G);
                if (f2 == Utils.FLOAT_EPSILON || x(this.D, f2) || !f(this, false, (int) f2, (int) x3, (int) y3)) {
                    int i3 = this.C;
                    if (abs > ((float) i3) && abs * 0.5f > abs2) {
                        this.y = true;
                        K(true);
                        setScrollState(1);
                        this.D = f2 > Utils.FLOAT_EPSILON ? this.F + ((float) this.C) : this.F - ((float) this.C);
                        this.E = y3;
                        setScrollingCacheEnabled(true);
                    } else if (abs2 > ((float) i3)) {
                        this.z = true;
                    }
                    if (this.y && D(x3)) {
                        u.d0(this);
                    }
                } else {
                    this.D = x3;
                    this.E = y3;
                    this.z = true;
                    return false;
                }
            }
        } else if (action == 6) {
            z(motionEvent);
        }
        if (this.I == null) {
            this.I = VelocityTracker.obtain();
        }
        this.I.addMovement(motionEvent);
        return this.y;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x008e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayout(boolean r19, int r20, int r21, int r22, int r23) {
        /*
        // Method dump skipped, instructions count: 286
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onLayout(boolean, int, int, int, int):void");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00a8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r14, int r15) {
        /*
        // Method dump skipped, instructions count: 241
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onMeasure(int, int):void");
    }

    /* access modifiers changed from: protected */
    public boolean onRequestFocusInDescendants(int i2, Rect rect) {
        int i3;
        int i4;
        f s2;
        int childCount = getChildCount();
        int i5 = -1;
        if ((i2 & 2) != 0) {
            i5 = childCount;
            i4 = 0;
            i3 = 1;
        } else {
            i4 = childCount - 1;
            i3 = -1;
        }
        while (i4 != i5) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() == 0 && (s2 = s(childAt)) != null && s2.f1876b == this.f1867g && childAt.requestFocus(i2, rect)) {
                return true;
            }
            i4 += i3;
        }
        return false;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof m)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        m mVar = (m) parcelable;
        super.onRestoreInstanceState(mVar.g());
        a aVar = this.f1866f;
        if (aVar != null) {
            aVar.k(mVar.f1889e, mVar.f1890f);
            O(mVar.f1888d, false, true);
            return;
        }
        this.f1868h = mVar.f1888d;
        this.f1869i = mVar.f1889e;
        this.f1870j = mVar.f1890f;
    }

    public Parcelable onSaveInstanceState() {
        m mVar = new m(super.onSaveInstanceState());
        mVar.f1888d = this.f1867g;
        a aVar = this.f1866f;
        if (aVar != null) {
            mVar.f1889e = aVar.l();
        }
        return mVar;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 != i4) {
            int i6 = this.n;
            G(i2, i4, i6, i6);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        a aVar;
        if (this.N) {
            return true;
        }
        boolean z2 = false;
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || (aVar = this.f1866f) == null || aVar.d() == 0) {
            return false;
        }
        if (this.I == null) {
            this.I = VelocityTracker.obtain();
        }
        this.I.addMovement(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.f1871k.abortAnimation();
            this.w = false;
            E();
            float x2 = motionEvent.getX();
            this.F = x2;
            this.D = x2;
            float y2 = motionEvent.getY();
            this.G = y2;
            this.E = y2;
            this.H = motionEvent.getPointerId(0);
        } else if (action != 1) {
            if (action == 2) {
                if (!this.y) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.H);
                    if (findPointerIndex == -1) {
                        z2 = L();
                    } else {
                        float x3 = motionEvent.getX(findPointerIndex);
                        float abs = Math.abs(x3 - this.D);
                        float y3 = motionEvent.getY(findPointerIndex);
                        float abs2 = Math.abs(y3 - this.E);
                        if (abs > ((float) this.C) && abs > abs2) {
                            this.y = true;
                            K(true);
                            float f2 = this.F;
                            this.D = x3 - f2 > Utils.FLOAT_EPSILON ? f2 + ((float) this.C) : f2 - ((float) this.C);
                            this.E = y3;
                            setScrollState(1);
                            setScrollingCacheEnabled(true);
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                            }
                        }
                    }
                }
                if (this.y) {
                    z2 = false | D(motionEvent.getX(motionEvent.findPointerIndex(this.H)));
                }
            } else if (action != 3) {
                if (action == 5) {
                    int actionIndex = motionEvent.getActionIndex();
                    this.D = motionEvent.getX(actionIndex);
                    this.H = motionEvent.getPointerId(actionIndex);
                } else if (action == 6) {
                    z(motionEvent);
                    this.D = motionEvent.getX(motionEvent.findPointerIndex(this.H));
                }
            } else if (this.y) {
                M(this.f1867g, true, 0, false);
                z2 = L();
            }
        } else if (this.y) {
            VelocityTracker velocityTracker = this.I;
            velocityTracker.computeCurrentVelocity(1000, (float) this.K);
            int xVelocity = (int) velocityTracker.getXVelocity(this.H);
            this.w = true;
            int clientWidth = getClientWidth();
            int scrollX = getScrollX();
            f t2 = t();
            float f3 = (float) clientWidth;
            P(i(t2.f1876b, ((((float) scrollX) / f3) - t2.f1879e) / (t2.f1878d + (((float) this.n) / f3)), xVelocity, (int) (motionEvent.getX(motionEvent.findPointerIndex(this.H)) - this.F)), true, true, xVelocity);
            z2 = L();
        }
        if (z2) {
            u.d0(this);
        }
        return true;
    }

    public boolean p(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 21) {
                if (keyCode != 22) {
                    if (keyCode == 61) {
                        if (keyEvent.hasNoModifiers()) {
                            return d(2);
                        }
                        if (keyEvent.hasModifiers(1)) {
                            return d(1);
                        }
                    }
                } else if (keyEvent.hasModifiers(2)) {
                    return B();
                } else {
                    return d(66);
                }
            } else if (keyEvent.hasModifiers(2)) {
                return A();
            } else {
                return d(17);
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public f r(View view) {
        while (true) {
            ViewParent parent = view.getParent();
            if (parent == this) {
                return s(view);
            }
            if (parent == null || !(parent instanceof View)) {
                return null;
            }
            view = (View) parent;
        }
    }

    public void removeView(View view) {
        if (this.u) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    /* access modifiers changed from: package-private */
    public f s(View view) {
        for (int i2 = 0; i2 < this.f1863c.size(); i2++) {
            f fVar = this.f1863c.get(i2);
            if (this.f1866f.i(view, fVar.f1875a)) {
                return fVar;
            }
        }
        return null;
    }

    public void setAdapter(a aVar) {
        a aVar2 = this.f1866f;
        if (aVar2 != null) {
            aVar2.o(null);
            this.f1866f.q(this);
            for (int i2 = 0; i2 < this.f1863c.size(); i2++) {
                f fVar = this.f1863c.get(i2);
                this.f1866f.a(this, fVar.f1876b, fVar.f1875a);
            }
            this.f1866f.c(this);
            this.f1863c.clear();
            H();
            this.f1867g = 0;
            scrollTo(0, 0);
        }
        a aVar3 = this.f1866f;
        this.f1866f = aVar;
        this.f1862b = 0;
        if (aVar != null) {
            if (this.m == null) {
                this.m = new l();
            }
            this.f1866f.o(this.m);
            this.w = false;
            boolean z2 = this.Q;
            this.Q = true;
            this.f1862b = this.f1866f.d();
            if (this.f1868h >= 0) {
                this.f1866f.k(this.f1869i, this.f1870j);
                O(this.f1868h, false, true);
                this.f1868h = -1;
                this.f1869i = null;
                this.f1870j = null;
            } else if (!z2) {
                E();
            } else {
                requestLayout();
            }
        }
        List<i> list = this.W;
        if (!(list == null || list.isEmpty())) {
            int size = this.W.size();
            for (int i3 = 0; i3 < size; i3++) {
                this.W.get(i3).d(this, aVar3, aVar);
            }
        }
    }

    public void setCurrentItem(int i2) {
        this.w = false;
        O(i2, !this.Q, false);
    }

    public void setOffscreenPageLimit(int i2) {
        if (i2 < 1) {
            Log.w("ViewPager", "Requested offscreen page limit " + i2 + " too small; defaulting to " + 1);
            i2 = 1;
        }
        if (i2 != this.x) {
            this.x = i2;
            E();
        }
    }

    @Deprecated
    public void setOnPageChangeListener(j jVar) {
        this.U = jVar;
    }

    public void setPageMargin(int i2) {
        int i3 = this.n;
        this.n = i2;
        int width = getWidth();
        G(width, width, i2, i3);
        requestLayout();
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.o = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    /* access modifiers changed from: package-private */
    public void setScrollState(int i2) {
        if (this.f0 != i2) {
            this.f0 = i2;
            if (this.a0 != null) {
                n(i2 != 0);
            }
            l(i2);
        }
    }

    /* access modifiers changed from: package-private */
    public f u(int i2) {
        for (int i3 = 0; i3 < this.f1863c.size(); i3++) {
            f fVar = this.f1863c.get(i3);
            if (fVar.f1876b == i2) {
                return fVar;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void v() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.f1871k = new Scroller(context, i0);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.C = viewConfiguration.getScaledPagingTouchSlop();
        this.J = (int) (400.0f * f2);
        this.K = viewConfiguration.getScaledMaximumFlingVelocity();
        this.O = new EdgeEffect(context);
        this.P = new EdgeEffect(context);
        this.L = (int) (25.0f * f2);
        this.M = (int) (2.0f * f2);
        this.A = (int) (f2 * 16.0f);
        u.m0(this, new h());
        if (u.z(this) == 0) {
            u.x0(this, 1);
        }
        u.z0(this, new d());
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.o;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0064  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void y(int r13, float r14, int r15) {
        /*
        // Method dump skipped, instructions count: 162
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.y(int, float, int):void");
    }

    public static class g extends ViewGroup.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public boolean f1880a;

        /* renamed from: b  reason: collision with root package name */
        public int f1881b;

        /* renamed from: c  reason: collision with root package name */
        float f1882c = Utils.FLOAT_EPSILON;

        /* renamed from: d  reason: collision with root package name */
        boolean f1883d;

        /* renamed from: e  reason: collision with root package name */
        int f1884e;

        /* renamed from: f  reason: collision with root package name */
        int f1885f;

        public g() {
            super(-1, -1);
        }

        public g(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.g0);
            this.f1881b = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new g(getContext(), attributeSet);
    }

    public void setPageMarginDrawable(int i2) {
        setPageMarginDrawable(b.h.d.a.d(getContext(), i2));
    }
}
