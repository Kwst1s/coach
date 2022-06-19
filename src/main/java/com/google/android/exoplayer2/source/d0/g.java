package com.google.android.exoplayer2.source.d0;

import com.google.android.exoplayer2.a0;
import com.google.android.exoplayer2.l;
import com.google.android.exoplayer2.m;
import com.google.android.exoplayer2.source.d0.h;
import com.google.android.exoplayer2.source.v;
import com.google.android.exoplayer2.source.x;
import com.google.android.exoplayer2.source.y;
import com.google.android.exoplayer2.source.z;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.d;
import com.google.android.exoplayer2.upstream.t;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.e;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: ChunkSampleStream */
public class g<T extends h> implements y, z, Loader.b<d>, Loader.f {

    /* renamed from: b  reason: collision with root package name */
    public final int f6124b;

    /* renamed from: c  reason: collision with root package name */
    private final int[] f6125c;

    /* renamed from: d  reason: collision with root package name */
    private final l[] f6126d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean[] f6127e;

    /* renamed from: f  reason: collision with root package name */
    private final T f6128f;

    /* renamed from: g  reason: collision with root package name */
    private final z.a<g<T>> f6129g;

    /* renamed from: h  reason: collision with root package name */
    private final v.a f6130h;

    /* renamed from: i  reason: collision with root package name */
    private final t f6131i;

    /* renamed from: j  reason: collision with root package name */
    private final Loader f6132j = new Loader("Loader:ChunkSampleStream");

    /* renamed from: k  reason: collision with root package name */
    private final f f6133k = new f();
    private final ArrayList<a> l;
    private final List<a> m;
    private final x n;
    private final x[] o;
    private final c p;
    private l q;
    private b<T> r;
    private long s;
    private long t;
    private int u;
    long v;
    boolean w;

    /* compiled from: ChunkSampleStream */
    public final class a implements y {

        /* renamed from: b  reason: collision with root package name */
        public final g<T> f6134b;

        /* renamed from: c  reason: collision with root package name */
        private final x f6135c;

        /* renamed from: d  reason: collision with root package name */
        private final int f6136d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f6137e;

        public a(g<T> gVar, x xVar, int i2) {
            this.f6134b = gVar;
            this.f6135c = xVar;
            this.f6136d = i2;
        }

        private void b() {
            if (!this.f6137e) {
                g.this.f6130h.c(g.this.f6125c[this.f6136d], g.this.f6126d[this.f6136d], 0, null, g.this.t);
                this.f6137e = true;
            }
        }

        @Override // com.google.android.exoplayer2.source.y
        public void a() {
        }

        public void c() {
            e.f(g.this.f6127e[this.f6136d]);
            g.this.f6127e[this.f6136d] = false;
        }

        @Override // com.google.android.exoplayer2.source.y
        public boolean e() {
            g gVar = g.this;
            return gVar.w || (!gVar.F() && this.f6135c.u());
        }

        @Override // com.google.android.exoplayer2.source.y
        public int h(m mVar, com.google.android.exoplayer2.d0.e eVar, boolean z) {
            if (g.this.F()) {
                return -3;
            }
            b();
            x xVar = this.f6135c;
            g gVar = g.this;
            return xVar.y(mVar, eVar, z, gVar.w, gVar.v);
        }

        @Override // com.google.android.exoplayer2.source.y
        public int n(long j2) {
            if (g.this.F()) {
                return 0;
            }
            b();
            if (g.this.w && j2 > this.f6135c.q()) {
                return this.f6135c.g();
            }
            int f2 = this.f6135c.f(j2, true, true);
            if (f2 == -1) {
                return 0;
            }
            return f2;
        }
    }

    /* compiled from: ChunkSampleStream */
    public interface b<T extends h> {
        void e(g<T> gVar);
    }

