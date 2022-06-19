package com.google.android.exoplayer2.e0.v;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.e0.g;
import com.google.android.exoplayer2.e0.h;
import com.google.android.exoplayer2.e0.i;
import com.google.android.exoplayer2.e0.n;
import com.google.android.exoplayer2.e0.q;
import com.google.android.exoplayer2.util.s;

/* compiled from: OggExtractor */
public class d implements g {

    /* renamed from: a  reason: collision with root package name */
    private i f5350a;

    /* renamed from: b  reason: collision with root package name */
    private i f5351b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f5352c;

    static {
        a aVar = a.f5332a;
    }

    static /* synthetic */ g[] b() {
        return new g[]{new d()};
    }

    private static s d(s sVar) {
        sVar.K(0);
        return sVar;
    }

    private boolean g(h hVar) {
        f fVar = new f();
        if (fVar.a(hVar, true) && (fVar.f5360b & 2) == 2) {
            int min = Math.min(fVar.f5364f, 8);
            s sVar = new s(min);
            hVar.j(sVar.f7062a, 0, min);
            d(sVar);
            if (c.o(sVar)) {
                this.f5351b = new c();
            } else {
                d(sVar);
                if (k.p(sVar)) {
                    this.f5351b = new k();
                } else {
                    d(sVar);
                    if (h.n(sVar)) {
                        this.f5351b = new h();
                    }
                }
            }
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.e0.g
    public void a() {
    }

    @Override // com.google.android.exoplayer2.e0.g
    public void c(i iVar) {
        this.f5350a = iVar;
    }

    @Override // com.google.android.exoplayer2.e0.g
    public void e(long j2, long j3) {
        i iVar = this.f5351b;
        if (iVar != null) {
            iVar.k(j2, j3);
        }
    }

    @Override // com.google.android.exoplayer2.e0.g
    public boolean f(h hVar) {
        try {
            return g(hVar);
        } catch (ParserException unused) {
            return false;
        }
    }

    @Override // com.google.android.exoplayer2.e0.g
    public int i(h hVar, n nVar) {
        if (this.f5351b == null) {
            if (g(hVar)) {
                hVar.e();
            } else {
                throw new ParserException("Failed to determine bitstream type");
            }
        }
        if (!this.f5352c) {
            q a2 = this.f5350a.a(0, 1);
            this.f5350a.h();
            this.f5351b.c(this.f5350a, a2);
            this.f5352c = true;
        }
        return this.f5351b.f(hVar, nVar);
    }
}
