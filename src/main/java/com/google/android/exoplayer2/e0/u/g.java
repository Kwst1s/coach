package com.google.android.exoplayer2.e0.u;

import android.util.Pair;
import android.util.SparseArray;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.d;
import com.google.android.exoplayer2.drm.l;
import com.google.android.exoplayer2.e0.h;
import com.google.android.exoplayer2.e0.i;
import com.google.android.exoplayer2.e0.n;
import com.google.android.exoplayer2.e0.o;
import com.google.android.exoplayer2.e0.q;
import com.google.android.exoplayer2.e0.u.c;
import com.google.android.exoplayer2.l;
import com.google.android.exoplayer2.util.a0;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.e;
import com.google.android.exoplayer2.util.m;
import com.google.android.exoplayer2.util.s;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/* compiled from: FragmentedMp4Extractor */
public final class g implements com.google.android.exoplayer2.e0.g {
    private static final int H = d0.B("seig");
    private static final byte[] I = {-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};
    private static final l J = l.w(null, "application/x-emsg", Long.MAX_VALUE);
    private int A;
    private int B;
    private boolean C;
    private i D;
    private q[] E;
    private q[] F;
    private boolean G;

    /* renamed from: a  reason: collision with root package name */
    private final int f5244a;

    /* renamed from: b  reason: collision with root package name */
    private final l f5245b;

    /* renamed from: c  reason: collision with root package name */
    private final List<l> f5246c;

    /* renamed from: d  reason: collision with root package name */
    private final com.google.android.exoplayer2.drm.l f5247d;

    /* renamed from: e  reason: collision with root package name */
    private final SparseArray<b> f5248e;

    /* renamed from: f  reason: collision with root package name */
    private final s f5249f;

    /* renamed from: g  reason: collision with root package name */
    private final s f5250g;

    /* renamed from: h  reason: collision with root package name */
    private final s f5251h;

    /* renamed from: i  reason: collision with root package name */
    private final a0 f5252i;

    /* renamed from: j  reason: collision with root package name */
    private final s f5253j;

    /* renamed from: k  reason: collision with root package name */
    private final byte[] f5254k;
    private final ArrayDeque<c.a> l;
    private final ArrayDeque<a> m;
    private final q n;
    private int o;
    private int p;
    private long q;
    private int r;
    private s s;
    private long t;
    private int u;
    private long v;
    private long w;
    private long x;
    private b y;
    private int z;

    /* access modifiers changed from: private */
    /* compiled from: FragmentedMp4Extractor */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final long f5255a;

        /* renamed from: b  reason: collision with root package name */
        public final int f5256b;