    public g(int i2, int[] iArr, l[] lVarArr, T t2, z.a<g<T>> aVar, d dVar, long j2, t tVar, v.a aVar2) {
        int i3;
        this.f6124b = i2;
        this.f6125c = iArr;
        this.f6126d = lVarArr;
        this.f6128f = t2;
        this.f6129g = aVar;
        this.f6130h = aVar2;
        this.f6131i = tVar;
        ArrayList<a> arrayList = new ArrayList<>();
        this.l = arrayList;
        this.m = Collections.unmodifiableList(arrayList);
        int i4 = 0;
        if (iArr == null) {
            i3 = 0;
        } else {
            i3 = iArr.length;
        }
        this.o = new x[i3];
        this.f6127e = new boolean[i3];
        int i5 = i3 + 1;
        int[] iArr2 = new int[i5];
        x[] xVarArr = new x[i5];
        x xVar = new x(dVar);
        this.n = xVar;
        iArr2[0] = i2;
        xVarArr[0] = xVar;
        while (i4 < i3) {
            x xVar2 = new x(dVar);
            this.o[i4] = xVar2;
            int i6 = i4 + 1;
            xVarArr[i6] = xVar2;
            iArr2[i6] = iArr[i4];
            i4 = i6;
        }
        this.p = new c(iArr2, xVarArr);
        this.s = j2;
        this.t = j2;
    }

    private a A(int i2) {
        a aVar = this.l.get(i2);
        ArrayList<a> arrayList = this.l;
        d0.X(arrayList, i2, arrayList.size());
        this.u = Math.max(this.u, this.l.size());
        int i3 = 0;
        this.n.m(aVar.i(0));
        while (true) {
            x[] xVarArr = this.o;
            if (i3 >= xVarArr.length) {
                return aVar;
            }
            x xVar = xVarArr[i3];
            i3++;
            xVar.m(aVar.i(i3));
        }
    }

    private a C() {
        ArrayList<a> arrayList = this.l;
        return arrayList.get(arrayList.size() - 1);
    }

    private boolean D(int i2) {
        int r2;
        a aVar = this.l.get(i2);
        if (this.n.r() > aVar.i(0)) {
            return true;
        }
        int i3 = 0;
        do {
            x[] xVarArr = this.o;
            if (i3 >= xVarArr.length) {
                return false;
            }
            r2 = xVarArr[i3].r();
            i3++;
        } while (r2 <= aVar.i(i3));
        return true;
    }

    private boolean E(d dVar) {
        return dVar instanceof a;
    }

    private void G() {
        int L = L(this.n.r(), this.u - 1);
        while (true) {
            int i2 = this.u;
            if (i2 <= L) {
                this.u = i2 + 1;
                H(i2);
            } else {
                return;
            }
        }
    }

    private void H(int i2) {
        a aVar = this.l.get(i2);
        l lVar = aVar.f6100c;
        if (!lVar.equals(this.q)) {
            this.f6130h.c(this.f6124b, lVar, aVar.f6101d, aVar.f6102e, aVar.f6103f);
        }
        this.q = lVar;
    }

    private int L(int i2, int i3) {
        do {
            i3++;
            if (i3 >= this.l.size()) {
                return this.l.size() - 1;
            }
        } while (this.l.get(i3).i(0) <= i2);
        return i3 - 1;
    }

    private void z(int i2) {
        int min = Math.min(L(i2, 0), this.u);
        if (min > 0) {
            d0.X(this.l, 0, min);
            this.u -= min;
        }
    }

    public T B() {
        return this.f6128f;
    }

    /* access modifiers changed from: package-private */
    public boolean F() {
        return this.s != -9223372036854775807L;
    }

    /* renamed from: I */
    public void k(d dVar, long j2, long j3, boolean z) {
        this.f6130h.x(dVar.f6098a, dVar.f(), dVar.e(), dVar.f6099b, this.f6124b, dVar.f6100c, dVar.f6101d, dVar.f6102e, dVar.f6103f, dVar.f6104g, j2, j3, dVar.c());
        if (!z) {
            this.n.C();
            for (x xVar : this.o) {
                xVar.C();
            }
            this.f6129g.n(this);
        }
    }

    /* renamed from: J */
    public void q(d dVar, long j2, long j3) {
        this.f6128f.e(dVar);
        this.f6130h.A(dVar.f6098a, dVar.f(), dVar.e(), dVar.f6099b, this.f6124b, dVar.f6100c, dVar.f6101d, dVar.f6102e, dVar.f6103f, dVar.f6104g, j2, j3, dVar.c());
        this.f6129g.n(this);
    }

