package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.source.hls.g;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.source.hls.playlist.d;
import com.google.android.exoplayer2.source.hls.playlist.e;
import com.google.android.exoplayer2.source.v;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.t;
import com.google.android.exoplayer2.upstream.v;
import com.google.android.exoplayer2.util.c0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;

/* compiled from: DefaultHlsPlaylistTracker */
public final class c implements HlsPlaylistTracker, Loader.b<v<f>> {
    public static final HlsPlaylistTracker.a q = a.f6436a;

    /* renamed from: b  reason: collision with root package name */
    private final g f6438b;

    /* renamed from: c  reason: collision with root package name */
    private final h f6439c;

    /* renamed from: d  reason: collision with root package name */
    private final t f6440d;

    /* renamed from: e  reason: collision with root package name */
    private final IdentityHashMap<d.a, a> f6441e = new IdentityHashMap<>();

    /* renamed from: f  reason: collision with root package name */
    private final List<HlsPlaylistTracker.b> f6442f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    private v.a<f> f6443g;

    /* renamed from: h  reason: collision with root package name */
    private v.a f6444h;

    /* renamed from: i  reason: collision with root package name */
    private Loader f6445i;

    /* renamed from: j  reason: collision with root package name */
    private Handler f6446j;

    /* renamed from: k  reason: collision with root package name */
    private HlsPlaylistTracker.c f6447k;
    private d l;
    private d.a m;
    private e n;
    private boolean o;
    private long p = -9223372036854775807L;

    /* access modifiers changed from: private */
    /* compiled from: DefaultHlsPlaylistTracker */
    public final class a implements Loader.b<com.google.android.exoplayer2.upstream.v<f>>, Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final d.a f6448b;

        /* renamed from: c  reason: collision with root package name */
        private final Loader f6449c = new Loader("DefaultHlsPlaylistTracker:MediaPlaylist");

        /* renamed from: d  reason: collision with root package name */
        private final com.google.android.exoplayer2.upstream.v<f> f6450d;

        /* renamed from: e  reason: collision with root package name */
        private e f6451e;

        /* renamed from: f  reason: collision with root package name */
        private long f6452f;

        /* renamed from: g  reason: collision with root package name */
        private long f6453g;

        /* renamed from: h  reason: collision with root package name */
        private long f6454h;

        /* renamed from: i  reason: collision with root package name */
        private long f6455i;

        /* renamed from: j  reason: collision with root package name */
        private boolean f6456j;

        /* renamed from: k  reason: collision with root package name */
        private IOException f6457k;

        public a(d.a aVar) {
            this.f6448b = aVar;
            this.f6450d = new com.google.android.exoplayer2.upstream.v<>(c.this.f6438b.a(4), c0.d(c.this.l.f6485a, aVar.f6465a), 4, c.this.f6443g);
        }

        private boolean d(long j2) {
            this.f6455i = SystemClock.elapsedRealtime() + j2;
            return c.this.m == this.f6448b && !c.this.E();
        }

