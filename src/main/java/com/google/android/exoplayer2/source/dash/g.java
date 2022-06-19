package com.google.android.exoplayer2.source.dash;

import com.google.android.exoplayer2.e0.b;
import com.google.android.exoplayer2.source.dash.k.h;

/* compiled from: DashWrappingSegmentIndex */
public final class g implements f {

    /* renamed from: a  reason: collision with root package name */
    private final b f6194a;

    /* renamed from: b  reason: collision with root package name */
    private final long f6195b;

    public g(b bVar, long j2) {
        this.f6194a = bVar;
        this.f6195b = j2;
    }

    @Override // com.google.android.exoplayer2.source.dash.f
    public long a(long j2, long j3) {
        return (long) this.f6194a.a(j2 + this.f6195b);
    }

    @Override // com.google.android.exoplayer2.source.dash.f
    public long b(long j2) {
        return this.f6194a.f5055e[(int) j2] - this.f6195b;
    }

    @Override // com.google.android.exoplayer2.source.dash.f
    public long c(long j2, long j3) {
        return this.f6194a.f5054d[(int) j2];
    }

    @Override // com.google.android.exoplayer2.source.dash.f
    public h d(long j2) {
        b bVar = this.f6194a;
        int i2 = (int) j2;
        return new h(null, bVar.f5053c[i2], (long) bVar.f5052b[i2]);
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
        return this.f6194a.f5051a;
    }
}
