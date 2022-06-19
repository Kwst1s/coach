package com.google.android.exoplayer2.e0.t;

import android.util.Pair;
import com.github.mikephil.charting.utils.Utils;
import com.google.android.exoplayer2.e0.o;
import com.google.android.exoplayer2.e0.p;
import com.google.android.exoplayer2.e0.t.e;
import com.google.android.exoplayer2.f0.h.k;
import com.google.android.exoplayer2.util.d0;

/* access modifiers changed from: package-private */
/* compiled from: MlltSeeker */
public final class d implements e.a {

    /* renamed from: a  reason: collision with root package name */
    private final long[] f5166a;

    /* renamed from: b  reason: collision with root package name */
    private final long[] f5167b;

    /* renamed from: c  reason: collision with root package name */
    private final long f5168c;

    private d(long[] jArr, long[] jArr2) {
        this.f5166a = jArr;
        this.f5167b = jArr2;
        this.f5168c = com.google.android.exoplayer2.d.a(jArr2[jArr2.length - 1]);
    }

    public static d a(long j2, k kVar) {
        int length = kVar.f5754f.length;
        int i2 = length + 1;
        long[] jArr = new long[i2];
        long[] jArr2 = new long[i2];
        jArr[0] = j2;
        long j3 = 0;
        jArr2[0] = 0;
        for (int i3 = 1; i3 <= length; i3++) {
            int i4 = i3 - 1;
            j2 += (long) (kVar.f5752d + kVar.f5754f[i4]);
            j3 += (long) (kVar.f5753e + kVar.f5755g[i4]);
            jArr[i3] = j2;
            jArr2[i3] = j3;
        }
        return new d(jArr, jArr2);
    }

    private static Pair<Long, Long> c(long j2, long[] jArr, long[] jArr2) {
        double d2;
        int e2 = d0.e(jArr, j2, true, true);
        long j3 = jArr[e2];
        long j4 = jArr2[e2];
        int i2 = e2 + 1;
        if (i2 == jArr.length) {
            return Pair.create(Long.valueOf(j3), Long.valueOf(j4));
        }
        long j5 = jArr[i2];
        long j6 = jArr2[i2];
        if (j5 == j3) {
            d2 = Utils.DOUBLE_EPSILON;
        } else {
            double d3 = (double) j2;
            double d4 = (double) j3;
            Double.isNaN(d3);
            Double.isNaN(d4);
            double d5 = (double) (j5 - j3);
            Double.isNaN(d5);
            d2 = (d3 - d4) / d5;
        }
        double d6 = (double) (j6 - j4);
        Double.isNaN(d6);
        return Pair.create(Long.valueOf(j2), Long.valueOf(((long) (d2 * d6)) + j4));
    }

    @Override // com.google.android.exoplayer2.e0.t.e.a
    public long b(long j2) {
        return com.google.android.exoplayer2.d.a(((Long) c(j2, this.f5166a, this.f5167b).second).longValue());
    }

    @Override // com.google.android.exoplayer2.e0.t.e.a
    public long d() {
        return -1;
    }

    @Override // com.google.android.exoplayer2.e0.o
    public boolean g() {
        return true;
    }

    @Override // com.google.android.exoplayer2.e0.o
    public o.a h(long j2) {
        Pair<Long, Long> c2 = c(com.google.android.exoplayer2.d.b(d0.o(j2, 0, this.f5168c)), this.f5167b, this.f5166a);
        return new o.a(new p(com.google.android.exoplayer2.d.a(((Long) c2.first).longValue()), ((Long) c2.second).longValue()));
    }

    @Override // com.google.android.exoplayer2.e0.o
    public long j() {
        return this.f5168c;
    }
}
