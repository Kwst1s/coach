package com.google.android.exoplayer2.util;

/* compiled from: ParsableBitArray */
public final class r {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f7058a;

    /* renamed from: b  reason: collision with root package name */
    private int f7059b;

    /* renamed from: c  reason: collision with root package name */
    private int f7060c;

    /* renamed from: d  reason: collision with root package name */
    private int f7061d;

    public r() {
        this.f7058a = d0.f7011f;
    }

    private void a() {
        int i2;
        int i3 = this.f7059b;
        e.f(i3 >= 0 && (i3 < (i2 = this.f7061d) || (i3 == i2 && this.f7060c == 0)));
    }

    public int b() {
        return ((this.f7061d - this.f7059b) * 8) - this.f7060c;
    }

    public void c() {
        if (this.f7060c != 0) {
            this.f7060c = 0;
            this.f7059b++;
            a();
        }
    }

    public int d() {
        e.f(this.f7060c == 0);
        return this.f7059b;
    }

    public int e() {
        return (this.f7059b * 8) + this.f7060c;
    }

    public void f(int i2, int i3) {
        if (i3 < 32) {
            i2 &= (1 << i3) - 1;
        }
        int min = Math.min(8 - this.f7060c, i3);
        int i4 = this.f7060c;
        int i5 = (8 - i4) - min;
        byte[] bArr = this.f7058a;
        int i6 = this.f7059b;
        bArr[i6] = (byte) (((65280 >> i4) | ((1 << i5) - 1)) & bArr[i6]);
        int i7 = i3 - min;
        bArr[i6] = (byte) (((i2 >>> i7) << i5) | bArr[i6]);
        int i8 = i6 + 1;
        while (i7 > 8) {
            this.f7058a[i8] = (byte) (i2 >>> (i7 - 8));
            i7 -= 8;
            i8++;
        }
        int i9 = 8 - i7;
        byte[] bArr2 = this.f7058a;
        bArr2[i8] = (byte) (bArr2[i8] & ((1 << i9) - 1));
        bArr2[i8] = (byte) (((i2 & ((1 << i7) - 1)) << i9) | bArr2[i8]);
        p(i3);
        a();
    }

    public boolean g() {
        boolean z = (this.f7058a[this.f7059b] & (128 >> this.f7060c)) != 0;
        o();
        return z;
    }

    public int h(int i2) {
        int i3;
        if (i2 == 0) {
            return 0;
        }
        this.f7060c += i2;
        int i4 = 0;
        while (true) {
            i3 = this.f7060c;
            if (i3 <= 8) {
                break;
            }
            int i5 = i3 - 8;
            this.f7060c = i5;
            byte[] bArr = this.f7058a;
            int i6 = this.f7059b;
            this.f7059b = i6 + 1;
            i4 |= (bArr[i6] & 255) << i5;
        }
        byte[] bArr2 = this.f7058a;
        int i7 = this.f7059b;
        int i8 = (-1 >>> (32 - i2)) & (i4 | ((bArr2[i7] & 255) >> (8 - i3)));
        if (i3 == 8) {
            this.f7060c = 0;
            this.f7059b = i7 + 1;
        }
        a();
        return i8;
    }

    public void i(byte[] bArr, int i2, int i3) {
        int i4 = (i3 >> 3) + i2;
        while (i2 < i4) {
            byte[] bArr2 = this.f7058a;
            int i5 = this.f7059b;
            int i6 = i5 + 1;
            this.f7059b = i6;
            byte b2 = bArr2[i5];
            int i7 = this.f7060c;
            bArr[i2] = (byte) (b2 << i7);
            bArr[i2] = (byte) (((255 & bArr2[i6]) >> (8 - i7)) | bArr[i2]);
            i2++;
        }
        int i8 = i3 & 7;
        if (i8 != 0) {
            bArr[i4] = (byte) (bArr[i4] & (255 >> i8));
            int i9 = this.f7060c;
            if (i9 + i8 > 8) {
                byte b3 = bArr[i4];
                byte[] bArr3 = this.f7058a;
                int i10 = this.f7059b;
                this.f7059b = i10 + 1;
                bArr[i4] = (byte) (b3 | ((bArr3[i10] & 255) << i9));
                this.f7060c = i9 - 8;
            }
            int i11 = this.f7060c + i8;
            this.f7060c = i11;
            byte[] bArr4 = this.f7058a;
            int i12 = this.f7059b;
            bArr[i4] = (byte) (((byte) (((255 & bArr4[i12]) >> (8 - i11)) << (8 - i8))) | bArr[i4]);
            if (i11 == 8) {
                this.f7060c = 0;
                this.f7059b = i12 + 1;
            }
            a();
        }
    }

    public void j(byte[] bArr, int i2, int i3) {
        e.f(this.f7060c == 0);
        System.arraycopy(this.f7058a, this.f7059b, bArr, i2, i3);
        this.f7059b += i3;
        a();
    }

    public void k(s sVar) {
        m(sVar.f7062a, sVar.d());
        n(sVar.c() * 8);
    }

    public void l(byte[] bArr) {
        m(bArr, bArr.length);
    }

    public void m(byte[] bArr, int i2) {
        this.f7058a = bArr;
        this.f7059b = 0;
        this.f7060c = 0;
        this.f7061d = i2;
    }

    public void n(int i2) {
        int i3 = i2 / 8;
        this.f7059b = i3;
        this.f7060c = i2 - (i3 * 8);
        a();
    }

    public void o() {
        int i2 = this.f7060c + 1;
        this.f7060c = i2;
        if (i2 == 8) {
            this.f7060c = 0;
            this.f7059b++;
        }
        a();
    }

    public void p(int i2) {
        int i3 = i2 / 8;
        int i4 = this.f7059b + i3;
        this.f7059b = i4;
        int i5 = this.f7060c + (i2 - (i3 * 8));
        this.f7060c = i5;
        if (i5 > 7) {
            this.f7059b = i4 + 1;
            this.f7060c = i5 - 8;
        }
        a();
    }

    public void q(int i2) {
        e.f(this.f7060c == 0);
        this.f7059b += i2;
        a();
    }

    public r(byte[] bArr) {
        this(bArr, bArr.length);
    }

    public r(byte[] bArr, int i2) {
        this.f7058a = bArr;
        this.f7061d = i2;
    }
}
