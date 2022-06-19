package com.google.android.exoplayer2.source.hls;

import com.google.android.exoplayer2.a0;
import com.google.android.exoplayer2.g0.g;
import com.google.android.exoplayer2.l;
import com.google.android.exoplayer2.source.b0;
import com.google.android.exoplayer2.source.c0;
import com.google.android.exoplayer2.source.hls.n;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.source.hls.playlist.d;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.source.t;
import com.google.android.exoplayer2.source.v;
import com.google.android.exoplayer2.source.y;
import com.google.android.exoplayer2.source.z;
import com.google.android.exoplayer2.upstream.d;
import com.google.android.exoplayer2.upstream.x;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.e;
import com.google.android.exoplayer2.util.p;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;

/* compiled from: HlsMediaPeriod */
public final class k implements t, n.a, HlsPlaylistTracker.b {

    /* renamed from: b  reason: collision with root package name */
    private final h f6391b;

    /* renamed from: c  reason: collision with root package name */
    private final HlsPlaylistTracker f6392c;

    /* renamed from: d  reason: collision with root package name */
    private final g f6393d;

    /* renamed from: e  reason: collision with root package name */
    private final x f6394e;

    /* renamed from: f  reason: collision with root package name */
    private final com.google.android.exoplayer2.upstream.t f6395f;

    /* renamed from: g  reason: collision with root package name */
    private final v.a f6396g;

    /* renamed from: h  reason: collision with root package name */
    private final d f6397h;

    /* renamed from: i  reason: collision with root package name */
    private final IdentityHashMap<y, Integer> f6398i = new IdentityHashMap<>();

    /* renamed from: j  reason: collision with root package name */
    private final o f6399j = new o();

    /* renamed from: k  reason: collision with root package name */
    private final o f6400k;
    private final boolean l;
    private t.a m;
    private int n;
    private c0 o;
    private n[] p = new n[0];
    private n[] q = new n[0];
    private z r;
    private boolean s;

    public k(h hVar, HlsPlaylistTracker hlsPlaylistTracker, g gVar, x xVar, com.google.android.exoplayer2.upstream.t tVar, v.a aVar, d dVar, o oVar, boolean z) {
        this.f6391b = hVar;
        this.f6392c = hlsPlaylistTracker;
        this.f6393d = gVar;
        this.f6394e = xVar;
        this.f6395f = tVar;
        this.f6396g = aVar;
        this.f6397h = dVar;
        this.f6400k = oVar;
        this.l = z;
        this.r = oVar.a(new z[0]);
        aVar.I();
    }

    private void p(com.google.android.exoplayer2.source.hls.playlist.d dVar, long j2) {
        ArrayList arrayList;
        ArrayList arrayList2 = new ArrayList(dVar.f6459d);
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        for (int i2 = 0; i2 < arrayList2.size(); i2++) {
            d.a aVar = (d.a) arrayList2.get(i2);
            l lVar = aVar.f6466b;
            if (lVar.n > 0 || d0.x(lVar.f5974e, 2) != null) {
                arrayList3.add(aVar);
            } else if (d0.x(lVar.f5974e, 1) != null) {
                arrayList4.add(aVar);
            }
        }
        if (!arrayList3.isEmpty()) {
            arrayList = arrayList3;
        } else {
            if (arrayList4.size() < arrayList2.size()) {
                arrayList2.removeAll(arrayList4);
            }
            arrayList = arrayList2;
        }
        e.a(!arrayList.isEmpty());
        d.a[] aVarArr = (d.a[]) arrayList.toArray(new d.a[0]);
        String str = aVarArr[0].f6466b.f5974e;
        n u = u(0, aVarArr, dVar.f6462g, dVar.f6463h, j2);
        this.p[0] = u;
        if (!this.l || str == null) {
            u.Y(true);
            u.w();
            return;
        }
        boolean z = d0.x(str, 2) != null;
        boolean z2 = d0.x(str, 1) != null;
        ArrayList arrayList5 = new ArrayList();
        if (z) {
            int size = arrayList.size();
            l[] lVarArr = new l[size];
            for (int i3 = 0; i3 < size; i3++) {
                lVarArr[i3] = w(aVarArr[i3].f6466b);
            }
            arrayList5.add(new b0(lVarArr));
            if (z2 && (dVar.f6462g != null || dVar.f6460e.isEmpty())) {
                arrayList5.add(new b0(v(aVarArr[0].f6466b, dVar.f6462g, false)));
            }
            List<l> list = dVar.f6463h;
            if (list != null) {
                for (int i4 = 0; i4 < list.size(); i4++) {
                    arrayList5.add(new b0(list.get(i4)));
                }
            }
        } else if (z2) {
            int size2 = arrayList.size();
            l[] lVarArr2 = new l[size2];
            for (int i5 = 0; i5 < size2; i5++) {
                lVarArr2[i5] = v(aVarArr[i5].f6466b, dVar.f6462g, true);
            }
            arrayList5.add(new b0(lVarArr2));
        } else {
            throw new IllegalArgumentException("Unexpected codecs attribute: " + str);
        }
        b0 b0Var = new b0(l.x("ID3", "application/id3", null, -1, null));
        arrayList5.add(b0Var);
        u.R(new c0((b0[]) arrayList5.toArray(new b0[0])), 0, new c0(b0Var));
    }

