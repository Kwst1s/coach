package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.load.engine.f;
import com.bumptech.glide.load.m.d;
import com.bumptech.glide.load.n.n;
import java.util.Collections;
import java.util.List;

/* access modifiers changed from: package-private */
/* compiled from: SourceGenerator */
public class y implements f, f.a {

    /* renamed from: b  reason: collision with root package name */
    private final g<?> f3871b;

    /* renamed from: c  reason: collision with root package name */
    private final f.a f3872c;

    /* renamed from: d  reason: collision with root package name */
    private int f3873d;

    /* renamed from: e  reason: collision with root package name */
    private c f3874e;

    /* renamed from: f  reason: collision with root package name */
    private Object f3875f;

    /* renamed from: g  reason: collision with root package name */
    private volatile n.a<?> f3876g;

    /* renamed from: h  reason: collision with root package name */
    private d f3877h;

    /* access modifiers changed from: package-private */
    /* compiled from: SourceGenerator */
    public class a implements d.a<Object> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ n.a f3878b;

        a(n.a aVar) {
            this.f3878b = aVar;
        }

        @Override // com.bumptech.glide.load.m.d.a
        public void c(Exception exc) {
            if (y.this.g(this.f3878b)) {
                y.this.i(this.f3878b, exc);
            }
        }

        @Override // com.bumptech.glide.load.m.d.a
        public void d(Object obj) {
            if (y.this.g(this.f3878b)) {
                y.this.h(this.f3878b, obj);
            }
        }
    }

    y(g<?> gVar, f.a aVar) {
        this.f3871b = gVar;
        this.f3872c = aVar;
    }

    /* JADX INFO: finally extract failed */
    private void d(Object obj) {
        long b2 = com.bumptech.glide.r.f.b();
        try {
            com.bumptech.glide.load.d<X> p = this.f3871b.p(obj);
            e eVar = new e(p, obj, this.f3871b.k());
            this.f3877h = new d(this.f3876g.f4020a, this.f3871b.o());
            this.f3871b.d().a(this.f3877h, eVar);
            if (Log.isLoggable("SourceGenerator", 2)) {
                Log.v("SourceGenerator", "Finished encoding source to cache, key: " + this.f3877h + ", data: " + obj + ", encoder: " + p + ", duration: " + com.bumptech.glide.r.f.a(b2));
            }
            this.f3876g.f4022c.b();
            this.f3874e = new c(Collections.singletonList(this.f3876g.f4020a), this.f3871b, this);
        } catch (Throwable th) {
            this.f3876g.f4022c.b();
            throw th;
        }
    }

    private boolean f() {
        return this.f3873d < this.f3871b.g().size();
    }

    private void j(n.a<?> aVar) {
        this.f3876g.f4022c.f(this.f3871b.l(), new a(aVar));
    }

    @Override // com.bumptech.glide.load.engine.f.a
    public void a() {
        throw new UnsupportedOperationException();
    }

    @Override // com.bumptech.glide.load.engine.f.a
    public void b(com.bumptech.glide.load.f fVar, Exception exc, d<?> dVar, com.bumptech.glide.load.a aVar) {
        this.f3872c.b(fVar, exc, dVar, this.f3876g.f4022c.e());
    }

    @Override // com.bumptech.glide.load.engine.f.a
    public void c(com.bumptech.glide.load.f fVar, Object obj, d<?> dVar, com.bumptech.glide.load.a aVar, com.bumptech.glide.load.f fVar2) {
        this.f3872c.c(fVar, obj, dVar, this.f3876g.f4022c.e(), fVar);
    }

    @Override // com.bumptech.glide.load.engine.f
    public void cancel() {
        n.a<?> aVar = this.f3876g;
        if (aVar != null) {
            aVar.f4022c.cancel();
        }
    }

    @Override // com.bumptech.glide.load.engine.f
    public boolean e() {
        Object obj = this.f3875f;
        if (obj != null) {
            this.f3875f = null;
            d(obj);
        }
        c cVar = this.f3874e;
        if (cVar != null && cVar.e()) {
            return true;
        }
        this.f3874e = null;
        this.f3876g = null;
        boolean z = false;
        while (!z && f()) {
            List<n.a<?>> g2 = this.f3871b.g();
            int i2 = this.f3873d;
            this.f3873d = i2 + 1;
            this.f3876g = g2.get(i2);
            if (this.f3876g != null && (this.f3871b.e().c(this.f3876g.f4022c.e()) || this.f3871b.t(this.f3876g.f4022c.a()))) {
                j(this.f3876g);
                z = true;
            }
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public boolean g(n.a<?> aVar) {
        n.a<?> aVar2 = this.f3876g;
        return aVar2 != null && aVar2 == aVar;
    }

    /* access modifiers changed from: package-private */
    public void h(n.a<?> aVar, Object obj) {
        j e2 = this.f3871b.e();
        if (obj == null || !e2.c(aVar.f4022c.e())) {
            f.a aVar2 = this.f3872c;
            com.bumptech.glide.load.f fVar = aVar.f4020a;
            d<Data> dVar = aVar.f4022c;
            aVar2.c(fVar, obj, dVar, dVar.e(), this.f3877h);
            return;
        }
        this.f3875f = obj;
        this.f3872c.a();
    }

    /* access modifiers changed from: package-private */
    public void i(n.a<?> aVar, Exception exc) {
        f.a aVar2 = this.f3872c;
        d dVar = this.f3877h;
        d<Data> dVar2 = aVar.f4022c;
        aVar2.b(dVar, exc, dVar2, dVar2.e());
    }
}