    /* renamed from: K */
    public Loader.c p(d dVar, long j2, long j3, IOException iOException, int i2) {
        long c2 = dVar.c();
        boolean E = E(dVar);
        int size = this.l.size() - 1;
        boolean z = c2 == 0 || !E || !D(size);
        Loader.c cVar = null;
        if (this.f6128f.h(dVar, z, iOException, z ? this.f6131i.a(dVar.f6099b, j3, iOException, i2) : -9223372036854775807L)) {
            if (z) {
                cVar = Loader.f6879e;
                if (E) {
                    e.f(A(size) == dVar);
                    if (this.l.isEmpty()) {
                        this.s = this.t;
                    }
                }
            } else {
                com.google.android.exoplayer2.util.m.f("ChunkSampleStream", "Ignoring attempt to cancel non-cancelable load.");
            }
        }
        if (cVar == null) {
            long c3 = this.f6131i.c(dVar.f6099b, j3, iOException, i2);
            cVar = c3 != -9223372036854775807L ? Loader.g(false, c3) : Loader.f6880f;
        }
        boolean z2 = !cVar.c();
        this.f6130h.D(dVar.f6098a, dVar.f(), dVar.e(), dVar.f6099b, this.f6124b, dVar.f6100c, dVar.f6101d, dVar.f6102e, dVar.f6103f, dVar.f6104g, j2, j3, c2, iOException, z2);
        if (z2) {
            this.f6129g.n(this);
        }
        return cVar;
    }

    public void M() {
        N(null);
    }

    public void N(b<T> bVar) {
        this.r = bVar;
        this.n.k();
        for (x xVar : this.o) {
            xVar.k();
        }
        this.f6132j.k(this);
    }

    public void O(long j2) {
        boolean z;
        this.t = j2;
        if (F()) {
            this.s = j2;
            return;
        }
        a aVar = null;
        int i2 = 0;
        while (true) {
            if (i2 >= this.l.size()) {
                break;
            }
            a aVar2 = this.l.get(i2);
            long j3 = aVar2.f6103f;
            if (j3 == j2 && aVar2.f6094j == -9223372036854775807L) {
                aVar = aVar2;
                break;
            } else if (j3 > j2) {
                break;
            } else {
                i2++;
            }
        }
        this.n.E();
        if (aVar != null) {
            z = this.n.F(aVar.i(0));
            this.v = 0;
        } else {
            z = this.n.f(j2, true, (j2 > c() ? 1 : (j2 == c() ? 0 : -1)) < 0) != -1;
            this.v = this.t;
        }
        if (z) {
            this.u = L(this.n.r(), 0);
            x[] xVarArr = this.o;
            for (x xVar : xVarArr) {
                xVar.E();
                xVar.f(j2, true, false);
            }
            return;
        }
        this.s = j2;
        this.w = false;
        this.l.clear();
        this.u = 0;
        if (this.f6132j.h()) {
            this.f6132j.f();
            return;
        }
        this.n.C();
        for (x xVar2 : this.o) {
            xVar2.C();
        }
    }

