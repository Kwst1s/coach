package com.google.android.exoplayer2.extractor.flv;

import com.google.android.exoplayer2.e0.g;
import com.google.android.exoplayer2.e0.h;
import com.google.android.exoplayer2.e0.i;
import com.google.android.exoplayer2.e0.n;
import com.google.android.exoplayer2.e0.o;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.s;

/* compiled from: FlvExtractor */
public final class c implements g {
    private static final int p = d0.B("FLV");

    /* renamed from: a  reason: collision with root package name */
    private final s f5684a = new s(4);

    /* renamed from: b  reason: collision with root package name */
    private final s f5685b = new s(9);

    /* renamed from: c  reason: collision with root package name */
    private final s f5686c = new s(11);

    /* renamed from: d  reason: collision with root package name */
    private final s f5687d = new s();

    /* renamed from: e  reason: collision with root package name */
    private final d f5688e = new d();

    /* renamed from: f  reason: collision with root package name */
    private i f5689f;

    /* renamed from: g  reason: collision with root package name */
    private int f5690g = 1;

    /* renamed from: h  reason: collision with root package name */
    private long f5691h = -9223372036854775807L;

    /* renamed from: i  reason: collision with root package name */
    private int f5692i;

    /* renamed from: j  reason: collision with root package name */
    private int f5693j;

    /* renamed from: k  reason: collision with root package name */
    private int f5694k;
    private long l;
    private boolean m;
    private b n;
    private e o;

    static {
        a aVar = a.f5679a;
    }

    private void b() {
        if (!this.m) {
            this.f5689f.e(new o.b(-9223372036854775807L));
            this.m = true;
        }
        if (this.f5691h == -9223372036854775807L) {
            this.f5691h = this.f5688e.d() == -9223372036854775807L ? -this.l : 0;
        }
    }

    static /* synthetic */ g[] d() {
        return new g[]{new c()};
    }

    private s g(h hVar) {
        if (this.f5694k > this.f5687d.b()) {
            s sVar = this.f5687d;
            sVar.I(new byte[Math.max(sVar.b() * 2, this.f5694k)], 0);
        } else {
            this.f5687d.K(0);
        }
        this.f5687d.J(this.f5694k);
        hVar.readFully(this.f5687d.f7062a, 0, this.f5694k);
        return this.f5687d;
    }

    private boolean h(h hVar) {
        boolean z = false;
        if (!hVar.c(this.f5685b.f7062a, 0, 9, true)) {
            return false;
        }
        this.f5685b.K(0);
        this.f5685b.L(4);
        int y = this.f5685b.y();
        boolean z2 = (y & 4) != 0;
        if ((y & 1) != 0) {
            z = true;
        }
        if (z2 && this.n == null) {
            this.n = new b(this.f5689f.a(8, 1));
        }
        if (z && this.o == null) {
            this.o = new e(this.f5689f.a(9, 2));
        }
        this.f5689f.h();
        this.f5692i = (this.f5685b.j() - 9) + 4;
        this.f5690g = 2;
        return true;
    }

    private boolean j(h hVar) {
        int i2 = this.f5693j;
        boolean z = true;
        if (i2 == 8 && this.n != null) {
            b();
            this.n.a(g(hVar), this.f5691h + this.l);
        } else if (i2 == 9 && this.o != null) {
            b();
            this.o.a(g(hVar), this.f5691h + this.l);
        } else if (i2 != 18 || this.m) {
            hVar.f(this.f5694k);
            z = false;
        } else {
            this.f5688e.a(g(hVar), this.l);
            long d2 = this.f5688e.d();
            if (d2 != -9223372036854775807L) {
                this.f5689f.e(new o.b(d2));
                this.m = true;
            }
        }
        this.f5692i = 4;
        this.f5690g = 2;
        return z;
    }

    private boolean k(h hVar) {
        if (!hVar.c(this.f5686c.f7062a, 0, 11, true)) {
            return false;
        }
        this.f5686c.K(0);
        this.f5693j = this.f5686c.y();
        this.f5694k = this.f5686c.B();
        this.l = (long) this.f5686c.B();
        this.l = (((long) (this.f5686c.y() << 24)) | this.l) * 1000;
        this.f5686c.L(3);
        this.f5690g = 4;
        return true;
    }

    private void l(h hVar) {
        hVar.f(this.f5692i);
        this.f5692i = 0;
        this.f5690g = 3;
    }

    @Override // com.google.android.exoplayer2.e0.g
    public void a() {
    }

    @Override // com.google.android.exoplayer2.e0.g
    public void c(i iVar) {
        this.f5689f = iVar;
    }

    @Override // com.google.android.exoplayer2.e0.g
    public void e(long j2, long j3) {
        this.f5690g = 1;
        this.f5691h = -9223372036854775807L;
        this.f5692i = 0;
    }

    @Override // com.google.android.exoplayer2.e0.g
    public boolean f(h hVar) {
        hVar.j(this.f5684a.f7062a, 0, 3);
        this.f5684a.K(0);
        if (this.f5684a.B() != p) {
            return false;
        }
        hVar.j(this.f5684a.f7062a, 0, 2);
        this.f5684a.K(0);
        if ((this.f5684a.E() & 250) != 0) {
            return false;
        }
        hVar.j(this.f5684a.f7062a, 0, 4);
        this.f5684a.K(0);
        int j2 = this.f5684a.j();
        hVar.e();
        hVar.k(j2);
        hVar.j(this.f5684a.f7062a, 0, 4);
        this.f5684a.K(0);
        if (this.f5684a.j() == 0) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.e0.g
    public int i(h hVar, n nVar) {
        while (true) {
            int i2 = this.f5690g;
            if (i2 != 1) {
                if (i2 == 2) {
                    l(hVar);
                } else if (i2 != 3) {
                    if (i2 != 4) {
                        throw new IllegalStateException();
                    } else if (j(hVar)) {
                        return 0;
                    }
                } else if (!k(hVar)) {
                    return -1;
                }
            } else if (!h(hVar)) {
                return -1;
            }
        }
    }
}