        public a(long j2, int i2) {
            this.f5255a = j2;
            this.f5256b = i2;
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: FragmentedMp4Extractor */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final q f5257a;

        /* renamed from: b  reason: collision with root package name */
        public final n f5258b = new n();

        /* renamed from: c  reason: collision with root package name */
        public l f5259c;

        /* renamed from: d  reason: collision with root package name */
        public e f5260d;

        /* renamed from: e  reason: collision with root package name */
        public int f5261e;

        /* renamed from: f  reason: collision with root package name */
        public int f5262f;

        /* renamed from: g  reason: collision with root package name */
        public int f5263g;

        /* renamed from: h  reason: collision with root package name */
        public int f5264h;

        /* renamed from: i  reason: collision with root package name */
        private final s f5265i = new s(1);

        /* renamed from: j  reason: collision with root package name */
        private final s f5266j = new s();

        public b(q qVar) {
            this.f5257a = qVar;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private m c() {
            n nVar = this.f5258b;
            int i2 = nVar.f5313a.f5234a;
            m mVar = nVar.o;
            if (mVar == null) {
                mVar = this.f5259c.a(i2);
            }
            if (mVar == null || !mVar.f5308a) {
                return null;
            }
            return mVar;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void i() {
            m c2 = c();
            if (c2 != null) {
                s sVar = this.f5258b.q;
                int i2 = c2.f5311d;
                if (i2 != 0) {
                    sVar.L(i2);
                }
                if (this.f5258b.g(this.f5261e)) {
                    sVar.L(sVar.E() * 6);
                }
            }
        }

        public void d(l lVar, e eVar) {
            e.e(lVar);
            this.f5259c = lVar;
            e.e(eVar);
            this.f5260d = eVar;
            this.f5257a.d(lVar.f5302f);
            g();
        }

        public boolean e() {
            this.f5261e++;
            int i2 = this.f5262f + 1;
            this.f5262f = i2;
            int[] iArr = this.f5258b.f5320h;
            int i3 = this.f5263g;
            if (i2 != iArr[i3]) {
                return true;
            }
            this.f5263g = i3 + 1;
            this.f5262f = 0;
            return false;
        }

        public int f() {
            s sVar;
            m c2 = c();
            if (c2 == null) {
                return 0;
            }
            int i2 = c2.f5311d;
            if (i2 != 0) {
                sVar = this.f5258b.q;
            } else {
                byte[] bArr = c2.f5312e;
                this.f5266j.I(bArr, bArr.length);
                s sVar2 = this.f5266j;
                i2 = bArr.length;
                sVar = sVar2;
            }
            boolean g2 = this.f5258b.g(this.f5261e);
            s sVar3 = this.f5265i;
            sVar3.f7062a[0] = (byte) ((g2 ? 128 : 0) | i2);
            sVar3.K(0);
            this.f5257a.a(this.f5265i, 1);
            this.f5257a.a(sVar, i2);
            if (!g2) {
                return i2 + 1;
            }
            s sVar4 = this.f5258b.q;
            int E = sVar4.E();
            sVar4.L(-2);
            int i3 = (E * 6) + 2;
            this.f5257a.a(sVar4, i3);
            return i2 + 1 + i3;
        }

        public void g() {
            this.f5258b.f();
            this.f5261e = 0;
            this.f5263g = 0;
            this.f5262f = 0;
            this.f5264h = 0;
        }

        public void h(long j2) {
            long b2 = d.b(j2);
            int i2 = this.f5261e;
            while (true) {
                n nVar = this.f5258b;
                if (i2 < nVar.f5318f && nVar.c(i2) < b2) {
                    if (this.f5258b.l[i2]) {
                        this.f5264h = i2;
                    }
                    i2++;
                } else {
                    return;
                }
            }
        }

        public void j(com.google.android.exoplayer2.drm.l lVar) {
            m a2 = this.f5259c.a(this.f5258b.f5313a.f5234a);
            this.f5257a.d(this.f5259c.f5302f.k(lVar.l(a2 != null ? a2.f5309b : null)));
        }
    }

    static {
        a aVar = a.f5190a;
    }

    public g() {
        this(0);
    }

    private static long A(s sVar) {
        sVar.K(8);
        return c.c(sVar.j()) == 1 ? sVar.D() : sVar.A();
    }

    private static b B(s sVar, SparseArray<b> sparseArray) {
        sVar.K(8);
        int b2 = c.b(sVar.j());
        b j2 = j(sparseArray, sVar.j());
        if (j2 == null) {
            return null;
        }
        if ((b2 & 1) != 0) {
            long D2 = sVar.D();
            n nVar = j2.f5258b;
            nVar.f5315c = D2;
            nVar.f5316d = D2;
        }
        e eVar = j2.f5260d;
        j2.f5258b.f5313a = new e((b2 & 2) != 0 ? sVar.C() - 1 : eVar.f5234a, (b2 & 8) != 0 ? sVar.C() : eVar.f5235b, (b2 & 16) != 0 ? sVar.C() : eVar.f5236c, (b2 & 32) != 0 ? sVar.C() : eVar.f5237d);
        return j2;
    }

    private static void C(c.a aVar, SparseArray<b> sparseArray, int i2, byte[] bArr) {
        b B2 = B(aVar.g(c.y).R0, sparseArray);
        if (B2 != null) {
            n nVar = B2.f5258b;
            long j2 = nVar.s;
            B2.g();
            int i3 = c.x;
            if (aVar.g(i3) != null && (i2 & 2) == 0) {
                j2 = A(aVar.g(i3).R0);
            }
            F(aVar, B2, j2, i2);
            m a2 = B2.f5259c.a(nVar.f5313a.f5234a);
            c.b g2 = aVar.g(c.d0);
            if (g2 != null) {
                v(a2, g2.R0, nVar);
            }
            c.b g3 = aVar.g(c.e0);
            if (g3 != null) {
                u(g3.R0, nVar);
            }
            c.b g4 = aVar.g(c.i0);
            if (g4 != null) {
                x(g4.R0, nVar);
            }
            c.b g5 = aVar.g(c.f0);
            c.b g6 = aVar.g(c.g0);
            if (!(g5 == null || g6 == null)) {
                y(g5.R0, g6.R0, a2 != null ? a2.f5309b : null, nVar);
            }
            int size = aVar.S0.size();
            for (int i4 = 0; i4 < size; i4++) {
                c.b bVar = aVar.S0.get(i4);
                if (bVar.f5202a == c.h0) {
                    G(bVar.R0, nVar, bArr);
                }
            }
        }
    }

    private static Pair<Integer, e> D(s sVar) {
        sVar.K(12);
        return Pair.create(Integer.valueOf(sVar.j()), new e(sVar.C() - 1, sVar.C(), sVar.C(), sVar.j()));
    }

    private static int E(b bVar, int i2, long j2, int i3, s sVar, int i4) {
        boolean z2;
        int i5;
        boolean z3;
        int i6;
        boolean z4;
        boolean z5;
        boolean z6;
        sVar.K(8);
        int b2 = c.b(sVar.j());
        l lVar = bVar.f5259c;
        n nVar = bVar.f5258b;
        e eVar = nVar.f5313a;
        nVar.f5320h[i2] = sVar.C();
        long[] jArr = nVar.f5319g;
        jArr[i2] = nVar.f5315c;
        if ((b2 & 1) != 0) {
            jArr[i2] = jArr[i2] + ((long) sVar.j());
        }
        boolean z7 = (b2 & 4) != 0;
        int i7 = eVar.f5237d;
        if (z7) {
            i7 = sVar.C();
        }
        boolean z8 = (b2 & 256) != 0;
        boolean z9 = (b2 & 512) != 0;
        boolean z10 = (b2 & 1024) != 0;
        boolean z11 = (b2 & 2048) != 0;
        long[] jArr2 = lVar.f5304h;
        long j3 = 0;
        if (jArr2 != null && jArr2.length == 1 && jArr2[0] == 0) {
            j3 = d0.Z(lVar.f5305i[0], 1000, lVar.f5299c);
        }
        int[] iArr = nVar.f5321i;
        int[] iArr2 = nVar.f5322j;
        long[] jArr3 = nVar.f5323k;
        boolean[] zArr = nVar.l;
        boolean z12 = lVar.f5298b == 2 && (i3 & 1) != 0;
        int i8 = i4 + nVar.f5320h[i2];
        long j4 = lVar.f5299c;
        long j5 = i2 > 0 ? nVar.s : j2;
        int i9 = i4;
        while (i9 < i8) {
            int C2 = z8 ? sVar.C() : eVar.f5235b;
            if (z9) {
                z2 = z8;
                i5 = sVar.C();
            } else {
                z2 = z8;
                i5 = eVar.f5236c;
            }
            if (i9 == 0 && z7) {
                z3 = z7;
                i6 = i7;
            } else if (z10) {
                z3 = z7;
                i6 = sVar.j();
            } else {
                z3 = z7;
                i6 = eVar.f5237d;
            }
            if (z11) {
                z6 = z11;
                z5 = z9;
                z4 = z10;
                iArr2[i9] = (int) ((((long) sVar.j()) * 1000) / j4);
            } else {
                z6 = z11;
                z5 = z9;
                z4 = z10;
                iArr2[i9] = 0;
            }
            jArr3[i9] = d0.Z(j5, 1000, j4) - j3;
            iArr[i9] = i5;
            zArr[i9] = ((i6 >> 16) & 1) == 0 && (!z12 || i9 == 0);
            i9++;
            j5 += (long) C2;
            j4 = j4;
            z8 = z2;
            z7 = z3;
            z11 = z6;
            z9 = z5;
            z10 = z4;
        }
        nVar.s = j5;
        return i8;
    }

    private static void F(c.a aVar, b bVar, long j2, int i2) {
        List<c.b> list = aVar.S0;
        int size = list.size();
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            c.b bVar2 = list.get(i5);
            if (bVar2.f5202a == c.A) {
                s sVar = bVar2.R0;
                sVar.K(12);
                int C2 = sVar.C();
                if (C2 > 0) {
                    i4 += C2;
                    i3++;
                }
            }
        }
        bVar.f5263g = 0;
        bVar.f5262f = 0;
        bVar.f5261e = 0;
        bVar.f5258b.e(i3, i4);
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < size; i8++) {
            c.b bVar3 = list.get(i8);
            if (bVar3.f5202a == c.A) {
                i7 = E(bVar, i6, j2, i2, bVar3.R0, i7);
                i6++;
            }
        }
    }

