package com.google.android.exoplayer2.util;

import java.nio.ByteBuffer;
import java.util.Arrays;

/* compiled from: NalUnitUtil */
public final class q {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f7040a = {0, 0, 0, 1};

    /* renamed from: b  reason: collision with root package name */
    public static final float[] f7041b = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};

    /* renamed from: c  reason: collision with root package name */
    private static final Object f7042c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private static int[] f7043d = new int[10];

    /* compiled from: NalUnitUtil */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f7044a;

        /* renamed from: b  reason: collision with root package name */
        public final int f7045b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f7046c;

        public a(int i2, int i3, boolean z) {
            this.f7044a = i2;
            this.f7045b = i3;
            this.f7046c = z;
        }
    }

    /* compiled from: NalUnitUtil */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f7047a;

        /* renamed from: b  reason: collision with root package name */
        public final int f7048b;

        /* renamed from: c  reason: collision with root package name */
        public final int f7049c;

        /* renamed from: d  reason: collision with root package name */
        public final int f7050d;

        /* renamed from: e  reason: collision with root package name */
        public final int f7051e;

        /* renamed from: f  reason: collision with root package name */
        public final int f7052f;

        /* renamed from: g  reason: collision with root package name */
        public final float f7053g;

        /* renamed from: h  reason: collision with root package name */
        public final boolean f7054h;

        /* renamed from: i  reason: collision with root package name */
        public final boolean f7055i;

        /* renamed from: j  reason: collision with root package name */
        public final int f7056j;

        /* renamed from: k  reason: collision with root package name */
        public final int f7057k;
        public final int l;
        public final boolean m;

        public b(int i2, int i3, int i4, int i5, int i6, int i7, float f2, boolean z, boolean z2, int i8, int i9, int i10, boolean z3) {
            this.f7047a = i2;
            this.f7048b = i3;
            this.f7049c = i4;
            this.f7050d = i5;
            this.f7051e = i6;
            this.f7052f = i7;
            this.f7053g = f2;
            this.f7054h = z;
            this.f7055i = z2;
            this.f7056j = i8;
            this.f7057k = i9;
            this.l = i10;
            this.m = z3;
        }
    }

    public static void a(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }

    public static void b(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = i2 + 1;
            if (i4 < position) {
                int i5 = byteBuffer.get(i2) & 255;
                if (i3 == 3) {
                    if (i5 == 1 && (byteBuffer.get(i4) & 31) == 7) {
                        ByteBuffer duplicate = byteBuffer.duplicate();
                        duplicate.position(i2 - 3);
                        duplicate.limit(position);
                        byteBuffer.position(0);
                        byteBuffer.put(duplicate);
                        return;
                    }
                } else if (i5 == 0) {
                    i3++;
                }
                if (i5 != 0) {
                    i3 = 0;
                }
                i2 = i4;
            } else {
                byteBuffer.clear();
                return;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0097, code lost:
        r8 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int c(byte[] r7, int r8, int r9, boolean[] r10) {
        /*
        // Method dump skipped, instructions count: 188
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.util.q.c(byte[], int, int, boolean[]):int");
    }

    private static int d(byte[] bArr, int i2, int i3) {
        while (i2 < i3 - 2) {
            if (bArr[i2] == 0 && bArr[i2 + 1] == 0 && bArr[i2 + 2] == 3) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static int e(byte[] bArr, int i2) {
        return (bArr[i2 + 3] & 126) >> 1;
    }

    public static int f(byte[] bArr, int i2) {
        return bArr[i2 + 3] & 31;
    }

    public static boolean g(String str, byte b2) {
        if ("video/avc".equals(str) && (b2 & 31) == 6) {
            return true;
        }
        if (!"video/hevc".equals(str) || ((b2 & 126) >> 1) != 39) {
            return false;
        }
        return true;
    }

    public static a h(byte[] bArr, int i2, int i3) {
        t tVar = new t(bArr, i2, i3);
        tVar.l(8);
        int h2 = tVar.h();
        int h3 = tVar.h();
        tVar.k();
        return new a(h2, h3, tVar.d());
    }

    /* JADX WARN: Type inference failed for: r16v0, types: [int, boolean] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0136  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0149  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.exoplayer2.util.q.b i(byte[] r21, int r22, int r23) {
        /*
        // Method dump skipped, instructions count: 372
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.util.q.i(byte[], int, int):com.google.android.exoplayer2.util.q$b");
    }

    private static void j(t tVar, int i2) {
        int i3 = 8;
        int i4 = 8;
        for (int i5 = 0; i5 < i2; i5++) {
            if (i3 != 0) {
                i3 = ((tVar.g() + i4) + 256) % 256;
            }
            if (i3 != 0) {
                i4 = i3;
            }
        }
    }

    public static int k(byte[] bArr, int i2) {
        int i3;
        synchronized (f7042c) {
            int i4 = 0;
            int i5 = 0;
            while (i4 < i2) {
                try {
                    i4 = d(bArr, i4, i2);
                    if (i4 < i2) {
                        int[] iArr = f7043d;
                        if (iArr.length <= i5) {
                            f7043d = Arrays.copyOf(iArr, iArr.length * 2);
                        }
                        f7043d[i5] = i4;
                        i4 += 3;
                        i5++;
                    }
                } finally {
                }
            }
            i3 = i2 - i5;
            int i6 = 0;
            int i7 = 0;
            for (int i8 = 0; i8 < i5; i8++) {
                int i9 = f7043d[i8] - i7;
                System.arraycopy(bArr, i7, bArr, i6, i9);
                int i10 = i6 + i9;
                int i11 = i10 + 1;
                bArr[i10] = 0;
                i6 = i11 + 1;
                bArr[i11] = 0;
                i7 += i9 + 3;
            }
            System.arraycopy(bArr, i7, bArr, i6, i3 - i6);
        }
        return i3;
    }
}
