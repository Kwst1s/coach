package com.google.android.exoplayer2.util;

import java.util.Arrays;

/* compiled from: TimedValueQueue */
public final class z<V> {

    /* renamed from: a  reason: collision with root package name */
    private long[] f7087a;

    /* renamed from: b  reason: collision with root package name */
    private V[] f7088b;

    /* renamed from: c  reason: collision with root package name */
    private int f7089c;

    /* renamed from: d  reason: collision with root package name */
    private int f7090d;

    public z() {
        this(10);
    }

    private void b(long j2, V v) {
        int i2 = this.f7089c;
        int i3 = this.f7090d;
        V[] vArr = this.f7088b;
        int length = (i2 + i3) % vArr.length;
        this.f7087a[length] = j2;
        vArr[length] = v;
        this.f7090d = i3 + 1;
    }

    private void d(long j2) {
        int i2 = this.f7090d;
        if (i2 > 0) {
            if (j2 <= this.f7087a[((this.f7089c + i2) - 1) % this.f7088b.length]) {
                c();
            }
        }
    }

    private void e() {
        int length = this.f7088b.length;
        if (this.f7090d >= length) {
            int i2 = length * 2;
            long[] jArr = new long[i2];
            V[] vArr = (V[]) f(i2);
            int i3 = this.f7089c;
            int i4 = length - i3;
            System.arraycopy(this.f7087a, i3, jArr, 0, i4);
            System.arraycopy(this.f7088b, this.f7089c, vArr, 0, i4);
            int i5 = this.f7089c;
            if (i5 > 0) {
                System.arraycopy(this.f7087a, 0, jArr, i4, i5);
                System.arraycopy(this.f7088b, 0, vArr, i4, this.f7089c);
            }
            this.f7087a = jArr;
            this.f7088b = vArr;
            this.f7089c = 0;
        }
    }

    private static <V> V[] f(int i2) {
        return (V[]) new Object[i2];
    }

    private V g(long j2, boolean z) {
        long j3 = Long.MAX_VALUE;
        V v = null;
        while (true) {
            int i2 = this.f7090d;
            if (i2 <= 0) {
                break;
            }
            long[] jArr = this.f7087a;
            int i3 = this.f7089c;
            long j4 = j2 - jArr[i3];
            if (j4 < 0 && (z || (-j4) >= j3)) {
                break;
            }
            V[] vArr = this.f7088b;
            v = vArr[i3];
            vArr[i3] = null;
            this.f7089c = (i3 + 1) % vArr.length;
            this.f7090d = i2 - 1;
            j3 = j4;
        }
        return v;
    }

    public synchronized void a(long j2, V v) {
        d(j2);
        e();
        b(j2, v);
    }

    public synchronized void c() {
        this.f7089c = 0;
        this.f7090d = 0;
        Arrays.fill(this.f7088b, (Object) null);
    }

    public synchronized V h(long j2) {
        return g(j2, true);
    }

    public z(int i2) {
        this.f7087a = new long[i2];
        this.f7088b = (V[]) f(i2);
    }
}
