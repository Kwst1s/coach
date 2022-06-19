package com.google.android.exoplayer2.source.e0;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.d;
import com.google.android.exoplayer2.g;
import com.google.android.exoplayer2.k;
import com.google.android.exoplayer2.source.a0;
import com.google.android.exoplayer2.source.e0.c;
import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.source.p;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.a;
import com.google.android.exoplayer2.source.u;
import com.google.android.exoplayer2.source.v;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.i;
import com.google.android.exoplayer2.upstream.r;
import com.google.android.exoplayer2.upstream.t;
import com.google.android.exoplayer2.upstream.u;
import com.google.android.exoplayer2.upstream.v;
import com.google.android.exoplayer2.upstream.x;
import java.io.IOException;
import java.util.ArrayList;

/* compiled from: SsMediaSource */
public final class e extends l implements Loader.b<v<com.google.android.exoplayer2.source.smoothstreaming.manifest.a>> {

    /* renamed from: g  reason: collision with root package name */
    private final boolean f6342g;

    /* renamed from: h  reason: collision with root package name */
    private final Uri f6343h;

    /* renamed from: i  reason: collision with root package name */
    private final i.a f6344i;

    /* renamed from: j  reason: collision with root package name */
    private final c.a f6345j;

    /* renamed from: k  reason: collision with root package name */
    private final o f6346k;
    private final t l;
    private final long m;
    private final v.a n;
    private final v.a<? extends com.google.android.exoplayer2.source.smoothstreaming.manifest.a> o;
    private final ArrayList<d> p;
    private final Object q;
    private i r;
    private Loader s;
    private u t;
    private x u;
    private long v;
    private com.google.android.exoplayer2.source.smoothstreaming.manifest.a w;
    private Handler x;

    /* compiled from: SsMediaSource */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final c.a f6347a;

        /* renamed from: b  reason: collision with root package name */
        private final i.a f6348b;

        /* renamed from: c  reason: collision with root package name */
        private v.a<? extends com.google.android.exoplayer2.source.smoothstreaming.manifest.a> f6349c;

        /* renamed from: d  reason: collision with root package name */
        private o f6350d = new p();

        /* renamed from: e  reason: collision with root package name */
        private t f6351e = new r();

        /* renamed from: f  reason: collision with root package name */
        private long f6352f = 30000;

        /* renamed from: g  reason: collision with root package name */
        private Object f6353g;

        public b(c.a aVar, i.a aVar2) {
            com.google.android.exoplayer2.util.e.e(aVar);
            this.f6347a = aVar;
            this.f6348b = aVar2;
        }

