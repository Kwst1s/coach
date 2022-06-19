package b.f.b;

import b.f.b.i;
import b.f.b.k.d;
import b.f.b.k.e;
import com.github.mikephil.charting.utils.Utils;
import java.util.Arrays;
import java.util.HashMap;

/* compiled from: LinearSystem */
public class d {
    public static boolean r = false;
    public static boolean s = true;
    public static boolean t = true;
    public static boolean u = true;
    public static boolean v = false;
    private static int w = 1000;
    public static e x;
    public static long y;
    public static long z;

    /* renamed from: a  reason: collision with root package name */
    public boolean f2235a;

    /* renamed from: b  reason: collision with root package name */
    int f2236b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap<String, i> f2237c;

    /* renamed from: d  reason: collision with root package name */
    private a f2238d;

    /* renamed from: e  reason: collision with root package name */
    private int f2239e;

    /* renamed from: f  reason: collision with root package name */
    private int f2240f;

    /* renamed from: g  reason: collision with root package name */
    b[] f2241g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f2242h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f2243i;

    /* renamed from: j  reason: collision with root package name */
    private boolean[] f2244j;

    /* renamed from: k  reason: collision with root package name */
    int f2245k;
    int l;
    private int m;
    final c n;
    private i[] o;
    private int p;
    private a q;

    /* access modifiers changed from: package-private */
    /* compiled from: LinearSystem */
    public interface a {
        void a(a aVar);

        void b(i iVar);

        i c(d dVar, boolean[] zArr);

        void clear();

        i getKey();

        boolean isEmpty();
    }

    /* access modifiers changed from: package-private */
    /* compiled from: LinearSystem */
    public class b extends b {
        public b(d dVar, c cVar) {
            this.f2229e = new j(this, cVar);
        }
    }

    public d() {
        this.f2235a = false;
        this.f2236b = 0;
        this.f2237c = null;
        this.f2239e = 32;
        this.f2240f = 32;
        this.f2241g = null;
        this.f2242h = false;
        this.f2243i = false;
        this.f2244j = new boolean[32];
        this.f2245k = 1;
        this.l = 0;
        this.m = 32;
        this.o = new i[w];
        this.p = 0;
        this.f2241g = new b[32];
        C();
        c cVar = new c();
        this.n = cVar;
        this.f2238d = new h(cVar);
        if (v) {
            this.q = new b(this, cVar);
        } else {
            this.q = new b(cVar);
        }
    }

    private final int B(a aVar, boolean z2) {
        e eVar = x;
        if (eVar != null) {
            eVar.f2253h++;
        }
        for (int i2 = 0; i2 < this.f2245k; i2++) {
            this.f2244j[i2] = false;
        }
        boolean z3 = false;
        int i3 = 0;
        while (!z3) {
            e eVar2 = x;
            if (eVar2 != null) {
                eVar2.f2254i++;
            }
            i3++;
            if (i3 >= this.f2245k * 2) {
                return i3;
            }
            if (aVar.getKey() != null) {
                this.f2244j[aVar.getKey().f2268c] = true;
            }
            i c2 = aVar.c(this, this.f2244j);
            if (c2 != null) {
                boolean[] zArr = this.f2244j;
                int i4 = c2.f2268c;
                if (zArr[i4]) {
                    return i3;
                }
                zArr[i4] = true;
            }
            if (c2 != null) {
                float f2 = Float.MAX_VALUE;
                int i5 = -1;
                for (int i6 = 0; i6 < this.l; i6++) {
                    b bVar = this.f2241g[i6];
                    if (bVar.f2225a.f2275j != i.a.UNRESTRICTED && !bVar.f2230f && bVar.t(c2)) {
                        float c3 = bVar.f2229e.c(c2);
                        if (c3 < Utils.FLOAT_EPSILON) {
                            float f3 = (-bVar.f2226b) / c3;
                            if (f3 < f2) {
                                i5 = i6;
                                f2 = f3;
                            }
                        }
                    }
                }
                if (i5 > -1) {
                    b bVar2 = this.f2241g[i5];
                    bVar2.f2225a.f2269d = -1;
                    e eVar3 = x;
                    if (eVar3 != null) {
                        eVar3.f2255j++;
                    }
                    bVar2.x(c2);
                    i iVar = bVar2.f2225a;
                    iVar.f2269d = i5;
                    iVar.g(this, bVar2);
                }
            } else {
                z3 = true;
            }
        }
        return i3;
    }

