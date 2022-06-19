package com.google.android.exoplayer2.h0;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.q;
import com.google.android.exoplayer2.util.s;
import java.util.Collections;
import java.util.List;

/* compiled from: HevcConfig */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public final List<byte[]> f5896a;

    /* renamed from: b  reason: collision with root package name */
    public final int f5897b;

    private k(List<byte[]> list, int i2) {
        this.f5896a = list;
        this.f5897b = i2;
    }

    public static k a(s sVar) {
        List list;
        try {
            sVar.L(21);
            int y = sVar.y() & 3;
            int y2 = sVar.y();
            int c2 = sVar.c();
            int i2 = 0;
            for (int i3 = 0; i3 < y2; i3++) {
                sVar.L(1);
                int E = sVar.E();
                for (int i4 = 0; i4 < E; i4++) {
                    int E2 = sVar.E();
                    i2 += E2 + 4;
                    sVar.L(E2);
                }
            }
            sVar.K(c2);
            byte[] bArr = new byte[i2];
            int i5 = 0;
            for (int i6 = 0; i6 < y2; i6++) {
                sVar.L(1);
                int E3 = sVar.E();
                for (int i7 = 0; i7 < E3; i7++) {
                    int E4 = sVar.E();
                    byte[] bArr2 = q.f7040a;
                    System.arraycopy(bArr2, 0, bArr, i5, bArr2.length);
                    int length = i5 + bArr2.length;
                    System.arraycopy(sVar.f7062a, sVar.c(), bArr, length, E4);
                    i5 = length + E4;
                    sVar.L(E4);
                }
            }
            if (i2 == 0) {
                list = null;
            } else {
                list = Collections.singletonList(bArr);
            }
            return new k(list, y + 1);
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw new ParserException("Error parsing HEVC config", e2);
        }
    }
}
