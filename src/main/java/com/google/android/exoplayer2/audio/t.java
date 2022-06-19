package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.util.e;
import java.nio.ShortBuffer;
import java.util.Arrays;

/* access modifiers changed from: package-private */
/* compiled from: Sonic */
public final class t {

    /* renamed from: a  reason: collision with root package name */
    private final int f4850a;

    /* renamed from: b  reason: collision with root package name */
    private final int f4851b;

    /* renamed from: c  reason: collision with root package name */
    private final float f4852c;

    /* renamed from: d  reason: collision with root package name */
    private final float f4853d;

    /* renamed from: e  reason: collision with root package name */
    private final float f4854e;

    /* renamed from: f  reason: collision with root package name */
    private final int f4855f;

    /* renamed from: g  reason: collision with root package name */
    private final int f4856g;

    /* renamed from: h  reason: collision with root package name */
    private final int f4857h;

    /* renamed from: i  reason: collision with root package name */
    private final short[] f4858i;

    /* renamed from: j  reason: collision with root package name */
    private short[] f4859j;

    /* renamed from: k  reason: collision with root package name */
    private int f4860k;
    private short[] l;
    private int m;
    private short[] n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private int t;
    private int u;
    private int v;

    public t(int i2, int i3, float f2, float f3, int i4) {
        this.f4850a = i2;
        this.f4851b = i3;
        this.f4852c = f2;
        this.f4853d = f3;
        this.f4854e = ((float) i2) / ((float) i4);
        this.f4855f = i2 / 400;
        int i5 = i2 / 65;
        this.f4856g = i5;
        int i6 = i5 * 2;
        this.f4857h = i6;
        this.f4858i = new short[i6];
        this.f4859j = new short[(i6 * i3)];
        this.l = new short[(i6 * i3)];
        this.n = new short[(i6 * i3)];
    }

    private void a(float f2, int i2) {
        int i3;
        int i4;
        if (this.m != i2) {
            int i5 = this.f4850a;
            int i6 = (int) (((float) i5) / f2);
            while (true) {
                if (i6 <= 16384 && i5 <= 16384) {
                    break;
                }
                i6 /= 2;
                i5 /= 2;
            }
            n(i2);
            int i7 = 0;
            while (true) {
                int i8 = this.o;
                boolean z = true;
                if (i7 < i8 - 1) {
                    while (true) {
                        i3 = this.p;
                        int i9 = (i3 + 1) * i6;
                        i4 = this.q;
                        if (i9 <= i4 * i5) {
                            break;
                        }
                        this.l = f(this.l, this.m, 1);
                        int i10 = 0;
                        while (true) {
                            int i11 = this.f4851b;
                            if (i10 >= i11) {
                                break;
                            }
                            this.l[(this.m * i11) + i10] = m(this.n, (i11 * i7) + i10, i5, i6);
                            i10++;
                        }
                        this.q++;
                        this.m++;
                    }
                    int i12 = i3 + 1;
                    this.p = i12;
                    if (i12 == i5) {
                        this.p = 0;
                        if (i4 != i6) {
                            z = false;
                        }
                        e.f(z);
                        this.q = 0;
                    }
                    i7++;
                } else {
                    t(i8 - 1);
                    return;
                }
            }
        }
    }

    private void b(float f2) {
        int l2;
        int i2 = this.f4860k;
        if (i2 >= this.f4857h) {
            int i3 = 0;
            do {
                if (this.r > 0) {
                    l2 = c(i3);
                } else {
                    int g2 = g(this.f4859j, i3);
                    if (((double) f2) > 1.0d) {
                        l2 = g2 + v(this.f4859j, i3, f2, g2);
                    } else {
                        l2 = l(this.f4859j, i3, f2, g2);
                    }
                }
                i3 += l2;
            } while (this.f4857h + i3 <= i2);
            u(i3);
        }
    }

    private int c(int i2) {
        int min = Math.min(this.f4857h, this.r);
        d(this.f4859j, i2, min);
        this.r -= min;
        return min;
    }

    private void d(short[] sArr, int i2, int i3) {
        short[] f2 = f(this.l, this.m, i3);
        this.l = f2;
        int i4 = this.f4851b;
        System.arraycopy(sArr, i2 * i4, f2, this.m * i4, i4 * i3);
        this.m += i3;
    }

