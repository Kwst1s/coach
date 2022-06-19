package com.google.android.exoplayer2.util;

import android.util.Pair;
import b.a.j;
import com.google.android.exoplayer2.ParserException;
import java.util.ArrayList;

/* compiled from: CodecSpecificDataUtil */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f7016a = {0, 0, 0, 1};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f7017b = {96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f7018c = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    public static byte[] a(int i2, int i3, int i4) {
        return new byte[]{(byte) (((i2 << 3) & 248) | ((i3 >> 1) & 7)), (byte) (((i3 << 7) & 128) | ((i4 << 3) & j.E0))};
    }

    public static byte[] b(int i2, int i3) {
        int i4 = 0;
        int i5 = 0;
        int i6 = -1;
        while (true) {
            int[] iArr = f7017b;
            if (i5 >= iArr.length) {
                break;
            }
            if (i2 == iArr[i5]) {
                i6 = i5;
            }
            i5++;
        }
        int i7 = -1;
        while (true) {
            int[] iArr2 = f7018c;
            if (i4 >= iArr2.length) {
                break;
            }
            if (i3 == iArr2[i4]) {
                i7 = i4;
            }
            i4++;
        }
        if (i2 != -1 && i7 != -1) {
            return a(2, i6, i7);
        }
        throw new IllegalArgumentException("Invalid sample rate or number of channels: " + i2 + ", " + i3);
    }

    public static String c(int i2, int i3, int i4) {
        return String.format("avc1.%02X%02X%02X", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
    }

    public static byte[] d(byte[] bArr, int i2, int i3) {
        byte[] bArr2 = f7016a;
        byte[] bArr3 = new byte[(bArr2.length + i3)];
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        System.arraycopy(bArr, i2, bArr3, bArr2.length, i3);
        return bArr3;
    }

    private static int e(byte[] bArr, int i2) {
        int length = bArr.length - f7016a.length;
        while (i2 <= length) {
            if (h(bArr, i2)) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    private static int f(r rVar) {
        int h2 = rVar.h(5);
        return h2 == 31 ? rVar.h(6) + 32 : h2;
    }

    private static int g(r rVar) {
        int h2 = rVar.h(4);
        if (h2 == 15) {
            return rVar.h(24);
        }
        e.a(h2 < 13);
        return f7017b[h2];
    }

    private static boolean h(byte[] bArr, int i2) {
        if (bArr.length - i2 <= f7016a.length) {
            return false;
        }
        int i3 = 0;
        while (true) {
            byte[] bArr2 = f7016a;
            if (i3 >= bArr2.length) {
                return true;
            }
            if (bArr[i2 + i3] != bArr2[i3]) {
                return false;
            }
            i3++;
        }
    }

    public static Pair<Integer, Integer> i(r rVar, boolean z) {
        int f2 = f(rVar);
        int g2 = g(rVar);
        int h2 = rVar.h(4);
        if (f2 == 5 || f2 == 29) {
            g2 = g(rVar);
            f2 = f(rVar);
            if (f2 == 22) {
                h2 = rVar.h(4);
            }
        }
        boolean z2 = true;
        if (z) {
            if (!(f2 == 1 || f2 == 2 || f2 == 3 || f2 == 4 || f2 == 6 || f2 == 7 || f2 == 17)) {
                switch (f2) {
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                        break;
                    default:
                        throw new ParserException("Unsupported audio object type: " + f2);
                }
            }
            k(rVar, f2, h2);
            switch (f2) {
                case 17:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                    int h3 = rVar.h(2);
                    if (h3 == 2 || h3 == 3) {
                        throw new ParserException("Unsupported epConfig: " + h3);
                    }
            }
        }
        int i2 = f7018c[h2];
        if (i2 == -1) {
            z2 = false;
        }
        e.a(z2);
        return Pair.create(Integer.valueOf(g2), Integer.valueOf(i2));
    }

    public static Pair<Integer, Integer> j(byte[] bArr) {
        return i(new r(bArr), false);
    }

    private static void k(r rVar, int i2, int i3) {
        rVar.p(1);
        if (rVar.g()) {
            rVar.p(14);
        }
        boolean g2 = rVar.g();
        if (i3 != 0) {
            if (i2 == 6 || i2 == 20) {
                rVar.p(3);
            }
            if (g2) {
                if (i2 == 22) {
                    rVar.p(16);
                }
                if (i2 == 17 || i2 == 19 || i2 == 20 || i2 == 23) {
                    rVar.p(3);
                }
                rVar.p(1);
                return;
            }
            return;
        }
        throw new UnsupportedOperationException();
    }

    public static byte[][] l(byte[] bArr) {
        if (!h(bArr, 0)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        do {
            arrayList.add(Integer.valueOf(i2));
            i2 = e(bArr, i2 + f7016a.length);
        } while (i2 != -1);
        byte[][] bArr2 = new byte[arrayList.size()][];
        int i3 = 0;
        while (i3 < arrayList.size()) {
            int intValue = ((Integer) arrayList.get(i3)).intValue();
            int intValue2 = (i3 < arrayList.size() + -1 ? ((Integer) arrayList.get(i3 + 1)).intValue() : bArr.length) - intValue;
            byte[] bArr3 = new byte[intValue2];
            System.arraycopy(bArr, intValue, bArr3, 0, intValue2);
            bArr2[i3] = bArr3;
            i3++;
        }
        return bArr2;
    }
}
