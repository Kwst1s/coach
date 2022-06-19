package b.f.b.k.m;

import b.f.b.k.d;
import b.f.b.k.e;
import b.f.b.k.h;
import b.f.b.k.m.f;
import b.f.b.k.m.p;
import com.github.mikephil.charting.utils.Utils;

/* compiled from: VerticalWidgetRun */
public class n extends p {

    /* renamed from: k  reason: collision with root package name */
    public f f2395k;
    g l = null;

    /* compiled from: VerticalWidgetRun */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2396a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                b.f.b.k.m.p$b[] r0 = b.f.b.k.m.p.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                b.f.b.k.m.n.a.f2396a = r0
                b.f.b.k.m.p$b r1 = b.f.b.k.m.p.b.START     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = b.f.b.k.m.n.a.f2396a     // Catch:{ NoSuchFieldError -> 0x001d }
                b.f.b.k.m.p$b r1 = b.f.b.k.m.p.b.END     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = b.f.b.k.m.n.a.f2396a     // Catch:{ NoSuchFieldError -> 0x0028 }
                b.f.b.k.m.p$b r1 = b.f.b.k.m.p.b.CENTER     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: b.f.b.k.m.n.a.<clinit>():void");
        }
    }

    public n(e eVar) {
        super(eVar);
        f fVar = new f(this);
        this.f2395k = fVar;
        this.f2410h.f2372e = f.a.TOP;
        this.f2411i.f2372e = f.a.BOTTOM;
        fVar.f2372e = f.a.BASELINE;
        this.f2408f = 1;
    }

    @Override // b.f.b.k.m.d, b.f.b.k.m.p
    public void a(d dVar) {
        int i2;
        float f2;
        float f3;
        float f4;
        int i3 = a.f2396a[this.f2412j.ordinal()];
        if (i3 == 1) {
            p(dVar);
        } else if (i3 == 2) {
            o(dVar);
        } else if (i3 == 3) {
            e eVar = this.f2404b;
            n(dVar, eVar.G, eVar.I, 1);
            return;
        }
        g gVar = this.f2407e;
        if (gVar.f2370c && !gVar.f2377j && this.f2406d == e.b.MATCH_CONSTRAINT) {
            e eVar2 = this.f2404b;
            int i4 = eVar2.o;
            if (i4 == 2) {
                e I = eVar2.I();
                if (I != null) {
                    g gVar2 = I.f2329e.f2407e;
                    if (gVar2.f2377j) {
                        float f5 = this.f2404b.v;
                        this.f2407e.d((int) ((((float) gVar2.f2374g) * f5) + 0.5f));
                    }
                }
            } else if (i4 == 3 && eVar2.f2328d.f2407e.f2377j) {
                int u = eVar2.u();
                if (u == -1) {
                    e eVar3 = this.f2404b;
                    f4 = (float) eVar3.f2328d.f2407e.f2374g;
                    f3 = eVar3.t();
                } else if (u == 0) {
                    e eVar4 = this.f2404b;
                    f2 = ((float) eVar4.f2328d.f2407e.f2374g) * eVar4.t();
                    i2 = (int) (f2 + 0.5f);
                    this.f2407e.d(i2);
                } else if (u != 1) {
                    i2 = 0;
                    this.f2407e.d(i2);
                } else {
                    e eVar5 = this.f2404b;
                    f4 = (float) eVar5.f2328d.f2407e.f2374g;
                    f3 = eVar5.t();
                }
                f2 = f4 / f3;
                i2 = (int) (f2 + 0.5f);
                this.f2407e.d(i2);
            }
        }
        f fVar = this.f2410h;
        if (fVar.f2370c) {
            f fVar2 = this.f2411i;
            if (fVar2.f2370c) {
                if (!fVar.f2377j || !fVar2.f2377j || !this.f2407e.f2377j) {
                    if (!this.f2407e.f2377j && this.f2406d == e.b.MATCH_CONSTRAINT) {
                        e eVar6 = this.f2404b;
                        if (eVar6.n == 0 && !eVar6.b0()) {
                            int i5 = this.f2410h.l.get(0).f2374g;
                            f fVar3 = this.f2410h;
                            int i6 = i5 + fVar3.f2373f;
                            int i7 = this.f2411i.l.get(0).f2374g + this.f2411i.f2373f;
                            fVar3.d(i6);
                            this.f2411i.d(i7);
                            this.f2407e.d(i7 - i6);
                            return;
                        }
                    }
                    if (!this.f2407e.f2377j && this.f2406d == e.b.MATCH_CONSTRAINT && this.f2403a == 1 && this.f2410h.l.size() > 0 && this.f2411i.l.size() > 0) {
                        int i8 = (this.f2411i.l.get(0).f2374g + this.f2411i.f2373f) - (this.f2410h.l.get(0).f2374g + this.f2410h.f2373f);
                        g gVar3 = this.f2407e;
                        int i9 = gVar3.m;
                        if (i8 < i9) {
                            gVar3.d(i8);
                        } else {
                            gVar3.d(i9);
                        }
                    }
                    if (this.f2407e.f2377j && this.f2410h.l.size() > 0 && this.f2411i.l.size() > 0) {
                        f fVar4 = this.f2410h.l.get(0);
                        f fVar5 = this.f2411i.l.get(0);
                        int i10 = fVar4.f2374g + this.f2410h.f2373f;
                        int i11 = fVar5.f2374g + this.f2411i.f2373f;
                        float M = this.f2404b.M();
                        if (fVar4 == fVar5) {
                            i10 = fVar4.f2374g;
                            i11 = fVar5.f2374g;
                            M = 0.5f;
                        }
                        this.f2410h.d((int) (((float) i10) + 0.5f + (((float) ((i11 - i10) - this.f2407e.f2374g)) * M)));
                        this.f2411i.d(this.f2410h.f2374g + this.f2407e.f2374g);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    @Override // b.f.b.k.m.p
    public void d() {
        e I;
        e I2;
        e eVar = this.f2404b;
        if (eVar.f2325a) {
            this.f2407e.d(eVar.v());
        }
        if (!this.f2407e.f2377j) {
            this.f2406d = this.f2404b.O();
            if (this.f2404b.U()) {
                this.l = new a(this);
            }
            e.b bVar = this.f2406d;
            if (bVar != e.b.MATCH_CONSTRAINT) {
                if (bVar == e.b.MATCH_PARENT && (I2 = this.f2404b.I()) != null && I2.O() == e.b.FIXED) {
                    int v = (I2.v() - this.f2404b.G.e()) - this.f2404b.I.e();
                    b(this.f2410h, I2.f2329e.f2410h, this.f2404b.G.e());
                    b(this.f2411i, I2.f2329e.f2411i, -this.f2404b.I.e());
                    this.f2407e.d(v);
                    return;
                } else if (this.f2406d == e.b.FIXED) {
                    this.f2407e.d(this.f2404b.v());
                }
            }
        } else if (this.f2406d == e.b.MATCH_PARENT && (I = this.f2404b.I()) != null && I.O() == e.b.FIXED) {
            b(this.f2410h, I.f2329e.f2410h, this.f2404b.G.e());
            b(this.f2411i, I.f2329e.f2411i, -this.f2404b.I.e());
            return;
        }
        g gVar = this.f2407e;
        boolean z = gVar.f2377j;
        if (z) {
            e eVar2 = this.f2404b;
            if (eVar2.f2325a) {
                d[] dVarArr = eVar2.N;
                if (dVarArr[2].f2310f != null && dVarArr[3].f2310f != null) {
                    if (eVar2.b0()) {
                        this.f2410h.f2373f = this.f2404b.N[2].e();
                        this.f2411i.f2373f = -this.f2404b.N[3].e();
                    } else {
                        f h2 = h(this.f2404b.N[2]);
                        if (h2 != null) {
                            b(this.f2410h, h2, this.f2404b.N[2].e());
                        }
                        f h3 = h(this.f2404b.N[3]);
                        if (h3 != null) {
                            b(this.f2411i, h3, -this.f2404b.N[3].e());
                        }
                        this.f2410h.f2369b = true;
                        this.f2411i.f2369b = true;
                    }
                    if (this.f2404b.U()) {
                        b(this.f2395k, this.f2410h, this.f2404b.n());
                        return;
                    }
                    return;
                } else if (dVarArr[2].f2310f != null) {
                    f h4 = h(dVarArr[2]);
                    if (h4 != null) {
                        b(this.f2410h, h4, this.f2404b.N[2].e());
                        b(this.f2411i, this.f2410h, this.f2407e.f2374g);
                        if (this.f2404b.U()) {
                            b(this.f2395k, this.f2410h, this.f2404b.n());
                            return;
                        }
                        return;
                    }
                    return;
                } else if (dVarArr[3].f2310f != null) {
                    f h5 = h(dVarArr[3]);
                    if (h5 != null) {
                        b(this.f2411i, h5, -this.f2404b.N[3].e());
                        b(this.f2410h, this.f2411i, -this.f2407e.f2374g);
                    }
                    if (this.f2404b.U()) {
                        b(this.f2395k, this.f2410h, this.f2404b.n());
                        return;
                    }
                    return;
                } else if (dVarArr[4].f2310f != null) {
                    f h6 = h(dVarArr[4]);
                    if (h6 != null) {
                        b(this.f2395k, h6, 0);
                        b(this.f2410h, this.f2395k, -this.f2404b.n());
                        b(this.f2411i, this.f2410h, this.f2407e.f2374g);
                        return;
                    }
                    return;
                } else if (!(eVar2 instanceof h) && eVar2.I() != null && this.f2404b.m(d.b.CENTER).f2310f == null) {
                    b(this.f2410h, this.f2404b.I().f2329e.f2410h, this.f2404b.T());
                    b(this.f2411i, this.f2410h, this.f2407e.f2374g);
                    if (this.f2404b.U()) {
                        b(this.f2395k, this.f2410h, this.f2404b.n());
                        return;
                    }
                    return;
                } else {
                    return;
                }
            }
        }
        if (z || this.f2406d != e.b.MATCH_CONSTRAINT) {
            gVar.b(this);
        } else {
            e eVar3 = this.f2404b;
            int i2 = eVar3.o;
            if (i2 == 2) {
                e I3 = eVar3.I();
                if (I3 != null) {
                    g gVar2 = I3.f2329e.f2407e;
                    this.f2407e.l.add(gVar2);
                    gVar2.f2378k.add(this.f2407e);
                    g gVar3 = this.f2407e;
                    gVar3.f2369b = true;
                    gVar3.f2378k.add(this.f2410h);
                    this.f2407e.f2378k.add(this.f2411i);
                }
            } else if (i2 == 3 && !eVar3.b0()) {
                e eVar4 = this.f2404b;
                if (eVar4.n != 3) {
                    g gVar4 = eVar4.f2328d.f2407e;
                    this.f2407e.l.add(gVar4);
                    gVar4.f2378k.add(this.f2407e);
                    g gVar5 = this.f2407e;
                    gVar5.f2369b = true;
                    gVar5.f2378k.add(this.f2410h);
                    this.f2407e.f2378k.add(this.f2411i);
                }
            }
        }
        e eVar5 = this.f2404b;
        d[] dVarArr2 = eVar5.N;
        if (dVarArr2[2].f2310f != null && dVarArr2[3].f2310f != null) {
            if (eVar5.b0()) {
                this.f2410h.f2373f = this.f2404b.N[2].e();
                this.f2411i.f2373f = -this.f2404b.N[3].e();
            } else {
                f h7 = h(this.f2404b.N[2]);
                f h8 = h(this.f2404b.N[3]);
                h7.b(this);
                h8.b(this);
                this.f2412j = p.b.CENTER;
            }
            if (this.f2404b.U()) {
                c(this.f2395k, this.f2410h, 1, this.l);
            }
        } else if (dVarArr2[2].f2310f != null) {
            f h9 = h(dVarArr2[2]);
            if (h9 != null) {
                b(this.f2410h, h9, this.f2404b.N[2].e());
                c(this.f2411i, this.f2410h, 1, this.f2407e);
                if (this.f2404b.U()) {
                    c(this.f2395k, this.f2410h, 1, this.l);
                }
                e.b bVar2 = this.f2406d;
                e.b bVar3 = e.b.MATCH_CONSTRAINT;
                if (bVar2 == bVar3 && this.f2404b.t() > Utils.FLOAT_EPSILON) {
                    l lVar = this.f2404b.f2328d;
                    if (lVar.f2406d == bVar3) {
                        lVar.f2407e.f2378k.add(this.f2407e);
                        this.f2407e.l.add(this.f2404b.f2328d.f2407e);
                        this.f2407e.f2368a = this;
                    }
                }
            }
        } else if (dVarArr2[3].f2310f != null) {
            f h10 = h(dVarArr2[3]);
            if (h10 != null) {
                b(this.f2411i, h10, -this.f2404b.N[3].e());
                c(this.f2410h, this.f2411i, -1, this.f2407e);
                if (this.f2404b.U()) {
                    c(this.f2395k, this.f2410h, 1, this.l);
                }
            }
        } else if (dVarArr2[4].f2310f != null) {
            f h11 = h(dVarArr2[4]);
            if (h11 != null) {
                b(this.f2395k, h11, 0);
                c(this.f2410h, this.f2395k, -1, this.l);
                c(this.f2411i, this.f2410h, 1, this.f2407e);
            }
        } else if (!(eVar5 instanceof h) && eVar5.I() != null) {
            b(this.f2410h, this.f2404b.I().f2329e.f2410h, this.f2404b.T());
            c(this.f2411i, this.f2410h, 1, this.f2407e);
            if (this.f2404b.U()) {
                c(this.f2395k, this.f2410h, 1, this.l);
            }
            e.b bVar4 = this.f2406d;
            e.b bVar5 = e.b.MATCH_CONSTRAINT;
            if (bVar4 == bVar5 && this.f2404b.t() > Utils.FLOAT_EPSILON) {
                l lVar2 = this.f2404b.f2328d;
                if (lVar2.f2406d == bVar5) {
                    lVar2.f2407e.f2378k.add(this.f2407e);
                    this.f2407e.l.add(this.f2404b.f2328d.f2407e);
                    this.f2407e.f2368a = this;
                }
            }
        }
        if (this.f2407e.l.size() == 0) {
            this.f2407e.f2370c = true;
        }
    }

    @Override // b.f.b.k.m.p
    public void e() {
        f fVar = this.f2410h;
        if (fVar.f2377j) {
            this.f2404b.W0(fVar.f2374g);
        }
    }

    /* access modifiers changed from: package-private */
    @Override // b.f.b.k.m.p
    public void f() {
        this.f2405c = null;
        this.f2410h.c();
        this.f2411i.c();
        this.f2395k.c();
        this.f2407e.c();
        this.f2409g = false;
    }

    /* access modifiers changed from: package-private */
    @Override // b.f.b.k.m.p
    public boolean m() {
        if (this.f2406d != e.b.MATCH_CONSTRAINT || this.f2404b.o == 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void q() {
        this.f2409g = false;
        this.f2410h.c();
        this.f2410h.f2377j = false;
        this.f2411i.c();
        this.f2411i.f2377j = false;
        this.f2395k.c();
        this.f2395k.f2377j = false;
        this.f2407e.f2377j = false;
    }

    public String toString() {
        return "VerticalRun " + this.f2404b.r();
    }
}
