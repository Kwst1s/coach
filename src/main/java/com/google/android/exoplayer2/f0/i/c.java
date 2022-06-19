package com.google.android.exoplayer2.f0.i;

import com.google.android.exoplayer2.f0.a;
import com.google.android.exoplayer2.f0.b;
import com.google.android.exoplayer2.f0.d;
import com.google.android.exoplayer2.util.a0;
import com.google.android.exoplayer2.util.r;
import com.google.android.exoplayer2.util.s;
import java.nio.ByteBuffer;

/* compiled from: SpliceInfoDecoder */
public final class c implements b {

    /* renamed from: a  reason: collision with root package name */
    private final s f5765a = new s();

    /* renamed from: b  reason: collision with root package name */
    private final r f5766b = new r();

    /* renamed from: c  reason: collision with root package name */
    private a0 f5767c;

    @Override // com.google.android.exoplayer2.f0.b
    public a a(d dVar) {
        a0 a0Var = this.f5767c;
        if (a0Var == null || dVar.f5707g != a0Var.e()) {
            a0 a0Var2 = new a0(dVar.f4952e);
            this.f5767c = a0Var2;
            a0Var2.a(dVar.f4952e - dVar.f5707g);
        }
        ByteBuffer byteBuffer = dVar.f4951d;
        byte[] array = byteBuffer.array();
        int limit = byteBuffer.limit();
        this.f5765a.I(array, limit);
        this.f5766b.m(array, limit);
        this.f5766b.p(39);
        long h2 = (((long) this.f5766b.h(1)) << 32) | ((long) this.f5766b.h(32));
        this.f5766b.p(20);
        int h3 = this.f5766b.h(12);
        int h4 = this.f5766b.h(8);
        a.b bVar = null;
        this.f5765a.L(14);
        if (h4 == 0) {
            bVar = new e();
        } else if (h4 == 255) {
            bVar = a.g(this.f5765a, h3, h2);
        } else if (h4 == 4) {
            bVar = f.g(this.f5765a);
        } else if (h4 == 5) {
            bVar = d.g(this.f5765a, h2, this.f5767c);
        } else if (h4 == 6) {
            bVar = g.g(this.f5765a, h2, this.f5767c);
        }
        if (bVar == null) {
            return new a(new a.b[0]);
        }
        return new a(bVar);
    }
}
