package com.google.android.exoplayer2.util;

import java.util.Arrays;

/* compiled from: LongArray */
public final class n {

    /* renamed from: a  reason: collision with root package name */
    private int f7034a;

    /* renamed from: b  reason: collision with root package name */
    private long[] f7035b;

    public n() {
        this(32);
    }

    public void a(long j2) {
        int i2 = this.f7034a;
        long[] jArr = this.f7035b;
        if (i2 == jArr.length) {
            this.f7035b = Arrays.copyOf(jArr, i2 * 2);
        }
        long[] jArr2 = this.f7035b;
        int i3 = this.f7034a;
        this.f7034a = i3 + 1;
        jArr2[i3] = j2;
    }

    public long b(int i2) {
        if (i2 >= 0 && i2 < this.f7034a) {
            return this.f7035b[i2];
        }
        throw new IndexOutOfBoundsException("Invalid index " + i2 + ", size is " + this.f7034a);
    }

    public int c() {
        return this.f7034a;
    }

    public long[] d() {
        return Arrays.copyOf(this.f7035b, this.f7034a);
    }

    public n(int i2) {
        this.f7035b = new long[i2];
    }
}
