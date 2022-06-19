package com.google.android.exoplayer2.source;

import android.net.Uri;
import com.google.android.exoplayer2.e0.e;
import com.google.android.exoplayer2.e0.j;
import com.google.android.exoplayer2.g;
import com.google.android.exoplayer2.source.r;
import com.google.android.exoplayer2.source.u;
import com.google.android.exoplayer2.upstream.d;
import com.google.android.exoplayer2.upstream.i;
import com.google.android.exoplayer2.upstream.t;
import com.google.android.exoplayer2.upstream.x;

/* compiled from: ExtractorMediaSource */
public final class s extends l implements r.c {

    /* renamed from: g  reason: collision with root package name */
    private final Uri f6557g;

    /* renamed from: h  reason: collision with root package name */
    private final i.a f6558h;

    /* renamed from: i  reason: collision with root package name */
    private final j f6559i;

    /* renamed from: j  reason: collision with root package name */
    private final t f6560j;

    /* renamed from: k  reason: collision with root package name */
    private final String f6561k;
    private final int l;
    private final Object m;
    private long n;
    private boolean o;
    private x p;

    /* compiled from: ExtractorMediaSource */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final i.a f6562a;

        /* renamed from: b  reason: collision with root package name */
        private j f6563b;

        /* renamed from: c  reason: collision with root package name */
        private String f6564c;

        /* renamed from: d  reason: collision with root package name */
        private Object f6565d;

        /* renamed from: e  reason: collision with root package name */
        private t f6566e = new com.google.android.exoplayer2.upstream.r();

        /* renamed from: f  reason: collision with root package name */
        private int f6567f = 1048576;

        /* renamed from: g  reason: collision with root package name */
        private boolean f6568g;

        public b(i.a aVar) {
            this.f6562a = aVar;
        }

        public s a(Uri uri) {
            this.f6568g = true;
            if (this.f6563b == null) {
                this.f6563b = new e();
            }
            return new s(uri, this.f6562a, this.f6563b, this.f6566e, this.f6564c, this.f6567f, this.f6565d);
        }

        public b b(j jVar) {
            com.google.android.exoplayer2.util.e.f(!this.f6568g);
            this.f6563b = jVar;
            return this;
        }
    }

    private void r(long j2, boolean z) {
        this.n = j2;
        this.o = z;
        n(new a0(this.n, this.o, false, this.m), null);
    }

    @Override // com.google.android.exoplayer2.source.u
    public t a(u.a aVar, d dVar) {
        i a2 = this.f6558h.a();
        x xVar = this.p;
        if (xVar != null) {
            a2.d(xVar);
        }
        return new r(this.f6557g, a2, this.f6559i.a(), this.f6560j, j(aVar), this, dVar, this.f6561k, this.l);
    }

    @Override // com.google.android.exoplayer2.source.u
    public void b() {
    }

    @Override // com.google.android.exoplayer2.source.u
    public void c(t tVar) {
        ((r) tVar).Q();
    }

    @Override // com.google.android.exoplayer2.source.r.c
    public void g(long j2, boolean z) {
        if (j2 == -9223372036854775807L) {
            j2 = this.n;
        }
        if (this.n != j2 || this.o != z) {
            r(j2, z);
        }
    }

    @Override // com.google.android.exoplayer2.source.l
    public void m(g gVar, boolean z, x xVar) {
        this.p = xVar;
        r(this.n, false);
    }

    @Override // com.google.android.exoplayer2.source.l
    public void o() {
    }

    private s(Uri uri, i.a aVar, j jVar, t tVar, String str, int i2, Object obj) {
        this.f6557g = uri;
        this.f6558h = aVar;
        this.f6559i = jVar;
        this.f6560j = tVar;
        this.f6561k = str;
        this.l = i2;
        this.n = -9223372036854775807L;
        this.m = obj;
    }
}
