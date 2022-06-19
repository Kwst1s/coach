package com.google.android.exoplayer2.source.d0;

import com.google.android.exoplayer2.e0.d;
import com.google.android.exoplayer2.e0.g;
import com.google.android.exoplayer2.e0.n;
import com.google.android.exoplayer2.l;
import com.google.android.exoplayer2.upstream.k;
import com.google.android.exoplayer2.upstream.w;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.e;

/* compiled from: ContainerMediaChunk */
public class i extends a {
    private static final n t = new n();
    private final int n;
    private final long o;
    private final e p;
    private long q;
    private volatile boolean r;
    private boolean s;

    public i(com.google.android.exoplayer2.upstream.i iVar, k kVar, l lVar, int i2, Object obj, long j2, long j3, long j4, long j5, long j6, int i3, long j7, e eVar) {
        super(iVar, kVar, lVar, i2, obj, j2, j3, j4, j5, j6);
        this.n = i3;
        this.o = j7;
        this.p = eVar;
    }

    /* JADX INFO: finally extract failed */
    @Override // com.google.android.exoplayer2.upstream.Loader.e
    public final void a() {
        k d2 = this.f6098a.d(this.q);
        try {
            w wVar = this.f6105h;
            d dVar = new d(wVar, d2.f6925d, wVar.b(d2));
            if (this.q == 0) {
                c j2 = j();
                j2.c(this.o);
                e eVar = this.p;
                long j3 = this.f6094j;
                long j4 = j3 == -9223372036854775807L ? -9223372036854775807L : j3 - this.o;
                long j5 = this.f6095k;
                eVar.d(j2, j4, j5 == -9223372036854775807L ? -9223372036854775807L : j5 - this.o);
            }
            try {
                g gVar = this.p.f6106b;
                boolean z = false;
                int i2 = 0;
                while (i2 == 0 && !this.r) {
                    i2 = gVar.i(dVar, t);
                }
                if (i2 != 1) {
                    z = true;
                }
                e.f(z);
                this.q = dVar.l() - this.f6098a.f6925d;
                d0.j(this.f6105h);
                this.s = true;
            } catch (Throwable th) {
                this.q = dVar.l() - this.f6098a.f6925d;
                throw th;
            }
        } catch (Throwable th2) {
            d0.j(this.f6105h);
            throw th2;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.e
    public final void b() {
        this.r = true;
    }

    @Override // com.google.android.exoplayer2.source.d0.l
    public long g() {
        return this.f6144i + ((long) this.n);
    }

    @Override // com.google.android.exoplayer2.source.d0.l
    public boolean h() {
        return this.s;
    }
}
