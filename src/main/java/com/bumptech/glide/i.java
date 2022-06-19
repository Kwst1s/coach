package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.bumptech.glide.load.engine.j;
import com.bumptech.glide.m.c;
import com.bumptech.glide.m.d;
import com.bumptech.glide.m.h;
import com.bumptech.glide.m.m;
import com.bumptech.glide.m.n;
import com.bumptech.glide.m.p;
import com.bumptech.glide.p.e;
import com.bumptech.glide.p.f;
import com.bumptech.glide.r.k;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: RequestManager */
public class i implements ComponentCallbacks2, com.bumptech.glide.m.i {
    private static final f n;

    /* renamed from: b  reason: collision with root package name */
    protected final b f3542b;

    /* renamed from: c  reason: collision with root package name */
    protected final Context f3543c;

    /* renamed from: d  reason: collision with root package name */
    final h f3544d;

    /* renamed from: e  reason: collision with root package name */
    private final n f3545e;

    /* renamed from: f  reason: collision with root package name */
    private final m f3546f;

    /* renamed from: g  reason: collision with root package name */
    private final p f3547g;

    /* renamed from: h  reason: collision with root package name */
    private final Runnable f3548h;

    /* renamed from: i  reason: collision with root package name */
    private final Handler f3549i;

    /* renamed from: j  reason: collision with root package name */
    private final c f3550j;

    /* renamed from: k  reason: collision with root package name */
    private final CopyOnWriteArrayList<e<Object>> f3551k;
    private f l;
    private boolean m;

    /* compiled from: RequestManager */
    class a implements Runnable {
        a() {
        }

        public void run() {
            i iVar = i.this;
            iVar.f3544d.a(iVar);
        }
    }

    /* compiled from: RequestManager */
    private class b implements c.a {

        /* renamed from: a  reason: collision with root package name */
        private final n f3553a;

        b(n nVar) {
            this.f3553a = nVar;
        }

        @Override // com.bumptech.glide.m.c.a
        public void a(boolean z) {
            if (z) {
                synchronized (i.this) {
                    this.f3553a.e();
                }
            }
        }
    }

    static {
        f d0 = f.d0(Bitmap.class);
        d0.J();
        n = d0;
        f.d0(com.bumptech.glide.load.o.g.c.class).J();
        f fVar = (f) ((f) f.e0(j.f3779b).Q(f.LOW)).X(true);
    }

    public i(b bVar, h hVar, m mVar, Context context) {
        this(bVar, hVar, mVar, new n(), bVar.g(), context);
    }

    private void B(com.bumptech.glide.p.j.h<?> hVar) {
        boolean A = A(hVar);
        com.bumptech.glide.p.c g2 = hVar.g();
        if (!A && !this.f3542b.p(hVar) && g2 != null) {
            hVar.j(null);
            g2.clear();
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean A(com.bumptech.glide.p.j.h<?> hVar) {
        com.bumptech.glide.p.c g2 = hVar.g();
        if (g2 == null) {
            return true;
        }
        if (!this.f3545e.a(g2)) {
            return false;
        }
        this.f3547g.o(hVar);
        hVar.j(null);
        return true;
    }

    @Override // com.bumptech.glide.m.i
    public synchronized void a() {
        x();
        this.f3547g.a();
    }

    @Override // com.bumptech.glide.m.i
    public synchronized void e() {
        w();
        this.f3547g.e();
    }

    @Override // com.bumptech.glide.m.i
    public synchronized void k() {
        this.f3547g.k();
        for (com.bumptech.glide.p.j.h<?> hVar : this.f3547g.m()) {
            o(hVar);
        }
        this.f3547g.l();
        this.f3545e.b();
        this.f3544d.b(this);
        this.f3544d.b(this.f3550j);
        this.f3549i.removeCallbacks(this.f3548h);
        this.f3542b.s(this);
    }

    public <ResourceType> h<ResourceType> l(Class<ResourceType> cls) {
        return new h<>(this.f3542b, this, cls, this.f3543c);
    }

    public h<Bitmap> m() {
        return l(Bitmap.class).a(n);
    }

    public h<Drawable> n() {
        return l(Drawable.class);
    }

    public void o(com.bumptech.glide.p.j.h<?> hVar) {
        if (hVar != null) {
            B(hVar);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onLowMemory() {
    }

    public void onTrimMemory(int i2) {
        if (i2 == 60 && this.m) {
            v();
        }
    }

    /* access modifiers changed from: package-private */
    public List<e<Object>> p() {
        return this.f3551k;
    }

    /* access modifiers changed from: package-private */
    public synchronized f q() {
        return this.l;
    }

    /* access modifiers changed from: package-private */
    public <T> j<?, T> r(Class<T> cls) {
        return this.f3542b.i().e(cls);
    }

    public h<Drawable> s(Uri uri) {
        h<Drawable> n2 = n();
        n2.q0(uri);
        return n2;
    }

    public h<Drawable> t(String str) {
        h<Drawable> n2 = n();
        n2.s0(str);
        return n2;
    }

    public synchronized String toString() {
        return super.toString() + "{tracker=" + this.f3545e + ", treeNode=" + this.f3546f + "}";
    }

    public synchronized void u() {
        this.f3545e.c();
    }

    public synchronized void v() {
        u();
        for (i iVar : this.f3546f.a()) {
            iVar.u();
        }
    }

    public synchronized void w() {
        this.f3545e.d();
    }

    public synchronized void x() {
        this.f3545e.f();
    }

    /* access modifiers changed from: protected */
    public synchronized void y(f fVar) {
        f fVar2 = (f) fVar.clone();
        fVar2.b();
        this.l = fVar2;
    }

    /* access modifiers changed from: package-private */
    public synchronized void z(com.bumptech.glide.p.j.h<?> hVar, com.bumptech.glide.p.c cVar) {
        this.f3547g.n(hVar);
        this.f3545e.g(cVar);
    }

    i(b bVar, h hVar, m mVar, n nVar, d dVar, Context context) {
        this.f3547g = new p();
        a aVar = new a();
        this.f3548h = aVar;
        Handler handler = new Handler(Looper.getMainLooper());
        this.f3549i = handler;
        this.f3542b = bVar;
        this.f3544d = hVar;
        this.f3546f = mVar;
        this.f3545e = nVar;
        this.f3543c = context;
        c a2 = dVar.a(context.getApplicationContext(), new b(nVar));
        this.f3550j = a2;
        if (k.o()) {
            handler.post(aVar);
        } else {
            hVar.a(this);
        }
        hVar.a(a2);
        this.f3551k = new CopyOnWriteArrayList<>(bVar.i().c());
        y(bVar.i().d());
        bVar.o(this);
    }
}
