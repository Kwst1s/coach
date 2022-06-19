package b.f.b.k;

import b.f.b.d;
import b.f.b.i;
import b.f.b.k.e;
import b.f.b.k.m.b;
import b.f.b.k.m.e;
import com.github.mikephil.charting.utils.Utils;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: ConstraintWidgetContainer */
public class f extends l {
    c[] A0 = new c[4];
    c[] B0 = new c[4];
    private int C0 = 257;
    private boolean D0 = false;
    private boolean E0 = false;
    private WeakReference<d> F0 = null;
    private WeakReference<d> G0 = null;
    private WeakReference<d> H0 = null;
    private WeakReference<d> I0 = null;
    public b.a J0 = new b.a();
    b q0 = new b(this);
    public e r0 = new e(this);
    protected b.AbstractC0036b s0 = null;
    private boolean t0 = false;
    public b.f.b.e u0;
    protected d v0 = new d();
    int w0;
    int x0;
    public int y0 = 0;
    public int z0 = 0;

    public static boolean A1(e eVar, b.AbstractC0036b bVar, b.a aVar, int i2) {
        int i3;
        int i4;
        if (bVar == null) {
            return false;
        }
        aVar.f2349a = eVar.y();
        aVar.f2350b = eVar.O();
        aVar.f2351c = eVar.R();
        aVar.f2352d = eVar.v();
        aVar.f2357i = false;
        aVar.f2358j = i2;
        e.b bVar2 = aVar.f2349a;
        e.b bVar3 = e.b.MATCH_CONSTRAINT;
        boolean z = bVar2 == bVar3;
        boolean z2 = aVar.f2350b == bVar3;
        boolean z3 = z && eVar.U > Utils.FLOAT_EPSILON;
        boolean z4 = z2 && eVar.U > Utils.FLOAT_EPSILON;
        if (z && eVar.V(0) && eVar.n == 0 && !z3) {
            aVar.f2349a = e.b.WRAP_CONTENT;
            if (z2 && eVar.o == 0) {
                aVar.f2349a = e.b.FIXED;
            }
            z = false;
        }
        if (z2 && eVar.V(1) && eVar.o == 0 && !z4) {
            aVar.f2350b = e.b.WRAP_CONTENT;
            if (z && eVar.n == 0) {
                aVar.f2350b = e.b.FIXED;
            }
            z2 = false;
        }
        if (eVar.e0()) {
            aVar.f2349a = e.b.FIXED;
            z = false;
        }
        if (eVar.f0()) {
            aVar.f2350b = e.b.FIXED;
            z2 = false;
        }
        if (z3) {
            if (eVar.p[0] == 4) {
                aVar.f2349a = e.b.FIXED;
            } else if (!z2) {
                e.b bVar4 = aVar.f2350b;
                e.b bVar5 = e.b.FIXED;
                if (bVar4 == bVar5) {
                    i4 = aVar.f2352d;
                } else {
                    aVar.f2349a = e.b.WRAP_CONTENT;
                    bVar.a(eVar, aVar);
                    i4 = aVar.f2354f;
                }
                aVar.f2349a = bVar5;
                int i5 = eVar.V;
                if (i5 == 0 || i5 == -1) {
                    aVar.f2351c = (int) (eVar.t() * ((float) i4));
                } else {
                    aVar.f2351c = (int) (eVar.t() / ((float) i4));
                }
            }
        }
        if (z4) {
            if (eVar.p[1] == 4) {
                aVar.f2350b = e.b.FIXED;
            } else if (!z) {
                e.b bVar6 = aVar.f2349a;
                e.b bVar7 = e.b.FIXED;
                if (bVar6 == bVar7) {
                    i3 = aVar.f2351c;
                } else {
                    aVar.f2350b = e.b.WRAP_CONTENT;
                    bVar.a(eVar, aVar);
                    i3 = aVar.f2353e;
                }
                aVar.f2350b = bVar7;
                int i6 = eVar.V;
                if (i6 == 0 || i6 == -1) {
                    aVar.f2352d = (int) (((float) i3) / eVar.t());
                } else {
                    aVar.f2352d = (int) (((float) i3) * eVar.t());
                }
            }
        }
        bVar.a(eVar, aVar);
        eVar.U0(aVar.f2353e);
        eVar.v0(aVar.f2354f);
        eVar.u0(aVar.f2356h);
        eVar.k0(aVar.f2355g);
        aVar.f2358j = b.a.f2348k;
        return aVar.f2357i;
    }

    private void C1() {
        this.y0 = 0;
        this.z0 = 0;
    }

    private void g1(e eVar) {
        int i2 = this.y0 + 1;
        c[] cVarArr = this.B0;
        if (i2 >= cVarArr.length) {
            this.B0 = (c[]) Arrays.copyOf(cVarArr, cVarArr.length * 2);
        }
        this.B0[this.y0] = new c(eVar, 0, x1());
        this.y0++;
    }

    private void j1(d dVar, i iVar) {
        this.v0.h(iVar, this.v0.q(dVar), 0, 5);
    }

    private void k1(d dVar, i iVar) {
        this.v0.h(this.v0.q(dVar), iVar, 0, 5);
    }

    private void l1(e eVar) {
        int i2 = this.z0 + 1;
        c[] cVarArr = this.A0;
        if (i2 >= cVarArr.length) {
            this.A0 = (c[]) Arrays.copyOf(cVarArr, cVarArr.length * 2);
        }
        this.A0[this.z0] = new c(eVar, 1, x1());
        this.z0++;
    }

    public boolean B1(int i2) {
        return (this.C0 & i2) == i2;
    }

    public void D1(b.AbstractC0036b bVar) {
        this.s0 = bVar;
        this.r0.n(bVar);
    }

