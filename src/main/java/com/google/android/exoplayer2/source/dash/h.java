package com.google.android.exoplayer2.source.dash;

import android.os.SystemClock;
import com.google.android.exoplayer2.a0;
import com.google.android.exoplayer2.e0.o;
import com.google.android.exoplayer2.e0.q;
import com.google.android.exoplayer2.g0.g;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.d0.d;
import com.google.android.exoplayer2.source.d0.e;
import com.google.android.exoplayer2.source.d0.f;
import com.google.android.exoplayer2.source.d0.k;
import com.google.android.exoplayer2.source.d0.l;
import com.google.android.exoplayer2.source.d0.m;
import com.google.android.exoplayer2.source.d0.n;
import com.google.android.exoplayer2.source.dash.c;
import com.google.android.exoplayer2.source.dash.j;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.i;
import com.google.android.exoplayer2.upstream.u;
import com.google.android.exoplayer2.upstream.x;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.p;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: DefaultDashChunkSource */
public class h implements c {

    /* renamed from: a  reason: collision with root package name */
    private final u f6196a;

    /* renamed from: b  reason: collision with root package name */
    private final int[] f6197b;

    /* renamed from: c  reason: collision with root package name */
    private final g f6198c;

    /* renamed from: d  reason: collision with root package name */
    private final int f6199d;

    /* renamed from: e  reason: collision with root package name */
    private final i f6200e;

    /* renamed from: f  reason: collision with root package name */
    private final long f6201f;

    /* renamed from: g  reason: collision with root package name */
    private final int f6202g;

    /* renamed from: h  reason: collision with root package name */
    private final j.c f6203h;

    /* renamed from: i  reason: collision with root package name */
    protected final b[] f6204i;

    /* renamed from: j  reason: collision with root package name */
    private com.google.android.exoplayer2.source.dash.k.b f6205j;

    /* renamed from: k  reason: collision with root package name */
    private int f6206k;
    private IOException l;
    private boolean m;
    private long n = -9223372036854775807L;

    /* compiled from: DefaultDashChunkSource */
    public static final class a implements c.a {

        /* renamed from: a  reason: collision with root package name */
        private final i.a f6207a;

        /* renamed from: b  reason: collision with root package name */
        private final int f6208b;

        public a(i.a aVar) {
            this(aVar, 1);
        }

        @Override // com.google.android.exoplayer2.source.dash.c.a
        public c a(u uVar, com.google.android.exoplayer2.source.dash.k.b bVar, int i2, int[] iArr, g gVar, int i3, long j2, boolean z, boolean z2, j.c cVar, x xVar) {
            i a2 = this.f6207a.a();
            if (xVar != null) {
                a2.d(xVar);
            }
            return new h(uVar, bVar, i2, iArr, gVar, i3, a2, j2, this.f6208b, z, z2, cVar);
        }

        public a(i.a aVar, int i2) {
            this.f6207a = aVar;
            this.f6208b = i2;
        }
    }

    /* compiled from: DefaultDashChunkSource */
    protected static final class c extends com.google.android.exoplayer2.source.d0.b {
        public c(b bVar, long j2, long j3) {
            super(j2, j3);
        }
    }

    public h(u uVar, com.google.android.exoplayer2.source.dash.k.b bVar, int i2, int[] iArr, g gVar, int i3, i iVar, long j2, int i4, boolean z, boolean z2, j.c cVar) {
        this.f6196a = uVar;
        this.f6205j = bVar;
        this.f6197b = iArr;
        this.f6198c = gVar;
        this.f6199d = i3;
        this.f6200e = iVar;
        this.f6206k = i2;
        this.f6201f = j2;
        this.f6202g = i4;
        this.f6203h = cVar;
        long g2 = bVar.g(i2);
        ArrayList<com.google.android.exoplayer2.source.dash.k.i> j3 = j();
        this.f6204i = new b[gVar.length()];
        for (int i5 = 0; i5 < this.f6204i.length; i5++) {
            this.f6204i[i5] = new b(g2, i3, j3.get(gVar.e(i5)), z, z2, cVar);
        }
    }

