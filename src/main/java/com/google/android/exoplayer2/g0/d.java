package com.google.android.exoplayer2.g0;

import com.google.android.exoplayer2.source.b0;
import com.google.android.exoplayer2.source.d0.l;
import com.google.android.exoplayer2.source.d0.m;
import java.util.List;

/* compiled from: FixedTrackSelection */
public final class d extends b {

    /* renamed from: g  reason: collision with root package name */
    private final int f5842g;

    /* renamed from: h  reason: collision with root package name */
    private final Object f5843h;

    public d(b0 b0Var, int i2) {
        this(b0Var, i2, 0, null);
    }

    @Override // com.google.android.exoplayer2.g0.b, com.google.android.exoplayer2.g0.g
    public void h(long j2, long j3, long j4, List<? extends l> list, m[] mVarArr) {
    }

    @Override // com.google.android.exoplayer2.g0.g
    public int l() {
        return this.f5842g;
    }

    @Override // com.google.android.exoplayer2.g0.g
    public int m() {
        return 0;
    }

    @Override // com.google.android.exoplayer2.g0.g
    public Object p() {
        return this.f5843h;
    }

    public d(b0 b0Var, int i2, int i3, Object obj) {
        super(b0Var, i2);
        this.f5842g = i3;
        this.f5843h = obj;
    }
}
