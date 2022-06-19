package com.google.android.exoplayer2.text;

import com.google.android.exoplayer2.d0.g;
import java.nio.ByteBuffer;

/* compiled from: SimpleSubtitleDecoder */
public abstract class b extends g<g, h, SubtitleDecoderException> implements e {
    protected b(String str) {
        super(new g[2], new h[2]);
        v(1024);
    }

    /* access modifiers changed from: protected */
    /* renamed from: A */
    public final SubtitleDecoderException k(g gVar, h hVar, boolean z) {
        try {
            ByteBuffer byteBuffer = gVar.f4951d;
            hVar.n(gVar.f4952e, z(byteBuffer.array(), byteBuffer.limit(), z), gVar.f6660g);
            hVar.g(Integer.MIN_VALUE);
            return null;
        } catch (SubtitleDecoderException e2) {
            return e2;
        }
    }

    /* access modifiers changed from: protected */
    public final void B(h hVar) {
        super.s(hVar);
    }

    @Override // com.google.android.exoplayer2.text.e
    public void b(long j2) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: w */
    public final g h() {
        return new g();
    }

    /* access modifiers changed from: protected */
    /* renamed from: x */
    public final h i() {
        return new c(this);
    }

    /* access modifiers changed from: protected */
    /* renamed from: y */
    public final SubtitleDecoderException j(Throwable th) {
        return new SubtitleDecoderException("Unexpected decode error", th);
    }

    /* access modifiers changed from: protected */
    public abstract d z(byte[] bArr, int i2, boolean z);
}