    private long i() {
        long currentTimeMillis;
        if (this.f6201f != 0) {
            currentTimeMillis = SystemClock.elapsedRealtime() + this.f6201f;
        } else {
            currentTimeMillis = System.currentTimeMillis();
        }
        return currentTimeMillis * 1000;
    }

    private ArrayList<com.google.android.exoplayer2.source.dash.k.i> j() {
        List<com.google.android.exoplayer2.source.dash.k.a> list = this.f6205j.d(this.f6206k).f6276c;
        ArrayList<com.google.android.exoplayer2.source.dash.k.i> arrayList = new ArrayList<>();
        for (int i2 : this.f6197b) {
            arrayList.addAll(list.get(i2).f6240c);
        }
        return arrayList;
    }

    private long k(b bVar, l lVar, long j2, long j3, long j4) {
        if (lVar != null) {
            return lVar.g();
        }
        return d0.o(bVar.j(j2), j3, j4);
    }

    private long n(long j2) {
        if (this.f6205j.f6246d && this.n != -9223372036854775807L) {
            return this.n - j2;
        }
        return -9223372036854775807L;
    }

    private void o(b bVar, long j2) {
        this.n = this.f6205j.f6246d ? bVar.i(j2) : -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.source.d0.h
    public void a() {
        IOException iOException = this.l;
        if (iOException == null) {
            this.f6196a.a();
            return;
        }
        throw iOException;
    }

    @Override // com.google.android.exoplayer2.source.d0.h
    public long b(long j2, a0 a0Var) {
        b[] bVarArr = this.f6204i;
        for (b bVar : bVarArr) {
            if (bVar.f6211c != null) {
                long j3 = bVar.j(j2);
                long k2 = bVar.k(j3);
                return d0.Y(j2, a0Var, k2, (k2 >= j2 || j3 >= ((long) (bVar.h() + -1))) ? k2 : bVar.k(j3 + 1));
            }
        }
        return j2;
    }

    @Override // com.google.android.exoplayer2.source.dash.c
    public void c(com.google.android.exoplayer2.source.dash.k.b bVar, int i2) {
        try {
            this.f6205j = bVar;
            this.f6206k = i2;
            long g2 = bVar.g(i2);
            ArrayList<com.google.android.exoplayer2.source.dash.k.i> j2 = j();
            for (int i3 = 0; i3 < this.f6204i.length; i3++) {
                b[] bVarArr = this.f6204i;
                bVarArr[i3] = bVarArr[i3].b(g2, j2.get(this.f6198c.e(i3)));
            }
        } catch (BehindLiveWindowException e2) {
            this.l = e2;
        }
    }

    @Override // com.google.android.exoplayer2.source.d0.h
    public int d(long j2, List<? extends l> list) {
        if (this.l != null || this.f6198c.length() < 2) {
            return list.size();
        }
        return this.f6198c.f(j2, list);
    }

    @Override // com.google.android.exoplayer2.source.d0.h
    public void e(d dVar) {
        o c2;
        if (dVar instanceof k) {
            int g2 = this.f6198c.g(((k) dVar).f6100c);
            b bVar = this.f6204i[g2];
            if (bVar.f6211c == null && (c2 = bVar.f6209a.c()) != null) {
                this.f6204i[g2] = bVar.c(new g((com.google.android.exoplayer2.e0.b) c2, bVar.f6210b.f6289c));
            }
        }
        j.c cVar = this.f6203h;
        if (cVar != null) {
            cVar.h(dVar);
        }
    }

    @Override // com.google.android.exoplayer2.source.d0.h
    public void g(long j2, long j3, List<? extends l> list, f fVar) {
        long j4;
        m[] mVarArr;
        int i2;
        int i3;
        if (this.l == null) {
            long j5 = j3 - j2;
            long n2 = n(j2);
            long a2 = com.google.android.exoplayer2.d.a(this.f6205j.f6243a) + com.google.android.exoplayer2.d.a(this.f6205j.d(this.f6206k).f6275b) + j3;
            j.c cVar = this.f6203h;
            if (cVar == null || !cVar.f(a2)) {
                long i4 = i();
                l lVar = list.isEmpty() ? null : (l) list.get(list.size() - 1);
                int length = this.f6198c.length();
                m[] mVarArr2 = new m[length];
                int i5 = 0;
                while (i5 < length) {
                    b bVar = this.f6204i[i5];
                    if (bVar.f6211c == null) {
                        mVarArr2[i5] = m.f6145a;
                        i3 = i5;
                        i2 = length;
                        mVarArr = mVarArr2;
                        j4 = i4;
                    } else {
                        long e2 = bVar.e(this.f6205j, this.f6206k, i4);
                        long g2 = bVar.g(this.f6205j, this.f6206k, i4);
                        i3 = i5;
                        i2 = length;
                        mVarArr = mVarArr2;
                        j4 = i4;
                        long k2 = k(bVar, lVar, j3, e2, g2);
                        if (k2 < e2) {
                            mVarArr[i3] = m.f6145a;
                        } else {
                            mVarArr[i3] = new c(bVar, k2, g2);
                        }
                    }
                    i5 = i3 + 1;
                    length = i2;
                    mVarArr2 = mVarArr;
                    i4 = j4;
                }
                this.f6198c.h(j2, j5, n2, list, mVarArr2);
                b bVar2 = this.f6204i[this.f6198c.m()];
                e eVar = bVar2.f6209a;
                if (eVar != null) {
                    com.google.android.exoplayer2.source.dash.k.i iVar = bVar2.f6210b;
                    com.google.android.exoplayer2.source.dash.k.h k3 = eVar.b() == null ? iVar.k() : null;
                    com.google.android.exoplayer2.source.dash.k.h j6 = bVar2.f6211c == null ? iVar.j() : null;
                    if (!(k3 == null && j6 == null)) {
                        fVar.f6122a = l(bVar2, this.f6200e, this.f6198c.k(), this.f6198c.l(), this.f6198c.p(), k3, j6);
                        return;
                    }
                }
                if (bVar2.h() == 0) {
                    com.google.android.exoplayer2.source.dash.k.b bVar3 = this.f6205j;
                    fVar.f6123b = !bVar3.f6246d || this.f6206k < bVar3.e() - 1;
                    return;
                }
                long e3 = bVar2.e(this.f6205j, this.f6206k, i4);
                long g3 = bVar2.g(this.f6205j, this.f6206k, i4);
                o(bVar2, g3);
                long k4 = k(bVar2, lVar, j3, e3, g3);
                if (k4 < e3) {
                    this.l = new BehindLiveWindowException();
                } else if (k4 > g3 || (this.m && k4 >= g3)) {
                    com.google.android.exoplayer2.source.dash.k.b bVar4 = this.f6205j;
                    fVar.f6123b = !bVar4.f6246d || this.f6206k < bVar4.e() - 1;
                } else {
                    long j7 = bVar2.f6212d;
                    if (j7 == -9223372036854775807L || bVar2.k(k4) < j7) {
                        int min = (int) Math.min((long) this.f6202g, (g3 - k4) + 1);
                        if (j7 != -9223372036854775807L) {
                            while (min > 1 && bVar2.k((((long) min) + k4) - 1) >= j7) {
                                min--;
                            }
                        }
                        fVar.f6122a = m(bVar2, this.f6200e, this.f6199d, this.f6198c.k(), this.f6198c.l(), this.f6198c.p(), k4, min, list.isEmpty() ? j3 : -9223372036854775807L);
                        return;
                    }
                    fVar.f6123b = true;
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.d0.h
    public boolean h(d dVar, boolean z, Exception exc, long j2) {
        b bVar;
        int h2;
        if (!z) {
            return false;
        }
        j.c cVar = this.f6203h;
        if (cVar != null && cVar.g(dVar)) {
            return true;
        }
        if (!this.f6205j.f6246d && (dVar instanceof l) && (exc instanceof HttpDataSource.InvalidResponseCodeException) && ((HttpDataSource.InvalidResponseCodeException) exc).f6874b == 404 && (h2 = (bVar = this.f6204i[this.f6198c.g(dVar.f6100c)]).h()) != -1 && h2 != 0) {
            if (((l) dVar).g() > (bVar.f() + ((long) h2)) - 1) {
                this.m = true;
                return true;
            }
        }
        if (j2 == -9223372036854775807L) {
            return false;
        }
        g gVar = this.f6198c;
        if (gVar.a(gVar.g(dVar.f6100c), j2)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public d l(b bVar, i iVar, com.google.android.exoplayer2.l lVar, int i2, Object obj, com.google.android.exoplayer2.source.dash.k.h hVar, com.google.android.exoplayer2.source.dash.k.h hVar2) {
        String str = bVar.f6210b.f6288b;
        if (hVar == null || (hVar2 = hVar.a(hVar2, str)) != null) {
            hVar = hVar2;
        }
        return new k(iVar, new com.google.android.exoplayer2.upstream.k(hVar.b(str), hVar.f6283a, hVar.f6284b, bVar.f6210b.h()), lVar, i2, obj, bVar.f6209a);
    }

    /* access modifiers changed from: protected */
    public d m(b bVar, i iVar, int i2, com.google.android.exoplayer2.l lVar, int i3, Object obj, long j2, int i4, long j3) {
        com.google.android.exoplayer2.source.dash.k.i iVar2 = bVar.f6210b;
        long k2 = bVar.k(j2);
        com.google.android.exoplayer2.source.dash.k.h l2 = bVar.l(j2);
        String str = iVar2.f6288b;
        if (bVar.f6209a == null) {
            return new n(iVar, new com.google.android.exoplayer2.upstream.k(l2.b(str), l2.f6283a, l2.f6284b, iVar2.h()), lVar, i3, obj, k2, bVar.i(j2), j2, i2, lVar);
        }
        int i5 = 1;
        int i6 = 1;
        while (i5 < i4) {
            com.google.android.exoplayer2.source.dash.k.h a2 = l2.a(bVar.l(((long) i5) + j2), str);
            if (a2 == null) {
                break;
            }
            i6++;
            i5++;
            l2 = a2;
        }
        long i7 = bVar.i((((long) i6) + j2) - 1);
        long j4 = bVar.f6212d;
        return new com.google.android.exoplayer2.source.d0.i(iVar, new com.google.android.exoplayer2.upstream.k(l2.b(str), l2.f6283a, l2.f6284b, iVar2.h()), lVar, i3, obj, k2, i7, j3, (j4 == -9223372036854775807L || j4 > i7) ? -9223372036854775807L : j4, j2, i6, -iVar2.f6289c, bVar.f6209a);
    }

    /* access modifiers changed from: protected */
    /* compiled from: DefaultDashChunkSource */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        final e f6209a;

        /* renamed from: b  reason: collision with root package name */
        public final com.google.android.exoplayer2.source.dash.k.i f6210b;

        /* renamed from: c  reason: collision with root package name */
        public final f f6211c;

        /* renamed from: d  reason: collision with root package name */
        private final long f6212d;

        /* renamed from: e  reason: collision with root package name */
        private final long f6213e;

        b(long j2, int i2, com.google.android.exoplayer2.source.dash.k.i iVar, boolean z, boolean z2, q qVar) {
            this(j2, iVar, d(i2, iVar, z, z2, qVar), 0, iVar.i());
        }

        private static e d(int i2, com.google.android.exoplayer2.source.dash.k.i iVar, boolean z, boolean z2, q qVar) {
            com.google.android.exoplayer2.e0.g gVar;
            List list;
            String str = iVar.f6287a.f5976g;
            if (m(str)) {
                return null;
            }
            if ("application/x-rawcc".equals(str)) {
                gVar = new com.google.android.exoplayer2.e0.w.a(iVar.f6287a);
            } else if (n(str)) {
                gVar = new com.google.android.exoplayer2.e0.s.e(1);
            } else {
                int i3 = z ? 4 : 0;
                if (z2) {
                    list = Collections.singletonList(com.google.android.exoplayer2.l.A(null, "application/cea-608", 0, null));
                } else {
                    list = Collections.emptyList();
                }
                gVar = new com.google.android.exoplayer2.e0.u.g(i3, null, null, null, list, qVar);
            }
            return new e(gVar, i2, iVar.f6287a);
        }

        private static boolean m(String str) {
            return p.l(str) || "application/ttml+xml".equals(str);
        }

        private static boolean n(String str) {
            return str.startsWith("video/webm") || str.startsWith("audio/webm") || str.startsWith("application/webm");
        }

        /* access modifiers changed from: package-private */
        public b b(long j2, com.google.android.exoplayer2.source.dash.k.i iVar) {
            long a2;
            f i2 = this.f6210b.i();
            f i3 = iVar.i();
            if (i2 == null) {
                return new b(j2, iVar, this.f6209a, this.f6213e, i2);
            }
            if (!i2.e()) {
                return new b(j2, iVar, this.f6209a, this.f6213e, i3);
            }
            int g2 = i2.g(j2);
            if (g2 == 0) {
                return new b(j2, iVar, this.f6209a, this.f6213e, i3);
            }
            long f2 = (i2.f() + ((long) g2)) - 1;
            long b2 = i2.b(f2) + i2.c(f2, j2);
            long f3 = i3.f();
            long b3 = i3.b(f3);
            long j3 = this.f6213e;
            if (b2 == b3) {
                a2 = f2 + 1;
            } else if (b2 >= b3) {
                a2 = i2.a(b3, j2);
            } else {
                throw new BehindLiveWindowException();
            }
            return new b(j2, iVar, this.f6209a, j3 + (a2 - f3), i3);
        }

        /* access modifiers changed from: package-private */
        public b c(f fVar) {
            return new b(this.f6212d, this.f6210b, this.f6209a, this.f6213e, fVar);
        }

        public long e(com.google.android.exoplayer2.source.dash.k.b bVar, int i2, long j2) {
            if (h() != -1 || bVar.f6248f == -9223372036854775807L) {
                return f();
            }
            return Math.max(f(), j(((j2 - com.google.android.exoplayer2.d.a(bVar.f6243a)) - com.google.android.exoplayer2.d.a(bVar.d(i2).f6275b)) - com.google.android.exoplayer2.d.a(bVar.f6248f)));
        }

        public long f() {
            return this.f6211c.f() + this.f6213e;
        }

        public long g(com.google.android.exoplayer2.source.dash.k.b bVar, int i2, long j2) {
            long f2;
            int h2 = h();
            if (h2 == -1) {
                f2 = j((j2 - com.google.android.exoplayer2.d.a(bVar.f6243a)) - com.google.android.exoplayer2.d.a(bVar.d(i2).f6275b));
            } else {
                f2 = f() + ((long) h2);
            }
            return f2 - 1;
        }

        public int h() {
            return this.f6211c.g(this.f6212d);
        }

        public long i(long j2) {
            return k(j2) + this.f6211c.c(j2 - this.f6213e, this.f6212d);
        }

        public long j(long j2) {
            return this.f6211c.a(j2, this.f6212d) + this.f6213e;
        }

        public long k(long j2) {
            return this.f6211c.b(j2 - this.f6213e);
        }

        public com.google.android.exoplayer2.source.dash.k.h l(long j2) {
            return this.f6211c.d(j2 - this.f6213e);
        }

        private b(long j2, com.google.android.exoplayer2.source.dash.k.i iVar, e eVar, long j3, f fVar) {
            this.f6212d = j2;
            this.f6210b = iVar;
            this.f6213e = j3;
            this.f6209a = eVar;
            this.f6211c = fVar;
        }
    }
}
