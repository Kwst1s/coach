package com.google.android.exoplayer2.e0;

import com.google.android.exoplayer2.f0.a;
import com.google.android.exoplayer2.f0.h.h;
import com.google.android.exoplayer2.util.s;
import java.io.EOFException;

/* compiled from: Id3Peeker */
public final class l {

    /* renamed from: a  reason: collision with root package name */
    private final s f5083a = new s(10);

    public a a(h hVar, h.a aVar) {
        a aVar2 = null;
        int i2 = 0;
        while (true) {
            try {
                hVar.j(this.f5083a.f7062a, 0, 10);
                this.f5083a.K(0);
                if (this.f5083a.B() != h.f5742b) {
                    break;
                }
                this.f5083a.L(3);
                int x = this.f5083a.x();
                int i3 = x + 10;
                if (aVar2 == null) {
                    byte[] bArr = new byte[i3];
                    System.arraycopy(this.f5083a.f7062a, 0, bArr, 0, 10);
                    hVar.j(bArr, 10, x);
                    aVar2 = new h(aVar).c(bArr, i3);
                } else {
                    hVar.k(x);
                }
                i2 += i3;
            } catch (EOFException unused) {
            }
        }
        hVar.e();
        hVar.k(i2);
        return aVar2;
    }
}