        private void h() {
            long l2 = this.f6449c.l(this.f6450d, this, c.this.f6440d.b(this.f6450d.f6982b));
            v.a aVar = c.this.f6444h;
            com.google.android.exoplayer2.upstream.v<f> vVar = this.f6450d;
            aVar.H(vVar.f6981a, vVar.f6982b, l2);
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void n(e eVar, long j2) {
            e eVar2 = this.f6451e;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.f6452f = elapsedRealtime;
            e B = c.this.B(eVar2, eVar);
            this.f6451e = B;
            if (B != eVar2) {
                this.f6457k = null;
                this.f6453g = elapsedRealtime;
                c.this.K(this.f6448b, B);
            } else if (!B.l) {
                e eVar3 = this.f6451e;
                if (eVar.f6472i + ((long) eVar.o.size()) < eVar3.f6472i) {
                    this.f6457k = new HlsPlaylistTracker.PlaylistResetException(this.f6448b.f6465a);
                    c.this.G(this.f6448b, -9223372036854775807L);
                } else {
                    double b2 = (double) com.google.android.exoplayer2.d.b(eVar3.f6474k);
                    Double.isNaN(b2);
                    if (((double) (elapsedRealtime - this.f6453g)) > b2 * 3.5d) {
                        this.f6457k = new HlsPlaylistTracker.PlaylistStuckException(this.f6448b.f6465a);
                        long a2 = c.this.f6440d.a(4, j2, this.f6457k, 1);
                        c.this.G(this.f6448b, a2);
                        if (a2 != -9223372036854775807L) {
                            d(a2);
                        }
                    }
                }
            }
            e eVar4 = this.f6451e;
            this.f6454h = elapsedRealtime + com.google.android.exoplayer2.d.b(eVar4 != eVar2 ? eVar4.f6474k : eVar4.f6474k / 2);
            if (this.f6448b == c.this.m && !this.f6451e.l) {
                g();
            }
        }

        public e e() {
            return this.f6451e;
        }

        public boolean f() {
            int i2;
            if (this.f6451e == null) {
                return false;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long max = Math.max(30000L, com.google.android.exoplayer2.d.b(this.f6451e.p));
            e eVar = this.f6451e;
            if (eVar.l || (i2 = eVar.f6467d) == 2 || i2 == 1 || this.f6452f + max > elapsedRealtime) {
                return true;
            }
            return false;
        }

        public void g() {
            this.f6455i = 0;
            if (!this.f6456j && !this.f6449c.h()) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (elapsedRealtime < this.f6454h) {
                    this.f6456j = true;
                    c.this.f6446j.postDelayed(this, this.f6454h - elapsedRealtime);
                    return;
                }
                h();
            }
        }

        public void i() {
            this.f6449c.a();
            IOException iOException = this.f6457k;
            if (iOException != null) {
                throw iOException;
            }
        }

        /* renamed from: j */
        public void k(com.google.android.exoplayer2.upstream.v<f> vVar, long j2, long j3, boolean z) {
            c.this.f6444h.y(vVar.f6981a, vVar.f(), vVar.d(), 4, j2, j3, vVar.c());
        }

        /* renamed from: l */
        public void q(com.google.android.exoplayer2.upstream.v<f> vVar, long j2, long j3) {
            f e2 = vVar.e();
            if (e2 instanceof e) {
                n((e) e2, j3);
                c.this.f6444h.B(vVar.f6981a, vVar.f(), vVar.d(), 4, j2, j3, vVar.c());
                return;
            }
            this.f6457k = new ParserException("Loaded playlist has unexpected type.");
        }

        /* renamed from: m */
        public Loader.c p(com.google.android.exoplayer2.upstream.v<f> vVar, long j2, long j3, IOException iOException, int i2) {
            Loader.c cVar;
            long a2 = c.this.f6440d.a(vVar.f6982b, j3, iOException, i2);
            boolean z = a2 != -9223372036854775807L;
            boolean z2 = c.this.G(this.f6448b, a2) || !z;
            if (z) {
                z2 |= d(a2);
            }
            if (z2) {
                long c2 = c.this.f6440d.c(vVar.f6982b, j3, iOException, i2);
                cVar = c2 != -9223372036854775807L ? Loader.g(false, c2) : Loader.f6880f;
            } else {
                cVar = Loader.f6879e;
            }
            c.this.f6444h.E(vVar.f6981a, vVar.f(), vVar.d(), 4, j2, j3, vVar.c(), iOException, !cVar.c());
            return cVar;
        }

        public void o() {
            this.f6449c.j();
        }

        public void run() {
            this.f6456j = false;
            h();
        }
    }

    public c(g gVar, t tVar, h hVar) {
        this.f6438b = gVar;
        this.f6439c = hVar;
        this.f6440d = tVar;
    }

