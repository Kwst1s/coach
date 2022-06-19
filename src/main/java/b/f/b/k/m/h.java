package b.f.b.k.m;

import b.f.b.k.a;
import b.f.b.k.d;
import b.f.b.k.e;
import b.f.b.k.f;
import b.f.b.k.g;
import b.f.b.k.m.b;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: Direct */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private static b.a f2388a = new b.a();

    private static boolean a(e eVar) {
        e.b y = eVar.y();
        e.b O = eVar.O();
        f fVar = eVar.I() != null ? (f) eVar.I() : null;
        if (fVar != null) {
            fVar.y();
            e.b bVar = e.b.FIXED;
        }
        if (fVar != null) {
            fVar.O();
            e.b bVar2 = e.b.FIXED;
        }
        e.b bVar3 = e.b.FIXED;
        boolean z = y == bVar3 || y == e.b.WRAP_CONTENT || (y == e.b.MATCH_CONSTRAINT && eVar.n == 0 && eVar.U == Utils.FLOAT_EPSILON && eVar.V(0)) || eVar.e0();
        boolean z2 = O == bVar3 || O == e.b.WRAP_CONTENT || (O == e.b.MATCH_CONSTRAINT && eVar.o == 0 && eVar.U == Utils.FLOAT_EPSILON && eVar.V(1)) || eVar.f0();
        if (eVar.U > Utils.FLOAT_EPSILON && (z || z2)) {
            return true;
        }
        if (!z || !z2) {
            return false;
        }
        return true;
    }

    private static void b(e eVar, b.AbstractC0036b bVar, boolean z) {
        d dVar;
        d dVar2;
        d dVar3;
        d dVar4;
        d dVar5;
        if (!(eVar instanceof f) && eVar.d0() && a(eVar)) {
            f.A1(eVar, bVar, new b.a(), b.a.f2348k);
        }
        d m = eVar.m(d.b.LEFT);
        d m2 = eVar.m(d.b.RIGHT);
        int d2 = m.d();
        int d3 = m2.d();
        if (m.c() != null && m.m()) {
            Iterator<d> it = m.c().iterator();
            while (it.hasNext()) {
                d next = it.next();
                e eVar2 = next.f2308d;
                boolean a2 = a(eVar2);
                if (eVar2.d0() && a2) {
                    f.A1(eVar2, bVar, new b.a(), b.a.f2348k);
                }
                e.b y = eVar2.y();
                e.b bVar2 = e.b.MATCH_CONSTRAINT;
                if (y != bVar2 || a2) {
                    if (!eVar2.d0()) {
                        d dVar6 = eVar2.F;
                        if (next == dVar6 && eVar2.H.f2310f == null) {
                            int e2 = dVar6.e() + d2;
                            eVar2.p0(e2, eVar2.R() + e2);
                            b(eVar2, bVar, z);
                        } else {
                            d dVar7 = eVar2.H;
                            if (next == dVar7 && dVar6.f2310f == null) {
                                int e3 = d2 - dVar7.e();
                                eVar2.p0(e3 - eVar2.R(), e3);
                                b(eVar2, bVar, z);
                            } else if (next == dVar6 && (dVar3 = dVar7.f2310f) != null && dVar3.m() && !eVar2.Z()) {
                                d(bVar, eVar2, z);
                            }
                        }
                    }
                } else if (eVar2.y() == bVar2 && eVar2.r >= 0 && eVar2.q >= 0) {
                    if ((eVar2.Q() == 8 || (eVar2.n == 0 && eVar2.t() == Utils.FLOAT_EPSILON)) && !eVar2.Z() && !eVar2.c0()) {
                        if (((next == eVar2.F && (dVar5 = eVar2.H.f2310f) != null && dVar5.m()) || (next == eVar2.H && (dVar4 = eVar2.F.f2310f) != null && dVar4.m())) && !eVar2.Z()) {
                            e(eVar, bVar, eVar2, z);
                        }
                    }
                }
            }
        }
        if (!(eVar instanceof g) && m2.c() != null && m2.m()) {
            Iterator<d> it2 = m2.c().iterator();
            while (it2.hasNext()) {
                d next2 = it2.next();
                e eVar3 = next2.f2308d;
                boolean a3 = a(eVar3);
                if (eVar3.d0() && a3) {
                    f.A1(eVar3, bVar, new b.a(), b.a.f2348k);
                }
                boolean z2 = (next2 == eVar3.F && (dVar2 = eVar3.H.f2310f) != null && dVar2.m()) || (next2 == eVar3.H && (dVar = eVar3.F.f2310f) != null && dVar.m());
                e.b y2 = eVar3.y();
                e.b bVar3 = e.b.MATCH_CONSTRAINT;
                if (y2 != bVar3 || a3) {
                    if (!eVar3.d0()) {
                        d dVar8 = eVar3.F;
                        if (next2 == dVar8 && eVar3.H.f2310f == null) {
                            int e4 = dVar8.e() + d3;
                            eVar3.p0(e4, eVar3.R() + e4);
                            b(eVar3, bVar, z);
                        } else {
                            d dVar9 = eVar3.H;
                            if (next2 == dVar9 && dVar8.f2310f == null) {
                                int e5 = d3 - dVar9.e();
                                eVar3.p0(e5 - eVar3.R(), e5);
                                b(eVar3, bVar, z);
                            } else if (z2 && !eVar3.Z()) {
                                d(bVar, eVar3, z);
                            }
                        }
                    }
                } else if (eVar3.y() == bVar3 && eVar3.r >= 0 && eVar3.q >= 0) {
                    if ((eVar3.Q() == 8 || (eVar3.n == 0 && eVar3.t() == Utils.FLOAT_EPSILON)) && !eVar3.Z() && !eVar3.c0() && z2 && !eVar3.Z()) {
                        e(eVar, bVar, eVar3, z);
                    }
                }
            }
        }
    }

    private static void c(a aVar, b.AbstractC0036b bVar, int i2, boolean z) {
        if (!aVar.c1()) {
            return;
        }
        if (i2 == 0) {
            b(aVar, bVar, z);
        } else {
            i(aVar, bVar);
        }
    }

    private static void d(b.AbstractC0036b bVar, e eVar, boolean z) {
        float w = eVar.w();
        int d2 = eVar.F.f2310f.d();
        int d3 = eVar.H.f2310f.d();
        int e2 = eVar.F.e() + d2;
        int e3 = d3 - eVar.H.e();
        if (d2 == d3) {
            w = 0.5f;
        } else {
            d2 = e2;
            d3 = e3;
        }
        int R = eVar.R();
        int i2 = (d3 - d2) - R;
        if (d2 > d3) {
            i2 = (d2 - d3) - R;
        }
        int i3 = ((int) ((w * ((float) i2)) + 0.5f)) + d2;
        int i4 = i3 + R;
        if (d2 > d3) {
            i4 = i3 - R;
        }
        eVar.p0(i3, i4);
        b(eVar, bVar, z);
    }

    private static void e(e eVar, b.AbstractC0036b bVar, e eVar2, boolean z) {
        int i2;
        float w = eVar2.w();
        int d2 = eVar2.F.f2310f.d() + eVar2.F.e();
        int d3 = eVar2.H.f2310f.d() - eVar2.H.e();
        if (d3 >= d2) {
            int R = eVar2.R();
            if (eVar2.Q() != 8) {
                int i3 = eVar2.n;
                if (i3 == 2) {
                    if (eVar instanceof f) {
                        i2 = eVar.R();
                    } else {
                        i2 = eVar.I().R();
                    }
                    R = (int) (eVar2.w() * 0.5f * ((float) i2));
                } else if (i3 == 0) {
                    R = d3 - d2;
                }
                R = Math.max(eVar2.q, R);
                int i4 = eVar2.r;
                if (i4 > 0) {
                    R = Math.min(i4, R);
                }
            }
            int i5 = d2 + ((int) ((w * ((float) ((d3 - d2) - R))) + 0.5f));
            eVar2.p0(i5, R + i5);
            b(eVar2, bVar, z);
        }
    }

    private static void f(b.AbstractC0036b bVar, e eVar) {
        float M = eVar.M();
        int d2 = eVar.G.f2310f.d();
        int d3 = eVar.I.f2310f.d();
        int e2 = eVar.G.e() + d2;
        int e3 = d3 - eVar.I.e();
        if (d2 == d3) {
            M = 0.5f;
        } else {
            d2 = e2;
            d3 = e3;
        }
        int v = eVar.v();
        int i2 = (d3 - d2) - v;
        if (d2 > d3) {
            i2 = (d2 - d3) - v;
        }
        int i3 = (int) ((M * ((float) i2)) + 0.5f);
        int i4 = d2 + i3;
        int i5 = i4 + v;
        if (d2 > d3) {
            i4 = d2 - i3;
            i5 = i4 - v;
        }
        eVar.s0(i4, i5);
        i(eVar, bVar);
    }

    private static void g(e eVar, b.AbstractC0036b bVar, e eVar2) {
        int i2;
        float M = eVar2.M();
        int d2 = eVar2.G.f2310f.d() + eVar2.G.e();
        int d3 = eVar2.I.f2310f.d() - eVar2.I.e();
        if (d3 >= d2) {
            int v = eVar2.v();
            if (eVar2.Q() != 8) {
                int i3 = eVar2.o;
                if (i3 == 2) {
                    if (eVar instanceof f) {
                        i2 = eVar.v();
                    } else {
                        i2 = eVar.I().v();
                    }
                    v = (int) (M * 0.5f * ((float) i2));
                } else if (i3 == 0) {
                    v = d3 - d2;
                }
                v = Math.max(eVar2.t, v);
                int i4 = eVar2.u;
                if (i4 > 0) {
                    v = Math.min(i4, v);
                }
            }
            int i5 = d2 + ((int) ((M * ((float) ((d3 - d2) - v))) + 0.5f));
            eVar2.s0(i5, v + i5);
            i(eVar2, bVar);
        }
    }

    public static void h(f fVar, b.AbstractC0036b bVar) {
        e.b y = fVar.y();
        e.b O = fVar.O();
        fVar.i0();
        ArrayList<e> a1 = fVar.a1();
        int size = a1.size();
        for (int i2 = 0; i2 < size; i2++) {
            a1.get(i2).i0();
        }
        boolean x1 = fVar.x1();
        if (y == e.b.FIXED) {
            fVar.p0(0, fVar.R());
        } else {
            fVar.q0(0);
        }
        boolean z = false;
        boolean z2 = false;
        for (int i3 = 0; i3 < size; i3++) {
            e eVar = a1.get(i3);
            if (eVar instanceof g) {
                g gVar = (g) eVar;
                if (gVar.b1() == 1) {
                    if (gVar.c1() != -1) {
                        gVar.f1(gVar.c1());
                    } else if (gVar.d1() != -1 && fVar.e0()) {
                        gVar.f1(fVar.R() - gVar.d1());
                    } else if (fVar.e0()) {
                        gVar.f1((int) ((gVar.e1() * ((float) fVar.R())) + 0.5f));
                    }
                    z = true;
                }
            } else if ((eVar instanceof a) && ((a) eVar).g1() == 0) {
                z2 = true;
            }
        }
        if (z) {
            for (int i4 = 0; i4 < size; i4++) {
                e eVar2 = a1.get(i4);
                if (eVar2 instanceof g) {
                    g gVar2 = (g) eVar2;
                    if (gVar2.b1() == 1) {
                        b(gVar2, bVar, x1);
                    }
                }
            }
        }
        b(fVar, bVar, x1);
        if (z2) {
            for (int i5 = 0; i5 < size; i5++) {
                e eVar3 = a1.get(i5);
                if (eVar3 instanceof a) {
                    a aVar = (a) eVar3;
                    if (aVar.g1() == 0) {
                        c(aVar, bVar, 0, x1);
                    }
                }
            }
        }
        if (O == e.b.FIXED) {
            fVar.s0(0, fVar.v());
        } else {
            fVar.r0(0);
        }
        boolean z3 = false;
        boolean z4 = false;
        for (int i6 = 0; i6 < size; i6++) {
            e eVar4 = a1.get(i6);
            if (eVar4 instanceof g) {
                g gVar3 = (g) eVar4;
                if (gVar3.b1() == 0) {
                    if (gVar3.c1() != -1) {
                        gVar3.f1(gVar3.c1());
                    } else if (gVar3.d1() != -1 && fVar.f0()) {
                        gVar3.f1(fVar.v() - gVar3.d1());
                    } else if (fVar.f0()) {
                        gVar3.f1((int) ((gVar3.e1() * ((float) fVar.v())) + 0.5f));
                    }
                    z3 = true;
                }
            } else if ((eVar4 instanceof a) && ((a) eVar4).g1() == 1) {
                z4 = true;
            }
        }
        if (z3) {
            for (int i7 = 0; i7 < size; i7++) {
                e eVar5 = a1.get(i7);
                if (eVar5 instanceof g) {
                    g gVar4 = (g) eVar5;
                    if (gVar4.b1() == 0) {
                        i(gVar4, bVar);
                    }
                }
            }
        }
        i(fVar, bVar);
        if (z4) {
            for (int i8 = 0; i8 < size; i8++) {
                e eVar6 = a1.get(i8);
                if (eVar6 instanceof a) {
                    a aVar2 = (a) eVar6;
                    if (aVar2.g1() == 1) {
                        c(aVar2, bVar, 1, x1);
                    }
                }
            }
        }
        for (int i9 = 0; i9 < size; i9++) {
            e eVar7 = a1.get(i9);
            if (eVar7.d0() && a(eVar7)) {
                f.A1(eVar7, bVar, f2388a, b.a.f2348k);
                b(eVar7, bVar, x1);
                i(eVar7, bVar);
            }
        }
    }

    private static void i(e eVar, b.AbstractC0036b bVar) {
        d dVar;
        d dVar2;
        d dVar3;
        d dVar4;
        d dVar5;
        if (!(eVar instanceof f) && eVar.d0() && a(eVar)) {
            f.A1(eVar, bVar, new b.a(), b.a.f2348k);
        }
        d m = eVar.m(d.b.TOP);
        d m2 = eVar.m(d.b.BOTTOM);
        int d2 = m.d();
        int d3 = m2.d();
        if (m.c() != null && m.m()) {
            Iterator<d> it = m.c().iterator();
            while (it.hasNext()) {
                d next = it.next();
                e eVar2 = next.f2308d;
                boolean a2 = a(eVar2);
                if (eVar2.d0() && a2) {
                    f.A1(eVar2, bVar, new b.a(), b.a.f2348k);
                }
                e.b O = eVar2.O();
                e.b bVar2 = e.b.MATCH_CONSTRAINT;
                if (O != bVar2 || a2) {
                    if (!eVar2.d0()) {
                        d dVar6 = eVar2.G;
                        if (next == dVar6 && eVar2.I.f2310f == null) {
                            int e2 = dVar6.e() + d2;
                            eVar2.s0(e2, eVar2.v() + e2);
                            i(eVar2, bVar);
                        } else {
                            d dVar7 = eVar2.I;
                            if (next == dVar7 && dVar7.f2310f == null) {
                                int e3 = d2 - dVar7.e();
                                eVar2.s0(e3 - eVar2.v(), e3);
                                i(eVar2, bVar);
                            } else if (next == dVar6 && (dVar3 = dVar7.f2310f) != null && dVar3.m()) {
                                f(bVar, eVar2);
                            }
                        }
                    }
                } else if (eVar2.O() == bVar2 && eVar2.u >= 0 && eVar2.t >= 0) {
                    if ((eVar2.Q() == 8 || (eVar2.o == 0 && eVar2.t() == Utils.FLOAT_EPSILON)) && !eVar2.b0() && !eVar2.c0()) {
                        if (((next == eVar2.G && (dVar5 = eVar2.I.f2310f) != null && dVar5.m()) || (next == eVar2.I && (dVar4 = eVar2.G.f2310f) != null && dVar4.m())) && !eVar2.b0()) {
                            g(eVar, bVar, eVar2);
                        }
                    }
                }
            }
        }
        if (!(eVar instanceof g)) {
            if (m2.c() != null && m2.m()) {
                Iterator<d> it2 = m2.c().iterator();
                while (it2.hasNext()) {
                    d next2 = it2.next();
                    e eVar3 = next2.f2308d;
                    boolean a3 = a(eVar3);
                    if (eVar3.d0() && a3) {
                        f.A1(eVar3, bVar, new b.a(), b.a.f2348k);
                    }
                    boolean z = (next2 == eVar3.G && (dVar2 = eVar3.I.f2310f) != null && dVar2.m()) || (next2 == eVar3.I && (dVar = eVar3.G.f2310f) != null && dVar.m());
                    e.b O2 = eVar3.O();
                    e.b bVar3 = e.b.MATCH_CONSTRAINT;
                    if (O2 != bVar3 || a3) {
                        if (!eVar3.d0()) {
                            d dVar8 = eVar3.G;
                            if (next2 == dVar8 && eVar3.I.f2310f == null) {
                                int e4 = dVar8.e() + d3;
                                eVar3.s0(e4, eVar3.v() + e4);
                                i(eVar3, bVar);
                            } else {
                                d dVar9 = eVar3.I;
                                if (next2 == dVar9 && dVar8.f2310f == null) {
                                    int e5 = d3 - dVar9.e();
                                    eVar3.s0(e5 - eVar3.v(), e5);
                                    i(eVar3, bVar);
                                } else if (z && !eVar3.b0()) {
                                    f(bVar, eVar3);
                                }
                            }
                        }
                    } else if (eVar3.O() == bVar3 && eVar3.u >= 0 && eVar3.t >= 0) {
                        if ((eVar3.Q() == 8 || (eVar3.o == 0 && eVar3.t() == Utils.FLOAT_EPSILON)) && !eVar3.b0() && !eVar3.c0() && z && !eVar3.b0()) {
                            g(eVar, bVar, eVar3);
                        }
                    }
                }
            }
            d m3 = eVar.m(d.b.BASELINE);
            if (m3.c() != null && m3.m()) {
                int d4 = m3.d();
                Iterator<d> it3 = m3.c().iterator();
                while (it3.hasNext()) {
                    d next3 = it3.next();
                    e eVar4 = next3.f2308d;
                    boolean a4 = a(eVar4);
                    if (eVar4.d0() && a4) {
                        f.A1(eVar4, bVar, new b.a(), b.a.f2348k);
                    }
                    if ((eVar4.O() != e.b.MATCH_CONSTRAINT || a4) && !eVar4.d0() && next3 == eVar4.J) {
                        eVar4.o0(d4);
                        i(eVar4, bVar);
                    }
                }
            }
        }
    }
}
