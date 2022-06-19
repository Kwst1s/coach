package b.f.b.k.m;

import b.f.b.k.d;
import b.f.b.k.e;
import b.f.b.k.f;
import b.f.b.k.g;
import b.f.b.k.i;
import b.f.b.k.m.b;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: DependencyGraph */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private f f2360a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f2361b = true;

    /* renamed from: c  reason: collision with root package name */
    private boolean f2362c = true;

    /* renamed from: d  reason: collision with root package name */
    private f f2363d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<p> f2364e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    private b.AbstractC0036b f2365f;

    /* renamed from: g  reason: collision with root package name */
    private b.a f2366g;

    /* renamed from: h  reason: collision with root package name */
    ArrayList<m> f2367h;

    public e(f fVar) {
        new ArrayList();
        this.f2365f = null;
        this.f2366g = new b.a();
        this.f2367h = new ArrayList<>();
        this.f2360a = fVar;
        this.f2363d = fVar;
    }

    private void a(f fVar, int i2, int i3, f fVar2, ArrayList<m> arrayList, m mVar) {
        p pVar = fVar.f2371d;
        if (pVar.f2405c == null) {
            f fVar3 = this.f2360a;
            if (!(pVar == fVar3.f2328d || pVar == fVar3.f2329e)) {
                if (mVar == null) {
                    mVar = new m(pVar, i3);
                    arrayList.add(mVar);
                }
                pVar.f2405c = mVar;
                mVar.a(pVar);
                for (d dVar : pVar.f2410h.f2378k) {
                    if (dVar instanceof f) {
                        a((f) dVar, i2, 0, fVar2, arrayList, mVar);
                    }
                }
                for (d dVar2 : pVar.f2411i.f2378k) {
                    if (dVar2 instanceof f) {
                        a((f) dVar2, i2, 1, fVar2, arrayList, mVar);
                    }
                }
                if (i2 == 1 && (pVar instanceof n)) {
                    for (d dVar3 : ((n) pVar).f2395k.f2378k) {
                        if (dVar3 instanceof f) {
                            a((f) dVar3, i2, 2, fVar2, arrayList, mVar);
                        }
                    }
                }
                for (f fVar4 : pVar.f2410h.l) {
                    if (fVar4 == fVar2) {
                        mVar.f2392a = true;
                    }
                    a(fVar4, i2, 0, fVar2, arrayList, mVar);
                }
                for (f fVar5 : pVar.f2411i.l) {
                    if (fVar5 == fVar2) {
                        mVar.f2392a = true;
                    }
                    a(fVar5, i2, 1, fVar2, arrayList, mVar);
                }
                if (i2 == 1 && (pVar instanceof n)) {
                    for (f fVar6 : ((n) pVar).f2395k.l) {
                        a(fVar6, i2, 2, fVar2, arrayList, mVar);
                    }
                }
            }
        }
    }

    private boolean b(f fVar) {
        e.b bVar;
        e.b bVar2;
        int i2;
        e.b bVar3;
        int i3;
        e.b bVar4;
        Iterator<b.f.b.k.e> it = fVar.p0.iterator();
        while (it.hasNext()) {
            b.f.b.k.e next = it.next();
            e.b[] bVarArr = next.Q;
            e.b bVar5 = bVarArr[0];
            e.b bVar6 = bVarArr[1];
            if (next.Q() == 8) {
                next.f2325a = true;
            } else {
                if (next.s < 1.0f && bVar5 == e.b.MATCH_CONSTRAINT) {
                    next.n = 2;
                }
                if (next.v < 1.0f && bVar6 == e.b.MATCH_CONSTRAINT) {
                    next.o = 2;
                }
                if (next.t() > Utils.FLOAT_EPSILON) {
                    e.b bVar7 = e.b.MATCH_CONSTRAINT;
                    if (bVar5 == bVar7 && (bVar6 == e.b.WRAP_CONTENT || bVar6 == e.b.FIXED)) {
                        next.n = 3;
                    } else if (bVar6 == bVar7 && (bVar5 == e.b.WRAP_CONTENT || bVar5 == e.b.FIXED)) {
                        next.o = 3;
                    } else if (bVar5 == bVar7 && bVar6 == bVar7) {
                        if (next.n == 0) {
                            next.n = 3;
                        }
                        if (next.o == 0) {
                            next.o = 3;
                        }
                    }
                }
                e.b bVar8 = e.b.MATCH_CONSTRAINT;
                if (bVar5 == bVar8 && next.n == 1 && (next.F.f2310f == null || next.H.f2310f == null)) {
                    bVar5 = e.b.WRAP_CONTENT;
                }
                if (bVar6 == bVar8 && next.o == 1 && (next.G.f2310f == null || next.I.f2310f == null)) {
                    bVar6 = e.b.WRAP_CONTENT;
                }
                l lVar = next.f2328d;
                lVar.f2406d = bVar5;
                int i4 = next.n;
                lVar.f2403a = i4;
                n nVar = next.f2329e;
                nVar.f2406d = bVar6;
                int i5 = next.o;
                nVar.f2403a = i5;
                e.b bVar9 = e.b.MATCH_PARENT;
                if ((bVar5 == bVar9 || bVar5 == e.b.FIXED || bVar5 == e.b.WRAP_CONTENT) && (bVar6 == bVar9 || bVar6 == e.b.FIXED || bVar6 == e.b.WRAP_CONTENT)) {
                    int R = next.R();
                    if (bVar5 == bVar9) {
                        i2 = (fVar.R() - next.F.f2311g) - next.H.f2311g;
                        bVar3 = e.b.FIXED;
                    } else {
                        i2 = R;
                        bVar3 = bVar5;
                    }
                    int v = next.v();
                    if (bVar6 == bVar9) {
                        i3 = (fVar.v() - next.G.f2311g) - next.I.f2311g;
                        bVar4 = e.b.FIXED;
                    } else {
                        i3 = v;
                        bVar4 = bVar6;
                    }
                    l(next, bVar3, i2, bVar4, i3);
                    next.f2328d.f2407e.d(next.R());
                    next.f2329e.f2407e.d(next.v());
                    next.f2325a = true;
                } else {
                    if (bVar5 == bVar8 && (bVar6 == (bVar2 = e.b.WRAP_CONTENT) || bVar6 == e.b.FIXED)) {
                        if (i4 == 3) {
                            if (bVar6 == bVar2) {
                                l(next, bVar2, 0, bVar2, 0);
                            }
                            int v2 = next.v();
                            e.b bVar10 = e.b.FIXED;
                            l(next, bVar10, (int) ((((float) v2) * next.U) + 0.5f), bVar10, v2);
                            next.f2328d.f2407e.d(next.R());
                            next.f2329e.f2407e.d(next.v());
                            next.f2325a = true;
                        } else if (i4 == 1) {
                            l(next, bVar2, 0, bVar6, 0);
                            next.f2328d.f2407e.m = next.R();
                        } else if (i4 == 2) {
                            e.b[] bVarArr2 = fVar.Q;
                            e.b bVar11 = bVarArr2[0];
                            e.b bVar12 = e.b.FIXED;
                            if (bVar11 == bVar12 || bVarArr2[0] == bVar9) {
                                l(next, bVar12, (int) ((next.s * ((float) fVar.R())) + 0.5f), bVar6, next.v());
                                next.f2328d.f2407e.d(next.R());
                                next.f2329e.f2407e.d(next.v());
                                next.f2325a = true;
                            }
                        } else {
                            d[] dVarArr = next.N;
                            if (dVarArr[0].f2310f == null || dVarArr[1].f2310f == null) {
                                l(next, bVar2, 0, bVar6, 0);
                                next.f2328d.f2407e.d(next.R());
                                next.f2329e.f2407e.d(next.v());
                                next.f2325a = true;
                            }
                        }
                    }
                    if (bVar6 == bVar8 && (bVar5 == (bVar = e.b.WRAP_CONTENT) || bVar5 == e.b.FIXED)) {
                        if (i5 == 3) {
                            if (bVar5 == bVar) {
                                l(next, bVar, 0, bVar, 0);
                            }
                            int R2 = next.R();
                            float f2 = next.U;
                            if (next.u() == -1) {
                                f2 = 1.0f / f2;
                            }
                            e.b bVar13 = e.b.FIXED;
                            l(next, bVar13, R2, bVar13, (int) ((((float) R2) * f2) + 0.5f));
                            next.f2328d.f2407e.d(next.R());
                            next.f2329e.f2407e.d(next.v());
                            next.f2325a = true;
                        } else if (i5 == 1) {
                            l(next, bVar5, 0, bVar, 0);
                            next.f2329e.f2407e.m = next.v();
                        } else if (i5 == 2) {
                            e.b[] bVarArr3 = fVar.Q;
                            e.b bVar14 = bVarArr3[1];
                            e.b bVar15 = e.b.FIXED;
                            if (bVar14 == bVar15 || bVarArr3[1] == bVar9) {
                                l(next, bVar5, next.R(), bVar15, (int) ((next.v * ((float) fVar.v())) + 0.5f));
                                next.f2328d.f2407e.d(next.R());
                                next.f2329e.f2407e.d(next.v());
                                next.f2325a = true;
                            }
                        } else {
                            d[] dVarArr2 = next.N;
                            if (dVarArr2[2].f2310f == null || dVarArr2[3].f2310f == null) {
                                l(next, bVar, 0, bVar6, 0);
                                next.f2328d.f2407e.d(next.R());
                                next.f2329e.f2407e.d(next.v());
                                next.f2325a = true;
                            }
                        }
                    }
                    if (bVar5 == bVar8 && bVar6 == bVar8) {
                        if (i4 == 1 || i5 == 1) {
                            e.b bVar16 = e.b.WRAP_CONTENT;
                            l(next, bVar16, 0, bVar16, 0);
                            next.f2328d.f2407e.m = next.R();
                            next.f2329e.f2407e.m = next.v();
                        } else if (i5 == 2 && i4 == 2) {
                            e.b[] bVarArr4 = fVar.Q;
                            e.b bVar17 = bVarArr4[0];
                            e.b bVar18 = e.b.FIXED;
                            if ((bVar17 == bVar18 || bVarArr4[0] == bVar18) && (bVarArr4[1] == bVar18 || bVarArr4[1] == bVar18)) {
                                l(next, bVar18, (int) ((next.s * ((float) fVar.R())) + 0.5f), bVar18, (int) ((next.v * ((float) fVar.v())) + 0.5f));
                                next.f2328d.f2407e.d(next.R());
                                next.f2329e.f2407e.d(next.v());
                                next.f2325a = true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    private int e(f fVar, int i2) {
        int size = this.f2367h.size();
        long j2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            j2 = Math.max(j2, this.f2367h.get(i3).b(fVar, i2));
        }
        return (int) j2;
    }

    private void i(p pVar, int i2, ArrayList<m> arrayList) {
        for (d dVar : pVar.f2410h.f2378k) {
            if (dVar instanceof f) {
                a((f) dVar, i2, 0, pVar.f2411i, arrayList, null);
            } else if (dVar instanceof p) {
                a(((p) dVar).f2410h, i2, 0, pVar.f2411i, arrayList, null);
            }
        }
        for (d dVar2 : pVar.f2411i.f2378k) {
            if (dVar2 instanceof f) {
                a((f) dVar2, i2, 1, pVar.f2410h, arrayList, null);
            } else if (dVar2 instanceof p) {
                a(((p) dVar2).f2411i, i2, 1, pVar.f2410h, arrayList, null);
            }
        }
        if (i2 == 1) {
            for (d dVar3 : ((n) pVar).f2395k.f2378k) {
                if (dVar3 instanceof f) {
                    a((f) dVar3, i2, 2, null, arrayList, null);
                }
            }
        }
    }

    private void l(b.f.b.k.e eVar, e.b bVar, int i2, e.b bVar2, int i3) {
        b.a aVar = this.f2366g;
        aVar.f2349a = bVar;
        aVar.f2350b = bVar2;
        aVar.f2351c = i2;
        aVar.f2352d = i3;
        this.f2365f.a(eVar, aVar);
        eVar.U0(this.f2366g.f2353e);
        eVar.v0(this.f2366g.f2354f);
        eVar.u0(this.f2366g.f2356h);
        eVar.k0(this.f2366g.f2355g);
    }

    public void c() {
        d(this.f2364e);
        this.f2367h.clear();
        m.f2391d = 0;
        i(this.f2360a.f2328d, 0, this.f2367h);
        i(this.f2360a.f2329e, 1, this.f2367h);
        this.f2361b = false;
    }

    public void d(ArrayList<p> arrayList) {
        arrayList.clear();
        this.f2363d.f2328d.f();
        this.f2363d.f2329e.f();
        arrayList.add(this.f2363d.f2328d);
        arrayList.add(this.f2363d.f2329e);
        Iterator<b.f.b.k.e> it = this.f2363d.p0.iterator();
        HashSet hashSet = null;
        while (it.hasNext()) {
            b.f.b.k.e next = it.next();
            if (next instanceof g) {
                arrayList.add(new j(next));
            } else {
                if (next.Z()) {
                    if (next.f2326b == null) {
                        next.f2326b = new c(next, 0);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(next.f2326b);
                } else {
                    arrayList.add(next.f2328d);
                }
                if (next.b0()) {
                    if (next.f2327c == null) {
                        next.f2327c = new c(next, 1);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(next.f2327c);
                } else {
                    arrayList.add(next.f2329e);
                }
                if (next instanceof i) {
                    arrayList.add(new k(next));
                }
            }
        }
        if (hashSet != null) {
            arrayList.addAll(hashSet);
        }
        Iterator<p> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            it2.next().f();
        }
        Iterator<p> it3 = arrayList.iterator();
        while (it3.hasNext()) {
            p next2 = it3.next();
            if (next2.f2404b != this.f2363d) {
                next2.d();
            }
        }
    }

    public boolean f(boolean z) {
        boolean z2;
        boolean z3 = true;
        boolean z4 = z & true;
        if (this.f2361b || this.f2362c) {
            Iterator<b.f.b.k.e> it = this.f2360a.p0.iterator();
            while (it.hasNext()) {
                b.f.b.k.e next = it.next();
                next.l();
                next.f2325a = false;
                next.f2328d.r();
                next.f2329e.q();
            }
            this.f2360a.l();
            f fVar = this.f2360a;
            fVar.f2325a = false;
            fVar.f2328d.r();
            this.f2360a.f2329e.q();
            this.f2362c = false;
        }
        if (b(this.f2363d)) {
            return false;
        }
        this.f2360a.V0(0);
        this.f2360a.W0(0);
        e.b s = this.f2360a.s(0);
        e.b s2 = this.f2360a.s(1);
        if (this.f2361b) {
            c();
        }
        int S = this.f2360a.S();
        int T = this.f2360a.T();
        this.f2360a.f2328d.f2410h.d(S);
        this.f2360a.f2329e.f2410h.d(T);
        m();
        e.b bVar = e.b.WRAP_CONTENT;
        if (s == bVar || s2 == bVar) {
            if (z4) {
                Iterator<p> it2 = this.f2364e.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (!it2.next().m()) {
                            z4 = false;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            if (z4 && s == e.b.WRAP_CONTENT) {
                this.f2360a.z0(e.b.FIXED);
                f fVar2 = this.f2360a;
                fVar2.U0(e(fVar2, 0));
                f fVar3 = this.f2360a;
                fVar3.f2328d.f2407e.d(fVar3.R());
            }
            if (z4 && s2 == e.b.WRAP_CONTENT) {
                this.f2360a.Q0(e.b.FIXED);
                f fVar4 = this.f2360a;
                fVar4.v0(e(fVar4, 1));
                f fVar5 = this.f2360a;
                fVar5.f2329e.f2407e.d(fVar5.v());
            }
        }
        f fVar6 = this.f2360a;
        e.b[] bVarArr = fVar6.Q;
        e.b bVar2 = bVarArr[0];
        e.b bVar3 = e.b.FIXED;
        if (bVar2 == bVar3 || bVarArr[0] == e.b.MATCH_PARENT) {
            int R = fVar6.R() + S;
            this.f2360a.f2328d.f2411i.d(R);
            this.f2360a.f2328d.f2407e.d(R - S);
            m();
            f fVar7 = this.f2360a;
            e.b[] bVarArr2 = fVar7.Q;
            if (bVarArr2[1] == bVar3 || bVarArr2[1] == e.b.MATCH_PARENT) {
                int v = fVar7.v() + T;
                this.f2360a.f2329e.f2411i.d(v);
                this.f2360a.f2329e.f2407e.d(v - T);
            }
            m();
            z2 = true;
        } else {
            z2 = false;
        }
        Iterator<p> it3 = this.f2364e.iterator();
        while (it3.hasNext()) {
            p next2 = it3.next();
            if (next2.f2404b != this.f2360a || next2.f2409g) {
                next2.e();
            }
        }
        Iterator<p> it4 = this.f2364e.iterator();
        while (true) {
            if (!it4.hasNext()) {
                break;
            }
            p next3 = it4.next();
            if ((z2 || next3.f2404b != this.f2360a) && (!next3.f2410h.f2377j || ((!next3.f2411i.f2377j && !(next3 instanceof j)) || (!next3.f2407e.f2377j && !(next3 instanceof c) && !(next3 instanceof j))))) {
                z3 = false;
            }
        }
        z3 = false;
        this.f2360a.z0(s);
        this.f2360a.Q0(s2);
        return z3;
    }

    public boolean g(boolean z) {
        if (this.f2361b) {
            Iterator<b.f.b.k.e> it = this.f2360a.p0.iterator();
            while (it.hasNext()) {
                b.f.b.k.e next = it.next();
                next.l();
                next.f2325a = false;
                l lVar = next.f2328d;
                lVar.f2407e.f2377j = false;
                lVar.f2409g = false;
                lVar.r();
                n nVar = next.f2329e;
                nVar.f2407e.f2377j = false;
                nVar.f2409g = false;
                nVar.q();
            }
            this.f2360a.l();
            f fVar = this.f2360a;
            fVar.f2325a = false;
            l lVar2 = fVar.f2328d;
            lVar2.f2407e.f2377j = false;
            lVar2.f2409g = false;
            lVar2.r();
            n nVar2 = this.f2360a.f2329e;
            nVar2.f2407e.f2377j = false;
            nVar2.f2409g = false;
            nVar2.q();
            c();
        }
        if (b(this.f2363d)) {
            return false;
        }
        this.f2360a.V0(0);
        this.f2360a.W0(0);
        this.f2360a.f2328d.f2410h.d(0);
        this.f2360a.f2329e.f2410h.d(0);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0143 A[EDGE_INSN: B:77:0x0143->B:62:0x0143 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean h(boolean r10, int r11) {
        /*
        // Method dump skipped, instructions count: 334
        */
        throw new UnsupportedOperationException("Method not decompiled: b.f.b.k.m.e.h(boolean, int):boolean");
    }

    public void j() {
        this.f2361b = true;
    }

    public void k() {
        this.f2362c = true;
    }

    public void m() {
        g gVar;
        Iterator<b.f.b.k.e> it = this.f2360a.p0.iterator();
        while (it.hasNext()) {
            b.f.b.k.e next = it.next();
            if (!next.f2325a) {
                e.b[] bVarArr = next.Q;
                boolean z = false;
                e.b bVar = bVarArr[0];
                e.b bVar2 = bVarArr[1];
                int i2 = next.n;
                int i3 = next.o;
                e.b bVar3 = e.b.WRAP_CONTENT;
                boolean z2 = bVar == bVar3 || (bVar == e.b.MATCH_CONSTRAINT && i2 == 1);
                if (bVar2 == bVar3 || (bVar2 == e.b.MATCH_CONSTRAINT && i3 == 1)) {
                    z = true;
                }
                g gVar2 = next.f2328d.f2407e;
                boolean z3 = gVar2.f2377j;
                g gVar3 = next.f2329e.f2407e;
                boolean z4 = gVar3.f2377j;
                if (z3 && z4) {
                    e.b bVar4 = e.b.FIXED;
                    l(next, bVar4, gVar2.f2374g, bVar4, gVar3.f2374g);
                    next.f2325a = true;
                } else if (z3 && z) {
                    l(next, e.b.FIXED, gVar2.f2374g, bVar3, gVar3.f2374g);
                    if (bVar2 == e.b.MATCH_CONSTRAINT) {
                        next.f2329e.f2407e.m = next.v();
                    } else {
                        next.f2329e.f2407e.d(next.v());
                        next.f2325a = true;
                    }
                } else if (z4 && z2) {
                    l(next, bVar3, gVar2.f2374g, e.b.FIXED, gVar3.f2374g);
                    if (bVar == e.b.MATCH_CONSTRAINT) {
                        next.f2328d.f2407e.m = next.R();
                    } else {
                        next.f2328d.f2407e.d(next.R());
                        next.f2325a = true;
                    }
                }
                if (next.f2325a && (gVar = next.f2329e.l) != null) {
                    gVar.d(next.n());
                }
            }
        }
    }

    public void n(b.AbstractC0036b bVar) {
        this.f2365f = bVar;
    }
}
