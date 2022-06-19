package com.google.android.exoplayer2.text.k;

import com.google.android.exoplayer2.e0.q;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.m;
import com.google.android.exoplayer2.util.s;

/* compiled from: CeaUtil */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static final int f6710a = d0.B("GA94");

    public static void a(long j2, s sVar, q[] qVarArr) {
        while (true) {
            boolean z = true;
            if (sVar.a() > 1) {
                int c2 = c(sVar);
                int c3 = c(sVar);
                int c4 = sVar.c() + c3;
                if (c3 == -1 || c3 > sVar.a()) {
                    m.f("CeaUtil", "Skipping remainder of malformed SEI NAL unit.");
                    c4 = sVar.d();
                } else if (c2 == 4 && c3 >= 8) {
                    int y = sVar.y();
                    int E = sVar.E();
                    int j3 = E == 49 ? sVar.j() : 0;
                    int y2 = sVar.y();
                    if (E == 47) {
                        sVar.L(1);
                    }
                    boolean z2 = y == 181 && (E == 49 || E == 47) && y2 == 3;
                    if (E == 49) {
                        if (j3 != f6710a) {
                            z = false;
                        }
                        z2 &= z;
                    }
                    if (z2) {
                        b(j2, sVar, qVarArr);
                    }
                }
                sVar.K(c4);
            } else {
                return;
            }
        }
    }

    public static void b(long j2, s sVar, q[] qVarArr) {
        int y = sVar.y();
        if ((y & 64) != 0) {
            sVar.L(1);
            int i2 = (y & 31) * 3;
            int c2 = sVar.c();
            for (q qVar : qVarArr) {
                sVar.K(c2);
                qVar.a(sVar, i2);
                qVar.c(j2, 1, i2, 0, null);
            }
        }
    }

    private static int c(s sVar) {
        int i2 = 0;
        while (sVar.a() != 0) {
            int y = sVar.y();
            i2 += y;
            if (y != 255) {
                return i2;
            }
        }
        return -1;
    }
}
