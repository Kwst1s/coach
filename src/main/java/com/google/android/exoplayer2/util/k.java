package com.google.android.exoplayer2.util;

/* compiled from: FlacStreamInfo */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public final int f7028a;

    /* renamed from: b  reason: collision with root package name */
    public final int f7029b;

    /* renamed from: c  reason: collision with root package name */
    public final int f7030c;

    /* renamed from: d  reason: collision with root package name */
    public final long f7031d;

    public k(byte[] bArr, int i2) {
        r rVar = new r(bArr);
        rVar.n(i2 * 8);
        rVar.h(16);
        rVar.h(16);
        rVar.h(24);
        rVar.h(24);
        this.f7028a = rVar.h(20);
        this.f7029b = rVar.h(3) + 1;
        this.f7030c = rVar.h(5) + 1;
        this.f7031d = ((((long) rVar.h(4)) & 15) << 32) | (((long) rVar.h(32)) & 4294967295L);
    }

    public int a() {
        return this.f7030c * this.f7028a;
    }

    public long b() {
        return (this.f7031d * 1000000) / ((long) this.f7028a);
    }
}
