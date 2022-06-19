package com.bumptech.glide.load.engine;

import android.util.Log;
import b.h.j.e;
import com.bumptech.glide.load.engine.a0.a;
import com.bumptech.glide.load.engine.a0.h;
import com.bumptech.glide.load.engine.h;
import com.bumptech.glide.load.engine.p;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.l;
import com.bumptech.glide.p.g;
import com.bumptech.glide.r.j;
import com.bumptech.glide.r.l.a;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: Engine */
public class k implements m, h.a, p.a {

    /* renamed from: i  reason: collision with root package name */
    private static final boolean f3781i = Log.isLoggable("Engine", 2);

    /* renamed from: a  reason: collision with root package name */
    private final r f3782a;

    /* renamed from: b  reason: collision with root package name */
    private final o f3783b;

    /* renamed from: c  reason: collision with root package name */
    private final h f3784c;

    /* renamed from: d  reason: collision with root package name */
    private final b f3785d;

    /* renamed from: e  reason: collision with root package name */
    private final x f3786e;

    /* renamed from: f  reason: collision with root package name */
    private final c f3787f;

    /* renamed from: g  reason: collision with root package name */
    private final a f3788g;

    /* renamed from: h  reason: collision with root package name */
    private final a f3789h;

    /* access modifiers changed from: package-private */
    /* compiled from: Engine */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        final h.e f3790a;

        /* renamed from: b  reason: collision with root package name */
        final e<h<?>> f3791b = com.bumptech.glide.r.l.a.d(150, new C0095a());

        /* renamed from: c  reason: collision with root package name */
        private int f3792c;

        /* renamed from: com.bumptech.glide.load.engine.k$a$a  reason: collision with other inner class name */
        /* compiled from: Engine */
        class C0095a implements a.d<h<?>> {
            C0095a() {
            }

            /* renamed from: b */
            public h<?> a() {
                a aVar = a.this;
                return new h<>(aVar.f3790a, aVar.f3791b);
            }
        }

        a(h.e eVar) {
            this.f3790a = eVar;
        }

        /* access modifiers changed from: package-private */
        public <R> h<R> a(com.bumptech.glide.d dVar, Object obj, n nVar, f fVar, int i2, int i3, Class<?> cls, Class<R> cls2, com.bumptech.glide.f fVar2, j jVar, Map<Class<?>, l<?>> map, boolean z, boolean z2, boolean z3, com.bumptech.glide.load.h hVar, h.b<R> bVar) {
            h<?> b2 = this.f3791b.b();
            j.d(b2);
            h<R> hVar2 = (h<R>) b2;
            int i4 = this.f3792c;
            this.f3792c = i4 + 1;
            hVar2.n(dVar, obj, nVar, fVar, i2, i3, cls, cls2, fVar2, jVar, map, z, z2, z3, hVar, bVar, i4);
            return hVar2;
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Engine */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        final com.bumptech.glide.load.engine.b0.a f3794a;

        /* renamed from: b  reason: collision with root package name */
        final com.bumptech.glide.load.engine.b0.a f3795b;

        /* renamed from: c  reason: collision with root package name */
        final com.bumptech.glide.load.engine.b0.a f3796c;

        /* renamed from: d  reason: collision with root package name */
        final com.bumptech.glide.load.engine.b0.a f3797d;

        /* renamed from: e  reason: collision with root package name */
        final m f3798e;

        /* renamed from: f  reason: collision with root package name */
        final p.a f3799f;

        /* renamed from: g  reason: collision with root package name */
        final e<l<?>> f3800g = com.bumptech.glide.r.l.a.d(150, new a());

        /* compiled from: Engine */
        class a implements a.d<l<?>> {
            a() {
            }

            /* renamed from: b */
            public l<?> a() {
                b bVar = b.this;
                return new l<>(bVar.f3794a, bVar.f3795b, bVar.f3796c, bVar.f3797d, bVar.f3798e, bVar.f3799f, bVar.f3800g);
            }
        }

        b(com.bumptech.glide.load.engine.b0.a aVar, com.bumptech.glide.load.engine.b0.a aVar2, com.bumptech.glide.load.engine.b0.a aVar3, com.bumptech.glide.load.engine.b0.a aVar4, m mVar, p.a aVar5) {
            this.f3794a = aVar;
            this.f3795b = aVar2;
            this.f3796c = aVar3;
            this.f3797d = aVar4;
            this.f3798e = mVar;
            this.f3799f = aVar5;
        }

        /* access modifiers changed from: package-private */
        public <R> l<R> a(f fVar, boolean z, boolean z2, boolean z3, boolean z4) {
            l<?> b2 = this.f3800g.b();
            j.d(b2);
            l<R> lVar = (l<R>) b2;
            lVar.l(fVar, z, z2, z3, z4);
            return lVar;
        }
    }

