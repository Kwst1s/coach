package com.google.android.exoplayer2.e0.y;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.e0.g;
import com.google.android.exoplayer2.e0.h;
import com.google.android.exoplayer2.e0.i;
import com.google.android.exoplayer2.e0.n;
import com.google.android.exoplayer2.e0.q;
import com.google.android.exoplayer2.l;
import com.google.android.exoplayer2.util.e;

/* compiled from: WavExtractor */
public final class b implements g {

    /* renamed from: a  reason: collision with root package name */
    private i f5663a;

    /* renamed from: b  reason: collision with root package name */
    private q f5664b;

    /* renamed from: c  reason: collision with root package name */
    private c f5665c;

    /* renamed from: d  reason: collision with root package name */
    private int f5666d;

    /* renamed from: e  reason: collision with root package name */
    private int f5667e;

    static {
        a aVar = a.f5662a;
    }

    static /* synthetic */ g[] b() {
        return new g[]{new b()};
    }

    @Override // com.google.android.exoplayer2.e0.g
    public void a() {
    }

    @Override // com.google.android.exoplayer2.e0.g
    public void c(i iVar) {
        this.f5663a = iVar;
        this.f5664b = iVar.a(0, 1);
        this.f5665c = null;
        iVar.h();
    }

    @Override // com.google.android.exoplayer2.e0.g
    public void e(long j2, long j3) {
        this.f5667e = 0;
    }

    @Override // com.google.android.exoplayer2.e0.g
    public boolean f(h hVar) {
        return d.a(hVar) != null;
    }

    @Override // com.google.android.exoplayer2.e0.g
    public int i(h hVar, n nVar) {
        if (this.f5665c == null) {
            c a2 = d.a(hVar);
            this.f5665c = a2;
            if (a2 != null) {
                this.f5664b.d(l.s(null, "audio/raw", null, a2.a(), 32768, this.f5665c.i(), this.f5665c.k(), this.f5665c.f(), null, null, 0, null));
                this.f5666d = this.f5665c.c();
            } else {
                throw new ParserException("Unsupported or unrecognized wav header.");
            }
        }
        if (!this.f5665c.l()) {
            d.b(hVar, this.f5665c);
            this.f5663a.e(this.f5665c);
        }
        long e2 = this.f5665c.e();
        e.f(e2 != -1);
        long l = e2 - hVar.l();
        if (l <= 0) {
            return -1;
        }
        int b2 = this.f5664b.b(hVar, (int) Math.min((long) (32768 - this.f5667e), l), true);
        if (b2 != -1) {
            this.f5667e += b2;
        }
        int i2 = this.f5667e / this.f5666d;
        if (i2 > 0) {
            long b3 = this.f5665c.b(hVar.l() - ((long) this.f5667e));
            int i3 = i2 * this.f5666d;
            int i4 = this.f5667e - i3;
            this.f5667e = i4;
            this.f5664b.c(b3, 1, i3, i4, null);
        }
        if (b2 == -1) {
            return -1;
        }
        return 0;
    }
}
