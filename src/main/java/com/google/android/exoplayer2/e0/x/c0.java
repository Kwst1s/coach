package com.google.android.exoplayer2.e0.x;

import com.google.android.exoplayer2.e0.h;
import com.google.android.exoplayer2.e0.n;
import com.google.android.exoplayer2.util.a0;
import com.google.android.exoplayer2.util.s;

/* access modifiers changed from: package-private */
/* compiled from: TsDurationReader */
public final class c0 {

    /* renamed from: a  reason: collision with root package name */
    private final a0 f5413a = new a0(0);

    /* renamed from: b  reason: collision with root package name */
    private final s f5414b = new s(37600);

    /* renamed from: c  reason: collision with root package name */
    private boolean f5415c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f5416d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f5417e;

    /* renamed from: f  reason: collision with root package name */
    private long f5418f = -9223372036854775807L;

    /* renamed from: g  reason: collision with root package name */
    private long f5419g = -9223372036854775807L;

    /* renamed from: h  reason: collision with root package name */
    private long f5420h = -9223372036854775807L;

    c0() {
    }

    private int a(h hVar) {
        this.f5415c = true;
        hVar.e();
        return 0;
    }

    private int f(h hVar, n nVar, int i2) {
        if (hVar.l() != 0) {
            nVar.f5095a = 0;
            return 1;
        }
        int min = (int) Math.min(37600L, hVar.d());
        hVar.e();
        hVar.j(this.f5414b.f7062a, 0, min);
        this.f5414b.K(0);
        this.f5414b.J(min);
        this.f5418f = g(this.f5414b, i2);
        this.f5416d = true;
        return 0;
    }

    private long g(s sVar, int i2) {
        int d2 = sVar.d();
        for (int c2 = sVar.c(); c2 < d2; c2++) {
            if (sVar.f7062a[c2] == 71) {
                long b2 = f0.b(sVar, c2, i2);
                if (b2 != -9223372036854775807L) {
                    return b2;
                }
            }
        }
        return -9223372036854775807L;
    }

    private int h(h hVar, n nVar, int i2) {
        int min = (int) Math.min(37600L, hVar.d());
        long d2 = hVar.d() - ((long) min);
        if (hVar.l() != d2) {
            nVar.f5095a = d2;
            return 1;
        }
        hVar.e();
        hVar.j(this.f5414b.f7062a, 0, min);
        this.f5414b.K(0);
        this.f5414b.J(min);
        this.f5419g = i(this.f5414b, i2);
        this.f5417e = true;
        return 0;
    }

    private long i(s sVar, int i2) {
        int c2 = sVar.c();
        int d2 = sVar.d();
        while (true) {
            d2--;
            if (d2 < c2) {
                return -9223372036854775807L;
            }
            if (sVar.f7062a[d2] == 71) {
                long b2 = f0.b(sVar, d2, i2);
                if (b2 != -9223372036854775807L) {
                    return b2;
                }
            }
        }
    }

    public long b() {
        return this.f5420h;
    }

    public a0 c() {
        return this.f5413a;
    }

    public boolean d() {
        return this.f5415c;
    }

    public int e(h hVar, n nVar, int i2) {
        if (i2 <= 0) {
            return a(hVar);
        }
        if (!this.f5417e) {
            return h(hVar, nVar, i2);
        }
        if (this.f5419g == -9223372036854775807L) {
            return a(hVar);
        }
        if (!this.f5416d) {
            return f(hVar, nVar, i2);
        }
        long j2 = this.f5418f;
        if (j2 == -9223372036854775807L) {
            return a(hVar);
        }
        this.f5420h = this.f5413a.b(this.f5419g) - this.f5413a.b(j2);
        return a(hVar);
    }
}
