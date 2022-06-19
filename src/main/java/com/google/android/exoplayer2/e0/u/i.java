package com.google.android.exoplayer2.e0.u;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.e0.g;
import com.google.android.exoplayer2.e0.h;
import com.google.android.exoplayer2.e0.k;
import com.google.android.exoplayer2.e0.n;
import com.google.android.exoplayer2.e0.o;
import com.google.android.exoplayer2.e0.p;
import com.google.android.exoplayer2.e0.q;
import com.google.android.exoplayer2.e0.u.c;
import com.google.android.exoplayer2.l;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.e;
import com.google.android.exoplayer2.util.s;
import java.util.ArrayDeque;
import java.util.ArrayList;

/* compiled from: Mp4Extractor */
public final class i implements g, o {
    private static final int t = d0.B("qt  ");

    /* renamed from: a  reason: collision with root package name */
    private final int f5278a;

    /* renamed from: b  reason: collision with root package name */
    private final s f5279b;

    /* renamed from: c  reason: collision with root package name */
    private final s f5280c;

    /* renamed from: d  reason: collision with root package name */
    private final s f5281d;

    /* renamed from: e  reason: collision with root package name */
    private final ArrayDeque<c.a> f5282e;

    /* renamed from: f  reason: collision with root package name */
    private int f5283f;

    /* renamed from: g  reason: collision with root package name */
    private int f5284g;

    /* renamed from: h  reason: collision with root package name */
    private long f5285h;

    /* renamed from: i  reason: collision with root package name */
    private int f5286i;

    /* renamed from: j  reason: collision with root package name */
    private s f5287j;

    /* renamed from: k  reason: collision with root package name */
    private int f5288k;
    private int l;
    private int m;
    private com.google.android.exoplayer2.e0.i n;
    private a[] o;
    private long[][] p;
    private int q;
    private long r;
    private boolean s;

    /* access modifiers changed from: private */
    /* compiled from: Mp4Extractor */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final l f5289a;

        /* renamed from: b  reason: collision with root package name */
        public final o f5290b;

        /* renamed from: c  reason: collision with root package name */
        public final q f5291c;

        /* renamed from: d  reason: collision with root package name */
        public int f5292d;