    private static void G(s sVar, n nVar, byte[] bArr) {
        sVar.K(8);
        sVar.h(bArr, 0, 16);
        if (Arrays.equals(bArr, I)) {
            w(sVar, 16, nVar);
        }
    }

    private void H(long j2) {
        while (!this.l.isEmpty() && this.l.peek().R0 == j2) {
            m(this.l.pop());
        }
        b();
    }

    private boolean I(h hVar) {
        if (this.r == 0) {
            if (!hVar.c(this.f5253j.f7062a, 0, 8, true)) {
                return false;
            }
            this.r = 8;
            this.f5253j.K(0);
            this.q = this.f5253j.A();
            this.p = this.f5253j.j();
        }
        long j2 = this.q;
        if (j2 == 1) {
            hVar.readFully(this.f5253j.f7062a, 8, 8);
            this.r += 8;
            this.q = this.f5253j.D();
        } else if (j2 == 0) {
            long d2 = hVar.d();
            if (d2 == -1 && !this.l.isEmpty()) {
                d2 = this.l.peek().R0;
            }
            if (d2 != -1) {
                this.q = (d2 - hVar.l()) + ((long) this.r);
            }
        }
        if (this.q >= ((long) this.r)) {
            long l2 = hVar.l() - ((long) this.r);
            if (this.p == c.L) {
                int size = this.f5248e.size();
                for (int i2 = 0; i2 < size; i2++) {
                    n nVar = this.f5248e.valueAt(i2).f5258b;
                    nVar.f5314b = l2;
                    nVar.f5316d = l2;
                    nVar.f5315c = l2;
                }
            }
            int i3 = this.p;
            if (i3 == c.f5199i) {
                this.y = null;
                this.t = this.q + l2;
                if (!this.G) {
                    this.D.e(new o.b(this.w, l2));
                    this.G = true;
                }
                this.o = 2;
                return true;
            }
            if (M(i3)) {
                long l3 = (hVar.l() + this.q) - 8;
                this.l.push(new c.a(this.p, l3));
                if (this.q == ((long) this.r)) {
                    H(l3);
                } else {
                    b();
                }
            } else if (N(this.p)) {
                if (this.r == 8) {
                    long j3 = this.q;
                    if (j3 <= 2147483647L) {
                        s sVar = new s((int) j3);
                        this.s = sVar;
                        System.arraycopy(this.f5253j.f7062a, 0, sVar.f7062a, 0, 8);
                        this.o = 1;
                    } else {
                        throw new ParserException("Leaf atom with length > 2147483647 (unsupported).");
                    }
                } else {
                    throw new ParserException("Leaf atom defines extended atom size (unsupported).");
                }
            } else if (this.q <= 2147483647L) {
                this.s = null;
                this.o = 1;
            } else {
                throw new ParserException("Skipping atom with length > 2147483647 (unsupported).");
            }
            return true;
        }
        throw new ParserException("Atom size less than header length (unsupported).");
    }