    /* compiled from: Engine */
    private static class c implements h.e {

        /* renamed from: a  reason: collision with root package name */
        private final a.AbstractC0090a f3802a;

        /* renamed from: b  reason: collision with root package name */
        private volatile com.bumptech.glide.load.engine.a0.a f3803b;

        c(a.AbstractC0090a aVar) {
            this.f3802a = aVar;
        }

        @Override // com.bumptech.glide.load.engine.h.e
        public com.bumptech.glide.load.engine.a0.a a() {
            if (this.f3803b == null) {
                synchronized (this) {
                    if (this.f3803b == null) {
                        this.f3803b = this.f3802a.a();
                    }
                    if (this.f3803b == null) {
                        this.f3803b = new com.bumptech.glide.load.engine.a0.b();
                    }
                }
            }
            return this.f3803b;
        }
    }

    /* compiled from: Engine */
    public class d {

        /* renamed from: a  reason: collision with root package name */
        private final l<?> f3804a;

        /* renamed from: b  reason: collision with root package name */
        private final g f3805b;

        d(g gVar, l<?> lVar) {
            this.f3805b = gVar;
            this.f3804a = lVar;
        }

        public void a() {
            synchronized (k.this) {
                this.f3804a.r(this.f3805b);
            }
        }
    }

    public k(com.bumptech.glide.load.engine.a0.h hVar, a.AbstractC0090a aVar, com.bumptech.glide.load.engine.b0.a aVar2, com.bumptech.glide.load.engine.b0.a aVar3, com.bumptech.glide.load.engine.b0.a aVar4, com.bumptech.glide.load.engine.b0.a aVar5, boolean z) {
        this(hVar, aVar, aVar2, aVar3, aVar4, aVar5, null, null, null, null, null, null, z);
    }

    private p<?> e(f fVar) {
        u<?> e2 = this.f3784c.e(fVar);
        if (e2 == null) {
            return null;
        }
        if (e2 instanceof p) {
            return (p) e2;
        }
        return new p<>(e2, true, true, fVar, this);
    }

    private p<?> g(f fVar) {
        p<?> e2 = this.f3789h.e(fVar);
        if (e2 != null) {
            e2.a();
        }
        return e2;
    }

    private p<?> h(f fVar) {
        p<?> e2 = e(fVar);
        if (e2 != null) {
            e2.a();
            this.f3789h.a(fVar, e2);
        }
        return e2;
    }

    private p<?> i(n nVar, boolean z, long j2) {
        if (!z) {
            return null;
        }
        p<?> g2 = g(nVar);
        if (g2 != null) {
            if (f3781i) {
                j("Loaded resource from active resources", j2, nVar);
            }
            return g2;
        }
        p<?> h2 = h(nVar);
        if (h2 == null) {
            return null;
        }
        if (f3781i) {
            j("Loaded resource from cache", j2, nVar);
        }
        return h2;
    }

    private static void j(String str, long j2, f fVar) {
        Log.v("Engine", str + " in " + com.bumptech.glide.r.f.a(j2) + "ms, key: " + fVar);
    }

