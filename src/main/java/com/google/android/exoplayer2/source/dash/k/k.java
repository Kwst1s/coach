package com.google.android.exoplayer2.source.dash.k;

import com.google.android.exoplayer2.source.dash.f;

/* access modifiers changed from: package-private */
/* compiled from: SingleSegmentIndex */
public final class k implements f {

    /* renamed from: a  reason: collision with root package name */
    private final h f6309a;

    public k(h hVar) {
        this.f6309a = hVar;
    }

    @Override // com.google.android.exoplayer2.source.dash.f
    public long a(long j2, long j3) {
        return 0;
    }

    @Override // com.google.android.exoplayer2.source.dash.f
    public long b(long j2) {
        return 0;
    }

    @Override // com.google.android.exoplayer2.source.dash.f
    public long c(long j2, long j3) {
        return j3;
    }

    @Override // com.google.android.exoplayer2.source.dash.f
    public h d(long j2) {
        return this.f6309a;
    }

    @Override // com.google.android.exoplayer2.source.dash.f
    public boolean e() {
        return true;
    }

    @Override // com.google.android.exoplayer2.source.dash.f
    public long f() {
        return 0;
    }

    @Override // com.google.android.exoplayer2.source.dash.f
    public int g(long j2) {
        return 1;
    }
}
