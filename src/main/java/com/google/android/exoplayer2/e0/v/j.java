package com.google.android.exoplayer2.e0.v;

import com.google.android.exoplayer2.util.e;

/* access modifiers changed from: package-private */
/* compiled from: VorbisBitArray */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f5380a;

    /* renamed from: b  reason: collision with root package name */
    private final int f5381b;

    /* renamed from: c  reason: collision with root package name */
    private int f5382c;

    /* renamed from: d  reason: collision with root package name */
    private int f5383d;

    public j(byte[] bArr) {
        this.f5380a = bArr;
        this.f5381b = bArr.length;
    }

    private void a() {
        int i2;
        int i3 = this.f5382c;
        e.f(i3 >= 0 && (i3 < (i2 = this.f5381b) || (i3 == i2 && this.f5383d == 0)));
    }

    public int b() {
        return (this.f5382c * 8) + this.f5383d;
    }

    public boolean c() {
        boolean z = (((this.f5380a[this.f5382c] & 255) >> this.f5383d) & 1) == 1;
        e(1);
        return z;
    }

    public int d(int i2) {
        int i3 = this.f5382c;
        int min = Math.min(i2, 8 - this.f5383d);
        int i4 = i3 + 1;
        int i5 = ((this.f5380a[i3] & 255) >> this.f5383d) & (255 >> (8 - min));
        while (min < i2) {
            i5 |= (this.f5380a[i4] & 255) << min;
            min += 8;
            i4++;
        }
        int i6 = i5 & (-1 >>> (32 - i2));
        e(i2);
        return i6;
    }

    public void e(int i2) {
        int i3 = i2 / 8;
        int i4 = this.f5382c + i3;
        this.f5382c = i4;
        int i5 = this.f5383d + (i2 - (i3 * 8));
        this.f5383d = i5;
        if (i5 > 7) {
            this.f5382c = i4 + 1;
            this.f5383d = i5 - 8;
        }
        a();
    }
}
