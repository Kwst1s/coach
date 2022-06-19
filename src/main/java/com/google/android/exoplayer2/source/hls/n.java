package com.google.android.exoplayer2.source.hls;

import android.os.Handler;
import com.google.android.exoplayer2.e0.i;
import com.google.android.exoplayer2.e0.o;
import com.google.android.exoplayer2.e0.q;
import com.google.android.exoplayer2.l;
import com.google.android.exoplayer2.source.b0;
import com.google.android.exoplayer2.source.c0;
import com.google.android.exoplayer2.source.d0.d;
import com.google.android.exoplayer2.source.hls.f;
import com.google.android.exoplayer2.source.hls.playlist.d;
import com.google.android.exoplayer2.source.v;
import com.google.android.exoplayer2.source.x;
import com.google.android.exoplayer2.source.y;
import com.google.android.exoplayer2.source.z;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.t;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.e;
import com.google.android.exoplayer2.util.m;
import com.google.android.exoplayer2.util.p;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* access modifiers changed from: package-private */
/* compiled from: HlsSampleStreamWrapper */
public final class n implements Loader.b<d>, Loader.f, z, i, x.b {
    private int A;
    private l B;
    private l C;
    private boolean D;
    private c0 E;
    private c0 F;
    private int[] G;
    private int H;
    private boolean I;
    private boolean[] J = new boolean[0];
    private boolean[] K = new boolean[0];
    private long L;
    private long M;
    private boolean N;
    private boolean O;
    private boolean P;
    private boolean Q;
    private long R;
    private int S;

    /* renamed from: b  reason: collision with root package name */
    private final int f6417b;

    /* renamed from: c  reason: collision with root package name */
    private final a f6418c;

    /* renamed from: d  reason: collision with root package name */
    private final f f6419d;

    /* renamed from: e  reason: collision with root package name */
    private final com.google.android.exoplayer2.upstream.d f6420e;

    /* renamed from: f  reason: collision with root package name */
    private final l f6421f;

    /* renamed from: g  reason: collision with root package name */
    private final t f6422g;

    /* renamed from: h  reason: collision with root package name */
    private final Loader f6423h = new Loader("Loader:HlsSampleStreamWrapper");

    /* renamed from: i  reason: collision with root package name */
    private final v.a f6424i;

    /* renamed from: j  reason: collision with root package name */
    private final f.b f6425j = new f.b();

    /* renamed from: k  reason: collision with root package name */
    private final ArrayList<j> f6426k;
    private final List<j> l;
    private final Runnable m;
    private final Runnable n;
    private final Handler o;
    private final ArrayList<m> p;
    private x[] q = new x[0];
    private int[] r = new int[0];
    private boolean s;
    private int t = -1;
    private boolean u;
    private int v = -1;
    private int w;
    private int x;
    private boolean y;
    private boolean z;

    /* compiled from: HlsSampleStreamWrapper */
    public interface a extends z.a<n> {
        void a();

        void i(d.a aVar);
    }

    public n(int i2, a aVar, f fVar, com.google.android.exoplayer2.upstream.d dVar, long j2, l lVar, t tVar, v.a aVar2) {
        this.f6417b = i2;
        this.f6418c = aVar;
        this.f6419d = fVar;
        this.f6420e = dVar;
        this.f6421f = lVar;
        this.f6422g = tVar;
        this.f6424i = aVar2;
        ArrayList<j> arrayList = new ArrayList<>();
        this.f6426k = arrayList;
        this.l = Collections.unmodifiableList(arrayList);
        this.p = new ArrayList<>();
        this.m = new b(this);
        this.n = new a(this);
        this.o = new Handler();
        this.L = j2;
        this.M = j2;
    }

    private static boolean A(l lVar, l lVar2) {
        String str = lVar.f5977h;
        String str2 = lVar2.f5977h;
        int g2 = p.g(str);
        if (g2 != 3) {
            if (g2 == p.g(str2)) {
                return true;
            }
            return false;
        } else if (!d0.b(str, str2)) {
            return false;
        } else {
            if (("application/cea-608".equals(str) || "application/cea-708".equals(str)) && lVar.B != lVar2.B) {
                return false;
            }
            return true;
        }
    }

    private j B() {
        ArrayList<j> arrayList = this.f6426k;
        return arrayList.get(arrayList.size() - 1);
    }

