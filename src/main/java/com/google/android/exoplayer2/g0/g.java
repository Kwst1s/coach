package com.google.android.exoplayer2.g0;

import com.google.android.exoplayer2.l;
import com.google.android.exoplayer2.source.b0;
import com.google.android.exoplayer2.source.d0.m;
import com.google.android.exoplayer2.upstream.e;
import java.util.List;

/* compiled from: TrackSelection */
public interface g {

    /* compiled from: TrackSelection */
    public interface a {
        g a(b0 b0Var, e eVar, int... iArr);
    }

    boolean a(int i2, long j2);

    l b(int i2);

    void c();

    void d();

    int e(int i2);

    int f(long j2, List<? extends com.google.android.exoplayer2.source.d0.l> list);

    int g(l lVar);

    void h(long j2, long j3, long j4, List<? extends com.google.android.exoplayer2.source.d0.l> list, m[] mVarArr);

    int i();

    b0 j();

    l k();

    int l();

    int length();

    int m();

    void n(float f2);

    @Deprecated
    void o(long j2, long j3, long j4);

    Object p();

    int q(int i2);
}
