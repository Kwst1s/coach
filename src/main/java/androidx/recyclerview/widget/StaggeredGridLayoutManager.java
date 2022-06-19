package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import b.h.k.d0.c;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class StaggeredGridLayoutManager extends RecyclerView.o implements RecyclerView.z.b {
    boolean A = false;
    private BitSet B;
    int C = -1;
    int D = Integer.MIN_VALUE;
    d E = new d();
    private int F = 2;
    private boolean G;
    private boolean H;
    private e I;
    private int J;
    private final Rect K = new Rect();
    private final b L = new b();
    private boolean M = false;
    private boolean N = true;
    private int[] O;
    private final Runnable P = new a();
    private int s = -1;
    f[] t;
    m u;
    m v;
    private int w;
    private int x;
    private final i y;
    boolean z = false;

    class a implements Runnable {
        a() {
        }

        public void run() {
            StaggeredGridLayoutManager.this.T1();
        }
    }

    /* access modifiers changed from: package-private */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        int f1643a;

        /* renamed from: b  reason: collision with root package name */
        int f1644b;

        /* renamed from: c  reason: collision with root package name */
        boolean f1645c;

        /* renamed from: d  reason: collision with root package name */
        boolean f1646d;

        /* renamed from: e  reason: collision with root package name */
        boolean f1647e;

        /* renamed from: f  reason: collision with root package name */
        int[] f1648f;

        b() {
            c();
        }

        /* access modifiers changed from: package-private */
        public void a() {
            int i2;
            if (this.f1645c) {
                i2 = StaggeredGridLayoutManager.this.u.i();
            } else {
                i2 = StaggeredGridLayoutManager.this.u.m();
            }
            this.f1644b = i2;
        }

        /* access modifiers changed from: package-private */
        public void b(int i2) {
            if (this.f1645c) {
                this.f1644b = StaggeredGridLayoutManager.this.u.i() - i2;
            } else {
                this.f1644b = StaggeredGridLayoutManager.this.u.m() + i2;
            }
        }

        /* access modifiers changed from: package-private */
        public void c() {
            this.f1643a = -1;
            this.f1644b = Integer.MIN_VALUE;
            this.f1645c = false;
            this.f1646d = false;
            this.f1647e = false;
            int[] iArr = this.f1648f;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }

        /* access modifiers changed from: package-private */
        public void d(f[] fVarArr) {
            int length = fVarArr.length;
            int[] iArr = this.f1648f;
            if (iArr == null || iArr.length < length) {
                this.f1648f = new int[StaggeredGridLayoutManager.this.t.length];
            }
            for (int i2 = 0; i2 < length; i2++) {
                this.f1648f[i2] = fVarArr[i2].p(Integer.MIN_VALUE);
            }
        }
    }

    public static class c extends RecyclerView.p {

        /* renamed from: e  reason: collision with root package name */
        f f1650e;

        /* renamed from: f  reason: collision with root package name */
        boolean f1651f;

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public final int e() {
            f fVar = this.f1650e;
            if (fVar == null) {
                return -1;
            }
            return fVar.f1672e;
        }

        public boolean f() {
            return this.f1651f;
        }

        public c(int i2, int i3) {
            super(i2, i3);
        }

        public c(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    public static class e implements Parcelable {
        public static final Parcelable.Creator<e> CREATOR = new a();

        /* renamed from: b  reason: collision with root package name */
        int f1658b;

        /* renamed from: c  reason: collision with root package name */
        int f1659c;

        /* renamed from: d  reason: collision with root package name */
        int f1660d;

        /* renamed from: e  reason: collision with root package name */
        int[] f1661e;

        /* renamed from: f  reason: collision with root package name */
        int f1662f;

        /* renamed from: g  reason: collision with root package name */
        int[] f1663g;

        /* renamed from: h  reason: collision with root package name */
        List<d.a> f1664h;

        /* renamed from: i  reason: collision with root package name */
        boolean f1665i;

        /* renamed from: j  reason: collision with root package name */
        boolean f1666j;

        /* renamed from: k  reason: collision with root package name */
        boolean f1667k;

        static class a implements Parcelable.Creator<e> {
            a() {
            }

            /* renamed from: a */
            public e createFromParcel(Parcel parcel) {
                return new e(parcel);
            }

            /* renamed from: b */
            public e[] newArray(int i2) {
                return new e[i2];
            }
        }

        public e() {
        }

        public int describeContents() {
            return 0;
        }

        /* access modifiers changed from: package-private */
        public void g() {
            this.f1661e = null;
            this.f1660d = 0;
            this.f1658b = -1;
            this.f1659c = -1;
        }

        /* access modifiers changed from: package-private */
        public void k() {
            this.f1661e = null;
            this.f1660d = 0;
            this.f1662f = 0;
            this.f1663g = null;
            this.f1664h = null;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f1658b);
            parcel.writeInt(this.f1659c);
            parcel.writeInt(this.f1660d);
            if (this.f1660d > 0) {
                parcel.writeIntArray(this.f1661e);
            }
            parcel.writeInt(this.f1662f);
            if (this.f1662f > 0) {
                parcel.writeIntArray(this.f1663g);
            }
            parcel.writeInt(this.f1665i ? 1 : 0);
            parcel.writeInt(this.f1666j ? 1 : 0);
            parcel.writeInt(this.f1667k ? 1 : 0);
            parcel.writeList(this.f1664h);
        }

        e(Parcel parcel) {
            this.f1658b = parcel.readInt();
            this.f1659c = parcel.readInt();
            int readInt = parcel.readInt();
            this.f1660d = readInt;
            if (readInt > 0) {
                int[] iArr = new int[readInt];
                this.f1661e = iArr;
                parcel.readIntArray(iArr);
            }
            int readInt2 = parcel.readInt();
            this.f1662f = readInt2;
            if (readInt2 > 0) {
                int[] iArr2 = new int[readInt2];
                this.f1663g = iArr2;
                parcel.readIntArray(iArr2);
            }
            boolean z = false;
            this.f1665i = parcel.readInt() == 1;
            this.f1666j = parcel.readInt() == 1;
            this.f1667k = parcel.readInt() == 1 ? true : z;
            this.f1664h = parcel.readArrayList(d.a.class.getClassLoader());
        }

        public e(e eVar) {
            this.f1660d = eVar.f1660d;
            this.f1658b = eVar.f1658b;
            this.f1659c = eVar.f1659c;
            this.f1661e = eVar.f1661e;
            this.f1662f = eVar.f1662f;
            this.f1663g = eVar.f1663g;
            this.f1665i = eVar.f1665i;
            this.f1666j = eVar.f1666j;
            this.f1667k = eVar.f1667k;
            this.f1664h = eVar.f1664h;
        }
    }

    /* access modifiers changed from: package-private */
    public class f {

        /* renamed from: a  reason: collision with root package name */
        ArrayList<View> f1668a = new ArrayList<>();

        /* renamed from: b  reason: collision with root package name */
        int f1669b = Integer.MIN_VALUE;

        /* renamed from: c  reason: collision with root package name */
        int f1670c = Integer.MIN_VALUE;

        /* renamed from: d  reason: collision with root package name */
        int f1671d = 0;

        /* renamed from: e  reason: collision with root package name */
        final int f1672e;

        f(int i2) {
            this.f1672e = i2;
        }

        /* access modifiers changed from: package-private */
        public void a(View view) {
            c n = n(view);
            n.f1650e = this;
            this.f1668a.add(view);
            this.f1670c = Integer.MIN_VALUE;
            if (this.f1668a.size() == 1) {
                this.f1669b = Integer.MIN_VALUE;
            }
            if (n.c() || n.b()) {
                this.f1671d += StaggeredGridLayoutManager.this.u.e(view);
            }
        }

        /* access modifiers changed from: package-private */
        public void b(boolean z, int i2) {
            int i3;
            if (z) {
                i3 = l(Integer.MIN_VALUE);
            } else {
                i3 = p(Integer.MIN_VALUE);
            }
            e();
            if (i3 != Integer.MIN_VALUE) {
                if (z && i3 < StaggeredGridLayoutManager.this.u.i()) {
                    return;
                }
                if (z || i3 <= StaggeredGridLayoutManager.this.u.m()) {
                    if (i2 != Integer.MIN_VALUE) {
                        i3 += i2;
                    }
                    this.f1670c = i3;
                    this.f1669b = i3;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void c() {
            d.a f2;
            ArrayList<View> arrayList = this.f1668a;
            View view = arrayList.get(arrayList.size() - 1);
            c n = n(view);
            this.f1670c = StaggeredGridLayoutManager.this.u.d(view);
            if (n.f1651f && (f2 = StaggeredGridLayoutManager.this.E.f(n.a())) != null && f2.f1655c == 1) {
                this.f1670c += f2.g(this.f1672e);
            }
        }

        /* access modifiers changed from: package-private */
        public void d() {
            d.a f2;
            View view = this.f1668a.get(0);
            c n = n(view);
            this.f1669b = StaggeredGridLayoutManager.this.u.g(view);
            if (n.f1651f && (f2 = StaggeredGridLayoutManager.this.E.f(n.a())) != null && f2.f1655c == -1) {
                this.f1669b -= f2.g(this.f1672e);
            }
        }

        /* access modifiers changed from: package-private */
        public void e() {
            this.f1668a.clear();
            q();
            this.f1671d = 0;
        }

        public int f() {
            if (StaggeredGridLayoutManager.this.z) {
                return i(this.f1668a.size() - 1, -1, true);
            }
            return i(0, this.f1668a.size(), true);
        }

        public int g() {
            if (StaggeredGridLayoutManager.this.z) {
                return i(0, this.f1668a.size(), true);
            }
            return i(this.f1668a.size() - 1, -1, true);
        }

        /* access modifiers changed from: package-private */
        public int h(int i2, int i3, boolean z, boolean z2, boolean z3) {
            int m = StaggeredGridLayoutManager.this.u.m();
            int i4 = StaggeredGridLayoutManager.this.u.i();
            int i5 = i3 > i2 ? 1 : -1;
            while (i2 != i3) {
                View view = this.f1668a.get(i2);
                int g2 = StaggeredGridLayoutManager.this.u.g(view);
                int d2 = StaggeredGridLayoutManager.this.u.d(view);
                boolean z4 = false;
                boolean z5 = !z3 ? g2 < i4 : g2 <= i4;
                if (!z3 ? d2 > m : d2 >= m) {
                    z4 = true;
                }
                if (z5 && z4) {
                    if (!z || !z2) {
                        if (z2) {
                            return StaggeredGridLayoutManager.this.i0(view);
                        }
                        if (g2 < m || d2 > i4) {
                            return StaggeredGridLayoutManager.this.i0(view);
                        }
                    } else if (g2 >= m && d2 <= i4) {
                        return StaggeredGridLayoutManager.this.i0(view);
                    }
                }
                i2 += i5;
            }
            return -1;
        }

        /* access modifiers changed from: package-private */
        public int i(int i2, int i3, boolean z) {
            return h(i2, i3, false, false, z);
        }

        public int j() {
            return this.f1671d;
        }

        /* access modifiers changed from: package-private */
        public int k() {
            int i2 = this.f1670c;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            c();
            return this.f1670c;
        }

        /* access modifiers changed from: package-private */
        public int l(int i2) {
            int i3 = this.f1670c;
            if (i3 != Integer.MIN_VALUE) {
                return i3;
            }
            if (this.f1668a.size() == 0) {
                return i2;
            }
            c();
            return this.f1670c;
        }

        public View m(int i2, int i3) {
            View view = null;
            if (i3 != -1) {
                int size = this.f1668a.size() - 1;
                while (size >= 0) {
                    View view2 = this.f1668a.get(size);
                    StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager.z && staggeredGridLayoutManager.i0(view2) >= i2) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager2 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager2.z && staggeredGridLayoutManager2.i0(view2) <= i2) || !view2.hasFocusable()) {
                        break;
                    }
                    size--;
                    view = view2;
                }
            } else {
                int size2 = this.f1668a.size();
                int i4 = 0;
                while (i4 < size2) {
                    View view3 = this.f1668a.get(i4);
                    StaggeredGridLayoutManager staggeredGridLayoutManager3 = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager3.z && staggeredGridLayoutManager3.i0(view3) <= i2) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager4 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager4.z && staggeredGridLayoutManager4.i0(view3) >= i2) || !view3.hasFocusable()) {
                        break;
                    }
                    i4++;
                    view = view3;
                }
            }
            return view;
        }

        /* access modifiers changed from: package-private */
        public c n(View view) {
            return (c) view.getLayoutParams();
        }

        /* access modifiers changed from: package-private */
        public int o() {
            int i2 = this.f1669b;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            d();
            return this.f1669b;
        }

        /* access modifiers changed from: package-private */
        public int p(int i2) {
            int i3 = this.f1669b;
            if (i3 != Integer.MIN_VALUE) {
                return i3;
            }
            if (this.f1668a.size() == 0) {
                return i2;
            }
            d();
            return this.f1669b;
        }

        /* access modifiers changed from: package-private */
        public void q() {
            this.f1669b = Integer.MIN_VALUE;
            this.f1670c = Integer.MIN_VALUE;
        }

        /* access modifiers changed from: package-private */
        public void r(int i2) {
            int i3 = this.f1669b;
            if (i3 != Integer.MIN_VALUE) {
                this.f1669b = i3 + i2;
            }
            int i4 = this.f1670c;
            if (i4 != Integer.MIN_VALUE) {
                this.f1670c = i4 + i2;
            }
        }

        /* access modifiers changed from: package-private */
        public void s() {
            int size = this.f1668a.size();
            View remove = this.f1668a.remove(size - 1);
            c n = n(remove);
            n.f1650e = null;
            if (n.c() || n.b()) {
                this.f1671d -= StaggeredGridLayoutManager.this.u.e(remove);
            }
            if (size == 1) {
                this.f1669b = Integer.MIN_VALUE;
            }
            this.f1670c = Integer.MIN_VALUE;
        }

        /* access modifiers changed from: package-private */
        public void t() {
            View remove = this.f1668a.remove(0);
            c n = n(remove);
            n.f1650e = null;
            if (this.f1668a.size() == 0) {
                this.f1670c = Integer.MIN_VALUE;
            }
            if (n.c() || n.b()) {
                this.f1671d -= StaggeredGridLayoutManager.this.u.e(remove);
            }
            this.f1669b = Integer.MIN_VALUE;
        }

        /* access modifiers changed from: package-private */
        public void u(View view) {
            c n = n(view);
            n.f1650e = this;
            this.f1668a.add(0, view);
            this.f1669b = Integer.MIN_VALUE;
            if (this.f1668a.size() == 1) {
                this.f1670c = Integer.MIN_VALUE;
            }
            if (n.c() || n.b()) {
                this.f1671d += StaggeredGridLayoutManager.this.u.e(view);
            }
        }

        /* access modifiers changed from: package-private */
        public void v(int i2) {
            this.f1669b = i2;
            this.f1670c = i2;
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
        RecyclerView.o.d j0 = RecyclerView.o.j0(context, attributeSet, i2, i3);
        I2(j0.f1602a);
        K2(j0.f1603b);
        J2(j0.f1604c);
        this.y = new i();
        b2();
    }

    private void A2(View view) {
        for (int i2 = this.s - 1; i2 >= 0; i2--) {
            this.t[i2].u(view);
        }
    }

    private void B2(RecyclerView.v vVar, i iVar) {
        int i2;
        int i3;
        if (iVar.f1799a && !iVar.f1807i) {
            if (iVar.f1800b == 0) {
                if (iVar.f1803e == -1) {
                    C2(vVar, iVar.f1805g);
                } else {
                    D2(vVar, iVar.f1804f);
                }
            } else if (iVar.f1803e == -1) {
                int i4 = iVar.f1804f;
                int n2 = i4 - n2(i4);
                if (n2 < 0) {
                    i3 = iVar.f1805g;
                } else {
                    i3 = iVar.f1805g - Math.min(n2, iVar.f1800b);
                }
                C2(vVar, i3);
            } else {
                int o2 = o2(iVar.f1805g) - iVar.f1805g;
                if (o2 < 0) {
                    i2 = iVar.f1804f;
                } else {
                    i2 = Math.min(o2, iVar.f1800b) + iVar.f1804f;
                }
                D2(vVar, i2);
            }
        }
    }

    private void C2(RecyclerView.v vVar, int i2) {
        for (int K2 = K() - 1; K2 >= 0; K2--) {
            View J2 = J(K2);
            if (this.u.g(J2) >= i2 && this.u.q(J2) >= i2) {
                c cVar = (c) J2.getLayoutParams();
                if (cVar.f1651f) {
                    for (int i3 = 0; i3 < this.s; i3++) {
                        if (this.t[i3].f1668a.size() == 1) {
                            return;
                        }
                    }
                    for (int i4 = 0; i4 < this.s; i4++) {
                        this.t[i4].s();
                    }
                } else if (cVar.f1650e.f1668a.size() != 1) {
                    cVar.f1650e.s();
                } else {
                    return;
                }
                n1(J2, vVar);
            } else {
                return;
            }
        }
    }

    private void D2(RecyclerView.v vVar, int i2) {
        while (K() > 0) {
            View J2 = J(0);
            if (this.u.d(J2) <= i2 && this.u.p(J2) <= i2) {
                c cVar = (c) J2.getLayoutParams();
                if (cVar.f1651f) {
                    for (int i3 = 0; i3 < this.s; i3++) {
                        if (this.t[i3].f1668a.size() == 1) {
                            return;
                        }
                    }
                    for (int i4 = 0; i4 < this.s; i4++) {
                        this.t[i4].t();
                    }
                } else if (cVar.f1650e.f1668a.size() != 1) {
                    cVar.f1650e.t();
                } else {
                    return;
                }
                n1(J2, vVar);
            } else {
                return;
            }
        }
    }

    private void E2() {
        if (this.v.k() != 1073741824) {
            float f2 = Utils.FLOAT_EPSILON;
            int K2 = K();
            for (int i2 = 0; i2 < K2; i2++) {
                View J2 = J(i2);
                float e2 = (float) this.v.e(J2);
                if (e2 >= f2) {
                    if (((c) J2.getLayoutParams()).f()) {
                        e2 = (e2 * 1.0f) / ((float) this.s);
                    }
                    f2 = Math.max(f2, e2);
                }
            }
            int i3 = this.x;
            int round = Math.round(f2 * ((float) this.s));
            if (this.v.k() == Integer.MIN_VALUE) {
                round = Math.min(round, this.v.n());
            }
            Q2(round);
            if (this.x != i3) {
                for (int i4 = 0; i4 < K2; i4++) {
                    View J3 = J(i4);
                    c cVar = (c) J3.getLayoutParams();
                    if (!cVar.f1651f) {
                        if (!u2() || this.w != 1) {
                            int i5 = cVar.f1650e.f1672e;
                            int i6 = this.x * i5;
                            int i7 = i5 * i3;
                            if (this.w == 1) {
                                J3.offsetLeftAndRight(i6 - i7);
                            } else {
                                J3.offsetTopAndBottom(i6 - i7);
                            }
                        } else {
                            int i8 = this.s;
                            int i9 = cVar.f1650e.f1672e;
                            J3.offsetLeftAndRight(((-((i8 - 1) - i9)) * this.x) - ((-((i8 - 1) - i9)) * i3));
                        }
                    }
                }
            }
        }
    }

    private void F2() {
        if (this.w == 1 || !u2()) {
            this.A = this.z;
        } else {
            this.A = !this.z;
        }
    }

    private void H2(int i2) {
        i iVar = this.y;
        iVar.f1803e = i2;
        int i3 = 1;
        if (this.A != (i2 == -1)) {
            i3 = -1;
        }
        iVar.f1802d = i3;
    }

    private void L2(int i2, int i3) {
        for (int i4 = 0; i4 < this.s; i4++) {
            if (!this.t[i4].f1668a.isEmpty()) {
                R2(this.t[i4], i2, i3);
            }
        }
    }

    private boolean M2(RecyclerView.a0 a0Var, b bVar) {
        int i2;
        if (this.G) {
            i2 = h2(a0Var.b());
        } else {
            i2 = d2(a0Var.b());
        }
        bVar.f1643a = i2;
        bVar.f1644b = Integer.MIN_VALUE;
        return true;
    }

    private void N1(View view) {
        for (int i2 = this.s - 1; i2 >= 0; i2--) {
            this.t[i2].a(view);
        }
    }

    private void O1(b bVar) {
        int i2;
        e eVar = this.I;
        int i3 = eVar.f1660d;
        if (i3 > 0) {
            if (i3 == this.s) {
                for (int i4 = 0; i4 < this.s; i4++) {
                    this.t[i4].e();
                    e eVar2 = this.I;
                    int i5 = eVar2.f1661e[i4];
                    if (i5 != Integer.MIN_VALUE) {
                        if (eVar2.f1666j) {
                            i2 = this.u.i();
                        } else {
                            i2 = this.u.m();
                        }
                        i5 += i2;
                    }
                    this.t[i4].v(i5);
                }
            } else {
                eVar.k();
                e eVar3 = this.I;
                eVar3.f1658b = eVar3.f1659c;
            }
        }
        e eVar4 = this.I;
        this.H = eVar4.f1667k;
        J2(eVar4.f1665i);
        F2();
        e eVar5 = this.I;
        int i6 = eVar5.f1658b;
        if (i6 != -1) {
            this.C = i6;
            bVar.f1645c = eVar5.f1666j;
        } else {
            bVar.f1645c = this.A;
        }
        if (eVar5.f1662f > 1) {
            d dVar = this.E;
            dVar.f1652a = eVar5.f1663g;
            dVar.f1653b = eVar5.f1664h;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void P2(int r5, androidx.recyclerview.widget.RecyclerView.a0 r6) {
        /*
        // Method dump skipped, instructions count: 119
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.P2(int, androidx.recyclerview.widget.RecyclerView$a0):void");
    }

    private void R1(View view, c cVar, i iVar) {
        if (iVar.f1803e == 1) {
            if (cVar.f1651f) {
                N1(view);
            } else {
                cVar.f1650e.a(view);
            }
        } else if (cVar.f1651f) {
            A2(view);
        } else {
            cVar.f1650e.u(view);
        }
    }

    private void R2(f fVar, int i2, int i3) {
        int j2 = fVar.j();
        if (i2 == -1) {
            if (fVar.o() + j2 <= i3) {
                this.B.set(fVar.f1672e, false);
            }
        } else if (fVar.k() - j2 >= i3) {
            this.B.set(fVar.f1672e, false);
        }
    }

    private int S1(int i2) {
        if (K() != 0) {
            if ((i2 < k2()) != this.A) {
                return -1;
            }
            return 1;
        } else if (this.A) {
            return 1;
        } else {
            return -1;
        }
    }

    private int S2(int i2, int i3, int i4) {
        if (i3 == 0 && i4 == 0) {
            return i2;
        }
        int mode = View.MeasureSpec.getMode(i2);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            return View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i2) - i3) - i4), mode);
        }
        return i2;
    }

    private boolean U1(f fVar) {
        if (this.A) {
            if (fVar.k() < this.u.i()) {
                ArrayList<View> arrayList = fVar.f1668a;
                return !fVar.n(arrayList.get(arrayList.size() - 1)).f1651f;
            }
        } else if (fVar.o() > this.u.m()) {
            return !fVar.n(fVar.f1668a.get(0)).f1651f;
        }
        return false;
    }

    private int V1(RecyclerView.a0 a0Var) {
        if (K() == 0) {
            return 0;
        }
        return o.a(a0Var, this.u, f2(!this.N), e2(!this.N), this, this.N);
    }

    private int W1(RecyclerView.a0 a0Var) {
        if (K() == 0) {
            return 0;
        }
        return o.b(a0Var, this.u, f2(!this.N), e2(!this.N), this, this.N, this.A);
    }

    private int X1(RecyclerView.a0 a0Var) {
        if (K() == 0) {
            return 0;
        }
        return o.c(a0Var, this.u, f2(!this.N), e2(!this.N), this, this.N);
    }

    private int Y1(int i2) {
        if (i2 == 1) {
            return (this.w != 1 && u2()) ? 1 : -1;
        }
        if (i2 == 2) {
            return (this.w != 1 && u2()) ? -1 : 1;
        }
        if (i2 != 17) {
            if (i2 != 33) {
                if (i2 != 66) {
                    return (i2 == 130 && this.w == 1) ? 1 : Integer.MIN_VALUE;
                }
                if (this.w == 0) {
                    return 1;
                }
                return Integer.MIN_VALUE;
            } else if (this.w == 1) {
                return -1;
            } else {
                return Integer.MIN_VALUE;
            }
        } else if (this.w == 0) {
            return -1;
        } else {
            return Integer.MIN_VALUE;
        }
    }

    private d.a Z1(int i2) {
        d.a aVar = new d.a();
        aVar.f1656d = new int[this.s];
        for (int i3 = 0; i3 < this.s; i3++) {
            aVar.f1656d[i3] = i2 - this.t[i3].l(i2);
        }
        return aVar;
    }

    private d.a a2(int i2) {
        d.a aVar = new d.a();
        aVar.f1656d = new int[this.s];
        for (int i3 = 0; i3 < this.s; i3++) {
            aVar.f1656d[i3] = this.t[i3].p(i2) - i2;
        }
        return aVar;
    }

    private void b2() {
        this.u = m.b(this, this.w);
        this.v = m.b(this, 1 - this.w);
    }

    private int c2(RecyclerView.v vVar, i iVar, RecyclerView.a0 a0Var) {
        int i2;
        int i3;
        int i4;
        f fVar;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        boolean z2;
        int i11;
        int i12;
        int i13;
        boolean z3 = false;
        this.B.set(0, this.s, true);
        if (this.y.f1807i) {
            i2 = iVar.f1803e == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            if (iVar.f1803e == 1) {
                i13 = iVar.f1805g + iVar.f1800b;
            } else {
                i13 = iVar.f1804f - iVar.f1800b;
            }
            i2 = i13;
        }
        L2(iVar.f1803e, i2);
        if (this.A) {
            i3 = this.u.i();
        } else {
            i3 = this.u.m();
        }
        boolean z4 = false;
        while (iVar.a(a0Var) && (this.y.f1807i || !this.B.isEmpty())) {
            View b2 = iVar.b(vVar);
            c cVar = (c) b2.getLayoutParams();
            int a2 = cVar.a();
            int g2 = this.E.g(a2);
            boolean z5 = g2 == -1;
            if (z5) {
                if (cVar.f1651f) {
                    f[] fVarArr = this.t;
                    char c2 = z3 ? 1 : 0;
                    char c3 = z3 ? 1 : 0;
                    char c4 = z3 ? 1 : 0;
                    fVar = fVarArr[c2];
                } else {
                    fVar = q2(iVar);
                }
                this.E.n(a2, fVar);
            } else {
                fVar = this.t[g2];
            }
            cVar.f1650e = fVar;
            if (iVar.f1803e == 1) {
                e(b2);
            } else {
                int i14 = z3 ? 1 : 0;
                int i15 = z3 ? 1 : 0;
                int i16 = z3 ? 1 : 0;
                f(b2, i14);
            }
            w2(b2, cVar, z3);
            if (iVar.f1803e == 1) {
                if (cVar.f1651f) {
                    i12 = m2(i3);
                } else {
                    i12 = fVar.l(i3);
                }
                int e2 = this.u.e(b2) + i12;
                if (z5 && cVar.f1651f) {
                    d.a Z1 = Z1(i12);
                    Z1.f1655c = -1;
                    Z1.f1654b = a2;
                    this.E.a(Z1);
                }
                i5 = e2;
                i6 = i12;
            } else {
                if (cVar.f1651f) {
                    i11 = p2(i3);
                } else {
                    i11 = fVar.p(i3);
                }
                i6 = i11 - this.u.e(b2);
                if (z5 && cVar.f1651f) {
                    d.a a22 = a2(i11);
                    a22.f1655c = 1;
                    a22.f1654b = a2;
                    this.E.a(a22);
                }
                i5 = i11;
            }
            if (cVar.f1651f && iVar.f1802d == -1) {
                if (z5) {
                    this.M = true;
                } else {
                    if (iVar.f1803e == 1) {
                        z2 = P1();
                    } else {
                        z2 = Q1();
                    }
                    if (!z2) {
                        d.a f2 = this.E.f(a2);
                        if (f2 != null) {
                            f2.f1657e = true;
                        }
                        this.M = true;
                    }
                }
            }
            R1(b2, cVar, iVar);
            if (!u2() || this.w != 1) {
                if (cVar.f1651f) {
                    i9 = this.v.m();
                } else {
                    i9 = (fVar.f1672e * this.x) + this.v.m();
                }
                i8 = i9;
                i7 = this.v.e(b2) + i9;
            } else {
                if (cVar.f1651f) {
                    i10 = this.v.i();
                } else {
                    i10 = this.v.i() - (((this.s - 1) - fVar.f1672e) * this.x);
                }
                i7 = i10;
                i8 = i10 - this.v.e(b2);
            }
            if (this.w == 1) {
                A0(b2, i8, i6, i7, i5);
            } else {
                A0(b2, i6, i8, i5, i7);
            }
            if (cVar.f1651f) {
                L2(this.y.f1803e, i2);
            } else {
                R2(fVar, this.y.f1803e, i2);
            }
            B2(vVar, this.y);
            if (this.y.f1806h && b2.hasFocusable()) {
                if (cVar.f1651f) {
                    this.B.clear();
                } else {
                    this.B.set(fVar.f1672e, false);
                    z4 = true;
                    z3 = false;
                }
            }
            z4 = true;
            z3 = false;
        }
        if (!z4) {
            B2(vVar, this.y);
        }
        if (this.y.f1803e == -1) {
            i4 = this.u.m() - p2(this.u.m());
        } else {
            i4 = m2(this.u.i()) - this.u.i();
        }
        if (i4 > 0) {
            return Math.min(iVar.f1800b, i4);
        }
        return 0;
    }

    private int d2(int i2) {
        int K2 = K();
        for (int i3 = 0; i3 < K2; i3++) {
            int i0 = i0(J(i3));
            if (i0 >= 0 && i0 < i2) {
                return i0;
            }
        }
        return 0;
    }

    private int h2(int i2) {
        for (int K2 = K() - 1; K2 >= 0; K2--) {
            int i0 = i0(J(K2));
            if (i0 >= 0 && i0 < i2) {
                return i0;
            }
        }
        return 0;
    }

    private void i2(RecyclerView.v vVar, RecyclerView.a0 a0Var, boolean z2) {
        int i2;
        int m2 = m2(Integer.MIN_VALUE);
        if (m2 != Integer.MIN_VALUE && (i2 = this.u.i() - m2) > 0) {
            int i3 = i2 - (-G2(-i2, vVar, a0Var));
            if (z2 && i3 > 0) {
                this.u.r(i3);
            }
        }
    }

    private void j2(RecyclerView.v vVar, RecyclerView.a0 a0Var, boolean z2) {
        int m;
        int p2 = p2(Integer.MAX_VALUE);
        if (p2 != Integer.MAX_VALUE && (m = p2 - this.u.m()) > 0) {
            int G2 = m - G2(m, vVar, a0Var);
            if (z2 && G2 > 0) {
                this.u.r(-G2);
            }
        }
    }

    private int m2(int i2) {
        int l = this.t[0].l(i2);
        for (int i3 = 1; i3 < this.s; i3++) {
            int l2 = this.t[i3].l(i2);
            if (l2 > l) {
                l = l2;
            }
        }
        return l;
    }

    private int n2(int i2) {
        int p = this.t[0].p(i2);
        for (int i3 = 1; i3 < this.s; i3++) {
            int p2 = this.t[i3].p(i2);
            if (p2 > p) {
                p = p2;
            }
        }
        return p;
    }

    private int o2(int i2) {
        int l = this.t[0].l(i2);
        for (int i3 = 1; i3 < this.s; i3++) {
            int l2 = this.t[i3].l(i2);
            if (l2 < l) {
                l = l2;
            }
        }
        return l;
    }

    private int p2(int i2) {
        int p = this.t[0].p(i2);
        for (int i3 = 1; i3 < this.s; i3++) {
            int p2 = this.t[i3].p(i2);
            if (p2 < p) {
                p = p2;
            }
        }
        return p;
    }

    private f q2(i iVar) {
        int i2;
        int i3;
        int i4 = -1;
        if (y2(iVar.f1803e)) {
            i3 = this.s - 1;
            i2 = -1;
        } else {
            i3 = 0;
            i4 = this.s;
            i2 = 1;
        }
        f fVar = null;
        if (iVar.f1803e == 1) {
            int i5 = Integer.MAX_VALUE;
            int m = this.u.m();
            while (i3 != i4) {
                f fVar2 = this.t[i3];
                int l = fVar2.l(m);
                if (l < i5) {
                    fVar = fVar2;
                    i5 = l;
                }
                i3 += i2;
            }
            return fVar;
        }
        int i6 = Integer.MIN_VALUE;
        int i7 = this.u.i();
        while (i3 != i4) {
            f fVar3 = this.t[i3];
            int p = fVar3.p(i7);
            if (p > i6) {
                fVar = fVar3;
                i6 = p;
            }
            i3 += i2;
        }
        return fVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0043 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0044  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void r2(int r7, int r8, int r9) {
        /*
            r6 = this;
            boolean r0 = r6.A
            if (r0 == 0) goto L_0x0009
            int r0 = r6.l2()
            goto L_0x000d
        L_0x0009:
            int r0 = r6.k2()
        L_0x000d:
            r1 = 8
            if (r9 != r1) goto L_0x001a
            if (r7 >= r8) goto L_0x0016
            int r2 = r8 + 1
            goto L_0x001c
        L_0x0016:
            int r2 = r7 + 1
            r3 = r8
            goto L_0x001d
        L_0x001a:
            int r2 = r7 + r8
        L_0x001c:
            r3 = r7
        L_0x001d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r4 = r6.E
            r4.h(r3)
            r4 = 1
            if (r9 == r4) goto L_0x003c
            r5 = 2
            if (r9 == r5) goto L_0x0036
            if (r9 == r1) goto L_0x002b
            goto L_0x0041
        L_0x002b:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r9 = r6.E
            r9.k(r7, r4)
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r7 = r6.E
            r7.j(r8, r4)
            goto L_0x0041
        L_0x0036:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r9 = r6.E
            r9.k(r7, r8)
            goto L_0x0041
        L_0x003c:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r9 = r6.E
            r9.j(r7, r8)
        L_0x0041:
            if (r2 > r0) goto L_0x0044
            return
        L_0x0044:
            boolean r7 = r6.A
            if (r7 == 0) goto L_0x004d
            int r7 = r6.k2()
            goto L_0x0051
        L_0x004d:
            int r7 = r6.l2()
        L_0x0051:
            if (r3 > r7) goto L_0x0056
            r6.u1()
        L_0x0056:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.r2(int, int, int):void");
    }

    private void v2(View view, int i2, int i3, boolean z2) {
        boolean z3;
        k(view, this.K);
        c cVar = (c) view.getLayoutParams();
        int i4 = ((ViewGroup.MarginLayoutParams) cVar).leftMargin;
        Rect rect = this.K;
        int S2 = S2(i2, i4 + rect.left, ((ViewGroup.MarginLayoutParams) cVar).rightMargin + rect.right);
        int i5 = ((ViewGroup.MarginLayoutParams) cVar).topMargin;
        Rect rect2 = this.K;
        int S22 = S2(i3, i5 + rect2.top, ((ViewGroup.MarginLayoutParams) cVar).bottomMargin + rect2.bottom);
        if (z2) {
            z3 = I1(view, S2, S22, cVar);
        } else {
            z3 = G1(view, S2, S22, cVar);
        }
        if (z3) {
            view.measure(S2, S22);
        }
    }

    private void w2(View view, c cVar, boolean z2) {
        if (cVar.f1651f) {
            if (this.w == 1) {
                v2(view, this.J, RecyclerView.o.L(X(), Y(), h0() + e0(), ((ViewGroup.MarginLayoutParams) cVar).height, true), z2);
            } else {
                v2(view, RecyclerView.o.L(p0(), q0(), f0() + g0(), ((ViewGroup.MarginLayoutParams) cVar).width, true), this.J, z2);
            }
        } else if (this.w == 1) {
            v2(view, RecyclerView.o.L(this.x, q0(), 0, ((ViewGroup.MarginLayoutParams) cVar).width, false), RecyclerView.o.L(X(), Y(), h0() + e0(), ((ViewGroup.MarginLayoutParams) cVar).height, true), z2);
        } else {
            v2(view, RecyclerView.o.L(p0(), q0(), f0() + g0(), ((ViewGroup.MarginLayoutParams) cVar).width, true), RecyclerView.o.L(this.x, Y(), 0, ((ViewGroup.MarginLayoutParams) cVar).height, false), z2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0157, code lost:
        if (T1() != false) goto L_0x015b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void x2(androidx.recyclerview.widget.RecyclerView.v r9, androidx.recyclerview.widget.RecyclerView.a0 r10, boolean r11) {
        /*
        // Method dump skipped, instructions count: 379
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.x2(androidx.recyclerview.widget.RecyclerView$v, androidx.recyclerview.widget.RecyclerView$a0, boolean):void");
    }

    private boolean y2(int i2) {
        if (this.w == 0) {
            if ((i2 == -1) != this.A) {
                return true;
            }
            return false;
        }
        if (((i2 == -1) == this.A) == u2()) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void D0(int i2) {
        super.D0(i2);
        for (int i3 = 0; i3 < this.s; i3++) {
            this.t[i3].r(i2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void D1(Rect rect, int i2, int i3) {
        int i4;
        int i5;
        int f0 = f0() + g0();
        int h0 = h0() + e0();
        if (this.w == 1) {
            i5 = RecyclerView.o.o(i3, rect.height() + h0, c0());
            i4 = RecyclerView.o.o(i2, (this.x * this.s) + f0, d0());
        } else {
            i4 = RecyclerView.o.o(i2, rect.width() + f0, d0());
            i5 = RecyclerView.o.o(i3, (this.x * this.s) + h0, c0());
        }
        C1(i4, i5);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p E() {
        if (this.w == 0) {
            return new c(-2, -1);
        }
        return new c(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void E0(int i2) {
        super.E0(i2);
        for (int i3 = 0; i3 < this.s; i3++) {
            this.t[i3].r(i2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p F(Context context, AttributeSet attributeSet) {
        return new c(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p G(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new c((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new c(layoutParams);
    }

    /* access modifiers changed from: package-private */
    public int G2(int i2, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (K() == 0 || i2 == 0) {
            return 0;
        }
        z2(i2, a0Var);
        int c2 = c2(vVar, this.y, a0Var);
        if (this.y.f1800b >= c2) {
            i2 = i2 < 0 ? -c2 : c2;
        }
        this.u.r(-i2);
        this.G = this.A;
        i iVar = this.y;
        iVar.f1800b = 0;
        B2(vVar, iVar);
        return i2;
    }

    public void I2(int i2) {
        if (i2 == 0 || i2 == 1) {
            h(null);
            if (i2 != this.w) {
                this.w = i2;
                m mVar = this.u;
                this.u = this.v;
                this.v = mVar;
                u1();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation.");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void J0(RecyclerView recyclerView, RecyclerView.v vVar) {
        super.J0(recyclerView, vVar);
        p1(this.P);
        for (int i2 = 0; i2 < this.s; i2++) {
            this.t[i2].e();
        }
        recyclerView.requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void J1(RecyclerView recyclerView, RecyclerView.a0 a0Var, int i2) {
        j jVar = new j(recyclerView.getContext());
        jVar.p(i2);
        K1(jVar);
    }

    public void J2(boolean z2) {
        h(null);
        e eVar = this.I;
        if (!(eVar == null || eVar.f1665i == z2)) {
            eVar.f1665i = z2;
        }
        this.z = z2;
        u1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public View K0(View view, int i2, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        View C2;
        int i3;
        int i4;
        int i5;
        int i6;
        View m;
        if (K() == 0 || (C2 = C(view)) == null) {
            return null;
        }
        F2();
        int Y1 = Y1(i2);
        if (Y1 == Integer.MIN_VALUE) {
            return null;
        }
        c cVar = (c) C2.getLayoutParams();
        boolean z2 = cVar.f1651f;
        f fVar = cVar.f1650e;
        if (Y1 == 1) {
            i3 = l2();
        } else {
            i3 = k2();
        }
        P2(i3, a0Var);
        H2(Y1);
        i iVar = this.y;
        iVar.f1801c = iVar.f1802d + i3;
        iVar.f1800b = (int) (((float) this.u.n()) * 0.33333334f);
        i iVar2 = this.y;
        iVar2.f1806h = true;
        iVar2.f1799a = false;
        c2(vVar, iVar2, a0Var);
        this.G = this.A;
        if (!(z2 || (m = fVar.m(i3, Y1)) == null || m == C2)) {
            return m;
        }
        if (y2(Y1)) {
            for (int i7 = this.s - 1; i7 >= 0; i7--) {
                View m2 = this.t[i7].m(i3, Y1);
                if (!(m2 == null || m2 == C2)) {
                    return m2;
                }
            }
        } else {
            for (int i8 = 0; i8 < this.s; i8++) {
                View m3 = this.t[i8].m(i3, Y1);
                if (!(m3 == null || m3 == C2)) {
                    return m3;
                }
            }
        }
        boolean z3 = (this.z ^ true) == (Y1 == -1);
        if (!z2) {
            if (z3) {
                i6 = fVar.f();
            } else {
                i6 = fVar.g();
            }
            View D2 = D(i6);
            if (!(D2 == null || D2 == C2)) {
                return D2;
            }
        }
        if (y2(Y1)) {
            for (int i9 = this.s - 1; i9 >= 0; i9--) {
                if (i9 != fVar.f1672e) {
                    if (z3) {
                        i5 = this.t[i9].f();
                    } else {
                        i5 = this.t[i9].g();
                    }
                    View D3 = D(i5);
                    if (!(D3 == null || D3 == C2)) {
                        return D3;
                    }
                }
            }
        } else {
            for (int i10 = 0; i10 < this.s; i10++) {
                if (z3) {
                    i4 = this.t[i10].f();
                } else {
                    i4 = this.t[i10].g();
                }
                View D4 = D(i4);
                if (!(D4 == null || D4 == C2)) {
                    return D4;
                }
            }
        }
        return null;
    }

    public void K2(int i2) {
        h(null);
        if (i2 != this.s) {
            t2();
            this.s = i2;
            this.B = new BitSet(this.s);
            this.t = new f[this.s];
            for (int i3 = 0; i3 < this.s; i3++) {
                this.t[i3] = new f(i3);
            }
            u1();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void L0(AccessibilityEvent accessibilityEvent) {
        super.L0(accessibilityEvent);
        if (K() > 0) {
            View f2 = f2(false);
            View e2 = e2(false);
            if (f2 != null && e2 != null) {
                int i0 = i0(f2);
                int i02 = i0(e2);
                if (i0 < i02) {
                    accessibilityEvent.setFromIndex(i0);
                    accessibilityEvent.setToIndex(i02);
                    return;
                }
                accessibilityEvent.setFromIndex(i02);
                accessibilityEvent.setToIndex(i0);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean M1() {
        return this.I == null;
    }

    /* access modifiers changed from: package-private */
    public boolean N2(RecyclerView.a0 a0Var, b bVar) {
        int i2;
        int i3;
        int i4;
        boolean z2 = false;
        if (!a0Var.e() && (i2 = this.C) != -1) {
            if (i2 < 0 || i2 >= a0Var.b()) {
                this.C = -1;
                this.D = Integer.MIN_VALUE;
            } else {
                e eVar = this.I;
                if (eVar == null || eVar.f1658b == -1 || eVar.f1660d < 1) {
                    View D2 = D(this.C);
                    if (D2 != null) {
                        if (this.A) {
                            i3 = l2();
                        } else {
                            i3 = k2();
                        }
                        bVar.f1643a = i3;
                        if (this.D != Integer.MIN_VALUE) {
                            if (bVar.f1645c) {
                                bVar.f1644b = (this.u.i() - this.D) - this.u.d(D2);
                            } else {
                                bVar.f1644b = (this.u.m() + this.D) - this.u.g(D2);
                            }
                            return true;
                        } else if (this.u.e(D2) > this.u.n()) {
                            if (bVar.f1645c) {
                                i4 = this.u.i();
                            } else {
                                i4 = this.u.m();
                            }
                            bVar.f1644b = i4;
                            return true;
                        } else {
                            int g2 = this.u.g(D2) - this.u.m();
                            if (g2 < 0) {
                                bVar.f1644b = -g2;
                                return true;
                            }
                            int i5 = this.u.i() - this.u.d(D2);
                            if (i5 < 0) {
                                bVar.f1644b = i5;
                                return true;
                            }
                            bVar.f1644b = Integer.MIN_VALUE;
                        }
                    } else {
                        int i6 = this.C;
                        bVar.f1643a = i6;
                        int i7 = this.D;
                        if (i7 == Integer.MIN_VALUE) {
                            if (S1(i6) == 1) {
                                z2 = true;
                            }
                            bVar.f1645c = z2;
                            bVar.a();
                        } else {
                            bVar.b(i7);
                        }
                        bVar.f1646d = true;
                    }
                } else {
                    bVar.f1644b = Integer.MIN_VALUE;
                    bVar.f1643a = this.C;
                }
                return true;
            }
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int O(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (this.w == 1) {
            return this.s;
        }
        return super.O(vVar, a0Var);
    }

    /* access modifiers changed from: package-private */
    public void O2(RecyclerView.a0 a0Var, b bVar) {
        if (!N2(a0Var, bVar) && !M2(a0Var, bVar)) {
            bVar.a();
            bVar.f1643a = 0;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean P1() {
        int l = this.t[0].l(Integer.MIN_VALUE);
        for (int i2 = 1; i2 < this.s; i2++) {
            if (this.t[i2].l(Integer.MIN_VALUE) != l) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void Q0(RecyclerView.v vVar, RecyclerView.a0 a0Var, View view, b.h.k.d0.c cVar) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof c)) {
            super.P0(view, cVar);
            return;
        }
        c cVar2 = (c) layoutParams;
        if (this.w == 0) {
            cVar.d0(c.C0048c.a(cVar2.e(), cVar2.f1651f ? this.s : 1, -1, -1, false, false));
        } else {
            cVar.d0(c.C0048c.a(-1, -1, cVar2.e(), cVar2.f1651f ? this.s : 1, false, false));
        }
    }

    /* access modifiers changed from: package-private */
    public boolean Q1() {
        int p = this.t[0].p(Integer.MIN_VALUE);
        for (int i2 = 1; i2 < this.s; i2++) {
            if (this.t[i2].p(Integer.MIN_VALUE) != p) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void Q2(int i2) {
        this.x = i2 / this.s;
        this.J = View.MeasureSpec.makeMeasureSpec(i2, this.v.k());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void S0(RecyclerView recyclerView, int i2, int i3) {
        r2(i2, i3, 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void T0(RecyclerView recyclerView) {
        this.E.b();
        u1();
    }

    /* access modifiers changed from: package-private */
    public boolean T1() {
        int i2;
        int i3;
        if (K() == 0 || this.F == 0 || !s0()) {
            return false;
        }
        if (this.A) {
            i3 = l2();
            i2 = k2();
        } else {
            i3 = k2();
            i2 = l2();
        }
        if (i3 == 0 && s2() != null) {
            this.E.b();
            v1();
            u1();
            return true;
        } else if (!this.M) {
            return false;
        } else {
            int i4 = this.A ? -1 : 1;
            int i5 = i2 + 1;
            d.a e2 = this.E.e(i3, i5, i4, true);
            if (e2 == null) {
                this.M = false;
                this.E.d(i5);
                return false;
            }
            d.a e3 = this.E.e(i3, e2.f1654b, i4 * -1, true);
            if (e3 == null) {
                this.E.d(e2.f1654b);
            } else {
                this.E.d(e3.f1654b + 1);
            }
            v1();
            u1();
            return true;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void U0(RecyclerView recyclerView, int i2, int i3, int i4) {
        r2(i2, i3, 8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void V0(RecyclerView recyclerView, int i2, int i3) {
        r2(i2, i3, 2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void X0(RecyclerView recyclerView, int i2, int i3, Object obj) {
        r2(i2, i3, 4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void Y0(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        x2(vVar, a0Var, true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void Z0(RecyclerView.a0 a0Var) {
        super.Z0(a0Var);
        this.C = -1;
        this.D = Integer.MIN_VALUE;
        this.I = null;
        this.L.c();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.z.b
    public PointF a(int i2) {
        int S1 = S1(i2);
        PointF pointF = new PointF();
        if (S1 == 0) {
            return null;
        }
        if (this.w == 0) {
            pointF.x = (float) S1;
            pointF.y = Utils.FLOAT_EPSILON;
        } else {
            pointF.x = Utils.FLOAT_EPSILON;
            pointF.y = (float) S1;
        }
        return pointF;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void d1(Parcelable parcelable) {
        if (parcelable instanceof e) {
            this.I = (e) parcelable;
            u1();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public Parcelable e1() {
        int i2;
        int i3;
        int i4;
        int[] iArr;
        if (this.I != null) {
            return new e(this.I);
        }
        e eVar = new e();
        eVar.f1665i = this.z;
        eVar.f1666j = this.G;
        eVar.f1667k = this.H;
        d dVar = this.E;
        if (dVar == null || (iArr = dVar.f1652a) == null) {
            eVar.f1662f = 0;
        } else {
            eVar.f1663g = iArr;
            eVar.f1662f = iArr.length;
            eVar.f1664h = dVar.f1653b;
        }
        if (K() > 0) {
            if (this.G) {
                i2 = l2();
            } else {
                i2 = k2();
            }
            eVar.f1658b = i2;
            eVar.f1659c = g2();
            int i5 = this.s;
            eVar.f1660d = i5;
            eVar.f1661e = new int[i5];
            for (int i6 = 0; i6 < this.s; i6++) {
                if (this.G) {
                    i3 = this.t[i6].l(Integer.MIN_VALUE);
                    if (i3 != Integer.MIN_VALUE) {
                        i4 = this.u.i();
                    } else {
                        eVar.f1661e[i6] = i3;
                    }
                } else {
                    i3 = this.t[i6].p(Integer.MIN_VALUE);
                    if (i3 != Integer.MIN_VALUE) {
                        i4 = this.u.m();
                    } else {
                        eVar.f1661e[i6] = i3;
                    }
                }
                i3 -= i4;
                eVar.f1661e[i6] = i3;
            }
        } else {
            eVar.f1658b = -1;
            eVar.f1659c = -1;
            eVar.f1660d = 0;
        }
        return eVar;
    }

    /* access modifiers changed from: package-private */
    public View e2(boolean z2) {
        int m = this.u.m();
        int i2 = this.u.i();
        View view = null;
        for (int K2 = K() - 1; K2 >= 0; K2--) {
            View J2 = J(K2);
            int g2 = this.u.g(J2);
            int d2 = this.u.d(J2);
            if (d2 > m && g2 < i2) {
                if (d2 <= i2 || !z2) {
                    return J2;
                }
                if (view == null) {
                    view = J2;
                }
            }
        }
        return view;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void f1(int i2) {
        if (i2 == 0) {
            T1();
        }
    }

    /* access modifiers changed from: package-private */
    public View f2(boolean z2) {
        int m = this.u.m();
        int i2 = this.u.i();
        int K2 = K();
        View view = null;
        for (int i3 = 0; i3 < K2; i3++) {
            View J2 = J(i3);
            int g2 = this.u.g(J2);
            if (this.u.d(J2) > m && g2 < i2) {
                if (g2 >= m || !z2) {
                    return J2;
                }
                if (view == null) {
                    view = J2;
                }
            }
        }
        return view;
    }

    /* access modifiers changed from: package-private */
    public int g2() {
        View view;
        if (this.A) {
            view = e2(true);
        } else {
            view = f2(true);
        }
        if (view == null) {
            return -1;
        }
        return i0(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void h(String str) {
        if (this.I == null) {
            super.h(str);
        }
    }

    /* access modifiers changed from: package-private */
    public int k2() {
        if (K() == 0) {
            return 0;
        }
        return i0(J(0));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean l() {
        return this.w == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int l0(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (this.w == 0) {
            return this.s;
        }
        return super.l0(vVar, a0Var);
    }

    /* access modifiers changed from: package-private */
    public int l2() {
        int K2 = K();
        if (K2 == 0) {
            return 0;
        }
        return i0(J(K2 - 1));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean m() {
        return this.w == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean n(RecyclerView.p pVar) {
        return pVar instanceof c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void p(int i2, int i3, RecyclerView.a0 a0Var, RecyclerView.o.c cVar) {
        int i4;
        int i5;
        if (this.w != 0) {
            i2 = i3;
        }
        if (!(K() == 0 || i2 == 0)) {
            z2(i2, a0Var);
            int[] iArr = this.O;
            if (iArr == null || iArr.length < this.s) {
                this.O = new int[this.s];
            }
            int i6 = 0;
            for (int i7 = 0; i7 < this.s; i7++) {
                i iVar = this.y;
                if (iVar.f1802d == -1) {
                    i5 = iVar.f1804f;
                    i4 = this.t[i7].p(i5);
                } else {
                    i5 = this.t[i7].l(iVar.f1805g);
                    i4 = this.y.f1805g;
                }
                int i8 = i5 - i4;
                if (i8 >= 0) {
                    this.O[i6] = i8;
                    i6++;
                }
            }
            Arrays.sort(this.O, 0, i6);
            for (int i9 = 0; i9 < i6 && this.y.a(a0Var); i9++) {
                cVar.a(this.y.f1801c, this.O[i9]);
                i iVar2 = this.y;
                iVar2.f1801c += iVar2.f1802d;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int r(RecyclerView.a0 a0Var) {
        return V1(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int s(RecyclerView.a0 a0Var) {
        return W1(a0Var);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0074, code lost:
        if (r10 == r11) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0086, code lost:
        if (r10 == r11) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x008a, code lost:
        r10 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View s2() {
        /*
        // Method dump skipped, instructions count: 173
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.s2():android.view.View");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int t(RecyclerView.a0 a0Var) {
        return X1(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean t0() {
        return this.F != 0;
    }

    public void t2() {
        this.E.b();
        u1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int u(RecyclerView.a0 a0Var) {
        return V1(a0Var);
    }

    /* access modifiers changed from: package-private */
    public boolean u2() {
        return a0() == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int v(RecyclerView.a0 a0Var) {
        return W1(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int w(RecyclerView.a0 a0Var) {
        return X1(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int x1(int i2, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return G2(i2, vVar, a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void y1(int i2) {
        e eVar = this.I;
        if (!(eVar == null || eVar.f1658b == i2)) {
            eVar.g();
        }
        this.C = i2;
        this.D = Integer.MIN_VALUE;
        u1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int z1(int i2, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return G2(i2, vVar, a0Var);
    }

    /* access modifiers changed from: package-private */
    public void z2(int i2, RecyclerView.a0 a0Var) {
        int i3;
        int i4;
        if (i2 > 0) {
            i4 = l2();
            i3 = 1;
        } else {
            i4 = k2();
            i3 = -1;
        }
        this.y.f1799a = true;
        P2(i4, a0Var);
        H2(i3);
        i iVar = this.y;
        iVar.f1801c = i4 + iVar.f1802d;
        iVar.f1800b = Math.abs(i2);
    }

    /* access modifiers changed from: package-private */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        int[] f1652a;

        /* renamed from: b  reason: collision with root package name */
        List<a> f1653b;

        d() {
        }

        private int i(int i2) {
            if (this.f1653b == null) {
                return -1;
            }
            a f2 = f(i2);
            if (f2 != null) {
                this.f1653b.remove(f2);
            }
            int size = this.f1653b.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    i3 = -1;
                    break;
                } else if (this.f1653b.get(i3).f1654b >= i2) {
                    break;
                } else {
                    i3++;
                }
            }
            if (i3 == -1) {
                return -1;
            }
            this.f1653b.remove(i3);
            return this.f1653b.get(i3).f1654b;
        }

        private void l(int i2, int i3) {
            List<a> list = this.f1653b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    a aVar = this.f1653b.get(size);
                    int i4 = aVar.f1654b;
                    if (i4 >= i2) {
                        aVar.f1654b = i4 + i3;
                    }
                }
            }
        }

        private void m(int i2, int i3) {
            List<a> list = this.f1653b;
            if (list != null) {
                int i4 = i2 + i3;
                for (int size = list.size() - 1; size >= 0; size--) {
                    a aVar = this.f1653b.get(size);
                    int i5 = aVar.f1654b;
                    if (i5 >= i2) {
                        if (i5 < i4) {
                            this.f1653b.remove(size);
                        } else {
                            aVar.f1654b = i5 - i3;
                        }
                    }
                }
            }
        }

        public void a(a aVar) {
            if (this.f1653b == null) {
                this.f1653b = new ArrayList();
            }
            int size = this.f1653b.size();
            for (int i2 = 0; i2 < size; i2++) {
                a aVar2 = this.f1653b.get(i2);
                if (aVar2.f1654b == aVar.f1654b) {
                    this.f1653b.remove(i2);
                }
                if (aVar2.f1654b >= aVar.f1654b) {
                    this.f1653b.add(i2, aVar);
                    return;
                }
            }
            this.f1653b.add(aVar);
        }

        /* access modifiers changed from: package-private */
        public void b() {
            int[] iArr = this.f1652a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f1653b = null;
        }

        /* access modifiers changed from: package-private */
        public void c(int i2) {
            int[] iArr = this.f1652a;
            if (iArr == null) {
                int[] iArr2 = new int[(Math.max(i2, 10) + 1)];
                this.f1652a = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i2 >= iArr.length) {
                int[] iArr3 = new int[o(i2)];
                this.f1652a = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                int[] iArr4 = this.f1652a;
                Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
            }
        }

        /* access modifiers changed from: package-private */
        public int d(int i2) {
            List<a> list = this.f1653b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (this.f1653b.get(size).f1654b >= i2) {
                        this.f1653b.remove(size);
                    }
                }
            }
            return h(i2);
        }

        public a e(int i2, int i3, int i4, boolean z) {
            List<a> list = this.f1653b;
            if (list == null) {
                return null;
            }
            int size = list.size();
            for (int i5 = 0; i5 < size; i5++) {
                a aVar = this.f1653b.get(i5);
                int i6 = aVar.f1654b;
                if (i6 >= i3) {
                    return null;
                }
                if (i6 >= i2 && (i4 == 0 || aVar.f1655c == i4 || (z && aVar.f1657e))) {
                    return aVar;
                }
            }
            return null;
        }

        public a f(int i2) {
            List<a> list = this.f1653b;
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = this.f1653b.get(size);
                if (aVar.f1654b == i2) {
                    return aVar;
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public int g(int i2) {
            int[] iArr = this.f1652a;
            if (iArr == null || i2 >= iArr.length) {
                return -1;
            }
            return iArr[i2];
        }

        /* access modifiers changed from: package-private */
        public int h(int i2) {
            int[] iArr = this.f1652a;
            if (iArr == null || i2 >= iArr.length) {
                return -1;
            }
            int i3 = i(i2);
            if (i3 == -1) {
                int[] iArr2 = this.f1652a;
                Arrays.fill(iArr2, i2, iArr2.length, -1);
                return this.f1652a.length;
            }
            int i4 = i3 + 1;
            Arrays.fill(this.f1652a, i2, i4, -1);
            return i4;
        }

        /* access modifiers changed from: package-private */
        public void j(int i2, int i3) {
            int[] iArr = this.f1652a;
            if (iArr != null && i2 < iArr.length) {
                int i4 = i2 + i3;
                c(i4);
                int[] iArr2 = this.f1652a;
                System.arraycopy(iArr2, i2, iArr2, i4, (iArr2.length - i2) - i3);
                Arrays.fill(this.f1652a, i2, i4, -1);
                l(i2, i3);
            }
        }

        /* access modifiers changed from: package-private */
        public void k(int i2, int i3) {
            int[] iArr = this.f1652a;
            if (iArr != null && i2 < iArr.length) {
                int i4 = i2 + i3;
                c(i4);
                int[] iArr2 = this.f1652a;
                System.arraycopy(iArr2, i4, iArr2, i2, (iArr2.length - i2) - i3);
                int[] iArr3 = this.f1652a;
                Arrays.fill(iArr3, iArr3.length - i3, iArr3.length, -1);
                m(i2, i3);
            }
        }

        /* access modifiers changed from: package-private */
        public void n(int i2, f fVar) {
            c(i2);
            this.f1652a[i2] = fVar.f1672e;
        }

        /* access modifiers changed from: package-private */
        public int o(int i2) {
            int length = this.f1652a.length;
            while (length <= i2) {
                length *= 2;
            }
            return length;
        }

        /* access modifiers changed from: package-private */
        @SuppressLint({"BanParcelableUsage"})
        public static class a implements Parcelable {
            public static final Parcelable.Creator<a> CREATOR = new C0022a();

            /* renamed from: b  reason: collision with root package name */
            int f1654b;

            /* renamed from: c  reason: collision with root package name */
            int f1655c;

            /* renamed from: d  reason: collision with root package name */
            int[] f1656d;

            /* renamed from: e  reason: collision with root package name */
            boolean f1657e;

            /* renamed from: androidx.recyclerview.widget.StaggeredGridLayoutManager$d$a$a  reason: collision with other inner class name */
            static class C0022a implements Parcelable.Creator<a> {
                C0022a() {
                }

                /* renamed from: a */
                public a createFromParcel(Parcel parcel) {
                    return new a(parcel);
                }

                /* renamed from: b */
                public a[] newArray(int i2) {
                    return new a[i2];
                }
            }

            a(Parcel parcel) {
                this.f1654b = parcel.readInt();
                this.f1655c = parcel.readInt();
                this.f1657e = parcel.readInt() != 1 ? false : true;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    int[] iArr = new int[readInt];
                    this.f1656d = iArr;
                    parcel.readIntArray(iArr);
                }
            }

            public int describeContents() {
                return 0;
            }

            /* access modifiers changed from: package-private */
            public int g(int i2) {
                int[] iArr = this.f1656d;
                if (iArr == null) {
                    return 0;
                }
                return iArr[i2];
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.f1654b + ", mGapDir=" + this.f1655c + ", mHasUnwantedGapAfter=" + this.f1657e + ", mGapPerSpan=" + Arrays.toString(this.f1656d) + '}';
            }

            public void writeToParcel(Parcel parcel, int i2) {
                parcel.writeInt(this.f1654b);
                parcel.writeInt(this.f1655c);
                parcel.writeInt(this.f1657e ? 1 : 0);
                int[] iArr = this.f1656d;
                if (iArr == null || iArr.length <= 0) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(iArr.length);
                parcel.writeIntArray(this.f1656d);
            }

            a() {
            }
        }
    }
}