    private static int C(int i2) {
        if (i2 == 1) {
            return 2;
        }
        if (i2 != 2) {
            return i2 != 3 ? 0 : 1;
        }
        return 3;
    }

    private static boolean E(com.google.android.exoplayer2.source.d0.d dVar) {
        return dVar instanceof j;
    }

    private boolean F() {
        return this.M != -9223372036854775807L;
    }

    private void J() {
        int i2 = this.E.f6087b;
        int[] iArr = new int[i2];
        this.G = iArr;
        Arrays.fill(iArr, -1);
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = 0;
            while (true) {
                x[] xVarArr = this.q;
                if (i4 >= xVarArr.length) {
                    break;
                } else if (A(xVarArr[i4].s(), this.E.g(i3).g(0))) {
                    this.G[i3] = i4;
                    break;
                } else {
                    i4++;
                }
            }
        }
        Iterator<m> it = this.p.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }

    /* access modifiers changed from: private */
    public void K() {
        if (!this.D && this.G == null && this.y) {
            for (x xVar : this.q) {
                if (xVar.s() == null) {
                    return;
                }
            }
            if (this.E != null) {
                J();
                return;
            }
            v();
            this.z = true;
            this.f6418c.a();
        }
    }

    /* access modifiers changed from: private */
    public void Q() {
        this.y = true;
        K();
    }

    private void U() {
        for (x xVar : this.q) {
            xVar.D(this.N);
        }
        this.N = false;
    }

    private boolean V(long j2) {
        int length = this.q.length;
        int i2 = 0;
        while (true) {
            boolean z2 = true;
            if (i2 >= length) {
                return true;
            }
            x xVar = this.q[i2];
            xVar.E();
            if (xVar.f(j2, true, false) == -1) {
                z2 = false;
            }
            if (z2 || (!this.K[i2] && this.I)) {
                i2++;
            }
        }
        return false;
    }

    private void c0(y[] yVarArr) {
        this.p.clear();
        for (y yVar : yVarArr) {
            if (yVar != null) {
                this.p.add((m) yVar);
            }
        }
    }

    private void v() {
        int length = this.q.length;
        boolean z2 = false;
        int i2 = 0;
        int i3 = 6;
        int i4 = -1;
        while (true) {
            int i5 = 2;
            if (i2 >= length) {
                break;
            }
            String str = this.q[i2].s().f5977h;
            if (!p.m(str)) {
                if (p.k(str)) {
                    i5 = 1;
                } else {
                    i5 = p.l(str) ? 3 : 6;
                }
            }
            if (C(i5) > C(i3)) {
                i4 = i2;
                i3 = i5;
            } else if (i5 == i3 && i4 != -1) {
                i4 = -1;
            }
            i2++;
        }
        b0 e2 = this.f6419d.e();
        int i6 = e2.f6079b;
        this.H = -1;
        this.G = new int[length];
        for (int i7 = 0; i7 < length; i7++) {
            this.G[i7] = i7;
        }
        b0[] b0VarArr = new b0[length];
        for (int i8 = 0; i8 < length; i8++) {
            l s2 = this.q[i8].s();
            if (i8 == i4) {
                l[] lVarArr = new l[i6];
                if (i6 == 1) {
                    lVarArr[0] = s2.m(e2.g(0));
                } else {
                    for (int i9 = 0; i9 < i6; i9++) {
                        lVarArr[i9] = y(e2.g(i9), s2, true);
                    }
                }
                b0VarArr[i8] = new b0(lVarArr);
                this.H = i8;
            } else {
                b0VarArr[i8] = new b0(y((i3 != 2 || !p.k(s2.f5977h)) ? null : this.f6421f, s2, false));
            }
        }
        this.E = new c0(b0VarArr);
        if (this.F == null) {
            z2 = true;
        }
        e.f(z2);
        this.F = c0.f6086e;
    }

    private static com.google.android.exoplayer2.e0.f x(int i2, int i3) {
        m.f("HlsSampleStreamWrapper", "Unmapped track with id " + i2 + " of type " + i3);
        return new com.google.android.exoplayer2.e0.f();
    }

    private static l y(l lVar, l lVar2, boolean z2) {
        if (lVar == null) {
            return lVar2;
        }
        int i2 = z2 ? lVar.f5973d : -1;
        String x2 = d0.x(lVar.f5974e, p.g(lVar2.f5977h));
        String d2 = p.d(x2);
        if (d2 == null) {
            d2 = lVar2.f5977h;
        }
        return lVar2.g(lVar.f5971b, lVar.f5972c, d2, x2, i2, lVar.m, lVar.n, lVar.z, lVar.A);
    }

    private boolean z(j jVar) {
        int i2 = jVar.f6389j;
        int length = this.q.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (this.J[i3] && this.q[i3].v() == i2) {
                return false;
            }
        }
        return true;
    }

    public void D(int i2, boolean z2, boolean z3) {
        if (!z3) {
            this.s = false;
            this.u = false;
        }
        this.S = i2;
        for (x xVar : this.q) {
            xVar.I(i2);
        }
        if (z2) {
            for (x xVar2 : this.q) {
                xVar2.J();
            }
        }
    }

    public boolean G(int i2) {
        return this.P || (!F() && this.q[i2].u());
    }

    public void L() {
        this.f6423h.a();
        this.f6419d.h();
    }

    /* renamed from: M */
    public void k(com.google.android.exoplayer2.source.d0.d dVar, long j2, long j3, boolean z2) {
        this.f6424i.x(dVar.f6098a, dVar.f(), dVar.e(), dVar.f6099b, this.f6417b, dVar.f6100c, dVar.f6101d, dVar.f6102e, dVar.f6103f, dVar.f6104g, j2, j3, dVar.c());
        if (!z2) {
            U();
            if (this.A > 0) {
                this.f6418c.n(this);
            }
        }
    }

    /* renamed from: N */
    public void q(com.google.android.exoplayer2.source.d0.d dVar, long j2, long j3) {
        this.f6419d.j(dVar);
        this.f6424i.A(dVar.f6098a, dVar.f(), dVar.e(), dVar.f6099b, this.f6417b, dVar.f6100c, dVar.f6101d, dVar.f6102e, dVar.f6103f, dVar.f6104g, j2, j3, dVar.c());
        if (!this.z) {
            f(this.L);
        } else {
            this.f6418c.n(this);
        }
    }

    /* renamed from: O */
    public Loader.c p(com.google.android.exoplayer2.source.d0.d dVar, long j2, long j3, IOException iOException, int i2) {
        Loader.c g2;
        long c2 = dVar.c();
        boolean E2 = E(dVar);
        long a2 = this.f6422g.a(dVar.f6099b, j3, iOException, i2);
        boolean z2 = false;
        boolean g3 = a2 != -9223372036854775807L ? this.f6419d.g(dVar, a2) : false;
        if (g3) {
            if (E2 && c2 == 0) {
                ArrayList<j> arrayList = this.f6426k;
                if (arrayList.remove(arrayList.size() - 1) == dVar) {
                    z2 = true;
                }
                e.f(z2);
                if (this.f6426k.isEmpty()) {
                    this.M = this.L;
                }
            }
            g2 = Loader.f6879e;
        } else {
            long c3 = this.f6422g.c(dVar.f6099b, j3, iOException, i2);
            g2 = c3 != -9223372036854775807L ? Loader.g(false, c3) : Loader.f6880f;
        }
        this.f6424i.D(dVar.f6098a, dVar.f(), dVar.e(), dVar.f6099b, this.f6417b, dVar.f6100c, dVar.f6101d, dVar.f6102e, dVar.f6103f, dVar.f6104g, j2, j3, c2, iOException, !g2.c());
        if (g3) {
            if (!this.z) {
                f(this.L);
            } else {
                this.f6418c.n(this);
            }
        }
        return g2;
    }

    public boolean P(d.a aVar, long j2) {
        return this.f6419d.k(aVar, j2);
    }

    public void R(c0 c0Var, int i2, c0 c0Var2) {
        this.z = true;
        this.E = c0Var;
        this.F = c0Var2;
        this.H = i2;
        this.f6418c.a();
    }

    public int S(int i2, com.google.android.exoplayer2.m mVar, com.google.android.exoplayer2.d0.e eVar, boolean z2) {
        if (F()) {
            return -3;
        }
        int i3 = 0;
        if (!this.f6426k.isEmpty()) {
            int i4 = 0;
            while (i4 < this.f6426k.size() - 1 && z(this.f6426k.get(i4))) {
                i4++;
            }
            d0.X(this.f6426k, 0, i4);
            j jVar = this.f6426k.get(0);
            l lVar = jVar.f6100c;
            if (!lVar.equals(this.C)) {
                this.f6424i.c(this.f6417b, lVar, jVar.f6101d, jVar.f6102e, jVar.f6103f);
            }
            this.C = lVar;
        }
        int y2 = this.q[i2].y(mVar, eVar, z2, this.P, this.L);
        if (y2 == -5 && i2 == this.x) {
            int v2 = this.q[i2].v();
            while (i3 < this.f6426k.size() && this.f6426k.get(i3).f6389j != v2) {
                i3++;
            }
            mVar.f5981a = mVar.f5981a.m(i3 < this.f6426k.size() ? this.f6426k.get(i3).f6100c : this.B);
        }
        return y2;
    }

    public void T() {
        if (this.z) {
            for (x xVar : this.q) {
                xVar.k();
            }
        }
        this.f6423h.k(this);
        this.o.removeCallbacksAndMessages(null);
        this.D = true;
        this.p.clear();
    }

    public boolean W(long j2, boolean z2) {
        this.L = j2;
        if (F()) {
            this.M = j2;
            return true;
        } else if (this.y && !z2 && V(j2)) {
            return false;
        } else {
            this.M = j2;
            this.P = false;
            this.f6426k.clear();
            if (this.f6423h.h()) {
                this.f6423h.f();
            } else {
                U();
            }
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:68:0x0132  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x013c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean X(com.google.android.exoplayer2.g0.g[] r20, boolean[] r21, com.google.android.exoplayer2.source.y[] r22, boolean[] r23, long r24, boolean r26) {
        /*
        // Method dump skipped, instructions count: 337
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.hls.n.X(com.google.android.exoplayer2.g0.g[], boolean[], com.google.android.exoplayer2.source.y[], boolean[], long, boolean):boolean");
    }

    public void Y(boolean z2) {
        this.f6419d.p(z2);
    }

    public void Z(long j2) {
        this.R = j2;
        for (x xVar : this.q) {
            xVar.G(j2);
        }
    }

    @Override // com.google.android.exoplayer2.e0.i
    public q a(int i2, int i3) {
        x[] xVarArr = this.q;
        int length = xVarArr.length;
        boolean z2 = false;
        if (i3 == 1) {
            int i4 = this.t;
            if (i4 != -1) {
                if (!this.s) {
                    this.s = true;
                    this.r[i4] = i2;
                    return xVarArr[i4];
                } else if (this.r[i4] == i2) {
                    return xVarArr[i4];
                } else {
                    return x(i2, i3);
                }
            } else if (this.Q) {
                return x(i2, i3);
            }
        } else if (i3 == 2) {
            int i5 = this.v;
            if (i5 != -1) {
                if (!this.u) {
                    this.u = true;
                    this.r[i5] = i2;
                    return xVarArr[i5];
                } else if (this.r[i5] == i2) {
                    return xVarArr[i5];
                } else {
                    return x(i2, i3);
                }
            } else if (this.Q) {
                return x(i2, i3);
            }
        } else {
            for (int i6 = 0; i6 < length; i6++) {
                if (this.r[i6] == i2) {
                    return this.q[i6];
                }
            }
            if (this.Q) {
                return x(i2, i3);
            }
        }
        x xVar = new x(this.f6420e);
        xVar.G(this.R);
        xVar.I(this.S);
        xVar.H(this);
        int i7 = length + 1;
        int[] copyOf = Arrays.copyOf(this.r, i7);
        this.r = copyOf;
        copyOf[length] = i2;
        x[] xVarArr2 = (x[]) Arrays.copyOf(this.q, i7);
        this.q = xVarArr2;
        xVarArr2[length] = xVar;
        boolean[] copyOf2 = Arrays.copyOf(this.K, i7);
        this.K = copyOf2;
        if (i3 == 1 || i3 == 2) {
            z2 = true;
        }
        copyOf2[length] = z2;
        this.I = copyOf2[length] | this.I;
        if (i3 == 1) {
            this.s = true;
            this.t = length;
        } else if (i3 == 2) {
            this.u = true;
            this.v = length;
        }
        if (C(i3) > C(this.w)) {
            this.x = length;
            this.w = i3;
        }
        this.J = Arrays.copyOf(this.J, i7);
        return xVar;
    }

    public int a0(int i2, long j2) {
        if (F()) {
            return 0;
        }
        x xVar = this.q[i2];
        if (this.P && j2 > xVar.q()) {
            return xVar.g();
        }
        int f2 = xVar.f(j2, true, true);
        if (f2 == -1) {
            return 0;
        }
        return f2;
    }

    public void b0(int i2) {
        int i3 = this.G[i2];
        e.f(this.J[i3]);
        this.J[i3] = false;
    }

    @Override // com.google.android.exoplayer2.source.z
    public long c() {
        if (F()) {
            return this.M;
        }
        if (this.P) {
            return Long.MIN_VALUE;
        }
        return B().f6104g;
    }

    @Override // com.google.android.exoplayer2.source.z
    public long d() {
        if (this.P) {
            return Long.MIN_VALUE;
        }
        if (F()) {
            return this.M;
        }
        long j2 = this.L;
        j B2 = B();
        if (!B2.h()) {
            if (this.f6426k.size() > 1) {
                ArrayList<j> arrayList = this.f6426k;
                B2 = arrayList.get(arrayList.size() - 2);
            } else {
                B2 = null;
            }
        }
        if (B2 != null) {
            j2 = Math.max(j2, B2.f6104g);
        }
        if (this.y) {
            for (x xVar : this.q) {
                j2 = Math.max(j2, xVar.q());
            }
        }
        return j2;
    }

    @Override // com.google.android.exoplayer2.e0.i
    public void e(o oVar) {
    }

    @Override // com.google.android.exoplayer2.source.z
    public boolean f(long j2) {
        List<j> list;
        long max;
        if (this.P || this.f6423h.h()) {
            return false;
        }
        if (F()) {
            list = Collections.emptyList();
            max = this.M;
        } else {
            list = this.l;
            j B2 = B();
            if (B2.h()) {
                max = B2.f6104g;
            } else {
                max = Math.max(this.L, B2.f6103f);
            }
        }
        this.f6419d.d(j2, max, list, this.f6425j);
        f.b bVar = this.f6425j;
        boolean z2 = bVar.f6385b;
        com.google.android.exoplayer2.source.d0.d dVar = bVar.f6384a;
        d.a aVar = bVar.f6386c;
        bVar.a();
        if (z2) {
            this.M = -9223372036854775807L;
            this.P = true;
            return true;
        } else if (dVar == null) {
            if (aVar != null) {
                this.f6418c.i(aVar);
            }
            return false;
        } else {
            if (E(dVar)) {
                this.M = -9223372036854775807L;
                j jVar = (j) dVar;
                jVar.j(this);
                this.f6426k.add(jVar);
                this.B = jVar.f6100c;
            }
            this.f6424i.G(dVar.f6098a, dVar.f6099b, this.f6417b, dVar.f6100c, dVar.f6101d, dVar.f6102e, dVar.f6103f, dVar.f6104g, this.f6423h.l(dVar, this, this.f6422g.b(dVar.f6099b)));
            return true;
        }
    }

    @Override // com.google.android.exoplayer2.source.z
    public void g(long j2) {
    }

    @Override // com.google.android.exoplayer2.e0.i
    public void h() {
        this.Q = true;
        this.o.post(this.n);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.f
    public void i() {
        U();
    }

    @Override // com.google.android.exoplayer2.source.x.b
    public void n(l lVar) {
        this.o.post(this.m);
    }

    public c0 o() {
        return this.E;
    }

    public void r() {
        L();
    }

    public void s(long j2, boolean z2) {
        if (this.y && !F()) {
            int length = this.q.length;
            for (int i2 = 0; i2 < length; i2++) {
                this.q[i2].j(j2, z2, this.J[i2]);
            }
        }
    }

    public int u(int i2) {
        int i3 = this.G[i2];
        if (i3 != -1) {
            boolean[] zArr = this.J;
            if (zArr[i3]) {
                return -2;
            }
            zArr[i3] = true;
            return i3;
        } else if (this.F.k(this.E.g(i2)) == -1) {
            return -2;
        } else {
            return -3;
        }
    }

    public void w() {
        if (!this.z) {
            f(this.L);
        }
    }
}
