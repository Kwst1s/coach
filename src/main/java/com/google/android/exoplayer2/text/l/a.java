package com.google.android.exoplayer2.text.l;

import com.google.android.exoplayer2.text.b;
import com.google.android.exoplayer2.util.s;
import java.util.List;

/* compiled from: DvbDecoder */
public final class a extends b {
    private final b n;

    public a(List<byte[]> list) {
        super("DvbDecoder");
        s sVar = new s(list.get(0));
        this.n = new b(sVar.E(), sVar.E());
    }

    /* access modifiers changed from: protected */
    /* renamed from: C */
    public c z(byte[] bArr, int i2, boolean z) {
        if (z) {
            this.n.r();
        }
        return new c(this.n.b(bArr, i2));
    }
}
