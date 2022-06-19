package com.google.android.exoplayer2.util;

import com.github.mikephil.charting.BuildConfig;
import java.nio.charset.Charset;

/* compiled from: ParsableByteArray */
public final class s {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f7062a;

    /* renamed from: b  reason: collision with root package name */
    private int f7063b;

    /* renamed from: c  reason: collision with root package name */
    private int f7064c;

    public s() {
        this.f7062a = d0.f7011f;
    }

    public long A() {
        byte[] bArr = this.f7062a;
        int i2 = this.f7063b;
        int i3 = i2 + 1;
        this.f7063b = i3;
        int i4 = i3 + 1;
        this.f7063b = i4;
        int i5 = i4 + 1;
        this.f7063b = i5;
        this.f7063b = i5 + 1;
        return (((long) bArr[i5]) & 255) | ((((long) bArr[i2]) & 255) << 24) | ((((long) bArr[i3]) & 255) << 16) | ((((long) bArr[i4]) & 255) << 8);
    }

    public int B() {
        byte[] bArr = this.f7062a;
        int i2 = this.f7063b;
        int i3 = i2 + 1;
        this.f7063b = i3;
        int i4 = i3 + 1;
        this.f7063b = i4;
        int i5 = ((bArr[i2] & 255) << 16) | ((bArr[i3] & 255) << 8);
        this.f7063b = i4 + 1;
        return (bArr[i4] & 255) | i5;
    }

    public int C() {
        int j2 = j();
        if (j2 >= 0) {
            return j2;
        }
        throw new IllegalStateException("Top bit not zero: " + j2);
    }

    public long D() {
        long r = r();
        if (r >= 0) {
            return r;
        }
        throw new IllegalStateException("Top bit not zero: " + r);
    }

    public int E() {
        byte[] bArr = this.f7062a;
        int i2 = this.f7063b;
        int i3 = i2 + 1;
        this.f7063b = i3;
        this.f7063b = i3 + 1;
        return (bArr[i3] & 255) | ((bArr[i2] & 255) << 8);
    }

    public long F() {
        int i2;
        int i3;
        long j2 = (long) this.f7062a[this.f7063b];
        int i4 = 7;
        while (true) {
            if (i4 < 0) {
                break;
            }
            int i5 = 1 << i4;
            if ((((long) i5) & j2) != 0) {
                i4--;
            } else if (i4 < 6) {
                j2 &= (long) (i5 - 1);
                i3 = 7 - i4;
            } else if (i4 == 7) {
                i3 = 1;
            }
        }
        i3 = 0;
        if (i3 != 0) {
            for (i2 = 1; i2 < i3; i2++) {
                byte b2 = this.f7062a[this.f7063b + i2];
                if ((b2 & 192) == 128) {
                    j2 = (j2 << 6) | ((long) (b2 & 63));
                } else {
                    throw new NumberFormatException("Invalid UTF-8 sequence continuation byte: " + j2);
                }
            }
            this.f7063b += i3;
            return j2;
        }
        throw new NumberFormatException("Invalid UTF-8 sequence first byte: " + j2);
    }

    public void G() {
        this.f7063b = 0;
        this.f7064c = 0;
    }

    public void H(int i2) {
        I(b() < i2 ? new byte[i2] : this.f7062a, i2);
    }

    public void I(byte[] bArr, int i2) {
        this.f7062a = bArr;
        this.f7064c = i2;
        this.f7063b = 0;
    }

    public void J(int i2) {
        e.a(i2 >= 0 && i2 <= this.f7062a.length);
        this.f7064c = i2;
    }

    public void K(int i2) {
        e.a(i2 >= 0 && i2 <= this.f7064c);
        this.f7063b = i2;
    }

    public void L(int i2) {
        K(this.f7063b + i2);
    }

    public int a() {
        return this.f7064c - this.f7063b;
    }

    public int b() {
        return this.f7062a.length;
    }

    public int c() {
        return this.f7063b;
    }

    public int d() {
        return this.f7064c;
    }

    public char e() {
        byte[] bArr = this.f7062a;
        int i2 = this.f7063b;
        return (char) ((bArr[i2 + 1] & 255) | ((bArr[i2] & 255) << 8));
    }

    public int f() {
        return this.f7062a[this.f7063b] & 255;
    }

