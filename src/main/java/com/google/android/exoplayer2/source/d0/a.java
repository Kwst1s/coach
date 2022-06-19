package com.google.android.exoplayer2.source.d0;

import com.google.android.exoplayer2.l;
import com.google.android.exoplayer2.upstream.i;
import com.google.android.exoplayer2.upstream.k;

/* compiled from: BaseMediaChunk */
public abstract class a extends l {

    /* renamed from: j  reason: collision with root package name */
    public final long f6094j;

    /* renamed from: k  reason: collision with root package name */
    public final long f6095k;
    private c l;
    private int[] m;

    public a(i iVar, k kVar, l lVar, int i2, Object obj, long j2, long j3, long j4, long j5, long j6) {
        super(iVar, kVar, lVar, i2, obj, j2, j3, j6);
        this.f6094j = j4;
        this.f6095k = j5;
    }

    public final int i(int i2) {
        return this.m[i2];
    }

    /* access modifiers changed from: protected */
    public final c j() {
        return this.l;
    }

    public void k(c cVar) {
        this.l = cVar;
        this.m = cVar.b();
    }
}
