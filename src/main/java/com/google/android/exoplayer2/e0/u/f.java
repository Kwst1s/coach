package com.google.android.exoplayer2.e0.u;

import com.google.android.exoplayer2.util.d0;

/* access modifiers changed from: package-private */
/* compiled from: FixedSampleSizeRechunker */
public final class f {

    /* compiled from: FixedSampleSizeRechunker */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final long[] f5238a;

        /* renamed from: b  reason: collision with root package name */
        public final int[] f5239b;

        /* renamed from: c  reason: collision with root package name */
        public final int f5240c;

        /* renamed from: d  reason: collision with root package name */
        public final long[] f5241d;

        /* renamed from: e  reason: collision with root package name */
        public final int[] f5242e;

        /* renamed from: f  reason: collision with root package name */
        public final long f5243f;

        private b(long[] jArr, int[] iArr, int i2, long[] jArr2, int[] iArr2, long j2) {
            this.f5238a = jArr;
            this.f5239b = iArr;
            this.f5240c = i2;
            this.f5241d = jArr2;
            this.f5242e = iArr2;
            this.f5243f = j2;
        }
    }

    public static b a(int i2, long[] jArr, int[] iArr, long j2) {
        int i3 = 8192 / i2;
        int i4 = 0;
        for (int i5 : iArr) {
            i4 += d0.h(i5, i3);
        }
        long[] jArr2 = new long[i4];
        int[] iArr2 = new int[i4];
        long[] jArr3 = new long[i4];
        int[] iArr3 = new int[i4];
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < iArr.length; i9++) {
            int i10 = iArr[i9];
            long j3 = jArr[i9];
            while (i10 > 0) {
                int min = Math.min(i3, i10);
                jArr2[i7] = j3;
                iArr2[i7] = i2 * min;
                i8 = Math.max(i8, iArr2[i7]);
                jArr3[i7] = ((long) i6) * j2;
                iArr3[i7] = 1;
                j3 += (long) iArr2[i7];
                i6 += min;
                i10 -= min;
                i7++;
            }
        }
        return new b(jArr2, iArr2, i8, jArr3, iArr3, j2 * ((long) i6));
    }
}
