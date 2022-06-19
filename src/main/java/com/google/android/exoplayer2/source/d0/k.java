package com.google.android.exoplayer2.source.d0;

import com.google.android.exoplayer2.e0.d;
import com.google.android.exoplayer2.e0.g;
import com.google.android.exoplayer2.e0.n;
import com.google.android.exoplayer2.l;
import com.google.android.exoplayer2.upstream.i;
import com.google.android.exoplayer2.upstream.w;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.e;

/* compiled from: InitializationChunk */
public final class k extends d {
    private static final n l = new n();

    /* renamed from: i  reason: collision with root package name */
    private final e f6141i;

    /* renamed from: j  reason: collision with root package name */
    private long f6142j;

    /* renamed from: k  reason: collision with root package name */
    private volatile boolean f6143k;

    public k(i iVar, com.google.android.exoplayer2.upstream.k kVar, l lVar, int i2, Object obj, e eVar) {
        super(iVar, kVar, 2, lVar, i2, obj, -9223372036854775807L, -9223372036854775807L);
        this.f6141i = eVar;
    }

    /* JADX INFO: finally extract failed */
    @Override // com.google.android.exoplayer2.upstream.Loader.e
    public void a() {
        com.google.android.exoplayer2.upstream.k d2 = this.f6098a.d(this.f6142j);
        try {
            w wVar = this.f6105h;
            d dVar = new d(wVar, d2.f6925d, wVar.b(d2));
            if (this.f6142j == 0) {
                this.f6141i.d(null, -9223372036854775807L, -9223372036854775807L);
            }
            try {
                g gVar = this.f6141i.f6106b;
                boolean z = false;
                int i2 = 0;
                while (i2 == 0 && !this.f6143k) {
                    i2 = gVar.i(dVar, l);
                }
                if (i2 != 1) {
                    z = true;
                }
                e.f(z);
                this.f6142j = dVar.l() - this.f6098a.f6925d;
            } catch (Throwable th) {
                this.f6142j = dVar.l() - this.f6098a.f6925d;
                throw th;
            }
        } finally {
            d0.j(this.f6105h);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.e
    public void b() {
        this.f6143k = true;
    }
}
