package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import com.google.android.exoplayer2.g;
import com.google.android.exoplayer2.k;
import com.google.android.exoplayer2.source.a0;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.source.hls.playlist.c;
import com.google.android.exoplayer2.source.hls.playlist.e;
import com.google.android.exoplayer2.source.hls.playlist.h;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.source.p;
import com.google.android.exoplayer2.source.u;
import com.google.android.exoplayer2.upstream.d;
import com.google.android.exoplayer2.upstream.i;
import com.google.android.exoplayer2.upstream.r;
import com.google.android.exoplayer2.upstream.t;
import com.google.android.exoplayer2.upstream.x;
import com.google.android.exoplayer2.util.e;
import java.util.List;

/* compiled from: HlsMediaSource */
public final class l extends com.google.android.exoplayer2.source.l implements HlsPlaylistTracker.c {

    /* renamed from: g  reason: collision with root package name */
    private final h f6401g;

    /* renamed from: h  reason: collision with root package name */
    private final Uri f6402h;

    /* renamed from: i  reason: collision with root package name */
    private final g f6403i;

    /* renamed from: j  reason: collision with root package name */
    private final o f6404j;

    /* renamed from: k  reason: collision with root package name */
    private final t f6405k;
    private final boolean l;
    private final HlsPlaylistTracker m;
    private final Object n;
    private x o;

    /* compiled from: HlsMediaSource */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final g f6406a;

        /* renamed from: b  reason: collision with root package name */
        private h f6407b;

        /* renamed from: c  reason: collision with root package name */
        private h f6408c;

        /* renamed from: d  reason: collision with root package name */
        private HlsPlaylistTracker.a f6409d;

        /* renamed from: e  reason: collision with root package name */
        private o f6410e;

        /* renamed from: f  reason: collision with root package name */
        private t f6411f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f6412g;

        /* renamed from: h  reason: collision with root package name */
        private Object f6413h;

        public b(i.a aVar) {
            this(new d(aVar));
        }

        public l a(Uri uri) {
            g gVar = this.f6406a;
            h hVar = this.f6407b;
            o oVar = this.f6410e;
            t tVar = this.f6411f;
            return new l(uri, gVar, hVar, oVar, tVar, this.f6409d.a(gVar, tVar, this.f6408c), this.f6412g, this.f6413h);
        }

        public b(g gVar) {
            e.e(gVar);
            this.f6406a = gVar;
            this.f6408c = new com.google.android.exoplayer2.source.hls.playlist.b();
            this.f6409d = c.q;
            this.f6407b = h.f6388a;
            this.f6411f = new r();
            this.f6410e = new p();
        }
    }

    static {
        k.a("goog.exo.hls");
    }

    @Override // com.google.android.exoplayer2.source.u
    public com.google.android.exoplayer2.source.t a(u.a aVar, d dVar) {
        return new k(this.f6401g, this.m, this.f6403i, this.o, this.f6405k, j(aVar), dVar, this.f6404j, this.l);
    }

    @Override // com.google.android.exoplayer2.source.u
    public void b() {
        this.m.f();
    }

    @Override // com.google.android.exoplayer2.source.u
    public void c(com.google.android.exoplayer2.source.t tVar) {
        ((k) tVar).y();
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.c
    public void d(com.google.android.exoplayer2.source.hls.playlist.e eVar) {
        a0 a0Var;
        long j2;
        long j3;
        long b2 = eVar.m ? com.google.android.exoplayer2.d.b(eVar.f6469f) : -9223372036854775807L;
        int i2 = eVar.f6467d;
        long j4 = (i2 == 2 || i2 == 1) ? b2 : -9223372036854775807L;
        long j5 = eVar.f6468e;
        if (this.m.a()) {
            long l2 = eVar.f6469f - this.m.l();
            long j6 = eVar.l ? l2 + eVar.p : -9223372036854775807L;
            List<e.a> list = eVar.o;
            if (j5 == -9223372036854775807L) {
                if (list.isEmpty()) {
                    j3 = 0;
                } else {
                    j3 = list.get(Math.max(0, list.size() - 3)).f6479f;
                }
                j2 = j3;
            } else {
                j2 = j5;
            }
            a0Var = new a0(j4, b2, j6, eVar.p, l2, j2, true, !eVar.l, this.n);
        } else {
            long j7 = j5 == -9223372036854775807L ? 0 : j5;
            long j8 = eVar.p;
            a0Var = new a0(j4, b2, j8, j8, 0, j7, true, false, this.n);
        }
        n(a0Var, new i(this.m.d(), eVar));
    }

    @Override // com.google.android.exoplayer2.source.l
    public void m(g gVar, boolean z, x xVar) {
        this.o = xVar;
        this.m.e(this.f6402h, j(null), this);
    }

    @Override // com.google.android.exoplayer2.source.l
    public void o() {
        this.m.stop();
    }

    private l(Uri uri, g gVar, h hVar, o oVar, t tVar, HlsPlaylistTracker hlsPlaylistTracker, boolean z, Object obj) {
        this.f6402h = uri;
        this.f6403i = gVar;
        this.f6401g = hVar;
        this.f6404j = oVar;
        this.f6405k = tVar;
        this.m = hlsPlaylistTracker;
        this.l = z;
        this.n = obj;
    }
}