    private void C() {
        int i2 = 0;
        if (v) {
            while (i2 < this.l) {
                b bVar = this.f2241g[i2];
                if (bVar != null) {
                    this.n.f2231a.a(bVar);
                }
                this.f2241g[i2] = null;
                i2++;
            }
            return;
        }
        while (i2 < this.l) {
            b bVar2 = this.f2241g[i2];
            if (bVar2 != null) {
                this.n.f2232b.a(bVar2);
            }
            this.f2241g[i2] = null;
            i2++;
        }
    }

    private i a(i.a aVar, String str) {
        i b2 = this.n.f2233c.b();
        if (b2 == null) {
            b2 = new i(aVar, str);
            b2.f(aVar, str);
        } else {
            b2.d();
            b2.f(aVar, str);
        }
        int i2 = this.p;
        int i3 = w;
        if (i2 >= i3) {
            int i4 = i3 * 2;
            w = i4;
            this.o = (i[]) Arrays.copyOf(this.o, i4);
        }
        i[] iVarArr = this.o;
        int i5 = this.p;
        this.p = i5 + 1;
        iVarArr[i5] = b2;
        return b2;
    }

    private final void l(b bVar) {
        int i2;
        if (!t || !bVar.f2230f) {
            b[] bVarArr = this.f2241g;
            int i3 = this.l;
            bVarArr[i3] = bVar;
            i iVar = bVar.f2225a;
            iVar.f2269d = i3;
            this.l = i3 + 1;
            iVar.g(this, bVar);
        } else {
            bVar.f2225a.e(this, bVar.f2226b);
        }
        if (t && this.f2235a) {
            int i4 = 0;
            while (i4 < this.l) {
                if (this.f2241g[i4] == null) {
                    System.out.println("WTF");
                }
                b[] bVarArr2 = this.f2241g;
                if (bVarArr2[i4] != null && bVarArr2[i4].f2230f) {
                    b bVar2 = bVarArr2[i4];
                    bVar2.f2225a.e(this, bVar2.f2226b);
                    if (v) {
                        this.n.f2231a.a(bVar2);
                    } else {
                        this.n.f2232b.a(bVar2);
                    }
                    this.f2241g[i4] = null;
                    int i5 = i4 + 1;
                    int i6 = i5;
                    while (true) {
                        i2 = this.l;
                        if (i5 >= i2) {
                            break;
                        }
                        b[] bVarArr3 = this.f2241g;
                        int i7 = i5 - 1;
                        bVarArr3[i7] = bVarArr3[i5];
                        if (bVarArr3[i7].f2225a.f2269d == i5) {
                            bVarArr3[i7].f2225a.f2269d = i7;
                        }
                        i6 = i5;
                        i5++;
                    }
                    if (i6 < i2) {
                        this.f2241g[i6] = null;
                    }
                    this.l = i2 - 1;
                    i4--;
                }
                i4++;
            }
            this.f2235a = false;
        }
    }

    private void n() {
        for (int i2 = 0; i2 < this.l; i2++) {
            b bVar = this.f2241g[i2];
            bVar.f2225a.f2271f = bVar.f2226b;
        }
    }

    public static b s(d dVar, i iVar, i iVar2, float f2) {
        b r2 = dVar.r();
        r2.j(iVar, iVar2, f2);
        return r2;
    }

