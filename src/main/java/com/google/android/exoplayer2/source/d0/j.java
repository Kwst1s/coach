package com.google.android.exoplayer2.source.d0;

import com.google.android.exoplayer2.l;
import com.google.android.exoplayer2.upstream.i;
import com.google.android.exoplayer2.upstream.k;
import com.google.android.exoplayer2.util.d0;
import java.util.Arrays;

/* compiled from: DataChunk */
public abstract class j extends d {

    /* renamed from: i  reason: collision with root package name */
    private byte[] f6139i;

    /* renamed from: j  reason: collision with root package name */
    private volatile boolean f6140j;

    public j(i iVar, k kVar, int i2, l lVar, int i3, Object obj, byte[] bArr) {
        super(iVar, kVar, i2, lVar, i3, obj, -9223372036854775807L, -9223372036854775807L);
        this.f6139i = bArr;
    }

    private void i(int i2) {
        byte[] bArr = this.f6139i;
        if (bArr == null) {
            this.f6139i = new byte[16384];
        } else if (bArr.length < i2 + 16384) {
            this.f6139i = Arrays.copyOf(bArr, bArr.length + 16384);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.e
    public final void a() {
        try {
            this.f6105h.b(this.f6098a);
            int i2 = 0;
            int i3 = 0;
            while (i2 != -1 && !this.f6140j) {
                i(i3);
                i2 = this.f6105h.a(this.f6139i, i3, 16384);
                if (i2 != -1) {
                    i3 += i2;
                }
            }
            if (!this.f6140j) {
                g(this.f6139i, i3);
            }
        } finally {
            d0.j(this.f6105h);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.e
    public final void b() {
        this.f6140j = true;
    }

    /* access modifiers changed from: protected */
    public abstract void g(byte[] bArr, int i2);

    public byte[] h() {
        return this.f6139i;
    }
}
