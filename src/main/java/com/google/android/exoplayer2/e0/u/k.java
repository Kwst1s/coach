package com.google.android.exoplayer2.e0.u;

import com.google.android.exoplayer2.e0.h;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.s;

/* compiled from: Sniffer */
final class k {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f5296a = {d0.B("isom"), d0.B("iso2"), d0.B("iso3"), d0.B("iso4"), d0.B("iso5"), d0.B("iso6"), d0.B("avc1"), d0.B("hvc1"), d0.B("hev1"), d0.B("mp41"), d0.B("mp42"), d0.B("3g2a"), d0.B("3g2b"), d0.B("3gr6"), d0.B("3gs6"), d0.B("3ge6"), d0.B("3gg6"), d0.B("M4V "), d0.B("M4A "), d0.B("f4v "), d0.B("kddi"), d0.B("M4VP"), d0.B("qt  "), d0.B("MSNV")};

    private static boolean a(int i2) {
        if ((i2 >>> 8) == d0.B("3gp")) {
            return true;
        }
        for (int i3 : f5296a) {
            if (i3 == i2) {
                return true;
            }
        }
        return false;
    }

    public static boolean b(h hVar) {
        return c(hVar, true);
    }

    private static boolean c(h hVar, boolean z) {
        boolean z2;
        long d2 = hVar.d();
        long j2 = -1;
        if (d2 == -1 || d2 > 4096) {
            d2 = 4096;
        }
        int i2 = (int) d2;
        s sVar = new s(64);
        int i3 = 0;
        boolean z3 = false;
        while (true) {
            if (i3 >= i2) {
                break;
            }
            sVar.H(8);
            hVar.j(sVar.f7062a, 0, 8);
            long A = sVar.A();
            int j3 = sVar.j();
            int i4 = 16;
            if (A == 1) {
                hVar.j(sVar.f7062a, 8, 8);
                sVar.J(16);
                A = sVar.D();
            } else {
                if (A == 0) {
                    long d3 = hVar.d();
                    if (d3 != j2) {
                        A = ((long) 8) + (d3 - hVar.l());
                    }
                }
                i4 = 8;
            }
            long j4 = (long) i4;
            if (A < j4) {
                return false;
            }
            i3 += i4;
            if (j3 != c.C) {
                if (j3 == c.L || j3 == c.N) {
                    z2 = true;
                } else if ((((long) i3) + A) - j4 >= ((long) i2)) {
                    break;
                } else {
                    int i5 = (int) (A - j4);
                    i3 += i5;
                    if (j3 == c.f5192b) {
                        if (i5 < 8) {
                            return false;
                        }
                        sVar.H(i5);
                        hVar.j(sVar.f7062a, 0, i5);
                        int i6 = i5 / 4;
                        int i7 = 0;
                        while (true) {
                            if (i7 >= i6) {
                                break;
                            }
                            if (i7 == 1) {
                                sVar.L(4);
                            } else if (a(sVar.j())) {
                                z3 = true;
                                break;
                            }
                            i7++;
                        }
                        if (!z3) {
                            return false;
                        }
                    } else if (i5 != 0) {
                        hVar.k(i5);
                    }
                    j2 = -1;
                }
            }
        }
        z2 = false;
        if (!z3 || z != z2) {
            return false;
        }
        return true;
    }

    public static boolean d(h hVar) {
        return c(hVar, false);
    }
}
