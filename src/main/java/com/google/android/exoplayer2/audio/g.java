package com.google.android.exoplayer2.audio;

import androidx.constraintlayout.widget.i;
import b.a.j;
import com.google.android.exoplayer2.l;
import com.google.android.exoplayer2.util.r;
import com.google.android.exoplayer2.util.s;
import java.nio.ByteBuffer;

/* compiled from: Ac3Util */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f4767a = {1, 2, 3, 6};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f4768b = {48000, 44100, 32000};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f4769c = {24000, 22050, 16000};

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f4770d = {2, 1, 2, 3, 3, 4, 4, 5};

    /* renamed from: e  reason: collision with root package name */
    private static final int[] f4771e = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, 384, 448, 512, 576, 640};

    /* renamed from: f  reason: collision with root package name */
    private static final int[] f4772f = {69, 87, i.E0, j.F0, 139, 174, 208, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    /* compiled from: Ac3Util */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final String f4773a;

        /* renamed from: b  reason: collision with root package name */
        public final int f4774b;

        /* renamed from: c  reason: collision with root package name */
        public final int f4775c;

        /* renamed from: d  reason: collision with root package name */
        public final int f4776d;

        /* renamed from: e  reason: collision with root package name */
        public final int f4777e;

        private b(String str, int i2, int i3, int i4, int i5, int i6) {
            this.f4773a = str;
            this.f4775c = i3;
            this.f4774b = i4;
            this.f4776d = i5;
            this.f4777e = i6;
        }
    }

    public static int a(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit() - 10;
        for (int i2 = position; i2 <= limit; i2++) {
            if ((byteBuffer.getInt(i2 + 4) & -16777217) == -1167101192) {
                return i2 - position;
            }
        }
        return -1;
    }

    public static int b() {
        return 1536;
    }

    private static int c(int i2, int i3) {
        int i4 = i3 / 2;
        if (i2 < 0) {
            return -1;
        }
        int[] iArr = f4768b;
        if (i2 >= iArr.length || i3 < 0) {
            return -1;
        }
        int[] iArr2 = f4772f;
        if (i4 >= iArr2.length) {
            return -1;
        }
        int i5 = iArr[i2];
        if (i5 == 44100) {
            return (iArr2[i4] + (i3 % 2)) * 2;
        }
        int i6 = f4771e[i4];
        return i5 == 32000 ? i6 * 6 : i6 * 4;
    }

    public static l d(s sVar, String str, String str2, com.google.android.exoplayer2.drm.l lVar) {
        int i2 = f4768b[(sVar.y() & 192) >> 6];
        int y = sVar.y();
        int i3 = f4770d[(y & 56) >> 3];
        if ((y & 4) != 0) {
            i3++;
        }
        return l.t(str, "audio/ac3", null, -1, -1, i3, i2, null, lVar, 0, str2);
    }

    public static b e(r rVar) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        String str;
        int i7;
        int i8;
        int i9;
        int i10;
        int e2 = rVar.e();
        rVar.p(40);
        boolean z = rVar.h(5) == 16;
        rVar.n(e2);
        int i11 = -1;
        if (z) {
            rVar.p(16);
            int h2 = rVar.h(2);
            if (h2 == 0) {
                i11 = 0;
            } else if (h2 == 1) {
                i11 = 1;
            } else if (h2 == 2) {
                i11 = 2;
            }
            rVar.p(3);
            int h3 = (rVar.h(11) + 1) * 2;
            int h4 = rVar.h(2);
            if (h4 == 3) {
                i7 = f4769c[rVar.h(2)];
                i9 = 3;
                i8 = 6;
            } else {
                i9 = rVar.h(2);
                i8 = f4767a[i9];
                i7 = f4768b[h4];
            }
            int i12 = i8 * 256;
            int h5 = rVar.h(3);
            boolean g2 = rVar.g();
            int i13 = f4770d[h5] + (g2 ? 1 : 0);
            rVar.p(10);
            if (rVar.g()) {
                rVar.p(8);
            }
            if (h5 == 0) {
                rVar.p(5);
                if (rVar.g()) {
                    rVar.p(8);
                }
            }
            if (i11 == 1 && rVar.g()) {
                rVar.p(16);
            }
            if (rVar.g()) {
                if (h5 > 2) {
                    rVar.p(2);
                }
                if ((h5 & 1) != 0 && h5 > 2) {
                    rVar.p(6);
                }
                if ((h5 & 4) != 0) {
                    rVar.p(6);
                }
                if (g2 && rVar.g()) {
                    rVar.p(5);
                }
                if (i11 == 0) {
                    if (rVar.g()) {
                        rVar.p(6);
                    }
                    if (h5 == 0 && rVar.g()) {
                        rVar.p(6);
                    }
                    if (rVar.g()) {
                        rVar.p(6);
                    }
                    int h6 = rVar.h(2);
                    if (h6 == 1) {
                        rVar.p(5);
                    } else if (h6 == 2) {
                        rVar.p(12);
                    } else if (h6 == 3) {
                        int h7 = rVar.h(5);
                        if (rVar.g()) {
                            rVar.p(5);
                            if (rVar.g()) {
                                rVar.p(4);
                            }
                            if (rVar.g()) {
                                rVar.p(4);
                            }
                            if (rVar.g()) {
                                rVar.p(4);
                            }
                            if (rVar.g()) {
                                rVar.p(4);
                            }
                            if (rVar.g()) {
                                rVar.p(4);
                            }
                            if (rVar.g()) {
                                rVar.p(4);
                            }
                            if (rVar.g()) {
                                rVar.p(4);
                            }
                            if (rVar.g()) {
                                if (rVar.g()) {
                                    rVar.p(4);
                                }
                                if (rVar.g()) {
                                    rVar.p(4);
                                }
                            }
                        }
                        if (rVar.g()) {
                            rVar.p(5);
                            if (rVar.g()) {
                                rVar.p(7);
                                if (rVar.g()) {
                                    rVar.p(8);
                                }
                            }
                        }
                        rVar.p((h7 + 2) * 8);
                        rVar.c();
                    }
                    if (h5 < 2) {
                        if (rVar.g()) {
                            rVar.p(14);
                        }
                        if (h5 == 0 && rVar.g()) {
                            rVar.p(14);
                        }
                    }
                    if (rVar.g()) {
                        if (i9 == 0) {
                            rVar.p(5);
                        } else {
                            for (int i14 = 0; i14 < i8; i14++) {
                                if (rVar.g()) {
                                    rVar.p(5);
                                }
                            }
                        }
                    }
                }
            }
            if (rVar.g()) {
                rVar.p(5);
                if (h5 == 2) {
                    rVar.p(4);
                }
                if (h5 >= 6) {
                    rVar.p(2);
                }
                if (rVar.g()) {
                    rVar.p(8);
                }
                if (h5 == 0 && rVar.g()) {
                    rVar.p(8);
                }
                i10 = 3;
                if (h4 < 3) {
                    rVar.o();
                }
            } else {
                i10 = 3;
            }
            if (i11 == 0 && i9 != i10) {
                rVar.o();
            }
            if (i11 == 2 && (i9 == i10 || rVar.g())) {
                rVar.p(6);
            }
            str = (rVar.g() && rVar.h(6) == 1 && rVar.h(8) == 1) ? "audio/eac3-joc" : "audio/eac3";
            i6 = i11;
            i3 = h3;
            i4 = i7;
            i2 = i12;
            i5 = i13;
        } else {
            rVar.p(32);
            int h8 = rVar.h(2);
            int c2 = c(h8, rVar.h(6));
            rVar.p(8);
            int h9 = rVar.h(3);
            if (!((h9 & 1) == 0 || h9 == 1)) {
                rVar.p(2);
            }
            if ((h9 & 4) != 0) {
                rVar.p(2);
            }
            if (h9 == 2) {
                rVar.p(2);
            }
            str = "audio/ac3";
            i3 = c2;
            i4 = f4768b[h8];
            i5 = f4770d[h9] + (rVar.g() ? 1 : 0);
            i6 = -1;
            i2 = 1536;
        }
        return new b(str, i6, i5, i4, i3, i2);
    }

    public static int f(byte[] bArr) {
        if (bArr.length < 6) {
            return -1;
        }
        if (!(((bArr[5] & 255) >> 3) == 16)) {
            return c((bArr[4] & 192) >> 6, bArr[4] & 63);
        }
        return (((bArr[3] & 255) | ((bArr[2] & 7) << 8)) + 1) * 2;
    }

    public static l g(s sVar, String str, String str2, com.google.android.exoplayer2.drm.l lVar) {
        sVar.L(2);
        int i2 = f4768b[(sVar.y() & 192) >> 6];
        int y = sVar.y();
        int i3 = f4770d[(y & 14) >> 1];
        if ((y & 1) != 0) {
            i3++;
        }
        if (((sVar.y() & 30) >> 1) > 0 && (2 & sVar.y()) != 0) {
            i3 += 2;
        }
        return l.t(str, (sVar.a() <= 0 || (sVar.y() & 1) == 0) ? "audio/eac3" : "audio/eac3-joc", null, -1, -1, i3, i2, null, lVar, 0, str2);
    }

    public static int h(ByteBuffer byteBuffer) {
        int i2 = 6;
        if (((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3) {
            i2 = f4767a[(byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4];
        }
        return i2 * 256;
    }

    public static int i(ByteBuffer byteBuffer, int i2) {
        return 40 << ((byteBuffer.get((byteBuffer.position() + i2) + ((byteBuffer.get((byteBuffer.position() + i2) + 7) & 255) == 187 ? 9 : 8)) >> 4) & 7);
    }

    public static int j(byte[] bArr) {
        boolean z = false;
        if (bArr[4] != -8 || bArr[5] != 114 || bArr[6] != 111 || (bArr[7] & 254) != 186) {
            return 0;
        }
        if ((bArr[7] & 255) == 187) {
            z = true;
        }
        return 40 << ((bArr[z ? (char) '\t' : '\b'] >> 4) & 7);
    }
}