    private int u(a aVar) {
        boolean z2;
        int i2 = 0;
        while (true) {
            if (i2 >= this.l) {
                z2 = false;
                break;
            }
            b[] bVarArr = this.f2241g;
            if (bVarArr[i2].f2225a.f2275j != i.a.UNRESTRICTED && bVarArr[i2].f2226b < Utils.FLOAT_EPSILON) {
                z2 = true;
                break;
            }
            i2++;
        }
        if (!z2) {
            return 0;
        }
        boolean z3 = false;
        int i3 = 0;
        while (!z3) {
            e eVar = x;
            if (eVar != null) {
                eVar.f2256k++;
            }
            i3++;
            float f2 = Float.MAX_VALUE;
            int i4 = -1;
            int i5 = -1;
            int i6 = 0;
            for (int i7 = 0; i7 < this.l; i7++) {
                b bVar = this.f2241g[i7];
                if (bVar.f2225a.f2275j != i.a.UNRESTRICTED && !bVar.f2230f && bVar.f2226b < Utils.FLOAT_EPSILON) {
                    int i8 = 9;
                    if (u) {
                        int e2 = bVar.f2229e.e();
                        int i9 = 0;
                        while (i9 < e2) {
                            i i10 = bVar.f2229e.i(i9);
                            float c2 = bVar.f2229e.c(i10);
                            if (c2 > Utils.FLOAT_EPSILON) {
                                int i11 = 0;
                                while (i11 < i8) {
                                    float f3 = i10.f2273h[i11] / c2;
                                    if ((f3 < f2 && i11 == i6) || i11 > i6) {
                                        i5 = i10.f2268c;
                                        i6 = i11;
                                        i4 = i7;
                                        f2 = f3;
                                    }
                                    i11++;
                                    i8 = 9;
                                }
                            }
                            i9++;
                            i8 = 9;
                        }
                    } else {
                        for (int i12 = 1; i12 < this.f2245k; i12++) {
                            i iVar = this.n.f2234d[i12];
                            float c3 = bVar.f2229e.c(iVar);
                            if (c3 > Utils.FLOAT_EPSILON) {
                                for (int i13 = 0; i13 < 9; i13++) {
                                    float f4 = iVar.f2273h[i13] / c3;
                                    if ((f4 < f2 && i13 == i6) || i13 > i6) {
                                        i5 = i12;
                                        i6 = i13;
                                        i4 = i7;
                                        f2 = f4;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (i4 != -1) {
                b bVar2 = this.f2241g[i4];
                bVar2.f2225a.f2269d = -1;
                e eVar2 = x;
                if (eVar2 != null) {
                    eVar2.f2255j++;
                }
                bVar2.x(this.n.f2234d[i5]);
                i iVar2 = bVar2.f2225a;
                iVar2.f2269d = i4;
                iVar2.g(this, bVar2);
            } else {
                z3 = true;
            }
            if (i3 > this.f2245k / 2) {
                z3 = true;
            }
        }
        return i3;
    }

    public static e w() {
        return x;
    }

    private void y() {
        int i2 = this.f2239e * 2;
        this.f2239e = i2;
        this.f2241g = (b[]) Arrays.copyOf(this.f2241g, i2);
        c cVar = this.n;
        cVar.f2234d = (i[]) Arrays.copyOf(cVar.f2234d, this.f2239e);
        int i3 = this.f2239e;
        this.f2244j = new boolean[i3];
        this.f2240f = i3;
        this.m = i3;
        e eVar = x;
        if (eVar != null) {
            eVar.f2249d++;
            eVar.o = Math.max(eVar.o, (long) i3);
            e eVar2 = x;
            eVar2.x = eVar2.o;
        }
    }

    /* access modifiers changed from: package-private */
    public void A(a aVar) {
        e eVar = x;
        if (eVar != null) {
            eVar.t++;
            eVar.u = Math.max(eVar.u, (long) this.f2245k);
            e eVar2 = x;
            eVar2.v = Math.max(eVar2.v, (long) this.l);
        }
        u(aVar);
        B(aVar, false);
        n();
    }

    public void D() {
        c cVar;
        int i2 = 0;
        while (true) {
            cVar = this.n;
            i[] iVarArr = cVar.f2234d;
            if (i2 >= iVarArr.length) {
                break;
            }
            i iVar = iVarArr[i2];
            if (iVar != null) {
                iVar.d();
            }
            i2++;
        }
        cVar.f2233c.c(this.o, this.p);
        this.p = 0;
        Arrays.fill(this.n.f2234d, (Object) null);
        HashMap<String, i> hashMap = this.f2237c;
        if (hashMap != null) {
            hashMap.clear();
        }
        this.f2236b = 0;
        this.f2238d.clear();
        this.f2245k = 1;
        for (int i3 = 0; i3 < this.l; i3++) {
            b[] bVarArr = this.f2241g;
            if (bVarArr[i3] != null) {
                bVarArr[i3].f2227c = false;
            }
        }
        C();
        this.l = 0;
        if (v) {
            this.q = new b(this, this.n);
        } else {
            this.q = new b(this.n);
        }
    }

    public void b(e eVar, e eVar2, float f2, int i2) {
        d.b bVar = d.b.LEFT;
        i q2 = q(eVar.m(bVar));
        d.b bVar2 = d.b.TOP;
        i q3 = q(eVar.m(bVar2));
        d.b bVar3 = d.b.RIGHT;
        i q4 = q(eVar.m(bVar3));
        d.b bVar4 = d.b.BOTTOM;
        i q5 = q(eVar.m(bVar4));
        i q6 = q(eVar2.m(bVar));
        i q7 = q(eVar2.m(bVar2));
        i q8 = q(eVar2.m(bVar3));
        i q9 = q(eVar2.m(bVar4));
        b r2 = r();
        double d2 = (double) f2;
        double sin = Math.sin(d2);
        double d3 = (double) i2;
        Double.isNaN(d3);
        r2.q(q3, q5, q7, q9, (float) (sin * d3));
        d(r2);
        b r3 = r();
        double cos = Math.cos(d2);
        Double.isNaN(d3);
        r3.q(q2, q4, q6, q8, (float) (cos * d3));
        d(r3);
    }

    public void c(i iVar, i iVar2, int i2, float f2, i iVar3, i iVar4, int i3, int i4) {
        b r2 = r();
        r2.h(iVar, iVar2, i2, f2, iVar3, iVar4, i3);
        if (i4 != 8) {
            r2.d(this, i4);
        }
        d(r2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x009f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00a0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void d(b.f.b.b r8) {
        /*
        // Method dump skipped, instructions count: 167
        */
        throw new UnsupportedOperationException("Method not decompiled: b.f.b.d.d(b.f.b.b):void");
    }

    public b e(i iVar, i iVar2, int i2, int i3) {
        if (!s || i3 != 8 || !iVar2.f2272g || iVar.f2269d != -1) {
            b r2 = r();
            r2.n(iVar, iVar2, i2);
            if (i3 != 8) {
                r2.d(this, i3);
            }
            d(r2);
            return r2;
        }
        iVar.e(this, iVar2.f2271f + ((float) i2));
        return null;
    }

    public void f(i iVar, int i2) {
        if (!s || iVar.f2269d != -1) {
            int i3 = iVar.f2269d;
            if (i3 != -1) {
                b bVar = this.f2241g[i3];
                if (bVar.f2230f) {
                    bVar.f2226b = (float) i2;
                } else if (bVar.f2229e.e() == 0) {
                    bVar.f2230f = true;
                    bVar.f2226b = (float) i2;
                } else {
                    b r2 = r();
                    r2.m(iVar, i2);
                    d(r2);
                }
            } else {
                b r3 = r();
                r3.i(iVar, i2);
                d(r3);
            }
        } else {
            float f2 = (float) i2;
            iVar.e(this, f2);
            for (int i4 = 0; i4 < this.f2236b + 1; i4++) {
                i iVar2 = this.n.f2234d[i4];
                if (iVar2 != null && iVar2.n && iVar2.o == iVar.f2268c) {
                    iVar2.e(this, iVar2.p + f2);
                }
            }
        }
    }

    public void g(i iVar, i iVar2, int i2, boolean z2) {
        b r2 = r();
        i t2 = t();
        t2.f2270e = 0;
        r2.o(iVar, iVar2, t2, i2);
        d(r2);
    }

    public void h(i iVar, i iVar2, int i2, int i3) {
        b r2 = r();
        i t2 = t();
        t2.f2270e = 0;
        r2.o(iVar, iVar2, t2, i2);
        if (i3 != 8) {
            m(r2, (int) (r2.f2229e.c(t2) * -1.0f), i3);
        }
        d(r2);
    }

    public void i(i iVar, i iVar2, int i2, boolean z2) {
        b r2 = r();
        i t2 = t();
        t2.f2270e = 0;
        r2.p(iVar, iVar2, t2, i2);
        d(r2);
    }

    public void j(i iVar, i iVar2, int i2, int i3) {
        b r2 = r();
        i t2 = t();
        t2.f2270e = 0;
        r2.p(iVar, iVar2, t2, i2);
        if (i3 != 8) {
            m(r2, (int) (r2.f2229e.c(t2) * -1.0f), i3);
        }
        d(r2);
    }

    public void k(i iVar, i iVar2, i iVar3, i iVar4, float f2, int i2) {
        b r2 = r();
        r2.k(iVar, iVar2, iVar3, iVar4, f2);
        if (i2 != 8) {
            r2.d(this, i2);
        }
        d(r2);
    }

    /* access modifiers changed from: package-private */
    public void m(b bVar, int i2, int i3) {
        bVar.e(o(i3, null), i2);
    }

    public i o(int i2, String str) {
        e eVar = x;
        if (eVar != null) {
            eVar.l++;
        }
        if (this.f2245k + 1 >= this.f2240f) {
            y();
        }
        i a2 = a(i.a.ERROR, str);
        int i3 = this.f2236b + 1;
        this.f2236b = i3;
        this.f2245k++;
        a2.f2268c = i3;
        a2.f2270e = i2;
        this.n.f2234d[i3] = a2;
        this.f2238d.b(a2);
        return a2;
    }

    public i p() {
        e eVar = x;
        if (eVar != null) {
            eVar.n++;
        }
        if (this.f2245k + 1 >= this.f2240f) {
            y();
        }
        i a2 = a(i.a.SLACK, null);
        int i2 = this.f2236b + 1;
        this.f2236b = i2;
        this.f2245k++;
        a2.f2268c = i2;
        this.n.f2234d[i2] = a2;
        return a2;
    }

    public i q(Object obj) {
        i iVar = null;
        if (obj == null) {
            return null;
        }
        if (this.f2245k + 1 >= this.f2240f) {
            y();
        }
        if (obj instanceof b.f.b.k.d) {
            b.f.b.k.d dVar = (b.f.b.k.d) obj;
            iVar = dVar.h();
            if (iVar == null) {
                dVar.r(this.n);
                iVar = dVar.h();
            }
            int i2 = iVar.f2268c;
            if (i2 == -1 || i2 > this.f2236b || this.n.f2234d[i2] == null) {
                if (i2 != -1) {
                    iVar.d();
                }
                int i3 = this.f2236b + 1;
                this.f2236b = i3;
                this.f2245k++;
                iVar.f2268c = i3;
                iVar.f2275j = i.a.UNRESTRICTED;
                this.n.f2234d[i3] = iVar;
            }
        }
        return iVar;
    }

    public b r() {
        b bVar;
        if (v) {
            bVar = this.n.f2231a.b();
            if (bVar == null) {
                bVar = new b(this, this.n);
                z++;
            } else {
                bVar.y();
            }
        } else {
            bVar = this.n.f2232b.b();
            if (bVar == null) {
                bVar = new b(this.n);
                y++;
            } else {
                bVar.y();
            }
        }
        i.b();
        return bVar;
    }

    public i t() {
        e eVar = x;
        if (eVar != null) {
            eVar.m++;
        }
        if (this.f2245k + 1 >= this.f2240f) {
            y();
        }
        i a2 = a(i.a.SLACK, null);
        int i2 = this.f2236b + 1;
        this.f2236b = i2;
        this.f2245k++;
        a2.f2268c = i2;
        this.n.f2234d[i2] = a2;
        return a2;
    }

    public c v() {
        return this.n;
    }

    public int x(Object obj) {
        i h2 = ((b.f.b.k.d) obj).h();
        if (h2 != null) {
            return (int) (h2.f2271f + 0.5f);
        }
        return 0;
    }

    public void z() {
        e eVar = x;
        if (eVar != null) {
            eVar.f2250e++;
        }
        if (this.f2238d.isEmpty()) {
            n();
        } else if (this.f2242h || this.f2243i) {
            e eVar2 = x;
            if (eVar2 != null) {
                eVar2.q++;
            }
            boolean z2 = false;
            int i2 = 0;
            while (true) {
                if (i2 >= this.l) {
                    z2 = true;
                    break;
                } else if (!this.f2241g[i2].f2230f) {
                    break;
                } else {
                    i2++;
                }
            }
            if (!z2) {
                A(this.f2238d);
                return;
            }
            e eVar3 = x;
            if (eVar3 != null) {
                eVar3.p++;
            }
            n();
        } else {
            A(this.f2238d);
        }
    }
}