    public void g(r rVar, int i2) {
        h(rVar.f7058a, 0, i2);
        rVar.n(0);
    }

    public void h(byte[] bArr, int i2, int i3) {
        System.arraycopy(this.f7062a, this.f7063b, bArr, i2, i3);
        this.f7063b += i3;
    }

    public double i() {
        return Double.longBitsToDouble(r());
    }

    public int j() {
        byte[] bArr = this.f7062a;
        int i2 = this.f7063b;
        int i3 = i2 + 1;
        this.f7063b = i3;
        int i4 = i3 + 1;
        this.f7063b = i4;
        int i5 = ((bArr[i2] & 255) << 24) | ((bArr[i3] & 255) << 16);
        int i6 = i4 + 1;
        this.f7063b = i6;
        int i7 = i5 | ((bArr[i4] & 255) << 8);
        this.f7063b = i6 + 1;
        return (bArr[i6] & 255) | i7;
    }

    public int k() {
        byte[] bArr = this.f7062a;
        int i2 = this.f7063b;
        int i3 = i2 + 1;
        this.f7063b = i3;
        int i4 = i3 + 1;
        this.f7063b = i4;
        int i5 = (((bArr[i2] & 255) << 24) >> 8) | ((bArr[i3] & 255) << 8);
        this.f7063b = i4 + 1;
        return (bArr[i4] & 255) | i5;
    }

    public String l() {
        if (a() == 0) {
            return null;
        }
        int i2 = this.f7063b;
        while (i2 < this.f7064c && !d0.O(this.f7062a[i2])) {
            i2++;
        }
        int i3 = this.f7063b;
        if (i2 - i3 >= 3) {
            byte[] bArr = this.f7062a;
            if (bArr[i3] == -17 && bArr[i3 + 1] == -69 && bArr[i3 + 2] == -65) {
                this.f7063b = i3 + 3;
            }
        }
        byte[] bArr2 = this.f7062a;
        int i4 = this.f7063b;
        String u = d0.u(bArr2, i4, i2 - i4);
        this.f7063b = i2;
        int i5 = this.f7064c;
        if (i2 == i5) {
            return u;
        }
        byte[] bArr3 = this.f7062a;
        if (bArr3[i2] == 13) {
            int i6 = i2 + 1;
            this.f7063b = i6;
            if (i6 == i5) {
                return u;
            }
        }
        int i7 = this.f7063b;
        if (bArr3[i7] == 10) {
            this.f7063b = i7 + 1;
        }
        return u;
    }

    public int m() {
        byte[] bArr = this.f7062a;
        int i2 = this.f7063b;
        int i3 = i2 + 1;
        this.f7063b = i3;
        int i4 = i3 + 1;
        this.f7063b = i4;
        int i5 = (bArr[i2] & 255) | ((bArr[i3] & 255) << 8);
        int i6 = i4 + 1;
        this.f7063b = i6;
        int i7 = i5 | ((bArr[i4] & 255) << 16);
        this.f7063b = i6 + 1;
        return ((bArr[i6] & 255) << 24) | i7;
    }

    public long n() {
        byte[] bArr = this.f7062a;
        int i2 = this.f7063b;
        int i3 = i2 + 1;
        this.f7063b = i3;
        int i4 = i3 + 1;
        this.f7063b = i4;
        int i5 = i4 + 1;
        this.f7063b = i5;
        int i6 = i5 + 1;
        this.f7063b = i6;
        int i7 = i6 + 1;
        this.f7063b = i7;
        int i8 = i7 + 1;
        this.f7063b = i8;
        int i9 = i8 + 1;
        this.f7063b = i9;
        this.f7063b = i9 + 1;
        return ((((long) bArr[i9]) & 255) << 56) | (((long) bArr[i2]) & 255) | ((((long) bArr[i3]) & 255) << 8) | ((((long) bArr[i4]) & 255) << 16) | ((((long) bArr[i5]) & 255) << 24) | ((((long) bArr[i6]) & 255) << 32) | ((((long) bArr[i7]) & 255) << 40) | ((((long) bArr[i8]) & 255) << 48);
    }

