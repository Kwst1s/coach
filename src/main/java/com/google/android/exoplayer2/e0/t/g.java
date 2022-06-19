package com.google.android.exoplayer2.e0.t;

import com.github.mikephil.charting.utils.Utils;
import com.google.android.exoplayer2.e0.m;
import com.google.android.exoplayer2.e0.o;
import com.google.android.exoplayer2.e0.p;
import com.google.android.exoplayer2.e0.t.e;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.s;

/* access modifiers changed from: package-private */
/* compiled from: XingSeeker */
public final class g implements e.a {

    /* renamed from: a  reason: collision with root package name */
    private final long f5184a;

    /* renamed from: b  reason: collision with root package name */
    private final int f5185b;

    /* renamed from: c  reason: collision with root package name */
    private final long f5186c;

    /* renamed from: d  reason: collision with root package name */
    private final long f5187d;

    /* renamed from: e  reason: collision with root package name */
    private final long f5188e;

    /* renamed from: f  reason: collision with root package name */
    private final long[] f5189f;

    private g(long j2, int i2, long j3) {
        this(j2, i2, j3, -1, null);
    }

    public static g a(long j2, long j3, m mVar, s sVar) {
        int C;
        int i2 = mVar.f5094g;
        int i3 = mVar.f5091d;
        int j4 = sVar.j();
        if ((j4 & 1) != 1 || (C = sVar.C()) == 0) {
            return null;
        }
        long Z = d0.Z((long) C, ((long) i2) * 1000000, (long) i3);
        if ((j4 & 6) != 6) {
            return new g(j3, mVar.f5090c, Z);
        }
        long C2 = (long) sVar.C();
        long[] jArr = new long[100];
        for (int i4 = 0; i4 < 100; i4++) {
            jArr[i4] = (long) sVar.y();
        }
        if (j2 != -1) {
            long j5 = j3 + C2;
            if (j2 != j5) {
                com.google.android.exoplayer2.util.m.f("XingSeeker", "XING data size mismatch: " + j2 + ", " + j5);
            }
        }
        return new g(j3, mVar.f5090c, Z, C2, jArr);
    }

    private long c(int i2) {
        return (this.f5186c * ((long) i2)) / 100;
    }

    @Override // com.google.android.exoplayer2.e0.t.e.a
    public long b(long j2) {
        long j3;
        double d2;
        long j4 = j2 - this.f5184a;
        if (!g() || j4 <= ((long) this.f5185b)) {
            return 0;
        }
        long[] jArr = this.f5189f;
        com.google.android.exoplayer2.util.e.e(jArr);
        long[] jArr2 = jArr;
        double d3 = (double) j4;
        Double.isNaN(d3);
        double d4 = (double) this.f5187d;
        Double.isNaN(d4);
        double d5 = (d3 * 256.0d) / d4;
        int e2 = d0.e(jArr2, (long) d5, true, true);
        long c2 = c(e2);
        long j5 = jArr2[e2];
        int i2 = e2 + 1;
        long c3 = c(i2);
        if (e2 == 99) {
            j3 = 256;
        } else {
            j3 = jArr2[i2];
        }
        if (j5 == j3) {
            d2 = Utils.DOUBLE_EPSILON;
        } else {
            double d6 = (double) j5;
            Double.isNaN(d6);
            double d7 = (double) (j3 - j5);
            Double.isNaN(d7);
            d2 = (d5 - d6) / d7;
        }
        double d8 = (double) (c3 - c2);
        Double.isNaN(d8);
        return c2 + Math.round(d2 * d8);
    }

    @Override // com.google.android.exoplayer2.e0.t.e.a
    public long d() {
        return this.f5188e;
    }

    @Override // com.google.android.exoplayer2.e0.o
    public boolean g() {
        return this.f5189f != null;
    }

    @Override // com.google.android.exoplayer2.e0.o
    public o.a h(long j2) {
        double d2;
        if (!g()) {
            return new o.a(new p(0, this.f5184a + ((long) this.f5185b)));
        }
        long o = d0.o(j2, 0, this.f5186c);
        double d3 = (double) o;
        Double.isNaN(d3);
        double d4 = (double) this.f5186c;
        Double.isNaN(d4);
        double d5 = (d3 * 100.0d) / d4;
        double d6 = Utils.DOUBLE_EPSILON;
        if (d5 > Utils.DOUBLE_EPSILON) {
            if (d5 >= 100.0d) {
                d6 = 256.0d;
            } else {
                int i2 = (int) d5;
                long[] jArr = this.f5189f;
                com.google.android.exoplayer2.util.e.e(jArr);
                long[] jArr2 = jArr;
                double d7 = (double) jArr2[i2];
                if (i2 == 99) {
                    d2 = 256.0d;
                } else {
                    d2 = (double) jArr2[i2 + 1];
                }
                double d8 = (double) i2;
                Double.isNaN(d8);
                Double.isNaN(d7);
                Double.isNaN(d7);
                d6 = d7 + ((d5 - d8) * (d2 - d7));
            }
        }
        double d9 = (double) this.f5187d;
        Double.isNaN(d9);
        return new o.a(new p(o, this.f5184a + d0.o(Math.round((d6 / 256.0d) * d9), (long) this.f5185b, this.f5187d - 1)));
    }

    @Override // com.google.android.exoplayer2.e0.o
    public long j() {
        return this.f5186c;
    }

    private g(long j2, int i2, long j3, long j4, long[] jArr) {
        this.f5184a = j2;
        this.f5185b = i2;
        this.f5186c = j3;
        this.f5189f = jArr;
        this.f5187d = j4;
        this.f5188e = j4 != -1 ? j2 + j4 : -1;
    }
}