        public e a(Uri uri) {
            if (this.f6349c == null) {
                this.f6349c = new SsManifestParser();
            }
            com.google.android.exoplayer2.util.e.e(uri);
            return new e(null, uri, this.f6348b, this.f6349c, this.f6347a, this.f6350d, this.f6351e, this.f6352f, this.f6353g);
        }
    }

    static {
        k.a("goog.exo.smoothstreaming");
    }

    private void v() {
        a0 a0Var;
        for (int i2 = 0; i2 < this.p.size(); i2++) {
            this.p.get(i2).x(this.w);
        }
        long j2 = Long.MIN_VALUE;
        a.b[] bVarArr = this.w.f6597f;
        long j3 = Long.MAX_VALUE;
        for (a.b bVar : bVarArr) {
            if (bVar.f6612k > 0) {
                j3 = Math.min(j3, bVar.e(0));
                j2 = Math.max(j2, bVar.e(bVar.f6612k - 1) + bVar.c(bVar.f6612k - 1));
            }
        }
        if (j3 == Long.MAX_VALUE) {
            a0Var = new a0(this.w.f6595d ? -9223372036854775807L : 0, 0, 0, 0, true, this.w.f6595d, this.q);
        } else {
            com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar = this.w;
            if (aVar.f6595d) {
                long j4 = aVar.f6599h;
                if (j4 != -9223372036854775807L && j4 > 0) {
                    j3 = Math.max(j3, j2 - j4);
                }
                long j5 = j2 - j3;
                long a2 = j5 - d.a(this.m);
                if (a2 < 5000000) {
                    a2 = Math.min(5000000L, j5 / 2);
                }
                a0Var = new a0(-9223372036854775807L, j5, j3, a2, true, true, this.q);
            } else {
                long j6 = aVar.f6598g;
                long j7 = j6 != -9223372036854775807L ? j6 : j2 - j3;
                a0Var = new a0(j3 + j7, j7, j3, 0, true, false, this.q);
            }
        }
        n(a0Var, this.w);
    }

    private void w() {
        if (this.w.f6595d) {
            this.x.postDelayed(new a(this), Math.max(0L, (this.v + 5000) - SystemClock.elapsedRealtime()));
        }
    }

    /* access modifiers changed from: private */
    public void x() {
        com.google.android.exoplayer2.upstream.v vVar = new com.google.android.exoplayer2.upstream.v(this.r, this.f6343h, 4, this.o);
        this.n.H(vVar.f6981a, vVar.f6982b, this.s.l(vVar, this, this.l.b(vVar.f6982b)));
    }

    @Override // com.google.android.exoplayer2.source.u
    public com.google.android.exoplayer2.source.t a(u.a aVar, com.google.android.exoplayer2.upstream.d dVar) {
        d dVar2 = new d(this.w, this.f6345j, this.u, this.f6346k, this.l, j(aVar), this.t, dVar);
        this.p.add(dVar2);
        return dVar2;
    }

    @Override // com.google.android.exoplayer2.source.u
    public void b() {
        this.t.a();
    }

    @Override // com.google.android.exoplayer2.source.u
    public void c(com.google.android.exoplayer2.source.t tVar) {
        ((d) tVar).v();
        this.p.remove(tVar);
    }

    @Override // com.google.android.exoplayer2.source.l
    public void m(g gVar, boolean z, x xVar) {
        this.u = xVar;
        if (this.f6342g) {
            this.t = new u.a();
            v();
            return;
        }
        this.r = this.f6344i.a();
        Loader loader = new Loader("Loader:Manifest");
        this.s = loader;
        this.t = loader;
        this.x = new Handler();
        x();
    }

    @Override // com.google.android.exoplayer2.source.l
    public void o() {
        this.w = this.f6342g ? this.w : null;
        this.r = null;
        this.v = 0;
        Loader loader = this.s;
        if (loader != null) {
            loader.j();
            this.s = null;
        }
        Handler handler = this.x;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.x = null;
        }
    }

    /* renamed from: s */
    public void k(com.google.android.exoplayer2.upstream.v<com.google.android.exoplayer2.source.smoothstreaming.manifest.a> vVar, long j2, long j3, boolean z) {
        this.n.y(vVar.f6981a, vVar.f(), vVar.d(), vVar.f6982b, j2, j3, vVar.c());
    }

    /* renamed from: t */
    public void q(com.google.android.exoplayer2.upstream.v<com.google.android.exoplayer2.source.smoothstreaming.manifest.a> vVar, long j2, long j3) {
        this.n.B(vVar.f6981a, vVar.f(), vVar.d(), vVar.f6982b, j2, j3, vVar.c());
        this.w = vVar.e();
        this.v = j2 - j3;
        v();
        w();
    }

    /* renamed from: u */
    public Loader.c p(com.google.android.exoplayer2.upstream.v<com.google.android.exoplayer2.source.smoothstreaming.manifest.a> vVar, long j2, long j3, IOException iOException, int i2) {
        boolean z = iOException instanceof ParserException;
        this.n.E(vVar.f6981a, vVar.f(), vVar.d(), vVar.f6982b, j2, j3, vVar.c(), iOException, z);
        return z ? Loader.f6880f : Loader.f6878d;
    }

    private e(com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar, Uri uri, i.a aVar2, v.a<? extends com.google.android.exoplayer2.source.smoothstreaming.manifest.a> aVar3, c.a aVar4, o oVar, t tVar, long j2, Object obj) {
        Uri uri2;
        boolean z = false;
        com.google.android.exoplayer2.util.e.f(aVar == null || !aVar.f6595d);
        this.w = aVar;
        if (uri == null) {
            uri2 = null;
        } else {
            uri2 = com.google.android.exoplayer2.source.smoothstreaming.manifest.b.a(uri);
        }
        this.f6343h = uri2;
        this.f6344i = aVar2;
        this.o = aVar3;
        this.f6345j = aVar4;
        this.f6346k = oVar;
        this.l = tVar;
        this.m = j2;
        this.n = j(null);
        this.q = obj;
        this.f6342g = aVar != null ? true : z;
        this.p = new ArrayList<>();
    }
}
