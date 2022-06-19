package com.google.android.exoplayer2.source.dash;

import android.util.Pair;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.a0;
import com.google.android.exoplayer2.l;
import com.google.android.exoplayer2.source.b0;
import com.google.android.exoplayer2.source.c0;
import com.google.android.exoplayer2.source.d0.g;
import com.google.android.exoplayer2.source.dash.c;
import com.google.android.exoplayer2.source.dash.j;
import com.google.android.exoplayer2.source.dash.k.b;
import com.google.android.exoplayer2.source.dash.k.e;
import com.google.android.exoplayer2.source.dash.k.f;
import com.google.android.exoplayer2.source.dash.k.i;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.source.q;
import com.google.android.exoplayer2.source.t;
import com.google.android.exoplayer2.source.v;
import com.google.android.exoplayer2.source.y;
import com.google.android.exoplayer2.source.z;
import com.google.android.exoplayer2.upstream.u;
import com.google.android.exoplayer2.upstream.x;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;

/* access modifiers changed from: package-private */
/* compiled from: DashMediaPeriod */
public final class d implements t, z.a<g<c>>, g.b<c> {

    /* renamed from: b  reason: collision with root package name */
    final int f6148b;

    /* renamed from: c  reason: collision with root package name */
    private final c.a f6149c;

    /* renamed from: d  reason: collision with root package name */
    private final x f6150d;

    /* renamed from: e  reason: collision with root package name */
    private final com.google.android.exoplayer2.upstream.t f6151e;

    /* renamed from: f  reason: collision with root package name */
    private final long f6152f;

    /* renamed from: g  reason: collision with root package name */
    private final u f6153g;

    /* renamed from: h  reason: collision with root package name */
    private final com.google.android.exoplayer2.upstream.d f6154h;

    /* renamed from: i  reason: collision with root package name */
    private final c0 f6155i;

    /* renamed from: j  reason: collision with root package name */
    private final a[] f6156j;

    /* renamed from: k  reason: collision with root package name */
    private final o f6157k;
    private final j l;
    private final IdentityHashMap<g<c>, j.c> m = new IdentityHashMap<>();
    private final v.a n;
    private t.a o;
    private g<c>[] p = C(0);
    private i[] q = new i[0];
    private z r;
    private b s;
    private int t;
    private List<e> u;
    private boolean v;

    /* access modifiers changed from: private */
    /* compiled from: DashMediaPeriod */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int[] f6158a;

        /* renamed from: b  reason: collision with root package name */
        public final int f6159b;

        /* renamed from: c  reason: collision with root package name */
        public final int f6160c;

        /* renamed from: d  reason: collision with root package name */
        public final int f6161d;

        /* renamed from: e  reason: collision with root package name */
        public final int f6162e;

        /* renamed from: f  reason: collision with root package name */
        public final int f6163f;

        /* renamed from: g  reason: collision with root package name */
        public final int f6164g;

        private a(int i2, int i3, int[] iArr, int i4, int i5, int i6, int i7) {
            this.f6159b = i2;
            this.f6158a = iArr;
            this.f6160c = i3;
            this.f6162e = i4;
            this.f6163f = i5;
            this.f6164g = i6;
            this.f6161d = i7;
        }

        public static a a(int[] iArr, int i2) {
            return new a(3, 1, iArr, i2, -1, -1, -1);
        }

        public static a b(int[] iArr, int i2) {
            return new a(4, 1, iArr, i2, -1, -1, -1);
        }

        public static a c(int i2) {
            return new a(4, 2, null, -1, -1, -1, i2);
        }

