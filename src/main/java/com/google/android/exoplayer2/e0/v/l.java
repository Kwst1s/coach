package com.google.android.exoplayer2.e0.v;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.m;
import com.google.android.exoplayer2.util.s;
import java.util.Arrays;

/* access modifiers changed from: package-private */
/* compiled from: VorbisUtil */
public final class l {

    /* compiled from: VorbisUtil */
    public static final class a {
        public a(int i2, int i3, long[] jArr, int i4, boolean z) {
        }
    }

    /* compiled from: VorbisUtil */
    public static final class b {
        public b(String str, String[] strArr, int i2) {
        }
    }

    /* compiled from: VorbisUtil */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f5388a;

        public c(boolean z, int i2, int i3, int i4) {
            this.f5388a = z;
        }
    }

    /* compiled from: VorbisUtil */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public final int f5389a;

        /* renamed from: b  reason: collision with root package name */
        public final long f5390b;

        /* renamed from: c  reason: collision with root package name */
        public final int f5391c;

        /* renamed from: d  reason: collision with root package name */
        public final int f5392d;

        /* renamed from: e  reason: collision with root package name */
        public final int f5393e;

        /* renamed from: f  reason: collision with root package name */
        public final byte[] f5394f;

        public d(long j2, int i2, long j3, int i3, int i4, int i5, int i6, int i7, boolean z, byte[] bArr) {
            this.f5389a = i2;
            this.f5390b = j3;
            this.f5391c = i4;
            this.f5392d = i6;
            this.f5393e = i7;
            this.f5394f = bArr;
        }
    }

    public static int a(int i2) {
        int i3 = 0;
        while (i2 > 0) {
            i3++;
            i2 >>>= 1;
        }
        return i3;
    }

    private static long b(long j2, long j3) {
        double d2 = (double) j3;
        Double.isNaN(d2);
        return (long) Math.floor(Math.pow((double) j2, 1.0d / d2));
    }

    private static a c(j jVar) {
        if (jVar.d(24) == 5653314) {
            int d2 = jVar.d(16);
            int d3 = jVar.d(24);
            long[] jArr = new long[d3];
            boolean c2 = jVar.c();
            long j2 = 0;
            if (!c2) {
                boolean c3 = jVar.c();
                for (int i2 = 0; i2 < d3; i2++) {
                    if (!c3) {
                        jArr[i2] = (long) (jVar.d(5) + 1);
                    } else if (jVar.c()) {
                        jArr[i2] = (long) (jVar.d(5) + 1);
                    } else {
                        jArr[i2] = 0;
                    }
                }
            } else {
                int d4 = jVar.d(5) + 1;
                int i3 = 0;
                while (i3 < d3) {
                    int d5 = jVar.d(a(d3 - i3));
                    for (int i4 = 0; i4 < d5 && i3 < d3; i4++) {
                        jArr[i3] = (long) d4;
                        i3++;
                    }
                    d4++;
                }
            }
            int d6 = jVar.d(4);
            if (d6 <= 2) {
                if (d6 == 1 || d6 == 2) {
                    jVar.e(32);
                    jVar.e(32);
                    int d7 = jVar.d(4) + 1;
                    jVar.e(1);
                    if (d6 != 1) {
                        j2 = ((long) d3) * ((long) d2);
                    } else if (d2 != 0) {
                        j2 = b((long) d3, (long) d2);
                    }
                    jVar.e((int) (j2 * ((long) d7)));
                }
                return new a(d2, d3, jArr, d6, c2);
            }
            throw new ParserException("lookup type greater than 2 not decodable: " + d6);
        }
        throw new ParserException("expected code book to start with [0x56, 0x43, 0x42] at " + jVar.b());
    }

    private static void d(j jVar) {
        int d2 = jVar.d(6) + 1;
        for (int i2 = 0; i2 < d2; i2++) {
            int d3 = jVar.d(16);
            if (d3 == 0) {
                jVar.e(8);
                jVar.e(16);
                jVar.e(16);
                jVar.e(6);
                jVar.e(8);
                int d4 = jVar.d(4) + 1;
                for (int i3 = 0; i3 < d4; i3++) {
                    jVar.e(8);
                }
            } else if (d3 == 1) {
                int d5 = jVar.d(5);
                int i4 = -1;
                int[] iArr = new int[d5];
                for (int i5 = 0; i5 < d5; i5++) {
                    iArr[i5] = jVar.d(4);
                    if (iArr[i5] > i4) {
                        i4 = iArr[i5];
                    }
                }
                int i6 = i4 + 1;
                int[] iArr2 = new int[i6];
                for (int i7 = 0; i7 < i6; i7++) {
                    iArr2[i7] = jVar.d(3) + 1;
                    int d6 = jVar.d(2);
                    if (d6 > 0) {
                        jVar.e(8);
                    }
                    for (int i8 = 0; i8 < (1 << d6); i8++) {
                        jVar.e(8);
                    }
                }
                jVar.e(2);
                int d7 = jVar.d(4);
                int i9 = 0;
                int i10 = 0;
                for (int i11 = 0; i11 < d5; i11++) {
                    i9 += iArr2[iArr[i11]];
                    while (i10 < i9) {
                        jVar.e(d7);
                        i10++;
                    }
                }
            } else {
                throw new ParserException("floor type greater than 1 not decodable: " + d3);
            }
        }
    }

    private static void e(int i2, j jVar) {
        int d2 = jVar.d(6) + 1;
        for (int i3 = 0; i3 < d2; i3++) {
            int d3 = jVar.d(16);
            if (d3 != 0) {
                m.c("VorbisUtil", "mapping type other than 0 not supported: " + d3);
            } else {
                int d4 = jVar.c() ? jVar.d(4) + 1 : 1;
                if (jVar.c()) {
                    int d5 = jVar.d(8) + 1;
                    for (int i4 = 0; i4 < d5; i4++) {
                        int i5 = i2 - 1;
                        jVar.e(a(i5));
                        jVar.e(a(i5));
                    }
                }
                if (jVar.d(2) == 0) {
                    if (d4 > 1) {
                        for (int i6 = 0; i6 < i2; i6++) {
                            jVar.e(4);
                        }
                    }
                    for (int i7 = 0; i7 < d4; i7++) {
                        jVar.e(8);
                        jVar.e(8);
                        jVar.e(8);
                    }
                } else {
                    throw new ParserException("to reserved bits must be zero after mapping coupling steps");
                }
            }
        }
    }

    private static c[] f(j jVar) {
        int d2 = jVar.d(6) + 1;
        c[] cVarArr = new c[d2];
        for (int i2 = 0; i2 < d2; i2++) {
            cVarArr[i2] = new c(jVar.c(), jVar.d(16), jVar.d(16), jVar.d(8));
        }
        return cVarArr;
    }

    private static void g(j jVar) {
        int d2 = jVar.d(6) + 1;
        for (int i2 = 0; i2 < d2; i2++) {
            if (jVar.d(16) <= 2) {
                jVar.e(24);
                jVar.e(24);
                jVar.e(24);
                int d3 = jVar.d(6) + 1;
                jVar.e(8);
                int[] iArr = new int[d3];
                for (int i3 = 0; i3 < d3; i3++) {
                    iArr[i3] = ((jVar.c() ? jVar.d(5) : 0) * 8) + jVar.d(3);
                }
                for (int i4 = 0; i4 < d3; i4++) {
                    for (int i5 = 0; i5 < 8; i5++) {
                        if ((iArr[i4] & (1 << i5)) != 0) {
                            jVar.e(8);
                        }
                    }
                }
            } else {
                throw new ParserException("residueType greater than 2 is not decodable");
            }
        }
    }

    public static b h(s sVar) {
        k(3, sVar, false);
        String v = sVar.v((int) sVar.o());
        int length = 11 + v.length();
        long o = sVar.o();
        String[] strArr = new String[((int) o)];
        int i2 = length + 4;
        for (int i3 = 0; ((long) i3) < o; i3++) {
            strArr[i3] = sVar.v((int) sVar.o());
            i2 = i2 + 4 + strArr[i3].length();
        }
        if ((sVar.y() & 1) != 0) {
            return new b(v, strArr, i2 + 1);
        }
        throw new ParserException("framing bit expected to be set");
    }

    public static d i(s sVar) {
        k(1, sVar, false);
        long o = sVar.o();
        int y = sVar.y();
        long o2 = sVar.o();
        int m = sVar.m();
        int m2 = sVar.m();
        int m3 = sVar.m();
        int y2 = sVar.y();
        return new d(o, y, o2, m, m2, m3, (int) Math.pow(2.0d, (double) (y2 & 15)), (int) Math.pow(2.0d, (double) ((y2 & 240) >> 4)), (sVar.y() & 1) > 0, Arrays.copyOf(sVar.f7062a, sVar.d()));
    }

    public static c[] j(s sVar, int i2) {
        k(5, sVar, false);
        int y = sVar.y() + 1;
        j jVar = new j(sVar.f7062a);
        jVar.e(sVar.c() * 8);
        for (int i3 = 0; i3 < y; i3++) {
            c(jVar);
        }
        int d2 = jVar.d(6) + 1;
        for (int i4 = 0; i4 < d2; i4++) {
            if (jVar.d(16) != 0) {
                throw new ParserException("placeholder of time domain transforms not zeroed out");
            }
        }
        d(jVar);
        g(jVar);
        e(i2, jVar);
        c[] f2 = f(jVar);
        if (jVar.c()) {
            return f2;
        }
        throw new ParserException("framing bit after modes not set as expected");
    }

    public static boolean k(int i2, s sVar, boolean z) {
        if (sVar.a() < 7) {
            if (z) {
                return false;
            }
            throw new ParserException("too short header: " + sVar.a());
        } else if (sVar.y() != i2) {
            if (z) {
                return false;
            }
            throw new ParserException("expected header type " + Integer.toHexString(i2));
        } else if (sVar.y() == 118 && sVar.y() == 111 && sVar.y() == 114 && sVar.y() == 98 && sVar.y() == 105 && sVar.y() == 115) {
            return true;
        } else {
            if (z) {
                return false;
            }
            throw new ParserException("expected characters 'vorbis'");
        }
    }
}