    private void q(long j2) {
        com.google.android.exoplayer2.source.hls.playlist.d d2 = this.f6392c.d();
        List<d.a> list = d2.f6460e;
        List<d.a> list2 = d2.f6461f;
        int size = list.size() + 1 + list2.size();
        this.p = new n[size];
        this.n = size;
        p(d2, j2);
        char c2 = 0;
        int i2 = 0;
        int i3 = 1;
        while (i2 < list.size()) {
            d.a aVar = list.get(i2);
            d.a[] aVarArr = new d.a[1];
            aVarArr[c2] = aVar;
            n u = u(1, aVarArr, null, Collections.emptyList(), j2);
            int i4 = i3 + 1;
            this.p[i3] = u;
            l lVar = aVar.f6466b;
            if (!this.l || lVar.f5974e == null) {
                u.w();
            } else {
                u.R(new c0(new b0(aVar.f6466b)), 0, c0.f6086e);
            }
            i2++;
            i3 = i4;
            c2 = 0;
        }
        int i5 = 0;
        while (i5 < list2.size()) {
            d.a aVar2 = list2.get(i5);
            n u2 = u(3, new d.a[]{aVar2}, null, Collections.emptyList(), j2);
            this.p[i3] = u2;
            u2.R(new c0(new b0(aVar2.f6466b)), 0, c0.f6086e);
            i5++;
            i3++;
        }
        this.q = this.p;
    }

    private n u(int i2, d.a[] aVarArr, l lVar, List<l> list, long j2) {
        return new n(i2, this, new f(this.f6391b, this.f6392c, aVarArr, this.f6393d, this.f6394e, this.f6399j, list), this.f6397h, j2, lVar, this.f6395f, this.f6396g);
    }

    private static l v(l lVar, l lVar2, boolean z) {
        String str;
        int i2;
        int i3;
        String str2;
        String str3;
        if (lVar2 != null) {
            String str4 = lVar2.f5974e;
            int i4 = lVar2.u;
            int i5 = lVar2.z;
            String str5 = lVar2.A;
            str3 = lVar2.f5972c;
            str2 = str4;
            i3 = i4;
            i2 = i5;
            str = str5;
        } else {
            String x = d0.x(lVar.f5974e, 1);
            if (z) {
                int i6 = lVar.u;
                int i7 = lVar.z;
                str2 = x;
                str3 = lVar.f5972c;
                str = str3;
                i3 = i6;
                i2 = i7;
            } else {
                str2 = x;
                str3 = null;
                str = null;
                i3 = -1;
                i2 = 0;
            }
        }
        return l.q(lVar.f5971b, str3, lVar.f5976g, p.d(str2), str2, z ? lVar.f5973d : -1, i3, -1, null, i2, str);
    }

    private static l w(l lVar) {
        String x = d0.x(lVar.f5974e, 2);
        return l.E(lVar.f5971b, lVar.f5972c, lVar.f5976g, p.d(x), x, lVar.f5973d, lVar.m, lVar.n, lVar.o, null, lVar.z);
    }

    @Override // com.google.android.exoplayer2.source.hls.n.a
    public void a() {
        int i2 = this.n - 1;
        this.n = i2;
        if (i2 <= 0) {
            int i3 = 0;
            for (n nVar : this.p) {
                i3 += nVar.o().f6087b;
            }
            b0[] b0VarArr = new b0[i3];
            n[] nVarArr = this.p;
            int i4 = 0;
            for (n nVar2 : nVarArr) {
                int i5 = nVar2.o().f6087b;
                int i6 = 0;
                while (i6 < i5) {
                    b0VarArr[i4] = nVar2.o().g(i6);
                    i6++;
                    i4++;
                }
            }
            this.o = new c0(b0VarArr);
            this.m.k(this);
        }
    }

    @Override // com.google.android.exoplayer2.source.t
    public long b(long j2, a0 a0Var) {
        return j2;
    }

    @Override // com.google.android.exoplayer2.source.t, com.google.android.exoplayer2.source.z
    public long c() {
        return this.r.c();
    }

