package com.google.android.exoplayer2.e0;

import com.google.android.exoplayer2.e0.q;
import com.google.android.exoplayer2.l;
import com.google.android.exoplayer2.util.s;
import java.io.EOFException;

/* compiled from: DummyTrackOutput */
public final class f implements q {
    @Override // com.google.android.exoplayer2.e0.q
    public void a(s sVar, int i2) {
        sVar.L(i2);
    }

    @Override // com.google.android.exoplayer2.e0.q
    public int b(h hVar, int i2, boolean z) {
        int b2 = hVar.b(i2);
        if (b2 != -1) {
            return b2;
        }
        if (z) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // com.google.android.exoplayer2.e0.q
    public void c(long j2, int i2, int i3, int i4, q.a aVar) {
    }

    @Override // com.google.android.exoplayer2.e0.q
    public void d(l lVar) {
    }
}
