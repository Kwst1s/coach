package com.google.android.exoplayer2.h0;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.q;
import com.google.android.exoplayer2.util.s;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AvcConfig */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    public final List<byte[]> f5877a;

    /* renamed from: b  reason: collision with root package name */
    public final int f5878b;

    /* renamed from: c  reason: collision with root package name */
    public final int f5879c;

    /* renamed from: d  reason: collision with root package name */
    public final int f5880d;

    /* renamed from: e  reason: collision with root package name */
    public final float f5881e;

    private h(List<byte[]> list, int i2, int i3, int i4, float f2) {
        this.f5877a = list;
        this.f5878b = i2;
        this.f5879c = i3;
        this.f5880d = i4;
        this.f5881e = f2;
    }

    private static byte[] a(s sVar) {
        int E = sVar.E();
        int c2 = sVar.c();
        sVar.L(E);
        return g.d(sVar.f7062a, c2, E);
    }

    public static h b(s sVar) {
        float f2;
        int i2;
        int i3;
        try {
            sVar.L(4);
            int y = (sVar.y() & 3) + 1;
            if (y != 3) {
                ArrayList arrayList = new ArrayList();
                int y2 = sVar.y() & 31;
                for (int i4 = 0; i4 < y2; i4++) {
                    arrayList.add(a(sVar));
                }
                int y3 = sVar.y();
                for (int i5 = 0; i5 < y3; i5++) {
                    arrayList.add(a(sVar));
                }
                if (y2 > 0) {
                    q.b i6 = q.i((byte[]) arrayList.get(0), y, ((byte[]) arrayList.get(0)).length);
                    int i7 = i6.f7051e;
                    int i8 = i6.f7052f;
                    f2 = i6.f7053g;
                    i3 = i7;
                    i2 = i8;
                } else {
                    i3 = -1;
                    i2 = -1;
                    f2 = 1.0f;
                }
                return new h(arrayList, y, i3, i2, f2);
            }
            throw new IllegalStateException();
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw new ParserException("Error parsing AVC config", e2);
        }
    }
}