    private static e.a A(e eVar, e eVar2) {
        int i2 = (int) (eVar2.f6472i - eVar.f6472i);
        List<e.a> list = eVar.o;
        if (i2 < list.size()) {
            return list.get(i2);
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private e B(e eVar, e eVar2) {
        if (!eVar2.f(eVar)) {
            return eVar2.l ? eVar.d() : eVar;
        }
        return eVar2.c(D(eVar, eVar2), C(eVar, eVar2));
    }

    private int C(e eVar, e eVar2) {
        e.a A;
        if (eVar2.f6470g) {
            return eVar2.f6471h;
        }
        e eVar3 = this.n;
        int i2 = eVar3 != null ? eVar3.f6471h : 0;
        return (eVar == null || (A = A(eVar, eVar2)) == null) ? i2 : (eVar.f6471h + A.f6478e) - eVar2.o.get(0).f6478e;
    }

    private long D(e eVar, e eVar2) {
        if (eVar2.m) {
            return eVar2.f6469f;
        }
        e eVar3 = this.n;
        long j2 = eVar3 != null ? eVar3.f6469f : 0;
        if (eVar == null) {
            return j2;
        }
        int size = eVar.o.size();
        e.a A = A(eVar, eVar2);
        if (A != null) {
            return eVar.f6469f + A.f6479f;
        }
        return ((long) size) == eVar2.f6472i - eVar.f6472i ? eVar.e() : j2;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean E() {
        List<d.a> list = this.l.f6459d;
        int size = list.size();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        for (int i2 = 0; i2 < size; i2++) {
            a aVar = this.f6441e.get(list.get(i2));
            if (elapsedRealtime > aVar.f6455i) {
                this.m = aVar.f6448b;
                aVar.g();
                return true;
            }
        }
        return false;
    }

    private void F(d.a aVar) {
        if (aVar != this.m && this.l.f6459d.contains(aVar)) {
            e eVar = this.n;
            if (eVar == null || !eVar.l) {
                this.m = aVar;
                this.f6441e.get(aVar).g();
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean G(d.a aVar, long j2) {
        int size = this.f6442f.size();
        boolean z = false;
        for (int i2 = 0; i2 < size; i2++) {
            z |= !this.f6442f.get(i2).h(aVar, j2);
        }
        return z;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void K(d.a aVar, e eVar) {
        if (aVar == this.m) {
            if (this.n == null) {
                this.o = !eVar.l;
                this.p = eVar.f6469f;
            }
            this.n = eVar;
            this.f6447k.d(eVar);
        }
        int size = this.f6442f.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f6442f.get(i2).e();
        }
    }

    private void z(List<d.a> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            d.a aVar = list.get(i2);
            this.f6441e.put(aVar, new a(aVar));
        }
    }

    /* renamed from: H */
    public void k(com.google.android.exoplayer2.upstream.v<f> vVar, long j2, long j3, boolean z) {
        this.f6444h.y(vVar.f6981a, vVar.f(), vVar.d(), 4, j2, j3, vVar.c());
    }

    /* renamed from: I */
    public void q(com.google.android.exoplayer2.upstream.v<f> vVar, long j2, long j3) {
        d dVar;
        f e2 = vVar.e();
        boolean z = e2 instanceof e;
        if (z) {
            dVar = d.d(e2.f6485a);
        } else {
            dVar = (d) e2;
        }
        this.l = dVar;
        this.f6443g = this.f6439c.a(dVar);
        this.m = dVar.f6459d.get(0);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(dVar.f6459d);
        arrayList.addAll(dVar.f6460e);
        arrayList.addAll(dVar.f6461f);
        z(arrayList);
        a aVar = this.f6441e.get(this.m);
        if (z) {
            aVar.n((e) e2, j3);
        } else {
            aVar.g();
        }
        this.f6444h.B(vVar.f6981a, vVar.f(), vVar.d(), 4, j2, j3, vVar.c());
    }

    /* renamed from: J */
    public Loader.c p(com.google.android.exoplayer2.upstream.v<f> vVar, long j2, long j3, IOException iOException, int i2) {
        long c2 = this.f6440d.c(vVar.f6982b, j3, iOException, i2);
        boolean z = c2 == -9223372036854775807L;
        this.f6444h.E(vVar.f6981a, vVar.f(), vVar.d(), 4, j2, j3, vVar.c(), iOException, z);
        if (z) {
            return Loader.f6880f;
        }
        return Loader.g(false, c2);
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public boolean a() {
        return this.o;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public e b(d.a aVar) {
        e e2 = this.f6441e.get(aVar).e();
        if (e2 != null) {
            F(aVar);
        }
        return e2;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void c(d.a aVar) {
        this.f6441e.get(aVar).g();
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public d d() {
        return this.l;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void e(Uri uri, v.a aVar, HlsPlaylistTracker.c cVar) {
        this.f6446j = new Handler();
        this.f6444h = aVar;
        this.f6447k = cVar;
        com.google.android.exoplayer2.upstream.v vVar = new com.google.android.exoplayer2.upstream.v(this.f6438b.a(4), uri, 4, this.f6439c.b());
        com.google.android.exoplayer2.util.e.f(this.f6445i == null);
        Loader loader = new Loader("DefaultHlsPlaylistTracker:MasterPlaylist");
        this.f6445i = loader;
        aVar.H(vVar.f6981a, vVar.f6982b, loader.l(vVar, this, this.f6440d.b(vVar.f6982b)));
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void f() {
        Loader loader = this.f6445i;
        if (loader != null) {
            loader.a();
        }
        d.a aVar = this.m;
        if (aVar != null) {
            j(aVar);
        }
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void g(HlsPlaylistTracker.b bVar) {
        this.f6442f.remove(bVar);
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void h(HlsPlaylistTracker.b bVar) {
        this.f6442f.add(bVar);
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public boolean i(d.a aVar) {
        return this.f6441e.get(aVar).f();
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void j(d.a aVar) {
        this.f6441e.get(aVar).i();
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public long l() {
        return this.p;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void stop() {
        this.m = null;
        this.n = null;
        this.l = null;
        this.p = -9223372036854775807L;
        this.f6445i.j();
        this.f6445i = null;
        for (a aVar : this.f6441e.values()) {
            aVar.o();
        }
        this.f6446j.removeCallbacksAndMessages(null);
        this.f6446j = null;
        this.f6441e.clear();
    }
}
