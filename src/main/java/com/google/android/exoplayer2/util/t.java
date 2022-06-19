package com.google.android.exoplayer2.util;

/* compiled from: ParsableNalUnitBitArray */
public final class t {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f7065a;

    /* renamed from: b  reason: collision with root package name */
    private int f7066b;

    /* renamed from: c  reason: collision with root package name */
    private int f7067c;

    /* renamed from: d  reason: collision with root package name */
    private int f7068d;

    public t(byte[] bArr, int i2, int i3) {
        i(bArr, i2, i3);
    }

    private void a() {
        int i2;
        int i3 = this.f7067c;
        e.f(i3 >= 0 && (i3 < (i2 = this.f7066b) || (i3 == i2 && this.f7068d == 0)));
    }

    private int f() {
        int i2 = 0;
        int i3 = 0;
        while (!d()) {
            i3++;
        }
        int i4 = (1 << i3) - 1;
        if (i3 > 0) {
            i2 = e(i3);
        }
        return i4 + i2;
    }

    private boolean j(int i2) {
        if (2 <= i2 && i2 < this.f7066b) {
            byte[] bArr = this.f7065a;
            return bArr[i2] == 3 && bArr[i2 + -2] == 0 && bArr[i2 - 1] == 0;
        }
    }

    public boolean b(int i2) {
        int i3 = this.f7067c;
        int i4 = i2 / 8;
        int i5 = i3 + i4;
        int i6 = (this.f7068d + i2) - (i4 * 8);
        if (i6 > 7) {
            i5++;
            i6 -= 8;
        }
        while (true) {
            i3++;
            if (i3 > i5 || i5 >= this.f7066b) {
                int i7 = this.f7066b;
            } else if (j(i3)) {
                i5++;
                i3 += 2;
            }
        }
        int i72 = this.f7066b;
        if (i5 < i72) {
            return true;
        }
        if (i5 == i72 && i6 == 0) {
            return true;
        }
        return false;
    }

    public boolean c() {
        int i2 = this.f7067c;
        int i3 = this.f7068d;
        int i4 = 0;
        while (this.f7067c < this.f7066b && !d()) {
            i4++;
        }
        boolean z = this.f7067c == this.f7066b;
        this.f7067c = i2;
        this.f7068d = i3;
        if (z || !b((i4 * 2) + 1)) {
            return false;
        }
        return true;
    }

    public boolean d() {
        boolean z = (this.f7065a[this.f7067c] & (128 >> this.f7068d)) != 0;
        k();
        return z;
    }

    public int e(int i2) {
        int i3;
        int i4;
        this.f7068d += i2;
        int i5 = 0;
        while (true) {
            i3 = this.f7068d;
            i4 = 2;
            if (i3 <= 8) {
                break;
            }
            int i6 = i3 - 8;
            this.f7068d = i6;
            byte[] bArr = this.f7065a;
            int i7 = this.f7067c;
            i5 |= (bArr[i7] & 255) << i6;
            if (!j(i7 + 1)) {
                i4 = 1;
            }
            this.f7067c = i7 + i4;
        }
        byte[] bArr2 = this.f7065a;
        int i8 = this.f7067c;
        int i9 = (-1 >>> (32 - i2)) & (i5 | ((bArr2[i8] & 255) >> (8 - i3)));
        if (i3 == 8) {
            this.f7068d = 0;
            if (!j(i8 + 1)) {
                i4 = 1;
            }
            this.f7067c = i8 + i4;
        }
        a();
        return i9;
    }

    public int g() {
        int f2 = f();
        return (f2 % 2 == 0 ? -1 : 1) * ((f2 + 1) / 2);
    }

    public int h() {
        return f();
    }

    public void i(byte[] bArr, int i2, int i3) {
        this.f7065a = bArr;
        this.f7067c = i2;
        this.f7066b = i3;
        this.f7068d = 0;
        a();
    }

    public void k() {
        int i2 = 1;
        int i3 = this.f7068d + 1;
        this.f7068d = i3;
        if (i3 == 8) {
            this.f7068d = 0;
            int i4 = this.f7067c;
            if (j(i4 + 1)) {
                i2 = 2;
            }
            this.f7067c = i4 + i2;
        }
        a();
    }

    public void l(int i2) {
        int i3 = this.f7067c;
        int i4 = i2 / 8;
        int i5 = i3 + i4;
        this.f7067c = i5;
        int i6 = this.f7068d + (i2 - (i4 * 8));
        this.f7068d = i6;
        if (i6 > 7) {
            this.f7067c = i5 + 1;
            this.f7068d = i6 - 8;
        }
        while (true) {
            i3++;
            if (i3 > this.f7067c) {
                a();
                return;
            } else if (j(i3)) {
                this.f7067c++;
                i3 += 2;
            }
        }
    }
}
