package com.google.android.exoplayer2.e0;

import com.google.android.exoplayer2.e0.o;
import com.google.android.exoplayer2.util.d0;

/* compiled from: ConstantBitrateSeekMap */
public class c implements o {

    /* renamed from: a  reason: collision with root package name */
    private final long f5057a;

    /* renamed from: b  reason: collision with root package name */
    private final long f5058b;

    /* renamed from: c  reason: collision with root package name */
    private final int f5059c;

    /* renamed from: d  reason: collision with root package name */
    private final long f5060d;

    /* renamed from: e  reason: collision with root package name */
    private final int f5061e;

    /* renamed from: f  reason: collision with root package name */
    private final long f5062f;

    public c(long j2, long j3, int i2, int i3) {
        this.f5057a = j2;
        this.f5058b = j3;
        this.f5059c = i3 == -1 ? 1 : i3;
        this.f5061e = i2;
        if (j2 == -1) {
            this.f5060d = -1;
            this.f5062f = -9223372036854775807L;
            return;
        }
        this.f5060d = j2 - j3;
        this.f5062f = e(j2, j3, i2);
    }

    private long a(long j2) {
        int i2 = this.f5059c;
        return this.f5058b + d0.o((((j2 * ((long) this.f5061e)) / 8000000) / ((long) i2)) * ((long) i2), 0, this.f5060d - ((long) i2));
    }

    private static long e(long j2, long j3, int i2) {
        return ((Math.max(0L, j2 - j3) * 8) * 1000000) / ((long) i2);
    }

    public long c(long j2) {
        return e(j2, this.f5058b, this.f5061e);
    }

    @Override // com.google.android.exoplayer2.e0.o
    public boolean g() {
        return this.f5060d != -1;
    }

    @Override // com.google.android.exoplayer2.e0.o
    public o.a h(long j2) {
        if (this.f5060d == -1) {
            return new o.a(new p(0, this.f5058b));
        }
        long a2 = a(j2);
        long c2 = c(a2);
        p pVar = new p(c2, a2);
        if (c2 < j2) {
            int i2 = this.f5059c;
            if (((long) i2) + a2 < this.f5057a) {
                long j3 = a2 + ((long) i2);
                return new o.a(pVar, new p(c(j3), j3));
            }
        }
        return new o.a(pVar);
    }

    @Override // com.google.android.exoplayer2.e0.o
    public long j() {
        return this.f5062f;
    }
}