    private void J(h hVar) {
        int i2 = ((int) this.q) - this.r;
        s sVar = this.s;
        if (sVar != null) {
            hVar.readFully(sVar.f7062a, 8, i2);
            o(new c.b(this.p, this.s), hVar.l());
        } else {
            hVar.f(i2);
        }
        H(hVar.l());
    }

    private void K(h hVar) {
        int size = this.f5248e.size();
        b bVar = null;
        long j2 = Long.MAX_VALUE;
        for (int i2 = 0; i2 < size; i2++) {
            n nVar = this.f5248e.valueAt(i2).f5258b;
            if (nVar.r) {
                long j3 = nVar.f5316d;
                if (j3 < j2) {
                    bVar = this.f5248e.valueAt(i2);
                    j2 = j3;
                }
            }
        }
        if (bVar == null) {
            this.o = 3;
            return;
        }
        int l2 = (int) (j2 - hVar.l());
        if (l2 >= 0) {
            hVar.f(l2);
            bVar.f5258b.a(hVar);
            return;
        }
        throw new ParserException("Offset to encryption data was negative.");
    }

    private boolean L(h hVar) {
        q.a aVar;
        boolean z2;
        int i2;
        int i3 = 4;
        int i4 = 1;
        int i5 = 0;
        if (this.o == 3) {
            if (this.y == null) {
                b h2 = h(this.f5248e);
                if (h2 == null) {
                    int l2 = (int) (this.t - hVar.l());
                    if (l2 >= 0) {
                        hVar.f(l2);
                        b();
                        return false;
                    }
                    throw new ParserException("Offset to end of mdat was negative.");
                }
                int l3 = (int) (h2.f5258b.f5319g[h2.f5263g] - hVar.l());
                if (l3 < 0) {
                    m.f("FragmentedMp4Extractor", "Ignoring negative offset to sample data.");
                    l3 = 0;
                }
                hVar.f(l3);
                this.y = h2;
            }
            b bVar = this.y;
            int[] iArr = bVar.f5258b.f5321i;
            int i6 = bVar.f5261e;
            int i7 = iArr[i6];
            this.z = i7;
            if (i6 < bVar.f5264h) {
                hVar.f(i7);
                this.y.i();
                if (!this.y.e()) {
                    this.y = null;
                }
                this.o = 3;
                return true;
            }
            if (bVar.f5259c.f5303g == 1) {
                this.z = i7 - 8;
                hVar.f(8);
            }
            int f2 = this.y.f();
            this.A = f2;
            this.z += f2;
            this.o = 4;
            this.B = 0;
        }
        b bVar2 = this.y;
        n nVar = bVar2.f5258b;
        l lVar = bVar2.f5259c;
        q qVar = bVar2.f5257a;
        int i8 = bVar2.f5261e;
        long c2 = nVar.c(i8) * 1000;
        a0 a0Var = this.f5252i;
        if (a0Var != null) {
            c2 = a0Var.a(c2);
        }
        int i9 = lVar.f5306j;
        if (i9 == 0) {
            while (true) {
                int i10 = this.A;
                int i11 = this.z;
                if (i10 >= i11) {
                    break;
                }
                this.A += qVar.b(hVar, i11 - i10, false);
            }
        } else {
            byte[] bArr = this.f5250g.f7062a;
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            int i12 = i9 + 1;
            int i13 = 4 - i9;
            while (this.A < this.z) {
                int i14 = this.B;
                if (i14 == 0) {
                    hVar.readFully(bArr, i13, i12);
                    this.f5250g.K(i5);
                    this.B = this.f5250g.C() - i4;
                    this.f5249f.K(i5);
                    qVar.a(this.f5249f, i3);
                    qVar.a(this.f5250g, i4);
                    this.C = this.F.length > 0 && com.google.android.exoplayer2.util.q.g(lVar.f5302f.f5977h, bArr[i3]);
                    this.A += 5;
                    this.z += i13;
                } else {
                    if (this.C) {
                        this.f5251h.H(i14);
                        hVar.readFully(this.f5251h.f7062a, i5, this.B);
                        qVar.a(this.f5251h, this.B);
                        i2 = this.B;
                        s sVar = this.f5251h;
                        int k2 = com.google.android.exoplayer2.util.q.k(sVar.f7062a, sVar.d());
                        this.f5251h.K("video/hevc".equals(lVar.f5302f.f5977h) ? 1 : 0);
                        this.f5251h.J(k2);
                        com.google.android.exoplayer2.text.k.g.a(c2, this.f5251h, this.F);
                    } else {
                        i2 = qVar.b(hVar, i14, false);
                    }
                    this.A += i2;
                    this.B -= i2;
                    i3 = 4;
                    i4 = 1;
                    i5 = 0;
                }
            }
        }
        boolean z3 = nVar.l[i8];
        m c3 = this.y.c();
        if (c3 != null) {
            z2 = z3 | true;
            aVar = c3.f5310c;
        } else {
            z2 = z3;
            aVar = null;
        }
        int i15 = this.z;
        int i16 = z2 ? 1 : 0;
        int i17 = z2 ? 1 : 0;
        int i18 = z2 ? 1 : 0;
        qVar.c(c2, i16, i15, 0, aVar);
        r(c2);
        if (!this.y.e()) {
            this.y = null;
        }
        this.o = 3;
        return true;
    }

