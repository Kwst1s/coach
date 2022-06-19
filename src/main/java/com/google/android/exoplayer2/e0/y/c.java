package com.google.android.exoplayer2.e0.y;

import com.google.android.exoplayer2.e0.o;
import com.google.android.exoplayer2.e0.p;
import com.google.android.exoplayer2.util.d0;

/* access modifiers changed from: package-private */
/* compiled from: WavHeader */
public final class c implements o {

    /* renamed from: a  reason: collision with root package name */
    private final int f5668a;

    /* renamed from: b  reason: collision with root package name */
    private final int f5669b;

    /* renamed from: c  reason: collision with root package name */
    private final int f5670c;

    /* renamed from: d  reason: collision with root package name */
    private final int f5671d;

    /* renamed from: e  reason: collision with root package name */
    private final int f5672e;

    /* renamed from: f  reason: collision with root package name */
    private final int f5673f;

    /* renamed from: g  reason: collision with root package name */
    private long f5674g;

    /* renamed from: h  reason: collision with root package name */
    private long f5675h;

    public c(int i2, int i3, int i4, int i5, int i6, int i7) {
        this.f5668a = i2;
        this.f5669b = i3;
        this.f5670c = i4;
        this.f5671d = i5;
        this.f5672e = i6;
        this.f5673f = i7;
    }

    public int a() {
        return this.f5669b * this.f5672e * this.f5668a;
    }

    public long b(long j2) {
        return (Math.max(0L, j2 - this.f5674g) * 1000000) / ((long) this.f5670c);
    }

    public int c() {
        return this.f5671d;
    }

    public long e() {
        if (l()) {
            return this.f5674g + this.f5675h;
        }
        return -1;
    }

    public int f() {
        return this.f5673f;
    }

    @Override // com.google.android.exoplayer2.e0.o
    public boolean g() {
        return true;
    }

    @Override // com.google.android.exoplayer2.e0.o
    public o.a h(long j2) {
        int i2 = this.f5671d;
        long o = d0.o((((((long) this.f5670c) * j2) / 1000000) / ((long) i2)) * ((long) i2), 0, this.f5675h - ((long) i2));
        long j3 = this.f5674g + o;
        long b2 = b(j3);
        p pVar = new p(b2, j3);
        if (b2 < j2) {
            long j4 = this.f5675h;
            int i3 = this.f5671d;
            if (o != j4 - ((long) i3)) {
                long j5 = j3 + ((long) i3);
                return new o.a(pVar, new p(b(j5), j5));
            }
        }
        return new o.a(pVar);
    }

    public int i() {
        return this.f5668a;
    }

    @Override // com.google.android.exoplayer2.e0.o
    public long j() {
        return ((this.f5675h / ((long) this.f5671d)) * 1000000) / ((long) this.f5669b);
    }

    public int k() {
        return this.f5669b;
    }

    public boolean l() {
        return (this.f5674g == 0 || this.f5675h == 0) ? false : true;
    }

    public void m(long j2, long j3) {
        this.f5674g = j2;
        this.f5675h = j3;
    }
}