    private <R> d l(com.bumptech.glide.d dVar, Object obj, f fVar, int i2, int i3, Class<?> cls, Class<R> cls2, com.bumptech.glide.f fVar2, j jVar, Map<Class<?>, l<?>> map, boolean z, boolean z2, com.bumptech.glide.load.h hVar, boolean z3, boolean z4, boolean z5, boolean z6, g gVar, Executor executor, n nVar, long j2) {
        l<?> a2 = this.f3782a.a(nVar, z6);
        if (a2 != null) {
            a2.e(gVar, executor);
            if (f3781i) {
                j("Added to existing load", j2, nVar);
            }
            return new d(gVar, a2);
        }
        l<R> a3 = this.f3785d.a(nVar, z3, z4, z5, z6);
        h<R> a4 = this.f3788g.a(dVar, obj, nVar, fVar, i2, i3, cls, cls2, fVar2, jVar, map, z, z2, z6, hVar, a3);
        this.f3782a.c(nVar, a3);
        a3.e(gVar, executor);
        a3.s(a4);
        if (f3781i) {
            j("Started new load", j2, nVar);
        }
        return new d(gVar, a3);
    }

    @Override // com.bumptech.glide.load.engine.a0.h.a
    public void a(u<?> uVar) {
        this.f3786e.a(uVar, true);
    }

    @Override // com.bumptech.glide.load.engine.m
    public synchronized void b(l<?> lVar, f fVar, p<?> pVar) {
        if (pVar != null) {
            if (pVar.f()) {
                this.f3789h.a(fVar, pVar);
            }
        }
        this.f3782a.d(fVar, lVar);
    }

    @Override // com.bumptech.glide.load.engine.m
    public synchronized void c(l<?> lVar, f fVar) {
        this.f3782a.d(fVar, lVar);
    }

    @Override // com.bumptech.glide.load.engine.p.a
    public void d(f fVar, p<?> pVar) {
        this.f3789h.d(fVar);
        if (pVar.f()) {
            this.f3784c.d(fVar, pVar);
        } else {
            this.f3786e.a(pVar, false);
        }
    }

    public <R> d f(com.bumptech.glide.d dVar, Object obj, f fVar, int i2, int i3, Class<?> cls, Class<R> cls2, com.bumptech.glide.f fVar2, j jVar, Map<Class<?>, l<?>> map, boolean z, boolean z2, com.bumptech.glide.load.h hVar, boolean z3, boolean z4, boolean z5, boolean z6, g gVar, Executor executor) {
        long b2 = f3781i ? com.bumptech.glide.r.f.b() : 0;
        n a2 = this.f3783b.a(obj, fVar, i2, i3, map, cls, cls2, hVar);
        synchronized (this) {
            p<?> i4 = i(a2, z3, b2);
            if (i4 == null) {
                return l(dVar, obj, fVar, i2, i3, cls, cls2, fVar2, jVar, map, z, z2, hVar, z3, z4, z5, z6, gVar, executor, a2, b2);
            }
            gVar.b(i4, com.bumptech.glide.load.a.MEMORY_CACHE);
            return null;
        }
    }

    public void k(u<?> uVar) {
        if (uVar instanceof p) {
            ((p) uVar).g();
            return;
        }
        throw new IllegalArgumentException("Cannot release anything but an EngineResource");
    }

    k(com.bumptech.glide.load.engine.a0.h hVar, a.AbstractC0090a aVar, com.bumptech.glide.load.engine.b0.a aVar2, com.bumptech.glide.load.engine.b0.a aVar3, com.bumptech.glide.load.engine.b0.a aVar4, com.bumptech.glide.load.engine.b0.a aVar5, r rVar, o oVar, a aVar6, b bVar, a aVar7, x xVar, boolean z) {
        this.f3784c = hVar;
        c cVar = new c(aVar);
        this.f3787f = cVar;
        a aVar8 = aVar6 == null ? new a(z) : aVar6;
        this.f3789h = aVar8;
        aVar8.f(this);
        this.f3783b = oVar == null ? new o() : oVar;
        this.f3782a = rVar == null ? new r() : rVar;
        this.f3785d = bVar == null ? new b(aVar2, aVar3, aVar4, aVar5, this, this) : bVar;
        this.f3788g = aVar7 == null ? new a(cVar) : aVar7;
        this.f3786e = xVar == null ? new x() : xVar;
        hVar.c(this);
    }
}
