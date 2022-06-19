package com.google.android.exoplayer2.e0.x;

import android.util.SparseArray;
import com.google.android.exoplayer2.e0.g;
import com.google.android.exoplayer2.e0.h;
import com.google.android.exoplayer2.e0.i;
import com.google.android.exoplayer2.e0.n;
import com.google.android.exoplayer2.e0.o;
import com.google.android.exoplayer2.e0.x.e0;
import com.google.android.exoplayer2.util.a0;
import com.google.android.exoplayer2.util.r;
import com.google.android.exoplayer2.util.s;

/* compiled from: PsExtractor */
public final class w implements g {

    /* renamed from: a  reason: collision with root package name */
    private final a0 f5635a;

    /* renamed from: b  reason: collision with root package name */
    private final SparseArray<a> f5636b;

    /* renamed from: c  reason: collision with root package name */
    private final s f5637c;

    /* renamed from: d  reason: collision with root package name */
    private final v f5638d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f5639e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f5640f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f5641g;

    /* renamed from: h  reason: collision with root package name */
    private long f5642h;

    /* renamed from: i  reason: collision with root package name */
    private u f5643i;

    /* renamed from: j  reason: collision with root package name */
    private i f5644j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f5645k;

    /* compiled from: PsExtractor */
    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final l f5646a;

        /* renamed from: b  reason: collision with root package name */
        private final a0 f5647b;

        /* renamed from: c  reason: collision with root package name */
        private final r f5648c = new r(new byte[64]);

        /* renamed from: d  reason: collision with root package name */
        private boolean f5649d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f5650e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f5651f;

        /* renamed from: g  reason: collision with root package name */
        private int f5652g;

        /* renamed from: h  reason: collision with root package name */
        private long f5653h;

        public a(l lVar, a0 a0Var) {
            this.f5646a = lVar;
            this.f5647b = a0Var;
        }

        private void b() {
            this.f5648c.p(8);
            this.f5649d = this.f5648c.g();
            this.f5650e = this.f5648c.g();
            this.f5648c.p(6);
            this.f5652g = this.f5648c.h(8);
        }

        private void c() {
            this.f5653h = 0;
            if (this.f5649d) {
                this.f5648c.p(4);
                this.f5648c.p(1);
                this.f5648c.p(1);
                long h2 = (((long) this.f5648c.h(3)) << 30) | ((long) (this.f5648c.h(15) << 15)) | ((long) this.f5648c.h(15));
                this.f5648c.p(1);
                if (!this.f5651f && this.f5650e) {
                    this.f5648c.p(4);
                    this.f5648c.p(1);
                    this.f5648c.p(1);
                    this.f5648c.p(1);
                    this.f5647b.b((((long) this.f5648c.h(3)) << 30) | ((long) (this.f5648c.h(15) << 15)) | ((long) this.f5648c.h(15)));
                    this.f5651f = true;
                }
                this.f5653h = this.f5647b.b(h2);
            }
        }

        public void a(s sVar) {
            sVar.h(this.f5648c.f7058a, 0, 3);
            this.f5648c.n(0);
            b();
            sVar.h(this.f5648c.f7058a, 0, this.f5652g);
            this.f5648c.n(0);
            c();
            this.f5646a.d(this.f5653h, true);
            this.f5646a.c(sVar);
            this.f5646a.e();
        }