    private void e(short[] sArr, int i2, int i3) {
        int i4 = this.f4857h / i3;
        int i5 = this.f4851b;
        int i6 = i3 * i5;
        int i7 = i2 * i5;
        for (int i8 = 0; i8 < i4; i8++) {
            int i9 = 0;
            for (int i10 = 0; i10 < i6; i10++) {
                i9 += sArr[(i8 * i6) + i7 + i10];
            }
            this.f4858i[i8] = (short) (i9 / i6);
        }
    }

    private short[] f(short[] sArr, int i2, int i3) {
        int length = sArr.length;
        int i4 = this.f4851b;
        int i5 = length / i4;
        if (i2 + i3 <= i5) {
            return sArr;
        }
        return Arrays.copyOf(sArr, (((i5 * 3) / 2) + i3) * i4);
    }

    private int g(short[] sArr, int i2) {
        int i3;
        int i4 = this.f4850a;
        int i5 = i4 > 4000 ? i4 / 4000 : 1;
        if (this.f4851b == 1 && i5 == 1) {
            i3 = h(sArr, i2, this.f4855f, this.f4856g);
        } else {
            e(sArr, i2, i5);
            int h2 = h(this.f4858i, 0, this.f4855f / i5, this.f4856g / i5);
            if (i5 != 1) {
                int i6 = h2 * i5;
                int i7 = i5 * 4;
                int i8 = i6 - i7;
                int i9 = i6 + i7;
                int i10 = this.f4855f;
                if (i8 < i10) {
                    i8 = i10;
                }
                int i11 = this.f4856g;
                if (i9 > i11) {
                    i9 = i11;
                }
                if (this.f4851b == 1) {
                    i3 = h(sArr, i2, i8, i9);
                } else {
                    e(sArr, i2, 1);
                    i3 = h(this.f4858i, 0, i8, i9);
                }
            } else {
                i3 = h2;
            }
        }
        int i12 = p(this.u, this.v) ? this.s : i3;
        this.t = this.u;
        this.s = i3;
        return i12;
    }

    private int h(short[] sArr, int i2, int i3, int i4) {
        int i5 = i2 * this.f4851b;
        int i6 = 1;
        int i7 = 255;
        int i8 = 0;
        int i9 = 0;
        while (i3 <= i4) {
            int i10 = 0;
            for (int i11 = 0; i11 < i3; i11++) {
                i10 += Math.abs(sArr[i5 + i11] - sArr[(i5 + i3) + i11]);
            }
            if (i10 * i8 < i6 * i3) {
                i8 = i3;
                i6 = i10;
            }
            if (i10 * i7 > i9 * i3) {
                i7 = i3;
                i9 = i10;
            }
            i3++;
        }
        this.u = i6 / i8;
        this.v = i9 / i7;
        return i8;
    }

    private int l(short[] sArr, int i2, float f2, int i3) {
        int i4;
        if (f2 < 0.5f) {
            i4 = (int) ((((float) i3) * f2) / (1.0f - f2));
        } else {
            this.r = (int) ((((float) i3) * ((2.0f * f2) - 1.0f)) / (1.0f - f2));
            i4 = i3;
        }
        int i5 = i3 + i4;
        short[] f3 = f(this.l, this.m, i5);
        this.l = f3;
        int i6 = this.f4851b;
        System.arraycopy(sArr, i2 * i6, f3, this.m * i6, i6 * i3);
        o(i4, this.f4851b, this.l, this.m + i3, sArr, i2 + i3, sArr, i2);
        this.m += i5;
        return i4;
    }

    private short m(short[] sArr, int i2, int i3, int i4) {
        short s2 = sArr[i2];
        short s3 = sArr[i2 + this.f4851b];
        int i5 = this.q * i3;
        int i6 = this.p;
        int i7 = i6 * i4;
        int i8 = (i6 + 1) * i4;
        int i9 = i8 - i5;
        int i10 = i8 - i7;
        return (short) (((s2 * i9) + ((i10 - i9) * s3)) / i10);
    }

    private void n(int i2) {
        int i3 = this.m - i2;
        short[] f2 = f(this.n, this.o, i3);
        this.n = f2;
        short[] sArr = this.l;
        int i4 = this.f4851b;
        System.arraycopy(sArr, i2 * i4, f2, this.o * i4, i4 * i3);
        this.m = i2;
        this.o += i3;
    }