    @Override // com.google.android.exoplayer2.source.t, com.google.android.exoplayer2.source.z
    public long d() {
        return this.r.d();
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.b
    public void e() {
        this.m.n(this);
    }

    @Override // com.google.android.exoplayer2.source.t, com.google.android.exoplayer2.source.z
    public boolean f(long j2) {
        if (this.o != null) {
            return this.r.f(j2);
        }
        for (n nVar : this.p) {
            nVar.w();
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.source.t, com.google.android.exoplayer2.source.z
    public void g(long j2) {
        this.r.g(j2);
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.b
    public boolean h(d.a aVar, long j2) {
        boolean z = true;
        for (n nVar : this.p) {
            z &= nVar.P(aVar, j2);
        }
        this.m.n(this);
        return z;
    }

    @Override // com.google.android.exoplayer2.source.hls.n.a
    public void i(d.a aVar) {
        this.f6392c.c(aVar);
    }

    @Override // com.google.android.exoplayer2.source.t
    public long j(g[] gVarArr, boolean[] zArr, y[] yVarArr, boolean[] zArr2, long j2) {
        int i2;
        y[] yVarArr2 = yVarArr;
        int[] iArr = new int[gVarArr.length];
        int[] iArr2 = new int[gVarArr.length];
        for (int i3 = 0; i3 < gVarArr.length; i3++) {
            if (yVarArr2[i3] == null) {
                i2 = -1;
            } else {
                i2 = this.f6398i.get(yVarArr2[i3]).intValue();
            }
            iArr[i3] = i2;
            iArr2[i3] = -1;
            if (gVarArr[i3] != null) {
                b0 j3 = gVarArr[i3].j();
                int i4 = 0;
                while (true) {
                    n[] nVarArr = this.p;
                    if (i4 >= nVarArr.length) {
                        break;
                    } else if (nVarArr[i4].o().k(j3) != -1) {
                        iArr2[i3] = i4;
                        break;
                    } else {
                        i4++;
                    }
                }
            }
        }
        this.f6398i.clear();
        int length = gVarArr.length;
        y[] yVarArr3 = new y[length];
        y[] yVarArr4 = new y[gVarArr.length];
        g[] gVarArr2 = new g[gVarArr.length];
        n[] nVarArr2 = new n[this.p.length];
        int i5 = 0;
        int i6 = 0;
        boolean z = false;
        while (i6 < this.p.length) {
            for (int i7 = 0; i7 < gVarArr.length; i7++) {
                g gVar = null;
                yVarArr4[i7] = iArr[i7] == i6 ? yVarArr2[i7] : null;
                if (iArr2[i7] == i6) {
                    gVar = gVarArr[i7];
                }
                gVarArr2[i7] = gVar;
            }
            n nVar = this.p[i6];
            boolean X = nVar.X(gVarArr2, zArr, yVarArr4, zArr2, j2, z);
            int i8 = 0;
            boolean z2 = false;
            while (true) {
                boolean z3 = true;
                if (i8 >= gVarArr.length) {
                    break;
                }
                if (iArr2[i8] == i6) {
                    e.f(yVarArr4[i8] != null);
                    yVarArr3[i8] = yVarArr4[i8];
                    this.f6398i.put(yVarArr4[i8], Integer.valueOf(i6));
                    z2 = true;
                } else if (iArr[i8] == i6) {
                    if (yVarArr4[i8] != null) {
                        z3 = false;
                    }
                    e.f(z3);
                }
                i8++;
            }
            if (z2) {
                nVarArr2[i5] = nVar;
                i5++;
                if (i5 == 0) {
                    nVar.Y(true);
                    if (!X) {
                        n[] nVarArr3 = this.q;
                        if (nVarArr3.length != 0) {
                            if (nVar == nVarArr3[0]) {
                            }
                            this.f6399j.b();
                            z = true;
                        }
                    }
                    this.f6399j.b();
                    z = true;
                } else {
                    nVar.Y(false);
                }
            } else {
                i5 = i5;
            }
            i6++;
            nVarArr2 = nVarArr2;
            length = length;
            gVarArr2 = gVarArr2;
            yVarArr2 = yVarArr;
        }
        System.arraycopy(yVarArr3, 0, yVarArr2, 0, length);
        n[] nVarArr4 = (n[]) Arrays.copyOf(nVarArr2, i5);
        this.q = nVarArr4;
        this.r = this.f6400k.a(nVarArr4);
        return j2;
    }

    @Override // com.google.android.exoplayer2.source.t
    public long l() {
        if (this.s) {
            return -9223372036854775807L;
        }
        this.f6396g.L();
        this.s = true;
        return -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.source.t
    public void m(t.a aVar, long j2) {
        this.m = aVar;
        this.f6392c.h(this);
        q(j2);
    }

    @Override // com.google.android.exoplayer2.source.t
    public c0 o() {
        return this.o;
    }

    @Override // com.google.android.exoplayer2.source.t
    public void r() {
        for (n nVar : this.p) {
            nVar.r();
        }
    }

    @Override // com.google.android.exoplayer2.source.t
    public void s(long j2, boolean z) {
        for (n nVar : this.q) {
            nVar.s(j2, z);
        }
    }

    @Override // com.google.android.exoplayer2.source.t
    public long t(long j2) {
        n[] nVarArr = this.q;
        if (nVarArr.length > 0) {
            boolean W = nVarArr[0].W(j2, false);
            int i2 = 1;
            while (true) {
                n[] nVarArr2 = this.q;
                if (i2 >= nVarArr2.length) {
                    break;
                }
                nVarArr2[i2].W(j2, W);
                i2++;
            }
            if (W) {
                this.f6399j.b();
            }
        }
        return j2;
    }

    /* renamed from: x */
    public void n(n nVar) {
        this.m.n(this);
    }

    public void y() {
        this.f6392c.g(this);
        for (n nVar : this.p) {
            nVar.T();
        }
        this.m = null;
        this.f6396g.J();
    }
}
