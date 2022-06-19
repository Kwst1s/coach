package b.f.b.k.m;

import b.f.b.k.d;
import b.f.b.k.e;
import b.f.b.k.h;
import b.f.b.k.m.f;
import b.f.b.k.m.p;

/* compiled from: HorizontalWidgetRun */
public class l extends p {

    /* renamed from: k  reason: collision with root package name */
    private static int[] f2389k = new int[2];

    /* compiled from: HorizontalWidgetRun */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2390a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                b.f.b.k.m.p$b[] r0 = b.f.b.k.m.p.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                b.f.b.k.m.l.a.f2390a = r0
                b.f.b.k.m.p$b r1 = b.f.b.k.m.p.b.START     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = b.f.b.k.m.l.a.f2390a     // Catch:{ NoSuchFieldError -> 0x001d }
                b.f.b.k.m.p$b r1 = b.f.b.k.m.p.b.END     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = b.f.b.k.m.l.a.f2390a     // Catch:{ NoSuchFieldError -> 0x0028 }
                b.f.b.k.m.p$b r1 = b.f.b.k.m.p.b.CENTER     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: b.f.b.k.m.l.a.<clinit>():void");
        }
    }

    public l(e eVar) {
        super(eVar);
        this.f2410h.f2372e = f.a.LEFT;
        this.f2411i.f2372e = f.a.RIGHT;
        this.f2408f = 0;
    }

    private void q(int[] iArr, int i2, int i3, int i4, int i5, float f2, int i6) {
        int i7 = i3 - i2;
        int i8 = i5 - i4;
        if (i6 == -1) {
            int i9 = (int) ((((float) i8) * f2) + 0.5f);
            int i10 = (int) ((((float) i7) / f2) + 0.5f);
            if (i9 <= i7 && i8 <= i8) {
                iArr[0] = i9;
                iArr[1] = i8;
            } else if (i7 <= i7 && i10 <= i8) {
                iArr[0] = i7;
                iArr[1] = i10;
            }
        } else if (i6 == 0) {
            iArr[0] = (int) ((((float) i8) * f2) + 0.5f);
            iArr[1] = i8;
        } else if (i6 == 1) {
            iArr[0] = i7;
            iArr[1] = (int) ((((float) i7) * f2) + 0.5f);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:104:0x02bc, code lost:
        if (r14 != 1) goto L_0x0324;
     */
    @Override // b.f.b.k.m.d, b.f.b.k.m.p
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(b.f.b.k.m.d r17) {
        /*
        // Method dump skipped, instructions count: 1095
        */
        throw new UnsupportedOperationException("Method not decompiled: b.f.b.k.m.l.a(b.f.b.k.m.d):void");
    }

    /* access modifiers changed from: package-private */
    @Override // b.f.b.k.m.p
    public void d() {
        e I;
        e I2;
        e eVar = this.f2404b;
        if (eVar.f2325a) {
            this.f2407e.d(eVar.R());
        }
        if (!this.f2407e.f2377j) {
            e.b y = this.f2404b.y();
            this.f2406d = y;
            if (y != e.b.MATCH_CONSTRAINT) {
                e.b bVar = e.b.MATCH_PARENT;
                if (y == bVar && (((I2 = this.f2404b.I()) != null && I2.y() == e.b.FIXED) || I2.y() == bVar)) {
                    int R = (I2.R() - this.f2404b.F.e()) - this.f2404b.H.e();
                    b(this.f2410h, I2.f2328d.f2410h, this.f2404b.F.e());
                    b(this.f2411i, I2.f2328d.f2411i, -this.f2404b.H.e());
                    this.f2407e.d(R);
                    return;
                } else if (this.f2406d == e.b.FIXED) {
                    this.f2407e.d(this.f2404b.R());
                }
            }
        } else {
            e.b bVar2 = this.f2406d;
            e.b bVar3 = e.b.MATCH_PARENT;
            if (bVar2 == bVar3 && (((I = this.f2404b.I()) != null && I.y() == e.b.FIXED) || I.y() == bVar3)) {
                b(this.f2410h, I.f2328d.f2410h, this.f2404b.F.e());
                b(this.f2411i, I.f2328d.f2411i, -this.f2404b.H.e());
                return;
            }
        }
        g gVar = this.f2407e;
        if (gVar.f2377j) {
            e eVar2 = this.f2404b;
            if (eVar2.f2325a) {
                d[] dVarArr = eVar2.N;
                if (dVarArr[0].f2310f == null || dVarArr[1].f2310f == null) {
                    if (dVarArr[0].f2310f != null) {
                        f h2 = h(dVarArr[0]);
                        if (h2 != null) {
                            b(this.f2410h, h2, this.f2404b.N[0].e());
                            b(this.f2411i, this.f2410h, this.f2407e.f2374g);
                            return;
                        }
                        return;
                    } else if (dVarArr[1].f2310f != null) {
                        f h3 = h(dVarArr[1]);
                        if (h3 != null) {
                            b(this.f2411i, h3, -this.f2404b.N[1].e());
                            b(this.f2410h, this.f2411i, -this.f2407e.f2374g);
                            return;
                        }
                        return;
                    } else if (!(eVar2 instanceof h) && eVar2.I() != null && this.f2404b.m(d.b.CENTER).f2310f == null) {
                        b(this.f2410h, this.f2404b.I().f2328d.f2410h, this.f2404b.S());
                        b(this.f2411i, this.f2410h, this.f2407e.f2374g);
                        return;
                    } else {
                        return;
                    }
                } else if (eVar2.Z()) {
                    this.f2410h.f2373f = this.f2404b.N[0].e();
                    this.f2411i.f2373f = -this.f2404b.N[1].e();
                    return;
                } else {
                    f h4 = h(this.f2404b.N[0]);
                    if (h4 != null) {
                        b(this.f2410h, h4, this.f2404b.N[0].e());
                    }
                    f h5 = h(this.f2404b.N[1]);
                    if (h5 != null) {
                        b(this.f2411i, h5, -this.f2404b.N[1].e());
                    }
                    this.f2410h.f2369b = true;
                    this.f2411i.f2369b = true;
                    return;
                }
            }
        }
        if (this.f2406d == e.b.MATCH_CONSTRAINT) {
            e eVar3 = this.f2404b;
            int i2 = eVar3.n;
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
            } else if (i2 == 3) {
                if (eVar3.o == 3) {
                    this.f2410h.f2368a = this;
                    this.f2411i.f2368a = this;
                    n nVar = eVar3.f2329e;
                    nVar.f2410h.f2368a = this;
                    nVar.f2411i.f2368a = this;
                    gVar.f2368a = this;
                    if (eVar3.b0()) {
                        this.f2407e.l.add(this.f2404b.f2329e.f2407e);
                        this.f2404b.f2329e.f2407e.f2378k.add(this.f2407e);
                        n nVar2 = this.f2404b.f2329e;
                        nVar2.f2407e.f2368a = this;
                        this.f2407e.l.add(nVar2.f2410h);
                        this.f2407e.l.add(this.f2404b.f2329e.f2411i);
                        this.f2404b.f2329e.f2410h.f2378k.add(this.f2407e);
                        this.f2404b.f2329e.f2411i.f2378k.add(this.f2407e);
                    } else if (this.f2404b.Z()) {
                        this.f2404b.f2329e.f2407e.l.add(this.f2407e);
                        this.f2407e.f2378k.add(this.f2404b.f2329e.f2407e);
                    } else {
                        this.f2404b.f2329e.f2407e.l.add(this.f2407e);
                    }
                } else {
                    g gVar4 = eVar3.f2329e.f2407e;
                    gVar.l.add(gVar4);
                    gVar4.f2378k.add(this.f2407e);
                    this.f2404b.f2329e.f2410h.f2378k.add(this.f2407e);
                    this.f2404b.f2329e.f2411i.f2378k.add(this.f2407e);
                    g gVar5 = this.f2407e;
                    gVar5.f2369b = true;
                    gVar5.f2378k.add(this.f2410h);
                    this.f2407e.f2378k.add(this.f2411i);
                    this.f2410h.l.add(this.f2407e);
                    this.f2411i.l.add(this.f2407e);
                }
            }
        }
        e eVar4 = this.f2404b;
        d[] dVarArr2 = eVar4.N;
        if (dVarArr2[0].f2310f == null || dVarArr2[1].f2310f == null) {
            if (dVarArr2[0].f2310f != null) {
                f h6 = h(dVarArr2[0]);
                if (h6 != null) {
                    b(this.f2410h, h6, this.f2404b.N[0].e());
                    c(this.f2411i, this.f2410h, 1, this.f2407e);
                }
            } else if (dVarArr2[1].f2310f != null) {
                f h7 = h(dVarArr2[1]);
                if (h7 != null) {
                    b(this.f2411i, h7, -this.f2404b.N[1].e());
                    c(this.f2410h, this.f2411i, -1, this.f2407e);
                }
            } else if (!(eVar4 instanceof h) && eVar4.I() != null) {
                b(this.f2410h, this.f2404b.I().f2328d.f2410h, this.f2404b.S());
                c(this.f2411i, this.f2410h, 1, this.f2407e);
            }
        } else if (eVar4.Z()) {
            this.f2410h.f2373f = this.f2404b.N[0].e();
            this.f2411i.f2373f = -this.f2404b.N[1].e();
        } else {
            f h8 = h(this.f2404b.N[0]);
            f h9 = h(this.f2404b.N[1]);
            h8.b(this);
            h9.b(this);
            this.f2412j = p.b.CENTER;
        }
    }

    @Override // b.f.b.k.m.p
    public void e() {
        f fVar = this.f2410h;
        if (fVar.f2377j) {
            this.f2404b.V0(fVar.f2374g);
        }
    }

    /* access modifiers changed from: package-private */
    @Override // b.f.b.k.m.p
    public void f() {
        this.f2405c = null;
        this.f2410h.c();
        this.f2411i.c();
        this.f2407e.c();
        this.f2409g = false;
    }

    /* access modifiers changed from: package-private */
    @Override // b.f.b.k.m.p
    public boolean m() {
        if (this.f2406d != e.b.MATCH_CONSTRAINT || this.f2404b.n == 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void r() {
        this.f2409g = false;
        this.f2410h.c();
        this.f2410h.f2377j = false;
        this.f2411i.c();
        this.f2411i.f2377j = false;
        this.f2407e.f2377j = false;
    }

    public String toString() {
        return "HorizontalRun " + this.f2404b.r();
    }
}
