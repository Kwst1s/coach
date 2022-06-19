package b.f.b.k.m;

import b.f.b.k.d;
import b.f.b.k.e;

/* compiled from: WidgetRun */
public abstract class p implements d {

    /* renamed from: a  reason: collision with root package name */
    public int f2403a;

    /* renamed from: b  reason: collision with root package name */
    e f2404b;

    /* renamed from: c  reason: collision with root package name */
    m f2405c;

    /* renamed from: d  reason: collision with root package name */
    protected e.b f2406d;

    /* renamed from: e  reason: collision with root package name */
    g f2407e = new g(this);

    /* renamed from: f  reason: collision with root package name */
    public int f2408f = 0;

    /* renamed from: g  reason: collision with root package name */
    boolean f2409g = false;

    /* renamed from: h  reason: collision with root package name */
    public f f2410h = new f(this);

    /* renamed from: i  reason: collision with root package name */
    public f f2411i = new f(this);

    /* renamed from: j  reason: collision with root package name */
    protected b f2412j = b.NONE;

    /* access modifiers changed from: package-private */
    /* compiled from: WidgetRun */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2413a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                b.f.b.k.d$b[] r0 = b.f.b.k.d.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                b.f.b.k.m.p.a.f2413a = r0
                b.f.b.k.d$b r1 = b.f.b.k.d.b.LEFT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = b.f.b.k.m.p.a.f2413a     // Catch:{ NoSuchFieldError -> 0x001d }
                b.f.b.k.d$b r1 = b.f.b.k.d.b.RIGHT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = b.f.b.k.m.p.a.f2413a     // Catch:{ NoSuchFieldError -> 0x0028 }
                b.f.b.k.d$b r1 = b.f.b.k.d.b.TOP     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = b.f.b.k.m.p.a.f2413a     // Catch:{ NoSuchFieldError -> 0x0033 }
                b.f.b.k.d$b r1 = b.f.b.k.d.b.BASELINE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = b.f.b.k.m.p.a.f2413a     // Catch:{ NoSuchFieldError -> 0x003e }
                b.f.b.k.d$b r1 = b.f.b.k.d.b.BOTTOM     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: b.f.b.k.m.p.a.<clinit>():void");
        }
    }

    /* compiled from: WidgetRun */
    enum b {
        NONE,
        START,
        END,
        CENTER
    }

    public p(e eVar) {
        this.f2404b = eVar;
    }

    private void l(int i2, int i3) {
        int i4;
        int i5 = this.f2403a;
        if (i5 == 0) {
            this.f2407e.d(g(i3, i2));
        } else if (i5 == 1) {
            this.f2407e.d(Math.min(g(this.f2407e.m, i2), i3));
        } else if (i5 == 2) {
            e I = this.f2404b.I();
            if (I != null) {
                g gVar = (i2 == 0 ? I.f2328d : I.f2329e).f2407e;
                if (gVar.f2377j) {
                    e eVar = this.f2404b;
                    this.f2407e.d(g((int) ((((float) gVar.f2374g) * (i2 == 0 ? eVar.s : eVar.v)) + 0.5f), i2));
                }
            }
        } else if (i5 == 3) {
            e eVar2 = this.f2404b;
            p pVar = eVar2.f2328d;
            e.b bVar = pVar.f2406d;
            e.b bVar2 = e.b.MATCH_CONSTRAINT;
            if (bVar == bVar2 && pVar.f2403a == 3) {
                n nVar = eVar2.f2329e;
                if (nVar.f2406d == bVar2 && nVar.f2403a == 3) {
                    return;
                }
            }
            if (i2 == 0) {
                pVar = eVar2.f2329e;
            }
            if (pVar.f2407e.f2377j) {
                float t = eVar2.t();
                if (i2 == 1) {
                    i4 = (int) ((((float) pVar.f2407e.f2374g) / t) + 0.5f);
                } else {
                    i4 = (int) ((t * ((float) pVar.f2407e.f2374g)) + 0.5f);
                }
                this.f2407e.d(i4);
            }
        }
    }

    @Override // b.f.b.k.m.d
    public void a(d dVar) {
    }

    /* access modifiers changed from: protected */
    public final void b(f fVar, f fVar2, int i2) {
        fVar.l.add(fVar2);
        fVar.f2373f = i2;
        fVar2.f2378k.add(fVar);
    }

    /* access modifiers changed from: protected */
    public final void c(f fVar, f fVar2, int i2, g gVar) {
        fVar.l.add(fVar2);
        fVar.l.add(this.f2407e);
        fVar.f2375h = i2;
        fVar.f2376i = gVar;
        fVar2.f2378k.add(fVar);
        gVar.f2378k.add(fVar);
    }

    /* access modifiers changed from: package-private */
    public abstract void d();

    /* access modifiers changed from: package-private */
    public abstract void e();

    /* access modifiers changed from: package-private */
    public abstract void f();

    /* access modifiers changed from: protected */
    public final int g(int i2, int i3) {
        int i4;
        if (i3 == 0) {
            e eVar = this.f2404b;
            int i5 = eVar.r;
            i4 = Math.max(eVar.q, i2);
            if (i5 > 0) {
                i4 = Math.min(i5, i2);
            }
            if (i4 == i2) {
                return i2;
            }
        } else {
            e eVar2 = this.f2404b;
            int i6 = eVar2.u;
            i4 = Math.max(eVar2.t, i2);
            if (i6 > 0) {
                i4 = Math.min(i6, i2);
            }
            if (i4 == i2) {
                return i2;
            }
        }
        return i4;
    }

    /* access modifiers changed from: protected */
    public final f h(d dVar) {
        d dVar2 = dVar.f2310f;
        if (dVar2 == null) {
            return null;
        }
        e eVar = dVar2.f2308d;
        int i2 = a.f2413a[dVar2.f2309e.ordinal()];
        if (i2 == 1) {
            return eVar.f2328d.f2410h;
        }
        if (i2 == 2) {
            return eVar.f2328d.f2411i;
        }
        if (i2 == 3) {
            return eVar.f2329e.f2410h;
        }
        if (i2 == 4) {
            return eVar.f2329e.f2395k;
        }
        if (i2 != 5) {
            return null;
        }
        return eVar.f2329e.f2411i;
    }

    /* access modifiers changed from: protected */
    public final f i(d dVar, int i2) {
        d dVar2 = dVar.f2310f;
        if (dVar2 == null) {
            return null;
        }
        e eVar = dVar2.f2308d;
        p pVar = i2 == 0 ? eVar.f2328d : eVar.f2329e;
        int i3 = a.f2413a[dVar2.f2309e.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 5) {
                        return null;
                    }
                }
            }
            return pVar.f2411i;
        }
        return pVar.f2410h;
    }

    public long j() {
        g gVar = this.f2407e;
        if (gVar.f2377j) {
            return (long) gVar.f2374g;
        }
        return 0;
    }

    public boolean k() {
        return this.f2409g;
    }

    /* access modifiers changed from: package-private */
    public abstract boolean m();

    /* access modifiers changed from: protected */
    public void n(d dVar, d dVar2, d dVar3, int i2) {
        float f2;
        f h2 = h(dVar2);
        f h3 = h(dVar3);
        if (h2.f2377j && h3.f2377j) {
            int e2 = h2.f2374g + dVar2.e();
            int e3 = h3.f2374g - dVar3.e();
            int i3 = e3 - e2;
            if (!this.f2407e.f2377j && this.f2406d == e.b.MATCH_CONSTRAINT) {
                l(i2, i3);
            }
            g gVar = this.f2407e;
            if (gVar.f2377j) {
                if (gVar.f2374g == i3) {
                    this.f2410h.d(e2);
                    this.f2411i.d(e3);
                    return;
                }
                e eVar = this.f2404b;
                if (i2 == 0) {
                    f2 = eVar.w();
                } else {
                    f2 = eVar.M();
                }
                if (h2 == h3) {
                    e2 = h2.f2374g;
                    e3 = h3.f2374g;
                    f2 = 0.5f;
                }
                this.f2410h.d((int) (((float) e2) + 0.5f + (((float) ((e3 - e2) - this.f2407e.f2374g)) * f2)));
                this.f2411i.d(this.f2410h.f2374g + this.f2407e.f2374g);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void o(d dVar) {
    }

    /* access modifiers changed from: protected */
    public void p(d dVar) {
    }
}
