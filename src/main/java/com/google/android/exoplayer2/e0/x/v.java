package com.google.android.exoplayer2.e0.x;

import com.google.android.exoplayer2.e0.h;
import com.google.android.exoplayer2.e0.n;
import com.google.android.exoplayer2.util.a0;
import com.google.android.exoplayer2.util.s;

/* access modifiers changed from: package-private */
/* compiled from: PsDurationReader */
public final class v {

    /* renamed from: a  reason: collision with root package name */
    private final a0 f5627a = new a0(0);

    /* renamed from: b  reason: collision with root package name */
    private final s f5628b = new s(20000);

    /* renamed from: c  reason: collision with root package name */
    private boolean f5629c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f5630d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f5631e;

    /* renamed from: f  reason: collision with root package name */
    private long f5632f = -9223372036854775807L;

    /* renamed from: g  reason: collision with root package name */
    private long f5633g = -9223372036854775807L;

    /* renamed from: h  reason: collision with root package name */
    private long f5634h = -9223372036854775807L;

    v() {
    }

    private static boolean a(byte[] bArr) {
        if ((bArr[0] & 196) == 68 && (bArr[2] & 4) == 4 && (bArr[4] & 4) == 4 && (bArr[5] & 1) == 1 && (bArr[8] & 3) == 3) {
            return true;
        }
        return false;
    }

    private int b(h hVar) {
        this.f5629c = true;
        hVar.e();
        return 0;
    }

    private int f(byte[] bArr, int i2) {
        return (bArr[i2 + 3] & 255) | ((bArr[i2] & 255) << 24) | ((bArr[i2 + 1] & 255) << 16) | ((bArr[i2 + 2] & 255) << 8);
    }

    private int h(h hVar, n nVar) {
        if (hVar.l() != 0) {
            nVar.f5095a = 0;
            return 1;
        }
        int min = (int) Math.min(20000L, hVar.d());
        hVar.e();
        hVar.j(this.f5628b.f7062a, 0, min);
        this.f5628b.K(0);
        this.f5628b.J(min);
        this.f5632f = i(this.f5628b);
        this.f5630d = true;
        return 0;
    }

    private long i(s sVar) {
        int d2 = sVar.d();
        for (int c2 = sVar.c(); c2 < d2 - 3; c2++) {
            if (f(sVar.f7062a, c2) == 442) {
                sVar.K(c2 + 4);
                long l = l(sVar);
                if (l != -9223372036854775807L) {
                    return l;
                }
            }
        }
        return -9223372036854775807L;
    }

    private int j(h hVar, n nVar) {
        int min = (int) Math.min(20000L, hVar.d());
        long d2 = hVar.d() - ((long) min);
        if (hVar.l() != d2) {
            nVar.f5095a = d2;
            return 1;
        }
        hVar.e();
        hVar.j(this.f5628b.f7062a, 0, min);
        this.f5628b.K(0);
        this.f5628b.J(min);
        this.f5633g = k(this.f5628b);
        this.f5631e = true;
        return 0;
    }

    private long k(s sVar) {
        int c2 = sVar.c();
        for (int d2 = sVar.d() - 4; d2 >= c2; d2--) {
            if (f(sVar.f7062a, d2) == 442) {
                sVar.K(d2 + 4);
                long l = l(sVar);
                if (l != -9223372036854775807L) {
                    return l;
                }
            }
        }
        return -9223372036854775807L;
    }

    public static long l(s sVar) {
        int c2 = sVar.c();
        if (sVar.a() < 9) {
            return -9223372036854775807L;
        }
        byte[] bArr = new byte[9];
        sVar.h(bArr, 0, 9);
        sVar.K(c2);
        if (!a(bArr)) {
            return -9223372036854775807L;
        }
        return m(bArr);
    }

    private static long m(byte[] bArr) {
        return (((((long) bArr[0]) & 56) >> 3) << 30) | ((((long) bArr[0]) & 3) << 28) | ((((long) bArr[1]) & 255) << 20) | (((((long) bArr[2]) & 248) >> 3) << 15) | ((((long) bArr[2]) & 3) << 13) | ((((long) bArr[3]) & 255) << 5) | ((((long) bArr[4]) & 248) >> 3);
    }

    public long c() {
        return this.f5634h;
    }

    public a0 d() {
        return this.f5627a;
    }

    public boolean e() {
        return this.f5629c;
    }

    public int g(h hVar, n nVar) {
        if (!this.f5631e) {
            return j(hVar, nVar);
        }
        if (this.f5633g == -9223372036854775807L) {
            return b(hVar);
        }
        if (!this.f5630d) {
            return h(hVar, nVar);
        }
        long j2 = this.f5632f;
        if (j2 == -9223372036854775807L) {
            return b(hVar);
        }
        this.f5634h = this.f5627a.b(this.f5633g) - this.f5627a.b(j2);
        return b(hVar);
    }
}