    private static boolean M(int i2) {
        return i2 == c.C || i2 == c.E || i2 == c.F || i2 == c.G || i2 == c.H || i2 == c.L || i2 == c.M || i2 == c.N || i2 == c.Q;
    }

    private static boolean N(int i2) {
        return i2 == c.T || i2 == c.S || i2 == c.D || i2 == c.B || i2 == c.U || i2 == c.x || i2 == c.y || i2 == c.P || i2 == c.z || i2 == c.A || i2 == c.V || i2 == c.d0 || i2 == c.e0 || i2 == c.i0 || i2 == c.h0 || i2 == c.f0 || i2 == c.g0 || i2 == c.R || i2 == c.O || i2 == c.G0;
    }

    private void b() {
        this.o = 0;
        this.r = 0;
    }

    private e d(SparseArray<e> sparseArray, int i2) {
        if (sparseArray.size() == 1) {
            return sparseArray.valueAt(0);
        }
        e eVar = sparseArray.get(i2);
        e.e(eVar);
        return eVar;
    }

    private static com.google.android.exoplayer2.drm.l g(List<c.b> list) {
        int size = list.size();
        ArrayList arrayList = null;
        for (int i2 = 0; i2 < size; i2++) {
            c.b bVar = list.get(i2);
            if (bVar.f5202a == c.V) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] bArr = bVar.R0.f7062a;
                UUID f2 = j.f(bArr);
                if (f2 == null) {
                    m.f("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
                } else {
                    arrayList.add(new l.b(f2, "video/mp4", bArr));
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        return new com.google.android.exoplayer2.drm.l(arrayList);
    }

    private static b h(SparseArray<b> sparseArray) {
        int size = sparseArray.size();
        b bVar = null;
        long j2 = Long.MAX_VALUE;
        for (int i2 = 0; i2 < size; i2++) {
            b valueAt = sparseArray.valueAt(i2);
            int i3 = valueAt.f5263g;
            n nVar = valueAt.f5258b;
            if (i3 != nVar.f5317e) {
                long j3 = nVar.f5319g[i3];
                if (j3 < j2) {
                    bVar = valueAt;
                    j2 = j3;
                }
            }
        }
        return bVar;
    }

    private static b j(SparseArray<b> sparseArray, int i2) {
        if (sparseArray.size() == 1) {
            return sparseArray.valueAt(0);
        }
        return sparseArray.get(i2);
    }

    static /* synthetic */ com.google.android.exoplayer2.e0.g[] k() {
        return new com.google.android.exoplayer2.e0.g[]{new g()};
    }

    private void l() {
        int i2;
        if (this.E == null) {
            q[] qVarArr = new q[2];
            this.E = qVarArr;
            q qVar = this.n;
            if (qVar != null) {
                qVarArr[0] = qVar;
                i2 = 1;
            } else {
                i2 = 0;
            }
            if ((this.f5244a & 4) != 0) {
                qVarArr[i2] = this.D.a(this.f5248e.size(), 4);
                i2++;
            }
            q[] qVarArr2 = (q[]) Arrays.copyOf(this.E, i2);
            this.E = qVarArr2;
            for (q qVar2 : qVarArr2) {
                qVar2.d(J);
            }
        }
        if (this.F == null) {
            this.F = new q[this.f5246c.size()];
            for (int i3 = 0; i3 < this.F.length; i3++) {
                q a2 = this.D.a(this.f5248e.size() + 1 + i3, 3);
                a2.d(this.f5246c.get(i3));
                this.F[i3] = a2;
            }
        }
    }

    private void m(c.a aVar) {
        int i2 = aVar.f5202a;
        if (i2 == c.C) {
            q(aVar);
        } else if (i2 == c.L) {
            p(aVar);
        } else if (!this.l.isEmpty()) {
            this.l.peek().d(aVar);
        }
    }

    private void n(s sVar) {
        q[] qVarArr = this.E;
        if (!(qVarArr == null || qVarArr.length == 0)) {
            sVar.K(12);
            int a2 = sVar.a();
            sVar.s();
            sVar.s();
            long Z = d0.Z(sVar.A(), 1000000, sVar.A());
            q[] qVarArr2 = this.E;
            for (q qVar : qVarArr2) {
                sVar.K(12);
                qVar.a(sVar, a2);
            }
            long j2 = this.x;
            if (j2 != -9223372036854775807L) {
                long j3 = j2 + Z;
                a0 a0Var = this.f5252i;
                if (a0Var != null) {
                    j3 = a0Var.a(j3);
                }
                for (q qVar2 : this.E) {
                    qVar2.c(j3, 1, a2, 0, null);
                }
                return;
            }
            this.m.addLast(new a(Z, a2));
            this.u += a2;
        }
    }

    private void o(c.b bVar, long j2) {
        if (!this.l.isEmpty()) {
            this.l.peek().e(bVar);
            return;
        }
        int i2 = bVar.f5202a;
        if (i2 == c.B) {
            Pair<Long, com.google.android.exoplayer2.e0.b> z2 = z(bVar.R0, j2);
            this.x = ((Long) z2.first).longValue();
            this.D.e((o) z2.second);
            this.G = true;
        } else if (i2 == c.G0) {
            n(bVar.R0);
        }
    }

    private void p(c.a aVar) {
        com.google.android.exoplayer2.drm.l lVar;
        t(aVar, this.f5248e, this.f5244a, this.f5254k);
        if (this.f5247d != null) {
            lVar = null;
        } else {
            lVar = g(aVar.S0);
        }
        if (lVar != null) {
            int size = this.f5248e.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f5248e.valueAt(i2).j(lVar);
            }
        }
        if (this.v != -9223372036854775807L) {
            int size2 = this.f5248e.size();
            for (int i3 = 0; i3 < size2; i3++) {
                this.f5248e.valueAt(i3).h(this.v);
            }
            this.v = -9223372036854775807L;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r19v0, resolved type: com.google.android.exoplayer2.e0.u.g */
    /* JADX WARN: Multi-variable type inference failed */
    private void q(c.a aVar) {
        int i2;
        int i3;
        boolean z2 = true;
        int i4 = 0;
        e.g(this.f5245b == null, "Unexpected moov box.");
        com.google.android.exoplayer2.drm.l lVar = this.f5247d;
        if (lVar == null) {
            lVar = g(aVar.S0);
        }
        c.a f2 = aVar.f(c.N);
        SparseArray sparseArray = new SparseArray();
        int size = f2.S0.size();
        long j2 = -9223372036854775807L;
        for (int i5 = 0; i5 < size; i5++) {
            c.b bVar = f2.S0.get(i5);
            int i6 = bVar.f5202a;
            if (i6 == c.z) {
                Pair<Integer, e> D2 = D(bVar.R0);
                sparseArray.put(((Integer) D2.first).intValue(), D2.second);
            } else if (i6 == c.O) {
                j2 = s(bVar.R0);
            }
        }
        SparseArray sparseArray2 = new SparseArray();
        int size2 = aVar.T0.size();
        int i7 = 0;
        while (i7 < size2) {
            c.a aVar2 = aVar.T0.get(i7);
            if (aVar2.f5202a == c.E) {
                i2 = i7;
                i3 = size2;
                l u2 = d.u(aVar2, aVar.g(c.D), j2, lVar, (this.f5244a & 16) != 0, false);
                if (u2 != null) {
                    sparseArray2.put(u2.f5297a, u2);
                }
            } else {
                i2 = i7;
                i3 = size2;
            }
            i7 = i2 + 1;
            size2 = i3;
        }
        int size3 = sparseArray2.size();
        if (this.f5248e.size() == 0) {
            while (i4 < size3) {
                l lVar2 = (l) sparseArray2.valueAt(i4);
                b bVar2 = new b(this.D.a(i4, lVar2.f5298b));
                bVar2.d(lVar2, d(sparseArray, lVar2.f5297a));
                this.f5248e.put(lVar2.f5297a, bVar2);
                this.w = Math.max(this.w, lVar2.f5301e);
                i4++;
            }
            l();
            this.D.h();
            return;
        }
        if (this.f5248e.size() != size3) {
            z2 = false;
        }
        e.f(z2);
        while (i4 < size3) {
            l lVar3 = (l) sparseArray2.valueAt(i4);
            this.f5248e.get(lVar3.f5297a).d(lVar3, d(sparseArray, lVar3.f5297a));
            i4++;
        }
    }

    private void r(long j2) {
        while (!this.m.isEmpty()) {
            a removeFirst = this.m.removeFirst();
            this.u -= removeFirst.f5256b;
            long j3 = removeFirst.f5255a + j2;
            a0 a0Var = this.f5252i;
            if (a0Var != null) {
                j3 = a0Var.a(j3);
            }
            for (q qVar : this.E) {
                qVar.c(j3, 1, removeFirst.f5256b, this.u, null);
            }
        }
    }

    private static long s(s sVar) {
        sVar.K(8);
        return c.c(sVar.j()) == 0 ? sVar.A() : sVar.D();
    }

    private static void t(c.a aVar, SparseArray<b> sparseArray, int i2, byte[] bArr) {
        int size = aVar.T0.size();
        for (int i3 = 0; i3 < size; i3++) {
            c.a aVar2 = aVar.T0.get(i3);
            if (aVar2.f5202a == c.M) {
                C(aVar2, sparseArray, i2, bArr);
            }
        }
    }

    private static void u(s sVar, n nVar) {
        sVar.K(8);
        int j2 = sVar.j();
        if ((c.b(j2) & 1) == 1) {
            sVar.L(8);
        }
        int C2 = sVar.C();
        if (C2 == 1) {
            nVar.f5316d += c.c(j2) == 0 ? sVar.A() : sVar.D();
            return;
        }
        throw new ParserException("Unexpected saio entry count: " + C2);
    }

    private static void v(m mVar, s sVar, n nVar) {
        int i2;
        int i3 = mVar.f5311d;
        sVar.K(8);
        boolean z2 = true;
        if ((c.b(sVar.j()) & 1) == 1) {
            sVar.L(8);
        }
        int y2 = sVar.y();
        int C2 = sVar.C();
        if (C2 == nVar.f5318f) {
            if (y2 == 0) {
                boolean[] zArr = nVar.n;
                i2 = 0;
                for (int i4 = 0; i4 < C2; i4++) {
                    int y3 = sVar.y();
                    i2 += y3;
                    zArr[i4] = y3 > i3;
                }
            } else {
                if (y2 <= i3) {
                    z2 = false;
                }
                i2 = (y2 * C2) + 0;
                Arrays.fill(nVar.n, 0, C2, z2);
            }
            nVar.d(i2);
            return;
        }
        throw new ParserException("Length mismatch: " + C2 + ", " + nVar.f5318f);
    }

    private static void w(s sVar, int i2, n nVar) {
        sVar.K(i2 + 8);
        int b2 = c.b(sVar.j());
        if ((b2 & 1) == 0) {
            boolean z2 = (b2 & 2) != 0;
            int C2 = sVar.C();
            if (C2 == nVar.f5318f) {
                Arrays.fill(nVar.n, 0, C2, z2);
                nVar.d(sVar.a());
                nVar.b(sVar);
                return;
            }
            throw new ParserException("Length mismatch: " + C2 + ", " + nVar.f5318f);
        }
        throw new ParserException("Overriding TrackEncryptionBox parameters is unsupported.");
    }

    private static void x(s sVar, n nVar) {
        w(sVar, 0, nVar);
    }

    private static void y(s sVar, s sVar2, String str, n nVar) {
        byte[] bArr;
        sVar.K(8);
        int j2 = sVar.j();
        int j3 = sVar.j();
        int i2 = H;
        if (j3 == i2) {
            if (c.c(j2) == 1) {
                sVar.L(4);
            }
            if (sVar.j() == 1) {
                sVar2.K(8);
                int j4 = sVar2.j();
                if (sVar2.j() == i2) {
                    int c2 = c.c(j4);
                    if (c2 == 1) {
                        if (sVar2.A() == 0) {
                            throw new ParserException("Variable length description in sgpd found (unsupported)");
                        }
                    } else if (c2 >= 2) {
                        sVar2.L(4);
                    }
                    if (sVar2.A() == 1) {
                        sVar2.L(1);
                        int y2 = sVar2.y();
                        int i3 = (y2 & 240) >> 4;
                        int i4 = y2 & 15;
                        boolean z2 = sVar2.y() == 1;
                        if (z2) {
                            int y3 = sVar2.y();
                            byte[] bArr2 = new byte[16];
                            sVar2.h(bArr2, 0, 16);
                            if (!z2 || y3 != 0) {
                                bArr = null;
                            } else {
                                int y4 = sVar2.y();
                                byte[] bArr3 = new byte[y4];
                                sVar2.h(bArr3, 0, y4);
                                bArr = bArr3;
                            }
                            nVar.m = true;
                            nVar.o = new m(z2, str, y3, bArr2, i3, i4, bArr);
                            return;
                        }
                        return;
                    }
                    throw new ParserException("Entry count in sgpd != 1 (unsupported).");
                }
                return;
            }
            throw new ParserException("Entry count in sbgp != 1 (unsupported).");
        }
    }

    private static Pair<Long, com.google.android.exoplayer2.e0.b> z(s sVar, long j2) {
        long j3;
        long j4;
        sVar.K(8);
        int c2 = c.c(sVar.j());
        sVar.L(4);
        long A2 = sVar.A();
        if (c2 == 0) {
            j4 = sVar.A();
            j3 = sVar.A();
        } else {
            j4 = sVar.D();
            j3 = sVar.D();
        }
        long j5 = j2 + j3;
        long Z = d0.Z(j4, 1000000, A2);
        sVar.L(2);
        int E2 = sVar.E();
        int[] iArr = new int[E2];
        long[] jArr = new long[E2];
        long[] jArr2 = new long[E2];
        long[] jArr3 = new long[E2];
        long j6 = j4;
        long j7 = Z;
        int i2 = 0;
        while (i2 < E2) {
            int j8 = sVar.j();
            if ((j8 & Integer.MIN_VALUE) == 0) {
                long A3 = sVar.A();
                iArr[i2] = j8 & Integer.MAX_VALUE;
                jArr[i2] = j5;
                jArr3[i2] = j7;
                long j9 = j6 + A3;
                long Z2 = d0.Z(j9, 1000000, A2);
                jArr2[i2] = Z2 - jArr3[i2];
                sVar.L(4);
                j5 += (long) iArr[i2];
                i2++;
                iArr = iArr;
                jArr3 = jArr3;
                jArr2 = jArr2;
                jArr = jArr;
                E2 = E2;
                j6 = j9;
                j7 = Z2;
            } else {
                throw new ParserException("Unhandled indirect reference");
            }
        }
        return Pair.create(Long.valueOf(Z), new com.google.android.exoplayer2.e0.b(iArr, jArr, jArr2, jArr3));
    }

    @Override // com.google.android.exoplayer2.e0.g
    public void a() {
    }

    @Override // com.google.android.exoplayer2.e0.g
    public void c(i iVar) {
        this.D = iVar;
        l lVar = this.f5245b;
        if (lVar != null) {
            b bVar = new b(iVar.a(0, lVar.f5298b));
            bVar.d(this.f5245b, new e(0, 0, 0, 0));
            this.f5248e.put(0, bVar);
            l();
            this.D.h();
        }
    }

    @Override // com.google.android.exoplayer2.e0.g
    public void e(long j2, long j3) {
        int size = this.f5248e.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f5248e.valueAt(i2).g();
        }
        this.m.clear();
        this.u = 0;
        this.v = j3;
        this.l.clear();
        b();
    }

    @Override // com.google.android.exoplayer2.e0.g
    public boolean f(h hVar) {
        return k.b(hVar);
    }

    @Override // com.google.android.exoplayer2.e0.g
    public int i(h hVar, n nVar) {
        while (true) {
            int i2 = this.o;
            if (i2 != 0) {
                if (i2 == 1) {
                    J(hVar);
                } else if (i2 == 2) {
                    K(hVar);
                } else if (L(hVar)) {
                    return 0;
                }
            } else if (!I(hVar)) {
                return -1;
            }
        }
    }

    public g(int i2) {
        this(i2, null);
    }

    public g(int i2, a0 a0Var) {
        this(i2, a0Var, null, null);
    }

    public g(int i2, a0 a0Var, l lVar, com.google.android.exoplayer2.drm.l lVar2) {
        this(i2, a0Var, lVar, lVar2, Collections.emptyList());
    }

    public g(int i2, a0 a0Var, l lVar, com.google.android.exoplayer2.drm.l lVar2, List<com.google.android.exoplayer2.l> list) {
        this(i2, a0Var, lVar, lVar2, list, null);
    }

    public g(int i2, a0 a0Var, l lVar, com.google.android.exoplayer2.drm.l lVar2, List<com.google.android.exoplayer2.l> list, q qVar) {
        this.f5244a = i2 | (lVar != null ? 8 : 0);
        this.f5252i = a0Var;
        this.f5245b = lVar;
        this.f5247d = lVar2;
        this.f5246c = Collections.unmodifiableList(list);
        this.n = qVar;
        this.f5253j = new s(16);
        this.f5249f = new s(com.google.android.exoplayer2.util.q.f7040a);
        this.f5250g = new s(5);
        this.f5251h = new s();
        this.f5254k = new byte[16];
        this.l = new ArrayDeque<>();
        this.m = new ArrayDeque<>();
        this.f5248e = new SparseArray<>();
        this.w = -9223372036854775807L;
        this.v = -9223372036854775807L;
        this.x = -9223372036854775807L;
        b();
    }
}
