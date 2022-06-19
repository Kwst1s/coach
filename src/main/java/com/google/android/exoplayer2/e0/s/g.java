package com.google.android.exoplayer2.e0.s;

import com.google.android.exoplayer2.e0.h;

/* access modifiers changed from: package-private */
/* compiled from: VarintReader */
public final class g {

    /* renamed from: d  reason: collision with root package name */
    private static final long[] f5160d = {128, 64, 32, 16, 8, 4, 2, 1};

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f5161a = new byte[8];

    /* renamed from: b  reason: collision with root package name */
    private int f5162b;

    /* renamed from: c  reason: collision with root package name */
    private int f5163c;

    public static long a(byte[] bArr, int i2, boolean z) {
        long j2 = ((long) bArr[0]) & 255;
        if (z) {
            j2 &= f5160d[i2 - 1] ^ -1;
        }
        for (int i3 = 1; i3 < i2; i3++) {
            j2 = (j2 << 8) | (((long) bArr[i3]) & 255);
        }
        return j2;
    }

    public static int c(int i2) {
        int i3 = 0;
        while (true) {
            long[] jArr = f5160d;
            if (i3 >= jArr.length) {
                return -1;
            }
            if ((jArr[i3] & ((long) i2)) != 0) {
                return i3 + 1;
            }
            i3++;
        }
    }

    public int b() {
        return this.f5163c;
    }

    public long d(h hVar, boolean z, boolean z2, int i2) {
        if (this.f5162b == 0) {
            if (!hVar.c(this.f5161a, 0, 1, z)) {
                return -1;
            }
            int c2 = c(this.f5161a[0] & 255);
            this.f5163c = c2;
            if (c2 != -1) {
                this.f5162b = 1;
            } else {
                throw new IllegalStateException("No valid varint length mask found");
            }
        }
        int i3 = this.f5163c;
        if (i3 > i2) {
            this.f5162b = 0;
            return -2;
        }
        if (i3 != 1) {
            hVar.readFully(this.f5161a, 1, i3 - 1);
        }
        this.f5162b = 0;
        return a(this.f5161a, this.f5163c, z2);
    }

    public void e() {
        this.f5162b = 0;
        this.f5163c = 0;
    }
}
