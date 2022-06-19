package com.google.android.exoplayer2.f0.g;

import com.google.android.exoplayer2.f0.a;
import com.google.android.exoplayer2.f0.d;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.e;
import com.google.android.exoplayer2.util.s;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* compiled from: EventMessageDecoder */
public final class b implements com.google.android.exoplayer2.f0.b {
    @Override // com.google.android.exoplayer2.f0.b
    public a a(d dVar) {
        ByteBuffer byteBuffer = dVar.f4951d;
        byte[] array = byteBuffer.array();
        int limit = byteBuffer.limit();
        s sVar = new s(array, limit);
        String s = sVar.s();
        e.e(s);
        String str = s;
        String s2 = sVar.s();
        e.e(s2);
        String str2 = s2;
        long A = sVar.A();
        long Z = d0.Z(sVar.A(), 1000000, A);
        return new a(new a(str, str2, d0.Z(sVar.A(), 1000, A), sVar.A(), Arrays.copyOfRange(array, sVar.c(), limit), Z));
    }
}
