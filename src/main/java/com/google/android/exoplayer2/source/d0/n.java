package com.google.android.exoplayer2.source.d0;

import com.google.android.exoplayer2.e0.d;
import com.google.android.exoplayer2.e0.q;
import com.google.android.exoplayer2.l;
import com.google.android.exoplayer2.upstream.i;
import com.google.android.exoplayer2.upstream.k;
import com.google.android.exoplayer2.util.d0;

/* compiled from: SingleSampleMediaChunk */
public final class n extends a {
    private final int n;
    private final l o;
    private long p;
    private boolean q;

    public n(i iVar, k kVar, l lVar, int i2, Object obj, long j2, long j3, long j4, int i3, l lVar2) {
        super(iVar, kVar, lVar, i2, obj, j2, j3, -9223372036854775807L, -9223372036854775807L, j4);
        this.n = i3;
        this.o = lVar2;
    }

    /* JADX INFO: finally extract failed */
    @Override // com.google.android.exoplayer2.upstream.Loader.e
    public void a() {
        try {
            long b2 = this.f6105h.b(this.f6098a.d(this.p));
            if (b2 != -1) {
                b2 += this.p;
            }
            d dVar = new d(this.f6105h, this.p, b2);
            c j2 = j();
            j2.c(0);
            q a2 = j2.a(0, this.n);
            a2.d(this.o);
            for (int i2 = 0; i2 != -1; i2 = a2.b(dVar, Integer.MAX_VALUE, true)) {
                this.p += (long) i2;
            }
            a2.c(this.f6103f, 1, (int) this.p, 0, null);
            d0.j(this.f6105h);
            this.q = true;
        } catch (Throwable th) {
            d0.j(this.f6105h);
            throw th;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.e
    public void b() {
    }

    @Override // com.google.android.exoplayer2.source.d0.l
    public boolean h() {
        return this.q;
    }
}