    public long o() {
        byte[] bArr = this.f7062a;
        int i2 = this.f7063b;
        int i3 = i2 + 1;
        this.f7063b = i3;
        int i4 = i3 + 1;
        this.f7063b = i4;
        int i5 = i4 + 1;
        this.f7063b = i5;
        this.f7063b = i5 + 1;
        return ((((long) bArr[i5]) & 255) << 24) | (((long) bArr[i2]) & 255) | ((((long) bArr[i3]) & 255) << 8) | ((((long) bArr[i4]) & 255) << 16);
    }

    public int p() {
        int m = m();
        if (m >= 0) {
            return m;
        }
        throw new IllegalStateException("Top bit not zero: " + m);
    }

    public int q() {
        byte[] bArr = this.f7062a;
        int i2 = this.f7063b;
        int i3 = i2 + 1;
        this.f7063b = i3;
        this.f7063b = i3 + 1;
        return ((bArr[i3] & 255) << 8) | (bArr[i2] & 255);
    }

    public long r() {
        byte[] bArr = this.f7062a;
        int i2 = this.f7063b;
        int i3 = i2 + 1;
        this.f7063b = i3;
        int i4 = i3 + 1;
        this.f7063b = i4;
        int i5 = i4 + 1;
        this.f7063b = i5;
        int i6 = i5 + 1;
        this.f7063b = i6;
        int i7 = i6 + 1;
        this.f7063b = i7;
        int i8 = i7 + 1;
        this.f7063b = i8;
        int i9 = i8 + 1;
        this.f7063b = i9;
        this.f7063b = i9 + 1;
        return (((long) bArr[i9]) & 255) | ((((long) bArr[i2]) & 255) << 56) | ((((long) bArr[i3]) & 255) << 48) | ((((long) bArr[i4]) & 255) << 40) | ((((long) bArr[i5]) & 255) << 32) | ((((long) bArr[i6]) & 255) << 24) | ((((long) bArr[i7]) & 255) << 16) | ((((long) bArr[i8]) & 255) << 8);
    }

    public String s() {
        if (a() == 0) {
            return null;
        }
        int i2 = this.f7063b;
        while (i2 < this.f7064c && this.f7062a[i2] != 0) {
            i2++;
        }
        byte[] bArr = this.f7062a;
        int i3 = this.f7063b;
        String u = d0.u(bArr, i3, i2 - i3);
        this.f7063b = i2;
        if (i2 < this.f7064c) {
            this.f7063b = i2 + 1;
        }
        return u;
    }

    public String t(int i2) {
        if (i2 == 0) {
            return BuildConfig.FLAVOR;
        }
        int i3 = this.f7063b;
        int i4 = (i3 + i2) - 1;
        String u = d0.u(this.f7062a, i3, (i4 >= this.f7064c || this.f7062a[i4] != 0) ? i2 : i2 - 1);
        this.f7063b += i2;
        return u;
    }

    public short u() {
        byte[] bArr = this.f7062a;
        int i2 = this.f7063b;
        int i3 = i2 + 1;
        this.f7063b = i3;
        this.f7063b = i3 + 1;
        return (short) ((bArr[i3] & 255) | ((bArr[i2] & 255) << 8));
    }

    public String v(int i2) {
        return w(i2, Charset.forName("UTF-8"));
    }

    public String w(int i2, Charset charset) {
        String str = new String(this.f7062a, this.f7063b, i2, charset);
        this.f7063b += i2;
        return str;
    }

    public int x() {
        return (y() << 21) | (y() << 14) | (y() << 7) | y();
    }

    public int y() {
        byte[] bArr = this.f7062a;
        int i2 = this.f7063b;
        this.f7063b = i2 + 1;
        return bArr[i2] & 255;
    }

    public int z() {
        byte[] bArr = this.f7062a;
        int i2 = this.f7063b;
        int i3 = i2 + 1;
        this.f7063b = i3;
        int i4 = i3 + 1;
        this.f7063b = i4;
        int i5 = (bArr[i3] & 255) | ((bArr[i2] & 255) << 8);
        this.f7063b = i4 + 2;
        return i5;
    }

    public s(int i2) {
        this.f7062a = new byte[i2];
        this.f7064c = i2;
    }

    public s(byte[] bArr) {
        this.f7062a = bArr;
        this.f7064c = bArr.length;
    }

    public s(byte[] bArr, int i2) {
        this.f7062a = bArr;
        this.f7064c = i2;
    }
}
