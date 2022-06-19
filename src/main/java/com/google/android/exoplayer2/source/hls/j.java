package com.google.android.exoplayer2.source.hls;

import android.util.Pair;
import com.google.android.exoplayer2.e0.g;
import com.google.android.exoplayer2.f0.a;
import com.google.android.exoplayer2.f0.h.h;
import com.google.android.exoplayer2.source.d0.l;
import com.google.android.exoplayer2.source.hls.playlist.d;
import com.google.android.exoplayer2.upstream.i;
import com.google.android.exoplayer2.upstream.k;
import com.google.android.exoplayer2.util.a0;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.s;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* access modifiers changed from: package-private */
/* compiled from: HlsMediaChunk */
public final class j extends l {
    private static final AtomicInteger G = new AtomicInteger();
    private n A;
    private int B;
    private int C;
    private boolean D;
    private volatile boolean E;
    private boolean F;

    /* renamed from: j  reason: collision with root package name */
    public final int f6389j;

    /* renamed from: k  reason: collision with root package name */
    public final int f6390k;
    public final d.a l;
    private final i m;
    private final k n;
    private final boolean o;
    private final boolean p;
    private final boolean q;
    private final a0 r;
    private final boolean s;
    private final h t;
    private final List<com.google.android.exoplayer2.l> u;
    private final com.google.android.exoplayer2.drm.l v;
    private final g w;
    private final h x;
    private final s y;
    private g z;

    public j(h hVar, i iVar, k kVar, k kVar2, d.a aVar, List<com.google.android.exoplayer2.l> list, int i2, Object obj, long j2, long j3, long j4, int i3, boolean z2, boolean z3, a0 a0Var, j jVar, com.google.android.exoplayer2.drm.l lVar, byte[] bArr, byte[] bArr2) {
        super(i(iVar, bArr, bArr2), kVar, aVar.f6466b, i2, obj, j2, j3, j4);
        this.f6390k = i3;
        this.n = kVar2;
        this.l = aVar;
        this.p = z3;
        this.r = a0Var;
        boolean z4 = true;
        this.o = bArr != null;
        this.q = z2;
        this.t = hVar;
        this.u = list;
        this.v = lVar;
        g gVar = null;
        if (jVar != null) {
            this.x = jVar.x;
            this.y = jVar.y;
            if (jVar.l == aVar && jVar.F) {
                z4 = false;
            }
            this.s = z4;
            if (jVar.f6390k == i3 && !z4) {
                gVar = jVar.z;
            }
        } else {
            this.x = new h();
            this.y = new s(10);
            this.s = false;
        }
        this.w = gVar;
        this.m = iVar;
        this.f6389j = G.getAndIncrement();
    }

    private static i i(i iVar, byte[] bArr, byte[] bArr2) {
        return bArr != null ? new c(iVar, bArr, bArr2) : iVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0021  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x003f A[Catch:{ all -> 0x0072 }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0046 A[SYNTHETIC, Splitter:B:18:0x0046] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void k() {
        /*
        // Method dump skipped, instructions count: 123
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.hls.j.k():void");
    }

    /* JADX INFO: finally extract failed */
    private void l() {
        k kVar;
        if (!this.D && (kVar = this.n) != null) {
            try {
                com.google.android.exoplayer2.e0.d n2 = n(this.m, kVar.d((long) this.B));
                int i2 = 0;
                while (i2 == 0) {
                    try {
                        if (this.E) {
                            break;
                        }
                        i2 = this.z.i(n2, null);
                    } catch (Throwable th) {
                        this.B = (int) (n2.l() - this.n.f6925d);
                        throw th;
                    }
                }
                this.B = (int) (n2.l() - this.n.f6925d);
                d0.j(this.m);
                this.D = true;
            } catch (Throwable th2) {
                d0.j(this.m);
                throw th2;
            }
        }
    }

    private long m(com.google.android.exoplayer2.e0.h hVar) {
        a c2;
        hVar.e();
        if (hVar.d() >= 10 && hVar.h(this.y.f7062a, 0, 10, true)) {
            this.y.H(10);
            if (this.y.B() != h.f5742b) {
                return -9223372036854775807L;
            }
            this.y.L(3);
            int x2 = this.y.x();
            int i2 = x2 + 10;
            if (i2 > this.y.b()) {
                s sVar = this.y;
                byte[] bArr = sVar.f7062a;
                sVar.H(i2);
                System.arraycopy(bArr, 0, this.y.f7062a, 0, 10);
            }
            if (!hVar.h(this.y.f7062a, 10, x2, true) || (c2 = this.x.c(this.y.f7062a, x2)) == null) {
                return -9223372036854775807L;
            }
            int k2 = c2.k();
            for (int i3 = 0; i3 < k2; i3++) {
                a.b g2 = c2.g(i3);
                if (g2 instanceof com.google.android.exoplayer2.f0.h.l) {
                    com.google.android.exoplayer2.f0.h.l lVar = (com.google.android.exoplayer2.f0.h.l) g2;
                    if ("com.apple.streaming.transportStreamTimestamp".equals(lVar.f5756c)) {
                        System.arraycopy(lVar.f5757d, 0, this.y.f7062a, 0, 8);
                        this.y.H(8);
                        return this.y.r() & 8589934591L;
                    }
                }
            }
        }
        return -9223372036854775807L;
    }

    private com.google.android.exoplayer2.e0.d n(i iVar, k kVar) {
        com.google.android.exoplayer2.e0.d dVar = new com.google.android.exoplayer2.e0.d(iVar, kVar.f6925d, iVar.b(kVar));
        if (this.z != null) {
            return dVar;
        }
        long m2 = m(dVar);
        dVar.e();
        Pair<g, Boolean> a2 = this.t.a(this.w, kVar.f6922a, this.f6100c, this.u, this.v, this.r, iVar.c(), dVar);
        g gVar = (g) a2.first;
        this.z = gVar;
        boolean z2 = true;
        boolean z3 = gVar == this.w;
        if (((Boolean) a2.second).booleanValue()) {
            this.A.Z(m2 != -9223372036854775807L ? this.r.b(m2) : this.f6103f);
        }
        if (!z3 || this.n == null) {
            z2 = false;
        }
        this.D = z2;
        this.A.D(this.f6389j, this.s, z3);
        if (z3) {
            return dVar;
        }
        this.z.c(this.A);
        return dVar;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.e
    public void a() {
        l();
        if (!this.E) {
            if (!this.q) {
                k();
            }
            this.F = true;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.e
    public void b() {
        this.E = true;
    }

    @Override // com.google.android.exoplayer2.source.d0.l
    public boolean h() {
        return this.F;
    }

    public void j(n nVar) {
        this.A = nVar;
    }
}
