package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.a0;
import com.google.android.exoplayer2.g0.g;
import com.google.android.exoplayer2.source.z;

/* compiled from: MediaPeriod */
public interface t extends z {

    /* compiled from: MediaPeriod */
    public interface a extends z.a<t> {
        void k(t tVar);
    }

    long b(long j2, a0 a0Var);

    @Override // com.google.android.exoplayer2.source.z
    long c();

    @Override // com.google.android.exoplayer2.source.z
    long d();

    @Override // com.google.android.exoplayer2.source.z
    boolean f(long j2);

    @Override // com.google.android.exoplayer2.source.z
    void g(long j2);

    long j(g[] gVarArr, boolean[] zArr, y[] yVarArr, boolean[] zArr2, long j2);

    long l();

    void m(a aVar, long j2);

    c0 o();

    void r();

    void s(long j2, boolean z);

    long t(long j2);
}