    public void E1(int i2) {
        this.C0 = i2;
        d.r = B1(512);
    }

    public void F1(boolean z) {
        this.t0 = z;
    }

    public void G1(d dVar, boolean[] zArr) {
        zArr[2] = false;
        boolean B1 = B1(64);
        Z0(dVar, B1);
        int size = this.p0.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.p0.get(i2).Z0(dVar, B1);
        }
    }

    public void H1() {
        this.q0.e(this);
    }

    @Override // b.f.b.k.e
    public void Y0(boolean z, boolean z2) {
        super.Y0(z, z2);
        int size = this.p0.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.p0.get(i2).Y0(z, z2);
        }
    }

    /* JADX WARN: Type inference failed for: r6v5, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // b.f.b.k.l
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b1() {
        /*
        // Method dump skipped, instructions count: 799
        */
        throw new UnsupportedOperationException("Method not decompiled: b.f.b.k.f.b1():void");
    }

    /* access modifiers changed from: package-private */
    public void e1(e eVar, int i2) {
        if (i2 == 0) {
            g1(eVar);
        } else if (i2 == 1) {
            l1(eVar);
        }
    }

    public boolean f1(d dVar) {
        boolean B1 = B1(64);
        g(dVar, B1);
        int size = this.p0.size();
        boolean z = false;
        for (int i2 = 0; i2 < size; i2++) {
            e eVar = this.p0.get(i2);
            eVar.C0(0, false);
            eVar.C0(1, false);
            if (eVar instanceof a) {
                z = true;
            }
        }
        if (z) {
            for (int i3 = 0; i3 < size; i3++) {
                e eVar2 = this.p0.get(i3);
                if (eVar2 instanceof a) {
                    ((a) eVar2).h1();
                }
            }
        }
        for (int i4 = 0; i4 < size; i4++) {
            e eVar3 = this.p0.get(i4);
            if (eVar3.f()) {
                eVar3.g(dVar, B1);
            }
        }
        if (d.r) {
            HashSet<e> hashSet = new HashSet<>();
            for (int i5 = 0; i5 < size; i5++) {
                e eVar4 = this.p0.get(i5);
                if (!eVar4.f()) {
                    hashSet.add(eVar4);
                }
            }
            e(this, dVar, hashSet, y() == e.b.WRAP_CONTENT ? 0 : 1, false);
            Iterator<e> it = hashSet.iterator();
            while (it.hasNext()) {
                e next = it.next();
                j.a(this, dVar, next);
                next.g(dVar, B1);
            }
        } else {
            for (int i6 = 0; i6 < size; i6++) {
                e eVar5 = this.p0.get(i6);
                if (eVar5 instanceof f) {
                    e.b[] bVarArr = eVar5.Q;
                    e.b bVar = bVarArr[0];
                    e.b bVar2 = bVarArr[1];
                    e.b bVar3 = e.b.WRAP_CONTENT;
                    if (bVar == bVar3) {
                        eVar5.z0(e.b.FIXED);
                    }
                    if (bVar2 == bVar3) {
                        eVar5.Q0(e.b.FIXED);
                    }
                    eVar5.g(dVar, B1);
                    if (bVar == bVar3) {
                        eVar5.z0(bVar);
                    }
                    if (bVar2 == bVar3) {
                        eVar5.Q0(bVar2);
                    }
                } else {
                    j.a(this, dVar, eVar5);
                    if (!eVar5.f()) {
                        eVar5.g(dVar, B1);
                    }
                }
            }
        }
        if (this.y0 > 0) {
            b.b(this, dVar, null, 0);
        }
        if (this.z0 > 0) {
            b.b(this, dVar, null, 1);
        }
        return true;
    }

    @Override // b.f.b.k.l, b.f.b.k.e
    public void h0() {
        this.v0.D();
        this.w0 = 0;
        this.x0 = 0;
        super.h0();
    }

    public void h1(d dVar) {
        WeakReference<d> weakReference = this.I0;
        if (weakReference == null || weakReference.get() == null || dVar.d() > this.I0.get().d()) {
            this.I0 = new WeakReference<>(dVar);
        }
    }

    public void i1(d dVar) {
        WeakReference<d> weakReference = this.G0;
        if (weakReference == null || weakReference.get() == null || dVar.d() > this.G0.get().d()) {
            this.G0 = new WeakReference<>(dVar);
        }
    }

    /* access modifiers changed from: package-private */
    public void m1(d dVar) {
        WeakReference<d> weakReference = this.H0;
        if (weakReference == null || weakReference.get() == null || dVar.d() > this.H0.get().d()) {
            this.H0 = new WeakReference<>(dVar);
        }
    }

    /* access modifiers changed from: package-private */
    public void n1(d dVar) {
        WeakReference<d> weakReference = this.F0;
        if (weakReference == null || weakReference.get() == null || dVar.d() > this.F0.get().d()) {
            this.F0 = new WeakReference<>(dVar);
        }
    }

    public boolean o1(boolean z) {
        return this.r0.f(z);
    }

    public boolean p1(boolean z) {
        return this.r0.g(z);
    }

    public boolean q1(boolean z, int i2) {
        return this.r0.h(z, i2);
    }

    public b.AbstractC0036b r1() {
        return this.s0;
    }

    public int s1() {
        return this.C0;
    }

    public d t1() {
        return this.v0;
    }

    public void u1() {
        this.r0.j();
    }

    public void v1() {
        this.r0.k();
    }

    public boolean w1() {
        return this.E0;
    }

    public boolean x1() {
        return this.t0;
    }

    public boolean y1() {
        return this.D0;
    }

    public long z1(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        this.w0 = i9;
        this.x0 = i10;
        return this.q0.d(this, i2, i9, i10, i3, i4, i5, i6, i7, i8);
    }
}
