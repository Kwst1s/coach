package com.google.android.exoplayer2.util;

/* compiled from: TimestampAdjuster */
public final class a0 {

    /* renamed from: a  reason: collision with root package name */
    private long f7000a;

    /* renamed from: b  reason: collision with root package name */
    private long f7001b;

    /* renamed from: c  reason: collision with root package name */
    private volatile long f7002c = -9223372036854775807L;

    public a0(long j2) {
        h(j2);
    }

    public static long f(long j2) {
        return (j2 * 1000000) / 90000;
    }

    public static long i(long j2) {
        return (j2 * 90000) / 1000000;
    }

    public long a(long j2) {
        if (j2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (this.f7002c != -9223372036854775807L) {
            this.f7002c = j2;
        } else {
            long j3 = this.f7000a;
            if (j3 != Long.MAX_VALUE) {
                this.f7001b = j3 - j2;
            }
            synchronized (this) {
                this.f7002c = j2;
                notifyAll();
            }
        }
        return j2 + this.f7001b;
    }

    public long b(long j2) {
        if (j2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (this.f7002c != -9223372036854775807L) {
            long i2 = i(this.f7002c);
            long j3 = (4294967296L + i2) / 8589934592L;
            long j4 = ((j3 - 1) * 8589934592L) + j2;
            j2 += j3 * 8589934592L;
            if (Math.abs(j4 - i2) < Math.abs(j2 - i2)) {
                j2 = j4;
            }
        }
        return a(f(j2));
    }

    public long c() {
        return this.f7000a;
    }

    public long d() {
        if (this.f7002c != -9223372036854775807L) {
            return this.f7001b + this.f7002c;
        }
        long j2 = this.f7000a;
        if (j2 != Long.MAX_VALUE) {
            return j2;
        }
        return -9223372036854775807L;
    }

    public long e() {
        if (this.f7000a == Long.MAX_VALUE) {
            return 0;
        }
        if (this.f7002c == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return this.f7001b;
    }

    public void g() {
        this.f7002c = -9223372036854775807L;
    }

    public synchronized void h(long j2) {
        e.f(this.f7002c == -9223372036854775807L);
        this.f7000a = j2;
    }

    public synchronized void j() {
        while (this.f7002c == -9223372036854775807L) {
            wait();
        }
    }
}
