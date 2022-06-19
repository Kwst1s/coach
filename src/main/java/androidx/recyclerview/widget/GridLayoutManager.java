package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.h.k.d0.c;

public class GridLayoutManager extends LinearLayoutManager {
    boolean I = false;
    int J = -1;
    int[] K;
    View[] L;
    final SparseIntArray M = new SparseIntArray();
    final SparseIntArray N = new SparseIntArray();
    c O = new a();
    final Rect P = new Rect();
    private boolean Q;

    public static final class a extends c {
        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int e(int i2, int i3) {
            return i2 % i3;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int f(int i2) {
            return 1;
        }
    }

    public static abstract class c {

        /* renamed from: a  reason: collision with root package name */
        final SparseIntArray f1507a = new SparseIntArray();

        /* renamed from: b  reason: collision with root package name */
        final SparseIntArray f1508b = new SparseIntArray();

        /* renamed from: c  reason: collision with root package name */
        private boolean f1509c = false;

        /* renamed from: d  reason: collision with root package name */
        private boolean f1510d = false;

        static int a(SparseIntArray sparseIntArray, int i2) {
            int size = sparseIntArray.size() - 1;
            int i3 = 0;
            while (i3 <= size) {
                int i4 = (i3 + size) >>> 1;
                if (sparseIntArray.keyAt(i4) < i2) {
                    i3 = i4 + 1;
                } else {
                    size = i4 - 1;
                }
            }
            int i5 = i3 - 1;
            if (i5 < 0 || i5 >= sparseIntArray.size()) {
                return -1;
            }
            return sparseIntArray.keyAt(i5);
        }

        /* access modifiers changed from: package-private */
        public int b(int i2, int i3) {
            if (!this.f1510d) {
                return d(i2, i3);
            }
            int i4 = this.f1508b.get(i2, -1);
            if (i4 != -1) {
                return i4;
            }
            int d2 = d(i2, i3);
            this.f1508b.put(i2, d2);
            return d2;
        }

        /* access modifiers changed from: package-private */
        public int c(int i2, int i3) {
            if (!this.f1509c) {
                return e(i2, i3);
            }
            int i4 = this.f1507a.get(i2, -1);
            if (i4 != -1) {
                return i4;
            }
            int e2 = e(i2, i3);
            this.f1507a.put(i2, e2);
            return e2;
        }