        public void d() {
            this.f5651f = false;
            this.f5646a.a();
        }
    }

    static {
        c cVar = c.f5412a;
    }

    public w() {
        this(new a0(0));
    }

    static /* synthetic */ g[] b() {
        return new g[]{new w()};
    }

    private void d(long j2) {
        if (!this.f5645k) {
            this.f5645k = true;
            if (this.f5638d.c() != -9223372036854775807L) {
                u uVar = new u(this.f5638d.d(), this.f5638d.c(), j2);
                this.f5643i = uVar;
                this.f5644j.e(uVar.b());
                return;
            }
            this.f5644j.e(new o.b(this.f5638d.c()));
        }
    }

    @Override // com.google.android.exoplayer2.e0.g
    public void a() {
    }

    @Override // com.google.android.exoplayer2.e0.g
    public void c(i iVar) {
        this.f5644j = iVar;
    }

    @Override // com.google.android.exoplayer2.e0.g
    public void e(long j2, long j3) {
        if ((this.f5635a.e() == -9223372036854775807L) || !(this.f5635a.c() == 0 || this.f5635a.c() == j3)) {
            this.f5635a.g();
            this.f5635a.h(j3);
        }
        u uVar = this.f5643i;
        if (uVar != null) {
            uVar.h(j3);
        }
        for (int i2 = 0; i2 < this.f5636b.size(); i2++) {
            this.f5636b.valueAt(i2).d();
        }
    }

    @Override // com.google.android.exoplayer2.e0.g
    public boolean f(h hVar) {
        byte[] bArr = new byte[14];
        hVar.j(bArr, 0, 14);
        if (442 != (((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255)) || (bArr[4] & 196) != 68 || (bArr[6] & 4) != 4 || (bArr[8] & 4) != 4 || (bArr[9] & 1) != 1 || (bArr[12] & 3) != 3) {
            return false;
        }
        hVar.k(bArr[13] & 7);
        hVar.j(bArr, 0, 3);
        if (1 == (((bArr[0] & 255) << 16) | ((bArr[1] & 255) << 8) | (bArr[2] & 255))) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.e0.g
    public int i(h hVar, n nVar) {
        long d2 = hVar.d();
        if ((d2 != -1) && !this.f5638d.e()) {
            return this.f5638d.g(hVar, nVar);
        }
        d(d2);
        u uVar = this.f5643i;
        l lVar = null;
        if (uVar != null && uVar.d()) {
            return this.f5643i.c(hVar, nVar, null);
        }
        hVar.e();
        long i2 = d2 != -1 ? d2 - hVar.i() : -1;
        if ((i2 != -1 && i2 < 4) || !hVar.h(this.f5637c.f7062a, 0, 4, true)) {
            return -1;
        }
        this.f5637c.K(0);
        int j2 = this.f5637c.j();
        if (j2 == 441) {
            return -1;
        }
        if (j2 == 442) {
            hVar.j(this.f5637c.f7062a, 0, 10);
            this.f5637c.K(9);
            hVar.f((this.f5637c.y() & 7) + 14);
            return 0;
        } else if (j2 == 443) {
            hVar.j(this.f5637c.f7062a, 0, 2);
            this.f5637c.K(0);
            hVar.f(this.f5637c.E() + 6);
            return 0;
        } else if (((j2 & -256) >> 8) != 1) {
            hVar.f(1);
            return 0;
        } else {
            int i3 = j2 & 255;
            a aVar = this.f5636b.get(i3);
            if (!this.f5639e) {
                if (aVar == null) {
                    if (i3 == 189) {
                        lVar = new f();
                        this.f5640f = true;
                        this.f5642h = hVar.l();
                    } else if ((i3 & 224) == 192) {
                        lVar = new r();
                        this.f5640f = true;
                        this.f5642h = hVar.l();
                    } else if ((i3 & 240) == 224) {
                        lVar = new m();
                        this.f5641g = true;
                        this.f5642h = hVar.l();
                    }
                    if (lVar != null) {
                        lVar.f(this.f5644j, new e0.d(i3, 256));
                        aVar = new a(lVar, this.f5635a);
                        this.f5636b.put(i3, aVar);
                    }
                }
                if (hVar.l() > ((!this.f5640f || !this.f5641g) ? 1048576 : this.f5642h + 8192)) {
                    this.f5639e = true;
                    this.f5644j.h();
                }
            }
            hVar.j(this.f5637c.f7062a, 0, 2);
            this.f5637c.K(0);
            int E = this.f5637c.E() + 6;
            if (aVar == null) {
                hVar.f(E);
            } else {
                this.f5637c.H(E);
                hVar.readFully(this.f5637c.f7062a, 0, E);
                this.f5637c.K(6);
                aVar.a(this.f5637c);
                s sVar = this.f5637c;
                sVar.J(sVar.b());
            }
            return 0;
        }
    }

    public w(a0 a0Var) {
        this.f5635a = a0Var;
        this.f5637c = new s(4096);
        this.f5636b = new SparseArray<>();
        this.f5638d = new v();
    }
}