    public g<T>.a P(long j2, int i2) {
        for (int i3 = 0; i3 < this.o.length; i3++) {
            if (this.f6125c[i3] == i2) {
                e.f(!this.f6127e[i3]);
                this.f6127e[i3] = true;
                this.o[i3].E();
                this.o[i3].f(j2, true, true);
                return new a(this, this.o[i3], i3);
            }
        }
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.source.y
    public void a() {
        this.f6132j.a();
        if (!this.f6132j.h()) {
            this.f6128f.a();
        }
    }

    public long b(long j2, a0 a0Var) {
        return this.f6128f.b(j2, a0Var);
    }

    @Override // com.google.android.exoplayer2.source.z
    public long c() {
        if (F()) {
            return this.s;
        }
        if (this.w) {
            return Long.MIN_VALUE;
        }
        return C().f6104g;
    }

    @Override // com.google.android.exoplayer2.source.z
    public long d() {
        if (this.w) {
            return Long.MIN_VALUE;
        }
        if (F()) {
            return this.s;
        }
        long j2 = this.t;
        a C = C();
        if (!C.h()) {
            if (this.l.size() > 1) {
                ArrayList<a> arrayList = this.l;
                C = arrayList.get(arrayList.size() - 2);
            } else {
                C = null;
            }
        }
        if (C != null) {
            j2 = Math.max(j2, C.f6104g);
        }
        return Math.max(j2, this.n.q());
    }

    @Override // com.google.android.exoplayer2.source.y
    public boolean e() {
        return this.w || (!F() && this.n.u());
    }

    @Override // com.google.android.exoplayer2.source.z
    public boolean f(long j2) {
        long j3;
        List<a> list;
        boolean z = false;
        if (this.w || this.f6132j.h()) {
            return false;
        }
        boolean F = F();
        if (F) {
            list = Collections.emptyList();
            j3 = this.s;
        } else {
            list = this.m;
            j3 = C().f6104g;
        }
        this.f6128f.g(j2, j3, list, this.f6133k);
        f fVar = this.f6133k;
        boolean z2 = fVar.f6123b;
        d dVar = fVar.f6122a;
        fVar.a();
        if (z2) {
            this.s = -9223372036854775807L;
            this.w = true;
            return true;
        } else if (dVar == null) {
            return false;
        } else {
            if (E(dVar)) {
                a aVar = (a) dVar;
                if (F) {
                    long j4 = aVar.f6103f;
                    long j5 = this.s;
                    if (j4 == j5) {
                        z = true;
                    }
                    if (z) {
                        j5 = 0;
                    }
                    this.v = j5;
                    this.s = -9223372036854775807L;
                }
                aVar.k(this.p);
                this.l.add(aVar);
            }
            this.f6130h.G(dVar.f6098a, dVar.f6099b, this.f6124b, dVar.f6100c, dVar.f6101d, dVar.f6102e, dVar.f6103f, dVar.f6104g, this.f6132j.l(dVar, this, this.f6131i.b(dVar.f6099b)));
            return true;
        }
    }

    @Override // com.google.android.exoplayer2.source.z
    public void g(long j2) {
        int size;
        int d2;
        if (!this.f6132j.h() && !F() && (size = this.l.size()) > (d2 = this.f6128f.d(j2, this.m))) {
            while (true) {
                if (d2 >= size) {
                    d2 = size;
                    break;
                } else if (!D(d2)) {
                    break;
                } else {
                    d2++;
                }
            }
            if (d2 != size) {
                long j3 = C().f6104g;
                a A = A(d2);
                if (this.l.isEmpty()) {
                    this.s = this.t;
                }
                this.w = false;
                this.f6130h.N(this.f6124b, A.f6103f, j3);
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.y
    public int h(m mVar, com.google.android.exoplayer2.d0.e eVar, boolean z) {
        if (F()) {
            return -3;
        }
        G();
        return this.n.y(mVar, eVar, z, this.w, this.v);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.f
    public void i() {
        this.n.C();
        for (x xVar : this.o) {
            xVar.C();
        }
        b<T> bVar = this.r;
        if (bVar != null) {
            bVar.e(this);
        }
    }

    @Override // com.google.android.exoplayer2.source.y
    public int n(long j2) {
        int i2 = 0;
        if (F()) {
            return 0;
        }
        if (!this.w || j2 <= this.n.q()) {
            int f2 = this.n.f(j2, true, true);
            if (f2 != -1) {
                i2 = f2;
            }
        } else {
            i2 = this.n.g();
        }
        G();
        return i2;
    }

    public void s(long j2, boolean z) {
        if (!F()) {
            int o2 = this.n.o();
            this.n.j(j2, z, true);
            int o3 = this.n.o();
            if (o3 > o2) {
                long p2 = this.n.p();
                int i2 = 0;
                while (true) {
                    x[] xVarArr = this.o;
                    if (i2 >= xVarArr.length) {
                        break;
                    }
                    xVarArr[i2].j(p2, z, this.f6127e[i2]);
                    i2++;
                }
            }
            z(o3);
        }
    }
}