        /* JADX WARNING: Removed duplicated region for block: B:11:0x002d  */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0043  */
        /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int d(int r7, int r8) {
            /*
                r6 = this;
                boolean r0 = r6.f1510d
                r1 = 0
                if (r0 == 0) goto L_0x0024
                android.util.SparseIntArray r0 = r6.f1508b
                int r0 = a(r0, r7)
                r2 = -1
                if (r0 == r2) goto L_0x0024
                android.util.SparseIntArray r2 = r6.f1508b
                int r2 = r2.get(r0)
                int r3 = r0 + 1
                int r4 = r6.c(r0, r8)
                int r0 = r6.f(r0)
                int r4 = r4 + r0
                if (r4 != r8) goto L_0x0027
                int r2 = r2 + 1
                goto L_0x0026
            L_0x0024:
                r2 = 0
                r3 = 0
            L_0x0026:
                r4 = 0
            L_0x0027:
                int r0 = r6.f(r7)
            L_0x002b:
                if (r3 >= r7) goto L_0x0040
                int r5 = r6.f(r3)
                int r4 = r4 + r5
                if (r4 != r8) goto L_0x0038
                int r2 = r2 + 1
                r4 = 0
                goto L_0x003d
            L_0x0038:
                if (r4 <= r8) goto L_0x003d
                int r2 = r2 + 1
                r4 = r5
            L_0x003d:
                int r3 = r3 + 1
                goto L_0x002b
            L_0x0040:
                int r4 = r4 + r0
                if (r4 <= r8) goto L_0x0045
                int r2 = r2 + 1
            L_0x0045:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.c.d(int, int):int");
        }

        public abstract int e(int i2, int i3);

        public abstract int f(int i2);

        public void g() {
            this.f1508b.clear();
        }

        public void h() {
            this.f1507a.clear();
        }
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        g3(RecyclerView.o.j0(context, attributeSet, i2, i3).f1603b);
    }

    private void P2(RecyclerView.v vVar, RecyclerView.a0 a0Var, int i2, boolean z) {
        int i3;
        int i4;
        int i5 = 0;
        int i6 = -1;
        if (z) {
            i6 = i2;
            i4 = 0;
            i3 = 1;
        } else {
            i4 = i2 - 1;
            i3 = -1;
        }
        while (i4 != i6) {
            View view = this.L[i4];
            b bVar = (b) view.getLayoutParams();
            int c3 = c3(vVar, a0Var, i0(view));
            bVar.f1506f = c3;
            bVar.f1505e = i5;
            i5 += c3;
            i4 += i3;
        }
    }

    private void Q2() {
        int K2 = K();
        for (int i2 = 0; i2 < K2; i2++) {
            b bVar = (b) J(i2).getLayoutParams();
            int a2 = bVar.a();
            this.M.put(a2, bVar.f());
            this.N.put(a2, bVar.e());
        }
    }

    private void R2(int i2) {
        this.K = S2(this.K, this.J, i2);
    }

    static int[] S2(int[] iArr, int i2, int i3) {
        int i4;
        if (!(iArr != null && iArr.length == i2 + 1 && iArr[iArr.length - 1] == i3)) {
            iArr = new int[(i2 + 1)];
        }
        int i5 = 0;
        iArr[0] = 0;
        int i6 = i3 / i2;
        int i7 = i3 % i2;
        int i8 = 0;
        for (int i9 = 1; i9 <= i2; i9++) {
            i5 += i7;
            if (i5 <= 0 || i2 - i5 >= i7) {
                i4 = i6;
            } else {
                i4 = i6 + 1;
                i5 -= i2;
            }
            i8 += i4;
            iArr[i9] = i8;
        }
        return iArr;
    }

    private void T2() {
        this.M.clear();
        this.N.clear();
    }

    private int U2(RecyclerView.a0 a0Var) {
        int i2;
        if (!(K() == 0 || a0Var.b() == 0)) {
            U1();
            boolean s2 = s2();
            View Z1 = Z1(!s2, true);
            View Y1 = Y1(!s2, true);
            if (!(Z1 == null || Y1 == null)) {
                int b2 = this.O.b(i0(Z1), this.J);
                int b3 = this.O.b(i0(Y1), this.J);
                int min = Math.min(b2, b3);
                int max = Math.max(b2, b3);
                int b4 = this.O.b(a0Var.b() - 1, this.J) + 1;
                if (this.x) {
                    i2 = Math.max(0, (b4 - max) - 1);
                } else {
                    i2 = Math.max(0, min);
                }
                if (!s2) {
                    return i2;
                }
                return Math.round((((float) i2) * (((float) Math.abs(this.u.d(Y1) - this.u.g(Z1))) / ((float) ((this.O.b(i0(Y1), this.J) - this.O.b(i0(Z1), this.J)) + 1)))) + ((float) (this.u.m() - this.u.g(Z1))));
            }
        }
        return 0;
    }

    private int V2(RecyclerView.a0 a0Var) {
        if (!(K() == 0 || a0Var.b() == 0)) {
            U1();
            View Z1 = Z1(!s2(), true);
            View Y1 = Y1(!s2(), true);
            if (!(Z1 == null || Y1 == null)) {
                if (!s2()) {
                    return this.O.b(a0Var.b() - 1, this.J) + 1;
                }
                int d2 = this.u.d(Y1) - this.u.g(Z1);
                int b2 = this.O.b(i0(Z1), this.J);
                return (int) ((((float) d2) / ((float) ((this.O.b(i0(Y1), this.J) - b2) + 1))) * ((float) (this.O.b(a0Var.b() - 1, this.J) + 1)));
            }
        }
        return 0;
    }

    private void W2(RecyclerView.v vVar, RecyclerView.a0 a0Var, LinearLayoutManager.a aVar, int i2) {
        boolean z = i2 == 1;
        int b3 = b3(vVar, a0Var, aVar.f1512b);
        if (z) {
            while (b3 > 0) {
                int i3 = aVar.f1512b;
                if (i3 > 0) {
                    int i4 = i3 - 1;
                    aVar.f1512b = i4;
                    b3 = b3(vVar, a0Var, i4);
                } else {
                    return;
                }
            }
            return;
        }
        int b2 = a0Var.b() - 1;
        int i5 = aVar.f1512b;
        while (i5 < b2) {
            int i6 = i5 + 1;
            int b32 = b3(vVar, a0Var, i6);
            if (b32 <= b3) {
                break;
            }
            i5 = i6;
            b3 = b32;
        }
        aVar.f1512b = i5;
    }

    private void X2() {
        View[] viewArr = this.L;
        if (viewArr == null || viewArr.length != this.J) {
            this.L = new View[this.J];
        }
    }

    private int a3(RecyclerView.v vVar, RecyclerView.a0 a0Var, int i2) {
        if (!a0Var.e()) {
            return this.O.b(i2, this.J);
        }
        int f2 = vVar.f(i2);
        if (f2 != -1) {
            return this.O.b(f2, this.J);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i2);
        return 0;
    }

    private int b3(RecyclerView.v vVar, RecyclerView.a0 a0Var, int i2) {
        if (!a0Var.e()) {
            return this.O.c(i2, this.J);
        }
        int i3 = this.N.get(i2, -1);
        if (i3 != -1) {
            return i3;
        }
        int f2 = vVar.f(i2);
        if (f2 != -1) {
            return this.O.c(f2, this.J);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i2);
        return 0;
    }

    private int c3(RecyclerView.v vVar, RecyclerView.a0 a0Var, int i2) {
        if (!a0Var.e()) {
            return this.O.f(i2);
        }
        int i3 = this.M.get(i2, -1);
        if (i3 != -1) {
            return i3;
        }
        int f2 = vVar.f(i2);
        if (f2 != -1) {
            return this.O.f(f2);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i2);
        return 1;
    }

    private void d3(float f2, int i2) {
        R2(Math.max(Math.round(f2 * ((float) this.J)), i2));
    }

    private void e3(View view, int i2, boolean z) {
        int i3;
        int i4;
        b bVar = (b) view.getLayoutParams();
        Rect rect = bVar.f1607b;
        int i5 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) bVar).topMargin + ((ViewGroup.MarginLayoutParams) bVar).bottomMargin;
        int i6 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) bVar).leftMargin + ((ViewGroup.MarginLayoutParams) bVar).rightMargin;
        int Y2 = Y2(bVar.f1505e, bVar.f1506f);
        if (this.s == 1) {
            i3 = RecyclerView.o.L(Y2, i2, i6, ((ViewGroup.MarginLayoutParams) bVar).width, false);
            i4 = RecyclerView.o.L(this.u.n(), Y(), i5, ((ViewGroup.MarginLayoutParams) bVar).height, true);
        } else {
            int L2 = RecyclerView.o.L(Y2, i2, i5, ((ViewGroup.MarginLayoutParams) bVar).height, false);
            int L3 = RecyclerView.o.L(this.u.n(), q0(), i6, ((ViewGroup.MarginLayoutParams) bVar).width, true);
            i4 = L2;
            i3 = L3;
        }
        f3(view, i3, i4, z);
    }

    private void f3(View view, int i2, int i3, boolean z) {
        boolean z2;
        RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
        if (z) {
            z2 = I1(view, i2, i3, pVar);
        } else {
            z2 = G1(view, i2, i3, pVar);
        }
        if (z2) {
            view.measure(i2, i3);
        }
    }

    private void h3() {
        int i2;
        int i3;
        if (q2() == 1) {
            i3 = p0() - g0();
            i2 = f0();
        } else {
            i3 = X() - e0();
            i2 = h0();
        }
        R2(i3 - i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void D1(Rect rect, int i2, int i3) {
        int i4;
        int i5;
        if (this.K == null) {
            super.D1(rect, i2, i3);
        }
        int f0 = f0() + g0();
        int h0 = h0() + e0();
        if (this.s == 1) {
            i5 = RecyclerView.o.o(i3, rect.height() + h0, c0());
            int[] iArr = this.K;
            i4 = RecyclerView.o.o(i2, iArr[iArr.length - 1] + f0, d0());
        } else {
            i4 = RecyclerView.o.o(i2, rect.width() + f0, d0());
            int[] iArr2 = this.K;
            i5 = RecyclerView.o.o(i3, iArr2[iArr2.length - 1] + h0, c0());
        }
        C1(i4, i5);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o, androidx.recyclerview.widget.LinearLayoutManager
    public RecyclerView.p E() {
        if (this.s == 0) {
            return new b(-2, -1);
        }
        return new b(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p F(Context context, AttributeSet attributeSet) {
        return new b(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p G(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new b((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new b(layoutParams);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void G2(boolean z) {
        if (!z) {
            super.G2(false);
            return;
        }
        throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00d6, code lost:
        if (r13 == (r2 > r15)) goto L_0x00b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00f6, code lost:
        if (r13 == r11) goto L_0x00b8;
     */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0107  */
    @Override // androidx.recyclerview.widget.RecyclerView.o, androidx.recyclerview.widget.LinearLayoutManager
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View K0(android.view.View r24, int r25, androidx.recyclerview.widget.RecyclerView.v r26, androidx.recyclerview.widget.RecyclerView.a0 r27) {
        /*
        // Method dump skipped, instructions count: 337
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.K0(android.view.View, int, androidx.recyclerview.widget.RecyclerView$v, androidx.recyclerview.widget.RecyclerView$a0):android.view.View");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o, androidx.recyclerview.widget.LinearLayoutManager
    public boolean M1() {
        return this.D == null && !this.I;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int O(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (this.s == 1) {
            return this.J;
        }
        if (a0Var.b() < 1) {
            return 0;
        }
        return a3(vVar, a0Var, a0Var.b() - 1) + 1;
    }

    /* access modifiers changed from: package-private */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void O1(RecyclerView.a0 a0Var, LinearLayoutManager.c cVar, RecyclerView.o.c cVar2) {
        int i2 = this.J;
        for (int i3 = 0; i3 < this.J && cVar.c(a0Var) && i2 > 0; i3++) {
            int i4 = cVar.f1523d;
            cVar2.a(i4, Math.max(0, cVar.f1526g));
            i2 -= this.O.f(i4);
            cVar.f1523d += cVar.f1524e;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void Q0(RecyclerView.v vVar, RecyclerView.a0 a0Var, View view, b.h.k.d0.c cVar) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof b)) {
            super.P0(view, cVar);
            return;
        }
        b bVar = (b) layoutParams;
        int a3 = a3(vVar, a0Var, bVar.a());
        if (this.s == 0) {
            cVar.d0(c.C0048c.a(bVar.e(), bVar.f(), a3, 1, false, false));
        } else {
            cVar.d0(c.C0048c.a(a3, 1, bVar.e(), bVar.f(), false, false));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void S0(RecyclerView recyclerView, int i2, int i3) {
        this.O.h();
        this.O.g();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void T0(RecyclerView recyclerView) {
        this.O.h();
        this.O.g();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void U0(RecyclerView recyclerView, int i2, int i3, int i4) {
        this.O.h();
        this.O.g();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void V0(RecyclerView recyclerView, int i2, int i3) {
        this.O.h();
        this.O.g();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void X0(RecyclerView recyclerView, int i2, int i3, Object obj) {
        this.O.h();
        this.O.g();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o, androidx.recyclerview.widget.LinearLayoutManager
    public void Y0(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (a0Var.e()) {
            Q2();
        }
        super.Y0(vVar, a0Var);
        T2();
    }

    /* access modifiers changed from: package-private */
    public int Y2(int i2, int i3) {
        if (this.s != 1 || !r2()) {
            int[] iArr = this.K;
            return iArr[i3 + i2] - iArr[i2];
        }
        int[] iArr2 = this.K;
        int i4 = this.J;
        return iArr2[i4 - i2] - iArr2[(i4 - i2) - i3];
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o, androidx.recyclerview.widget.LinearLayoutManager
    public void Z0(RecyclerView.a0 a0Var) {
        super.Z0(a0Var);
        this.I = false;
    }

    public int Z2() {
        return this.J;
    }

    public void g3(int i2) {
        if (i2 != this.J) {
            this.I = true;
            if (i2 >= 1) {
                this.J = i2;
                this.O.h();
                u1();
                return;
            }
            throw new IllegalArgumentException("Span count should be at least 1. Provided " + i2);
        }
    }

    /* access modifiers changed from: package-private */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public View i2(RecyclerView.v vVar, RecyclerView.a0 a0Var, int i2, int i3, int i4) {
        U1();
        int m = this.u.m();
        int i5 = this.u.i();
        int i6 = i3 > i2 ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i2 != i3) {
            View J2 = J(i2);
            int i0 = i0(J2);
            if (i0 >= 0 && i0 < i4 && b3(vVar, a0Var, i0) == 0) {
                if (((RecyclerView.p) J2.getLayoutParams()).c()) {
                    if (view2 == null) {
                        view2 = J2;
                    }
                } else if (this.u.g(J2) < i5 && this.u.d(J2) >= m) {
                    return J2;
                } else {
                    if (view == null) {
                        view = J2;
                    }
                }
            }
            i2 += i6;
        }
        return view != null ? view : view2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int l0(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (this.s == 0) {
            return this.J;
        }
        if (a0Var.b() < 1) {
            return 0;
        }
        return a3(vVar, a0Var, a0Var.b() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean n(RecyclerView.p pVar) {
        return pVar instanceof b;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o, androidx.recyclerview.widget.LinearLayoutManager
    public int s(RecyclerView.a0 a0Var) {
        if (this.Q) {
            return U2(a0Var);
        }
        return super.s(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o, androidx.recyclerview.widget.LinearLayoutManager
    public int t(RecyclerView.a0 a0Var) {
        if (this.Q) {
            return V2(a0Var);
        }
        return super.t(a0Var);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r17v0, resolved type: androidx.recyclerview.widget.GridLayoutManager */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void t2(androidx.recyclerview.widget.RecyclerView.v r18, androidx.recyclerview.widget.RecyclerView.a0 r19, androidx.recyclerview.widget.LinearLayoutManager.c r20, androidx.recyclerview.widget.LinearLayoutManager.b r21) {
        /*
        // Method dump skipped, instructions count: 564
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.t2(androidx.recyclerview.widget.RecyclerView$v, androidx.recyclerview.widget.RecyclerView$a0, androidx.recyclerview.widget.LinearLayoutManager$c, androidx.recyclerview.widget.LinearLayoutManager$b):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o, androidx.recyclerview.widget.LinearLayoutManager
    public int v(RecyclerView.a0 a0Var) {
        if (this.Q) {
            return U2(a0Var);
        }
        return super.v(a0Var);
    }

    /* access modifiers changed from: package-private */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void v2(RecyclerView.v vVar, RecyclerView.a0 a0Var, LinearLayoutManager.a aVar, int i2) {
        super.v2(vVar, a0Var, aVar, i2);
        h3();
        if (a0Var.b() > 0 && !a0Var.e()) {
            W2(vVar, a0Var, aVar, i2);
        }
        X2();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o, androidx.recyclerview.widget.LinearLayoutManager
    public int w(RecyclerView.a0 a0Var) {
        if (this.Q) {
            return V2(a0Var);
        }
        return super.w(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o, androidx.recyclerview.widget.LinearLayoutManager
    public int x1(int i2, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        h3();
        X2();
        return super.x1(i2, vVar, a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o, androidx.recyclerview.widget.LinearLayoutManager
    public int z1(int i2, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        h3();
        X2();
        return super.z1(i2, vVar, a0Var);
    }

    public static class b extends RecyclerView.p {

        /* renamed from: e  reason: collision with root package name */
        int f1505e = -1;

        /* renamed from: f  reason: collision with root package name */
        int f1506f = 0;

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public int e() {
            return this.f1505e;
        }

        public int f() {
            return this.f1506f;
        }

        public b(int i2, int i3) {
            super(i2, i3);
        }

        public b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public GridLayoutManager(Context context, int i2) {
        super(context);
        g3(i2);
    }

    public GridLayoutManager(Context context, int i2, int i3, boolean z) {
        super(context, i3, z);
        g3(i2);
    }
}