        public a(l lVar, o oVar, q qVar) {
            this.f5289a = lVar;
            this.f5290b = oVar;
            this.f5291c = qVar;
        }
    }

    static {
        b bVar = b.f5191a;
    }

    public i() {
        this(0);
    }

    private static long[][] k(a[] aVarArr) {
        long[][] jArr = new long[aVarArr.length][];
        int[] iArr = new int[aVarArr.length];
        long[] jArr2 = new long[aVarArr.length];
        boolean[] zArr = new boolean[aVarArr.length];
        for (int i2 = 0; i2 < aVarArr.length; i2++) {
            jArr[i2] = new long[aVarArr[i2].f5290b.f5325b];
            jArr2[i2] = aVarArr[i2].f5290b.f5329f[0];
        }
        long j2 = 0;
        int i3 = 0;
        while (i3 < aVarArr.length) {
            long j3 = Long.MAX_VALUE;
            int i4 = -1;
            for (int i5 = 0; i5 < aVarArr.length; i5++) {
                if (!zArr[i5] && jArr2[i5] <= j3) {
                    j3 = jArr2[i5];
                    i4 = i5;
                }
            }
            int i6 = iArr[i4];
            jArr[i4][i6] = j2;
            j2 += (long) aVarArr[i4].f5290b.f5327d[i6];
            int i7 = i6 + 1;
            iArr[i4] = i7;
            if (i7 < jArr[i4].length) {
                jArr2[i4] = aVarArr[i4].f5290b.f5329f[i7];
            } else {
                zArr[i4] = true;
                i3++;
            }
        }
        return jArr;
    }

    private void l() {
        this.f5283f = 0;
        this.f5286i = 0;
    }

    private static int m(o oVar, long j2) {
        int a2 = oVar.a(j2);
        return a2 == -1 ? oVar.b(j2) : a2;
    }

    private int n(long j2) {
        int i2 = -1;
        int i3 = -1;
        int i4 = 0;
        long j3 = Long.MAX_VALUE;
        boolean z = true;
        long j4 = Long.MAX_VALUE;
        boolean z2 = true;
        long j5 = Long.MAX_VALUE;
        while (true) {
            a[] aVarArr = this.o;
            if (i4 >= aVarArr.length) {
                break;
            }
            a aVar = aVarArr[i4];
            int i5 = aVar.f5292d;
            o oVar = aVar.f5290b;
            if (i5 != oVar.f5325b) {
                long j6 = oVar.f5326c[i5];
                long j7 = this.p[i4][i5];
                long j8 = j6 - j2;
                boolean z3 = j8 < 0 || j8 >= 262144;
                if ((!z3 && z2) || (z3 == z2 && j8 < j5)) {
                    z2 = z3;
                    j5 = j8;
                    i3 = i4;
                    j4 = j7;
                }
                if (j7 < j3) {
                    z = z3;
                    i2 = i4;
                    j3 = j7;
                }
            }
            i4++;
        }
        return (j3 == Long.MAX_VALUE || !z || j4 < j3 + 10485760) ? i3 : i2;
    }

    private ArrayList<o> o(c.a aVar, k kVar, boolean z) {
        l u;
        ArrayList<o> arrayList = new ArrayList<>();
        for (int i2 = 0; i2 < aVar.T0.size(); i2++) {
            c.a aVar2 = aVar.T0.get(i2);
            if (aVar2.f5202a == c.E && (u = d.u(aVar2, aVar.g(c.D), -9223372036854775807L, null, z, this.s)) != null) {
                o q2 = d.q(u, aVar2.f(c.F).f(c.G).f(c.H), kVar);
                if (q2.f5325b != 0) {
                    arrayList.add(q2);
                }
            }
        }
        return arrayList;
    }

    static /* synthetic */ g[] p() {
        return new g[]{new i()};
    }

    private static long q(o oVar, long j2, long j3) {
        int m2 = m(oVar, j2);
        if (m2 == -1) {
            return j3;
        }
        return Math.min(oVar.f5326c[m2], j3);
    }

    private void r(long j2) {
        while (!this.f5282e.isEmpty() && this.f5282e.peek().R0 == j2) {
            c.a pop = this.f5282e.pop();
            if (pop.f5202a == c.C) {
                t(pop);
                this.f5282e.clear();
                this.f5283f = 2;
            } else if (!this.f5282e.isEmpty()) {
                this.f5282e.peek().d(pop);
            }
        }
        if (this.f5283f != 2) {
            l();
        }
    }

    private static boolean s(s sVar) {
        sVar.K(8);
        if (sVar.j() == t) {
            return true;
        }
        sVar.L(4);
        while (sVar.a() > 0) {
            if (sVar.j() == t) {
                return true;
            }
        }
        return false;
    }

    private void t(c.a aVar) {
        com.google.android.exoplayer2.f0.a aVar2;
        ArrayList arrayList = new ArrayList();
        k kVar = new k();
        c.b g2 = aVar.g(c.A0);
        if (g2 != null) {
            aVar2 = d.v(g2, this.s);
            if (aVar2 != null) {
                kVar.c(aVar2);
            }
        } else {
            aVar2 = null;
        }
        int i2 = 1;
        int i3 = 0;
        ArrayList<o> o2 = o(aVar, kVar, (this.f5278a & 1) != 0);
        int size = o2.size();
        int i4 = -1;
        long j2 = -9223372036854775807L;
        while (i3 < size) {
            o oVar = o2.get(i3);
            l lVar = oVar.f5324a;
            a aVar3 = new a(lVar, oVar, this.n.a(i3, lVar.f5298b));
            l n2 = lVar.f5302f.n(oVar.f5328e + 30);
            if (lVar.f5298b == i2) {
                if (kVar.a()) {
                    n2 = n2.l(kVar.f5081a, kVar.f5082b);
                }
                if (aVar2 != null) {
                    n2 = n2.o(aVar2);
                }
            }
            aVar3.f5291c.d(n2);
            long j3 = lVar.f5301e;
            if (j3 == -9223372036854775807L) {
                j3 = oVar.f5331h;
            }
            j2 = Math.max(j2, j3);
            if (lVar.f5298b == 2) {
                if (i4 == -1) {
                    i4 = arrayList.size();
                }
            }
            arrayList.add(aVar3);
            i3++;
            i2 = 1;
        }
        this.q = i4;
        this.r = j2;
        a[] aVarArr = (a[]) arrayList.toArray(new a[arrayList.size()]);
        this.o = aVarArr;
        this.p = k(aVarArr);
        this.n.h();
        this.n.e(this);
    }

    private boolean u(h hVar) {
        if (this.f5286i == 0) {
            if (!hVar.c(this.f5281d.f7062a, 0, 8, true)) {
                return false;
            }
            this.f5286i = 8;
            this.f5281d.K(0);
            this.f5285h = this.f5281d.A();
            this.f5284g = this.f5281d.j();
        }
        long j2 = this.f5285h;
        if (j2 == 1) {
            hVar.readFully(this.f5281d.f7062a, 8, 8);
            this.f5286i += 8;
            this.f5285h = this.f5281d.D();
        } else if (j2 == 0) {
            long d2 = hVar.d();
            if (d2 == -1 && !this.f5282e.isEmpty()) {
                d2 = this.f5282e.peek().R0;
            }
            if (d2 != -1) {
                this.f5285h = (d2 - hVar.l()) + ((long) this.f5286i);
            }
        }
        if (this.f5285h >= ((long) this.f5286i)) {
            if (x(this.f5284g)) {
                long l2 = (hVar.l() + this.f5285h) - ((long) this.f5286i);
                this.f5282e.push(new c.a(this.f5284g, l2));
                if (this.f5285h == ((long) this.f5286i)) {
                    r(l2);
                } else {
                    l();
                }
            } else if (y(this.f5284g)) {
                e.f(this.f5286i == 8);
                e.f(this.f5285h <= 2147483647L);
                s sVar = new s((int) this.f5285h);
                this.f5287j = sVar;
                System.arraycopy(this.f5281d.f7062a, 0, sVar.f7062a, 0, 8);
                this.f5283f = 1;
            } else {
                this.f5287j = null;
                this.f5283f = 1;
            }
            return true;
        }
        throw new ParserException("Atom size less than header length (unsupported).");
    }

    private boolean v(h hVar, n nVar) {
        boolean z;
        long j2 = this.f5285h - ((long) this.f5286i);
        long l2 = hVar.l() + j2;
        s sVar = this.f5287j;
        if (sVar != null) {
            hVar.readFully(sVar.f7062a, this.f5286i, (int) j2);
            if (this.f5284g == c.f5192b) {
                this.s = s(this.f5287j);
            } else if (!this.f5282e.isEmpty()) {
                this.f5282e.peek().e(new c.b(this.f5284g, this.f5287j));
            }
        } else if (j2 < 262144) {
            hVar.f((int) j2);
        } else {
            nVar.f5095a = hVar.l() + j2;
            z = true;
            r(l2);
            if (z || this.f5283f == 2) {
                return false;
            }
            return true;
        }
        z = false;
        r(l2);
        if (z) {
        }
        return false;
    }

    private int w(h hVar, n nVar) {
        long l2 = hVar.l();
        if (this.f5288k == -1) {
            int n2 = n(l2);
            this.f5288k = n2;
            if (n2 == -1) {
                return -1;
            }
        }
        a aVar = this.o[this.f5288k];
        q qVar = aVar.f5291c;
        int i2 = aVar.f5292d;
        o oVar = aVar.f5290b;
        long j2 = oVar.f5326c[i2];
        int i3 = oVar.f5327d[i2];
        long j3 = (j2 - l2) + ((long) this.l);
        if (j3 < 0 || j3 >= 262144) {
            nVar.f5095a = j2;
            return 1;
        }
        if (aVar.f5289a.f5303g == 1) {
            j3 += 8;
            i3 -= 8;
        }
        hVar.f((int) j3);
        int i4 = aVar.f5289a.f5306j;
        if (i4 == 0) {
            while (true) {
                int i5 = this.l;
                if (i5 >= i3) {
                    break;
                }
                int b2 = qVar.b(hVar, i3 - i5, false);
                this.l += b2;
                this.m -= b2;
            }
        } else {
            byte[] bArr = this.f5280c.f7062a;
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            int i6 = 4 - i4;
            while (this.l < i3) {
                int i7 = this.m;
                if (i7 == 0) {
                    hVar.readFully(this.f5280c.f7062a, i6, i4);
                    this.f5280c.K(0);
                    this.m = this.f5280c.C();
                    this.f5279b.K(0);
                    qVar.a(this.f5279b, 4);
                    this.l += 4;
                    i3 += i6;
                } else {
                    int b3 = qVar.b(hVar, i7, false);
                    this.l += b3;
                    this.m -= b3;
                }
            }
        }
        o oVar2 = aVar.f5290b;
        qVar.c(oVar2.f5329f[i2], oVar2.f5330g[i2], i3, 0, null);
        aVar.f5292d++;
        this.f5288k = -1;
        this.l = 0;
        this.m = 0;
        return 0;
    }

    private static boolean x(int i2) {
        return i2 == c.C || i2 == c.E || i2 == c.F || i2 == c.G || i2 == c.H || i2 == c.Q;
    }

    private static boolean y(int i2) {
        return i2 == c.S || i2 == c.D || i2 == c.T || i2 == c.U || i2 == c.m0 || i2 == c.n0 || i2 == c.o0 || i2 == c.R || i2 == c.p0 || i2 == c.q0 || i2 == c.r0 || i2 == c.s0 || i2 == c.t0 || i2 == c.P || i2 == c.f5192b || i2 == c.A0;
    }

    private void z(long j2) {
        a[] aVarArr = this.o;
        for (a aVar : aVarArr) {
            o oVar = aVar.f5290b;
            int a2 = oVar.a(j2);
            if (a2 == -1) {
                a2 = oVar.b(j2);
            }
            aVar.f5292d = a2;
        }
    }

    @Override // com.google.android.exoplayer2.e0.g
    public void a() {
    }

    @Override // com.google.android.exoplayer2.e0.g
    public void c(com.google.android.exoplayer2.e0.i iVar) {
        this.n = iVar;
    }

    @Override // com.google.android.exoplayer2.e0.g
    public void e(long j2, long j3) {
        this.f5282e.clear();
        this.f5286i = 0;
        this.f5288k = -1;
        this.l = 0;
        this.m = 0;
        if (j2 == 0) {
            l();
        } else if (this.o != null) {
            z(j3);
        }
    }

    @Override // com.google.android.exoplayer2.e0.g
    public boolean f(h hVar) {
        return k.d(hVar);
    }

    @Override // com.google.android.exoplayer2.e0.o
    public boolean g() {
        return true;
    }

    @Override // com.google.android.exoplayer2.e0.o
    public o.a h(long j2) {
        long j3;
        long j4;
        long j5;
        long j6;
        int b2;
        a[] aVarArr = this.o;
        if (aVarArr.length == 0) {
            return new o.a(p.f5100c);
        }
        int i2 = this.q;
        if (i2 != -1) {
            o oVar = aVarArr[i2].f5290b;
            int m2 = m(oVar, j2);
            if (m2 == -1) {
                return new o.a(p.f5100c);
            }
            long j7 = oVar.f5329f[m2];
            j3 = oVar.f5326c[m2];
            if (j7 >= j2 || m2 >= oVar.f5325b - 1 || (b2 = oVar.b(j2)) == -1 || b2 == m2) {
                j6 = -1;
                j5 = -9223372036854775807L;
            } else {
                j5 = oVar.f5329f[b2];
                j6 = oVar.f5326c[b2];
            }
            j4 = j6;
            j2 = j7;
        } else {
            j3 = Long.MAX_VALUE;
            j4 = -1;
            j5 = -9223372036854775807L;
        }
        int i3 = 0;
        while (true) {
            a[] aVarArr2 = this.o;
            if (i3 >= aVarArr2.length) {
                break;
            }
            if (i3 != this.q) {
                o oVar2 = aVarArr2[i3].f5290b;
                long q2 = q(oVar2, j2, j3);
                if (j5 != -9223372036854775807L) {
                    j4 = q(oVar2, j5, j4);
                }
                j3 = q2;
            }
            i3++;
        }
        p pVar = new p(j2, j3);
        if (j5 == -9223372036854775807L) {
            return new o.a(pVar);
        }
        return new o.a(pVar, new p(j5, j4));
    }

    @Override // com.google.android.exoplayer2.e0.g
    public int i(h hVar, n nVar) {
        while (true) {
            int i2 = this.f5283f;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 == 2) {
                        return w(hVar, nVar);
                    }
                    throw new IllegalStateException();
                } else if (v(hVar, nVar)) {
                    return 1;
                }
            } else if (!u(hVar)) {
                return -1;
            }
        }
    }

    @Override // com.google.android.exoplayer2.e0.o
    public long j() {
        return this.r;
    }

    public i(int i2) {
        this.f5278a = i2;
        this.f5281d = new s(16);
        this.f5282e = new ArrayDeque<>();
        this.f5279b = new s(com.google.android.exoplayer2.util.q.f7040a);
        this.f5280c = new s(4);
        this.f5288k = -1;
    }
}
