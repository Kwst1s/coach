package com.google.android.exoplayer2.e0;

/* compiled from: MpegAudioHeader */
public final class m {

    /* renamed from: h  reason: collision with root package name */
    private static final String[] f5084h = {"audio/mpeg-L1", "audio/mpeg-L2", "audio/mpeg"};

    /* renamed from: i  reason: collision with root package name */
    private static final int[] f5085i = {44100, 48000, 32000};

    /* renamed from: j  reason: collision with root package name */
    private static final int[] f5086j = {32, 64, 96, 128, 160, 192, 224, 256, 288, 320, 352, 384, 416, 448};

    /* renamed from: k  reason: collision with root package name */
    private static final int[] f5087k = {32, 48, 56, 64, 80, 96, 112, 128, 144, 160, 176, 192, 224, 256};
    private static final int[] l = {32, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, 384};
    private static final int[] m = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320};
    private static final int[] n = {8, 16, 24, 32, 40, 48, 56, 64, 80, 96, 112, 128, 144, 160};

    /* renamed from: a  reason: collision with root package name */
    public int f5088a;

    /* renamed from: b  reason: collision with root package name */
    public String f5089b;

    /* renamed from: c  reason: collision with root package name */
    public int f5090c;

    /* renamed from: d  reason: collision with root package name */
    public int f5091d;

    /* renamed from: e  reason: collision with root package name */
    public int f5092e;

    /* renamed from: f  reason: collision with root package name */
    public int f5093f;

    /* renamed from: g  reason: collision with root package name */
    public int f5094g;

    public static int a(int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        if ((i2 & -2097152) != -2097152 || (i3 = (i2 >>> 19) & 3) == 1 || (i4 = (i2 >>> 17) & 3) == 0 || (i5 = (i2 >>> 12) & 15) == 0 || i5 == 15 || (i6 = (i2 >>> 10) & 3) == 3) {
            return -1;
        }
        int i8 = f5085i[i6];
        if (i3 == 2) {
            i8 /= 2;
        } else if (i3 == 0) {
            i8 /= 4;
        }
        int i9 = (i2 >>> 9) & 1;
        if (i4 == 3) {
            return ((((i3 == 3 ? f5086j[i5 - 1] : f5087k[i5 - 1]) * 12000) / i8) + i9) * 4;
        }
        if (i3 == 3) {
            i7 = i4 == 2 ? l[i5 - 1] : m[i5 - 1];
        } else {
            i7 = n[i5 - 1];
        }
        int i10 = 144000;
        if (i3 == 3) {
            return ((i7 * 144000) / i8) + i9;
        }
        if (i4 == 1) {
            i10 = 72000;
        }
        return ((i10 * i7) / i8) + i9;
    }

    public static boolean b(int i2, m mVar) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        if ((i2 & -2097152) != -2097152 || (i3 = (i2 >>> 19) & 3) == 1 || (i4 = (i2 >>> 17) & 3) == 0 || (i5 = (i2 >>> 12) & 15) == 0 || i5 == 15 || (i6 = (i2 >>> 10) & 3) == 3) {
            return false;
        }
        int i10 = f5085i[i6];
        if (i3 == 2) {
            i10 /= 2;
        } else if (i3 == 0) {
            i10 /= 4;
        }
        int i11 = (i2 >>> 9) & 1;
        int i12 = 1152;
        if (i4 == 3) {
            i9 = i3 == 3 ? f5086j[i5 - 1] : f5087k[i5 - 1];
            i8 = (((i9 * 12000) / i10) + i11) * 4;
            i7 = 384;
        } else {
            int i13 = 144000;
            if (i3 == 3) {
                i9 = i4 == 2 ? l[i5 - 1] : m[i5 - 1];
                i8 = ((144000 * i9) / i10) + i11;
                i7 = 1152;
            } else {
                i9 = n[i5 - 1];
                if (i4 == 1) {
                    i12 = 576;
                }
                if (i4 == 1) {
                    i13 = 72000;
                }
                i8 = ((i13 * i9) / i10) + i11;
                i7 = i12;
            }
        }
        mVar.c(i3, f5084h[3 - i4], i8, i10, ((i2 >> 6) & 3) == 3 ? 1 : 2, i9 * 1000, i7);
        return true;
    }

    private void c(int i2, String str, int i3, int i4, int i5, int i6, int i7) {
        this.f5088a = i2;
        this.f5089b = str;
        this.f5090c = i3;
        this.f5091d = i4;
        this.f5092e = i5;
        this.f5093f = i6;
        this.f5094g = i7;
    }
}
