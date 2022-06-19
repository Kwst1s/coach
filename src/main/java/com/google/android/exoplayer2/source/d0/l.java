package com.google.android.exoplayer2.source.d0;

import com.google.android.exoplayer2.upstream.i;
import com.google.android.exoplayer2.upstream.k;
import com.google.android.exoplayer2.util.e;

/* compiled from: MediaChunk */
public abstract class l extends d {

    /* renamed from: i  reason: collision with root package name */
    public final long f6144i;

    public l(i iVar, k kVar, com.google.android.exoplayer2.l lVar, int i2, Object obj, long j2, long j3, long j4) {
        super(iVar, kVar, 1, lVar, i2, obj, j2, j3);
        e.e(lVar);
        this.f6144i = j4;
    }

    public long g() {
        long j2 = this.f6144i;
        if (j2 != -1) {
            return 1 + j2;
        }
        return -1;
    }

    public abstract boolean h();
}