    private static void o(int i2, int i3, short[] sArr, int i4, short[] sArr2, int i5, short[] sArr3, int i6) {
        for (int i7 = 0; i7 < i3; i7++) {
            int i8 = (i4 * i3) + i7;
            int i9 = (i6 * i3) + i7;
            int i10 = (i5 * i3) + i7;
            for (int i11 = 0; i11 < i2; i11++) {
                sArr[i8] = (short) (((sArr2[i10] * (i2 - i11)) + (sArr3[i9] * i11)) / i2);
                i8 += i3;
                i10 += i3;
                i9 += i3;
            }
        }
    }

    private boolean p(int i2, int i3) {
        if (i2 == 0 || this.s == 0 || i3 > i2 * 3 || i2 * 2 <= this.t * 3) {
            return false;
        }
        return true;
    }

    private void q() {
        int i2 = this.m;
        float f2 = this.f4852c;
        float f3 = this.f4853d;
        float f4 = f2 / f3;
        float f5 = this.f4854e * f3;
        double d2 = (double) f4;
        if (d2 > 1.00001d || d2 < 0.99999d) {
            b(f4);
        } else {
            d(this.f4859j, 0, this.f4860k);
            this.f4860k = 0;
        }
        if (f5 != 1.0f) {
            a(f5, i2);
        }
    }

    private void t(int i2) {
        if (i2 != 0) {
            short[] sArr = this.n;
            int i3 = this.f4851b;
            System.arraycopy(sArr, i2 * i3, sArr, 0, (this.o - i2) * i3);
            this.o -= i2;
        }
    }

    private void u(int i2) {
        int i3 = this.f4860k - i2;
        short[] sArr = this.f4859j;
        int i4 = this.f4851b;
        System.arraycopy(sArr, i2 * i4, sArr, 0, i4 * i3);
        this.f4860k = i3;
    }

    private int v(short[] sArr, int i2, float f2, int i3) {
        int i4;
        if (f2 >= 2.0f) {
            i4 = (int) (((float) i3) / (f2 - 1.0f));
        } else {
            this.r = (int) ((((float) i3) * (2.0f - f2)) / (f2 - 1.0f));
            i4 = i3;
        }
        short[] f3 = f(this.l, this.m, i4);
        this.l = f3;
        o(i4, this.f4851b, f3, this.m, sArr, i2, sArr, i2 + i3);
        this.m += i4;
        return i4;
    }

    public void i() {
        this.f4860k = 0;
        this.m = 0;
        this.o = 0;
        this.p = 0;
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.t = 0;
        this.u = 0;
        this.v = 0;
    }

    public int j() {
        return this.m;
    }

    public void k(ShortBuffer shortBuffer) {
        int min = Math.min(shortBuffer.remaining() / this.f4851b, this.m);
        shortBuffer.put(this.l, 0, this.f4851b * min);
        int i2 = this.m - min;
        this.m = i2;
        short[] sArr = this.l;
        int i3 = this.f4851b;
        System.arraycopy(sArr, min * i3, sArr, 0, i2 * i3);
    }

    public void r() {
        int i2;
        int i3 = this.f4860k;
        float f2 = this.f4852c;
        float f3 = this.f4853d;
        int i4 = this.m + ((int) ((((((float) i3) / (f2 / f3)) + ((float) this.o)) / (this.f4854e * f3)) + 0.5f));
        this.f4859j = f(this.f4859j, i3, (this.f4857h * 2) + i3);
        int i5 = 0;
        while (true) {
            i2 = this.f4857h;
            int i6 = this.f4851b;
            if (i5 >= i2 * 2 * i6) {
                break;
            }
            this.f4859j[(i6 * i3) + i5] = 0;
            i5++;
        }
        this.f4860k += i2 * 2;
        q();
        if (this.m > i4) {
            this.m = i4;
        }
        this.f4860k = 0;
        this.r = 0;
        this.o = 0;
    }

    public void s(ShortBuffer shortBuffer) {
        int remaining = shortBuffer.remaining();
        int i2 = this.f4851b;
        int i3 = remaining / i2;
        short[] f2 = f(this.f4859j, this.f4860k, i3);
        this.f4859j = f2;
        shortBuffer.get(f2, this.f4860k * this.f4851b, ((i2 * i3) * 2) / 2);
        this.f4860k += i3;
        q();
    }
}