        public static a d(int i2, int[] iArr, int i3, int i4, int i5) {
            return new a(i2, 0, iArr, i3, i4, i5, -1);
        }
    }

    public d(int i2, b bVar, int i3, c.a aVar, x xVar, com.google.android.exoplayer2.upstream.t tVar, v.a aVar2, long j2, u uVar, com.google.android.exoplayer2.upstream.d dVar, o oVar, j.b bVar2) {
        this.f6148b = i2;
        this.s = bVar;
        this.t = i3;
        this.f6149c = aVar;
        this.f6150d = xVar;
        this.f6151e = tVar;
        this.n = aVar2;
        this.f6152f = j2;
        this.f6153g = uVar;
        this.f6154h = dVar;
        this.f6157k = oVar;
        this.l = new j(bVar, bVar2, dVar);
        this.r = oVar.a(this.p);
        f d2 = bVar.d(i3);
        List<e> list = d2.f6277d;
        this.u = list;
        Pair<c0, a[]> u2 = u(d2.f6276c, list);
        this.f6155i = (c0) u2.first;
        this.f6156j = (a[]) u2.second;
        aVar2.I();
    }

    private static boolean A(List<com.google.android.exoplayer2.source.dash.k.a> list, int[] iArr) {
        for (int i2 : iArr) {
            List<i> list2 = list.get(i2).f6240c;
            for (int i3 = 0; i3 < list2.size(); i3++) {
                if (!list2.get(i3).f6290d.isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    private static int B(int i2, List<com.google.android.exoplayer2.source.dash.k.a> list, int[][] iArr, boolean[] zArr, boolean[] zArr2) {
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            if (A(list, iArr[i4])) {
                zArr[i4] = true;
                i3++;
            }
            if (z(list, iArr[i4])) {
                zArr2[i4] = true;
                i3++;
            }
        }
        return i3;
    }

    private static g<c>[] C(int i2) {
        return new g[i2];
    }

    private void F(com.google.android.exoplayer2.g0.g[] gVarArr, boolean[] zArr, y[] yVarArr) {
        for (int i2 = 0; i2 < gVarArr.length; i2++) {
            if (gVarArr[i2] == null || !zArr[i2]) {
                if (yVarArr[i2] instanceof g) {
                    ((g) yVarArr[i2]).N(this);
                } else if (yVarArr[i2] instanceof g.a) {
                    ((g.a) yVarArr[i2]).c();
                }
                yVarArr[i2] = null;
            }
        }
    }

    private void G(com.google.android.exoplayer2.g0.g[] gVarArr, y[] yVarArr, int[] iArr) {
        boolean z;
        for (int i2 = 0; i2 < gVarArr.length; i2++) {
            if ((yVarArr[i2] instanceof q) || (yVarArr[i2] instanceof g.a)) {
                int x = x(i2, iArr);
                if (x == -1) {
                    z = yVarArr[i2] instanceof q;
                } else {
                    z = (yVarArr[i2] instanceof g.a) && ((g.a) yVarArr[i2]).f6134b == yVarArr[x];
                }
                if (!z) {
                    if (yVarArr[i2] instanceof g.a) {
                        ((g.a) yVarArr[i2]).c();
                    }
                    yVarArr[i2] = null;
                }
            }
        }
    }

    private void H(com.google.android.exoplayer2.g0.g[] gVarArr, y[] yVarArr, boolean[] zArr, long j2, int[] iArr) {
        for (int i2 = 0; i2 < gVarArr.length; i2++) {
            if (yVarArr[i2] == null && gVarArr[i2] != null) {
                zArr[i2] = true;
                a aVar = this.f6156j[iArr[i2]];
                int i3 = aVar.f6160c;
                if (i3 == 0) {
                    yVarArr[i2] = q(aVar, gVarArr[i2], j2);
                } else if (i3 == 2) {
                    yVarArr[i2] = new i(this.u.get(aVar.f6161d), gVarArr[i2].j().g(0), this.s.f6246d);
                }
            }
        }
        for (int i4 = 0; i4 < gVarArr.length; i4++) {
            if (yVarArr[i4] == null && gVarArr[i4] != null) {
                a aVar2 = this.f6156j[iArr[i4]];
                if (aVar2.f6160c == 1) {
                    int x = x(i4, iArr);
                    if (x == -1) {
                        yVarArr[i4] = new q();
                    } else {
                        yVarArr[i4] = ((g) yVarArr[x]).P(j2, aVar2.f6159b);
                    }
                }
            }
        }
    }

    private static void h(List<e> list, b0[] b0VarArr, a[] aVarArr, int i2) {
        int i3 = 0;
        while (i3 < list.size()) {
            b0VarArr[i2] = new b0(l.x(list.get(i3).a(), "application/x-emsg", null, -1, null));
            aVarArr[i2] = a.c(i3);
            i3++;
            i2++;
        }
    }

    private static int p(List<com.google.android.exoplayer2.source.dash.k.a> list, int[][] iArr, int i2, boolean[] zArr, boolean[] zArr2, b0[] b0VarArr, a[] aVarArr) {
        int i3;
        int i4;
        int i5 = 0;
        int i6 = 0;
        while (i5 < i2) {
            int[] iArr2 = iArr[i5];
            ArrayList arrayList = new ArrayList();
            for (int i7 : iArr2) {
                arrayList.addAll(list.get(i7).f6240c);
            }
            int size = arrayList.size();
            l[] lVarArr = new l[size];
            for (int i8 = 0; i8 < size; i8++) {
                lVarArr[i8] = ((i) arrayList.get(i8)).f6287a;
            }
            com.google.android.exoplayer2.source.dash.k.a aVar = list.get(iArr2[0]);
            int i9 = i6 + 1;
            if (zArr[i5]) {
                i3 = i9 + 1;
            } else {
                i3 = i9;
                i9 = -1;
            }
            if (zArr2[i5]) {
                i4 = i3 + 1;
            } else {
                i4 = i3;
                i3 = -1;
            }
            b0VarArr[i6] = new b0(lVarArr);
            aVarArr[i6] = a.d(aVar.f6239b, iArr2, i6, i9, i3);
            if (i9 != -1) {
                b0VarArr[i9] = new b0(l.x(aVar.f6238a + ":emsg", "application/x-emsg", null, -1, null));
                aVarArr[i9] = a.b(iArr2, i6);
            }
            if (i3 != -1) {
                b0VarArr[i3] = new b0(l.A(aVar.f6238a + ":cea608", "application/cea-608", 0, null));
                aVarArr[i3] = a.a(iArr2, i6);
            }
            i5++;
            i6 = i4;
        }
        return i6;
    }

    private g<c> q(a aVar, com.google.android.exoplayer2.g0.g gVar, long j2) {
        int i2;
        l[] lVarArr;
        int[] iArr = new int[2];
        l[] lVarArr2 = new l[2];
        int i3 = aVar.f6163f;
        boolean z = i3 != -1;
        if (z) {
            lVarArr2[0] = this.f6155i.g(i3).g(0);
            iArr[0] = 4;
            i2 = 1;
        } else {
            i2 = 0;
        }
        int i4 = aVar.f6164g;
        boolean z2 = i4 != -1;
        if (z2) {
            lVarArr2[i2] = this.f6155i.g(i4).g(0);
            iArr[i2] = 3;
            i2++;
        }
        if (i2 < 2) {
            iArr = Arrays.copyOf(iArr, i2);
            lVarArr = (l[]) Arrays.copyOf(lVarArr2, i2);
        } else {
            lVarArr = lVarArr2;
        }
        j.c n2 = (!this.s.f6246d || !z) ? null : this.l.n();
        g<c> gVar2 = new g<>(aVar.f6159b, iArr, lVarArr, this.f6149c.a(this.f6153g, this.s, this.t, aVar.f6158a, gVar, aVar.f6159b, this.f6152f, z, z2, n2, this.f6150d), this, this.f6154h, j2, this.f6151e, this.n);
        synchronized (this) {
            this.m.put(gVar2, n2);
        }
        return gVar2;
    }

    private static Pair<c0, a[]> u(List<com.google.android.exoplayer2.source.dash.k.a> list, List<e> list2) {
        int[][] w = w(list);
        int length = w.length;
        boolean[] zArr = new boolean[length];
        boolean[] zArr2 = new boolean[length];
        int B = B(length, list, w, zArr, zArr2) + length + list2.size();
        b0[] b0VarArr = new b0[B];
        a[] aVarArr = new a[B];
        h(list2, b0VarArr, aVarArr, p(list, w, length, zArr, zArr2, b0VarArr, aVarArr));
        return Pair.create(new c0(b0VarArr), aVarArr);
    }

    private static com.google.android.exoplayer2.source.dash.k.d v(List<com.google.android.exoplayer2.source.dash.k.d> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            com.google.android.exoplayer2.source.dash.k.d dVar = list.get(i2);
            if ("urn:mpeg:dash:adaptation-set-switching:2016".equals(dVar.f6266a)) {
                return dVar;
            }
        }
        return null;
    }

    private static int[][] w(List<com.google.android.exoplayer2.source.dash.k.a> list) {
        int size = list.size();
        SparseIntArray sparseIntArray = new SparseIntArray(size);
        for (int i2 = 0; i2 < size; i2++) {
            sparseIntArray.put(list.get(i2).f6238a, i2);
        }
        int[][] iArr = new int[size][];
        boolean[] zArr = new boolean[size];
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            if (!zArr[i4]) {
                zArr[i4] = true;
                com.google.android.exoplayer2.source.dash.k.d v2 = v(list.get(i4).f6242e);
                if (v2 == null) {
                    iArr[i3] = new int[]{i4};
                    i3++;
                } else {
                    String[] split = v2.f6267b.split(",");
                    int[] iArr2 = new int[(split.length + 1)];
                    iArr2[0] = i4;
                    int i5 = 0;
                    while (i5 < split.length) {
                        int i6 = sparseIntArray.get(Integer.parseInt(split[i5]));
                        zArr[i6] = true;
                        i5++;
                        iArr2[i5] = i6;
                    }
                    iArr[i3] = iArr2;
                    i3++;
                }
            }
        }
        return i3 < size ? (int[][]) Arrays.copyOf(iArr, i3) : iArr;
    }

    private int x(int i2, int[] iArr) {
        int i3 = iArr[i2];
        if (i3 == -1) {
            return -1;
        }
        int i4 = this.f6156j[i3].f6162e;
        for (int i5 = 0; i5 < iArr.length; i5++) {
            int i6 = iArr[i5];
            if (i6 == i4 && this.f6156j[i6].f6160c == 0) {
                return i5;
            }
        }
        return -1;
    }

    private int[] y(com.google.android.exoplayer2.g0.g[] gVarArr) {
        int[] iArr = new int[gVarArr.length];
        for (int i2 = 0; i2 < gVarArr.length; i2++) {
            if (gVarArr[i2] != null) {
                iArr[i2] = this.f6155i.k(gVarArr[i2].j());
            } else {
                iArr[i2] = -1;
            }
        }
        return iArr;
    }

    private static boolean z(List<com.google.android.exoplayer2.source.dash.k.a> list, int[] iArr) {
        for (int i2 : iArr) {
            List<com.google.android.exoplayer2.source.dash.k.d> list2 = list.get(i2).f6241d;
            for (int i3 = 0; i3 < list2.size(); i3++) {
                if ("urn:scte:dash:cc:cea-608:2015".equals(list2.get(i3).f6266a)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: D */
    public void n(g<c> gVar) {
        this.o.n(this);
    }

    public void E() {
        this.l.r();
        for (g<c> gVar : this.p) {
            gVar.N(this);
        }
        this.o = null;
        this.n.J();
    }

    public void I(b bVar, int i2) {
        this.s = bVar;
        this.t = i2;
        this.l.t(bVar);
        g<c>[] gVarArr = this.p;
        if (gVarArr != null) {
            for (g<c> gVar : gVarArr) {
                gVar.B().c(bVar, i2);
            }
            this.o.n(this);
        }
        this.u = bVar.d(i2).f6277d;
        i[] iVarArr = this.q;
        for (i iVar : iVarArr) {
            Iterator<e> it = this.u.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                e next = it.next();
                if (next.a().equals(iVar.b())) {
                    boolean z = true;
                    int e2 = bVar.e() - 1;
                    if (!bVar.f6246d || i2 != e2) {
                        z = false;
                    }
                    iVar.d(next, z);
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.t
    public long b(long j2, a0 a0Var) {
        g<c>[] gVarArr = this.p;
        for (g<c> gVar : gVarArr) {
            if (gVar.f6124b == 2) {
                return gVar.b(j2, a0Var);
            }
        }
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

    @Override // com.google.android.exoplayer2.source.d0.g.b
    public synchronized void e(g<c> gVar) {
        j.c remove = this.m.remove(gVar);
        if (remove != null) {
            remove.m();
        }
    }

    @Override // com.google.android.exoplayer2.source.t, com.google.android.exoplayer2.source.z
    public boolean f(long j2) {
        return this.r.f(j2);
    }

    @Override // com.google.android.exoplayer2.source.t, com.google.android.exoplayer2.source.z
    public void g(long j2) {
        this.r.g(j2);
    }

    @Override // com.google.android.exoplayer2.source.t
    public long j(com.google.android.exoplayer2.g0.g[] gVarArr, boolean[] zArr, y[] yVarArr, boolean[] zArr2, long j2) {
        int[] y = y(gVarArr);
        F(gVarArr, zArr, yVarArr);
        G(gVarArr, yVarArr, y);
        H(gVarArr, yVarArr, zArr2, j2, y);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (y yVar : yVarArr) {
            if (yVar instanceof g) {
                arrayList.add((g) yVar);
            } else if (yVar instanceof i) {
                arrayList2.add((i) yVar);
            }
        }
        g<c>[] C = C(arrayList.size());
        this.p = C;
        arrayList.toArray(C);
        i[] iVarArr = new i[arrayList2.size()];
        this.q = iVarArr;
        arrayList2.toArray(iVarArr);
        this.r = this.f6157k.a(this.p);
        return j2;
    }

    @Override // com.google.android.exoplayer2.source.t
    public long l() {
        if (this.v) {
            return -9223372036854775807L;
        }
        this.n.L();
        this.v = true;
        return -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.source.t
    public void m(t.a aVar, long j2) {
        this.o = aVar;
        aVar.k(this);
    }

    @Override // com.google.android.exoplayer2.source.t
    public c0 o() {
        return this.f6155i;
    }

    @Override // com.google.android.exoplayer2.source.t
    public void r() {
        this.f6153g.a();
    }

    @Override // com.google.android.exoplayer2.source.t
    public void s(long j2, boolean z) {
        for (g<c> gVar : this.p) {
            gVar.s(j2, z);
        }
    }

    @Override // com.google.android.exoplayer2.source.t
    public long t(long j2) {
        for (g<c> gVar : this.p) {
            gVar.O(j2);
        }
        for (i iVar : this.q) {
            iVar.c(j2);
        }
        return j2;
    }
}
