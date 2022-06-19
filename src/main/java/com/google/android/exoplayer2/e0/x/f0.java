package com.google.android.exoplayer2.e0.x;

import com.google.android.exoplayer2.util.s;

/* compiled from: TsUtil */
public final class f0 {
    public static int a(byte[] bArr, int i2, int i3) {
        while (i2 < i3 && bArr[i2] != 71) {
            i2++;
        }
        return i2;
    }

    public static long b(s sVar, int i2, int i3) {
        sVar.K(i2);
        if (sVar.a() < 5) {
            return -9223372036854775807L;
        }
        int j2 = sVar.j();
        if ((8388608 & j2) != 0 || ((2096896 & j2) >> 8) != i3) {
            return -9223372036854775807L;
        }
        boolean z = true;
        if (((j2 & 32) != 0) && sVar.y() >= 7 && sVar.a() >= 7) {
            if ((sVar.y() & 16) != 16) {
                z = false;
            }
            if (z) {
                byte[] bArr = new byte[6];
                sVar.h(bArr, 0, 6);
                return c(bArr);
            }
        }
        return -9223372036854775807L;
    }

    private static long c(byte[] bArr) {
        return ((((long) bArr[0]) & 255) << 25) | ((((long) bArr[1]) & 255) << 17) | ((((long) bArr[2]) & 255) << 9) | ((((long) bArr[3]) & 255) << 1) | ((255 & ((long) bArr[4])) >> 7);
    }
}
